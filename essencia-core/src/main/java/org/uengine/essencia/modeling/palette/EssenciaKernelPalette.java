package org.uengine.essencia.modeling.palette;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.model.*;
import org.uengine.essencia.model.view.KernelLanguageViewable;
import org.uengine.essencia.model.view.LanguageElementView;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Palette;

import com.thoughtworks.xstream.XStream;

public class EssenciaKernelPalette extends Palette{
		
	public EssenciaKernelPalette(){
		setName("Kernel Palette");
		PracticeDefinition practice = null;
		try {
			InputStream is = getClass().getResourceAsStream("/org/uengine/essencia/model/kernel/kernel.practice");
			XStream x = new XStream();
			InputStreamReader isr = new InputStreamReader(is);
			practice = (PracticeDefinition)x.fromXML(isr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<EssenciaKernelSymbol> alphas = new ArrayList<EssenciaKernelSymbol>();
		List<EssenciaKernelSymbol> activitySpaces = new ArrayList<EssenciaKernelSymbol>();
		List<EssenciaKernelSymbol> competencies = new ArrayList<EssenciaKernelSymbol>();


		for(IElement element : practice.getElementList()){
			EssenciaKernelSymbol symbol = null;
			KernelLanguageViewable view;
			try {
				view = (KernelLanguageViewable)Thread.currentThread().getContextClassLoader().loadClass(element.getElementView().getClass().getName()).newInstance();
				symbol = view.createKernelSymbol();
				symbol = fill(symbol, element);

				if(element instanceof Alpha){
					alphas.add(symbol);
				}else if (element instanceof ActivitySpace){
					activitySpaces.add(symbol);
				}else if (element instanceof Competency){
					competencies.add(symbol);
				}

			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		getSymbolList().addAll(alphas);
		getSymbolList().addAll(activitySpaces);
		getSymbolList().addAll(competencies);


	}

	private EssenciaKernelSymbol fill(EssenciaKernelSymbol symbol, IElement element){
		symbol.setName(element.getName());
		symbol.setLanguageElementView( (LanguageElementView)((BasicElement)element).asView());
		return symbol;
	}

}