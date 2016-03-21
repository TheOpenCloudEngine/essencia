package org.uengine.essencia.modeling.canvas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.directwebremoting.Browser;
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
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.Practice;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.view.PracticeView;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.modeling.resource.resources.MethodResource;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.modeling.*;

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

                for (int canvasElement = 0; canvasElement < getElementViewList().size(); canvasElement++) {
                    for (int addElements = 0; addElements < practice.getElementList().size(); addElements++) {
                        if (getElementViewList().get(canvasElement).getElement().getClass() == practice.getElementList().get(addElements).getClass()) {
                            if (practice.getElementList().get(addElements).getClass() == Practice.class) {
                                practice.changeRelation(getElementViewList().get(canvasElement), practice.getElementList().get(addElements));
                                practice.getElementList().remove(addElements);
                            } else if (getElementViewList().get(canvasElement).getLabel().equals(practice.getElementList().get(addElements).getName())) {
                                practice.changeRelation(getElementViewList().get(canvasElement), practice.getElementList().get(addElements));
                                String[] temps = practice.getElementList().get(addElements).getElementView().getFromEdge().split(",");
                                for (String tmp : temps) {
                                    for (int k = 0; k < practice.getRelationList().size(); k++) {
                                        if (practice.getRelationList().get(k).getRelationView().getId().equals(tmp)) {
                                            for (ElementView v : getElementViewList()) {
                                                if (v.getToEdge() != null) {
                                                    String[] tempEdges = v.getToEdge().split(",");
                                                    String tempString = "";
                                                    for (String tempEdge : tempEdges) {
                                                        if (tempEdge.equals(practice.getRelationList().get(k).getRelationView().getId())) {
                                                            continue;
                                                        }
                                                        if ("".equals(tempString)) {
                                                            tempString = tempEdge;
                                                        } else {
                                                            tempString += "," + tempEdge;
                                                        }
                                                    }
                                                    v.setToEdge(tempString);
                                                }
                                            }
                                            practice.getRelationList().remove(k);
                                        }
                                    }
                                }
                                practice.getElementList().remove(addElements);
                            }
                        }
                    }
                }
                getElementViewList().addAll(ElementUtil.convertToElementViewList(practice.getElementList()));
                getRelationViewList().addAll(ElementUtil.convertToRelationViewList(practice.getRelationList()));

                autoRelocationFromPractice(getElementViewList());

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

        for (ElementView elementVeiw : list) {
            if (elementVeiw instanceof PracticeView) {
                elementVeiw.setX(96);
                elementVeiw.setY(96);
                if (elementVeiw.getToEdge() != null) {
                    String[] toEdges = elementVeiw.getToEdge().split(",");
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

    private ElementView findDuplicatedParentElement(List<BasicElement> parentElements) {
        for (BasicElement parentElement : parentElements) {
            for (ElementView elementView : getElementViewList()) {
                if (parentElement.getName().equals(elementView.getLabel()) && parentElement.getElementView().getClass() == elementView.getClass() || (parentElement.getElementView().getClass() == PracticeView.class && elementView.getClass() == PracticeView.class)) {
                    return elementView;
                }
            }
        }
        return null;
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
