package org.uengine.essencia.modeling.editor;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.resource.IModelResource;
import org.uengine.essencia.resource.Resource;
import org.uengine.modeling.IResource;

public class ModelerEditorTest {
	static List<EssenciaModelerEditor> editorList = new ArrayList<EssenciaModelerEditor>();

	public ModelerEditorTest() {
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/*IResource r = Resource.newInstance("junittets"+File.separator+"test.practice");
		PracticeDefinition temp = new PracticeDefinition();
		((IModelResource)r).saveResource(temp);
		EssenciaModelerEditor definerEditor = new DefinerEditor(r);
		editorList.add(definerEditor);
		
		IResource r1 = Resource.newInstance("junittets"+File.separator+"test.method");
		PracticeDefinition temp1 = new PracticeDefinition();
		((IModelResource)r1).saveResource(temp1);
		EssenciaModelerEditor composerEditor = new ComposerEditor(r1);
		editorList.add(composerEditor);*/
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		File pfile = new File(Resource.getCodebase() + "junittets"+File.separator+"test.practice");
		pfile.delete();
		File mfile = new File(Resource.getCodebase() + "junittets"+File.separator+"test.method");
		mfile.delete();
		File tempFolder = new File(Resource.getCodebase() + "junittets");
		tempFolder.delete();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		File pfile = new File(Resource.getCodebase() + "junittets"+File.separator+"test.practice");
		pfile.delete();
		File mfile = new File(Resource.getCodebase() + "junittets"+File.separator+"test.method");
		mfile.delete();
	}

	@Test
	public void testloadModel() {
		for(EssenciaModelerEditor editor : editorList){
			try {
				assertNotNull(editor.loadModel());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testCreateModeler() {
		for(EssenciaModelerEditor editor : editorList){
			editor.createModeler();
			assertNotNull(editor.getModeler());
		}
	}

}
