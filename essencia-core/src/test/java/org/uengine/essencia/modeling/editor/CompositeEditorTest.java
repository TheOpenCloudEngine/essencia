package org.uengine.essencia.modeling.editor;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.metaworks.MetaworksContext;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.resource.IModelResource;
import org.uengine.essencia.resource.Resource;
import org.uengine.modeling.IResource;

public class CompositeEditorTest {
	static List<CompositeEditor> editorList = new ArrayList<CompositeEditor>();

	public CompositeEditorTest() {
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IResource r = Resource.newInstance("junittets"+File.separator+"test.practice");
		PracticeDefinition temp = new PracticeDefinition();
		((IModelResource)r).saveResource(temp);
		PracticeDefinerEditor practiceEditor = new PracticeDefinerEditor();
		practiceEditor.loadNewEditor(r);
		editorList.add(practiceEditor);
		
		
		IResource r1 = Resource.newInstance("junittets"+File.separator+"test.method");
		r1.getMetaworksContext().setWhen(MetaworksContext.WHEN_NEW);
		PracticeDefinition temp1 = new PracticeDefinition();
		((IModelResource)r1).saveResource(temp1);
		MethodComposerEditor methodEditor = new MethodComposerEditor();
		methodEditor.loadNewEditor(r1);
		editorList.add(methodEditor);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		File pfile = new File(Resource.getCodebase() + "junittets"+File.separator+"test.practice");
		pfile.delete();
		File mfile = new File(Resource.getCodebase() + "junittets"+File.separator+"test.method");
		mfile.delete();
		File prfile = new File(Resource.getCodebase() + "junittets"+File.separator+"test.process");
		prfile.delete();
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
	public void testLoad() {
		for(CompositeEditor c : editorList){
			try {
				c.load();
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertNotNull(c.getItems());
			if(c.getItems().size() == 0){
				fail("ModelEditors are not set");
			}
			for(Editor editor : c.getItems()){
				ModelerEditor modelEditor = (ModelerEditor)editor;
				assertNotNull(modelEditor.getModeler());
			}
			assertNotNull(c.getItems());
		}
	}

	@Test
	public void testSave() {
		for(CompositeEditor c : editorList){
			try {
				c.save();
				
				IResource resource = c.getResource();
				
				assertNotNull(resource);
				assertNotNull(resource.getPath());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
