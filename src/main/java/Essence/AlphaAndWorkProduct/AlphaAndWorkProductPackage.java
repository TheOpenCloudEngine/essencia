/**
 */
package Essence.AlphaAndWorkProduct;

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
 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductFactory
 * @model kind="package"
 * @generated
 */
public interface AlphaAndWorkProductPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "AlphaAndWorkProduct";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/Essence/20140301#AlphaAndWorkProduct";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "essence.AlphaAndWorkProduct";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AlphaAndWorkProductPackage eINSTANCE = Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl.init();

	/**
	 * The meta object id for the '{@link Essence.AlphaAndWorkProduct.impl.AlphaImpl <em>Alpha</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.AlphaAndWorkProduct.impl.AlphaImpl
	 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getAlpha()
	 * @generated
	 */
	int ALPHA = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA__PROPERTIES = FoundationPackage.BASIC_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA__TAG = FoundationPackage.BASIC_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA__IS_SUPPRESSABLE = FoundationPackage.BASIC_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA__RESOURCE = FoundationPackage.BASIC_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA__OWNER = FoundationPackage.BASIC_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA__NAME = FoundationPackage.BASIC_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA__ICON = FoundationPackage.BASIC_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA__BRIEF_DESCRIPTION = FoundationPackage.BASIC_ELEMENT__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA__DESCRIPTION = FoundationPackage.BASIC_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA__STATES = FoundationPackage.BASIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Alpha</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_FEATURE_COUNT = FoundationPackage.BASIC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Alpha</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_OPERATION_COUNT = FoundationPackage.BASIC_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.AlphaAndWorkProduct.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.AlphaAndWorkProduct.impl.StateImpl
	 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getState()
	 * @generated
	 */
	int STATE = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__DESCRIPTION = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alpha</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ALPHA = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__SUCCESSOR = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Check List Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__CHECK_LIST_ITEM = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl <em>Alpha Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl
	 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getAlphaAssociation()
	 * @generated
	 */
	int ALPHA_ASSOCIATION = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__NAME = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End1lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__END1LOWER_BOUND = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End1upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__END1UPPER_BOUND = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End2lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__END2LOWER_BOUND = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>End2upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__END2UPPER_BOUND = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>End1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__END1 = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>End2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION__END2 = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Alpha Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Alpha Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_ASSOCIATION_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.AlphaAndWorkProduct.impl.WorkProductImpl <em>Work Product</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.AlphaAndWorkProduct.impl.WorkProductImpl
	 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getWorkProduct()
	 * @generated
	 */
	int WORK_PRODUCT = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT__PROPERTIES = FoundationPackage.BASIC_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT__TAG = FoundationPackage.BASIC_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT__IS_SUPPRESSABLE = FoundationPackage.BASIC_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT__RESOURCE = FoundationPackage.BASIC_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT__OWNER = FoundationPackage.BASIC_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT__NAME = FoundationPackage.BASIC_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT__ICON = FoundationPackage.BASIC_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT__BRIEF_DESCRIPTION = FoundationPackage.BASIC_ELEMENT__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT__DESCRIPTION = FoundationPackage.BASIC_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Level Of Detail</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT__LEVEL_OF_DETAIL = FoundationPackage.BASIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Work Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_FEATURE_COUNT = FoundationPackage.BASIC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Work Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_OPERATION_COUNT = FoundationPackage.BASIC_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.AlphaAndWorkProduct.impl.WorkProductManifestImpl <em>Work Product Manifest</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.AlphaAndWorkProduct.impl.WorkProductManifestImpl
	 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getWorkProductManifest()
	 * @generated
	 */
	int WORK_PRODUCT_MANIFEST = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST__LOWER_BOUND = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST__UPPER_BOUND = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alpha</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST__ALPHA = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Work Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST__WORK_PRODUCT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Work Product Manifest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Work Product Manifest</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORK_PRODUCT_MANIFEST_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.AlphaAndWorkProduct.impl.AlphaContainmentImpl <em>Alpha Containment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.AlphaAndWorkProduct.impl.AlphaContainmentImpl
	 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getAlphaContainment()
	 * @generated
	 */
	int ALPHA_CONTAINMENT = 5;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT__LOWER_BOUND = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT__UPPER_BOUND = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Subordinate Alpha</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT__SUBORDINATE_ALPHA = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Super Alpha</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT__SUPER_ALPHA = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Alpha Containment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Alpha Containment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALPHA_CONTAINMENT_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.AlphaAndWorkProduct.impl.LevelOfDetailImpl <em>Level Of Detail</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.AlphaAndWorkProduct.impl.LevelOfDetailImpl
	 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getLevelOfDetail()
	 * @generated
	 */
	int LEVEL_OF_DETAIL = 6;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__NAME = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Sufficient Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__IS_SUFFICIENT_LEVEL = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__DESCRIPTION = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Check List Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__CHECK_LIST_ITEM = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__SUCCESSOR = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Work Product</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL__WORK_PRODUCT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Level Of Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Level Of Detail</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEVEL_OF_DETAIL_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link Essence.AlphaAndWorkProduct.Alpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alpha</em>'.
	 * @see Essence.AlphaAndWorkProduct.Alpha
	 * @generated
	 */
	EClass getAlpha();

	/**
	 * Returns the meta object for the containment reference list '{@link Essence.AlphaAndWorkProduct.Alpha#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see Essence.AlphaAndWorkProduct.Alpha#getStates()
	 * @see #getAlpha()
	 * @generated
	 */
	EReference getAlpha_States();

	/**
	 * Returns the meta object for class '{@link Essence.AlphaAndWorkProduct.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see Essence.AlphaAndWorkProduct.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Essence.AlphaAndWorkProduct.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.State#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see Essence.AlphaAndWorkProduct.State#getDescription()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Description();

	/**
	 * Returns the meta object for the container reference '{@link Essence.AlphaAndWorkProduct.State#getAlpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Alpha</em>'.
	 * @see Essence.AlphaAndWorkProduct.State#getAlpha()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Alpha();

	/**
	 * Returns the meta object for the reference '{@link Essence.AlphaAndWorkProduct.State#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see Essence.AlphaAndWorkProduct.State#getSuccessor()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Successor();

	/**
	 * Returns the meta object for the containment reference list '{@link Essence.AlphaAndWorkProduct.State#getCheckListItem <em>Check List Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Check List Item</em>'.
	 * @see Essence.AlphaAndWorkProduct.State#getCheckListItem()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_CheckListItem();

	/**
	 * Returns the meta object for class '{@link Essence.AlphaAndWorkProduct.AlphaAssociation <em>Alpha Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alpha Association</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaAssociation
	 * @generated
	 */
	EClass getAlphaAssociation();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.AlphaAssociation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaAssociation#getName()
	 * @see #getAlphaAssociation()
	 * @generated
	 */
	EAttribute getAlphaAssociation_Name();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd1lowerBound <em>End1lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End1lower Bound</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd1lowerBound()
	 * @see #getAlphaAssociation()
	 * @generated
	 */
	EAttribute getAlphaAssociation_End1lowerBound();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd1upperBound <em>End1upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End1upper Bound</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd1upperBound()
	 * @see #getAlphaAssociation()
	 * @generated
	 */
	EAttribute getAlphaAssociation_End1upperBound();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd2lowerBound <em>End2lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End2lower Bound</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd2lowerBound()
	 * @see #getAlphaAssociation()
	 * @generated
	 */
	EAttribute getAlphaAssociation_End2lowerBound();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd2upperBound <em>End2upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End2upper Bound</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd2upperBound()
	 * @see #getAlphaAssociation()
	 * @generated
	 */
	EAttribute getAlphaAssociation_End2upperBound();

	/**
	 * Returns the meta object for the reference '{@link Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd1 <em>End1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End1</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd1()
	 * @see #getAlphaAssociation()
	 * @generated
	 */
	EReference getAlphaAssociation_End1();

	/**
	 * Returns the meta object for the reference '{@link Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd2 <em>End2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End2</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaAssociation#getEnd2()
	 * @see #getAlphaAssociation()
	 * @generated
	 */
	EReference getAlphaAssociation_End2();

	/**
	 * Returns the meta object for class '{@link Essence.AlphaAndWorkProduct.WorkProduct <em>Work Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Work Product</em>'.
	 * @see Essence.AlphaAndWorkProduct.WorkProduct
	 * @generated
	 */
	EClass getWorkProduct();

	/**
	 * Returns the meta object for the containment reference list '{@link Essence.AlphaAndWorkProduct.WorkProduct#getLevelOfDetail <em>Level Of Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Level Of Detail</em>'.
	 * @see Essence.AlphaAndWorkProduct.WorkProduct#getLevelOfDetail()
	 * @see #getWorkProduct()
	 * @generated
	 */
	EReference getWorkProduct_LevelOfDetail();

	/**
	 * Returns the meta object for class '{@link Essence.AlphaAndWorkProduct.WorkProductManifest <em>Work Product Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Work Product Manifest</em>'.
	 * @see Essence.AlphaAndWorkProduct.WorkProductManifest
	 * @generated
	 */
	EClass getWorkProductManifest();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see Essence.AlphaAndWorkProduct.WorkProductManifest#getLowerBound()
	 * @see #getWorkProductManifest()
	 * @generated
	 */
	EAttribute getWorkProductManifest_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see Essence.AlphaAndWorkProduct.WorkProductManifest#getUpperBound()
	 * @see #getWorkProductManifest()
	 * @generated
	 */
	EAttribute getWorkProductManifest_UpperBound();

	/**
	 * Returns the meta object for the reference '{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getAlpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Alpha</em>'.
	 * @see Essence.AlphaAndWorkProduct.WorkProductManifest#getAlpha()
	 * @see #getWorkProductManifest()
	 * @generated
	 */
	EReference getWorkProductManifest_Alpha();

	/**
	 * Returns the meta object for the reference '{@link Essence.AlphaAndWorkProduct.WorkProductManifest#getWorkProduct <em>Work Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Work Product</em>'.
	 * @see Essence.AlphaAndWorkProduct.WorkProductManifest#getWorkProduct()
	 * @see #getWorkProductManifest()
	 * @generated
	 */
	EReference getWorkProductManifest_WorkProduct();

	/**
	 * Returns the meta object for class '{@link Essence.AlphaAndWorkProduct.AlphaContainment <em>Alpha Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alpha Containment</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaContainment
	 * @generated
	 */
	EClass getAlphaContainment();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.AlphaContainment#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaContainment#getLowerBound()
	 * @see #getAlphaContainment()
	 * @generated
	 */
	EAttribute getAlphaContainment_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.AlphaContainment#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaContainment#getUpperBound()
	 * @see #getAlphaContainment()
	 * @generated
	 */
	EAttribute getAlphaContainment_UpperBound();

	/**
	 * Returns the meta object for the reference '{@link Essence.AlphaAndWorkProduct.AlphaContainment#getSubordinateAlpha <em>Subordinate Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subordinate Alpha</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaContainment#getSubordinateAlpha()
	 * @see #getAlphaContainment()
	 * @generated
	 */
	EReference getAlphaContainment_SubordinateAlpha();

	/**
	 * Returns the meta object for the reference '{@link Essence.AlphaAndWorkProduct.AlphaContainment#getSuperAlpha <em>Super Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Alpha</em>'.
	 * @see Essence.AlphaAndWorkProduct.AlphaContainment#getSuperAlpha()
	 * @see #getAlphaContainment()
	 * @generated
	 */
	EReference getAlphaContainment_SuperAlpha();

	/**
	 * Returns the meta object for class '{@link Essence.AlphaAndWorkProduct.LevelOfDetail <em>Level Of Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Level Of Detail</em>'.
	 * @see Essence.AlphaAndWorkProduct.LevelOfDetail
	 * @generated
	 */
	EClass getLevelOfDetail();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Essence.AlphaAndWorkProduct.LevelOfDetail#getName()
	 * @see #getLevelOfDetail()
	 * @generated
	 */
	EAttribute getLevelOfDetail_Name();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#isIsSufficientLevel <em>Is Sufficient Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Sufficient Level</em>'.
	 * @see Essence.AlphaAndWorkProduct.LevelOfDetail#isIsSufficientLevel()
	 * @see #getLevelOfDetail()
	 * @generated
	 */
	EAttribute getLevelOfDetail_IsSufficientLevel();

	/**
	 * Returns the meta object for the attribute '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see Essence.AlphaAndWorkProduct.LevelOfDetail#getDescription()
	 * @see #getLevelOfDetail()
	 * @generated
	 */
	EAttribute getLevelOfDetail_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getCheckListItem <em>Check List Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Check List Item</em>'.
	 * @see Essence.AlphaAndWorkProduct.LevelOfDetail#getCheckListItem()
	 * @see #getLevelOfDetail()
	 * @generated
	 */
	EReference getLevelOfDetail_CheckListItem();

	/**
	 * Returns the meta object for the reference '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see Essence.AlphaAndWorkProduct.LevelOfDetail#getSuccessor()
	 * @see #getLevelOfDetail()
	 * @generated
	 */
	EReference getLevelOfDetail_Successor();

	/**
	 * Returns the meta object for the container reference '{@link Essence.AlphaAndWorkProduct.LevelOfDetail#getWorkProduct <em>Work Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Work Product</em>'.
	 * @see Essence.AlphaAndWorkProduct.LevelOfDetail#getWorkProduct()
	 * @see #getLevelOfDetail()
	 * @generated
	 */
	EReference getLevelOfDetail_WorkProduct();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AlphaAndWorkProductFactory getAlphaAndWorkProductFactory();

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
		 * The meta object literal for the '{@link Essence.AlphaAndWorkProduct.impl.AlphaImpl <em>Alpha</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.AlphaAndWorkProduct.impl.AlphaImpl
		 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getAlpha()
		 * @generated
		 */
		EClass ALPHA = eINSTANCE.getAlpha();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALPHA__STATES = eINSTANCE.getAlpha_States();

		/**
		 * The meta object literal for the '{@link Essence.AlphaAndWorkProduct.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.AlphaAndWorkProduct.impl.StateImpl
		 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__DESCRIPTION = eINSTANCE.getState_Description();

		/**
		 * The meta object literal for the '<em><b>Alpha</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__ALPHA = eINSTANCE.getState_Alpha();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__SUCCESSOR = eINSTANCE.getState_Successor();

		/**
		 * The meta object literal for the '<em><b>Check List Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__CHECK_LIST_ITEM = eINSTANCE.getState_CheckListItem();

		/**
		 * The meta object literal for the '{@link Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl <em>Alpha Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl
		 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getAlphaAssociation()
		 * @generated
		 */
		EClass ALPHA_ASSOCIATION = eINSTANCE.getAlphaAssociation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALPHA_ASSOCIATION__NAME = eINSTANCE.getAlphaAssociation_Name();

		/**
		 * The meta object literal for the '<em><b>End1lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALPHA_ASSOCIATION__END1LOWER_BOUND = eINSTANCE.getAlphaAssociation_End1lowerBound();

		/**
		 * The meta object literal for the '<em><b>End1upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALPHA_ASSOCIATION__END1UPPER_BOUND = eINSTANCE.getAlphaAssociation_End1upperBound();

		/**
		 * The meta object literal for the '<em><b>End2lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALPHA_ASSOCIATION__END2LOWER_BOUND = eINSTANCE.getAlphaAssociation_End2lowerBound();

		/**
		 * The meta object literal for the '<em><b>End2upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALPHA_ASSOCIATION__END2UPPER_BOUND = eINSTANCE.getAlphaAssociation_End2upperBound();

		/**
		 * The meta object literal for the '<em><b>End1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALPHA_ASSOCIATION__END1 = eINSTANCE.getAlphaAssociation_End1();

		/**
		 * The meta object literal for the '<em><b>End2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALPHA_ASSOCIATION__END2 = eINSTANCE.getAlphaAssociation_End2();

		/**
		 * The meta object literal for the '{@link Essence.AlphaAndWorkProduct.impl.WorkProductImpl <em>Work Product</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.AlphaAndWorkProduct.impl.WorkProductImpl
		 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getWorkProduct()
		 * @generated
		 */
		EClass WORK_PRODUCT = eINSTANCE.getWorkProduct();

		/**
		 * The meta object literal for the '<em><b>Level Of Detail</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_PRODUCT__LEVEL_OF_DETAIL = eINSTANCE.getWorkProduct_LevelOfDetail();

		/**
		 * The meta object literal for the '{@link Essence.AlphaAndWorkProduct.impl.WorkProductManifestImpl <em>Work Product Manifest</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.AlphaAndWorkProduct.impl.WorkProductManifestImpl
		 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getWorkProductManifest()
		 * @generated
		 */
		EClass WORK_PRODUCT_MANIFEST = eINSTANCE.getWorkProductManifest();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_PRODUCT_MANIFEST__LOWER_BOUND = eINSTANCE.getWorkProductManifest_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORK_PRODUCT_MANIFEST__UPPER_BOUND = eINSTANCE.getWorkProductManifest_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Alpha</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_PRODUCT_MANIFEST__ALPHA = eINSTANCE.getWorkProductManifest_Alpha();

		/**
		 * The meta object literal for the '<em><b>Work Product</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORK_PRODUCT_MANIFEST__WORK_PRODUCT = eINSTANCE.getWorkProductManifest_WorkProduct();

		/**
		 * The meta object literal for the '{@link Essence.AlphaAndWorkProduct.impl.AlphaContainmentImpl <em>Alpha Containment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.AlphaAndWorkProduct.impl.AlphaContainmentImpl
		 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getAlphaContainment()
		 * @generated
		 */
		EClass ALPHA_CONTAINMENT = eINSTANCE.getAlphaContainment();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALPHA_CONTAINMENT__LOWER_BOUND = eINSTANCE.getAlphaContainment_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALPHA_CONTAINMENT__UPPER_BOUND = eINSTANCE.getAlphaContainment_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Subordinate Alpha</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALPHA_CONTAINMENT__SUBORDINATE_ALPHA = eINSTANCE.getAlphaContainment_SubordinateAlpha();

		/**
		 * The meta object literal for the '<em><b>Super Alpha</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALPHA_CONTAINMENT__SUPER_ALPHA = eINSTANCE.getAlphaContainment_SuperAlpha();

		/**
		 * The meta object literal for the '{@link Essence.AlphaAndWorkProduct.impl.LevelOfDetailImpl <em>Level Of Detail</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.AlphaAndWorkProduct.impl.LevelOfDetailImpl
		 * @see Essence.AlphaAndWorkProduct.impl.AlphaAndWorkProductPackageImpl#getLevelOfDetail()
		 * @generated
		 */
		EClass LEVEL_OF_DETAIL = eINSTANCE.getLevelOfDetail();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEVEL_OF_DETAIL__NAME = eINSTANCE.getLevelOfDetail_Name();

		/**
		 * The meta object literal for the '<em><b>Is Sufficient Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEVEL_OF_DETAIL__IS_SUFFICIENT_LEVEL = eINSTANCE.getLevelOfDetail_IsSufficientLevel();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LEVEL_OF_DETAIL__DESCRIPTION = eINSTANCE.getLevelOfDetail_Description();

		/**
		 * The meta object literal for the '<em><b>Check List Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEVEL_OF_DETAIL__CHECK_LIST_ITEM = eINSTANCE.getLevelOfDetail_CheckListItem();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEVEL_OF_DETAIL__SUCCESSOR = eINSTANCE.getLevelOfDetail_Successor();

		/**
		 * The meta object literal for the '<em><b>Work Product</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LEVEL_OF_DETAIL__WORK_PRODUCT = eINSTANCE.getLevelOfDetail_WorkProduct();

	}

} //AlphaAndWorkProductPackage
