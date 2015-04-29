package org.uengine.essencia.modeling.palette;

import org.uengine.kernel.designer.ui.AssociationTransitionView;
import org.uengine.kernel.designer.ui.DataAssociationTransitionView;
import org.uengine.kernel.designer.ui.MessageTransitionView;
import org.uengine.kernel.designer.ui.TransitionView;
import org.uengine.modeling.Palette;

public class ConnectorPalette extends Palette {

	public ConnectorPalette(){
		this.setName("Connector!");
		initPallet();
	}
	
	@Override
	protected void initPallet() {
		this.getSymbolList().add(TransitionView.createSymbol());
		this.getSymbolList().add(MessageTransitionView.createSymbol());
		this.getSymbolList().add(DataAssociationTransitionView.createSymbol());
		this.getSymbolList().add(AssociationTransitionView.createSymbol());
	}

	
}
