package org.uengine.essencia.dashboard;

import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.CheckPoint;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.State;
import org.uengine.kernel.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StandaloneDashboard {

    public StandaloneDashboard() throws Exception {

		PracticeDefinition practiceDefinition = new PracticeDefinition();

		setDashboard(new Dashboard(practiceDefinition));


		AlphaInstance workAlphaInstance = generateAlphaInstance();


		getDashboard().setAlphaInstances(new AlphaInstance[]{workAlphaInstance});
		getDashboard().setAlphas(new Alpha[]{workAlphaInstance.getAlpha()});
	}

	private AlphaInstance generateAlphaInstance() throws Exception {
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

			state.setList(checkPoints);

			state.setParentAlpha(workAlpha); //TODO: should be removed. alpha.setList should do this.
		}

		workAlpha.setList(statesOfWork);

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

			state.setList(checkPoints);

			state.setParentAlpha(sprintAlpha); //TODO: should be removed. alpha.setList should do this.
		}

		workAlpha.setChildElements(new ArrayList<Alpha>());
		workAlpha.getChildElements().add(sprintAlpha);

		sprintAlpha.setList(statesOfSprint);


		sprintAlpha.getList().get(0).setAggregationAlphaState("b");
		sprintAlpha.getList().get(1).setAggregationAlphaState("d");
		sprintAlpha.getList().get(2).setAggregationAlphaState("e");


		ProcessDefinition processDefinition = new ProcessDefinition();

		LanguageElementInstance defaultWorkAlphaInstance = workAlpha.createInstance("main");
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

		AlphaInstance sprint1 = sprintAlpha.createInstance("sprint1");
		AlphaInstance sprint2 = sprintAlpha.createInstance("sprint2");
		AlphaInstance sprint3 = sprintAlpha.createInstance("sprint3");

		pvvForSprint.setValue(sprint1);
		pvvForSprint.moveToAdd();

		pvvForSprint.setValue(sprint2);
		pvvForSprint.moveToAdd();

		pvvForSprint.setValue(sprint3);
		pvvForSprint.moveToAdd();

		instance.set("", pvvForSprint);


		//advancing state to "y" (completing checkpoints for state "x") for sprint 1,2,3 (all sprints)
		{
			for(CheckPoint point : sprintAlpha.findState("x").getList()){
				sprint1.setChecked(point.getName());
				sprint2.setChecked(point.getName());
				sprint3.setChecked(point.getName());
			}

			sprint1.advanceState(instance);
			sprint2.advanceState(instance);
			sprint3.advanceState(instance);
		}

		//advancing state to "z" for sprint 3 only
		{
			for(CheckPoint point : sprintAlpha.findState("y").getList()){
				sprint3.setChecked(point.getName());
			}

			sprint3.advanceState(instance);
		}


		//now get the workAlpha and investigate how it is effected by sprint alpha.
		List<AlphaInstance> workAlphaInstances = workAlpha.getInstances(instance);
		AlphaInstance workAlphaInstance = workAlphaInstances.get(0);


		ArrayList<Integer> runningCountsByState = new ArrayList<Integer>();

		workAlphaInstance.aggregateStateDetails(instance);

		for(State state : workAlpha.getStates()){
			Integer currentCount = (Integer) workAlphaInstance.getStateDetails(state.getName(), "WIPCount");

			if(currentCount==null)
				currentCount = 0;

			System.out.println(state.getName() + " (" + currentCount + "/" + workAlphaInstance.getSubAlphaInstanceCount() + ")");

			runningCountsByState.add(currentCount);
		}

		return workAlphaInstance;
	}

	Dashboard dashboard;
		public Dashboard getDashboard() {
			return dashboard;
		}
		public void setDashboard(Dashboard dashboard) {
			this.dashboard = dashboard;
		}


}