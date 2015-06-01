/**
 */
package Essence.AlphaAndWorkProduct;

import Essence.Foundation.LanguageElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Work Product Manifest</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getWorkProduct <em>Work Product</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getWorkProductManifest()
 * @model
 * @generated
 */
public interface WorkProductManifest extends LanguageElement {
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
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getWorkProductManifest_LowerBound()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getLowerBound <em>Lower Bound</em>}' attribute.
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
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getWorkProductManifest_UpperBound()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>Alpha</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alpha</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alpha</em>' reference.
	 * @see #setAlpha(Alpha)
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getWorkProductManifest_Alpha()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Alpha getAlpha();

	/**
	 * Sets the value of the '{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getAlpha <em>Alpha</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alpha</em>' reference.
	 * @see #getAlpha()
	 * @generated
	 */
	void setAlpha(Alpha value);

	/**
	 * Returns the value of the '<em><b>Work Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Work Product</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Work Product</em>' reference.
	 * @see #setWorkProduct(WorkProduct)
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getWorkProductManifest_WorkProduct()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	WorkProduct getWorkProduct();

	/**
	 * Sets the value of the '{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getWorkProduct <em>Work Product</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Work Product</em>' reference.
	 * @see #getWorkProduct()
	 * @generated
	 */
	void setWorkProduct(WorkProduct value);

} // WorkProductManifest
