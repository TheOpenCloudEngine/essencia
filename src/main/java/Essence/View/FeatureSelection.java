/**
 */
package Essence.View;

import Essence.Foundation.LanguageElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.View.FeatureSelection#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link Essence.View.FeatureSelection#getConstruct <em>Construct</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.View.ViewPackage#getFeatureSelection()
 * @model
 * @generated
 */
public interface FeatureSelection extends LanguageElement {
	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see #setFeatureName(String)
	 * @see Essence.View.ViewPackage#getFeatureSelection_FeatureName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Sets the value of the '{@link Essence.View.FeatureSelection#getFeatureName <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

	/**
	 * Returns the value of the '<em><b>Construct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Construct</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Construct</em>' reference.
	 * @see #setConstruct(LanguageElement)
	 * @see Essence.View.ViewPackage#getFeatureSelection_Construct()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LanguageElement getConstruct();

	/**
	 * Sets the value of the '{@link Essence.View.FeatureSelection#getConstruct <em>Construct</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Construct</em>' reference.
	 * @see #getConstruct()
	 * @generated
	 */
	void setConstruct(LanguageElement value);

} // FeatureSelection
