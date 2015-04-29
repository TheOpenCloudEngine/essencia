package org.uengine.essencia.modeling.palette;

import org.uengine.essencia.modeling.EventSymbol;
import org.uengine.essencia.modeling.GatewaySymbol;
import org.uengine.essencia.modeling.TaskSymbol;
import org.uengine.kernel.designer.ui.DefaultActivityView;
import org.uengine.kernel.designer.ui.GatewayActivityView;
import org.uengine.kernel.designer.ui.LoopActivityView;
import org.uengine.kernel.designer.ui.RoleView;
import org.uengine.kernel.designer.ui.StartActivityView;
import org.uengine.kernel.designer.ui.TransitionView;
import org.uengine.modeling.Palette;
import org.uengine.modeling.Symbol;
import org.uengine.modeling.SymbolFactory;

public class SimplePalette extends Palette {

	public SimplePalette(){
		
	}
	
	
	public SimplePalette(String type){
		this.setName("BPMN Diagram");
		setType(type);
		initPallet();
	}
	
	@Override
	protected void initPallet() {
		
		Symbol symbol=SymbolFactory.create(StartActivityView.class, EventSymbol.class);
		symbol.setName("Evenet");
		this.getSymbolList().add(symbol);
		
		symbol=SymbolFactory.create(DefaultActivityView.class, getType(), TaskSymbol.class);
		symbol.setName("Default");
		this.getSymbolList().add(symbol);
		
		symbol=SymbolFactory.create(GatewayActivityView.class, GatewaySymbol.class);
		symbol.setName("Gateway");
		this.getSymbolList().add(symbol);
		
		this.getSymbolList().add(SymbolFactory.create(LoopActivityView.class));
		
//		this.getSymbolList().add(SymbolFactory.create(PoolView.class));
		this.getSymbolList().add(SymbolFactory.create(RoleView.class));
//		this.getSymbolList().add(SymbolFactory.create(DataObjectActivityView.class));
//		this.getSymbolList().add(SymbolFactory.create(DataStoreActivityView.class));
//		this.getSymbolList().add(SymbolFactory.create(AnnotationActivityView.class));
//		this.getSymbolList().add(SymbolFactory.create(ScopeActivityView.class));
		
		this.getSymbolList().add(TransitionView.createSymbol());
		
	}
}
