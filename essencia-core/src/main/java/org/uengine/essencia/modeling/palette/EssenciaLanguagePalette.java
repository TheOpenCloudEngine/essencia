package org.uengine.essencia.modeling.palette;


import org.uengine.essencia.model.view.ActivitySpaceView;
import org.uengine.essencia.model.view.ActivityView;
import org.uengine.essencia.model.view.AlphaView;
import org.uengine.essencia.model.view.CompetencyView;
import org.uengine.essencia.model.view.PracticeView;
import org.uengine.essencia.model.view.WorkProductView;
import org.uengine.modeling.Palette;
import org.uengine.modeling.Symbol;
import org.uengine.modeling.SymbolFactory;

public class EssenciaLanguagePalette extends Palette{
		
	public EssenciaLanguagePalette(){
		setName("Essence Language");
		initPallet();
	}
	
	@Override
	protected void initPallet() {
		Symbol symbol = SymbolFactory.create(PracticeView.class);
		symbol.setName("Practice");
		this.getSymbolList().add(symbol);
		
		symbol = SymbolFactory.create(AlphaView.class);
		symbol.setName("Alpha");
		this.getSymbolList().add(symbol);
		
		symbol = SymbolFactory.create(ActivitySpaceView.class);
		symbol.setName("ActivitySpace");
		this.getSymbolList().add(symbol);
		
		symbol = SymbolFactory.create(ActivityView.class);
		symbol.setName("Activity");
		this.getSymbolList().add(symbol);
		
		symbol = SymbolFactory.create(CompetencyView.class);
		symbol.setName("Competency");
		this.getSymbolList().add(symbol);
		
		symbol = SymbolFactory.create(WorkProductView.class);
		symbol.setName("WorkProduct");
		this.getSymbolList().add(symbol);

		
	}
}
