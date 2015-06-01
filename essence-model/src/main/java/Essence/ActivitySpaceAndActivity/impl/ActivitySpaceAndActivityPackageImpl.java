/**
 */
package Essence.ActivitySpaceAndActivity.impl;

import Essence.ActivitySpaceAndActivity.AbstractActivity;
import Essence.ActivitySpaceAndActivity.Action;
import Essence.ActivitySpaceAndActivity.ActionKind;
import Essence.ActivitySpaceAndActivity.Activity;
import Essence.ActivitySpaceAndActivity.ActivityAssociation;
import Essence.ActivitySpaceAndActivity.ActivitySpace;
import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityFactory;
import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage;
import Essence.ActivitySpaceAndActivity.Approach;
import Essence.ActivitySpaceAndActivity.CompletionCriterion;
import Essence.ActivitySpaceAndActivity.Criterion;
import Essence.ActivitySpaceAndActivity.EntryCriterion;

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

import Essence.View.ViewPackage;

import Essence.View.impl.ViewPackageImpl;

import Essence.impl.EssencePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivitySpaceAndActivityPackageImpl extends EPackageImpl implements ActivitySpaceAndActivityPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activitySpaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass criterionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass approachEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionCriterionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryCriterionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionKindEEnum = null;

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
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ActivitySpaceAndActivityPackageImpl() {
		super(eNS_URI, ActivitySpaceAndActivityFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ActivitySpaceAndActivityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ActivitySpaceAndActivityPackage init() {
		if (isInited) return (ActivitySpaceAndActivityPackage) Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI);

		// Obtain or create and register package
		ActivitySpaceAndActivityPackageImpl theActivitySpaceAndActivityPackage = (ActivitySpaceAndActivityPackageImpl)(Registry.INSTANCE.get(eNS_URI) instanceof ActivitySpaceAndActivityPackageImpl ? Registry.INSTANCE.get(eNS_URI) : new ActivitySpaceAndActivityPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EssencePackageImpl theEssencePackage = (EssencePackageImpl)(Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI) instanceof EssencePackageImpl ? Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI) : EssencePackage.eINSTANCE);
		UserDefinedTypesPackageImpl theUserDefinedTypesPackage = (UserDefinedTypesPackageImpl)(Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI) instanceof UserDefinedTypesPackageImpl ? Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI) : UserDefinedTypesPackage.eINSTANCE);
		ViewPackageImpl theViewPackage = (ViewPackageImpl)(Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) instanceof ViewPackageImpl ? Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) : ViewPackage.eINSTANCE);
		FoundationPackageImpl theFoundationPackage = (FoundationPackageImpl)(Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI) instanceof FoundationPackageImpl ? Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI) : FoundationPackage.eINSTANCE);
		CompetencyPackageImpl theCompetencyPackage = (CompetencyPackageImpl)(Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI) instanceof CompetencyPackageImpl ? Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI) : CompetencyPackage.eINSTANCE);
		AlphaAndWorkProductPackageImpl theAlphaAndWorkProductPackage = (AlphaAndWorkProductPackageImpl)(Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) instanceof AlphaAndWorkProductPackageImpl ? Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) : AlphaAndWorkProductPackage.eINSTANCE);
		DiagramInterchangePackageImpl theDiagramInterchangePackage = (DiagramInterchangePackageImpl)(Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) instanceof DiagramInterchangePackageImpl ? Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) : DiagramInterchangePackage.eINSTANCE);

		// Create package meta-data objects
		theActivitySpaceAndActivityPackage.createPackageContents();
		theEssencePackage.createPackageContents();
		theUserDefinedTypesPackage.createPackageContents();
		theViewPackage.createPackageContents();
		theFoundationPackage.createPackageContents();
		theCompetencyPackage.createPackageContents();
		theAlphaAndWorkProductPackage.createPackageContents();
		theDiagramInterchangePackage.createPackageContents();

		// Initialize created meta-data
		theActivitySpaceAndActivityPackage.initializePackageContents();
		theEssencePackage.initializePackageContents();
		theUserDefinedTypesPackage.initializePackageContents();
		theViewPackage.initializePackageContents();
		theFoundationPackage.initializePackageContents();
		theCompetencyPackage.initializePackageContents();
		theAlphaAndWorkProductPackage.initializePackageContents();
		theDiagramInterchangePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActivitySpaceAndActivityPackage.freeze();


		// Update the registry and return the package
		Registry.INSTANCE.put(ActivitySpaceAndActivityPackage.eNS_URI, theActivitySpaceAndActivityPackage);
		return theActivitySpaceAndActivityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivitySpace() {
		return activitySpaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivitySpace_Input() {
		return (EReference)activitySpaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivity() {
		return activityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_RequiredCompetencyLevel() {
		return (EReference)activityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Action() {
		return (EReference)activityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Approach() {
		return (EReference)activityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivityAssociation() {
		return activityAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityAssociation_Kind() {
		return (EAttribute)activityAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityAssociation_End1() {
		return (EReference)activityAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivityAssociation_End2() {
		return (EReference)activityAssociationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAction_Kind() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_WorkProduct() {
		return (EReference)actionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Alpha() {
		return (EReference)actionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCriterion() {
		return criterionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCriterion_Description() {
		return (EAttribute)criterionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCriterion_State() {
		return (EReference)criterionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCriterion_LevelOfDetail() {
		return (EReference)criterionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractActivity() {
		return abstractActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractActivity_Criterion() {
		return (EReference)abstractActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApproach() {
		return approachEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApproach_Name() {
		return (EAttribute)approachEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApproach_Description() {
		return (EAttribute)approachEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionCriterion() {
		return completionCriterionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntryCriterion() {
		return entryCriterionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionKind() {
		return actionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivitySpaceAndActivityFactory getActivitySpaceAndActivityFactory() {
		return (ActivitySpaceAndActivityFactory)getEFactoryInstance();
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
		activitySpaceEClass = createEClass(ACTIVITY_SPACE);
		createEReference(activitySpaceEClass, ACTIVITY_SPACE__INPUT);

		activityEClass = createEClass(ACTIVITY);
		createEReference(activityEClass, ACTIVITY__REQUIRED_COMPETENCY_LEVEL);
		createEReference(activityEClass, ACTIVITY__ACTION);
		createEReference(activityEClass, ACTIVITY__APPROACH);

		activityAssociationEClass = createEClass(ACTIVITY_ASSOCIATION);
		createEAttribute(activityAssociationEClass, ACTIVITY_ASSOCIATION__KIND);
		createEReference(activityAssociationEClass, ACTIVITY_ASSOCIATION__END1);
		createEReference(activityAssociationEClass, ACTIVITY_ASSOCIATION__END2);

		actionEClass = createEClass(ACTION);
		createEAttribute(actionEClass, ACTION__KIND);
		createEReference(actionEClass, ACTION__WORK_PRODUCT);
		createEReference(actionEClass, ACTION__ALPHA);

		criterionEClass = createEClass(CRITERION);
		createEAttribute(criterionEClass, CRITERION__DESCRIPTION);
		createEReference(criterionEClass, CRITERION__STATE);
		createEReference(criterionEClass, CRITERION__LEVEL_OF_DETAIL);

		abstractActivityEClass = createEClass(ABSTRACT_ACTIVITY);
		createEReference(abstractActivityEClass, ABSTRACT_ACTIVITY__CRITERION);

		approachEClass = createEClass(APPROACH);
		createEAttribute(approachEClass, APPROACH__NAME);
		createEAttribute(approachEClass, APPROACH__DESCRIPTION);

		completionCriterionEClass = createEClass(COMPLETION_CRITERION);

		entryCriterionEClass = createEClass(ENTRY_CRITERION);

		// Create enums
		actionKindEEnum = createEEnum(ACTION_KIND);
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
		AlphaAndWorkProductPackage theAlphaAndWorkProductPackage = (AlphaAndWorkProductPackage) Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI);
		CompetencyPackage theCompetencyPackage = (CompetencyPackage) Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI);
		FoundationPackage theFoundationPackage = (FoundationPackage) Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		activitySpaceEClass.getESuperTypes().add(this.getAbstractActivity());
		activityEClass.getESuperTypes().add(this.getAbstractActivity());
		activityAssociationEClass.getESuperTypes().add(theFoundationPackage.getLanguageElement());
		actionEClass.getESuperTypes().add(theFoundationPackage.getLanguageElement());
		criterionEClass.getESuperTypes().add(theFoundationPackage.getLanguageElement());
		abstractActivityEClass.getESuperTypes().add(theFoundationPackage.getBasicElement());
		approachEClass.getESuperTypes().add(theFoundationPackage.getLanguageElement());
		completionCriterionEClass.getESuperTypes().add(this.getCriterion());
		entryCriterionEClass.getESuperTypes().add(this.getCriterion());

		// Initialize classes, features, and operations; add parameters
		initEClass(activitySpaceEClass, ActivitySpace.class, "ActivitySpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivitySpace_Input(), theAlphaAndWorkProductPackage.getAlpha(), null, "input", null, 0, -1, ActivitySpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(activityEClass, Activity.class, "Activity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivity_RequiredCompetencyLevel(), theCompetencyPackage.getCompetencyLevel(), null, "requiredCompetencyLevel", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivity_Action(), this.getAction(), null, "action", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivity_Approach(), this.getApproach(), null, "approach", null, 1, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(activityAssociationEClass, ActivityAssociation.class, "ActivityAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivityAssociation_Kind(), ecorePackage.getEString(), "kind", null, 1, 1, ActivityAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivityAssociation_End1(), this.getAbstractActivity(), null, "end1", null, 1, 1, ActivityAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActivityAssociation_End2(), this.getAbstractActivity(), null, "end2", null, 1, 1, ActivityAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAction_Kind(), this.getActionKind(), "kind", null, 1, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAction_WorkProduct(), theAlphaAndWorkProductPackage.getWorkProduct(), null, "workProduct", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAction_Alpha(), theAlphaAndWorkProductPackage.getAlpha(), null, "alpha", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(criterionEClass, Criterion.class, "Criterion", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCriterion_Description(), ecorePackage.getEString(), "description", null, 1, 1, Criterion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCriterion_State(), theAlphaAndWorkProductPackage.getState(), null, "state", null, 0, 1, Criterion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCriterion_LevelOfDetail(), theAlphaAndWorkProductPackage.getLevelOfDetail(), null, "levelOfDetail", null, 0, 1, Criterion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(abstractActivityEClass, AbstractActivity.class, "AbstractActivity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractActivity_Criterion(), this.getCriterion(), null, "criterion", null, 1, -1, AbstractActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(approachEClass, Approach.class, "Approach", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getApproach_Name(), ecorePackage.getEString(), "name", null, 1, 1, Approach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getApproach_Description(), ecorePackage.getEString(), "description", null, 1, 1, Approach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(completionCriterionEClass, CompletionCriterion.class, "CompletionCriterion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entryCriterionEClass, EntryCriterion.class, "EntryCriterion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(actionKindEEnum, ActionKind.class, "ActionKind");
		addEEnumLiteral(actionKindEEnum, ActionKind.CREATE);
		addEEnumLiteral(actionKindEEnum, ActionKind.READ);
		addEEnumLiteral(actionKindEEnum, ActionKind.UPDATE);
		addEEnumLiteral(actionKindEEnum, ActionKind.DELETE);
	}

} //ActivitySpaceAndActivityPackageImpl
