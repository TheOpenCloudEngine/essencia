/**
 */
package Essence.DiagramInterchange;

import Essence.Foundation.BasicElement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Card</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.DiagramInterchange.Card#getLeftHeaderSide <em>Left Header Side</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.Card#getLeftBodySide <em>Left Body Side</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.Card#getRightBodySide <em>Right Body Side</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.Card#getRightHeaderSide <em>Right Header Side</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.Card#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getCard()
 * @model
 * @generated
 */
public interface Card extends EObject {
	/**
	 * Returns the value of the '<em><b>Left Header Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Header Side</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Header Side</em>' containment reference.
	 * @see #setLeftHeaderSide(Node)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getCard_LeftHeaderSide()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Node getLeftHeaderSide();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.Card#getLeftHeaderSide <em>Left Header Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Header Side</em>' containment reference.
	 * @see #getLeftHeaderSide()
	 * @generated
	 */
	void setLeftHeaderSide(Node value);

	/**
	 * Returns the value of the '<em><b>Left Body Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Body Side</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Body Side</em>' containment reference.
	 * @see #setLeftBodySide(Diagram)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getCard_LeftBodySide()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Diagram getLeftBodySide();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.Card#getLeftBodySide <em>Left Body Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Body Side</em>' containment reference.
	 * @see #getLeftBodySide()
	 * @generated
	 */
	void setLeftBodySide(Diagram value);

	/**
	 * Returns the value of the '<em><b>Right Body Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Body Side</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Body Side</em>' containment reference.
	 * @see #setRightBodySide(Text)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getCard_RightBodySide()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Text getRightBodySide();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.Card#getRightBodySide <em>Right Body Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Body Side</em>' containment reference.
	 * @see #getRightBodySide()
	 * @generated
	 */
	void setRightBodySide(Text value);

	/**
	 * Returns the value of the '<em><b>Right Header Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Header Side</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Header Side</em>' containment reference.
	 * @see #setRightHeaderSide(Label)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getCard_RightHeaderSide()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Label getRightHeaderSide();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.Card#getRightHeaderSide <em>Right Header Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Header Side</em>' containment reference.
	 * @see #getRightHeaderSide()
	 * @generated
	 */
	void setRightHeaderSide(Label value);

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference.
	 * @see #setModelElement(BasicElement)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getCard_ModelElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BasicElement getModelElement();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.Card#getModelElement <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(BasicElement value);

} // Card
