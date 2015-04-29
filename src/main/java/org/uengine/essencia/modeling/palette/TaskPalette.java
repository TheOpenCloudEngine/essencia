package org.uengine.essencia.modeling.palette;

import org.uengine.kernel.designer.ui.DefaultActivityView;
import org.uengine.kernel.designer.ui.HumanActivityView;
import org.uengine.kernel.designer.ui.ManualActivityView;
import org.uengine.kernel.designer.ui.WebServiceActivityView;
import org.uengine.modeling.Palette;
import org.uengine.modeling.SymbolFactory;

public class TaskPalette extends Palette {

	public TaskPalette() {
		this.setName("TaskPalette");
	}
	public TaskPalette(String type) {
		this();
		setType(type);
		initPallet();
	}
	
	@Override
	protected void initPallet() {
		this.getSymbolList().add(SymbolFactory.create(DefaultActivityView.class, getType()));
		this.getSymbolList().add(SymbolFactory.create(HumanActivityView.class, getType()));
		this.getSymbolList().add(SymbolFactory.create(WebServiceActivityView.class, getType()));
		this.getSymbolList().add(SymbolFactory.create(ManualActivityView.class, getType()));
		
	}

}
