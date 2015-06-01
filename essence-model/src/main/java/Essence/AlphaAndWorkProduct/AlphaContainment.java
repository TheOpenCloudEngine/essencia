/**
 */
package Essence.AlphaAndWorkProduct;

import Essence.Foundation.LanguageElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alpha Containment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link AlphaContainment#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link AlphaContainment#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link AlphaContainment#getSubordinateAlpha <em>Subordinate Alpha</em>}</li>
 *   <li>{@link AlphaContainment#getSuperAlpha <em>Super Alpha</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getAlphaContainment()
 * @model
 * @generated
 */
public interface AlphaContainment extends LanguageElement {
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
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getAlphaContainment_LowerBound()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link AlphaContainment#getLowerBound <em>Lower Bound</em>}' attribute.
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
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getAlphaContainment_UpperBound()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link AlphaContainment#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>Subordinate Alpha</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subordinate Alpha</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subordinate Alpha</em>' reference.
	 * @see #setSubordinateAlpha(Alpha)
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getAlphaContainment_SubordinateAlpha()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Alpha getSubordinateAlpha();

	/**
	 * Sets the value of the '{@link AlphaContainment#getSubordinateAlpha <em>Subordinate Alpha</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subordinate Alpha</em>' reference.
	 * @see #getSubordinateAlpha()
	 * @generated
	 */
	void setSubordinateAlpha(Alpha value);

	/**
	 * Returns the value of the '<em><b>Super Alpha</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Alpha</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Alpha</em>' reference.
	 * @see #setSuperAlpha(Alpha)
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getAlphaContainment_SuperAlpha()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Alpha getSuperAlpha();

	/**
	 * Sets the value of the '{@link AlphaContainment#getSuperAlpha <em>Super Alpha</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Alpha</em>' reference.
	 * @see #getSuperAlpha()
	 * @generated
	 */
	void setSuperAlpha(Alpha value);

} // AlphaContainment
