package org.uengine.essencia.common;

import org.uengine.essencia.IUser;

public interface Lockable {
	boolean isLocked();
	void lock(IUser user) throws Exception;
	void unlock(IUser user) throws Exception;
}
