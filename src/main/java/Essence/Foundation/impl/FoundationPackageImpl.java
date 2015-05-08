/**
 */
package Essence.Foundation.impl;

import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage;

import Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl;

import Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage;

import Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl;

import Essence.Competency.CompetencyPackage;

import Essence.Competency.impl.CompetencyPackageImpl;

import Essence.DiagramInterchange.DiagramInterchangePackage;

import Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl;

import Essence.EssencePackage;

import Essence.Foundation.BasicElement;
import Essence.Foundation.Checkpoint;
import Essence.Foundation.ElementGroup;
import Essence.Foundation.EndeavorAssociation;
import Essence.Foundation.EndeavorProperty;
import Essence.Foundation.ExtensionElement;
import Essence.Foundation.FoundationFactory;
import Essence.Foundation.FoundationPackage;
import Essence.Foundation.Kernel;
import Essence.Foundation.LanguageElement;
import Essence.Foundation.Library;
import Essence.Foundation.MergeResolution;
import Essence.Foundation.Method;
import Essence.Foundation.Pattern;
import Essence.Foundation.PatternAssociation;
import Essence.Foundation.Practice;
import Essence.Foundation.PracticeAsset;
import Essence.Foundation.Resource;
import Essence.Foundation.Tag;
import Essence.Foundation.Type;

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
public class FoundationPackageImpl extends EPackageImpl implements FoundationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass languageElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kernelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass practiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endeavorAssociationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endeavorPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mergeResolutionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass practiceAssetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkpointEClass = null;

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
	 * @see Essence.Foundation.FoundationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FoundationPackageImpl() {
		super(eNS_URI, FoundationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FoundationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FoundationPackage init() {
		if (isInited) return (FoundationPackage)EPackage.Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI);

		// Obtain or create and register package
		FoundationPackageImpl theFoundationPackage = (FoundationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FoundationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FoundationPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		EssencePackageImpl theEssencePackage = (EssencePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI) instanceof EssencePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI) : EssencePackage.eINSTANCE);
		UserDefinedTypesPackageImpl theUserDefinedTypesPackage = (UserDefinedTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI) instanceof UserDefinedTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI) : UserDefinedTypesPackage.eINSTANCE);
		ActivitySpaceAndActivityPackageImpl theActivitySpaceAndActivityPackage = (ActivitySpaceAndActivityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI) instanceof ActivitySpaceAndActivityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI) : ActivitySpaceAndActivityPackage.eINSTANCE);
		ViewPackageImpl theViewPackage = (ViewPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) instanceof ViewPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) : ViewPackage.eINSTANCE);
		CompetencyPackageImpl theCompetencyPackage = (CompetencyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI) instanceof CompetencyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI) : CompetencyPackage.eINSTANCE);
		AlphaAndWorkProductPackageImpl theAlphaAndWorkProductPackage = (AlphaAndWorkProductPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) instanceof AlphaAndWorkProductPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) : AlphaAndWorkProductPackage.eINSTANCE);
		DiagramInterchangePackageImpl theDiagramInterchangePackage = (DiagramInterchangePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) instanceof DiagramInterchangePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) : DiagramInterchangePackage.eINSTANCE);

		// Create package meta-data objects
		theFoundationPackage.createPackageContents();
		theEssencePackage.createPackageContents();
		theUserDefinedTypesPackage.createPackageContents();
		theActivitySpaceAndActivityPackage.createPackageContents();
		theViewPackage.createPackageContents();
		theCompetencyPackage.createPackageContents();
		theAlphaAndWorkProductPackage.createPackageContents();
		theDiagramInterchangePackage.createPackageContents();

		// Initialize created meta-data
		theFoundationPackage.initializePackageContents();
		theEssencePackage.initializePackageContents();
		theUserDefinedTypesPackage.initializePackageContents();
		theActivitySpaceAndActivityPackage.initializePackageContents();
		theViewPackage.initializePackageContents();
		theCompetencyPackage.initializePackageContents();
		theAlphaAndWorkProductPackage.initializePackageContents();
		theDiagramInterchangePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFoundationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FoundationPackage.eNS_URI, theFoundationPackage);
		return theFoundationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLanguageElement() {
		return languageElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageElement_Properties() {
		return (EReference)languageElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageElement_Tag() {
		return (EReference)languageElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLanguageElement_IsSuppressable() {
		return (EAttribute)languageElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageElement_Resource() {
		return (EReference)languageElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageElement_Owner() {
		return (EReference)languageElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicElement() {
		return basicElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicElement_Name() {
		return (EAttribute)basicElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicElement_Icon() {
		return (EAttribute)basicElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicElement_BriefDescription() {
		return (EAttribute)basicElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicElement_Description() {
		return (EAttribute)basicElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionElement() {
		return extensionElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionElement_TargetAttribute() {
		return (EAttribute)extensionElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionElement_ExtensionFunction() {
		return (EAttribute)extensionElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionElement_TargetElement() {
		return (EReference)extensionElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTag() {
		return tagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTag_Value() {
		return (EAttribute)tagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementGroup() {
		return elementGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementGroup_Name() {
		return (EAttribute)elementGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementGroup_Icon() {
		return (EAttribute)elementGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementGroup_BriefDescription() {
		return (EAttribute)elementGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementGroup_Description() {
		return (EAttribute)elementGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementGroup_ReferredElements() {
		return (EReference)elementGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementGroup_MergeResolution() {
		return (EReference)elementGroupEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementGroup_Extension() {
		return (EReference)elementGroupEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementGroup_OwnedElements() {
		return (EReference)elementGroupEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKernel() {
		return kernelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKernel_ConsistencyRules() {
		return (EAttribute)kernelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPractice() {
		return practiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPractice_ConsistencyRules() {
		return (EAttribute)practiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPractice_Objective() {
		return (EAttribute)practiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPractice_Measures() {
		return (EAttribute)practiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPractice_Entry() {
		return (EAttribute)practiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPractice_Result() {
		return (EAttribute)practiceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibrary() {
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Association() {
		return (EReference)patternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternAssociation() {
		return patternAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPatternAssociation_Name() {
		return (EAttribute)patternAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternAssociation_Elements() {
		return (EReference)patternAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Content() {
		return (EAttribute)resourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndeavorAssociation() {
		return endeavorAssociationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndeavorAssociation_OwnedEnd() {
		return (EReference)endeavorAssociationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndeavorAssociation_MemberEnd() {
		return (EReference)endeavorAssociationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndeavorProperty() {
		return endeavorPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndeavorProperty_Name() {
		return (EAttribute)endeavorPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndeavorProperty_LowerBound() {
		return (EAttribute)endeavorPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEndeavorProperty_UpperBound() {
		return (EAttribute)endeavorPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndeavorProperty_Type() {
		return (EReference)endeavorPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndeavorProperty_OwningAssociation() {
		return (EReference)endeavorPropertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndeavorProperty_Association() {
		return (EReference)endeavorPropertyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndeavorProperty_LanguageElement() {
		return (EReference)endeavorPropertyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Name() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethod() {
		return methodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethod_BaseKernel() {
		return (EReference)methodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethod_Purpose() {
		return (EAttribute)methodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMergeResolution() {
		return mergeResolutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeResolution_TargetName() {
		return (EAttribute)mergeResolutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeResolution_TargetAttribute() {
		return (EAttribute)mergeResolutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMergeResolution_ResolutionFunction() {
		return (EAttribute)mergeResolutionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPracticeAsset() {
		return practiceAssetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckpoint() {
		return checkpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckpoint_Name() {
		return (EAttribute)checkpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckpoint_Description() {
		return (EAttribute)checkpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoundationFactory getFoundationFactory() {
		return (FoundationFactory)getEFactoryInstance();
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
		languageElementEClass = createEClass(LANGUAGE_ELEMENT);
		createEReference(languageElementEClass, LANGUAGE_ELEMENT__PROPERTIES);
		createEReference(languageElementEClass, LANGUAGE_ELEMENT__TAG);
		createEAttribute(languageElementEClass, LANGUAGE_ELEMENT__IS_SUPPRESSABLE);
		createEReference(languageElementEClass, LANGUAGE_ELEMENT__RESOURCE);
		createEReference(languageElementEClass, LANGUAGE_ELEMENT__OWNER);

		basicElementEClass = createEClass(BASIC_ELEMENT);
		createEAttribute(basicElementEClass, BASIC_ELEMENT__NAME);
		createEAttribute(basicElementEClass, BASIC_ELEMENT__ICON);
		createEAttribute(basicElementEClass, BASIC_ELEMENT__BRIEF_DESCRIPTION);
		createEAttribute(basicElementEClass, BASIC_ELEMENT__DESCRIPTION);

		extensionElementEClass = createEClass(EXTENSION_ELEMENT);
		createEAttribute(extensionElementEClass, EXTENSION_ELEMENT__TARGET_ATTRIBUTE);
		createEAttribute(extensionElementEClass, EXTENSION_ELEMENT__EXTENSION_FUNCTION);
		createEReference(extensionElementEClass, EXTENSION_ELEMENT__TARGET_ELEMENT);

		tagEClass = createEClass(TAG);
		createEAttribute(tagEClass, TAG__VALUE);

		elementGroupEClass = createEClass(ELEMENT_GROUP);
		createEAttribute(elementGroupEClass, ELEMENT_GROUP__NAME);
		createEAttribute(elementGroupEClass, ELEMENT_GROUP__ICON);
		createEAttribute(elementGroupEClass, ELEMENT_GROUP__BRIEF_DESCRIPTION);
		createEAttribute(elementGroupEClass, ELEMENT_GROUP__DESCRIPTION);
		createEReference(elementGroupEClass, ELEMENT_GROUP__REFERRED_ELEMENTS);
		createEReference(elementGroupEClass, ELEMENT_GROUP__MERGE_RESOLUTION);
		createEReference(elementGroupEClass, ELEMENT_GROUP__EXTENSION);
		createEReference(elementGroupEClass, ELEMENT_GROUP__OWNED_ELEMENTS);

		kernelEClass = createEClass(KERNEL);
		createEAttribute(kernelEClass, KERNEL__CONSISTENCY_RULES);

		practiceEClass = createEClass(PRACTICE);
		createEAttribute(practiceEClass, PRACTICE__CONSISTENCY_RULES);
		createEAttribute(practiceEClass, PRACTICE__OBJECTIVE);
		createEAttribute(practiceEClass, PRACTICE__MEASURES);
		createEAttribute(practiceEClass, PRACTICE__ENTRY);
		createEAttribute(practiceEClass, PRACTICE__RESULT);

		libraryEClass = createEClass(LIBRARY);

		patternEClass = createEClass(PATTERN);
		createEReference(patternEClass, PATTERN__ASSOCIATION);

		patternAssociationEClass = createEClass(PATTERN_ASSOCIATION);
		createEAttribute(patternAssociationEClass, PATTERN_ASSOCIATION__NAME);
		createEReference(patternAssociationEClass, PATTERN_ASSOCIATION__ELEMENTS);

		resourceEClass = createEClass(RESOURCE);
		createEAttribute(resourceEClass, RESOURCE__CONTENT);

		endeavorAssociationEClass = createEClass(ENDEAVOR_ASSOCIATION);
		createEReference(endeavorAssociationEClass, ENDEAVOR_ASSOCIATION__OWNED_END);
		createEReference(endeavorAssociationEClass, ENDEAVOR_ASSOCIATION__MEMBER_END);

		endeavorPropertyEClass = createEClass(ENDEAVOR_PROPERTY);
		createEAttribute(endeavorPropertyEClass, ENDEAVOR_PROPERTY__NAME);
		createEAttribute(endeavorPropertyEClass, ENDEAVOR_PROPERTY__LOWER_BOUND);
		createEAttribute(endeavorPropertyEClass, ENDEAVOR_PROPERTY__UPPER_BOUND);
		createEReference(endeavorPropertyEClass, ENDEAVOR_PROPERTY__TYPE);
		createEReference(endeavorPropertyEClass, ENDEAVOR_PROPERTY__OWNING_ASSOCIATION);
		createEReference(endeavorPropertyEClass, ENDEAVOR_PROPERTY__ASSOCIATION);
		createEReference(endeavorPropertyEClass, ENDEAVOR_PROPERTY__LANGUAGE_ELEMENT);

		typeEClass = createEClass(TYPE);
		createEAttribute(typeEClass, TYPE__NAME);

		methodEClass = createEClass(METHOD);
		createEReference(methodEClass, METHOD__BASE_KERNEL);
		createEAttribute(methodEClass, METHOD__PURPOSE);

		mergeResolutionEClass = createEClass(MERGE_RESOLUTION);
		createEAttribute(mergeResolutionEClass, MERGE_RESOLUTION__TARGET_NAME);
		createEAttribute(mergeResolutionEClass, MERGE_RESOLUTION__TARGET_ATTRIBUTE);
		createEAttribute(mergeResolutionEClass, MERGE_RESOLUTION__RESOLUTION_FUNCTION);

		practiceAssetEClass = createEClass(PRACTICE_ASSET);

		checkpointEClass = createEClass(CHECKPOINT);
		createEAttribute(checkpointEClass, CHECKPOINT__NAME);
		createEAttribute(checkpointEClass, CHECKPOINT__DESCRIPTION);
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
		EssencePackage theEssencePackage = (EssencePackage)EPackage.Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		basicElementEClass.getESuperTypes().add(this.getLanguageElement());
		extensionElementEClass.getESuperTypes().add(this.getLanguageElement());
		tagEClass.getESuperTypes().add(this.getLanguageElement());
		elementGroupEClass.getESuperTypes().add(this.getLanguageElement());
		kernelEClass.getESuperTypes().add(this.getElementGroup());
		practiceEClass.getESuperTypes().add(this.getElementGroup());
		libraryEClass.getESuperTypes().add(this.getElementGroup());
		patternEClass.getESuperTypes().add(this.getBasicElement());
		patternAssociationEClass.getESuperTypes().add(this.getLanguageElement());
		resourceEClass.getESuperTypes().add(this.getLanguageElement());
		methodEClass.getESuperTypes().add(this.getElementGroup());
		mergeResolutionEClass.getESuperTypes().add(this.getLanguageElement());
		practiceAssetEClass.getESuperTypes().add(this.getElementGroup());
		checkpointEClass.getESuperTypes().add(this.getLanguageElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(languageElementEClass, LanguageElement.class, "LanguageElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLanguageElement_Properties(), this.getEndeavorProperty(), null, "properties", null, 0, -1, LanguageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLanguageElement_Tag(), this.getTag(), null, "tag", null, 0, -1, LanguageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLanguageElement_IsSuppressable(), ecorePackage.getEBoolean(), "isSuppressable", null, 1, 1, LanguageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLanguageElement_Resource(), this.getResource(), null, "resource", null, 0, -1, LanguageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLanguageElement_Owner(), this.getElementGroup(), this.getElementGroup_OwnedElements(), "owner", null, 0, 1, LanguageElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(basicElementEClass, BasicElement.class, "BasicElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBasicElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, BasicElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBasicElement_Icon(), theEssencePackage.getGraphicalElement(), "icon", null, 0, 1, BasicElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBasicElement_BriefDescription(), ecorePackage.getEString(), "briefDescription", null, 1, 1, BasicElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBasicElement_Description(), ecorePackage.getEString(), "description", null, 1, 1, BasicElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(extensionElementEClass, ExtensionElement.class, "ExtensionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtensionElement_TargetAttribute(), ecorePackage.getEString(), "targetAttribute", null, 1, 1, ExtensionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionElement_ExtensionFunction(), ecorePackage.getEString(), "extensionFunction", null, 1, 1, ExtensionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionElement_TargetElement(), this.getLanguageElement(), null, "targetElement", null, 1, 1, ExtensionElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTag_Value(), ecorePackage.getEString(), "value", null, 1, 1, Tag.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(elementGroupEClass, ElementGroup.class, "ElementGroup", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementGroup_Name(), ecorePackage.getEString(), "name", null, 1, 1, ElementGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getElementGroup_Icon(), theEssencePackage.getGraphicalElement(), "icon", null, 0, 1, ElementGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getElementGroup_BriefDescription(), ecorePackage.getEString(), "briefDescription", null, 1, 1, ElementGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getElementGroup_Description(), ecorePackage.getEString(), "description", null, 1, 1, ElementGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getElementGroup_ReferredElements(), this.getLanguageElement(), null, "referredElements", null, 0, -1, ElementGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getElementGroup_MergeResolution(), this.getMergeResolution(), null, "mergeResolution", null, 0, -1, ElementGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getElementGroup_Extension(), this.getExtensionElement(), null, "extension", null, 0, -1, ElementGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getElementGroup_OwnedElements(), this.getLanguageElement(), this.getLanguageElement_Owner(), "ownedElements", null, 0, -1, ElementGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(kernelEClass, Kernel.class, "Kernel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKernel_ConsistencyRules(), ecorePackage.getEString(), "consistencyRules", null, 1, 1, Kernel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(practiceEClass, Practice.class, "Practice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPractice_ConsistencyRules(), ecorePackage.getEString(), "consistencyRules", null, 1, 1, Practice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPractice_Objective(), ecorePackage.getEString(), "objective", null, 1, 1, Practice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPractice_Measures(), ecorePackage.getEString(), "measures", null, 0, -1, Practice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPractice_Entry(), ecorePackage.getEString(), "entry", null, 0, -1, Practice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPractice_Result(), ecorePackage.getEString(), "result", null, 0, -1, Practice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPattern_Association(), this.getPatternAssociation(), null, "association", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(patternAssociationEClass, PatternAssociation.class, "PatternAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPatternAssociation_Name(), ecorePackage.getEString(), "name", null, 1, 1, PatternAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPatternAssociation_Elements(), this.getLanguageElement(), null, "elements", null, 0, -1, PatternAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResource_Content(), ecorePackage.getEString(), "content", null, 1, 1, Resource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(endeavorAssociationEClass, EndeavorAssociation.class, "EndeavorAssociation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndeavorAssociation_OwnedEnd(), this.getEndeavorProperty(), this.getEndeavorProperty_OwningAssociation(), "ownedEnd", null, 0, -1, EndeavorAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndeavorAssociation_MemberEnd(), this.getEndeavorProperty(), this.getEndeavorProperty_Association(), "memberEnd", null, 2, -1, EndeavorAssociation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(endeavorPropertyEClass, EndeavorProperty.class, "EndeavorProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEndeavorProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, EndeavorProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEndeavorProperty_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 1, 1, EndeavorProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEndeavorProperty_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 1, 1, EndeavorProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndeavorProperty_Type(), this.getType(), null, "type", null, 1, 1, EndeavorProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndeavorProperty_OwningAssociation(), this.getEndeavorAssociation(), this.getEndeavorAssociation_OwnedEnd(), "owningAssociation", null, 0, 1, EndeavorProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndeavorProperty_Association(), this.getEndeavorAssociation(), this.getEndeavorAssociation_MemberEnd(), "association", null, 0, 1, EndeavorProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndeavorProperty_LanguageElement(), this.getLanguageElement(), null, "languageElement", null, 1, 1, EndeavorProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getType_Name(), ecorePackage.getEString(), "name", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(methodEClass, Method.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethod_BaseKernel(), this.getKernel(), null, "baseKernel", null, 1, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMethod_Purpose(), ecorePackage.getEString(), "purpose", null, 1, 1, Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mergeResolutionEClass, MergeResolution.class, "MergeResolution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMergeResolution_TargetName(), ecorePackage.getEString(), "targetName", null, 1, 1, MergeResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMergeResolution_TargetAttribute(), ecorePackage.getEString(), "targetAttribute", null, 1, 1, MergeResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMergeResolution_ResolutionFunction(), ecorePackage.getEString(), "resolutionFunction", null, 1, 1, MergeResolution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(practiceAssetEClass, PracticeAsset.class, "PracticeAsset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(checkpointEClass, Checkpoint.class, "Checkpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCheckpoint_Name(), ecorePackage.getEString(), "name", null, 1, 1, Checkpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCheckpoint_Description(), ecorePackage.getEString(), "description", null, 1, 1, Checkpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //FoundationPackageImpl
