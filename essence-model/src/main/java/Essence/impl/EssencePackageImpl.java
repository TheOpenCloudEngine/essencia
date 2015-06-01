/**
 */
package Essence.impl;

import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage;

import Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl;

import Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage;

import Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl;

import Essence.Competency.CompetencyPackage;

import Essence.Competency.impl.CompetencyPackageImpl;

import Essence.DiagramInterchange.DiagramInterchangePackage;

import Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl;

import Essence.EssenceFactory;
import Essence.EssencePackage;

import Essence.Foundation.FoundationPackage;

import Essence.Foundation.impl.FoundationPackageImpl;

import Essence.UserDefinedTypes.UserDefinedTypesPackage;

import Essence.UserDefinedTypes.impl.UserDefinedTypesPackageImpl;

import Essence.View.ViewPackage;

import Essence.View.impl.ViewPackageImpl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EssencePackageImpl extends EPackageImpl implements EssencePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType qNameEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType graphicalElementEDataType = null;

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
	 * @see EssencePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EssencePackageImpl() {
		super(eNS_URI, EssenceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EssencePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EssencePackage init() {
		if (isInited) return (EssencePackage)Registry.INSTANCE.getEPackage(EssencePackage.eNS_URI);

		// Obtain or create and register package
		EssencePackageImpl theEssencePackage = (EssencePackageImpl)(Registry.INSTANCE.get(eNS_URI) instanceof EssencePackageImpl ? Registry.INSTANCE.get(eNS_URI) : new EssencePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		UserDefinedTypesPackageImpl theUserDefinedTypesPackage = (UserDefinedTypesPackageImpl)(Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI) instanceof UserDefinedTypesPackageImpl ? Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI) : UserDefinedTypesPackage.eINSTANCE);
		ActivitySpaceAndActivityPackageImpl theActivitySpaceAndActivityPackage = (ActivitySpaceAndActivityPackageImpl)(Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI) instanceof ActivitySpaceAndActivityPackageImpl ? Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI) : ActivitySpaceAndActivityPackage.eINSTANCE);
		ViewPackageImpl theViewPackage = (ViewPackageImpl)(Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) instanceof ViewPackageImpl ? Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI) : ViewPackage.eINSTANCE);
		FoundationPackageImpl theFoundationPackage = (FoundationPackageImpl)(Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI) instanceof FoundationPackageImpl ? Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI) : FoundationPackage.eINSTANCE);
		CompetencyPackageImpl theCompetencyPackage = (CompetencyPackageImpl)(Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI) instanceof CompetencyPackageImpl ? Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI) : CompetencyPackage.eINSTANCE);
		AlphaAndWorkProductPackageImpl theAlphaAndWorkProductPackage = (AlphaAndWorkProductPackageImpl)(Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) instanceof AlphaAndWorkProductPackageImpl ? Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI) : AlphaAndWorkProductPackage.eINSTANCE);
		DiagramInterchangePackageImpl theDiagramInterchangePackage = (DiagramInterchangePackageImpl)(Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) instanceof DiagramInterchangePackageImpl ? Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI) : DiagramInterchangePackage.eINSTANCE);

		// Create package meta-data objects
		theEssencePackage.createPackageContents();
		theUserDefinedTypesPackage.createPackageContents();
		theActivitySpaceAndActivityPackage.createPackageContents();
		theViewPackage.createPackageContents();
		theFoundationPackage.createPackageContents();
		theCompetencyPackage.createPackageContents();
		theAlphaAndWorkProductPackage.createPackageContents();
		theDiagramInterchangePackage.createPackageContents();

		// Initialize created meta-data
		theEssencePackage.initializePackageContents();
		theUserDefinedTypesPackage.initializePackageContents();
		theActivitySpaceAndActivityPackage.initializePackageContents();
		theViewPackage.initializePackageContents();
		theFoundationPackage.initializePackageContents();
		theCompetencyPackage.initializePackageContents();
		theAlphaAndWorkProductPackage.initializePackageContents();
		theDiagramInterchangePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEssencePackage.freeze();


		// Update the registry and return the package
		Registry.INSTANCE.put(EssencePackage.eNS_URI, theEssencePackage);
		return theEssencePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getQName() {
		return qNameEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getGraphicalElement() {
		return graphicalElementEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssenceFactory getEssenceFactory() {
		return (EssenceFactory)getEFactoryInstance();
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

		// Create data types
		uriEDataType = createEDataType(URI);
		qNameEDataType = createEDataType(QNAME);
		graphicalElementEDataType = createEDataType(GRAPHICAL_ELEMENT);
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
		UserDefinedTypesPackage theUserDefinedTypesPackage = (UserDefinedTypesPackage)Registry.INSTANCE.getEPackage(UserDefinedTypesPackage.eNS_URI);
		ActivitySpaceAndActivityPackage theActivitySpaceAndActivityPackage = (ActivitySpaceAndActivityPackage)Registry.INSTANCE.getEPackage(ActivitySpaceAndActivityPackage.eNS_URI);
		ViewPackage theViewPackage = (ViewPackage)Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI);
		FoundationPackage theFoundationPackage = (FoundationPackage)Registry.INSTANCE.getEPackage(FoundationPackage.eNS_URI);
		CompetencyPackage theCompetencyPackage = (CompetencyPackage)Registry.INSTANCE.getEPackage(CompetencyPackage.eNS_URI);
		AlphaAndWorkProductPackage theAlphaAndWorkProductPackage = (AlphaAndWorkProductPackage)Registry.INSTANCE.getEPackage(AlphaAndWorkProductPackage.eNS_URI);
		DiagramInterchangePackage theDiagramInterchangePackage = (DiagramInterchangePackage)Registry.INSTANCE.getEPackage(DiagramInterchangePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theUserDefinedTypesPackage);
		getESubpackages().add(theActivitySpaceAndActivityPackage);
		getESubpackages().add(theViewPackage);
		getESubpackages().add(theFoundationPackage);
		getESubpackages().add(theCompetencyPackage);
		getESubpackages().add(theAlphaAndWorkProductPackage);
		getESubpackages().add(theDiagramInterchangePackage);

		// Initialize data types
		initEDataType(uriEDataType, Object.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(qNameEDataType, Object.class, "QName", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(graphicalElementEDataType, Object.class, "GraphicalElement", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EssencePackageImpl
