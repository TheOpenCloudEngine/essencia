package org.uengine.essencia;

public class Session {

	IUser user;
		public IUser getUser() {
			return user;
		}
		public void setUser(IUser user) {
			this.user = user;
		}
		
	public Session(){
		
	}
	
	public Session(String userId){
		User user = new User();
		user.setEmpCode(userId);
		try {
			user.copyFrom(user.databaseMe());
		} catch (Exception e) {
			user.setEmpCode(userId);
			user.setEmail("test@uengine.org");
			user.setEmpName("tester");
		}
		
		this.setUser(user);
	}
	
}
