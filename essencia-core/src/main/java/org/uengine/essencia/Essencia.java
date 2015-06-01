package org.uengine.essencia;

import org.uengine.essencia.designer.Designer;
import org.uengine.essencia.i18n.Locale;
import org.uengine.kernel.GlobalContext;

public class Essencia {

	boolean loaded;
	IContent content;
	Locale locale;
	Session session;

	public boolean isLoaded() {
		return loaded;
	}
	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public IContent getContent() {
		return content;
	}
	public void setContent(IContent content) {
		this.content = content;
	}
	
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	public Essencia(){

	}
	
	public void init(String userId) throws Exception{
		this.setLoaded(true);
		this.setLocale(new Locale(GlobalContext.getPropertyString("essencia.defaultLanguage")));
		this.setContent(new Designer(this.getLocale()));
		this.setSession(new Session(userId));
	}

}
