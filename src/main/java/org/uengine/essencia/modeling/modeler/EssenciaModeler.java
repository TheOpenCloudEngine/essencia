package org.uengine.essencia.modeling.modeler;

import java.util.List;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Available;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IModel;
import org.uengine.modeling.Modeler;
import org.uengine.modeling.Palette;
import org.uengine.modeling.RelationView;

/**
 * @author jyj
 */
public abstract class EssenciaModeler extends Modeler {

	private int lastTracingTag;
	
	public EssenciaModeler(){
		super();
	}
	
	public int getLastTracingTag() {
		return lastTracingTag;
	}
	public void setLastTracingTag(int lastTracingTag) {
		this.lastTracingTag = lastTracingTag;
	}
	
	@Override
	@Available(when={MetaworksContext.WHEN_EDIT, MetaworksContext.WHEN_NEW})
	public Palette getPalette() {
		return super.getPalette();
	}

	@Override
	public IModel getModel() throws Exception {
		if(this.model == null)
			this.model = createModel();
		
		return this.model;
	}

	public abstract IModel createModel() throws Exception;
	
	public List<ElementView> obtainElementViewList(){
		return getCanvas().getElementViewList();
	}
	
	public List<RelationView> obtainRelationViewList(){
		return getCanvas().getRelationViewList();
	}
	
}
