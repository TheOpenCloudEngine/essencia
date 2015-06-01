package org.uengine.essencia.resource;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.uengine.modeling.IContainer;
import org.uengine.modeling.IResource;

public class ResourceTest {
	static List<IResource> resourceList = new ArrayList<IResource>();
	public ResourceTest() {
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		IResource testResource1 = new Resource("junittets"+File.separator+"EssenceScrum.practice");
		resourceList.add(testResource1);
//		getName : EssenceScrum.practice
//		getDisplayName:EssenceScrum
//		getType : practice

		IResource testResource2 = new Resource("junittets"+File.separator+"abc"+File.separator+"EssenceScrum.practice");
		resourceList.add(testResource2);
//		getName : EssenceScrum.practice
//		getDisplayName:EssenceScrum
//		getType : practice


		IResource testResource3 = new Resource("junittets");
		resourceList.add(testResource3);
//		getName : practices
//		getDisplayName:practices
//		getType : folder


		IResource testResource4 = new Resource("junittets"+File.separator+"abc");
		resourceList.add(testResource4);
//		getName : abc
//		getDisplayName:abc
//		getType : folder
		
		IResource testResource5 = new Resource("/junittets");
		resourceList.add(testResource5);
//		getName : practices
//		getDisplayName:practices
//		getType : folder
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		File tempFolder = new File(Resource.getCodebase() + "junittets");
		tempFolder.delete();
	}

	@Before
	public void setUp() throws Exception {
		

		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetPath() {
		for(IResource r : resourceList){
			assertNotNull(r.getPath());
		}
	}

	@Test
	public void testGetName() {
		for(IResource r : resourceList){
			if(r.getName().contains(File.separator)){
				fail("resource name is not suitable");
			}
			if(r instanceof IContainer){
				if(r.getDisplayName().contains(".")){
					fail("folder resource name has comma");
				}
			}
		}
	}

	@Test
	public void testGetDisplayName() {
		for(IResource r : resourceList){
			if(r.getDisplayName().contains(File.separator)){
				fail("resource displayName has File.separator");
			}
			if(r.getDisplayName().contains(".")){
				fail("resource displayName has comma");
			}
		}
	}

	@Test
	public void testRename() {
		String oldDisplayName = "";
		String newDisplayName = "ULTRANEWNAME";
		for(IResource r : resourceList){
			oldDisplayName = r.getDisplayName();
			r.rename(newDisplayName);
			assertNotEquals(oldDisplayName, r.getDisplayName());
			assertEquals(newDisplayName, r.getDisplayName());
		}
	}

	@Test
	public void testGetType() {
		for(IResource r : resourceList){
			if(r.getDisplayName().contains(File.separator)){
				fail("resource type has File.separator");
			}
			if(r.getDisplayName().contains(".")){
				fail("resource type has comma");
			}
			assertNotNull(r.getType());
		}
	}

	@Test
	public void testNewInstanceString() {
		for(IResource r : resourceList){
			IResource returnResource = Resource.newInstance(r.getPath());
			assertNotNull(returnResource.getPath());
			assertNotNull(returnResource.getDisplayName());
			assertNotNull(returnResource.getName());
			assertNotNull(returnResource.getType());
		}
	}

	@Test
	public void testNewPracticeFolderResourceString() {
		for(IResource r : resourceList){
			IResource returnResource = Resource.newPracticeFolderResource(r.getPath());
			assertNotNull(returnResource.getPath());
			assertNotNull(returnResource.getDisplayName());
			assertNotNull(returnResource.getName());
			assertNotNull(returnResource.getType());
		}
	}

	@Test
	public void testNewPracticeFolderResourceFile() {
		for(IResource r : resourceList){
			File file = new File(Resource.getCodebase() + r.getPath());
			IResource returnResource = Resource.newPracticeFolderResource(file);
			assertNotNull(returnResource.getPath());
			assertNotNull(returnResource.getDisplayName());
			assertNotNull(returnResource.getName());
			assertNotNull(returnResource.getType());
		}
	}

	@Test
	public void testNewMethodFolderResourceString() {
		for(IResource r : resourceList){
			IResource returnResource = Resource.newMethodFolderResource(r.getPath());
			assertNotNull(returnResource.getPath());
			assertNotNull(returnResource.getDisplayName());
			assertNotNull(returnResource.getName());
			assertNotNull(returnResource.getType());
		}
	}

	@Test
	public void testNewMethodFolderResourceFile() {
		for(IResource r : resourceList){
			File file = new File(Resource.getCodebase() + r.getPath());
			IResource returnResource = Resource.newMethodFolderResource(file);
			assertNotNull(returnResource.getPath());
			assertNotNull(returnResource.getDisplayName());
			assertNotNull(returnResource.getName());
			assertNotNull(returnResource.getType());
		}
	}

}
