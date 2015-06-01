package org.uengine.essencia.model.card;

import java.io.File;

public interface Card {
	
	String IMG_LOCATION = "resources" + File.separator + "images"+ File.separator + "symbol" + File.separator;
	String IMG_EXTENSION = ".png";
	String TERMINAL_IN_OUT = "_TERMINAL_C_INOUT_0";
	
	String getName();
	void setName(String name);
	
	String getParentName();
	void setParentName(String parentName);
	
	String getImg();
	void setImg(String img);
	
}
