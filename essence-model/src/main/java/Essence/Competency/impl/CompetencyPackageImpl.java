/**
 */
package Essence.Competency.impl;

import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage;

import Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl;

import Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage;

import Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl;

import Essence.Competency.Competency;
import Essence.Competency.CompetencyFactory;
import Essence.Competency.CompetencyLevel;
import Essence.Competency.CompetencyPackage;

import Essence.DiagramInterchange.DiagramInterchangePackage;

import Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl;

import Essence.EssencePackage;

import Essence.Foundation.FoundationPackage;

import Essence.Foundation.impl.FoundationPackageImpl;

import Essence.UserDefinedTypes.UserDefinedTypesPackage;

import Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl;

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
public class CompetencyPackageImpl extends EPackageImpl implements CompetencyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass competencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass competencyLevelEClass = null;

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
	 * @see CompetencyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompetencyPackageImpl() {
		super(eNS_URI, CompetencyFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CompetencyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompetencyPackage init() {
		if (isInited) return (CompetencyPackage) Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI);

		// Obtain or create and register package
		CompetencyPackageImpl theCompetencyPackage = (CompetencyPackageImpl)(Registry.INSTANCE.get(eNS_URI) instanceof CompetencyPackageImpl ? Registry.INSTANCE.get(eNS_URI) : new CompetencyPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EssencePackageImpl theEssencePackage = (EssencePackageImpl)(Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI) instanceof EssencePackageImpl ? Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI) : EssencePackage.eINSTANCE);
		UserDefinedTypesPackageImpl theUserDefinedTypesPackage = (UserDefinedTypesPackageImpl)(Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI) instanceof UserDefinedTypesPackageImpl ? Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI) : UserDefinedTypesPackage.eINSTANCE);
		ActivitySpaceAndActivityPackageImpl theActivitySpaceAndActivityPackage = (ActivitySpaceAndActivityPackageImpl)(Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI) instanceof ActivitySpaceAndActivityPackageImpl ? Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI) : ActivitySpaceAndActivityPackage.eINSTANCE);
		ViewPackageImpl theViewPackage = (ViewPackageImpl)(Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) instanceof ViewPackageImpl ? Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) : ViewPackage.eINSTANCE);
		FoundationPackageImpl theFoundationPackage = (FoundationPackageImpl)(Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI) instanceof FoundationPackageImpl ? Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI) : FoundationPackage.eINSTANCE);
		AlphaAndWorkProductPackageImpl theAlphaAndWorkProductPackage = (AlphaAndWorkProductPackageImpl)(Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) instanceof AlphaAndWorkProductPackageImpl ? Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) : AlphaAndWorkProductPackage.eINSTANCE);
		DiagramInterchangePackageImpl theDiagramInterchangePackage = (DiagramInterchangePackageImpl)(Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) instanceof DiagramInterchangePackageImpl ? Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) : DiagramInterchangePackage.eINSTANCE);

		// Create package meta-data objects
		theCompetencyPackage.createPackageContents();
		theEssencePackage.createPackageContents();
		theUserDefinedTypesPackage.createPackageContents();
		theActivitySpaceAndActivityPackage.createPackageContents();
		theViewPackage.createPackageContents();
		theFoundationPackage.createPackageContents();
		theAlphaAndWorkProductPackage.createPackageContents();
		theDiagramInterchangePackage.createPackageContents();

		// Initialize created meta-data
		theCompetencyPackage.initializePackageContents();
		theEssencePackage.initializePackageContents();
		theUserDefinedTypesPackage.initializePackageContents();
		theActivitySpaceAndActivityPackage.initializePackageContents();
		theViewPackage.initializePackageContents();
		theFoundationPackage.initializePackageContents();
		theAlphaAndWorkProductPackage.initializePackageContents();
		theDiagramInterchangePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompetencyPackage.freeze();


		// Update the registry and return the package
		Registry.INSTANCE.put(CompetencyPackage.eNS_URI, theCompetencyPackage);
		return theCompetencyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompetency() {
		return competencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompetency_PossibleLevel() {
		return (EReference)competencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompetencyLevel() {
		return competencyLevelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompetencyLevel_Name() {
		return (EAttribute)competencyLevelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompetencyLevel_BriefDescription() {
		return (EAttribute)competencyLevelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompetencyLevel_Level() {
		return (EAttribute)competencyLevelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompetencyLevel_ChecklistItem() {
		return (EReference)competencyLevelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompetencyFactory getCompetencyFactory() {
		return (CompetencyFactory)getEFactoryInstance();
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
		competencyEClass = createEClass(COMPETENCY);
		createEReference(competencyEClass, COMPETENCY__POSSIBLE_LEVEL);

		competencyLevelEClass = createEClass(COMPETENCY_LEVEL);
		createEAttribute(competencyLevelEClass, COMPETENCY_LEVEL__NAME);
		createEAttribute(competencyLevelEClass, COMPETENCY_LEVEL__BRIEF_DESCRIPTION);
		createEAttribute(competencyLevelEClass, COMPETENCY_LEVEL__LEVEL);
		createEReference(competencyLevelEClass, COMPETENCY_LEVEL__CHECKLIST_ITEM);
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
		competencyEClass.getESuperTypes().add(theFoundationPackage.getBasicElement());
		competencyLevelEClass.getESuperTypes().add(theFoundationPackage.getLanguageElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(competencyEClass, Competency.class, "Competency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompetency_PossibleLevel(), this.getCompetencyLevel(), null, "possibleLevel", null, 0, -1, Competency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(competencyLevelEClass, CompetencyLevel.class, "CompetencyLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompetencyLevel_Name(), ecorePackage.getEString(), "name", null, 1, 1, CompetencyLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCompetencyLevel_BriefDescription(), ecorePackage.getEString(), "briefDescription", null, 1, 1, CompetencyLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCompetencyLevel_Level(), ecorePackage.getEInt(), "level", null, 1, 1, CompetencyLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompetencyLevel_ChecklistItem(), theFoundationPackage.getCheckpoint(), null, "checklistItem", null, 0, -1, CompetencyLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //CompetencyPackageImpl
