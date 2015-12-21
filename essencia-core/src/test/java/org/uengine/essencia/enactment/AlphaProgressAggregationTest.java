package org.uengine.essencia.enactment;

import org.metaworks.component.SelectBox;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.model.*;
import org.uengine.kernel.Activity;
import org.uengine.kernel.*;
import org.uengine.kernel.bpmn.SequenceFlow;
import org.uengine.kernel.bpmn.SubProcess;
import org.uengine.kernel.test.UEngineTest;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlphaProgressAggregationTest extends UEngineTest{

   /**
    * build a practice as follows:
    *
    *           Work
    *              |
    *              +-- Sprint
    *
    *
    *  * State mappings are as follows:
    *
    *       Work::a == Sprint::x  (overrided by next)
    *       Work::b == Sprint::x
    *       Work::c == Sprint::y  (overrided by next)
    *       Work::d == Sprint::y
    *       Work::e == Sprint::z
    *
    *
    *   ** Work is a kernel alpha
    *
    *
    *  Assume there are multiple Sprint instances:
    *
    *       sprint1 (in state: y)
    *       sprint2 (in state: y)
    *       sprint3 (in state: z)
    *
    *  Then, The aggregated kernel alpha view is expected as follows:
    *
    *       Work
    *         |
    *         a   ---  (0/3)
    *         |
    *         b   ---  (0/3)
    *         |
    *         c   ---  (0/3)   <=== not 2/3 must be 0/3. since the sum of currently working states should be same as the total number of instances
    *         |
    *         d   ---  (2/3)
    *         |
    *         e   ---  (1/3)
    *
    *
    *
    * @throws Exception
    */

    public void testCase1() throws Exception {


        Alpha workAlpha = new Alpha();
        workAlpha.setName("Work");


        List<State> statesOfWork = new ArrayList<State>();

        for(String stateName : new String[]{"Initiated", "Prepared", "Started", "UnderControl", "Concluded",  "Closed"})
        {
            State state = new State();
            statesOfWork.add(state);
            state.setName(stateName);

            List<CheckPoint> checkPoints = new ArrayList<CheckPoint>();

            {
                CheckPoint point = new CheckPoint();
                point.setName("checkpoint1 of "+ stateName);

                checkPoints.add(point);
            }

            state.setCheckPoints(checkPoints);

            state.setParentAlpha(workAlpha); //TODO: should be removed. alpha.setList should do this.
        }

        workAlpha.setStates(statesOfWork);

        Alpha sprintAlpha = new Alpha();
        sprintAlpha.setName("Sprint");

        List<State> statesOfSprint = new ArrayList<State>();

        for(String stateName : new String[]{"open", "doing", "done"})
        {
            State state = new State();
            statesOfSprint.add(state);
            state.setName(stateName);

            List<CheckPoint> checkPoints = new ArrayList<CheckPoint>();

            {
                CheckPoint point = new CheckPoint();
                point.setName("checkpoint1 of "+ stateName);

                checkPoints.add(point);
            }

            state.setCheckPoints(checkPoints);

            state.setParentAlpha(sprintAlpha); //TODO: should be removed. alpha.setList should do this.
        }

        workAlpha.setChildElements(new ArrayList<LanguageElement>());
        workAlpha.getChildElements().add(sprintAlpha);

        sprintAlpha.setStates(statesOfSprint);


        sprintAlpha.getStates().get(0).setAggregationAlphaState("Prepared");
        sprintAlpha.getStates().get(1).setAggregationAlphaState("UnderControl");
        sprintAlpha.getStates().get(2).setAggregationAlphaState("Closed");


        ProcessDefinition processDefinition = new ProcessDefinition();

        LanguageElementInstance defaultWorkAlphaInstance = workAlpha.createObjectInstance();
        defaultWorkAlphaInstance.setId("main");
        ProcessVariable pvAlphaWork = new ProcessVariable(new Object[]{
                "name", workAlpha.getName(),
                "type", AlphaInstance.class,
                "defaultValue", (Serializable)defaultWorkAlphaInstance
        });

        pvAlphaWork.setDefaultValue(defaultWorkAlphaInstance);

        ProcessVariable pvSprint = new ProcessVariable(new Object[]{
                "name", sprintAlpha.getName(),
                "type", LanguageElementInstance.class,
        });

        processDefinition.setProcessVariables(new ProcessVariable[]{
                pvAlphaWork, pvSprint
        });


        ProcessInstance.USE_CLASS = DefaultProcessInstance.class;
        ProcessInstance instance = processDefinition.createInstance();

        ProcessVariableValue pvvForSprint = new ProcessVariableValue();
        pvvForSprint.setName(pvSprint.getName());

        AlphaInstance sprint1 = sprintAlpha.createObjectInstance();
        sprint1.setId("sprint1");
        AlphaInstance sprint2 = sprintAlpha.createObjectInstance();
        sprint2.setId("sprint2");
        AlphaInstance sprint3 = sprintAlpha.createObjectInstance();
        sprint3.setId("sprint3");

        pvvForSprint.setValue(sprint1);
        pvvForSprint.moveToAdd();

        pvvForSprint.setValue(sprint2);
        pvvForSprint.moveToAdd();

        pvvForSprint.setValue(sprint3);
        pvvForSprint.moveToAdd();

        instance.set("", pvvForSprint);


        //advancing state to "y" (completing checkpoints for state "x") for sprint 1,2,3 (all sprints)
        {
            for(CheckPoint point : sprintAlpha.findState("open").getCheckPoints()){
                sprint1.setChecked(point.getName());
                sprint2.setChecked(point.getName());
                sprint3.setChecked(point.getName());
            }

            sprint1.calculateState();
        }

        //advancing state to "z" for sprint 3 only
        {
            for(CheckPoint point : sprintAlpha.findState("doing").getCheckPoints()){
                sprint3.setChecked(point.getName());
            }

            sprint3.calculateState();
        }


        //now get the workAlpha and investigate how it is effected by sprint alpha.
        List<AlphaInstance> workAlphaInstances = workAlpha.getInstances(instance);
        AlphaInstance workAlphaInstance = workAlphaInstances.get(0);


        ArrayList<Integer> runningCountsByState = new ArrayList<Integer>();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(0);
        expected.add(0);
        expected.add(2);
        expected.add(0);
        expected.add(1);


        workAlphaInstance.aggregateStateDetails(instance);

        for(State state : workAlpha.getStates()){
            Integer currentCount = (Integer) workAlphaInstance.getStateDetails(state.getName(), "WIPCount");

            if(currentCount==null)
                currentCount = 0;

            System.out.println(state.getName() + " (" + currentCount + "/" + workAlphaInstance.getSubAlphaInstanceCount() + ")");

            runningCountsByState.add(currentCount);
        }

        assertEquals(expected, runningCountsByState);

    }
}
