/**
 */
package Essence.Foundation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.Foundation.LanguageElement#getProperties <em>Properties</em>}</li>
 *   <li>{@link Essence.Foundation.LanguageElement#getTag <em>Tag</em>}</li>
 *   <li>{@link Essence.Foundation.LanguageElement#isIsSuppressable <em>Is Suppressable</em>}</li>
 *   <li>{@link Essence.Foundation.LanguageElement#getResource <em>Resource</em>}</li>
 *   <li>{@link Essence.Foundation.LanguageElement#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Foundation.FoundationPackage#getLanguageElement()
 * @model abstract="true"
 * @generated
 */
public interface LanguageElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.Foundation.EndeavorProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see Essence.Foundation.FoundationPackage#getLanguageElement_Properties()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<EndeavorProperty> getProperties();

	/**
	 * Returns the value of the '<em><b>Tag</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.Foundation.Tag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' containment reference list.
	 * @see Essence.Foundation.FoundationPackage#getLanguageElement_Tag()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Tag> getTag();

	/**
	 * Returns the value of the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Suppressable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Suppressable</em>' attribute.
	 * @see #setIsSuppressable(boolean)
	 * @see Essence.Foundation.FoundationPackage#getLanguageElement_IsSuppressable()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsSuppressable();

	/**
	 * Sets the value of the '{@link Essence.Foundation.LanguageElement#isIsSuppressable <em>Is Suppressable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Suppressable</em>' attribute.
	 * @see #isIsSuppressable()
	 * @generated
	 */
	void setIsSuppressable(boolean value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.Foundation.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' containment reference list.
	 * @see Essence.Foundation.FoundationPackage#getLanguageElement_Resource()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Resource> getResource();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Essence.Foundation.ElementGroup#getOwnedElements <em>Owned Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(ElementGroup)
	 * @see Essence.Foundation.FoundationPackage#getLanguageElement_Owner()
	 * @see Essence.Foundation.ElementGroup#getOwnedElements
	 * @model opposite="ownedElements" transient="false" ordered="false"
	 * @generated
	 */
	ElementGroup getOwner();

	/**
	 * Sets the value of the '{@link Essence.Foundation.LanguageElement#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(ElementGroup value);

} // LanguageElement
