/**
 */
package Essence.Foundation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Kernel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Kernel#getConsistencyRules <em>Consistency Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Foundation.FoundationPackage#getKernel()
 * @model
 * @generated
 */
public interface Kernel extends ElementGroup {
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
	 * @see Essence.Foundation.FoundationPackage#getKernel_ConsistencyRules()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getConsistencyRules();

	/**
	 * Sets the value of the '{@link Kernel#getConsistencyRules <em>Consistency Rules</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consistency Rules</em>' attribute.
	 * @see #getConsistencyRules()
	 * @generated
	 */
	void setConsistencyRules(String value);

} // Kernel
