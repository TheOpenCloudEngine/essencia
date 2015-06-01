/**
 */
package Essence.Foundation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.Foundation.ElementGroup#getName <em>Name</em>}</li>
 *   <li>{@link Essence.Foundation.ElementGroup#getIcon <em>Icon</em>}</li>
 *   <li>{@link Essence.Foundation.ElementGroup#getBriefDescription <em>Brief Description</em>}</li>
 *   <li>{@link Essence.Foundation.ElementGroup#getDescription <em>Description</em>}</li>
 *   <li>{@link Essence.Foundation.ElementGroup#getReferredElements <em>Referred Elements</em>}</li>
 *   <li>{@link Essence.Foundation.ElementGroup#getMergeResolution <em>Merge Resolution</em>}</li>
 *   <li>{@link Essence.Foundation.ElementGroup#getExtension <em>Extension</em>}</li>
 *   <li>{@link Essence.Foundation.ElementGroup#getOwnedElements <em>Owned Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Foundation.FoundationPackage#getElementGroup()
 * @model abstract="true"
 * @generated
 */
public interface ElementGroup extends LanguageElement {
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
	 * @see Essence.Foundation.FoundationPackage#getElementGroup_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Essence.Foundation.ElementGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' attribute.
	 * @see #setIcon(Object)
	 * @see Essence.Foundation.FoundationPackage#getElementGroup_Icon()
	 * @model dataType="Essence.GraphicalElement" ordered="false"
	 * @generated
	 */
	Object getIcon();

	/**
	 * Sets the value of the '{@link Essence.Foundation.ElementGroup#getIcon <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' attribute.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(Object value);

	/**
	 * Returns the value of the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Brief Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Brief Description</em>' attribute.
	 * @see #setBriefDescription(String)
	 * @see Essence.Foundation.FoundationPackage#getElementGroup_BriefDescription()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getBriefDescription();

	/**
	 * Sets the value of the '{@link Essence.Foundation.ElementGroup#getBriefDescription <em>Brief Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Brief Description</em>' attribute.
	 * @see #getBriefDescription()
	 * @generated
	 */
	void setBriefDescription(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see Essence.Foundation.FoundationPackage#getElementGroup_Description()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link Essence.Foundation.ElementGroup#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Referred Elements</b></em>' reference list.
	 * The list contents are of type {@link Essence.Foundation.LanguageElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Elements</em>' reference list.
	 * @see Essence.Foundation.FoundationPackage#getElementGroup_ReferredElements()
	 * @model ordered="false"
	 * @generated
	 */
	EList<LanguageElement> getReferredElements();

	/**
	 * Returns the value of the '<em><b>Merge Resolution</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.Foundation.MergeResolution}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Merge Resolution</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Merge Resolution</em>' containment reference list.
	 * @see Essence.Foundation.FoundationPackage#getElementGroup_MergeResolution()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MergeResolution> getMergeResolution();

	/**
	 * Returns the value of the '<em><b>Extension</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.Foundation.ExtensionElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' containment reference list.
	 * @see Essence.Foundation.FoundationPackage#getElementGroup_Extension()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ExtensionElement> getExtension();

	/**
	 * Returns the value of the '<em><b>Owned Elements</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.Foundation.LanguageElement}.
	 * It is bidirectional and its opposite is '{@link Essence.Foundation.LanguageElement#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Elements</em>' containment reference list.
	 * @see Essence.Foundation.FoundationPackage#getElementGroup_OwnedElements()
	 * @see Essence.Foundation.LanguageElement#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<LanguageElement> getOwnedElements();

} // ElementGroup
