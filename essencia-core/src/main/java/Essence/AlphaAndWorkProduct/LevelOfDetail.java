/**
 */
package Essence.AlphaAndWorkProduct;

import Essence.Foundation.Checkpoint;
import Essence.Foundation.LanguageElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Level Of Detail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getName <em>Name</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.LevelOfDetail#isIsSufficientLevel <em>Is Sufficient Level</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getDescription <em>Description</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getCheckListItem <em>Check List Item</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getWorkProduct <em>Work Product</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getLevelOfDetail()
 * @model
 * @generated
 */
public interface LevelOfDetail extends LanguageElement {
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
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getLevelOfDetail_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Is Sufficient Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Sufficient Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Sufficient Level</em>' attribute.
	 * @see #setIsSufficientLevel(boolean)
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getLevelOfDetail_IsSufficientLevel()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsSufficientLevel();

	/**
	 * Sets the value of the '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#isIsSufficientLevel <em>Is Sufficient Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Sufficient Level</em>' attribute.
	 * @see #isIsSufficientLevel()
	 * @generated
	 */
	void setIsSufficientLevel(boolean value);

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
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getLevelOfDetail_Description()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Check List Item</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.Foundation.Checkpoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check List Item</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check List Item</em>' containment reference list.
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getLevelOfDetail_CheckListItem()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Checkpoint> getCheckListItem();

	/**
	 * Returns the value of the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor</em>' reference.
	 * @see #setSuccessor(LevelOfDetail)
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getLevelOfDetail_Successor()
	 * @model ordered="false"
	 * @generated
	 */
	LevelOfDetail getSuccessor();

	/**
	 * Sets the value of the '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getSuccessor <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor</em>' reference.
	 * @see #getSuccessor()
	 * @generated
	 */
	void setSuccessor(LevelOfDetail value);

	/**
	 * Returns the value of the '<em><b>Work Product</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link Essence.AlphaAndWorkProduct.WorkProduct#getLevelOfDetail <em>Level Of Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Work Product</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Work Product</em>' container reference.
	 * @see #setWorkProduct(WorkProduct)
	 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage#getLevelOfDetail_WorkProduct()
	 * @see Essence.AlphaAndWorkProduct.WorkProduct#getLevelOfDetail
	 * @model opposite="levelOfDetail" required="true" transient="false" ordered="false"
	 * @generated
	 */
	WorkProduct getWorkProduct();

	/**
	 * Sets the value of the '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getWorkProduct <em>Work Product</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Work Product</em>' container reference.
	 * @see #getWorkProduct()
	 * @generated
	 */
	void setWorkProduct(WorkProduct value);

} // LevelOfDetail
