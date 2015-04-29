package org.uengine.essencia.designer;

import java.util.List;

import org.metaworks.EventContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.uengine.essencia.model.AbstractActivity;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.IElement;


@Face(displayName = "Properties", ejsPath = "dwr/metaworks/genericfaces/CleanObjectFace.ejs")
public class ActivitySpaceAndActivityPropertyPanel extends EssenciaPropertyPanel {

	private List<LanguageElement> elementList;

	@Hidden
	public List<LanguageElement> getElementList() {
		return elementList;
	}

	public void setElementList(List<LanguageElement> elementList) {
		this.elementList = elementList;
	}

	public ActivitySpaceAndActivityPropertyPanel() {

	}

	public ActivitySpaceAndActivityPropertyPanel(ElementView elementView, List<IElement> elementList) {
		super(elementView);
		((AbstractActivity) getElement()).setUpElement(elementList);

	}
	
//	public ActivitySpaceAndActivityPropertyPanel(ElementView elementView, List<LanguageElement> elementList, List<Relation> relationList) {
//		super(elementView);
//		((AbstractActivity) getElement()).fillElements(elementList);
//		//
//	}

	@Face(displayName = "Apply")
	@ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_APPEND)
	public Object[] apply() {
		((AbstractActivity) getElement()).beforeApply();
		getElementView().setElement(getElement());
		return new Object[] { new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE), new Refresh(getElementView(), true) };
	}

}
