package org.uengine.essencia.modeling.modeler;

import org.uengine.essencia.modeling.canvas.MethodCanvas;
import org.uengine.essencia.modeling.palette.EssenciaPalette;

/**
 * @author jyj
 */
public class MethodComposer extends PracticeDefiner {
	
	public final static String SUFFIX = ".method";
	
	public MethodComposer() {
		setType(SUFFIX);
		setCanvas(new MethodCanvas());
		setPalette(new EssenciaPalette());
	}
	
}
