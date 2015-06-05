package org.uengine.essencia.model;

import java.io.File;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.enactment.EssenceActivity;
import org.uengine.essencia.model.adapter.EssenceXmiAPI;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.kernel.*;
import org.uengine.kernel.view.HumanActivityView;
import org.uengine.modeling.*;

public class PracticeDefinition implements Serializable, IModel, ContextAware {

    private static final long serialVersionUID = GlobalContext.SERIALIZATION_UID;

    private transient MetaworksContext metaworksContext;
    private String id;
    private TextContext name;
    private String description;
    private List<IElement> elementList;
    private List<IRelation> relationList;

    public PracticeDefinition() {
        ContextUtil.setWhen(this, EssenciaContext.WHEN_EDIT);
    }

    @Override
    public MetaworksContext getMetaworksContext() {
        return metaworksContext;
    }

    @Override
    public void setMetaworksContext(MetaworksContext metaworksContext) {
        this.metaworksContext = metaworksContext;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        if (this.getName() == null) {
            return null;
        }
        return this.getName().getText();
    }

    public TextContext getName() {
        return name;
    }

    public void setName(TextContext name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IElement> getElementList() {
        if (elementList == null) {
            setElementList(new ArrayList<IElement>());
        }
        return elementList;
    }

    public void setElementList(List<IElement> iElementList) {
        this.elementList = iElementList;
    }

    public void addElement(IElement iElementList) {
        if (getElementList() == null) {
            setElementList(new ArrayList<IElement>());
        }
        this.getElementList().add(iElementList);
    }

    public List<IRelation> getRelationList() {
        if (this.relationList == null) {
            this.setRelationList(new ArrayList<IRelation>());
        }
        return relationList;
    }

    public void setRelationList(List<IRelation> relationList) {
        this.relationList = relationList;
    }

    public void addRelationList(IRelation relation) {
        if (getRelationList() == null) {
            setRelationList(new ArrayList<IRelation>());
        }
        this.getRelationList().add(relation);
    }

    /**
     * get practice definition name from practice element
     *
     * @return practice element's name
     */
    public String getPracticeName() {
        String practiceName = "";
        for (IElement e : getElementList()) {
            if (e instanceof Practice) {
                practiceName = e.getName();
                break;
            }
        }
        return practiceName;
    }

    /**
     * count activities which has same competency
     *
     * @param competencyName
     * @return count of result
     */
    public int cntSameRoleActivities(String competencyName) {
        int result = 0;

        for (IElement element : this.getElementList()) {
            if (element instanceof Activity && competencyName.equals(((Activity) element).getCompetencyName())) {
                result++;
            }
        }

        return result;
    }

    /**
     * this method make this practice definition convert to uEngine's Process Definition
     *
     * @return ProcessDefinition ( from uengine-core module )
     * @throws Exception
     */
    public ProcessDefinition toProcessDefinition() {
        ProcessDefinition returnProcessDefinition = new ProcessDefinition();
        returnProcessDefinition.setName(getName());
        List<Role> roleList = new ArrayList<>();
        List<ProcessVariable> pvList = new ArrayList<>();

        Role role = null;
        ElementView roleView = null;
        int laneCnt = 0;
        ElementView humanView = null;
        for (IElement element : getElements(Activity.class)) {

            Competency competency = getElement(((Activity) element).getCompetencyName(), Competency.class);

            if (!roleList.contains(competency)) {
                role = Role.forName(competency.getName());
                role.setDisplayName(role.getName());
                roleView = role.createView();

                roleView.setWidth(calculateLaneWidth(competency.getName()) + 40 + 192);
                roleView.setHeight("128");
                roleView.setX(48 + Integer.valueOf(roleView.getWidth()) / 2);
                roleView.setY(40 + Integer.valueOf(roleView.getHeight()) / 2 + laneCnt * Integer.valueOf(roleView.getHeight()));
                roleView.setShapeId("OG.shape.HorizontalLaneShape");
                roleView.setLabel(role.getName());

                role.setElementView(roleView);
                roleList.add(role);

                laneCnt++;
            }

            //make essence activity
            EssenceActivity essenceActivity = new EssenceActivity((Activity) element);
            humanView = essenceActivity.createView();

            essenceActivity.setName(element.getName());

            humanView.setLabel(element.getName());
            humanView.setShapeId(HumanActivityView.SHAPE_ID_BPMN);
            humanView.setHeight("96");
            humanView.setWidth("96");

            int laneX = Integer.valueOf(roleView.getX());
            int laneHalfWidth = Integer.valueOf(roleView.getWidth()) / 2;
            int prevActivitiesCnt = prevActivitiesCntWithSameCompetency(returnProcessDefinition.getChildActivities(), competency);
            int humanX = Integer.valueOf(humanView.getWidth()) * prevActivitiesCnt;

            int rst = laneX - laneHalfWidth + humanX;
            rst = rst + 64 * prevActivitiesCnt;

            humanView.setX(rst);
            humanView.setY(roleView.getY());

            essenceActivity.setTool(makeTool(element));

            essenceActivity.setElementView(humanView);

            returnProcessDefinition.addChildActivity(essenceActivity);

        }

        Role[] roleArray = {};
        roleArray = roleList.toArray(roleArray);
        returnProcessDefinition.setRoles(roleArray);


        // these are make the recursive error in dwr
        ProcessVariable pv = null;
        for (Alpha alpha : getElements(Alpha.class)) {
            pv = new ProcessVariable(new Object[]{
                    "name", alpha.getName(),
                    "type", AlphaInstance.class
            });
            pvList.add(pv);
        }

        for (WorkProduct workProduct : getElements(WorkProduct.class)) {
//            LanguageElementInstance defaultWorkProduct = workProduct.createInstance("<id>");
            pv = new ProcessVariable(new Object[]{
                    "name", workProduct.getName(),
                    "type", LanguageElementInstance.class
//                    ,"defaultValue", (Serializable)defaultWorkProduct
            });
//              pv.setDefaultValue(defaultWorkProduct);
            pvList.add(pv);
        }

        ProcessVariable[] pvArray = {};
        pvArray = pvList.toArray(pvArray);
        returnProcessDefinition.setProcessVariables(pvArray);


        return returnProcessDefinition;
    }

//    private void deployProcessDefinition() throws Exception {
//        final String  url = "/app/essencia/tenant/uengine/upload";
//        File file = null;
//        try {
//            CloseableHttpClient httpclient = HttpClients.createDefault();
//            HttpPost post = new HttpPost(url);
//            FileBody fileBody = new FileBody(file);
////            String message = "file";
//
//            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
//            builder.addPart("upfile", fileBody);
////            builder.addTextBody("text", message, ContentType.TEXT_PLAIN);
//
//            HttpEntity entity = builder.build();
//            post.setEntity(entity);
//            HttpResponse response = httpclient.execute(post);
//            if (response != null) {
//                System.out.println(response.getStatusLine().getStatusCode());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }


    /**
     * make url for restful service
     * ex ) http://localhost:8080/essencia/CardService.jsp?className=org.uengine.essencia.CardTest&practiceName=ScrumUPMethod&elementName=Design_the_program&type=method
     *
     * @param element
     * @return url
     */
    private String makeTool(IElement element) {
        StringBuilder url = new StringBuilder("http://");
        try {
            url.append(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        url.append(":");
        url.append(GlobalContext.getPropertyString("port", "9999"));
        url.append("/essencia/CardService.jsp?className=org.uengine.essencia.Activity");
        url.append("&practiceName=" + getPracticeName());
        url.append("&elementName=" + element.getName());
        url.append("&type=" + "method");
        return url.toString();
    }

    /**
     * calculate the lane width with count of activities which have same role
     *
     * @param roleName
     * @return default width
     */
    private int calculateLaneWidth(String roleName) {
        int cntSameRoleActivities = cntSameRoleActivities(roleName);
        return cntSameRoleActivities * 96;
    }

    private int prevActivitiesCntWithSameCompetency(List<org.uengine.kernel.Activity> list, Competency c) {
        int cnt = 1;
        for (org.uengine.kernel.Activity activity : list) {
            if (activity instanceof EssenceActivity && ((EssenceActivity) activity).getActivityInEssenceDefinition().getCompetencyName().equals(c.getName())) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * find element by name
     * condition : every element has unique name
     *
     * @param name
     * @return element
     */
    public IElement getElementByName(String name) {
        if ("".equals(name)) {
            throw new NullPointerException();
        }
        IElement languageElement = null;
        for (IElement e : getElementList()) {
            if (name.equals(e.getName())) {
                languageElement = e;
                break;
            }
        }
        return languageElement;
    }

    /**
     * 1. find clazz
     * 2. find elementName
     * even if, some elements have same name with different type these algorithm is safe
     *
     * @param elementName
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends IElement> T getElement(String elementName, Class<T> clazz) {
        if (elementName == null || "".equals(elementName.trim())) {
            throw new IllegalArgumentException("elementName argument is not fit");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("clazz argument can not be null");
        }
        List<T> clazzList = getElements(clazz);
        for (T t : clazzList) {
            if (elementName.equals(t.getName())) {
                return (T) t;
            }
        }
        return null;
    }

    /*
     * Get essence element with from edge.
     */
    public IElement getElementWithFromEdge(String fromEdge) {
        IElement element = null;

        for (IElement e : getElementList()) {
            if (fromEdge.equals(e.getElementView().getFromEdge())) {
                element = e;
                break;
            }
        }
        return element;
    }

    /**
     * return the clazz type elements
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> getElements(Class<T> clazz) {
        if (clazz == null) {
            throw new IllegalArgumentException("clazz argument can not be null");
        }
        List<T> elementList = new ArrayList<T>();
        for (IElement e : getElementList()) {
            if (clazz.isInstance(e)) {
                elementList.add((T) e);
            }
        }
        return elementList;
    }

    /**
     * get element by element view's id ( opengraph id )
     * @param id
     * @return
     */
    public IElement pickElementByViewId(String id) {
        IElement element = null;
        for (IElement e : getElementList()) {
            String[] stringArrays = id.split("_");
            String temp = stringArrays[0] + "_" + stringArrays[1] + "_" + stringArrays[2];
            if (temp.equals(e.getElementView().getId())) {
                element = e;
                break;
            }
        }
        return element;
    }


    public List<BasicElement> findParentElements(ElementView view) {
        List<BasicElement> returnElementList = new ArrayList<BasicElement>();

        if (view.getFromEdge() != null) {
            String[] fromEdges = view.getFromEdge().split(",");
            for (IElement element : getElementList()) {
                if (element.getElementView().getToEdge() != null) {

                    String[] toEdges = element.getElementView().getToEdge().split(",");
                    for (String toEdge : toEdges) {
                        for (String fromEdge : fromEdges) {
                            if (toEdge.equals(fromEdge)) {
                                returnElementList.add((BasicElement) element);
                                findParentElements(element.getElementView());
                            }
                        }
                    }
                }
            }
        }
        return returnElementList;
    }

    public IRelation findFromRelation(ElementView view) {
        IRelation returnRelation = null;
        for (IRelation relation : getRelationList()) {
            for (String edge : view.getFromEdge().split(",")) {
                if (relation.getRelationView().getId().equals(edge)) {
                    returnRelation = relation;
                }
            }
        }
        return returnRelation;
    }

    public List<IRelation> findFromRelations(ElementView view) {
        List<IRelation> returnRelations = new ArrayList<IRelation>();
        if (view.getFromEdge() != null) {
            for (String edge : view.getFromEdge().split(",")) {
                for (IRelation relation : getRelationList()) {
                    if (relation.getRelationView().getId().equals(edge)) {
                        returnRelations.add(relation);
                    }
                }
            }
        }
        return returnRelations;

    }

    public List<IRelation> findToRelation(ElementView view) {
        List<IRelation> returnRelations = new ArrayList<IRelation>();
        if (view.getToEdge() != null) {
            for (String edge : view.getToEdge().split(",")) {
                for (IRelation relation : getRelationList()) {
                    if (relation.getRelationView().getId().equals(edge)) {
                        returnRelations.add(relation);
                    }
                }
            }
        }
        return returnRelations;
    }

    public List<IElement> findChildElements(ElementView view) {
        List<IElement> elementList = new ArrayList<IElement>();
        if (view.getToEdge() != null) {
            String[] toEdges = view.getToEdge().split(",");
            for (ElementView elementView : ElementUtil.convertToElementViewList(getElementList())) {
                for (String edge : toEdges) {
                    if (elementView.getFromEdge() != null) {
                        for (String fromEdge : elementView.getFromEdge().split(",")) {
                            if (edge.equals(fromEdge)) {
                                elementList.add(elementView.asElement());
                            }
                        }
                    }
                }
            }
        }
        return elementList;
    }

    public void changeRelation(ElementView newTarget, IElement target) {
        if (target.getElementView().getToEdge() != null) {
            String[] edges = target.getElementView().getToEdge().split(",");
            for (String edge : edges) {
                for (IRelation relation : getRelationList()) {
                    if (relation.getRelationView().getId().equals(edge)) {

                        relation.getRelationView().setFromWithTerminal(newTarget.getId());
                        newTarget.addToEdge(relation.getRelationView().getId());
                    }
                }
            }
        }
    }

    public void toXmi() {
        EssenceXmiAPI essenceXmiAPI = new EssenceXmiAPI(this);
        essenceXmiAPI.toXmi();
    }

    public void afterDeserialize() {
        addActivityToActivitySpace();
        addCheckpointToState();
    }

    private void addActivityToActivitySpace() {
        for (ActivitySpace activitySpace : getElements(ActivitySpace.class)) {
            activitySpace.addActivity(this);
        }
    }

    private void addCheckpointToState() {
        List<Activity> activityList = this.getElements(Activity.class);
        for (Activity activity : activityList) {
            if (activity.getCompletionCriteria() != null) {
                for (LanguageElement e : activity.getCompletionCriteria()) {
                    Criterion criterion = (Criterion) e;
                    State state = criterion.getState();
                    State fullState = getState(criterion.getState().getParentAlpha().getName(), state.getName());
                    if (fullState != null) {
                        state.setListFace(fullState.getListFace());
                    }
                }
            }
        }
    }

    public State getState(String alphaName, String stateName) {
        List<Alpha> alphaList = this.getElements(Alpha.class);
        for (Alpha alpha : alphaList) {
            if (alpha.getName().equals(alphaName)) {
                for (State state : alpha.getList()) {
                    if (state.getName().equals(stateName))
                        return state;
                }
            }
        }
        return null;
    }

    public void beforeSerialize() {

    }

}