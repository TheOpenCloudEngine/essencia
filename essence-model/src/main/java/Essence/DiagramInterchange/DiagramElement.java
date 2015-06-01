/**
 */
package Essence.DiagramInterchange;

import Essence.Foundation.LanguageElement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DiagramElement#getDiagramElement2 <em>Diagram Element2</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getDiagramElement()
 * @model
 * @generated
 */
public interface DiagramElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Diagram Element2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Element2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Element2</em>' reference.
	 * @see #setDiagramElement2(LanguageElement)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getDiagramElement_DiagramElement2()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LanguageElement getDiagramElement2();

	/**
	 * Sets the value of the '{@link DiagramElement#getDiagramElement2 <em>Diagram Element2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Element2</em>' reference.
	 * @see #getDiagramElement2()
	 * @generated
	 */
	void setDiagramElement2(LanguageElement value);

} // DiagramElement
