/**
 */
package Essence.Foundation.impl;

import Essence.Foundation.*;

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
public class FoundationFactoryImpl extends EFactoryImpl implements FoundationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FoundationFactory init() {
		try {
			FoundationFactory theFoundationFactory = (FoundationFactory)EPackage.Registry.INSTANCE.getEFactory(FoundationPackage.eNS_URI);
			if (theFoundationFactory != null) {
				return theFoundationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FoundationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoundationFactoryImpl() {
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
			case FoundationPackage.EXTENSION_ELEMENT: return createExtensionElement();
			case FoundationPackage.TAG: return createTag();
			case FoundationPackage.KERNEL: return createKernel();
			case FoundationPackage.PRACTICE: return createPractice();
			case FoundationPackage.LIBRARY: return createLibrary();
			case FoundationPackage.PATTERN: return createPattern();
			case FoundationPackage.PATTERN_ASSOCIATION: return createPatternAssociation();
			case FoundationPackage.RESOURCE: return createResource();
			case FoundationPackage.ENDEAVOR_ASSOCIATION: return createEndeavorAssociation();
			case FoundationPackage.ENDEAVOR_PROPERTY: return createEndeavorProperty();
			case FoundationPackage.TYPE: return createType();
			case FoundationPackage.METHOD: return createMethod();
			case FoundationPackage.MERGE_RESOLUTION: return createMergeResolution();
			case FoundationPackage.PRACTICE_ASSET: return createPracticeAsset();
			case FoundationPackage.CHECKPOINT: return createCheckpoint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionElement createExtensionElement() {
		ExtensionElementImpl extensionElement = new ExtensionElementImpl();
		return extensionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag createTag() {
		TagImpl tag = new TagImpl();
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Kernel createKernel() {
		KernelImpl kernel = new KernelImpl();
		return kernel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Practice createPractice() {
		PracticeImpl practice = new PracticeImpl();
		return practice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternAssociation createPatternAssociation() {
		PatternAssociationImpl patternAssociation = new PatternAssociationImpl();
		return patternAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndeavorAssociation createEndeavorAssociation() {
		EndeavorAssociationImpl endeavorAssociation = new EndeavorAssociationImpl();
		return endeavorAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndeavorProperty createEndeavorProperty() {
		EndeavorPropertyImpl endeavorProperty = new EndeavorPropertyImpl();
		return endeavorProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createType() {
		TypeImpl type = new TypeImpl();
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MergeResolution createMergeResolution() {
		MergeResolutionImpl mergeResolution = new MergeResolutionImpl();
		return mergeResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PracticeAsset createPracticeAsset() {
		PracticeAssetImpl practiceAsset = new PracticeAssetImpl();
		return practiceAsset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Checkpoint createCheckpoint() {
		CheckpointImpl checkpoint = new CheckpointImpl();
		return checkpoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoundationPackage getFoundationPackage() {
		return (FoundationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FoundationPackage getPackage() {
		return FoundationPackage.eINSTANCE;
	}

} //FoundationFactoryImpl
