package org.uengine.essencia.modeling.palette;

import org.uengine.kernel.designer.ui.PoolView;
import org.uengine.kernel.designer.ui.RoleView;
import org.uengine.modeling.Palette;
import org.uengine.modeling.SymbolFactory;

public class SwimlanePalette extends Palette {

	public SwimlanePalette(){
		this.setName("SwimlanePalette");
		initPallet();
	}
	
	
	@Override
	protected void initPallet() {
		this.getSymbolList().add(SymbolFactory.create(PoolView.class));
		this.getSymbolList().add(SymbolFactory.create(RoleView.class));
	}

}
