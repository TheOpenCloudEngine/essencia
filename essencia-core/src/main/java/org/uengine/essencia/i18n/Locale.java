package org.uengine.essencia.i18n;

import java.util.Hashtable;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.metaworks.annotation.ServiceMethod;
	
public class Locale{
	
	static Hashtable<String, Properties> webMessageBundles = new Hashtable<String, Properties>();

	String language;
		public String getLanguage() {
			return language;
		}	
		public void setLanguage(String language) {
			this.language = language;
		}
		
	Properties resourceBundle;		
		public Properties getResourceBundle() {
			return resourceBundle;
		}	
		public void setResourceBundle(Properties resourceBundle) {
			this.resourceBundle = resourceBundle;
		}

	public Locale(String lang){
		setLanguage(lang);
		//load();
	}

	
	
	@ServiceMethod(payload={"language"})
	public void load(){		
		// default language setting
		String language = "en";		
		if(this.getLanguage() != null)
			language = this.getLanguage();
		
		if("en-US".equals(language))	language = "en"; 
		
		if (!webMessageBundles.containsKey(language)) {
			java.util.Locale locale = new java.util.Locale(language);
			PropertyResourceBundle propertyResourceBundle = (PropertyResourceBundle) PropertyResourceBundle.getBundle("org.uengine.essencia.i18n.messages", locale, getClass().getClassLoader());
			
			Properties props = new Properties();
			for(String key : propertyResourceBundle.keySet()){
				props.put(key, propertyResourceBundle.getString(key));
			}
			
			webMessageBundles.put(language, props);
		}
		
		resourceBundle = webMessageBundles.get(language);		
	}
	
	public String getString(String... keys) throws Exception {
	
		String message = keys[0];
		
		if(message.startsWith("$")){
			message = resourceBundle.getProperty(message.substring(1));			
			message = (message == null) ? keys[0] : message;
		}
		
		 Pattern p = Pattern.compile("%s");
		 CharSequence cs = new StringBuffer(message);
		 Matcher m = p.matcher(cs);
		 int count = 0;
		 while(m.find()) {
			 count++;
		 }	
	
		 if(count > 0 && count != keys.length - 1)
				throw new Exception("$NotEqualToFormatCountAndArgumentCount");
		
		if(keys.length == 1)
			return message;	
		
		StringBuffer sb = new StringBuffer();
		count = 0;
		m.reset();
        while (m.find()) {
        	String key = keys[1 + count++];
			key = this.getString(key);
        	
            m.appendReplacement(sb, key);
        }
        m.appendTail(sb);
        
        return sb.toString();
	}
}
