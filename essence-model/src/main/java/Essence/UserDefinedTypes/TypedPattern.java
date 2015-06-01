/**
 */
package Essence.UserDefinedTypes;

import Essence.Foundation.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TypedPattern#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see UserDefinedTypesPackage#getTypedPattern()
 * @model
 * @generated
 */
public interface TypedPattern extends Pattern {
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
	 * @see UserDefinedTypesPackage#getTypedPattern_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	UserDefinedType getKind();

	/**
	 * Sets the value of the '{@link TypedPattern#getKind <em>Kind</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' reference.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(UserDefinedType value);

} // TypedPattern
