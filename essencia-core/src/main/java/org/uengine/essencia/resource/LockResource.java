package org.uengine.essencia.resource;

import java.io.File;

import org.uengine.essencia.IUser;
import org.uengine.essencia.common.LockInfo;
import org.uengine.essencia.repository.ObjectRepository;
import org.uengine.modeling.resource.IResource;

public class LockResource extends Resource {

	private static final String LOCK_SUFFIX = ".lock";

	public LockResource(IResource resource) {
		setPath(resource.getPath() + LOCK_SUFFIX);
	}

	public boolean exists(){
		return (new File(getAbsolutePath())).exists();
	}

	public void write(Object content) throws Exception {
		if(exists())
			throw new Exception("This resource is already locked.");

		ObjectRepository.getInstance().put(this, content);
	}

	public void delete(IUser user) throws Exception {
		if(!exists())
			throw new Exception("This resource is not locked.");

		if(!confirmLocker(user))
			throw new Exception("You can only unlock locker only.");

		delete();
	}

	public boolean confirmLocker(IUser user) {
		try {
			return user.equals(getLockInfo().getUser());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public LockInfo getLockInfo() throws Exception {
		if(exists()){
			try {
				return (LockInfo)ObjectRepository.getInstance().get(this);
			} catch (Exception e) {
				throw new Exception("Failed to fetch lock information.", e);
			}
		}

		throw new Exception("Lock information does not exist.");	
	}
}
