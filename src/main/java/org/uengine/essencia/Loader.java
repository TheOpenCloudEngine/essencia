package org.uengine.essencia;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;

public class Loader {

	String userId;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}

    @ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_SELF)
	public Object run() throws Exception {
		Essencia essencia = new Essencia();
		essencia.init(this.getUserId());
		return essencia;
	}
}
