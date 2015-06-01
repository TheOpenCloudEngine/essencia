/**
 */
package Essence.UserDefinedTypes;

import Essence.Foundation.Resource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TypedResource#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.UserDefinedTypes.UserDefinedTypesPackage#getTypedResource()
 * @model
 * @generated
 */
public interface TypedResource extends Resource {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' reference.
	 * @see #setKind(UserDefinedType)
	 * @see Essence.UserDefinedTypes.UserDefinedTypesPackage#getTypedResource_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	UserDefinedType getKind();

	/**
	 * Sets the value of the '{@link TypedResource#getKind <em>Kind</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' reference.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(UserDefinedType value);

} // TypedResource
