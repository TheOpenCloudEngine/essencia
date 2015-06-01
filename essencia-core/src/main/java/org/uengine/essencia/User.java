package org.uengine.essencia;

import org.metaworks.dao.Database;

public class User extends Database<IUser> implements IUser {

	String empCode;
		public String getEmpCode() {
			return empCode;
		}
		public void setEmpCode(String empCode) {
			this.empCode = empCode;
		}

	String empName;
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
	
	String email;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((empCode == null) ? 0 : empCode.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (super.equals(obj))
			return true;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (empCode == null) {
			if (other.empCode != null)
				return false;
		} else if (!empCode.equals(other.empCode))
			return false;
		return true;
	}
}
