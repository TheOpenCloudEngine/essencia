package org.uengine.essencia;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.repository.ObjectRepository;
import org.uengine.essencia.resource.FolderResourceType;

public class CardService {
	public CardService() {
	}
	
	String fullClassName;
		public String getFullClassName() {
			return fullClassName;
		}
		public void setFullClassName(String className) {
			this.fullClassName = className;
		}
	
	String practiceName;
		public String getPracticeName() {
			return practiceName;
		}
		public void setPracticeName(String practiceName) {
			this.practiceName = practiceName;
		}
	String elementName;
		public String getElementName() {
			return elementName;
		}
		public void setElementName(String elementName) {
			this.elementName = elementName;
		}
		
	String type;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
	Card activityCard;
		public Card getActivityCard() {
			return activityCard;
		}
		public void setActivityCard(Card activityCard) {
			this.activityCard = activityCard;
		}

	List<Card> stateCardList;
		public List<Card> getStateCardList() {
			if(stateCardList == null){
				setStateCardList(new ArrayList<Card>());
			}
			return stateCardList;
		}
		public void setStateCardList(List<Card> stateCardList) {
			this.stateCardList = stateCardList;
		}

	List<Card> workProductList;
		public List<Card> getWorkProductList() {
			if(workProductList == null){
				setWorkProductList(new ArrayList<Card>());
			}
			return workProductList;
		}
		public void setWorkProductList(List<Card> workProductList) {
			this.workProductList = workProductList;
		}
		
	@ServiceMethod(callByContent=true)
	public void draw() throws Exception{
		
		String sourcePath = FolderResourceType.METHOD_FOLDER.getName() + File.separator;
		StringBuffer filePath = new StringBuffer(sourcePath);
		filePath.append(getPracticeName()).append(".").append(getType());
		
		PracticeDefinition definition = (PracticeDefinition)ObjectRepository.getInstance().get(filePath.toString());
		definition.afterDeserialize();
		Activity activity = definition.getElement(getElementName(), Activity.class);
		
		makeActivityCard(activity, definition);
		
		makeCompletionCriteriaStateCards(activity, definition);
		
		makeWorkProductCards(activity, definition);
		
		
	}
	
	private void makeActivityCard(Activity activity, PracticeDefinition definition){
		Card card = null;
		card = activity.createCardView();
		card.setParentName(definition.getPracticeName());
		setActivityCard(card);
	}
	
	private void makeCompletionCriteriaStateCards(Activity activity, PracticeDefinition definition){
//		for(Alpha alpha : activity.getOutputAlphas().getAlphas()){
//			for(State state : alpha.getStatePanel().getList()){
//				getStateCardList().add(state.createDetailCardView(definition.getElement(alpha.getName().substring(0,alpha.getName().indexOf("(")), Alpha.class)));
//			}
//		}
	}
	
	private void makeWorkProductCards(Activity activity, PracticeDefinition definition){
//		Card card = null;
//		for(WorkProduct workProduct : activity.getWorkProducts().getWorkProducts()){
//			card = definition.getElement(workProduct.getName().substring(0,workProduct.getName().indexOf("(")), WorkProduct.class).createCardView();
//			card.setParentName(definition.getPracticeName());
//			getWorkProductList().add(card);
//		}
	}
}
