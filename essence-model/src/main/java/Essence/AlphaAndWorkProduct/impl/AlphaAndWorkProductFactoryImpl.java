/**
 */
package Essence.AlphaAndWorkProduct.impl;

import Essence.AlphaAndWorkProduct.*;

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
public class AlphaAndWorkProductFactoryImpl extends EFactoryImpl implements AlphaAndWorkProductFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AlphaAndWorkProductFactory init() {
		try {
			AlphaAndWorkProductFactory theAlphaAndWorkProductFactory = (AlphaAndWorkProductFactory)EPackage.Registry.INSTANCE.getEFactory(AlphaAndWorkProductPackage.eNS_URI);
			if (theAlphaAndWorkProductFactory != null) {
				return theAlphaAndWorkProductFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AlphaAndWorkProductFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlphaAndWorkProductFactoryImpl() {
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
			case AlphaAndWorkProductPackage.ALPHA: return createAlpha();
			case AlphaAndWorkProductPackage.STATE: return createState();
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION: return createAlphaAssociation();
			case AlphaAndWorkProductPackage.WORK_PRODUCT: return createWorkProduct();
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST: return createWorkProductManifest();
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT: return createAlphaContainment();
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL: return createLevelOfDetail();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha createAlpha() {
		AlphaImpl alpha = new AlphaImpl();
		return alpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlphaAssociation createAlphaAssociation() {
		AlphaAssociationImpl alphaAssociation = new AlphaAssociationImpl();
		return alphaAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkProduct createWorkProduct() {
		WorkProductImpl workProduct = new WorkProductImpl();
		return workProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkProductManifest createWorkProductManifest() {
		WorkProductManifestImpl workProductManifest = new WorkProductManifestImpl();
		return workProductManifest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlphaContainment createAlphaContainment() {
		AlphaContainmentImpl alphaContainment = new AlphaContainmentImpl();
		return alphaContainment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LevelOfDetail createLevelOfDetail() {
		LevelOfDetailImpl levelOfDetail = new LevelOfDetailImpl();
		return levelOfDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlphaAndWorkProductPackage getAlphaAndWorkProductPackage() {
		return (AlphaAndWorkProductPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AlphaAndWorkProductPackage getPackage() {
		return AlphaAndWorkProductPackage.eINSTANCE;
	}

} //AlphaAndWorkProductFactoryImpl
