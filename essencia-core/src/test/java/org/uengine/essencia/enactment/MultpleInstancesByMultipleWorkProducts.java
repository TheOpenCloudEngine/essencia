package org.uengine.essencia.enactment;

import org.metaworks.component.SelectBox;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.*;
import org.uengine.kernel.*;
import org.uengine.kernel.Activity;
import org.uengine.kernel.bpmn.SequenceFlow;
import org.uengine.kernel.bpmn.SubProcess;
import org.uengine.kernel.test.UEngineTest;
import org.uengine.modeling.IElement;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MultpleInstancesByMultipleWorkProducts extends UEngineTest{

    EssenceProcessDefinition processDefinition;
    PracticeDefinition practiceDefinition;
    Alpha alphaBacklog;
    org.uengine.essencia.model.Activity activityInEssenceDefinition;
    org.uengine.essencia.model.Activity sprintPlanningInEssenceDefinition;
    EssenceActivity essenceActivity;
    EssenceActivity sprintPlanningActivity;


    WorkProduct sprint;

    /**
     * build a graph as follows:
     *
     *                +-------sub--------+
     *                |                  |
     *          9 --->|   1 -> 2 -> 3    |---> 7
     *                |                  |
     *                +------------------+
     *
     *   * 1,2 and 3 are embraced in an embedded SubProcess
     *   * sub is subprocess which is set as multiple instance for each variable value of 'Backlog'(is a subalpha)
     *   * 2 is a ReceiveActivity
     *
     * @throws Exception
     */
    public void setUp() throws Exception {


        practiceDefinition = new PracticeDefinition();
//
//        practiceDefinition.addElement();
//
//

        //we should find alpha globally by naming - 'practiceDefinition.getAlpha("Backlog")';


        sprint = new WorkProduct();
        sprint.setName("Sprint");
        sprint.addAttribute("duration", Long.class);
        sprint.addAttribute("iteration", Integer.class);
        sprint.addAttribute("startDate", String.class);
        sprint.addAttribute("endDate", String.class);



        alphaBacklog = new Alpha();
        alphaBacklog.setName("Backlog");
        alphaBacklog.addAttribute("type", String.class);
        alphaBacklog.addAttribute("parent", String.class);

        List<LanguageElement> childElements = new ArrayList<LanguageElement>();
        childElements.add(sprint);
        alphaBacklog.setChildElements(childElements);

        List<IElement> elementList = new ArrayList<IElement>();
        elementList.add(alphaBacklog);

        practiceDefinition.setElementList(elementList);


        State identified;
        State selected;

        List<State> statesOfBacklog = new ArrayList<State>();
        {
            State state = new State();
            statesOfBacklog.add(state);
            state.setName("Identified");

            List<CheckPoint> checkPoints = new ArrayList<CheckPoint>();

            {
                CheckPoint point = new CheckPoint();
                point.setName("checkpoint1 of Identified");

                checkPoints.add(point);
            }

            state.setCheckPoints(checkPoints);

            state.setParentAlpha(alphaBacklog); //TODO: should be removed. alpha.setList should do this.

            identified = state;

        }
        {
            State state = new State();
            statesOfBacklog.add(state);
            state.setName("Selected");

            List<CheckPoint> checkPoints = new ArrayList<CheckPoint>();

            {
                CheckPoint point = new CheckPoint();
                point.setName("checkpoint1 of Selected");

                checkPoints.add(point);
            }

            state.setCheckPoints(checkPoints);

            state.setParentAlpha(alphaBacklog);


            selected = state;
        }
        {
            State state = new State();
            statesOfBacklog.add(state);
            state.setName("Done");

            List<CheckPoint> checkPoints = new ArrayList<CheckPoint>();

            {
                CheckPoint point = new CheckPoint();
                point.setName("checkpoint1 of Done");

                checkPoints.add(point);
            }

            state.setCheckPoints(checkPoints);
            state.setParentAlpha(alphaBacklog);


        }


        alphaBacklog.setStates(statesOfBacklog);

        {
            sprintPlanningInEssenceDefinition = new org.uengine.essencia.model.Activity();
            sprintPlanningInEssenceDefinition.setName("Planning");
            sprintPlanningInEssenceDefinition.setCompetency(new Competency());
            sprintPlanningInEssenceDefinition.getCompetency().setName("Product Owner");

            List<CompletionCriterion> completionCriteria = new ArrayList<CompletionCriterion>();

            CompletionCriterion criterion = new CompletionCriterion();

            sprint.setStates(new ArrayList<State>());

            LevelOfDetail done = new LevelOfDetail();
            done.setParentWorkProduct(sprint);
            done.setName("done");

            LevelOfDetail draft = new LevelOfDetail();
            draft.setParentWorkProduct(sprint);
            draft.setName("draft");

            sprint.getLevelOfDetails().add(draft);
            sprint.getLevelOfDetails().add(done);

            criterion.setLevelOfDetail(done);
            completionCriteria.add(criterion);

            sprintPlanningInEssenceDefinition.setCompletionCriteria(completionCriteria);

        }

        {

            activityInEssenceDefinition = new org.uengine.essencia.model.Activity();

            activityInEssenceDefinition.setName("Working");

            //TODO:  problematic!
            activityInEssenceDefinition.setCompetency(new Competency());
            activityInEssenceDefinition.getCompetency().setName("Product Owner");

            EntryCriterion criterion = new EntryCriterion();
            criterion.setState(identified);

            List<EntryCriterion> criteriaList = new ArrayList<EntryCriterion>();
            criteriaList.add(criterion);

            activityInEssenceDefinition.setEntryCriteria(criteriaList);


            CompletionCriterion completionCriteria = new CompletionCriterion();
            completionCriteria.setState(selected);

            CompletionCriterion completionCriteria2 = new CompletionCriterion();
            LevelOfDetail levelOfDetail = new LevelOfDetail();
            levelOfDetail.setParentWorkProduct(sprint);
            levelOfDetail.setName("done");

            completionCriteria2.setLevelOfDetail(levelOfDetail);

            List<CompletionCriterion> completionCriteriaList = new ArrayList<CompletionCriterion>(); //TODO:
            completionCriteriaList.add(completionCriteria);
            completionCriteriaList.add(completionCriteria2);


            activityInEssenceDefinition.setCompletionCriteria(completionCriteriaList);

          }

        /////// building process definition :  later it should be generated from PracticeDefinition by default


        processDefinition = new EssenceProcessDefinition();

        processDefinition.setPracticeDefinition(practiceDefinition);

        processDefinition.setId("scrum process");

        WorkProductInstance defaultSprint = sprint.createObjectInstance();
        defaultSprint.setId("<id>");
        defaultSprint.setAttribute("iteration", new Integer(5));
        defaultSprint.setAttribute("startDate", "");
        defaultSprint.setCurrentStateName("draft");
//        defaultSprint.put("duration", 14);

        ProcessVariableValue pvv = new ProcessVariableValue();
        pvv.setName(alphaBacklog.getName());


        //where?
        //alphaBacklog.getStates();

        AlphaInstance backlogInstance = alphaBacklog.createObjectInstance();
        backlogInstance.setId("backlog");
        backlogInstance.setAttribute("type", "Backlog");


        ProcessVariable pvAlphaBacklog = new ProcessVariable(new Object[]{
                "name", alphaBacklog.getName(),
                "type", AlphaInstance.class,
        });

        pvAlphaBacklog.setDefaultValue(backlogInstance);

        ProcessVariable pvSprint = new ProcessVariable(new Object[]{
                "name", sprint.getName(),
                "type", LanguageElementInstance.class,
                "defaultValue", (Serializable)defaultSprint
        });

        pvSprint.setDefaultValue(defaultSprint);

        processDefinition.setProcessVariables(new ProcessVariable[]{
                pvAlphaBacklog,
                pvSprint,
        });

        processDefinition.setRoles(new Role[]{
                Role.forName(activityInEssenceDefinition.getCompetency().getName())
        });




        SubProcess subProcess = new SubProcess();
        subProcess.setTracingTag("sub");

        subProcess.setForEachVariable(pvSprint);

        /// variable mapping
        {
            SubProcessParameterContext alphaBacklogMapping = new SubProcessParameterContext();
            TextContext argument = TextContext.createInstance();
            argument.setText(alphaBacklog.getName());
            alphaBacklogMapping.setArgument(argument);

            alphaBacklogMapping.setVariable(pvAlphaBacklog);
            alphaBacklogMapping.setDirection(ParameterContext.DIRECTION_IN);
            alphaBacklogMapping.setSplit(false);


            List<SubProcessParameterContext> subProcessParameterContextList = new ArrayList<SubProcessParameterContext>();

            SubProcessParameterContext sprintVariableMapping = new SubProcessParameterContext();
            argument = TextContext.createInstance();
            argument.setText(sprint.getName());
            sprintVariableMapping.setArgument(argument);

            sprintVariableMapping.setVariable(pvSprint);
            sprintVariableMapping.setDirection(ParameterContext.DIRECTION_INOUT);
            sprintVariableMapping.setSplit(true);

            subProcessParameterContextList.add(alphaBacklogMapping);
            subProcessParameterContextList.add(sprintVariableMapping);

            subProcess.setVariableBindings(subProcessParameterContextList);
        }

        processDefinition.addChildActivity(subProcess);




        for(int i=1; i<4; i++) {
            org.uengine.kernel.Activity a1 = new DefaultActivity();

            if(i==2){

                essenceActivity = new EssenceActivity(activityInEssenceDefinition);
                a1 = essenceActivity;
            }

            a1.setTracingTag("a" + i);
            subProcess.addChildActivity(a1);
        }


        for(int i=4; i<20; i++) {



            Activity a1 = new DefaultActivity();


            if(i==9){
                sprintPlanningActivity = new EssenceActivity(sprintPlanningInEssenceDefinition);
//                sprintPlanningActivity.getParameters()[0].setMultipleInput(true);
                a1 = sprintPlanningActivity;
            }



            a1.setTracingTag("a" + i);
            processDefinition.addChildActivity(a1);

        }


        {
            SequenceFlow t1 = new SequenceFlow();
            t1.setSourceRef("a9");
            t1.setTargetRef("sub");

            processDefinition.addSequenceFlow(t1);
        }
        {
            SequenceFlow t1 = new SequenceFlow();
            t1.setSourceRef("a1");
            t1.setTargetRef("a2");

            subProcess.addSequenceFlow(t1);
        }
        {
            SequenceFlow t1 = new SequenceFlow();
            t1.setSourceRef("a2");
            t1.setTargetRef("a3");

            subProcess.addSequenceFlow(t1);
        }

        {
            SequenceFlow t1 = new SequenceFlow();
            t1.setSourceRef("sub");
            t1.setTargetRef("a7");

            processDefinition.addSequenceFlow(t1);
        }

        processDefinition.afterDeserialization();

        AbstractProcessInstance.USE_CLASS = DefaultProcessInstance.class;

        GlobalContext.serialize(processDefinition, new FileOutputStream(getClass().getName()+ ".process"), String.class);

    }
















    public void testMethodEnactment() throws Exception {

        ProcessInstance instance = processDefinition.createInstance();



        instance.putRoleMapping(activityInEssenceDefinition.getCompetency().getName(), "jane");

        instance.execute();


        ResultPayload resultPayload = new ResultPayload();

        ProcessVariableValue pvvForSprints = new ProcessVariableValue();
        pvvForSprints.setName("sprint");
        LanguageElementInstance sprint1 = sprint.createObjectInstance();
        sprint1.setId("sprint1");
        sprint1.setAttribute("iteration", 1);
        pvvForSprints.setValue(sprint1);

        pvvForSprints.moveToAdd();
        LanguageElementInstance sprint2 = sprint.createObjectInstance();
        sprint2.setId("sprint2");
        sprint1.setAttribute("iteration", 2);
        pvvForSprints.setValue(sprint2);

        pvvForSprints.moveToAdd();
        LanguageElementInstance sprint3 = sprint.createObjectInstance();
        sprint3.setId("sprint3");
        sprint1.setAttribute("iteration", 3);
        pvvForSprints.setValue(sprint3);



        resultPayload.setProcessVariableChange(new KeyedParameter(sprint.getName(), pvvForSprints));

        instance.getProcessDefinition().fireMessage(sprintPlanningActivity.getMessage(), instance, resultPayload);



        assertExecutionPathEquals("After Receiving Three Values and three sub processes are instantiated for each values", new String[]{
                "a9",       "a1", "a1", "a1",
        }, instance);



        //now completing the sub processes one by one

        instance.setExecutionScope("0");


        //checking checkpoints currently reached state
//        {
//            AlphaInstance alphaInstanceOfSub1 = alphaBacklog.getInstances(instance).get(0);
//
//            for(CheckPoint point : alphaBacklog.getStates().get(0).getCheckPoints()){
//                alphaInstanceOfSub1.setChecked(point.getName());
//
//                //point.setChecked(alphaInstanceOfSub1);
//            }
//        }


        //Now, it should be completable


        resultPayload = new ResultPayload();

        sprint1 = sprint.createObjectInstance();
        sprint1.setId("sprint1");
        sprint1.setAttribute("iteration", 11);

        resultPayload.setProcessVariableChange(new KeyedParameter(sprint.getName(), sprint1));

        instance.getProcessDefinition().fireMessage(essenceActivity.getMessage(), instance, resultPayload);

        assertExecutionPathEquals("With Execution Scope 0", new String[]{
                "a9", "a1", "a1", "a1", "a2", "a3"
        }, instance);



        instance.setExecutionScope("1");

        //checking checkpoints currently reached state
//        {
//            AlphaInstance alphaInstanceOfSub1 = alphaBacklog.getInstances(instance).get(0);
//
//            for(CheckPoint point : alphaBacklog.getStates().get(1).getCheckPoints()){
//                alphaInstanceOfSub1.setChecked(point.getName());
//
//                //point.setChecked(alphaInstanceOfSub1);
//            }
//        }

        resultPayload = new ResultPayload();

        sprint2 = sprint.createObjectInstance();
        sprint2.setId("sprint2");
        sprint2.setAttribute("iteration", 12);

        resultPayload.setProcessVariableChange(new KeyedParameter(sprint.getName(), sprint2));


        instance.getProcessDefinition().fireMessage(essenceActivity.getMessage(), instance, resultPayload);

        assertExecutionPathEquals("With Execution Scope 1", new String[]{
                "a9",       "a1", "a1", "a1",   "a2", "a3",   "a2", "a3"
        }, instance);



        instance.setExecutionScope("2");

        //checking checkpoints currently reached state
//        {
//            AlphaInstance alphaInstanceOfSub1 = alphaBacklog.getInstances(instance).get(0);
//
//            for (CheckPoint point : alphaBacklog.getStates().get(2).getCheckPoints()) {
//                alphaInstanceOfSub1.setChecked(point.getName());
//
//                //point.setChecked(alphaInstanceOfSub1);
//            }
//        }

        resultPayload = new ResultPayload();

        sprint3 = sprint.createObjectInstance();
        sprint3.setId("sprint3");
        sprint3.setAttribute("iteration", 13);

        resultPayload.setProcessVariableChange(new KeyedParameter(sprint.getName(), sprint3));


        instance.getProcessDefinition().fireMessage(essenceActivity.getMessage(), instance, resultPayload);

        assertExecutionPathEquals("With Execution Scope 2", new String[]{
                "a9",       "a1", "a1", "a1",   "a2", "a3",   "a2", "a3",  "a2", "a3",   "sub", "a7"
        }, instance);


        instance.setExecutionScope(null);


//        List<AlphaInstance> alphaInstanceList = alphaBacklog.getInstances(instance);
//
//        for(AlphaInstance alphaInstance : alphaInstanceList){
//            System.out.println(alphaInstance.getId()+":  "+ alphaInstance.getCurrentStateName());
//        }

        int[] mustBeIterationValues = {11,12,13};
        int i = 0;

        List<? extends LanguageElementInstance> sprintInstances = sprint.getInstances(instance);

        for(LanguageElementInstance sprintInstance : sprintInstances){
            System.out.println(sprintInstance.getId()+":  "+ sprintInstance.getAttribute("iteration"));

            assertEquals(sprintInstance.getAttribute("iteration"), mustBeIterationValues[i++]);
        }



        //TODO:  user interface generation for Parameter Values - that is LanguageElementInstance : may be ok.
        //TODO:  Can this instance model generate all of the information on dashboard displays?
        //TODO:  sub in sub scoping :  main-sub-sub-sub scoping for execution scope system
        //TODO:  rolemapping is also needed to be scoped (in db persistence)

    }
}
