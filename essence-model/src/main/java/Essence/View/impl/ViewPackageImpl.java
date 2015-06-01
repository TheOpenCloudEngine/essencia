/**
 */
package Essence.View.impl;

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

import Essence.UserDefinedTypes.UserDefinedTypesPackage;

import Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl;

import Essence.View.FeatureSelection;
import Essence.View.ViewFactory;
import Essence.View.ViewPackage;
import Essence.View.ViewSelection;

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
public class ViewPackageImpl extends EPackageImpl implements ViewPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass viewSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureSelectionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Registry
	 * @see Essence.View.ViewPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ViewPackageImpl() {
		super(eNS_URI, ViewFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ViewPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ViewPackage init() {
		if (isInited) return (ViewPackage) Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI);

		// Obtain or create and register package
		ViewPackageImpl theViewPackage = (ViewPackageImpl)(Registry.INSTANCE.get(eNS_URI) instanceof ViewPackageImpl ? Registry.INSTANCE.get(eNS_URI) : new ViewPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EssencePackageImpl theEssencePackage = (EssencePackageImpl)(Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI) instanceof EssencePackageImpl ? Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI) : EssencePackage.eINSTANCE);
		UserDefinedTypesPackageImpl theUserDefinedTypesPackage = (UserDefinedTypesPackageImpl)(Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI) instanceof UserDefinedTypesPackageImpl ? Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI) : UserDefinedTypesPackage.eINSTANCE);
		ActivitySpaceAndActivityPackageImpl theActivitySpaceAndActivityPackage = (ActivitySpaceAndActivityPackageImpl)(Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI) instanceof ActivitySpaceAndActivityPackageImpl ? Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI) : ActivitySpaceAndActivityPackage.eINSTANCE);
		FoundationPackageImpl theFoundationPackage = (FoundationPackageImpl)(Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI) instanceof FoundationPackageImpl ? Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI) : FoundationPackage.eINSTANCE);
		CompetencyPackageImpl theCompetencyPackage = (CompetencyPackageImpl)(Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI) instanceof CompetencyPackageImpl ? Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI) : CompetencyPackage.eINSTANCE);
		AlphaAndWorkProductPackageImpl theAlphaAndWorkProductPackage = (AlphaAndWorkProductPackageImpl)(Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) instanceof AlphaAndWorkProductPackageImpl ? Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) : AlphaAndWorkProductPackage.eINSTANCE);
		DiagramInterchangePackageImpl theDiagramInterchangePackage = (DiagramInterchangePackageImpl)(Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) instanceof DiagramInterchangePackageImpl ? Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) : DiagramInterchangePackage.eINSTANCE);

		// Create package meta-data objects
		theViewPackage.createPackageContents();
		theEssencePackage.createPackageContents();
		theUserDefinedTypesPackage.createPackageContents();
		theActivitySpaceAndActivityPackage.createPackageContents();
		theFoundationPackage.createPackageContents();
		theCompetencyPackage.createPackageContents();
		theAlphaAndWorkProductPackage.createPackageContents();
		theDiagramInterchangePackage.createPackageContents();

		// Initialize created meta-data
		theViewPackage.initializePackageContents();
		theEssencePackage.initializePackageContents();
		theUserDefinedTypesPackage.initializePackageContents();
		theActivitySpaceAndActivityPackage.initializePackageContents();
		theFoundationPackage.initializePackageContents();
		theCompetencyPackage.initializePackageContents();
		theAlphaAndWorkProductPackage.initializePackageContents();
		theDiagramInterchangePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theViewPackage.freeze();


		// Update the registry and return the package
		Registry.INSTANCE.put(ViewPackage.eNS_URI, theViewPackage);
		return theViewPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getViewSelection() {
		return viewSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewSelection_Name() {
		return (EAttribute)viewSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getViewSelection_Description() {
		return (EAttribute)viewSelectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewSelection_FeatureSelection() {
		return (EReference)viewSelectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewSelection_ConstructSelection() {
		return (EReference)viewSelectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getViewSelection_IncludedViewSelection() {
		return (EReference)viewSelectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureSelection() {
		return featureSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureSelection_FeatureName() {
		return (EAttribute)featureSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureSelection_Construct() {
		return (EReference)featureSelectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ViewFactory getViewFactory() {
		return (ViewFactory)getEFactoryInstance();
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
		viewSelectionEClass = createEClass(VIEW_SELECTION);
		createEAttribute(viewSelectionEClass, VIEW_SELECTION__NAME);
		createEAttribute(viewSelectionEClass, VIEW_SELECTION__DESCRIPTION);
		createEReference(viewSelectionEClass, VIEW_SELECTION__FEATURE_SELECTION);
		createEReference(viewSelectionEClass, VIEW_SELECTION__CONSTRUCT_SELECTION);
		createEReference(viewSelectionEClass, VIEW_SELECTION__INCLUDED_VIEW_SELECTION);

		featureSelectionEClass = createEClass(FEATURE_SELECTION);
		createEAttribute(featureSelectionEClass, FEATURE_SELECTION__FEATURE_NAME);
		createEReference(featureSelectionEClass, FEATURE_SELECTION__CONSTRUCT);
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
		FoundationPackage theFoundationPackage = (FoundationPackage) Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		viewSelectionEClass.getESuperTypes().add(theFoundationPackage.getLanguageElement());
		featureSelectionEClass.getESuperTypes().add(theFoundationPackage.getLanguageElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(viewSelectionEClass, ViewSelection.class, "ViewSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getViewSelection_Name(), ecorePackage.getEString(), "name", null, 1, 1, ViewSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getViewSelection_Description(), ecorePackage.getEString(), "description", null, 1, 1, ViewSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getViewSelection_FeatureSelection(), this.getFeatureSelection(), null, "featureSelection", null, 1, -1, ViewSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getViewSelection_ConstructSelection(), theFoundationPackage.getLanguageElement(), null, "constructSelection", null, 1, -1, ViewSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getViewSelection_IncludedViewSelection(), this.getViewSelection(), null, "includedViewSelection", null, 0, -1, ViewSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(featureSelectionEClass, FeatureSelection.class, "FeatureSelection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureSelection_FeatureName(), ecorePackage.getEString(), "featureName", null, 1, 1, FeatureSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFeatureSelection_Construct(), theFoundationPackage.getLanguageElement(), null, "construct", null, 1, 1, FeatureSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //ViewPackageImpl
