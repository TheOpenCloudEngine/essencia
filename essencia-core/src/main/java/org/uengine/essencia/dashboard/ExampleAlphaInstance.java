package org.uengine.essencia.dashboard;


import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.CheckPoint;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.State;
import org.uengine.kernel.*;

import java.util.ArrayList;
import java.util.List;

public class ExampleAlphaInstance {

    AlphaInstance alphaInstance;

        public AlphaInstance getAlphaInstance() {
            return alphaInstance;
        }

        public void setAlphaInstance(AlphaInstance alphaInstance) {
            this.alphaInstance = alphaInstance;
        }

    ProcessInstance processInstance;
        public ProcessInstance getProcessInstance() {
            return processInstance;
        }

        public void setProcessInstance(ProcessInstance processInstance) {
            this.processInstance = processInstance;
        }


    public ExampleAlphaInstance() throws Exception {
        Alpha workAlpha = new Alpha();
        workAlpha.setName("Work");


        List<State> statesOfWork = new ArrayList<State>();

        for(String stateName : new String[]{"a", "b", "c", "d", "e"})
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
        sprintAlpha.setName("sprint");

        List<State> statesOfSprint = new ArrayList<State>();

        for(String stateName : new String[]{"x", "y", "z"})
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


        sprintAlpha.getStates().get(0).setAggregationAlphaState("b");
        sprintAlpha.getStates().get(1).setAggregationAlphaState("d");
        sprintAlpha.getStates().get(2).setAggregationAlphaState("e");


        ProcessDefinition processDefinition = new ProcessDefinition();

        LanguageElementInstance defaultWorkAlphaInstance = workAlpha.createObjectInstance();
        ProcessVariable pvAlphaWork = new ProcessVariable(new Object[]{
                "name", workAlpha.getName(),
                "type", AlphaInstance.class,
                //				"defaultValue", (Serializable)defaultWorkAlphaInstance
        });

        pvAlphaWork.setDefaultValue(defaultWorkAlphaInstance);

        ProcessVariable pvSprint = new ProcessVariable(new Object[]{
                "name", sprintAlpha.getName(),
                "type", LanguageElementInstance.class,
        });

        processDefinition.setProcessVariables(new ProcessVariable[]{
                pvAlphaWork, pvSprint
        });


        AbstractProcessInstance.USE_CLASS = DefaultProcessInstance.class;
        processInstance = processDefinition.createInstance();

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

        processInstance.set("", pvvForSprint);


        //advancing state to "y" (completing checkpoints for state "x") for sprint 1,2,3 (all sprints)
        {
            for(CheckPoint point : sprintAlpha.findState("x").getCheckPoints()){
                sprint1.setChecked(point.getName());
                sprint2.setChecked(point.getName());
                sprint3.setChecked(point.getName());
            }

            sprint1.calculateState(processInstance);
        }

        //advancing state to "z" for sprint 3 only
        {
            for(CheckPoint point : sprintAlpha.findState("y").getCheckPoints()){
                sprint3.setChecked(point.getName());
            }

            sprint3.calculateState(processInstance);
        }


        //now get the workAlpha and investigate how it is effected by sprint alpha.
        List<AlphaInstance> workAlphaInstances = workAlpha.getInstances(processInstance);
        AlphaInstance workAlphaInstance = workAlphaInstances.get(0);


        ArrayList<Integer> runningCountsByState = new ArrayList<Integer>();

        workAlphaInstance.aggregateStateDetails(processInstance);

        for(State state : workAlpha.getStates()){
            Integer currentCount = (Integer) workAlphaInstance.getStateDetails(state.getName(), "WIPCount");

            if(currentCount==null)
                currentCount = 0;

            System.out.println(state.getName() + " (" + currentCount + "/" + workAlphaInstance.getSubAlphaInstanceCount() + ")");

            runningCountsByState.add(currentCount);
        }

        setAlphaInstance(workAlphaInstance);


    }
}