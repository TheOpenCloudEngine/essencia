package org.uengine.essencia.modeling;

import org.uengine.essencia.model.view.LanguageElementView;
import org.uengine.modeling.Symbol;

public class EssenciaKernelSymbol extends Symbol{
	
	LanguageElementView languageElementView;
		public LanguageElementView getLanguageElementView() {
			return languageElementView;
		}
		public void setLanguageElementView(LanguageElementView languageElementView) {
			this.languageElementView = languageElementView;
		}

	public EssenciaKernelSymbol(){
		
	}
}
