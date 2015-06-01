/**
 */
package Essence.Foundation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Endeavor Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.Foundation.EndeavorProperty#getName <em>Name</em>}</li>
 *   <li>{@link Essence.Foundation.EndeavorProperty#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link Essence.Foundation.EndeavorProperty#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link Essence.Foundation.EndeavorProperty#getType <em>Type</em>}</li>
 *   <li>{@link Essence.Foundation.EndeavorProperty#getOwningAssociation <em>Owning Association</em>}</li>
 *   <li>{@link Essence.Foundation.EndeavorProperty#getAssociation <em>Association</em>}</li>
 *   <li>{@link Essence.Foundation.EndeavorProperty#getLanguageElement <em>Language Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Foundation.FoundationPackage#getEndeavorProperty()
 * @model
 * @generated
 */
public interface EndeavorProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Essence.Foundation.FoundationPackage#getEndeavorProperty_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Essence.Foundation.EndeavorProperty#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see Essence.Foundation.FoundationPackage#getEndeavorProperty_LowerBound()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link Essence.Foundation.EndeavorProperty#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(int)
	 * @see Essence.Foundation.FoundationPackage#getEndeavorProperty_UpperBound()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link Essence.Foundation.EndeavorProperty#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see Essence.Foundation.FoundationPackage#getEndeavorProperty_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link Essence.Foundation.EndeavorProperty#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Owning Association</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Essence.Foundation.EndeavorAssociation#getOwnedEnd <em>Owned End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Association</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Association</em>' container reference.
	 * @see #setOwningAssociation(EndeavorAssociation)
	 * @see Essence.Foundation.FoundationPackage#getEndeavorProperty_OwningAssociation()
	 * @see Essence.Foundation.EndeavorAssociation#getOwnedEnd
	 * @model opposite="ownedEnd" transient="false" ordered="false"
	 * @generated
	 */
	EndeavorAssociation getOwningAssociation();

	/**
	 * Sets the value of the '{@link Essence.Foundation.EndeavorProperty#getOwningAssociation <em>Owning Association</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Association</em>' container reference.
	 * @see #getOwningAssociation()
	 * @generated
	 */
	void setOwningAssociation(EndeavorAssociation value);

	/**
	 * Returns the value of the '<em><b>Association</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link Essence.Foundation.EndeavorAssociation#getMemberEnd <em>Member End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' reference.
	 * @see #setAssociation(EndeavorAssociation)
	 * @see Essence.Foundation.FoundationPackage#getEndeavorProperty_Association()
	 * @see Essence.Foundation.EndeavorAssociation#getMemberEnd
	 * @model opposite="memberEnd" ordered="false"
	 * @generated
	 */
	EndeavorAssociation getAssociation();

	/**
	 * Sets the value of the '{@link Essence.Foundation.EndeavorProperty#getAssociation <em>Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association</em>' reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(EndeavorAssociation value);

	/**
	 * Returns the value of the '<em><b>Language Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Element</em>' reference.
	 * @see #setLanguageElement(LanguageElement)
	 * @see Essence.Foundation.FoundationPackage#getEndeavorProperty_LanguageElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LanguageElement getLanguageElement();

	/**
	 * Sets the value of the '{@link Essence.Foundation.EndeavorProperty#getLanguageElement <em>Language Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language Element</em>' reference.
	 * @see #getLanguageElement()
	 * @generated
	 */
	void setLanguageElement(LanguageElement value);

} // EndeavorProperty
