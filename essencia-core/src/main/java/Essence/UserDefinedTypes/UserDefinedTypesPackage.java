/**
 */
package Essence.UserDefinedTypes;

import Essence.Foundation.FoundationPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Essence.UserDefinedTypes.UserDefinedTypesFactory
 * @model kind="package"
 * @generated
 */
public interface UserDefinedTypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "UserDefinedTypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/Essence/20140301#UserDefinedTypes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "essence.UserDefinedTypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UserDefinedTypesPackage eINSTANCE = Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link Essence.UserDefinedTypes.impl.UserDefinedTypeImpl <em>User Defined Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.UserDefinedTypes.impl.UserDefinedTypeImpl
	 * @see Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl#getUserDefinedType()
	 * @generated
	 */
	int USER_DEFINED_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__NAME = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__DESCRIPTION = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE__CONSTRAINT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>User Defined Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>User Defined Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DEFINED_TYPE_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.UserDefinedTypes.impl.TypedPatternImpl <em>Typed Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.UserDefinedTypes.impl.TypedPatternImpl
	 * @see Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl#getTypedPattern()
	 * @generated
	 */
	int TYPED_PATTERN = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__PROPERTIES = FoundationPackage.PATTERN__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__TAG = FoundationPackage.PATTERN__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__IS_SUPPRESSABLE = FoundationPackage.PATTERN__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__RESOURCE = FoundationPackage.PATTERN__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__OWNER = FoundationPackage.PATTERN__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__NAME = FoundationPackage.PATTERN__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__ICON = FoundationPackage.PATTERN__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__BRIEF_DESCRIPTION = FoundationPackage.PATTERN__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__DESCRIPTION = FoundationPackage.PATTERN__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__ASSOCIATION = FoundationPackage.PATTERN__ASSOCIATION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN__KIND = FoundationPackage.PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN_FEATURE_COUNT = FoundationPackage.PATTERN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Typed Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_PATTERN_OPERATION_COUNT = FoundationPackage.PATTERN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.UserDefinedTypes.impl.TypedResourceImpl <em>Typed Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.UserDefinedTypes.impl.TypedResourceImpl
	 * @see Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl#getTypedResource()
	 * @generated
	 */
	int TYPED_RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESOURCE__PROPERTIES = FoundationPackage.RESOURCE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESOURCE__TAG = FoundationPackage.RESOURCE__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESOURCE__IS_SUPPRESSABLE = FoundationPackage.RESOURCE__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESOURCE__RESOURCE = FoundationPackage.RESOURCE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESOURCE__OWNER = FoundationPackage.RESOURCE__OWNER;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESOURCE__CONTENT = FoundationPackage.RESOURCE__CONTENT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESOURCE__KIND = FoundationPackage.RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESOURCE_FEATURE_COUNT = FoundationPackage.RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Typed Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_RESOURCE_OPERATION_COUNT = FoundationPackage.RESOURCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.UserDefinedTypes.impl.TypedTagImpl <em>Typed Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.UserDefinedTypes.impl.TypedTagImpl
	 * @see Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl#getTypedTag()
	 * @generated
	 */
	int TYPED_TAG = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TAG__PROPERTIES = FoundationPackage.TAG__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TAG__TAG = FoundationPackage.TAG__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TAG__IS_SUPPRESSABLE = FoundationPackage.TAG__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TAG__RESOURCE = FoundationPackage.TAG__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TAG__OWNER = FoundationPackage.TAG__OWNER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TAG__VALUE = FoundationPackage.TAG__VALUE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TAG__KIND = FoundationPackage.TAG_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TAG_FEATURE_COUNT = FoundationPackage.TAG_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Typed Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_TAG_OPERATION_COUNT = FoundationPackage.TAG_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link Essence.UserDefinedTypes.UserDefinedType <em>User Defined Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Defined Type</em>'.
	 * @see Essence.UserDefinedTypes.UserDefinedType
	 * @generated
	 */
	EClass getUserDefinedType();

	/**
	 * Returns the meta object for the attribute '{@link Essence.UserDefinedTypes.UserDefinedType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Essence.UserDefinedTypes.UserDefinedType#getName()
	 * @see #getUserDefinedType()
	 * @generated
	 */
	EAttribute getUserDefinedType_Name();

	/**
	 * Returns the meta object for the attribute '{@link Essence.UserDefinedTypes.UserDefinedType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see Essence.UserDefinedTypes.UserDefinedType#getDescription()
	 * @see #getUserDefinedType()
	 * @generated
	 */
	EAttribute getUserDefinedType_Description();

	/**
	 * Returns the meta object for the attribute '{@link Essence.UserDefinedTypes.UserDefinedType#getConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constraint</em>'.
	 * @see Essence.UserDefinedTypes.UserDefinedType#getConstraint()
	 * @see #getUserDefinedType()
	 * @generated
	 */
	EAttribute getUserDefinedType_Constraint();

	/**
	 * Returns the meta object for class '{@link Essence.UserDefinedTypes.TypedPattern <em>Typed Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Pattern</em>'.
	 * @see Essence.UserDefinedTypes.TypedPattern
	 * @generated
	 */
	EClass getTypedPattern();

	/**
	 * Returns the meta object for the reference '{@link Essence.UserDefinedTypes.TypedPattern#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Kind</em>'.
	 * @see Essence.UserDefinedTypes.TypedPattern#getKind()
	 * @see #getTypedPattern()
	 * @generated
	 */
	EReference getTypedPattern_Kind();

	/**
	 * Returns the meta object for class '{@link Essence.UserDefinedTypes.TypedResource <em>Typed Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Resource</em>'.
	 * @see Essence.UserDefinedTypes.TypedResource
	 * @generated
	 */
	EClass getTypedResource();

	/**
	 * Returns the meta object for the reference '{@link Essence.UserDefinedTypes.TypedResource#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Kind</em>'.
	 * @see Essence.UserDefinedTypes.TypedResource#getKind()
	 * @see #getTypedResource()
	 * @generated
	 */
	EReference getTypedResource_Kind();

	/**
	 * Returns the meta object for class '{@link Essence.UserDefinedTypes.TypedTag <em>Typed Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Tag</em>'.
	 * @see Essence.UserDefinedTypes.TypedTag
	 * @generated
	 */
	EClass getTypedTag();

	/**
	 * Returns the meta object for the reference '{@link Essence.UserDefinedTypes.TypedTag#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Kind</em>'.
	 * @see Essence.UserDefinedTypes.TypedTag#getKind()
	 * @see #getTypedTag()
	 * @generated
	 */
	EReference getTypedTag_Kind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UserDefinedTypesFactory getUserDefinedTypesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Essence.UserDefinedTypes.impl.UserDefinedTypeImpl <em>User Defined Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.UserDefinedTypes.impl.UserDefinedTypeImpl
		 * @see Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl#getUserDefinedType()
		 * @generated
		 */
		EClass USER_DEFINED_TYPE = eINSTANCE.getUserDefinedType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_DEFINED_TYPE__NAME = eINSTANCE.getUserDefinedType_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_DEFINED_TYPE__DESCRIPTION = eINSTANCE.getUserDefinedType_Description();

		/**
		 * The meta object literal for the '<em><b>Constraint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER_DEFINED_TYPE__CONSTRAINT = eINSTANCE.getUserDefinedType_Constraint();

		/**
		 * The meta object literal for the '{@link Essence.UserDefinedTypes.impl.TypedPatternImpl <em>Typed Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.UserDefinedTypes.impl.TypedPatternImpl
		 * @see Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl#getTypedPattern()
		 * @generated
		 */
		EClass TYPED_PATTERN = eINSTANCE.getTypedPattern();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_PATTERN__KIND = eINSTANCE.getTypedPattern_Kind();

		/**
		 * The meta object literal for the '{@link Essence.UserDefinedTypes.impl.TypedResourceImpl <em>Typed Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.UserDefinedTypes.impl.TypedResourceImpl
		 * @see Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl#getTypedResource()
		 * @generated
		 */
		EClass TYPED_RESOURCE = eINSTANCE.getTypedResource();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_RESOURCE__KIND = eINSTANCE.getTypedResource_Kind();

		/**
		 * The meta object literal for the '{@link Essence.UserDefinedTypes.impl.TypedTagImpl <em>Typed Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.UserDefinedTypes.impl.TypedTagImpl
		 * @see Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl#getTypedTag()
		 * @generated
		 */
		EClass TYPED_TAG = eINSTANCE.getTypedTag();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_TAG__KIND = eINSTANCE.getTypedTag_Kind();

	}

} //UserDefinedTypesPackage
