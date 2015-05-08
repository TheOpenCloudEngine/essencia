/**
 */
package Essence.UserDefinedTypes.impl;

import Essence.UserDefinedTypes.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UserDefinedTypesFactoryImpl extends EFactoryImpl implements UserDefinedTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UserDefinedTypesFactory init() {
		try {
			UserDefinedTypesFactory theUserDefinedTypesFactory = (UserDefinedTypesFactory)EPackage.Registry.INSTANCE.getEFactory(UserDefinedTypesPackage.eNS_URI);
			if (theUserDefinedTypesFactory != null) {
				return theUserDefinedTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UserDefinedTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDefinedTypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UserDefinedTypesPackage.USER_DEFINED_TYPE: return createUserDefinedType();
			case UserDefinedTypesPackage.TYPED_PATTERN: return createTypedPattern();
			case UserDefinedTypesPackage.TYPED_RESOURCE: return createTypedResource();
			case UserDefinedTypesPackage.TYPED_TAG: return createTypedTag();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDefinedType createUserDefinedType() {
		UserDefinedTypeImpl userDefinedType = new UserDefinedTypeImpl();
		return userDefinedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedPattern createTypedPattern() {
		TypedPatternImpl typedPattern = new TypedPatternImpl();
		return typedPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedResource createTypedResource() {
		TypedResourceImpl typedResource = new TypedResourceImpl();
		return typedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedTag createTypedTag() {
		TypedTagImpl typedTag = new TypedTagImpl();
		return typedTag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDefinedTypesPackage getUserDefinedTypesPackage() {
		return (UserDefinedTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UserDefinedTypesPackage getPackage() {
		return UserDefinedTypesPackage.eINSTANCE;
	}

} //UserDefinedTypesFactoryImpl
