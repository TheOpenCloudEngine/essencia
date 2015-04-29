package org.uengine.essencia.modeling.palette;

import org.uengine.kernel.designer.ui.DataObjectActivityView;
import org.uengine.kernel.designer.ui.DataStoreActivityView;
import org.uengine.modeling.Palette;
import org.uengine.modeling.SymbolFactory;

public class DataPalette extends Palette {

	public DataPalette(){
		this.setName("Data");
		initPallet();
	}
	
	@Override
	protected void initPallet() {
		this.getSymbolList().add(SymbolFactory.create(DataObjectActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(DataStoreActivityView.class));
	}

}
