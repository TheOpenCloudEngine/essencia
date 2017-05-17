package org.uengine.essencia.model;

import java.beans.Transient;
import java.io.File;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.EssenceActivity;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.adapter.XMIAdapter;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.essencia.util.ElementUtil;
import org.uengine.kernel.*;
import org.uengine.kernel.view.HumanActivityView;
import org.uengine.modeling.*;
import org.uengine.util.ActivityFor;

public class PracticeDefinition implements Serializable, IModel, ContextAware, NeedArrangementToSerialize {

    private static final long serialVersionUID = GlobalContext.SERIALIZATION_UID;

    private transient MetaworksContext metaworksContext;
    private String id;
    private TextContext name;
    private String description;
    private List<IElement> elementList;
    private List<IRelation> relationList;
    private String baseKernel;

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
            if (element instanceof Activity && competencyName.equals(((Activity) element).getCompetency().getName())) {
                result++;
            }
        }

        return result;
    }


    public ProcessDefinition toProcessDefinition() {

        return toProcessDefinition(null);
    }

        /**
         * this method make this practice definition convert to uEngine's Process Definition
         *
         * @return ProcessDefinition ( from uengine-core module )
         * @throws Exception
         */
    public EssenceProcessDefinition toProcessDefinition(EssenceProcessDefinition existingProcessDefinition) {

        EssenceProcessDefinition returnProcessDefinition = existingProcessDefinition;

        if(returnProcessDefinition==null) {
            returnProcessDefinition = new EssenceProcessDefinition();
            returnProcessDefinition.setRunAllStartableActivities(false);
        }

        ((EssenceProcessDefinition) returnProcessDefinition).setPracticeDefinition(this);



        //remove essence activities generated before in BPMN-side which is currently removed in the practice definition.
        new ActivityFor() {
            @Override
            public void logic(org.uengine.kernel.Activity activity) {
                if(activity instanceof EssenceActivity) {
                    EssenceActivity essenceActivity = (EssenceActivity) activity;

                    if(essenceActivity.getActivityInEssenceDefinition()==null){
                        ((ComplexActivity)essenceActivity.getParentActivity()).removeChildActivity(essenceActivity);
                    }
                }
            }
        }.run(returnProcessDefinition);


        Role rootRole = returnProcessDefinition.getRole("rootRole");
        boolean newRootRole = false;

        if(rootRole==null) {
            newRootRole = true;

            rootRole = Role.forName("rootRole");
            {
                rootRole.setDisplayName("");
                returnProcessDefinition.addRole(rootRole);

                ElementView roleView = rootRole.createView();

                //            roleView.setWidth(calculateLaneWidth(competency.getName()) + 40 + 192);
                roleView.setHeight(128 * returnProcessDefinition.getRoles().length);
                roleView.setX(48 + (roleView.getWidth()) / 2);
                roleView.setY(40 + (roleView.getHeight()) / 2);
                roleView.setShapeId("OG.shape.HorizontalLaneShape");
                roleView.setLabel("");
                roleView.setId("rootRole");

                rootRole.setElementView(roleView);
            }
        }

        for (IElement element : getElements(Activity.class)) {
            Role role = null;
            ElementView roleView = null;
            int laneCnt = 0;  //due to the rootRole, it should be 0
            ElementView humanView = null;

            Activity activityInPracticeDefinition = (Activity) element;

            if(activityInPracticeDefinition.getCompetency()==null) continue; // ignore the activity spaces or the activities which is not set its competency.
            Competency competency = getElement(activityInPracticeDefinition.getCompetency().getName(), Competency.class);

            if(competency==null) continue;
            if(activityInPracticeDefinition instanceof ActivitySpace) continue;

            //finding role from the existing process definition first.
            if(returnProcessDefinition.getRoles()!=null)
            for(int i=0; i<returnProcessDefinition.getRoles().length; i++){
                if(returnProcessDefinition.getRoles()[i].getName().equalsIgnoreCase(competency.getName())){
                    role = returnProcessDefinition.getRoles()[i];

                    laneCnt = i;
                    break;
                }
            }

            if (role==null) {
                role = Role.forName(competency.getName());
                role.setDisplayName(role.getName());
                returnProcessDefinition.addRole(role);

                laneCnt = returnProcessDefinition.getRoles().length - 2;

            }

            roleView = role.getElementView();


            if(roleView == null){
                roleView = role.createView();

                roleView.setWidth(calculateLaneWidth(competency.getName()) + 40 + 192);
                roleView.setHeight(128);
                roleView.setX(48 + (roleView.getWidth()) / 2);
                roleView.setY(40 + (roleView.getHeight()) / 2 + laneCnt * (roleView.getHeight()));
                roleView.setShapeId("OG.shape.HorizontalLaneShape");
                roleView.setLabel(role.getName());

                role.setElementView(roleView);
            }

            //for rootRole
            roleView.setParent(rootRole.getElementView().getId());

            //make essence activity
            final String nameOfFindingActivity = ((Activity) element).getName();


            //find existing BPMN activity to update
            final ActivityFor findingActivityByName = new ActivityFor(){

                @Override
                public void logic(org.uengine.kernel.Activity activity) {
                    if(activity instanceof EssenceActivity){
                        EssenceActivity essenceActivity = (EssenceActivity)activity;

                        if(nameOfFindingActivity.equals(essenceActivity.getActivityInEssenceDefinition().getName())) {
                            setReturnValue(activity);
                            stop();
                        }
                    }
                }
            };

            findingActivityByName.run(returnProcessDefinition);


            EssenceActivity essenceActivity = (EssenceActivity) findingActivityByName.getReturnValue();

            //in case that newly added
            if(essenceActivity==null){
                essenceActivity = new EssenceActivity();

                humanView = essenceActivity.createView();

                essenceActivity.setName(element.getName());

                humanView.setLabel(element.getName());
                humanView.setShapeId(HumanActivityView.SHAPE_ID_BPMN);
                humanView.setHeight(96);
                humanView.setWidth(96);

                double laneX = (roleView.getX());
                double laneHalfWidth = (roleView.getWidth()) / 2;
                double prevActivitiesCnt = prevActivitiesCntWithSameCompetency(returnProcessDefinition.getChildActivities(), competency);
                double humanX = (humanView.getWidth()) * prevActivitiesCnt;

                double rst = laneX - laneHalfWidth + humanX;
                rst = rst + 64 * prevActivitiesCnt;

                humanView.setX(rst);
                humanView.setY(roleView.getY());

//            essenceActivity.setTool(makeTool(element));

                essenceActivity.setElementView(humanView);

                essenceActivity.setActivityInEssenceDefinition(activityInPracticeDefinition);
                essenceActivity.setRole(Role.forName(activityInPracticeDefinition.getCompetency().getName()));//TODO: should be getCompetency().getName()

                returnProcessDefinition.addChildActivity(essenceActivity);

            }else{ //update
                essenceActivity.setActivityInEssenceDefinition(activityInPracticeDefinition);
                essenceActivity.setRole(Role.forName(activityInPracticeDefinition.getCompetency().getName()));//TODO: should be getCompetency().getName()

            }

            essenceActivity.initInputOutputParameters(); //Refresh the parameters



        }

        //getting max width and apply it to all and rootRole

        if(newRootRole){

            if(returnProcessDefinition.getRoles().length == 1){ //means there's only one role (rootRole)

                returnProcessDefinition.setRoles(null); //if there is only root role, remove it.

            }else {

                double maxWidth = 0;
                for (Role role : returnProcessDefinition.getRoles()) {

                    if (role.getElementView().getWidth() > maxWidth)
                        maxWidth = role.getElementView().getWidth();

                }

                for (Role role : returnProcessDefinition.getRoles()) {
                    ElementView roleView = role.getElementView();
                    roleView.setWidth(maxWidth);
                    roleView.setX(48 + (roleView.getWidth()) / 2);
                }


                ElementView rootRoleView = rootRole.getElementView();

                rootRoleView.setHeight(128 * (returnProcessDefinition.getRoles().length - 1)); // -1 means except itself - rootRole

                int labelSize = 20;
                rootRoleView.setWidth(maxWidth + labelSize /*label size*/);
                rootRoleView.setX(48 - labelSize + (rootRoleView.getWidth()) / 2);
                rootRoleView.setY(40 + (rootRoleView.getHeight()) / 2);
            }

        }



//        if (returnProcessDefinition.getChildActivities().size() != 0) {
//            EndEvent e = new EndEvent();
//            e.setTracingTag("99");
//            ElementView view = e.createView();
//            view.setShapeId("OG.shape.bpmn.E_End");
//            view.setHeight("32");
//            view.setWidth("32");
//            int temp = Integer.valueOf(humanView.getX()) + 83;
//
//            view.setX(temp);
//            view.setY(humanView.getY());
//            e.setElementView(view);
//            returnProcessDefinition.getChildActivities().add(e);
//        }


        overrideProcessVariablesTo(returnProcessDefinition);



        //set the processdefinition's description by copying from practice's description.
        List<Practice> practices = getElements(Practice.class);
        if(practices!=null && practices.size() > 0){
            Practice rootPractice = practices.get(0); // must finding logic needed e.g. getRootPractice()

            returnProcessDefinition.setDescription(rootPractice.getBriefDescription());
        }


        return returnProcessDefinition;
    }

    public void overrideProcessVariablesTo(EssenceProcessDefinition returnProcessDefinition) {
        List<ProcessVariable> pvList = new ArrayList<ProcessVariable>(){
            HashMap<String, String> names = new HashMap<String, String>();

            @Override
            public boolean add(ProcessVariable element) {
                names.put(element.getName(), element.getName());
                return super.add(element);
            }

            @Override
            public boolean contains(Object o) {

                if(names.containsKey(((ProcessVariable)o).getName())) return true;

                return super.contains(o);
            }
        };

        for (Alpha alpha : getElements(Alpha.class)) {
            ProcessVariable pv = null;

            AlphaInstance alphaInstance = null; //reset the alphaInstance all the times.
            alphaInstance = (AlphaInstance) alpha.createObjectInstance();

            //여기서 property를 다 set 해주어야할듯

            pv = new ProcessVariable(new Object[]{
                    "name", alpha.getName(),
                    "type", AlphaInstance.class
            });
            pv.setDefaultValue(alphaInstance);

            pvList.add(pv);
        }

        for (WorkProduct workProduct : getElements(WorkProduct.class)) {
            ProcessVariable pv = null;

            LanguageElementInstance workProductInstance = workProduct.createObjectInstance();
            workProductInstance.setId(workProduct.getName());

            pv = new ProcessVariable(new Object[]{
                    "name", workProduct.getName(),
                    "type", LanguageElementInstance.class
            });
            pv.setDefaultValue(workProductInstance);
            pvList.add(pv);
        }

        //restore the general process variables defined in Process Modeler
        if(returnProcessDefinition.getProcessVariables()!=null)
        for(ProcessVariable pvInExistingPD : returnProcessDefinition.getProcessVariables()){
            if(!(pvInExistingPD.getDefaultValue() instanceof LanguageElementInstance) && !pvList.contains(pvInExistingPD)){

                pvList.add(pvInExistingPD);
            }
        }


        ProcessVariable[] pvArray = {};
        pvArray = pvList.toArray(pvArray);
        returnProcessDefinition.setProcessVariables(pvArray);
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
            if (activity instanceof EssenceActivity && ((EssenceActivity) activity).getActivityInEssenceDefinition().getCompetency().getName().equals(c.getName())) {
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
            return null;
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
            return  null; //throw new IllegalArgumentException("element name is null");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("clazz argument cannot be null");
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
     *
     * @param id
     * @return
     */
    public IElement pickElementByViewId(String id) {
        IElement element = null;

        String[] stringArrays = id.split("_");
        String temp = stringArrays[0] + "_" + stringArrays[1] + "_" + stringArrays[2];

        for (IElement e : getElementList()) {
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

    public File toXmi() {
        XMIAdapter xmiAdapter = new XMIAdapter(this);
        return xmiAdapter.toXmi();
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

    //TODO:  remove this method and implement properly.
    private void addCheckpointToState() {
        List<Activity> activityList = this.getElements(Activity.class);
        for (Activity activity : activityList) {
            if (activity.getCompletionCriteria() != null) {
                for (LanguageElement e : activity.getCompletionCriteria()) {
                    Criterion criterion = (Criterion) e;
                    if (criterion.getState() != null) {
                        State state = criterion.getState();

                        try {

                            State fullState = getState(criterion.getState().getParentAlpha().getName(), state.getName());
                            if (fullState != null) {
                                state.setCheckPoints(fullState.getCheckPoints());
                            }
                        }catch (Exception ex){}

                    }
                }
            }
        }
    }

    public State getState(String alphaName, String stateName) {
        List<Alpha> alphaList = this.getElements(Alpha.class);
        for (Alpha alpha : alphaList) {
            if (alpha.getName().equals(alphaName)) {
                for (State state : alpha.getStates()) {
                    if (state.getName().equals(stateName))
                        return state;
                }
            }
        }
        return null;
    }

    public void beforeSerialize() {

    }


    @XStreamOmitField
    transient boolean arranged = false;


    public void arrangeRelations(){

        if(arranged) return;

        Map<String, IElement> elementMap = new HashMap<String, IElement>();

        Practice rootPractice = null;
        for(IElement element : getElementList()){
            elementMap.put(element.getElementView().getId(), element);

            if(element instanceof Practice){
                rootPractice = (Practice) element;
            }
        }

        for(IRelation relation : getRelationList()){

            String from = relation.getRelationView().getFrom();
            String to = relation.getRelationView().getTo();

            //danggling link will be automatically connected to method (root)
            if(from == null && rootPractice!=null) from = rootPractice.getElementView().getId();

            if(to==null || from==null) continue;

            from = from.split("_TERMINAL")[0];
            to = to.split("_TERMINAL")[0];

            BasicElement sourceElem = (BasicElement) elementMap.get(from);
            BasicElement targetElem = (BasicElement) elementMap.get(to);

            //stitch String Link
            if(targetElem!=null && sourceElem!=null)
                targetElem.setParentElementId(sourceElem.getName());

            Relation _relation = (Relation) relation;

            _relation.setSourceElement(sourceElem);
            _relation.setTargetElement(targetElem);

            if(sourceElem!=null) {
                if (sourceElem.outgoingRelations == null)
                    sourceElem.outgoingRelations = new ArrayList<Relation>();

                sourceElem.outgoingRelations.add(_relation);
            }

            if(targetElem != null){ //TODO: need to rosolve why this happen
                if(targetElem.incomingRelations==null)
                    targetElem.incomingRelations = new ArrayList<Relation>();

                targetElem.incomingRelations.add(_relation);
            }

        }

        arranged = true;


        // if there are danggling elements, make them connected to root practice.
        if(rootPractice!=null)
        for(IElement element : getElementList()){
            if(element instanceof BasicElement
                    &&
                    (((BasicElement) element).getIncomingRelations()==null || ((BasicElement) element).getIncomingRelations().size()==0) && !(element instanceof Practice)){

                Relation relation = new Relation();
                relation.setSourceElement(rootPractice);
                relation.setTargetElement(element);

                ((BasicElement) element).incomingRelations = new ArrayList<Relation>();

                ((BasicElement) element).getIncomingRelations().add(relation); //stitch to the target

                if(rootPractice.outgoingRelations == null){
                    rootPractice.outgoingRelations = new ArrayList<Relation>(); //stitch to the source
                }

                rootPractice.outgoingRelations.add(relation);

            }
        }

    }

    @Override
    public void beforeSerialization() {

        for (IElement element : getElements(Activity.class)) {

            Activity activityInPracticeDefinition = (Activity) element;

            if(activityInPracticeDefinition.getCompetency()!=null) {
                Competency competency = getElement(activityInPracticeDefinition.getCompetency().getName(), Competency.class);

                activityInPracticeDefinition.setCompetency(competency);
            }

            if(activityInPracticeDefinition.getEntryCriteria()!=null)
            for(EntryCriterion criterion : activityInPracticeDefinition.getEntryCriteria()){
                try {
                    refreshActivityCriteria(criterion);
                }catch (Exception e){
                    throw new RuntimeException("Error when to define the entry criterion of activity ["+ activityInPracticeDefinition.getName() + "] because " + e.getMessage());
                }
            }

            if(activityInPracticeDefinition.getCompletionCriteria()!=null)
            for(CompletionCriterion criterion : activityInPracticeDefinition.getCompletionCriteria()){
                try{
                    refreshActivityCriteria(criterion);
                }catch (Exception e){
                    throw new RuntimeException("Error when to define the completion criterion of activity ["+ activityInPracticeDefinition.getName() + "] because " + e.getMessage(), e);
                }
            }
        }

        for(IElement element : getElementList()){

            if(element instanceof NeedArrangementToSerialize){
                ((NeedArrangementToSerialize) element).beforeSerialization();
            }

        }

        for(IRelation relation : getRelationList()){

            BasicElement sourceElem = (BasicElement) relation.getSourceElement();
            BasicElement targetElem = (BasicElement) relation.getTargetElement();

            //stitch String Link
            if(targetElem!=null && sourceElem!=null)
                targetElem.setParentElementId(sourceElem.getName());
        }

    }

    private void refreshActivityCriteria(Criterion criterion) {
        if(criterion.getState()!=null && criterion.getState().getParentAlpha()!=null) {
            Alpha realAlpha = getElement(criterion.getState().getParentAlpha().getName(), Alpha.class);

            if(realAlpha==null){
                throw new RuntimeException("There's no alpha named [" + criterion.getState().getParentAlpha().getName() + "]"); //TODO: must be moved to some log file and messages must be presented to users.
            }

            State realState = realAlpha.findState(criterion.getState().getName());

            if(realState==null){
                throw new RuntimeException("There's no state named [" + criterion.getState().getName() + "]"); //TODO: must be moved to some log file and messages must be presented to users.
                //criterion.setState(null);
            }
            else {
                realState.setParentAlpha(realAlpha);
                criterion.setState(realState);
            }
        }

        if(criterion.getLevelOfDetail()!=null){
            WorkProduct realWorkProduct = getElement(criterion.getLevelOfDetail().getParentWorkProduct().getName(), WorkProduct.class);
            LevelOfDetail realLevelOfDetail = realWorkProduct.findLevelOfDetail(criterion.getLevelOfDetail().getName());
            realLevelOfDetail.setParentAlpha(realWorkProduct);

            criterion.setLevelOfDetail(realLevelOfDetail);
        }
    }

    @Override
    public void afterDeserialization() {
        arrangeRelations();
    }

    public void setBaseKernel(String baseKernel) {
        this.baseKernel = baseKernel;
    }

    public String getBaseKernel() {
        return baseKernel;
    }

    public PracticeDefinition shallowCopy(){
        PracticeDefinition practiceDefinition = new PracticeDefinition();
        practiceDefinition.setMetaworksContext(getMetaworksContext());
        practiceDefinition.setDescription(getDescription());
        practiceDefinition.setBaseKernel(getBaseKernel());
        practiceDefinition.setId(getId());
        practiceDefinition.setName(getName());
        practiceDefinition.setRelationList(getRelationList());

        List<IElement> copies = new ArrayList<IElement>();
        for(IElement element : getElementList()){
            if(element instanceof LanguageElement){
                copies.add((IElement) ((LanguageElement) element).shallowCopy());
            }else
                copies.add(element);
        }

        practiceDefinition.setElementList(copies);

        return practiceDefinition;
    }
}