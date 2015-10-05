package org.uengine.essencia.dashboard;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.State;
import org.uengine.modeling.IElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.model.ActivitySpace;
import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.Competency;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Palette;

import com.thoughtworks.xstream.XStream;

/**
 * Dashboard
 * @author lenovo
 *
 */
@Face(ejsPath="org/uengine/essencia/dashboard/Dashboard.ejs")
public class Dashboard implements ContextAware {

	
	public Dashboard(PracticeDefinition practiceDefinition) {
		//
		metaworksContext = new MetaworksContext();
		metaworksContext.setWhere("dashboard");
		this.practiceDefinition = practiceDefinition;

		//this.practiceDefinition = getKernelDefinition(); //TODO example.practices 대입


		//
		List<Alpha> alphaList = new ArrayList<Alpha>();
		List<IElement> list = this.practiceDefinition.getElementList();
		for(IElement el : list){
			if(el instanceof Alpha){
				System.out.println("isAlpha=" + el.getName());
				alphaList.add((Alpha)el);
			}
		}
		alphas = new Alpha[alphaList.size()];
		int ai = 0;
		for(Alpha al : alphaList){
			alphas[ai] = al;
			
			List<State> sts = al.getStates();
			for(State st : sts){
				System.out.println("concern=" + al.getConcern()+ ", al=" + al.getName() + ", st=" + st.getName());
			}
			ai++;
		}
		
	
	}

	
	private MetaworksContext metaworksContext;
	
	private PracticeDefinition practiceDefinition;
	
	public PracticeDefinition getPracticeDefinition() {
		return practiceDefinition;
	}

	public void setPracticeDefinition(PracticeDefinition practiceDefinition) {
		this.practiceDefinition = practiceDefinition;
	}

	private Alpha[] alphas;

	public MetaworksContext getMetaworksContext() {
		return metaworksContext;
	}

	public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
	}
	
	public Alpha[] getAlphas() {
		return alphas;
	}

	public void setAlphas(Alpha[] alphas) {
		this.alphas = alphas;
	}


	public PracticeDefinition getKernelDefinition() {
		PracticeDefinition practice = null;
		try {
			InputStream is = getClass().getResourceAsStream("/org/uengine/essencia/model/kernel/sample.practice");
			XStream x = new XStream();
			InputStreamReader isr = new InputStreamReader(is);
			practice = (PracticeDefinition)x.fromXML(isr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return practice;
	}


}