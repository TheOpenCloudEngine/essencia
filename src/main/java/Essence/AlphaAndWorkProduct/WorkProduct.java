/**
 */
package Essence.AlphaAndWorkProduct;

import Essence.Foundation.BasicElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Work Product</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.AlphaAndWorkProduct.WorkProduct#getLevelOfDetail <em>Level Of Detail</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getWorkProduct()
 * @model
 * @generated
 */
public interface WorkProduct extends BasicElement {
	/**
	 * Returns the value of the '<em><b>Level Of Detail</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.AlphaAndWorkProduct.LevelOfDetail}.
	 * It is bidirectional and its opposite is '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getWorkProduct <em>Work Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level Of Detail</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level Of Detail</em>' containment reference list.
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getWorkProduct_LevelOfDetail()
	 * @see Essence.AlphaAndWorkProduct.LevelOfDetail#getWorkProduct
	 * @model opposite="workProduct" containment="true" ordered="false"
	 * @generated
	 */
	EList<LevelOfDetail> getLevelOfDetail();

} // WorkProduct
