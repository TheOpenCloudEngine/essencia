/**
 */
package Essence.Foundation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Merge Resolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.Foundation.MergeResolution#getTargetName <em>Target Name</em>}</li>
 *   <li>{@link Essence.Foundation.MergeResolution#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link Essence.Foundation.MergeResolution#getResolutionFunction <em>Resolution Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Foundation.FoundationPackage#getMergeResolution()
 * @model
 * @generated
 */
public interface MergeResolution extends LanguageElement {
	/**
	 * Returns the value of the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Name</em>' attribute.
	 * @see #setTargetName(String)
	 * @see Essence.Foundation.FoundationPackage#getMergeResolution_TargetName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTargetName();

	/**
	 * Sets the value of the '{@link Essence.Foundation.MergeResolution#getTargetName <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Name</em>' attribute.
	 * @see #getTargetName()
	 * @generated
	 */
	void setTargetName(String value);

	/**
	 * Returns the value of the '<em><b>Target Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Attribute</em>' attribute.
	 * @see #setTargetAttribute(String)
	 * @see Essence.Foundation.FoundationPackage#getMergeResolution_TargetAttribute()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTargetAttribute();

	/**
	 * Sets the value of the '{@link Essence.Foundation.MergeResolution#getTargetAttribute <em>Target Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Attribute</em>' attribute.
	 * @see #getTargetAttribute()
	 * @generated
	 */
	void setTargetAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Resolution Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolution Function</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolution Function</em>' attribute.
	 * @see #setResolutionFunction(String)
	 * @see Essence.Foundation.FoundationPackage#getMergeResolution_ResolutionFunction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getResolutionFunction();

	/**
	 * Sets the value of the '{@link Essence.Foundation.MergeResolution#getResolutionFunction <em>Resolution Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolution Function</em>' attribute.
	 * @see #getResolutionFunction()
	 * @generated
	 */
	void setResolutionFunction(String value);

} // MergeResolution
