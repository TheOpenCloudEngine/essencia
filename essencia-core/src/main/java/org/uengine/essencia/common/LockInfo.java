package org.uengine.essencia.common;

import java.io.Serializable;
import java.util.Date;

import org.metaworks.annotation.Face;
import org.uengine.essencia.IUser;

@Face(ejsPath="dwr/metaworks/genericfaces/FormFace.ejs")
public class LockInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	IUser user;
	Date lockDate;
	
	public LockInfo(IUser user, Date lockDate){
		this.user = user;
		this.lockDate = lockDate;
	}

	@Face(displayName="Lock User")
	public IUser getUser() {
		return user;
	}
	public void setUser(IUser user) {
		this.user = user;
	}
	
	@Face(displayName="Locked Date")
	public Date getLockDate() {
		return lockDate;
	}
	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}
}
