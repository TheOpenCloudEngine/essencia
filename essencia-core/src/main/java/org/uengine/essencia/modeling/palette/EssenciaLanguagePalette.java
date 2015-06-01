package org.uengine.essencia.modeling.palette;


import org.uengine.essencia.model.view.ActivitySpaceView;
import org.uengine.essencia.model.view.ActivityView;
import org.uengine.essencia.model.view.AlphaView;
import org.uengine.essencia.model.view.CompetencyView;
import org.uengine.essencia.model.view.PracticeView;
import org.uengine.essencia.model.view.WorkProductView;
import org.uengine.modeling.Palette;

public class EssenciaLanguagePalette extends Palette{
		
	public EssenciaLanguagePalette(){
		setName("Essence Language");

		addSymbol(PracticeView.class);
		addSymbol(AlphaView.class);
		addSymbol(ActivitySpaceView.class);
		addSymbol(ActivityView.class);
		addSymbol(CompetencyView.class);
		addSymbol(WorkProductView.class);

		
	}
}
