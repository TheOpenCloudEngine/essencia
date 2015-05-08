/**
 */
package Essence.UserDefinedTypes.impl;

import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage;

import Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl;

import Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage;

import Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl;

import Essence.Competency.CompetencyPackage;

import Essence.Competency.impl.CompetencyPackageImpl;

import Essence.DiagramInterchange.DiagramInterchangePackage;

import Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl;

import Essence.EssencePackage;

import Essence.Foundation.FoundationPackage;

import Essence.Foundation.impl.FoundationPackageImpl;

import Essence.UserDefinedTypes.TypedPattern;
import Essence.UserDefinedTypes.TypedResource;
import Essence.UserDefinedTypes.TypedTag;
import Essence.UserDefinedTypes.UserDefinedType;
import Essence.UserDefinedTypes.UserDefinedTypesFactory;
import Essence.UserDefinedTypes.UserDefinedTypesPackage;

import Essence.View.ViewPackage;

import Essence.View.impl.ViewPackageImpl;

import Essence.impl.EssencePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UserDefinedTypesPackageImpl extends EPackageImpl implements UserDefinedTypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDefinedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedTagEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see Essence.UserDefinedTypes.UserDefinedTypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UserDefinedTypesPackageImpl() {
		super(eNS_URI, UserDefinedTypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UserDefinedTypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UserDefinedTypesPackage init() {
		if (isInited) return (UserDefinedTypesPackage)EPackage.Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI);

		// Obtain or create and register package
		UserDefinedTypesPackageImpl theUserDefinedTypesPackage = (UserDefinedTypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UserDefinedTypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UserDefinedTypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EssencePackageImpl theEssencePackage = (EssencePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI) instanceof EssencePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI) : EssencePackage.eINSTANCE);
		ActivitySpaceAndActivityPackageImpl theActivitySpaceAndActivityPackage = (ActivitySpaceAndActivityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI) instanceof ActivitySpaceAndActivityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI) : ActivitySpaceAndActivityPackage.eINSTANCE);
		ViewPackageImpl theViewPackage = (ViewPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) instanceof ViewPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) : ViewPackage.eINSTANCE);
		FoundationPackageImpl theFoundationPackage = (FoundationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI) instanceof FoundationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI) : FoundationPackage.eINSTANCE);
		CompetencyPackageImpl theCompetencyPackage = (CompetencyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI) instanceof CompetencyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI) : CompetencyPackage.eINSTANCE);
		AlphaAndWorkProductPackageImpl theAlphaAndWorkProductPackage = (AlphaAndWorkProductPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) instanceof AlphaAndWorkProductPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) : AlphaAndWorkProductPackage.eINSTANCE);
		DiagramInterchangePackageImpl theDiagramInterchangePackage = (DiagramInterchangePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) instanceof DiagramInterchangePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) : DiagramInterchangePackage.eINSTANCE);

		// Create package meta-data objects
		theUserDefinedTypesPackage.createPackageContents();
		theEssencePackage.createPackageContents();
		theActivitySpaceAndActivityPackage.createPackageContents();
		theViewPackage.createPackageContents();
		theFoundationPackage.createPackageContents();
		theCompetencyPackage.createPackageContents();
		theAlphaAndWorkProductPackage.createPackageContents();
		theDiagramInterchangePackage.createPackageContents();

		// Initialize created meta-data
		theUserDefinedTypesPackage.initializePackageContents();
		theEssencePackage.initializePackageContents();
		theActivitySpaceAndActivityPackage.initializePackageContents();
		theViewPackage.initializePackageContents();
		theFoundationPackage.initializePackageContents();
		theCompetencyPackage.initializePackageContents();
		theAlphaAndWorkProductPackage.initializePackageContents();
		theDiagramInterchangePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUserDefinedTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UserDefinedTypesPackage.eNS_URI, theUserDefinedTypesPackage);
		return theUserDefinedTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserDefinedType() {
		return userDefinedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserDefinedType_Name() {
		return (EAttribute)userDefinedTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserDefinedType_Description() {
		return (EAttribute)userDefinedTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUserDefinedType_Constraint() {
		return (EAttribute)userDefinedTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedPattern() {
		return typedPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedPattern_Kind() {
		return (EReference)typedPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedResource() {
		return typedResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedResource_Kind() {
		return (EReference)typedResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedTag() {
		return typedTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedTag_Kind() {
		return (EReference)typedTagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserDefinedTypesFactory getUserDefinedTypesFactory() {
		return (UserDefinedTypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		userDefinedTypeEClass = createEClass(USER_DEFINED_TYPE);
		createEAttribute(userDefinedTypeEClass, USER_DEFINED_TYPE__NAME);
		createEAttribute(userDefinedTypeEClass, USER_DEFINED_TYPE__DESCRIPTION);
		createEAttribute(userDefinedTypeEClass, USER_DEFINED_TYPE__CONSTRAINT);

		typedPatternEClass = createEClass(TYPED_PATTERN);
		createEReference(typedPatternEClass, TYPED_PATTERN__KIND);

		typedResourceEClass = createEClass(TYPED_RESOURCE);
		createEReference(typedResourceEClass, TYPED_RESOURCE__KIND);

		typedTagEClass = createEClass(TYPED_TAG);
		createEReference(typedTagEClass, TYPED_TAG__KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		FoundationPackage theFoundationPackage = (FoundationPackage)EPackage.Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		userDefinedTypeEClass.getESuperTypes().add(theFoundationPackage.getLanguageElement());
		typedPatternEClass.getESuperTypes().add(theFoundationPackage.getPattern());
		typedResourceEClass.getESuperTypes().add(theFoundationPackage.getResource());
		typedTagEClass.getESuperTypes().add(theFoundationPackage.getTag());

		// Initialize classes, features, and operations; add parameters
		initEClass(userDefinedTypeEClass, UserDefinedType.class, "UserDefinedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUserDefinedType_Name(), ecorePackage.getEString(), "name", null, 1, 1, UserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUserDefinedType_Description(), ecorePackage.getEString(), "description", null, 1, 1, UserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUserDefinedType_Constraint(), ecorePackage.getEString(), "constraint", null, 1, 1, UserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(typedPatternEClass, TypedPattern.class, "TypedPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedPattern_Kind(), this.getUserDefinedType(), null, "kind", null, 1, 1, TypedPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(typedResourceEClass, TypedResource.class, "TypedResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedResource_Kind(), this.getUserDefinedType(), null, "kind", null, 1, 1, TypedResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(typedTagEClass, TypedTag.class, "TypedTag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedTag_Kind(), this.getUserDefinedType(), null, "kind", null, 1, 1, TypedTag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //UserDefinedTypesPackageImpl
