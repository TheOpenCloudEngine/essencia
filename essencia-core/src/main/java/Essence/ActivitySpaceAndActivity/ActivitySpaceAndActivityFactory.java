/**
 */
package Essence.ActivitySpaceAndActivity;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage
 * @generated
 */
public interface ActivitySpaceAndActivityFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActivitySpaceAndActivityFactory eINSTANCE = Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Activity Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Space</em>'.
	 * @generated
	 */
	ActivitySpace createActivitySpace();

	/**
	 * Returns a new object of class '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity</em>'.
	 * @generated
	 */
	Activity createActivity();

	/**
	 * Returns a new object of class '<em>Activity Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Association</em>'.
	 * @generated
	 */
	ActivityAssociation createActivityAssociation();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	Action createAction();

	/**
	 * Returns a new object of class '<em>Approach</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Approach</em>'.
	 * @generated
	 */
	Approach createApproach();

	/**
	 * Returns a new object of class '<em>Completion Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Completion Criterion</em>'.
	 * @generated
	 */
	CompletionCriterion createCompletionCriterion();

	/**
	 * Returns a new object of class '<em>Entry Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Criterion</em>'.
	 * @generated
	 */
	EntryCriterion createEntryCriterion();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ActivitySpaceAndActivityPackage getActivitySpaceAndActivityPackage();

} //ActivitySpaceAndActivityFactory
