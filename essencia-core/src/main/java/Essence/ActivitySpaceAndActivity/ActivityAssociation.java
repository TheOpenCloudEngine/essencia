/**
 */
package Essence.ActivitySpaceAndActivity;

import Essence.Foundation.LanguageElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.ActivitySpaceAndActivity.ActivityAssociation#getKind <em>Kind</em>}</li>
 *   <li>{@link Essence.ActivitySpaceAndActivity.ActivityAssociation#getEnd1 <em>End1</em>}</li>
 *   <li>{@link Essence.ActivitySpaceAndActivity.ActivityAssociation#getEnd2 <em>End2</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getActivityAssociation()
 * @model
 * @generated
 */
public interface ActivityAssociation extends LanguageElement {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getActivityAssociation_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link Essence.ActivitySpaceAndActivity.ActivityAssociation#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>End1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End1</em>' reference.
	 * @see #setEnd1(AbstractActivity)
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getActivityAssociation_End1()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractActivity getEnd1();

	/**
	 * Sets the value of the '{@link Essence.ActivitySpaceAndActivity.ActivityAssociation#getEnd1 <em>End1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End1</em>' reference.
	 * @see #getEnd1()
	 * @generated
	 */
	void setEnd1(AbstractActivity value);

	/**
	 * Returns the value of the '<em><b>End2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End2</em>' reference.
	 * @see #setEnd2(AbstractActivity)
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#getActivityAssociation_End2()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractActivity getEnd2();

	/**
	 * Sets the value of the '{@link Essence.ActivitySpaceAndActivity.ActivityAssociation#getEnd2 <em>End2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End2</em>' reference.
	 * @see #getEnd2()
	 * @generated
	 */
	void setEnd2(AbstractActivity value);

} // ActivityAssociation
