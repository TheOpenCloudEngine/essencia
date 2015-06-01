/**
 */
package Essence.Foundation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.Foundation.Method#getBaseKernel <em>Base Kernel</em>}</li>
 *   <li>{@link Essence.Foundation.Method#getPurpose <em>Purpose</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Foundation.FoundationPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends ElementGroup {
	/**
	 * Returns the value of the '<em><b>Base Kernel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Kernel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Kernel</em>' reference.
	 * @see #setBaseKernel(Kernel)
	 * @see Essence.Foundation.FoundationPackage#getMethod_BaseKernel()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Kernel getBaseKernel();

	/**
	 * Sets the value of the '{@link Essence.Foundation.Method#getBaseKernel <em>Base Kernel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Kernel</em>' reference.
	 * @see #getBaseKernel()
	 * @generated
	 */
	void setBaseKernel(Kernel value);

	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see #setPurpose(String)
	 * @see Essence.Foundation.FoundationPackage#getMethod_Purpose()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getPurpose();

	/**
	 * Sets the value of the '{@link Essence.Foundation.Method#getPurpose <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Purpose</em>' attribute.
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(String value);

} // Method
