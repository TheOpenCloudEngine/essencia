package org.uengine.essencia.enactment;

import org.metaworks.component.SelectBox;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.*;
import org.uengine.kernel.*;
import org.uengine.kernel.Activity;
import org.uengine.kernel.bpmn.SequenceFlow;
import org.uengine.kernel.bpmn.SubProcess;
import org.uengine.kernel.test.UEngineTest;

import java.util.ArrayList;
import java.util.List;

public class MethodEnactmentTest extends UEngineTest{

    ProcessDefinition processDefinition;
    PracticeDefinition practiceDefinition;
    Alpha alphaBacklog;
    org.uengine.essencia.model.Activity activityInEssenceDefinition;
    EssenceActivity essenceActivity;


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


//        practiceDefinition = new PracticeDefinition();
//
//        practiceDefinition.addElement();
//
//

        //we should find alpha globally by naming - 'practiceDefinition.getAlpha("Backlog")';


        sprint = new WorkProduct();
        sprint.setName("Sprint");
        sprint.addAttribute("duration", Long.class);
        sprint.addAttribute("iteration", Integer.class);

        alphaBacklog = new Alpha();
        alphaBacklog.setName("Backlog");
        alphaBacklog.addAttribute("type", String.class);
        alphaBacklog.addAttribute("parent", String.class);


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

        activityInEssenceDefinition = new org.uengine.essencia.model.Activity();

        activityInEssenceDefinition.setName("Planning");

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

        List<CompletionCriterion> completionCriteriaList = new ArrayList<CompletionCriterion>(); //TODO:
        completionCriteriaList.add(completionCriteria);


        activityInEssenceDefinition.setCompletionCriteria(completionCriteriaList);

        List<LanguageElement> workProducts = new ArrayList<LanguageElement>();
        workProducts.add(sprint);

//        activityInEssenceDefinition.setWorkProductList(workProducts);


        /////// building process definition :  later it should be generated from PracticeDefinition by default


        processDefinition = new ProcessDefinition();

        processDefinition.setId("scrum process");

        processDefinition.setProcessVariables(new ProcessVariable[]{
                ProcessVariable.forName(alphaBacklog.getName()),
                ProcessVariable.forName(sprint.getName()),
        });

        processDefinition.setRoles(new Role[]{
                Role.forName(activityInEssenceDefinition.getCompetency().getName())
        });




        SubProcess subProcess = new SubProcess();
        subProcess.setTracingTag("sub");

        subProcess.setForEachVariable(ProcessVariable.forName(alphaBacklog.getName()));

        /// variable mapping
        {
            SubProcessParameterContext alphaBacklogMapping = new SubProcessParameterContext();
            TextContext argument = TextContext.createInstance();
            argument.setText(alphaBacklog.getName());
            alphaBacklogMapping.setArgument(argument);

            alphaBacklogMapping.setVariable(ProcessVariable.forName(alphaBacklog.getName()));
            alphaBacklogMapping.setDirection(ParameterContext.DIRECTION_IN);
            alphaBacklogMapping.setSplit(true);


            SubProcessParameterContext sprintVariableMapping = new SubProcessParameterContext();
            argument = TextContext.createInstance();
            argument.setText(sprint.getName());
            sprintVariableMapping.setArgument(argument);

            sprintVariableMapping.setVariable(ProcessVariable.forName(sprint.getName()));
            sprintVariableMapping.setDirection(ParameterContext.DIRECTION_INOUT);
            sprintVariableMapping.setSplit(true);

            List<SubProcessParameterContext> subProcessParameterContextList = new ArrayList<SubProcessParameterContext>();

            subProcessParameterContextList.add(alphaBacklogMapping);
            subProcessParameterContextList.add(sprintVariableMapping);

            subProcess.setVariableBindings(subProcessParameterContextList);
        }

        processDefinition.addChildActivity(subProcess);




        for(int i=1; i<4; i++) {
            Activity a1 = new DefaultActivity();

            if(i==2){

                essenceActivity = new EssenceActivity(activityInEssenceDefinition);

                a1 = essenceActivity;
            }

            a1.setTracingTag("a" + i);
            subProcess.addChildActivity(a1);
        }


        for(int i=4; i<20; i++) {
            Activity a1 = new DefaultActivity();

            a1.setTracingTag("a" + i);
            processDefinition.addChildActivity(a1);

        }


        {
            SequenceFlow t1 = new SequenceFlow();
            t1.setSourceRef("a9");
            t1.setTargetRef("sub");

            subProcess.addSequenceFlow(t1);
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

        ProcessInstance.USE_CLASS = DefaultProcessInstance.class;


    }

    public void testMethodEnactment() throws Exception {

        ProcessInstance instance = processDefinition.createInstance();


        ProcessVariableValue pvv = new ProcessVariableValue();
        pvv.setName(alphaBacklog.getName());


        //where?
        //alphaBacklog.getStates();

        AlphaInstance backlogInstance = alphaBacklog.createInstance("backlog1");
        {
            backlogInstance.setAttribute("type", "Story");

            try {
                backlogInstance.setAttribute("undefinedField", "someValue");

                fail("undefined property is accepted");
            } catch (Throwable t) {
            }

            try {
                backlogInstance.setAttribute("type", new Boolean(true));

                fail("illegal value for property 'type' is accepted");
            } catch (Throwable t) {
            }

            try {
                backlogInstance.setAttribute("id", "id");

                fail("put('id', value) must be denied");
            } catch (Throwable t) {
            }

            pvv.setValue(backlogInstance);
            pvv.moveToAdd();
        }

        {
            backlogInstance = alphaBacklog.createInstance("backlog2");
            backlogInstance.setAttribute("type", "Epic");
            backlogInstance.setAttribute("parent", "backlog1");

            pvv.setValue(backlogInstance);
            pvv.moveToAdd();
        }


        {
            backlogInstance = alphaBacklog.createInstance("backlog3");
            backlogInstance.setAttribute("type", "Task");
            backlogInstance.setAttribute("parent", "backlog2");

            pvv.setValue(backlogInstance);
        }

        instance.set(alphaBacklog.getName(), pvv);
        instance.putRoleMapping(activityInEssenceDefinition.getCompetency().getName(), "jane");

        instance.execute();


        assertExecutionPathEquals("Running Before Event", new String[]{
                "a9",       "a1", "a1", "a1",
        }, instance);

        instance.setExecutionScope("0");

        try {
            instance.getProcessDefinition().fireMessage(essenceActivity.getMessage(), instance, null);

            fail(NotCompletableException.class.getName() + " should be raised before checking checkpoints.");
        }catch (NotCompletableException shouldBeRaised){

        }

        //checking checkpoints currently reached state
        {
            AlphaInstance alphaInstanceOfSub1 = alphaBacklog.getInstances(instance).get(0);

            for(CheckPoint point : alphaBacklog.getStates().get(0).getCheckPoints()){
                alphaInstanceOfSub1.setChecked(point.getName());

                //point.setChecked(alphaInstanceOfSub1);
            }
        }


        //Now, it should be completable


        ResultPayload resultPayload = new ResultPayload();

        LanguageElementInstance sprint1 = sprint.createInstance("sprint1");
        sprint1.setAttribute("iteration", 1);

        resultPayload.setProcessVariableChange(new KeyedParameter(sprint.getName(), sprint1));

        instance.getProcessDefinition().fireMessage(essenceActivity.getMessage(), instance, resultPayload);

        assertExecutionPathEquals("With Execution Scope 0", new String[]{
                "a9", "a1", "a1", "a1", "a2", "a3"
        }, instance);



        instance.setExecutionScope("1");

        //checking checkpoints currently reached state
        {
            AlphaInstance alphaInstanceOfSub1 = alphaBacklog.getInstances(instance).get(0);

            for(CheckPoint point : alphaBacklog.getStates().get(0).getCheckPoints()){
                alphaInstanceOfSub1.setChecked(point.getName());

                //point.setChecked(alphaInstanceOfSub1);
            }
        }

        resultPayload = new ResultPayload();

        LanguageElementInstance sprint2 = sprint.createInstance("sprint2");
        sprint2.setAttribute("iteration", 2);

        resultPayload.setProcessVariableChange(new KeyedParameter(sprint.getName(), sprint2));


        instance.getProcessDefinition().fireMessage(essenceActivity.getMessage(), instance, resultPayload);

        assertExecutionPathEquals("With Execution Scope 1", new String[]{
                "a9",       "a1", "a1", "a1",   "a2", "a3",   "a2", "a3"
        }, instance);



        instance.setExecutionScope("2");

        //checking checkpoints currently reached state
        {
            AlphaInstance alphaInstanceOfSub1 = alphaBacklog.getInstances(instance).get(0);

            for (CheckPoint point : alphaBacklog.getStates().get(0).getCheckPoints()) {
                alphaInstanceOfSub1.setChecked(point.getName());

                //point.setChecked(alphaInstanceOfSub1);
            }
        }

        resultPayload = new ResultPayload();

        LanguageElementInstance sprint3 = sprint.createInstance("sprint3");
        sprint3.setAttribute("iteration", 3);

        resultPayload.setProcessVariableChange(new KeyedParameter(sprint.getName(), sprint3));


        instance.getProcessDefinition().fireMessage(essenceActivity.getMessage(), instance, resultPayload);

        assertExecutionPathEquals("With Execution Scope 2", new String[]{
                "a9",       "a1", "a1", "a1",   "a2", "a3",   "a2", "a3",  "a2", "a3",   "sub", "a7"
        }, instance);


        List<AlphaInstance> alphaInstanceList = alphaBacklog.getInstances(instance);

        for(AlphaInstance alphaInstance : alphaInstanceList){
            System.out.println(alphaInstance.getId()+":  "+ alphaInstance.getCurrentStateName());
        }

        List<? extends LanguageElementInstance> sprintInstances = sprint.getInstances(instance);

        for(LanguageElementInstance sprintInstance : sprintInstances){
            System.out.println(sprintInstance.getId()+":  "+ sprintInstance.getAttribute("iteration"));
        }



        //TODO:  user interface generation for Parameter Values - that is LanguageElementInstance : may be ok.
        //TODO:  sub in sub scoping :  main-sub-sub-sub scoping for execution scope system
        //TODO:  rolemapping is also needed to be scoped (in db persistence)

    }
}
