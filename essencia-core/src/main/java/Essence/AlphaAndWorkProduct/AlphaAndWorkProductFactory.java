/**
 */
package Essence.AlphaAndWorkProduct;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage
 * @generated
 */
public interface AlphaAndWorkProductFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AlphaAndWorkProductFactory eINSTANCE = Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Alpha</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alpha</em>'.
	 * @generated
	 */
	Alpha createAlpha();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>Alpha Association</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alpha Association</em>'.
	 * @generated
	 */
	AlphaAssociation createAlphaAssociation();

	/**
	 * Returns a new object of class '<em>Work Product</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Work Product</em>'.
	 * @generated
	 */
	WorkProduct createWorkProduct();

	/**
	 * Returns a new object of class '<em>Work Product Manifest</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Work Product Manifest</em>'.
	 * @generated
	 */
	WorkProductManifest createWorkProductManifest();

	/**
	 * Returns a new object of class '<em>Alpha Containment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alpha Containment</em>'.
	 * @generated
	 */
	AlphaContainment createAlphaContainment();

	/**
	 * Returns a new object of class '<em>Level Of Detail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Level Of Detail</em>'.
	 * @generated
	 */
	LevelOfDetail createLevelOfDetail();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AlphaAndWorkProductPackage getAlphaAndWorkProductPackage();

} //AlphaAndWorkProductFactory
