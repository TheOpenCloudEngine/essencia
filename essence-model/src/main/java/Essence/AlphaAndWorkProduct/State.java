/**
 */
package Essence.AlphaAndWorkProduct;

import Essence.Foundation.Checkpoint;
import Essence.Foundation.LanguageElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link State#getName <em>Name</em>}</li>
 *   <li>{@link State#getDescription <em>Description</em>}</li>
 *   <li>{@link State#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link State#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link State#getCheckListItem <em>Check List Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see AlphaAndWorkProductPackage#getState()
 * @model
 * @generated
 */
public interface State extends LanguageElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see AlphaAndWorkProductPackage#getState_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link State#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see AlphaAndWorkProductPackage#getState_Description()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link State#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Alpha</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Essence.AlphaAndWorkProduct.Alpha#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alpha</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alpha</em>' container reference.
	 * @see #setAlpha(Alpha)
	 * @see AlphaAndWorkProductPackage#getState_Alpha()
	 * @see Essence.AlphaAndWorkProduct.Alpha#getStates
	 * @model opposite="states" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Alpha getAlpha();

	/**
	 * Sets the value of the '{@link State#getAlpha <em>Alpha</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alpha</em>' container reference.
	 * @see #getAlpha()
	 * @generated
	 */
	void setAlpha(Alpha value);

	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(State)
	 * @see AlphaAndWorkProductPackage#getState_Successor()
	 * @model ordered="false"
	 * @generated
	 */
	State getSuccessor();

	/**
	 * Sets the value of the '{@link State#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(State value);

	/**
	 * Returns the value of the '<em><b>Check List Item</b></em>' containment reference list.
	 * The list contents are of type {@link Checkpoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check List Item</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check List Item</em>' containment reference list.
	 * @see AlphaAndWorkProductPackage#getState_CheckListItem()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Checkpoint> getCheckListItem();

} // State
