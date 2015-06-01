/**
 */
package Essence.Foundation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Practice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Practice#getConsistencyRules <em>Consistency Rules</em>}</li>
 *   <li>{@link Practice#getObjective <em>Objective</em>}</li>
 *   <li>{@link Practice#getMeasures <em>Measures</em>}</li>
 *   <li>{@link Practice#getEntry <em>Entry</em>}</li>
 *   <li>{@link Practice#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Foundation.FoundationPackage#getPractice()
 * @model
 * @generated
 */
public interface Practice extends ElementGroup {
	/**
	 * Returns the value of the '<em><b>Consistency Rules</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consistency Rules</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consistency Rules</em>' attribute.
	 * @see #setConsistencyRules(String)
	 * @see Essence.Foundation.FoundationPackage#getPractice_ConsistencyRules()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getConsistencyRules();

	/**
	 * Sets the value of the '{@link Practice#getConsistencyRules <em>Consistency Rules</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consistency Rules</em>' attribute.
	 * @see #getConsistencyRules()
	 * @generated
	 */
	void setConsistencyRules(String value);

	/**
	 * Returns the value of the '<em><b>Objective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objective</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objective</em>' attribute.
	 * @see #setObjective(String)
	 * @see Essence.Foundation.FoundationPackage#getPractice_Objective()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getObjective();

	/**
	 * Sets the value of the '{@link Practice#getObjective <em>Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Objective</em>' attribute.
	 * @see #getObjective()
	 * @generated
	 */
	void setObjective(String value);

	/**
	 * Returns the value of the '<em><b>Measures</b></em>' attribute list.
	 * The list contents are of type {@link String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measures</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measures</em>' attribute list.
	 * @see Essence.Foundation.FoundationPackage#getPractice_Measures()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getMeasures();

	/**
	 * Returns the value of the '<em><b>Entry</b></em>' attribute list.
	 * The list contents are of type {@link String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry</em>' attribute list.
	 * @see Essence.Foundation.FoundationPackage#getPractice_Entry()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getEntry();

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute list.
	 * The list contents are of type {@link String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute list.
	 * @see Essence.Foundation.FoundationPackage#getPractice_Result()
	 * @model ordered="false"
	 * @generated
	 */
	EList<String> getResult();

} // Practice
