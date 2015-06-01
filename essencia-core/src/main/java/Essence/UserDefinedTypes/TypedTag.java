/**
 */
package Essence.UserDefinedTypes;

import Essence.Foundation.Tag;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Tag</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.UserDefinedTypes.TypedTag#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.UserDefinedTypes.UserDefinedTypesPackage#getTypedTag()
 * @model
 * @generated
 */
public interface TypedTag extends Tag {
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
	 * @see Essence.UserDefinedTypes.UserDefinedTypesPackage#getTypedTag_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	UserDefinedType getKind();

	/**
	 * Sets the value of the '{@link Essence.UserDefinedTypes.TypedTag#getKind <em>Kind</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' reference.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(UserDefinedType value);

} // TypedTag
