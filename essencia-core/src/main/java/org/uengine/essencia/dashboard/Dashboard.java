package org.uengine.essencia.dashboard;

import java.util.List;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.State;

/**
 * Dashboard
 * 
 * @author lenovo
 *
 */
@Face(ejsPath = "org/uengine/essencia/dashboard/Dashboard.ejs")
public class Dashboard implements ContextAware {

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

    private MetaworksContext metaworksContext;

    private PracticeDefinition practiceDefinition;

    public PracticeDefinition getPracticeDefinition() {
	return practiceDefinition;
    }

    public void setPracticeDefinition(PracticeDefinition practiceDefinition) {
	this.practiceDefinition = practiceDefinition;
    }

    private Alpha[] alphas;

    public MetaworksContext getMetaworksContext() {
	return metaworksContext;
    }

    public void setMetaworksContext(MetaworksContext metaworksContext) {
	this.metaworksContext = metaworksContext;
    }

    public Alpha[] getAlphas() {
	return alphas;
    }

    public void setAlphas(Alpha[] alphas) {
	this.alphas = alphas;
    }

}