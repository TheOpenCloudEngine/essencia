package org.uengine.essencia.repository;

import java.util.HashMap;
import java.util.Map;

import org.uengine.essencia.resource.Resource;
import org.uengine.kernel.GlobalContext;

public class ObjectRepository {
	private static ObjectRepository instance = new ObjectRepository();
	//private Map<String, Object> repository;
	
	private ObjectRepository(){
		/*this.repository = new HashMap<String, Object>();*/
	}
	
	public static ObjectRepository getInstance(){
		return instance;
	}
	
	@Deprecated
	public Object get(String key) throws Exception {
		return this.get(key, false);
	}
		
	@Deprecated
	public Object get(String key, boolean fromCache) throws Exception {		
		return this.get(makeResource(key), fromCache);
	}

	public Object get(Resource resource) throws Exception {
		return this.get(resource, false);
	}
	
	public Object get(Resource resource, boolean fromCache) throws Exception {
		/*if(fromCache && this.repository.containsKey(resource.getPath()))
			return this.repository.get(resource.getPath());
*/
		return this.deserialize(resource);
	}

	
	public void put(Resource resource, Object value) throws Exception {
			this.serialize(resource, value);
			//this.repository.put(resource.getPath(), this.deserialize(resource));
	}

	private String serialize(Resource resource, Object value) throws Exception {
		try {
			String valueString = GlobalContext.serialize(value, value.getClass());
			resource.write(valueString);
			
			return valueString;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Deprecated
	private Resource makeResource(String key){
		Resource resource = (Resource)Resource.newInstance(key);
		return resource;
	}
	
	private Object deserialize(Resource resource) throws Exception {
		try {
			return GlobalContext.deserialize(resource.read());
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
