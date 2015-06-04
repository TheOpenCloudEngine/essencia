package org.uengine.essencia.dashboard;

import java.util.List;
import java.util.Map;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.State;

/**
 * Dashboard
 * 
 * @author lenovo
 *
 */
public class Dashboard implements ContextAware {

	public Dashboard(){

	}

    public Dashboard(PracticeDefinition practiceDefinition) {
		metaworksContext = new MetaworksContext();
		metaworksContext.setWhere("dashboard");

		this.practiceDefinition = practiceDefinition;

		alphas = new Alpha[practiceDefinition.getElements(Alpha.class).size()];
		int ai = 0;
		for (Alpha al : practiceDefinition.getElements(Alpha.class)) {
			alphas[ai] = al;

			List<State> sts = al.getList();
			for (State st : sts) {
			System.out.println("concern=" + al.getConcern() + ", al=" + al.getName() + ", st=" + st.getName());
			}
			ai++;
		}

    }


    private PracticeDefinition practiceDefinition;
		public PracticeDefinition getPracticeDefinition() {
		return practiceDefinition;
		}
		public void setPracticeDefinition(PracticeDefinition practiceDefinition) {
			this.practiceDefinition = practiceDefinition;
		}

	private MetaworksContext metaworksContext;
		public MetaworksContext getMetaworksContext() {
		return metaworksContext;
		}
		public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
		}


	private Alpha[] alphas;
		public Alpha[] getAlphas() {
		return alphas;
		}
		public void setAlphas(Alpha[] alphas) {
		this.alphas = alphas;
		}


	private Map<String, List<AlphaInstance>> alphaInstanceMap;
		public Map<String, List<AlphaInstance>> getAlphaInstanceMap() {
			return alphaInstanceMap;
		}
		public void setAlphaInstanceMap(Map<String, List<AlphaInstance>> alphaInstanceMap) {
			this.alphaInstanceMap = alphaInstanceMap;
		}


	@ServiceMethod(callByContent = true)
	public void savePlan(){
		System.out.println(getAlphaInstanceMap());

	}
}