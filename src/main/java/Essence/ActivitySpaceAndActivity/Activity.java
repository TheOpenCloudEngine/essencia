/**
 */
package Essence.ActivitySpaceAndActivity;

import Essence.Competency.CompetencyLevel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.ActivitySpaceAndActivity.Activity#getRequiredCompetencyLevel <em>Required Competency Level</em>}</li>
 *   <li>{@link Essence.ActivitySpaceAndActivity.Activity#getAction <em>Action</em>}</li>
 *   <li>{@link Essence.ActivitySpaceAndActivity.Activity#getApproach <em>Approach</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getActivity()
 * @model
 * @generated
 */
public interface Activity extends AbstractActivity {
	/**
	 * Returns the value of the '<em><b>Required Competency Level</b></em>' reference list.
	 * The list contents are of type {@link Essence.Competency.CompetencyLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Competency Level</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Competency Level</em>' reference list.
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getActivity_RequiredCompetencyLevel()
	 * @model ordered="false"
	 * @generated
	 */
	EList<CompetencyLevel> getRequiredCompetencyLevel();

	/**
	 * Returns the value of the '<em><b>Action</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.ActivitySpaceAndActivity.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' containment reference list.
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getActivity_Action()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Action> getAction();

	/**
	 * Returns the value of the '<em><b>Approach</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.ActivitySpaceAndActivity.Approach}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Approach</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Approach</em>' containment reference list.
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getActivity_Approach()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Approach> getApproach();

} // Activity
