package org.uengine.essencia.modeling.canvas;

import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToAppend;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.essencia.repository.ObjectRepository;
import org.uengine.essencia.resource.element.EssenciaElementResource;
import org.uengine.essencia.resource.element.EssenciaResource;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.RelationView;
import org.uengine.modeling.Symbol;

public class PracticeCanvas extends EssenciaCanvas {

	public PracticeCanvas(){
		initPracticeView();
	}
	
	public PracticeCanvas(String modelerType){
		super(modelerType);
	}
	
	@Available(when={MetaworksContext.WHEN_NEW, MetaworksContext.WHEN_EDIT})
	@ServiceMethod(payload={"clipboard", "modelerType", "elementViewList"}, target=ServiceMethodContext.TARGET_APPEND, eventBinding=CANVAS_DROP)
	@Override
	public void drop() {
		
		ElementView elementView = null;	
		
		Object[] returnArr = initReturnArr();
		
		Object content = clipboard.getContent();
		
		if(content instanceof EssenciaKernelSymbol){
			elementView = makeElementViewFromEssenciaKernelSymbol((EssenciaKernelSymbol)content);

			try{
				if(validate(elementView)){
					returnArr[1] = new ToAppend(ServiceMethodContext.TARGET_SELF, elementView);
				}

			} catch (RuntimeException e ){
				e.printStackTrace();
				throw e;
			}

			MetaworksRemoteService.wrapReturn(returnArr);
		}else if(content instanceof Symbol){
			Symbol symbol = (Symbol)content;
			
			if("EDGE".equals(symbol.getShapeType())){
				RelationView relationView = makeRelationViewFromSymbol((Symbol)content);
				
				returnArr[1] = new ToAppend(ServiceMethodContext.TARGET_SELF, relationView);
				MetaworksRemoteService.wrapReturn( returnArr);
			}else{
				elementView = makeElementViewFromSymbol((Symbol)content);
				
				returnArr[1] = new ToAppend(ServiceMethodContext.TARGET_SELF, elementView);
				MetaworksRemoteService.wrapReturn( returnArr);
			}
			
			
			
		}else if(content instanceof EssenciaElementResource){
			elementView = makeElementViewFromResource(((EssenciaResource) content));
			
			if(validate(elementView)){
				returnArr[1] = new ToAppend(ServiceMethodContext.TARGET_SELF, elementView);
			}

			MetaworksRemoteService.wrapReturn(returnArr);
		}else{
			MetaworksRemoteService.wrapReturn( returnArr);
		}
	}
	
	private ElementView makeElementViewFromResource(EssenciaResource resource){
		PracticeDefinition practice = null;
		ElementView elementView = null;
		try {
			practice = (PracticeDefinition)ObjectRepository.getInstance().get(resource.getPath());
			elementView = ((BasicElement)practice.getElementByName(resource.getDisplayName())).asView();
			elementView.setFromEdge("");
			elementView.setToEdge("");
			elementView.setX("");
			elementView.setY("");
			elementView.setId("");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementView;
	}
	
}
