package org.uengine.essencia.util;

import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.model.BasicElement;
import org.uengine.modeling.*;

public class ElementUtil {
	
	/**
	 * List<IElement> convert to List<ElementView>
	 * @param elementList
	 * @return
	 */
	public static List<ElementView> convertToElementViewList(List<IElement> elementList){
		List<ElementView> list = new ArrayList<ElementView>();
			for(IElement element : elementList){
				list.add(((BasicElement)element).asView());
			}
		return list;
	}
	
	/**
	 * List<ElementView> convert to List<IElement>
	 * @param elementViewList
	 * @return
	 */
	public static List<IElement> convertToElementList(List<ElementView> elementViewList){
		List<IElement> list = new ArrayList<IElement>();
		for(ElementView view : elementViewList){
			list.add(view.asElement());
		}
		return list;
	}
	
	/**
	 * List<Relation> conver to List<RelationView>
	 * @param relationList
	 * @return
	 */
	public static List<RelationView> convertToRelationViewList(List<IRelation> relationList){
		List<RelationView> list = new ArrayList<RelationView>();
		for(IRelation relation : relationList){
			list.add(relation.asView());
		}
		return list;
	}
	
	/**
	 * List<RelationView> conver to List<Relation>
	 * @param relationViewList
	 * @return
	 */
	public static List<IRelation> convertToRelationList(List<RelationView> relationViewList){
		List<IRelation> list = new ArrayList<IRelation>();
		for(RelationView view : relationViewList){
			list.add((IRelation)view.asRelation());
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
