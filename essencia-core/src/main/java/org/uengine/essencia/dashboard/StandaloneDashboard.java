package org.uengine.essencia.dashboard;

import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.PracticeDefinition;

import java.util.HashMap;
import java.util.List;

public class StandaloneDashboard {

    public StandaloneDashboard() throws Exception {

		PracticeDefinition practiceDefinition = new PracticeDefinition();

		setDashboard(new Dashboard(practiceDefinition));

		ExampleAlphaInstance exampleAlphaInstance = new ExampleAlphaInstance();

		AlphaInstance alphaInstance = exampleAlphaInstance.getAlphaInstance();

		getDashboard().setAlphaInstanceMap(new HashMap<String, List<AlphaInstance>>());

		getDashboard().getAlphaInstanceMap().put(alphaInstance.getAlpha().getName(), alphaInstance.getAlpha().getInstances(exampleAlphaInstance.getProcessInstance()));
		getDashboard().setAlphas(new Alpha[]{alphaInstance.getAlpha()});
	}

	private AlphaInstance generateAlphaInstance() throws Exception {
		return new ExampleAlphaInstance().getAlphaInstance();
	}


	Dashboard dashboard;
		public Dashboard getDashboard() {
			return dashboard;
		}
		public void setDashboard(Dashboard dashboard) {
			this.dashboard = dashboard;
		}

}