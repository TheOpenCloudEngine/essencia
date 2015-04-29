package org.uengine.essencia;

import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.Table;
import org.metaworks.dao.IDAO;

@Table(name = "emptable")
@Face(ejsPath="dwr/metaworks/genericfaces/FormFace.ejs")
public interface IUser extends IDAO{

	@Id
	@Hidden
	public String getEmpCode();
	public void setEmpCode(String empCode);
	
	@Face(displayName="Name")
	public String getEmpName();
	public void setEmpName(String empName);
	
	@Hidden
	public String getEmail();
	public void setEmail(String email);
	
}
