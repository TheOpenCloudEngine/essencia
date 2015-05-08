package org.uengine.essencia.modeling.modeler;

import java.util.ArrayList;
import java.util.List;

import org.uengine.contexts.TextContext;
import org.uengine.essencia.modeling.canvas.ProcessCanvas;
import org.uengine.kernel.Activity;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.kernel.Role;
import org.uengine.kernel.UEngineException;
import org.uengine.kernel.graph.Transition;
import org.uengine.modeling.Canvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.IModel;
import org.uengine.modeling.IRelation;
import org.uengine.modeling.Palette;
import org.uengine.modeling.RelationView;

public class ProcessModeler extends EssenciaModeler {
	
	public final static String SUFFIX = ".process";
	
	public ProcessModeler() {
		setType(SUFFIX);
		this.setCanvas(new ProcessCanvas(getType()));
//		Palette palette = new SimplePalette(getType());
//		this.setPalette(palette);
	}
	
	@Override
	public void setModel(IModel model) throws Exception {
		List<ElementView> elementViewList = new ArrayList<ElementView>();
		List<RelationView> relationViewList = new ArrayList<RelationView>();

		ProcessDefinition def = (ProcessDefinition)model;
		
		for(IElement element : def.getChildActivities()){
			Activity activity = (Activity)element;
			ElementView elementView = activity.getElementView();
			activity.setElementView(null);
			elementView.setElement(activity);
			
			elementViewList.add(elementView);
		}
		
		for(IRelation relation : def.getTransitions()){
			Transition transition = (Transition) relation;
//			TransitionView transitionView = (TransitionView)transition.getRelationView();
			transition.setRelationView(null);
//			transitionView.setRelation(transition);
//			relationViewList.add(transitionView);
		}
		if(def.getRoles()!=null){
			
			for(Role role : def.getRoles()){
				if(role.getElementView() != null){
					ElementView elementView = role.getElementView();
					role.setElementView(null);
					elementView.setElement(role);
					
					TextContext text = role.getDisplayName();
					elementView.setLabel(text.getText());
					elementViewList.add(elementView);
				}
			}
			
		}
		
		this.getCanvas().setElementViewList(elementViewList);
		this.getCanvas().setRelationViewList(relationViewList);

	}
	
	protected void updateLastTracingTag(String tracingTag){
		int compareTracingTag = Integer.parseInt(tracingTag);
		
		if(this.getLastTracingTag() < compareTracingTag)
			this.setLastTracingTag(compareTracingTag);
	}
	
	@Override
	public IModel createModel() throws Exception {
		return makeProcessDefinitionFromCanvas(getCanvas());
	}
		
	public ProcessDefinition makeProcessDefinitionFromCanvas(Canvas canvas) throws Exception{
		ProcessDefinition def = new ProcessDefinition();
		
		for(ElementView elementView : canvas.getElementViewList()){
			if(elementView.getElement() instanceof Role){
				
				Role[] roles = null;
				Role role = (Role) elementView.getElement();
				elementView.setElement(null);
				role.setElementView(elementView);
				role.setName(elementView.getLabel());
				role.setDisplayName(elementView.getLabel());
				if(def.getRoles() == null){
					roles = new Role[1];
					roles[0] = role;
					def.setRoles(roles);
					
				}else{
					int prevLength = def.getRoles().length;
					def.addRole(role);
					if(prevLength == def.getRoles().length){
						throw new UEngineException("There are duplicated names among lanes.");
					}
				}
			}else if (elementView.getElement() instanceof Activity){
				Activity activity = (Activity)elementView.getElement();
				elementView.setElement(null);
				activity.setName(elementView.getLabel());
				activity.setElementView(elementView);
				def.addChildActivity(activity);
			}
				
		}
		
		for(RelationView relationView : this.getCanvas().getRelationViewList()){
			Transition transition = (Transition) relationView.getRelation();
			relationView.setRelation(null);
//			transition.setRelationView((TransitionView)relationView);
			def.addTransition(transition);
		}
		def.setPools(null);
		return def;
	}

	
}
