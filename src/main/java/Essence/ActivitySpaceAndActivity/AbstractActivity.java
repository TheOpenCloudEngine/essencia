/**
 */
package Essence.ActivitySpaceAndActivity;

import Essence.Foundation.BasicElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.ActivitySpaceAndActivity.AbstractActivity#getCriterion <em>Criterion</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getAbstractActivity()
 * @model abstract="true"
 * @generated
 */
public interface AbstractActivity extends BasicElement {
	/**
	 * Returns the value of the '<em><b>Criterion</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.ActivitySpaceAndActivity.Criterion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criterion</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criterion</em>' containment reference list.
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getAbstractActivity_Criterion()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Criterion> getCriterion();

} // AbstractActivity
