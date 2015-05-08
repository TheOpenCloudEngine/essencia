/**
 */
package Essence.ActivitySpaceAndActivity;

import Essence.AlphaAndWorkProduct.Alpha;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.ActivitySpaceAndActivity.ActivitySpace#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getActivitySpace()
 * @model
 * @generated
 */
public interface ActivitySpace extends AbstractActivity {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' reference list.
	 * The list contents are of type {@link Essence.AlphaAndWorkProduct.Alpha}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' reference list.
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getActivitySpace_Input()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Alpha> getInput();

} // ActivitySpace
