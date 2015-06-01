/**
 */
package Essence.ActivitySpaceAndActivity;

import Essence.AlphaAndWorkProduct.Alpha;
import Essence.AlphaAndWorkProduct.WorkProduct;

import Essence.Foundation.LanguageElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.ActivitySpaceAndActivity.Action#getKind <em>Kind</em>}</li>
 *   <li>{@link Essence.ActivitySpaceAndActivity.Action#getWorkProduct <em>Work Product</em>}</li>
 *   <li>{@link Essence.ActivitySpaceAndActivity.Action#getAlpha <em>Alpha</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends LanguageElement {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link Essence.ActivitySpaceAndActivity.ActionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see Essence.ActivitySpaceAndActivity.ActionKind
	 * @see #setKind(ActionKind)
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getAction_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ActionKind getKind();

	/**
	 * Sets the value of the '{@link Essence.ActivitySpaceAndActivity.Action#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see Essence.ActivitySpaceAndActivity.ActionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ActionKind value);

	/**
	 * Returns the value of the '<em><b>Work Product</b></em>' reference list.
	 * The list contents are of type {@link Essence.AlphaAndWorkProduct.WorkProduct}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Work Product</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Work Product</em>' reference list.
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getAction_WorkProduct()
	 * @model ordered="false"
	 * @generated
	 */
	EList<WorkProduct> getWorkProduct();

	/**
	 * Returns the value of the '<em><b>Alpha</b></em>' reference list.
	 * The list contents are of type {@link Essence.AlphaAndWorkProduct.Alpha}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alpha</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alpha</em>' reference list.
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getAction_Alpha()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Alpha> getAlpha();

} // Action
