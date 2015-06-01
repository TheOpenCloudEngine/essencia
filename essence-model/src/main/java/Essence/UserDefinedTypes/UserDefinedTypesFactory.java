/**
 */
package Essence.UserDefinedTypes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Essence.UserDefinedTypes.UserDefinedTypesPackage
 * @generated
 */
public interface UserDefinedTypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UserDefinedTypesFactory eINSTANCE = Essence.UserDefinedTypes.impl.UserDefinedTypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>User Defined Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Defined Type</em>'.
	 * @generated
	 */
	UserDefinedType createUserDefinedType();

	/**
	 * Returns a new object of class '<em>Typed Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Pattern</em>'.
	 * @generated
	 */
	TypedPattern createTypedPattern();

	/**
	 * Returns a new object of class '<em>Typed Resource</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Resource</em>'.
	 * @generated
	 */
	TypedResource createTypedResource();

	/**
	 * Returns a new object of class '<em>Typed Tag</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Tag</em>'.
	 * @generated
	 */
	TypedTag createTypedTag();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UserDefinedTypesPackage getUserDefinedTypesPackage();

} //UserDefinedTypesFactory
