package org.uengine.essencia.util;

import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Relation;
import org.uengine.modeling.RelationView;

public class ElementUtil {
	
	/**
	 * List<ElementView> convert to <LanguageElement>
	 * @param elementViewList
	 * @return
	 */
	public static List<LanguageElement> convertToLanguageElementList(List<ElementView> elementViewList){
		List<LanguageElement> elementList = new ArrayList<LanguageElement>();
			for(ElementView elementView : elementViewList){
				BasicElement languageElement = (BasicElement)elementView.getElement();
				elementView.setElement(null);
				languageElement.setElementView(elementView);
				elementList.add(languageElement);
			}
		return elementList;
	}
	
	/**
	 * List<IElement> convert to List<ElementView>
	 * @param elementList
	 * @return
	 */
	public static List<ElementView> convertToElementViewList(List<IElement> elementList){
		List<ElementView> list = new ArrayList<ElementView>();
			for(IElement e : elementList){
				ElementView view = e.getElementView();
				e.setElementView(null);
				view.setElement(e);
				list.add(view);
			}
		return list;
	}
	
	/**
	 * List<ElementView> convert to List<IElement>
	 * @param elementList
	 * @return
	 */
	public static List<IElement> convertToIElementList(List<ElementView> elementList){
		List<IElement> list = new ArrayList<IElement>();
		for(ElementView view : elementList){
			IElement e = view.getElement();
			view.setElement(null);
			e.setElementView(view);
			list.add(e);
		}
		return list;
	}
	
	/**
	 * List<Relation> conver to List<RelationView>
	 * @param relationList
	 * @return
	 */
	public static List<RelationView> convertToRelationViewList(List<Relation> relationList){
		List<RelationView> list = new ArrayList<RelationView>();
		for(Relation r : relationList){
			RelationView view = r.getRelationView();
			r.setRelationView(null);
			view.setRelation(r);
			list.add(view);
		}
		return list;
	}
	
	/**
	 * List<RelationView> conver to List<Relation>
	 * @param relationList
	 * @return
	 */
	public static List<Relation> convertToRelationList(List<RelationView> relationList){
		List<Relation> list = new ArrayList<Relation>();
		for(RelationView view : relationList){
			Relation r = (Relation)view.getRelation();
			view.setRelation(null);
			r.setRelationView(view);
			list.add(r);
		}
		return list;
	}
	
	public static <T> List<T> syncList(List<T> list){ 
		List<T> temp = new ArrayList<T>();
		for(T type : list){
			if(type == null){
				continue;
			}
			temp.add(type);
		}
		return temp;
		
	}
	
	public static <T extends BasicElement> List<T> syncList(List<T> list, String str){
		
		List<T> temp = new ArrayList<T>();
		for(T type : list){
			if(type == null || str.equals(type.getName().trim())){
				continue;
			}
			temp.add(type);
		}
		return temp;
		
	}
	
}
