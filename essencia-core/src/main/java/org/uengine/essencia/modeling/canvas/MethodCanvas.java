package org.uengine.essencia.modeling.canvas;

import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;
import org.metaworks.MetaworksContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToAppend;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.mw3.Login;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.model.Practice;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.view.PracticeView;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.*;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.modeling.resource.resources.MethodResource;

import java.util.*;

import static org.metaworks.dwr.MetaworksRemoteService.wrapReturn;

public class MethodCanvas extends EssenciaCanvas {
    @AutowiredFromClient
    public Session session;

    public MethodCanvas() {
        initPracticeView();
    }

    public MethodCanvas(String modelerType) {
        super(modelerType);
    }

    public Object symbolContent;

    public Object getSymbolContent() {
        return symbolContent;
    }

    public void setSymbolContent(Object symbolContent) {
        this.symbolContent = symbolContent;
    }

    @Available(when = {MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
    @ServiceMethod(payload = {"symbolContent", "clipboard", "modelerType", "elementViewList", "relationViewList"}, target = ServiceMethodContext.TARGET_APPEND, eventBinding = CANVAS_DROP)
    @Override
    /**
     * Practice Merge
     */
    public void drop() {
        ElementView elementView = null;

        Object[] returnArr = initReturnArr();

        Object content = null;
        if (clipboard == null || clipboard.getId() == null) {
            content = this.getSymbolContent();
        } else if (clipboard.getId().equals(CANVAS_DROP)) {
            content = this.getSymbolContent();
        } else {
            content = clipboard.getContent();
        }

        if (content instanceof EssenciaKernelSymbol) {

            elementView = makeElementViewFromEssenciaKernelSymbol((EssenciaKernelSymbol) content);

            try {
                if (validate(elementView)) {
                    returnArr[1] = new ToAppend(ServiceMethodContext.TARGET_SELF, elementView);
                }

            } catch (RuntimeException e) {
                e.printStackTrace();
                throw e;
            }

            wrapReturn(returnArr);
        } else if (content instanceof Symbol) {
            Symbol symbol = (Symbol) content;


            if ("EDGE".equals(symbol.getShapeType())) {
                RelationView relationView = makeRelationViewFromSymbol((Symbol) content);

                returnArr[1] = new ToAppend(ServiceMethodContext.TARGET_SELF, relationView);
                wrapReturn(returnArr);
            } else {
                elementView = makeElementViewFromSymbol((Symbol) content);

                returnArr[1] = new ToAppend(ServiceMethodContext.TARGET_SELF, elementView);

                if (false) {  //turn on if you want to use broadcasting changes

                    MethodCanvas lightMe = new MethodCanvas();
                    lightMe.setModelerType(getModelerType());

                    MetaworksRemoteService.pushClientObjectsFiltered(new ScriptSessionFilter() {
                        @Override
                        public boolean match(ScriptSession scriptSession) {
                            return !(session != null && scriptSession.getId().equals(Login.getSessionIdWithUserId(session.getUser().getUserId())));

                        }
                    }, new Object[]{new ToAppend(lightMe, elementView)});
                }

                wrapReturn(returnArr);

                return;
            }


        } else if (content instanceof MethodResource) {

            PracticeDefinition practice = null;

            try {
                ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);

//                practice = (PracticeDefinition) ObjectRepository.getInstance().get(((PracticeResource) content).getPath());

                EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) resourceManager.getStorage().getObject((MethodResource) content);

                practice = essenceProcessDefinition.getPracticeDefinition();

                reissueId(practice);

                // find dropped kernel Element
                ElementView practiceRootElementView = findPracticeRootElement(practice.getElementList());
                String[] practiceRootElementViewsToEdges = findToEdge(practiceRootElementView);

                ElementView canvasRootElementView = findCanvasRootElement(getElementViewList());

                // custom duplicate element
                HashMap<IElement, ElementView> duplicateElementList = findAndCustomDuplicateElement(practiceRootElementViewsToEdges, practice.getElementList());
                List<ElementView> duplicateChildElementList = findAndCustomDuplicateChildElement(duplicateElementList, practice.getElementList(), practice.getRelationList());

                // remove practice duplicate element list
                List<IElement> removeElementList = findDuplicateElement(duplicateElementList);
                removeElementList.add(practice.getElementList().get(0));
                practice.getElementList().removeAll(removeElementList);
                // add duplicate elements child
                getElementViewList().addAll(duplicateChildElementList);

                // reconnect not duplicate practice kernel element
                customNotDuplicatePracticeElement(canvasRootElementView, practiceRootElementView, practice);
                // add element list and relation list
                getElementViewList().addAll(convertIElementListToElementViewList(practice.getElementList()));
                getRelationViewList().addAll(convertIRelationListToRelationViewList(practice.getRelationList()));

                // sort
                sortCanvasElementViewList(getElementViewList());

                // replace
                replaceElement(findToEdge(canvasRootElementView));

                for(RelationView relationView : getRelationViewList()) {
                    relationView.setNeedReconnect(true);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
            getMetaworksContext().setWhen(EssenciaContext.WHEN_EDIT);
            returnArr[1] = new Refresh(this);
            wrapReturn(returnArr);
        }

        wrapReturn(returnArr);
    }

    private void autoRelocationFromPractice(List<ElementView> list) {

        for (ElementView elementView : list) {
            if (elementView instanceof PracticeView) {
                elementView.setX(96);
                elementView.setY(96);
                if (elementView.getToEdge() != null) {
                    String[] toEdges = elementView.getToEdge().split(",");
                    firstLevel = Arrays.asList(toEdges);
                    autoRelocateByRelation(toEdges, list);
                }
            }
        }
    }

    List<String> firstLevel = null;
    double x = 96;
    double y = 96;

    private void autoRelocateByRelation(String[] edges, List<ElementView> list) {
        for (int i = 0; i < edges.length; i++) {
            for (ElementView view : list) {
                if (edges[i].equals(view.getFromEdge())) {
                    if (firstLevel.contains(edges[i])) {
                        x = 96 + 64 + Math.round((view.getWidth()));
                        if (i > 0) {
                            y = y + 32 + Math.round((view.getHeight()));
                        }
                    } else if (i == 0) {
                        x = x + 64 + Math.round((view.getWidth()));
                    } else {
                        y = y + 32 + Math.round((view.getHeight()));
                    }
                    view.setX(x);
                    view.setY(y);
                    if (view.getToEdge() != null) {
                        String[] toEdges = view.getToEdge().split(",");
                        autoRelocateByRelation(toEdges, list);
                    }
                }
            }
        }
    }

    private ElementView findCanvasRootElement(List<ElementView> canvasElementViewList) {
        ElementView canvasRootElementView = null;
        // find definition kernel elementView
        for(ElementView elementView : canvasElementViewList) {
            if(elementView instanceof PracticeView) {
                canvasRootElementView = elementView;
                break;
            }
        }
        return canvasRootElementView;
    }

    private ElementView findPracticeRootElement(List<IElement> practiceElementList) {
        ElementView practiceRootElementView = null;
        // find definition root elementView
        for(IElement element : practiceElementList) {
            if(element instanceof Practice) {
                practiceRootElementView = element.getElementView();
                break;
            }
        }
        return practiceRootElementView;
    }

    private HashMap<IElement, ElementView> findAndCustomDuplicateElement(String[] practiceToEdges, List<IElement> practiceElementList) {
        HashMap<IElement, ElementView> duplicatePracticeElementList = new HashMap<>();

        List<IElement> practiceKernelElementViewList = findPracticeChildElementViewList(practiceToEdges, practiceElementList);
        for (IElement practiceKernelElement : practiceKernelElementViewList) {
            for (ElementView elementView : getElementViewList()) {
                // search duplicated object
                if (elementView.getLabel().equals(practiceKernelElement.getElementView().getLabel())) {
                    // add practiceElement toEdge to canvasElement
                    elementView.setToEdge(elementView.getToEdge() + "," + practiceKernelElement.getElementView().getToEdge());
                    duplicatePracticeElementList.put(practiceKernelElement, elementView);
                }
            }
        }
        return duplicatePracticeElementList;
    }

    private List<ElementView> findAndCustomDuplicateChildElement(HashMap<IElement, ElementView> duplicateElement, List<IElement> practiceElementList, List<IRelation> practiceRelationList) {
        List<ElementView> duplicateChildElementList = new ArrayList<>();
        // canvasElement add duplicated practiceElement's child
        for(Map.Entry<IElement, ElementView> entry : duplicateElement.entrySet()) {
            IElement element = entry.getKey();
            ElementView elementView = entry.getValue();

            String[] elementToEdges = findToEdge(element.getElementView());
            List<IElement> duplicatePracticeChildElementViewList = findPracticeChildElementViewList(elementToEdges, practiceElementList);
            List<IRelation> elementRelationList = findPracticeRelation(elementToEdges, practiceRelationList);

            String[] elementViewToEdges = findToEdge(elementView);
            List<ElementView> duplicateCanvasChildElementViewList = findCanvasChildElementViewList(elementViewToEdges);

            for(IElement childElement : duplicatePracticeChildElementViewList) {
                for(IRelation relation : elementRelationList) {
                    if(childElement.getElementView().getFromEdge().contains(relation.getRelationView().getId()) &&
                            elementView.getToEdge().contains(relation.getRelationView().getId())) {

                        // reconnect canvas element to duplicate practice child element
                        reConnectRelation(relation, elementView);
                    }
                }
                // child set x
                childElement.getElementView().setX(duplicateCanvasChildElementViewList.get(0).getX());
                // child set y
                childElement.getElementView().setY(duplicateCanvasChildElementViewList.get(duplicateCanvasChildElementViewList.size() - 1).getY() + 92);
                duplicateChildElementList.add(childElement.getElementView());
            }
        }
        return duplicateChildElementList;
    }

    private void customNotDuplicatePracticeElement(ElementView canvasRootElementView, ElementView practiceRootElementView, PracticeDefinition practice) {
        canvasRootElementView.setToEdge(canvasRootElementView.getToEdge() + "," + practiceRootElementView.getToEdge());

        String[] practiceRootElementViewsToEdges = findToEdge(practiceRootElementView);
        List<IElement> practiceKernelElementList = findPracticeChildElementViewList(practiceRootElementViewsToEdges, practice.getElementList());
        List<IRelation> elementRelationList = findPracticeRelation(practiceRootElementViewsToEdges, practice.getRelationList());

        // practice kernel fromEdge change canvas's root
        for(IElement element : practiceKernelElementList) {
            for(IRelation relation : elementRelationList) {
                if(element.getElementView().getFromEdge().contains(relation.getRelationView().getId()) &&
                        canvasRootElementView.getToEdge().contains(relation.getRelationView().getId())) {

                    reConnectRelation(relation, canvasRootElementView);
                }
            }
            element.getElementView().setX(getElementViewList().get(1).getX());
            element.getElementView().setY(getElementViewList().get(getElementViewList().size() - 1).getY());
        }
    }

    private List<IRelation> findPracticeRelation(String[] childElementFromEdges, List<IRelation> practiceRelationList) {
        List<IRelation> relationList = new ArrayList<>();
        for(String fromEdges : childElementFromEdges) {
            for(IRelation relation : practiceRelationList) {
                if(relation.getRelationView().getId().contains(fromEdges)) {
                    relationList.add(relation);
                }
            }
        }
        return relationList;
    }

    private List<IElement> findDuplicateElement(HashMap<IElement, ElementView> duplicateElement) {
        List<IElement> duplicatePracticeElementList = new ArrayList<>();
        for(Map.Entry<IElement, ElementView> entry : duplicateElement.entrySet()) {
            duplicatePracticeElementList.add(entry.getKey());
        }
        return duplicatePracticeElementList;
    }

    private void replaceElement(String[] kernelToEdges) {
        List<ElementView> canvasKernelElementViewList = findCanvasChildElementViewList(kernelToEdges);

        for(ElementView elementView : canvasKernelElementViewList) {
            // find kernel's child
            String[] childToEdges = findToEdge(elementView);
            List<ElementView> canvasChildElementViewList = findCanvasChildElementViewList(childToEdges);

            int currentIndex = canvasKernelElementViewList.indexOf(elementView);
            if(canvasKernelElementViewList.indexOf(elementView) == 0) {
                elementView.setY(canvasChildElementViewList.get(canvasChildElementViewList.size() - 1).getY());

            } else {
                // replace child element
                replaceKernelChildElement(canvasKernelElementViewList.get(currentIndex - 1), canvasChildElementViewList);
                elementView.setY(canvasChildElementViewList.get(0).getY());
            }
        }
    }

    private void replaceKernelChildElement(ElementView beforeElementView, List<ElementView> childElementViewList) {
        String[] beforeChildToEdges = findToEdge(beforeElementView);
        List<ElementView> canvasBeforeChildElementViewList = findCanvasChildElementViewList(beforeChildToEdges);

        double beforeChildElementViewListLastY = canvasBeforeChildElementViewList.get(canvasBeforeChildElementViewList.size() - 1).getY();
        if(beforeChildElementViewListLastY >= childElementViewList.get(0).getY()) {
            for(ElementView childElementView : childElementViewList) {
                int currentIndex = childElementViewList.indexOf(childElementView);
                childElementView.setY(beforeChildElementViewListLastY + (92 * (currentIndex + 1)));
            }
        }
    }

    private String[] findToEdge(ElementView elementView) {
        if(elementView.getToEdge() != null && elementView.getToEdge().length() > 0) {
            return elementView.getToEdge().split(",");

        } else {
            return new String[0];
        }
    }

    private List<ElementView> findCanvasChildElementViewList(String[] toEdges) {
        List<ElementView> canvasChildElementViewList = new ArrayList<>();
        for(String toEdge : toEdges) {
            for(ElementView elementView : getElementViewList()) {
                if(elementView.getFromEdge() != null && elementView.getFromEdge().contains(toEdge)) {
                    canvasChildElementViewList.add(elementView);
                }
            }
        }
        return canvasChildElementViewList;
    }

    private List<ElementView> sortCanvasElementViewList(List<ElementView> elementViewList) {
        // element sorting
        Collections.sort(elementViewList, new Comparator<ElementView>() {
            @Override
            public int compare(ElementView before, ElementView after) {
            return Double.compare(before.getY(), after.getY());
            }
        });
        return elementViewList;
    }

    private List<IElement> findPracticeChildElementViewList(String[] toEdges, List<IElement> practiceElementList) {
        List<IElement> practiceChildElementViewList = new ArrayList<>();
        for(String toEdge : toEdges) {
            for(IElement element : practiceElementList) {
                if(element.getElementView().getFromEdge() != null && element.getElementView().getFromEdge().contains(toEdge)) {
                    practiceChildElementViewList.add(element);
                }
            }
        }
        return practiceChildElementViewList;
    }

    private List<ElementView> convertIElementListToElementViewList(List<IElement> practiceElementList) {
        List<ElementView> elementViewList = new ArrayList<>();
        for(IElement element : practiceElementList) {
            elementViewList.add(element.getElementView());
        }
        return elementViewList;
    }

    private List<RelationView> convertIRelationListToRelationViewList(List<IRelation> practiceRelationList) {
        List<RelationView> relationViewList = new ArrayList<>();
        for(IRelation relation : practiceRelationList) {
            relationViewList.add(relation.getRelationView());
        }
        return relationViewList;
    }

    private void reConnectRelation(IRelation relation, ElementView elementView) {
        relation.getRelationView().setFrom(elementView.getId() + relation.getRelationView().TERMINAL_IN_OUT);
        // add relation
        getRelationViewList().add(relation.getRelationView());
    }

    private String createId() {
        StringBuffer sb = new StringBuffer("OG_");
        sb.append(findCanvasId());
        sb.append("_");
        sb.append(findHighestElementId());

        return sb.toString();
    }

    private String findCanvasId() {
        String canvasId = "";
        for (ElementView view : getSafeElementViewList()) {
            if (view instanceof PracticeView) {
                canvasId = view.getId().split("_")[1];
            }
        }
        return canvasId;
    }

    int highestId = 0;

    private String findHighestElementId() {
        for (ElementView view : getSafeElementViewList()) {
            if (highestId < Integer.valueOf(view.getId().split("_")[2])) {
                highestId = Integer.valueOf(view.getId().split("_")[2]);
            }
        }
        for (RelationView view : getSafeRelationViewList()) {
            if (highestId < Integer.valueOf(view.getId().split("_")[2])) {
                highestId = Integer.valueOf(view.getId().split("_")[2]);
            }
        }
        ++highestId;
        return String.valueOf(highestId);
    }

    private void reissueId(PracticeDefinition p) {
        String oldId = "";
        String newId = "";
        for (IElement e : p.getElementList()) {

            oldId = e.getElementView().getId();
            newId = createId();

            e.getElementView().setId(newId);

            List<IRelation> fromRelations = p.findFromRelations(e.getElementView());
            if (fromRelations != null) {
                for (IRelation r : fromRelations) {
                    r.getRelationView().setTo(r.getRelationView().getTo().replace(oldId, newId));
                }
            }


            List<IRelation> toRelations = p.findToRelation(e.getElementView());
            if (toRelations.size() > 0) {
                for (IRelation r : toRelations) {
                    r.getRelationView().setFrom(r.getRelationView().getFrom().replace(oldId, newId));
                }
            }
        }
        for (IRelation r : p.getRelationList()) {
            oldId = r.getRelationView().getId();
            newId = createId();
            r.getRelationView().setId(newId);

            IElement to = p.pickElementByViewId(r.getRelationView().getTo());
            if (to != null) {
                to.getElementView().setFromEdge(to.getElementView().getFromEdge().replace(oldId, newId));
            }

            IElement from = p.pickElementByViewId(r.getRelationView().getFrom());
            if (from != null) {
                from.getElementView().setToEdge(from.getElementView().getToEdge().replace(oldId, newId));
            }
        }

    }


    boolean joinEditing;

    public boolean isJoinEditing() {
        return joinEditing;
    }

    public void setJoinEditing(boolean joinEditing) {
        this.joinEditing = joinEditing;
    }

    String resourcePath;

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    String remoteUserName;

    public String getRemoteUserName() {
        return remoteUserName;
    }

    public void setRemoteUserName(String remoteUserName) {
        this.remoteUserName = remoteUserName;
    }

    String remoteUserKey;

    public String getRemoteUserKey() {
        return remoteUserKey;
    }

    public void setRemoteUserKey(String remoteUserKey) {
        this.remoteUserKey = remoteUserKey;
    }

    @ServiceMethod(callByContent = true)
    public void sendChanges() {
        for (ArrayList<String> sessionsForThisCanvas : MethodResource.sessions.values()) {
            //Browser.withAllSessions();
        }
    }
}
