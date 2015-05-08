/**
 */
package Essence.Foundation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.Foundation.BasicElement#getName <em>Name</em>}</li>
 *   <li>{@link Essence.Foundation.BasicElement#getIcon <em>Icon</em>}</li>
 *   <li>{@link Essence.Foundation.BasicElement#getBriefDescription <em>Brief Description</em>}</li>
 *   <li>{@link Essence.Foundation.BasicElement#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Foundation.FoundationPackage#getBasicElement()
 * @model abstract="true"
 * @generated
 */
public interface BasicElement extends LanguageElement {
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
	 * @see Essence.Foundation.FoundationPackage#getBasicElement_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Essence.Foundation.BasicElement#getName <em>Name</em>}' attribute.
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
	 * @see Essence.Foundation.FoundationPackage#getBasicElement_Icon()
	 * @model dataType="Essence.GraphicalElement" ordered="false"
	 * @generated
	 */
	Object getIcon();

	/**
	 * Sets the value of the '{@link Essence.Foundation.BasicElement#getIcon <em>Icon</em>}' attribute.
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
	 * @see Essence.Foundation.FoundationPackage#getBasicElement_BriefDescription()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getBriefDescription();

	/**
	 * Sets the value of the '{@link Essence.Foundation.BasicElement#getBriefDescription <em>Brief Description</em>}' attribute.
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
	 * @see Essence.Foundation.FoundationPackage#getBasicElement_Description()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link Essence.Foundation.BasicElement#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // BasicElement
