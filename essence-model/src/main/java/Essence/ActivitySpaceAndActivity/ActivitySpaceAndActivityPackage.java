/**
 */
package Essence.ActivitySpaceAndActivity;

import Essence.Foundation.FoundationPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see ActivitySpaceAndActivityFactory
 * @model kind="package"
 * @generated
 */
public interface ActivitySpaceAndActivityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ActivitySpaceAndActivity";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/Essence/20140301#ActivitySpaceAndActivity";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "essence.ActivitySpaceAndActivity";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActivitySpaceAndActivityPackage eINSTANCE = Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl.init();

	/**
	 * The meta object id for the '{@link Essence.ActivitySpaceAndActivity.impl.AbstractActivityImpl <em>Abstract Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.ActivitySpaceAndActivity.impl.AbstractActivityImpl
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getAbstractActivity()
	 * @generated
	 */
	int ABSTRACT_ACTIVITY = 5;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__PROPERTIES = FoundationPackage.BASIC_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__TAG = FoundationPackage.BASIC_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__IS_SUPPRESSABLE = FoundationPackage.BASIC_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__RESOURCE = FoundationPackage.BASIC_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__OWNER = FoundationPackage.BASIC_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__NAME = FoundationPackage.BASIC_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__ICON = FoundationPackage.BASIC_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__BRIEF_DESCRIPTION = FoundationPackage.BASIC_ELEMENT__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__DESCRIPTION = FoundationPackage.BASIC_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Criterion</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY__CRITERION = FoundationPackage.BASIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY_FEATURE_COUNT = FoundationPackage.BASIC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTIVITY_OPERATION_COUNT = FoundationPackage.BASIC_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.ActivitySpaceAndActivity.impl.ActivitySpaceImpl <em>Activity Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceImpl
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getActivitySpace()
	 * @generated
	 */
	int ACTIVITY_SPACE = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__PROPERTIES = ABSTRACT_ACTIVITY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__TAG = ABSTRACT_ACTIVITY__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__IS_SUPPRESSABLE = ABSTRACT_ACTIVITY__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__RESOURCE = ABSTRACT_ACTIVITY__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__OWNER = ABSTRACT_ACTIVITY__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__NAME = ABSTRACT_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__ICON = ABSTRACT_ACTIVITY__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__BRIEF_DESCRIPTION = ABSTRACT_ACTIVITY__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__DESCRIPTION = ABSTRACT_ACTIVITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Criterion</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__CRITERION = ABSTRACT_ACTIVITY__CRITERION;

	/**
	 * The feature id for the '<em><b>Input</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE__INPUT = ABSTRACT_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Activity Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE_FEATURE_COUNT = ABSTRACT_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Activity Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_SPACE_OPERATION_COUNT = ABSTRACT_ACTIVITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.ActivitySpaceAndActivity.impl.ActivityImpl <em>Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivityImpl
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getActivity()
	 * @generated
	 */
	int ACTIVITY = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__PROPERTIES = ABSTRACT_ACTIVITY__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__TAG = ABSTRACT_ACTIVITY__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__IS_SUPPRESSABLE = ABSTRACT_ACTIVITY__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__RESOURCE = ABSTRACT_ACTIVITY__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__OWNER = ABSTRACT_ACTIVITY__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__NAME = ABSTRACT_ACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__ICON = ABSTRACT_ACTIVITY__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__BRIEF_DESCRIPTION = ABSTRACT_ACTIVITY__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__DESCRIPTION = ABSTRACT_ACTIVITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Criterion</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__CRITERION = ABSTRACT_ACTIVITY__CRITERION;

	/**
	 * The feature id for the '<em><b>Required Competency Level</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__REQUIRED_COMPETENCY_LEVEL = ABSTRACT_ACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__ACTION = ABSTRACT_ACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Approach</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__APPROACH = ABSTRACT_ACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FEATURE_COUNT = ABSTRACT_ACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_OPERATION_COUNT = ABSTRACT_ACTIVITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.ActivitySpaceAndActivity.impl.ActivityAssociationImpl <em>Activity Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivityAssociationImpl
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getActivityAssociation()
	 * @generated
	 */
	int ACTIVITY_ASSOCIATION = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ASSOCIATION__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ASSOCIATION__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ASSOCIATION__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ASSOCIATION__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ASSOCIATION__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ASSOCIATION__KIND = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ASSOCIATION__END1 = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ASSOCIATION__END2 = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Activity Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ASSOCIATION_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Activity Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_ASSOCIATION_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.ActivitySpaceAndActivity.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.ActivitySpaceAndActivity.impl.ActionImpl
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__KIND = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Work Product</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__WORK_PRODUCT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alpha</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ALPHA = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.ActivitySpaceAndActivity.impl.CriterionImpl <em>Criterion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.ActivitySpaceAndActivity.impl.CriterionImpl
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getCriterion()
	 * @generated
	 */
	int CRITERION = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__DESCRIPTION = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__STATE = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Level Of Detail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION__LEVEL_OF_DETAIL = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITERION_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.ActivitySpaceAndActivity.impl.ApproachImpl <em>Approach</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.ActivitySpaceAndActivity.impl.ApproachImpl
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getApproach()
	 * @generated
	 */
	int APPROACH = 6;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPROACH__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPROACH__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPROACH__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPROACH__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPROACH__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPROACH__NAME = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPROACH__DESCRIPTION = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Approach</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPROACH_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Approach</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPROACH_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.ActivitySpaceAndActivity.impl.CompletionCriterionImpl <em>Completion Criterion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.ActivitySpaceAndActivity.impl.CompletionCriterionImpl
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getCompletionCriterion()
	 * @generated
	 */
	int COMPLETION_CRITERION = 7;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_CRITERION__PROPERTIES = CRITERION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_CRITERION__TAG = CRITERION__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_CRITERION__IS_SUPPRESSABLE = CRITERION__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_CRITERION__RESOURCE = CRITERION__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_CRITERION__OWNER = CRITERION__OWNER;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_CRITERION__DESCRIPTION = CRITERION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_CRITERION__STATE = CRITERION__STATE;

	/**
	 * The feature id for the '<em><b>Level Of Detail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_CRITERION__LEVEL_OF_DETAIL = CRITERION__LEVEL_OF_DETAIL;

	/**
	 * The number of structural features of the '<em>Completion Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_CRITERION_FEATURE_COUNT = CRITERION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Completion Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_CRITERION_OPERATION_COUNT = CRITERION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.ActivitySpaceAndActivity.impl.EntryCriterionImpl <em>Entry Criterion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.ActivitySpaceAndActivity.impl.EntryCriterionImpl
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getEntryCriterion()
	 * @generated
	 */
	int ENTRY_CRITERION = 8;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_CRITERION__PROPERTIES = CRITERION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_CRITERION__TAG = CRITERION__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_CRITERION__IS_SUPPRESSABLE = CRITERION__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_CRITERION__RESOURCE = CRITERION__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_CRITERION__OWNER = CRITERION__OWNER;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_CRITERION__DESCRIPTION = CRITERION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_CRITERION__STATE = CRITERION__STATE;

	/**
	 * The feature id for the '<em><b>Level Of Detail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_CRITERION__LEVEL_OF_DETAIL = CRITERION__LEVEL_OF_DETAIL;

	/**
	 * The number of structural features of the '<em>Entry Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_CRITERION_FEATURE_COUNT = CRITERION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Entry Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_CRITERION_OPERATION_COUNT = CRITERION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link ActionKind <em>Action Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ActionKind
	 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getActionKind()
	 * @generated
	 */
	int ACTION_KIND = 9;


	/**
	 * Returns the meta object for class '{@link ActivitySpace <em>Activity Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Space</em>'.
	 * @see ActivitySpace
	 * @generated
	 */
	EClass getActivitySpace();

	/**
	 * Returns the meta object for the reference list '{@link ActivitySpace#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Input</em>'.
	 * @see ActivitySpace#getInput()
	 * @see #getActivitySpace()
	 * @generated
	 */
	EReference getActivitySpace_Input();

	/**
	 * Returns the meta object for class '{@link Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity</em>'.
	 * @see Activity
	 * @generated
	 */
	EClass getActivity();

	/**
	 * Returns the meta object for the reference list '{@link Activity#getRequiredCompetencyLevel <em>Required Competency Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Competency Level</em>'.
	 * @see Activity#getRequiredCompetencyLevel()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_RequiredCompetencyLevel();

	/**
	 * Returns the meta object for the containment reference list '{@link Activity#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Action</em>'.
	 * @see Activity#getAction()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Action();

	/**
	 * Returns the meta object for the containment reference list '{@link Activity#getApproach <em>Approach</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Approach</em>'.
	 * @see Activity#getApproach()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Approach();

	/**
	 * Returns the meta object for class '{@link ActivityAssociation <em>Activity Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Association</em>'.
	 * @see ActivityAssociation
	 * @generated
	 */
	EClass getActivityAssociation();

	/**
	 * Returns the meta object for the attribute '{@link ActivityAssociation#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see ActivityAssociation#getKind()
	 * @see #getActivityAssociation()
	 * @generated
	 */
	EAttribute getActivityAssociation_Kind();

	/**
	 * Returns the meta object for the reference '{@link ActivityAssociation#getEnd1 <em>End1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End1</em>'.
	 * @see ActivityAssociation#getEnd1()
	 * @see #getActivityAssociation()
	 * @generated
	 */
	EReference getActivityAssociation_End1();

	/**
	 * Returns the meta object for the reference '{@link ActivityAssociation#getEnd2 <em>End2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End2</em>'.
	 * @see ActivityAssociation#getEnd2()
	 * @see #getActivityAssociation()
	 * @generated
	 */
	EReference getActivityAssociation_End2();

	/**
	 * Returns the meta object for class '{@link Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link Action#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see Action#getKind()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Kind();

	/**
	 * Returns the meta object for the reference list '{@link Action#getWorkProduct <em>Work Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Work Product</em>'.
	 * @see Action#getWorkProduct()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_WorkProduct();

	/**
	 * Returns the meta object for the reference list '{@link Action#getAlpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Alpha</em>'.
	 * @see Action#getAlpha()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Alpha();

	/**
	 * Returns the meta object for class '{@link Essence.ActivitySpaceAndActivity.Criterion <em>Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Criterion</em>'.
	 * @see Essence.ActivitySpaceAndActivity.Criterion
	 * @generated
	 */
	EClass getCriterion();

	/**
	 * Returns the meta object for the attribute '{@link Essence.ActivitySpaceAndActivity.Criterion#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see Essence.ActivitySpaceAndActivity.Criterion#getDescription()
	 * @see #getCriterion()
	 * @generated
	 */
	EAttribute getCriterion_Description();

	/**
	 * Returns the meta object for the reference '{@link Essence.ActivitySpaceAndActivity.Criterion#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see Essence.ActivitySpaceAndActivity.Criterion#getState()
	 * @see #getCriterion()
	 * @generated
	 */
	EReference getCriterion_State();

	/**
	 * Returns the meta object for the reference '{@link Essence.ActivitySpaceAndActivity.Criterion#getLevelOfDetail <em>Level Of Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Level Of Detail</em>'.
	 * @see Essence.ActivitySpaceAndActivity.Criterion#getLevelOfDetail()
	 * @see #getCriterion()
	 * @generated
	 */
	EReference getCriterion_LevelOfDetail();

	/**
	 * Returns the meta object for class '{@link AbstractActivity <em>Abstract Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Activity</em>'.
	 * @see AbstractActivity
	 * @generated
	 */
	EClass getAbstractActivity();

	/**
	 * Returns the meta object for the containment reference list '{@link AbstractActivity#getCriterion <em>Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Criterion</em>'.
	 * @see AbstractActivity#getCriterion()
	 * @see #getAbstractActivity()
	 * @generated
	 */
	EReference getAbstractActivity_Criterion();

	/**
	 * Returns the meta object for class '{@link Approach <em>Approach</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Approach</em>'.
	 * @see Approach
	 * @generated
	 */
	EClass getApproach();

	/**
	 * Returns the meta object for the attribute '{@link Approach#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Approach#getName()
	 * @see #getApproach()
	 * @generated
	 */
	EAttribute getApproach_Name();

	/**
	 * Returns the meta object for the attribute '{@link Approach#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see Approach#getDescription()
	 * @see #getApproach()
	 * @generated
	 */
	EAttribute getApproach_Description();

	/**
	 * Returns the meta object for class '{@link CompletionCriterion <em>Completion Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Completion Criterion</em>'.
	 * @see CompletionCriterion
	 * @generated
	 */
	EClass getCompletionCriterion();

	/**
	 * Returns the meta object for class '{@link EntryCriterion <em>Entry Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Criterion</em>'.
	 * @see EntryCriterion
	 * @generated
	 */
	EClass getEntryCriterion();

	/**
	 * Returns the meta object for enum '{@link ActionKind <em>Action Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action Kind</em>'.
	 * @see ActionKind
	 * @generated
	 */
	EEnum getActionKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActivitySpaceAndActivityFactory getActivitySpaceAndActivityFactory();

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
		 * The meta object literal for the '{@link Essence.ActivitySpaceAndActivity.impl.ActivitySpaceImpl <em>Activity Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceImpl
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getActivitySpace()
		 * @generated
		 */
		EClass ACTIVITY_SPACE = eINSTANCE.getActivitySpace();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_SPACE__INPUT = eINSTANCE.getActivitySpace_Input();

		/**
		 * The meta object literal for the '{@link Essence.ActivitySpaceAndActivity.impl.ActivityImpl <em>Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivityImpl
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getActivity()
		 * @generated
		 */
		EClass ACTIVITY = eINSTANCE.getActivity();

		/**
		 * The meta object literal for the '<em><b>Required Competency Level</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__REQUIRED_COMPETENCY_LEVEL = eINSTANCE.getActivity_RequiredCompetencyLevel();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__ACTION = eINSTANCE.getActivity_Action();

		/**
		 * The meta object literal for the '<em><b>Approach</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__APPROACH = eINSTANCE.getActivity_Approach();

		/**
		 * The meta object literal for the '{@link Essence.ActivitySpaceAndActivity.impl.ActivityAssociationImpl <em>Activity Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivityAssociationImpl
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getActivityAssociation()
		 * @generated
		 */
		EClass ACTIVITY_ASSOCIATION = eINSTANCE.getActivityAssociation();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY_ASSOCIATION__KIND = eINSTANCE.getActivityAssociation_Kind();

		/**
		 * The meta object literal for the '<em><b>End1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_ASSOCIATION__END1 = eINSTANCE.getActivityAssociation_End1();

		/**
		 * The meta object literal for the '<em><b>End2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY_ASSOCIATION__END2 = eINSTANCE.getActivityAssociation_End2();

		/**
		 * The meta object literal for the '{@link Essence.ActivitySpaceAndActivity.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.ActivitySpaceAndActivity.impl.ActionImpl
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__KIND = eINSTANCE.getAction_Kind();

		/**
		 * The meta object literal for the '<em><b>Work Product</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__WORK_PRODUCT = eINSTANCE.getAction_WorkProduct();

		/**
		 * The meta object literal for the '<em><b>Alpha</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__ALPHA = eINSTANCE.getAction_Alpha();

		/**
		 * The meta object literal for the '{@link Essence.ActivitySpaceAndActivity.impl.CriterionImpl <em>Criterion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.ActivitySpaceAndActivity.impl.CriterionImpl
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getCriterion()
		 * @generated
		 */
		EClass CRITERION = eINSTANCE.getCriterion();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CRITERION__DESCRIPTION = eINSTANCE.getCriterion_Description();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITERION__STATE = eINSTANCE.getCriterion_State();

		/**
		 * The meta object literal for the '<em><b>Level Of Detail</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITERION__LEVEL_OF_DETAIL = eINSTANCE.getCriterion_LevelOfDetail();

		/**
		 * The meta object literal for the '{@link Essence.ActivitySpaceAndActivity.impl.AbstractActivityImpl <em>Abstract Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.ActivitySpaceAndActivity.impl.AbstractActivityImpl
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getAbstractActivity()
		 * @generated
		 */
		EClass ABSTRACT_ACTIVITY = eINSTANCE.getAbstractActivity();

		/**
		 * The meta object literal for the '<em><b>Criterion</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTIVITY__CRITERION = eINSTANCE.getAbstractActivity_Criterion();

		/**
		 * The meta object literal for the '{@link Essence.ActivitySpaceAndActivity.impl.ApproachImpl <em>Approach</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.ActivitySpaceAndActivity.impl.ApproachImpl
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getApproach()
		 * @generated
		 */
		EClass APPROACH = eINSTANCE.getApproach();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPROACH__NAME = eINSTANCE.getApproach_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPROACH__DESCRIPTION = eINSTANCE.getApproach_Description();

		/**
		 * The meta object literal for the '{@link Essence.ActivitySpaceAndActivity.impl.CompletionCriterionImpl <em>Completion Criterion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.ActivitySpaceAndActivity.impl.CompletionCriterionImpl
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getCompletionCriterion()
		 * @generated
		 */
		EClass COMPLETION_CRITERION = eINSTANCE.getCompletionCriterion();

		/**
		 * The meta object literal for the '{@link Essence.ActivitySpaceAndActivity.impl.EntryCriterionImpl <em>Entry Criterion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.ActivitySpaceAndActivity.impl.EntryCriterionImpl
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getEntryCriterion()
		 * @generated
		 */
		EClass ENTRY_CRITERION = eINSTANCE.getEntryCriterion();

		/**
		 * The meta object literal for the '{@link ActionKind <em>Action Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ActionKind
		 * @see Essence.ActivitySpaceAndActivity.impl.ActivitySpaceAndActivityPackageImpl#getActionKind()
		 * @generated
		 */
		EEnum ACTION_KIND = eINSTANCE.getActionKind();

	}

} //ActivitySpaceAndActivityPackage
