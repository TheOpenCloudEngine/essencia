/**
 */
package Essence.Foundation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.Foundation.ExtensionElement#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link Essence.Foundation.ExtensionElement#getExtensionFunction <em>Extension Function</em>}</li>
 *   <li>{@link Essence.Foundation.ExtensionElement#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Foundation.FoundationPackage#getExtensionElement()
 * @model
 * @generated
 */
public interface ExtensionElement extends LanguageElement {
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
	 * @see Essence.Foundation.FoundationPackage#getExtensionElement_TargetAttribute()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getTargetAttribute();

	/**
	 * Sets the value of the '{@link Essence.Foundation.ExtensionElement#getTargetAttribute <em>Target Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Attribute</em>' attribute.
	 * @see #getTargetAttribute()
	 * @generated
	 */
	void setTargetAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Extension Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Function</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Function</em>' attribute.
	 * @see #setExtensionFunction(String)
	 * @see Essence.Foundation.FoundationPackage#getExtensionElement_ExtensionFunction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getExtensionFunction();

	/**
	 * Sets the value of the '{@link Essence.Foundation.ExtensionElement#getExtensionFunction <em>Extension Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Function</em>' attribute.
	 * @see #getExtensionFunction()
	 * @generated
	 */
	void setExtensionFunction(String value);

	/**
	 * Returns the value of the '<em><b>Target Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Element</em>' reference.
	 * @see #setTargetElement(LanguageElement)
	 * @see Essence.Foundation.FoundationPackage#getExtensionElement_TargetElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LanguageElement getTargetElement();

	/**
	 * Sets the value of the '{@link Essence.Foundation.ExtensionElement#getTargetElement <em>Target Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Element</em>' reference.
	 * @see #getTargetElement()
	 * @generated
	 */
	void setTargetElement(LanguageElement value);

} // ExtensionElement
