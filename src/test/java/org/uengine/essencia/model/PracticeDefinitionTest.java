package org.uengine.essencia.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test;
import org.uengine.essencia.model.adapter.EssenceXmiAPI;
import org.uengine.essencia.resource.ModelResource;
import org.uengine.essencia.resource.Resource;

import com.thoughtworks.xstream.XStream;

public class PracticeDefinitionTest {
	
	PracticeDefinition pf = null;
	
	String xmiFile = "";

//	@Ignore
	@Test
	public void testToXmi(){
	/*	File f = new File("C:/essencia/codebase/practices/untitled.practice");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		XStream x = new XStream();
		PracticeDefinition pd = (PracticeDefinition)x.fromXML(fis);
		pd.afterDeserialize();
		
		EssenceXmiAPI exportable = new EssenceXmiAPI(pd);
		exportable.toXmi();
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	@Ignore
	@Test
	public void save(){
		File input = new File("C:/essencia/codebase/practices/untitled.practice");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		XStream x = new XStream();
		PracticeDefinition pd = (PracticeDefinition)x.fromXML(fis);
		//pd.afterDeserialize();
		
		File output = new File("C:/essencia/codebase/practices/aa.practice");
		ModelResource model = (ModelResource)Resource.newInstance(output);
		try {
			model.saveResource(pd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	@Test
	public void readXmi(){
	    EssenceXmiAPI importable = new EssenceXmiAPI(null);
	}
	
}
