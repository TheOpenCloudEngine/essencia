package org.uengine.essencia.modeling.palette;

import org.uengine.kernel.designer.ui.EndActivityView;
import org.uengine.kernel.designer.ui.EndMessageActivityView;
import org.uengine.kernel.designer.ui.IntermediateActivityView;
import org.uengine.kernel.designer.ui.IntermediateConditionalActivityView;
import org.uengine.kernel.designer.ui.IntermediateFilledMessageActivityView;
import org.uengine.kernel.designer.ui.IntermediateMessageActivityView;
import org.uengine.kernel.designer.ui.IntermediateTimerActivityView;
import org.uengine.kernel.designer.ui.StartActivityView;
import org.uengine.kernel.designer.ui.StartConditionalActivityView;
import org.uengine.kernel.designer.ui.StartMessageActivityView;
import org.uengine.kernel.designer.ui.StartTimerActivityView;
import org.uengine.kernel.designer.ui.TerminateActivityView;
import org.uengine.modeling.Palette;
import org.uengine.modeling.SymbolFactory;

public class EventPalette extends Palette {

	public EventPalette(){
		this.setName("Event");
		initPallet();
	}
	
	@Override
	protected void initPallet() {
		this.getSymbolList().add(SymbolFactory.create(StartActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(IntermediateActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(EndActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(StartMessageActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(IntermediateMessageActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(IntermediateFilledMessageActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(EndMessageActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(StartTimerActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(IntermediateTimerActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(StartConditionalActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(IntermediateConditionalActivityView.class));
		this.getSymbolList().add(SymbolFactory.create(TerminateActivityView.class));
	}
}
