/**
 */
package Essence.Foundation;

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
 * @see FoundationFactory
 * @model kind="package"
 * @generated
 */
public interface FoundationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Foundation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/Essence/20140301#Foundation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "essence.Foundation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FoundationPackage eINSTANCE = Essence.Foundation.impl.FoundationPackageImpl.init();

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.LanguageElementImpl <em>Language Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.LanguageElementImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getLanguageElement()
	 * @generated
	 */
	int LANGUAGE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ELEMENT__PROPERTIES = 0;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ELEMENT__TAG = 1;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ELEMENT__IS_SUPPRESSABLE = 2;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ELEMENT__RESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ELEMENT__OWNER = 4;

	/**
	 * The number of structural features of the '<em>Language Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ELEMENT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Language Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.BasicElementImpl <em>Basic Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.BasicElementImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getBasicElement()
	 * @generated
	 */
	int BASIC_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT__PROPERTIES = LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT__TAG = LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT__IS_SUPPRESSABLE = LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT__RESOURCE = LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT__OWNER = LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT__NAME = LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT__ICON = LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT__BRIEF_DESCRIPTION = LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT__DESCRIPTION = LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Basic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT_FEATURE_COUNT = LANGUAGE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Basic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEMENT_OPERATION_COUNT = LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.ExtensionElementImpl <em>Extension Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.ExtensionElementImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getExtensionElement()
	 * @generated
	 */
	int EXTENSION_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__PROPERTIES = LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__TAG = LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__IS_SUPPRESSABLE = LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__RESOURCE = LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__OWNER = LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Target Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__TARGET_ATTRIBUTE = LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extension Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__EXTENSION_FUNCTION = LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT__TARGET_ELEMENT = LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Extension Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT_FEATURE_COUNT = LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Extension Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_ELEMENT_OPERATION_COUNT = LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.TagImpl <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.TagImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getTag()
	 * @generated
	 */
	int TAG = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__PROPERTIES = LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__TAG = LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__IS_SUPPRESSABLE = LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__RESOURCE = LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__OWNER = LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__VALUE = LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_OPERATION_COUNT = LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.ElementGroupImpl <em>Element Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.ElementGroupImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getElementGroup()
	 * @generated
	 */
	int ELEMENT_GROUP = 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__PROPERTIES = LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__TAG = LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__IS_SUPPRESSABLE = LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__RESOURCE = LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__OWNER = LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__NAME = LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__ICON = LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__BRIEF_DESCRIPTION = LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__DESCRIPTION = LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Referred Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__REFERRED_ELEMENTS = LANGUAGE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Merge Resolution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__MERGE_RESOLUTION = LANGUAGE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__EXTENSION = LANGUAGE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP__OWNED_ELEMENTS = LANGUAGE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Element Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP_FEATURE_COUNT = LANGUAGE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Element Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_GROUP_OPERATION_COUNT = LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.KernelImpl <em>Kernel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.KernelImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getKernel()
	 * @generated
	 */
	int KERNEL = 5;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__PROPERTIES = ELEMENT_GROUP__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__TAG = ELEMENT_GROUP__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__IS_SUPPRESSABLE = ELEMENT_GROUP__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__RESOURCE = ELEMENT_GROUP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__OWNER = ELEMENT_GROUP__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__NAME = ELEMENT_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__ICON = ELEMENT_GROUP__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__BRIEF_DESCRIPTION = ELEMENT_GROUP__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__DESCRIPTION = ELEMENT_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Referred Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__REFERRED_ELEMENTS = ELEMENT_GROUP__REFERRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Merge Resolution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__MERGE_RESOLUTION = ELEMENT_GROUP__MERGE_RESOLUTION;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__EXTENSION = ELEMENT_GROUP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__OWNED_ELEMENTS = ELEMENT_GROUP__OWNED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Consistency Rules</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL__CONSISTENCY_RULES = ELEMENT_GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Kernel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL_FEATURE_COUNT = ELEMENT_GROUP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Kernel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERNEL_OPERATION_COUNT = ELEMENT_GROUP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.PracticeImpl <em>Practice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.PracticeImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getPractice()
	 * @generated
	 */
	int PRACTICE = 6;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__PROPERTIES = ELEMENT_GROUP__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__TAG = ELEMENT_GROUP__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__IS_SUPPRESSABLE = ELEMENT_GROUP__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__RESOURCE = ELEMENT_GROUP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__OWNER = ELEMENT_GROUP__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__NAME = ELEMENT_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__ICON = ELEMENT_GROUP__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__BRIEF_DESCRIPTION = ELEMENT_GROUP__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__DESCRIPTION = ELEMENT_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Referred Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__REFERRED_ELEMENTS = ELEMENT_GROUP__REFERRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Merge Resolution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__MERGE_RESOLUTION = ELEMENT_GROUP__MERGE_RESOLUTION;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__EXTENSION = ELEMENT_GROUP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__OWNED_ELEMENTS = ELEMENT_GROUP__OWNED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Consistency Rules</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__CONSISTENCY_RULES = ELEMENT_GROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Objective</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__OBJECTIVE = ELEMENT_GROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Measures</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__MEASURES = ELEMENT_GROUP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__ENTRY = ELEMENT_GROUP_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE__RESULT = ELEMENT_GROUP_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Practice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_FEATURE_COUNT = ELEMENT_GROUP_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Practice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_OPERATION_COUNT = ELEMENT_GROUP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.LibraryImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 7;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__PROPERTIES = ELEMENT_GROUP__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__TAG = ELEMENT_GROUP__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__IS_SUPPRESSABLE = ELEMENT_GROUP__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__RESOURCE = ELEMENT_GROUP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNER = ELEMENT_GROUP__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__NAME = ELEMENT_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ICON = ELEMENT_GROUP__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__BRIEF_DESCRIPTION = ELEMENT_GROUP__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__DESCRIPTION = ELEMENT_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Referred Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__REFERRED_ELEMENTS = ELEMENT_GROUP__REFERRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Merge Resolution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__MERGE_RESOLUTION = ELEMENT_GROUP__MERGE_RESOLUTION;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__EXTENSION = ELEMENT_GROUP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__OWNED_ELEMENTS = ELEMENT_GROUP__OWNED_ELEMENTS;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = ELEMENT_GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_OPERATION_COUNT = ELEMENT_GROUP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.PatternImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 8;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__PROPERTIES = BASIC_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__TAG = BASIC_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__IS_SUPPRESSABLE = BASIC_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__RESOURCE = BASIC_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__OWNER = BASIC_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__NAME = BASIC_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__ICON = BASIC_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__BRIEF_DESCRIPTION = BASIC_ELEMENT__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__DESCRIPTION = BASIC_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Association</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__ASSOCIATION = BASIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = BASIC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = BASIC_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.PatternAssociationImpl <em>Pattern Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.PatternAssociationImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getPatternAssociation()
	 * @generated
	 */
	int PATTERN_ASSOCIATION = 9;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ASSOCIATION__PROPERTIES = LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ASSOCIATION__TAG = LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ASSOCIATION__IS_SUPPRESSABLE = LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ASSOCIATION__RESOURCE = LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ASSOCIATION__OWNER = LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ASSOCIATION__NAME = LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ASSOCIATION__ELEMENTS = LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pattern Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ASSOCIATION_FEATURE_COUNT = LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Pattern Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_ASSOCIATION_OPERATION_COUNT = LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.ResourceImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 10;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PROPERTIES = LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__TAG = LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__IS_SUPPRESSABLE = LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__RESOURCE = LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__OWNER = LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__CONTENT = LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_OPERATION_COUNT = LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.EndeavorAssociationImpl <em>Endeavor Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.EndeavorAssociationImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getEndeavorAssociation()
	 * @generated
	 */
	int ENDEAVOR_ASSOCIATION = 11;

	/**
	 * The feature id for the '<em><b>Owned End</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_ASSOCIATION__OWNED_END = 0;

	/**
	 * The feature id for the '<em><b>Member End</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_ASSOCIATION__MEMBER_END = 1;

	/**
	 * The number of structural features of the '<em>Endeavor Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_ASSOCIATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Endeavor Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_ASSOCIATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.EndeavorPropertyImpl <em>Endeavor Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.EndeavorPropertyImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getEndeavorProperty()
	 * @generated
	 */
	int ENDEAVOR_PROPERTY = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_PROPERTY__LOWER_BOUND = 1;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_PROPERTY__UPPER_BOUND = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_PROPERTY__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Owning Association</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_PROPERTY__OWNING_ASSOCIATION = 4;

	/**
	 * The feature id for the '<em><b>Association</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_PROPERTY__ASSOCIATION = 5;

	/**
	 * The feature id for the '<em><b>Language Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_PROPERTY__LANGUAGE_ELEMENT = 6;

	/**
	 * The number of structural features of the '<em>Endeavor Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_PROPERTY_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Endeavor Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENDEAVOR_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.TypeImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.MethodImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 14;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__PROPERTIES = ELEMENT_GROUP__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__TAG = ELEMENT_GROUP__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__IS_SUPPRESSABLE = ELEMENT_GROUP__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__RESOURCE = ELEMENT_GROUP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__OWNER = ELEMENT_GROUP__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NAME = ELEMENT_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__ICON = ELEMENT_GROUP__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__BRIEF_DESCRIPTION = ELEMENT_GROUP__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DESCRIPTION = ELEMENT_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Referred Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__REFERRED_ELEMENTS = ELEMENT_GROUP__REFERRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Merge Resolution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__MERGE_RESOLUTION = ELEMENT_GROUP__MERGE_RESOLUTION;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__EXTENSION = ELEMENT_GROUP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__OWNED_ELEMENTS = ELEMENT_GROUP__OWNED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Base Kernel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__BASE_KERNEL = ELEMENT_GROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__PURPOSE = ELEMENT_GROUP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = ELEMENT_GROUP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_OPERATION_COUNT = ELEMENT_GROUP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.MergeResolutionImpl <em>Merge Resolution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.MergeResolutionImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getMergeResolution()
	 * @generated
	 */
	int MERGE_RESOLUTION = 15;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_RESOLUTION__PROPERTIES = LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_RESOLUTION__TAG = LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_RESOLUTION__IS_SUPPRESSABLE = LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_RESOLUTION__RESOURCE = LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_RESOLUTION__OWNER = LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_RESOLUTION__TARGET_NAME = LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_RESOLUTION__TARGET_ATTRIBUTE = LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolution Function</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_RESOLUTION__RESOLUTION_FUNCTION = LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Merge Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_RESOLUTION_FEATURE_COUNT = LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Merge Resolution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGE_RESOLUTION_OPERATION_COUNT = LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.PracticeAssetImpl <em>Practice Asset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.PracticeAssetImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getPracticeAsset()
	 * @generated
	 */
	int PRACTICE_ASSET = 16;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__PROPERTIES = ELEMENT_GROUP__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__TAG = ELEMENT_GROUP__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__IS_SUPPRESSABLE = ELEMENT_GROUP__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__RESOURCE = ELEMENT_GROUP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__OWNER = ELEMENT_GROUP__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__NAME = ELEMENT_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__ICON = ELEMENT_GROUP__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__BRIEF_DESCRIPTION = ELEMENT_GROUP__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__DESCRIPTION = ELEMENT_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Referred Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__REFERRED_ELEMENTS = ELEMENT_GROUP__REFERRED_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Merge Resolution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__MERGE_RESOLUTION = ELEMENT_GROUP__MERGE_RESOLUTION;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__EXTENSION = ELEMENT_GROUP__EXTENSION;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET__OWNED_ELEMENTS = ELEMENT_GROUP__OWNED_ELEMENTS;

	/**
	 * The number of structural features of the '<em>Practice Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET_FEATURE_COUNT = ELEMENT_GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Practice Asset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRACTICE_ASSET_OPERATION_COUNT = ELEMENT_GROUP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Foundation.impl.CheckpointImpl <em>Checkpoint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Foundation.impl.CheckpointImpl
	 * @see Essence.Foundation.impl.FoundationPackageImpl#getCheckpoint()
	 * @generated
	 */
	int CHECKPOINT = 17;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKPOINT__PROPERTIES = LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKPOINT__TAG = LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKPOINT__IS_SUPPRESSABLE = LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKPOINT__RESOURCE = LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKPOINT__OWNER = LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKPOINT__NAME = LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKPOINT__DESCRIPTION = LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Checkpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKPOINT_FEATURE_COUNT = LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Checkpoint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKPOINT_OPERATION_COUNT = LANGUAGE_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link LanguageElement <em>Language Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Element</em>'.
	 * @see LanguageElement
	 * @generated
	 */
	EClass getLanguageElement();

	/**
	 * Returns the meta object for the containment reference list '{@link LanguageElement#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see LanguageElement#getProperties()
	 * @see #getLanguageElement()
	 * @generated
	 */
	EReference getLanguageElement_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link LanguageElement#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tag</em>'.
	 * @see LanguageElement#getTag()
	 * @see #getLanguageElement()
	 * @generated
	 */
	EReference getLanguageElement_Tag();

	/**
	 * Returns the meta object for the attribute '{@link LanguageElement#isIsSuppressable <em>Is Suppressable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Suppressable</em>'.
	 * @see LanguageElement#isIsSuppressable()
	 * @see #getLanguageElement()
	 * @generated
	 */
	EAttribute getLanguageElement_IsSuppressable();

	/**
	 * Returns the meta object for the containment reference list '{@link LanguageElement#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource</em>'.
	 * @see LanguageElement#getResource()
	 * @see #getLanguageElement()
	 * @generated
	 */
	EReference getLanguageElement_Resource();

	/**
	 * Returns the meta object for the container reference '{@link LanguageElement#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see LanguageElement#getOwner()
	 * @see #getLanguageElement()
	 * @generated
	 */
	EReference getLanguageElement_Owner();

	/**
	 * Returns the meta object for class '{@link BasicElement <em>Basic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Element</em>'.
	 * @see BasicElement
	 * @generated
	 */
	EClass getBasicElement();

	/**
	 * Returns the meta object for the attribute '{@link BasicElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see BasicElement#getName()
	 * @see #getBasicElement()
	 * @generated
	 */
	EAttribute getBasicElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link BasicElement#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see BasicElement#getIcon()
	 * @see #getBasicElement()
	 * @generated
	 */
	EAttribute getBasicElement_Icon();

	/**
	 * Returns the meta object for the attribute '{@link BasicElement#getBriefDescription <em>Brief Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Brief Description</em>'.
	 * @see BasicElement#getBriefDescription()
	 * @see #getBasicElement()
	 * @generated
	 */
	EAttribute getBasicElement_BriefDescription();

	/**
	 * Returns the meta object for the attribute '{@link BasicElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see BasicElement#getDescription()
	 * @see #getBasicElement()
	 * @generated
	 */
	EAttribute getBasicElement_Description();

	/**
	 * Returns the meta object for class '{@link ExtensionElement <em>Extension Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Element</em>'.
	 * @see ExtensionElement
	 * @generated
	 */
	EClass getExtensionElement();

	/**
	 * Returns the meta object for the attribute '{@link ExtensionElement#getTargetAttribute <em>Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Attribute</em>'.
	 * @see ExtensionElement#getTargetAttribute()
	 * @see #getExtensionElement()
	 * @generated
	 */
	EAttribute getExtensionElement_TargetAttribute();

	/**
	 * Returns the meta object for the attribute '{@link ExtensionElement#getExtensionFunction <em>Extension Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension Function</em>'.
	 * @see ExtensionElement#getExtensionFunction()
	 * @see #getExtensionElement()
	 * @generated
	 */
	EAttribute getExtensionElement_ExtensionFunction();

	/**
	 * Returns the meta object for the reference '{@link ExtensionElement#getTargetElement <em>Target Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Element</em>'.
	 * @see ExtensionElement#getTargetElement()
	 * @see #getExtensionElement()
	 * @generated
	 */
	EReference getExtensionElement_TargetElement();

	/**
	 * Returns the meta object for class '{@link Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the attribute '{@link Tag#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see Tag#getValue()
	 * @see #getTag()
	 * @generated
	 */
	EAttribute getTag_Value();

	/**
	 * Returns the meta object for class '{@link ElementGroup <em>Element Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Group</em>'.
	 * @see ElementGroup
	 * @generated
	 */
	EClass getElementGroup();

	/**
	 * Returns the meta object for the attribute '{@link ElementGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ElementGroup#getName()
	 * @see #getElementGroup()
	 * @generated
	 */
	EAttribute getElementGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link ElementGroup#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon</em>'.
	 * @see ElementGroup#getIcon()
	 * @see #getElementGroup()
	 * @generated
	 */
	EAttribute getElementGroup_Icon();

	/**
	 * Returns the meta object for the attribute '{@link ElementGroup#getBriefDescription <em>Brief Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Brief Description</em>'.
	 * @see ElementGroup#getBriefDescription()
	 * @see #getElementGroup()
	 * @generated
	 */
	EAttribute getElementGroup_BriefDescription();

	/**
	 * Returns the meta object for the attribute '{@link ElementGroup#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see ElementGroup#getDescription()
	 * @see #getElementGroup()
	 * @generated
	 */
	EAttribute getElementGroup_Description();

	/**
	 * Returns the meta object for the reference list '{@link ElementGroup#getReferredElements <em>Referred Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referred Elements</em>'.
	 * @see ElementGroup#getReferredElements()
	 * @see #getElementGroup()
	 * @generated
	 */
	EReference getElementGroup_ReferredElements();

	/**
	 * Returns the meta object for the containment reference list '{@link ElementGroup#getMergeResolution <em>Merge Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Merge Resolution</em>'.
	 * @see ElementGroup#getMergeResolution()
	 * @see #getElementGroup()
	 * @generated
	 */
	EReference getElementGroup_MergeResolution();

	/**
	 * Returns the meta object for the containment reference list '{@link ElementGroup#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extension</em>'.
	 * @see ElementGroup#getExtension()
	 * @see #getElementGroup()
	 * @generated
	 */
	EReference getElementGroup_Extension();

	/**
	 * Returns the meta object for the containment reference list '{@link ElementGroup#getOwnedElements <em>Owned Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Elements</em>'.
	 * @see ElementGroup#getOwnedElements()
	 * @see #getElementGroup()
	 * @generated
	 */
	EReference getElementGroup_OwnedElements();

	/**
	 * Returns the meta object for class '{@link Kernel <em>Kernel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Kernel</em>'.
	 * @see Kernel
	 * @generated
	 */
	EClass getKernel();

	/**
	 * Returns the meta object for the attribute '{@link Kernel#getConsistencyRules <em>Consistency Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Consistency Rules</em>'.
	 * @see Kernel#getConsistencyRules()
	 * @see #getKernel()
	 * @generated
	 */
	EAttribute getKernel_ConsistencyRules();

	/**
	 * Returns the meta object for class '{@link Practice <em>Practice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Practice</em>'.
	 * @see Practice
	 * @generated
	 */
	EClass getPractice();

	/**
	 * Returns the meta object for the attribute '{@link Practice#getConsistencyRules <em>Consistency Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Consistency Rules</em>'.
	 * @see Practice#getConsistencyRules()
	 * @see #getPractice()
	 * @generated
	 */
	EAttribute getPractice_ConsistencyRules();

	/**
	 * Returns the meta object for the attribute '{@link Practice#getObjective <em>Objective</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Objective</em>'.
	 * @see Practice#getObjective()
	 * @see #getPractice()
	 * @generated
	 */
	EAttribute getPractice_Objective();

	/**
	 * Returns the meta object for the attribute list '{@link Practice#getMeasures <em>Measures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Measures</em>'.
	 * @see Practice#getMeasures()
	 * @see #getPractice()
	 * @generated
	 */
	EAttribute getPractice_Measures();

	/**
	 * Returns the meta object for the attribute list '{@link Practice#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Entry</em>'.
	 * @see Practice#getEntry()
	 * @see #getPractice()
	 * @generated
	 */
	EAttribute getPractice_Entry();

	/**
	 * Returns the meta object for the attribute list '{@link Practice#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Result</em>'.
	 * @see Practice#getResult()
	 * @see #getPractice()
	 * @generated
	 */
	EAttribute getPractice_Result();

	/**
	 * Returns the meta object for class '{@link Essence.Foundation.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see Essence.Foundation.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for class '{@link Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link Pattern#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Association</em>'.
	 * @see Pattern#getAssociation()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Association();

	/**
	 * Returns the meta object for class '{@link PatternAssociation <em>Pattern Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Association</em>'.
	 * @see PatternAssociation
	 * @generated
	 */
	EClass getPatternAssociation();

	/**
	 * Returns the meta object for the attribute '{@link PatternAssociation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see PatternAssociation#getName()
	 * @see #getPatternAssociation()
	 * @generated
	 */
	EAttribute getPatternAssociation_Name();

	/**
	 * Returns the meta object for the reference list '{@link PatternAssociation#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see PatternAssociation#getElements()
	 * @see #getPatternAssociation()
	 * @generated
	 */
	EReference getPatternAssociation_Elements();

	/**
	 * Returns the meta object for class '{@link Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link Resource#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see Resource#getContent()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Content();

	/**
	 * Returns the meta object for class '{@link EndeavorAssociation <em>Endeavor Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Endeavor Association</em>'.
	 * @see EndeavorAssociation
	 * @generated
	 */
	EClass getEndeavorAssociation();

	/**
	 * Returns the meta object for the containment reference list '{@link EndeavorAssociation#getOwnedEnd <em>Owned End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned End</em>'.
	 * @see EndeavorAssociation#getOwnedEnd()
	 * @see #getEndeavorAssociation()
	 * @generated
	 */
	EReference getEndeavorAssociation_OwnedEnd();

	/**
	 * Returns the meta object for the reference list '{@link EndeavorAssociation#getMemberEnd <em>Member End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Member End</em>'.
	 * @see EndeavorAssociation#getMemberEnd()
	 * @see #getEndeavorAssociation()
	 * @generated
	 */
	EReference getEndeavorAssociation_MemberEnd();

	/**
	 * Returns the meta object for class '{@link Essence.Foundation.EndeavorProperty <em>Endeavor Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Endeavor Property</em>'.
	 * @see Essence.Foundation.EndeavorProperty
	 * @generated
	 */
	EClass getEndeavorProperty();

	/**
	 * Returns the meta object for the attribute '{@link Essence.Foundation.EndeavorProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Essence.Foundation.EndeavorProperty#getName()
	 * @see #getEndeavorProperty()
	 * @generated
	 */
	EAttribute getEndeavorProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link Essence.Foundation.EndeavorProperty#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see Essence.Foundation.EndeavorProperty#getLowerBound()
	 * @see #getEndeavorProperty()
	 * @generated
	 */
	EAttribute getEndeavorProperty_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link Essence.Foundation.EndeavorProperty#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see Essence.Foundation.EndeavorProperty#getUpperBound()
	 * @see #getEndeavorProperty()
	 * @generated
	 */
	EAttribute getEndeavorProperty_UpperBound();

	/**
	 * Returns the meta object for the reference '{@link Essence.Foundation.EndeavorProperty#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see Essence.Foundation.EndeavorProperty#getType()
	 * @see #getEndeavorProperty()
	 * @generated
	 */
	EReference getEndeavorProperty_Type();

	/**
	 * Returns the meta object for the container reference '{@link Essence.Foundation.EndeavorProperty#getOwningAssociation <em>Owning Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Association</em>'.
	 * @see Essence.Foundation.EndeavorProperty#getOwningAssociation()
	 * @see #getEndeavorProperty()
	 * @generated
	 */
	EReference getEndeavorProperty_OwningAssociation();

	/**
	 * Returns the meta object for the reference '{@link Essence.Foundation.EndeavorProperty#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Association</em>'.
	 * @see Essence.Foundation.EndeavorProperty#getAssociation()
	 * @see #getEndeavorProperty()
	 * @generated
	 */
	EReference getEndeavorProperty_Association();

	/**
	 * Returns the meta object for the reference '{@link Essence.Foundation.EndeavorProperty#getLanguageElement <em>Language Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Language Element</em>'.
	 * @see Essence.Foundation.EndeavorProperty#getLanguageElement()
	 * @see #getEndeavorProperty()
	 * @generated
	 */
	EReference getEndeavorProperty_LanguageElement();

	/**
	 * Returns the meta object for class '{@link Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the attribute '{@link Type#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Type#getName()
	 * @see #getType()
	 * @generated
	 */
	EAttribute getType_Name();

	/**
	 * Returns the meta object for class '{@link Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the reference '{@link Method#getBaseKernel <em>Base Kernel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Kernel</em>'.
	 * @see Method#getBaseKernel()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_BaseKernel();

	/**
	 * Returns the meta object for the attribute '{@link Method#getPurpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Purpose</em>'.
	 * @see Method#getPurpose()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Purpose();

	/**
	 * Returns the meta object for class '{@link MergeResolution <em>Merge Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merge Resolution</em>'.
	 * @see MergeResolution
	 * @generated
	 */
	EClass getMergeResolution();

	/**
	 * Returns the meta object for the attribute '{@link MergeResolution#getTargetName <em>Target Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Name</em>'.
	 * @see MergeResolution#getTargetName()
	 * @see #getMergeResolution()
	 * @generated
	 */
	EAttribute getMergeResolution_TargetName();

	/**
	 * Returns the meta object for the attribute '{@link MergeResolution#getTargetAttribute <em>Target Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Attribute</em>'.
	 * @see MergeResolution#getTargetAttribute()
	 * @see #getMergeResolution()
	 * @generated
	 */
	EAttribute getMergeResolution_TargetAttribute();

	/**
	 * Returns the meta object for the attribute '{@link MergeResolution#getResolutionFunction <em>Resolution Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolution Function</em>'.
	 * @see MergeResolution#getResolutionFunction()
	 * @see #getMergeResolution()
	 * @generated
	 */
	EAttribute getMergeResolution_ResolutionFunction();

	/**
	 * Returns the meta object for class '{@link Essence.Foundation.PracticeAsset <em>Practice Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Practice Asset</em>'.
	 * @see Essence.Foundation.PracticeAsset
	 * @generated
	 */
	EClass getPracticeAsset();

	/**
	 * Returns the meta object for class '{@link Checkpoint <em>Checkpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checkpoint</em>'.
	 * @see Checkpoint
	 * @generated
	 */
	EClass getCheckpoint();

	/**
	 * Returns the meta object for the attribute '{@link Checkpoint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Checkpoint#getName()
	 * @see #getCheckpoint()
	 * @generated
	 */
	EAttribute getCheckpoint_Name();

	/**
	 * Returns the meta object for the attribute '{@link Checkpoint#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see Checkpoint#getDescription()
	 * @see #getCheckpoint()
	 * @generated
	 */
	EAttribute getCheckpoint_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FoundationFactory getFoundationFactory();

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
		 * The meta object literal for the '{@link Essence.Foundation.impl.LanguageElementImpl <em>Language Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.LanguageElementImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getLanguageElement()
		 * @generated
		 */
		EClass LANGUAGE_ELEMENT = eINSTANCE.getLanguageElement();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_ELEMENT__PROPERTIES = eINSTANCE.getLanguageElement_Properties();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_ELEMENT__TAG = eINSTANCE.getLanguageElement_Tag();

		/**
		 * The meta object literal for the '<em><b>Is Suppressable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_ELEMENT__IS_SUPPRESSABLE = eINSTANCE.getLanguageElement_IsSuppressable();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_ELEMENT__RESOURCE = eINSTANCE.getLanguageElement_Resource();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_ELEMENT__OWNER = eINSTANCE.getLanguageElement_Owner();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.BasicElementImpl <em>Basic Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.BasicElementImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getBasicElement()
		 * @generated
		 */
		EClass BASIC_ELEMENT = eINSTANCE.getBasicElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_ELEMENT__NAME = eINSTANCE.getBasicElement_Name();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_ELEMENT__ICON = eINSTANCE.getBasicElement_Icon();

		/**
		 * The meta object literal for the '<em><b>Brief Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_ELEMENT__BRIEF_DESCRIPTION = eINSTANCE.getBasicElement_BriefDescription();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_ELEMENT__DESCRIPTION = eINSTANCE.getBasicElement_Description();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.ExtensionElementImpl <em>Extension Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.ExtensionElementImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getExtensionElement()
		 * @generated
		 */
		EClass EXTENSION_ELEMENT = eINSTANCE.getExtensionElement();

		/**
		 * The meta object literal for the '<em><b>Target Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_ELEMENT__TARGET_ATTRIBUTE = eINSTANCE.getExtensionElement_TargetAttribute();

		/**
		 * The meta object literal for the '<em><b>Extension Function</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTENSION_ELEMENT__EXTENSION_FUNCTION = eINSTANCE.getExtensionElement_ExtensionFunction();

		/**
		 * The meta object literal for the '<em><b>Target Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENSION_ELEMENT__TARGET_ELEMENT = eINSTANCE.getExtensionElement_TargetElement();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.TagImpl <em>Tag</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.TagImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getTag()
		 * @generated
		 */
		EClass TAG = eINSTANCE.getTag();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG__VALUE = eINSTANCE.getTag_Value();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.ElementGroupImpl <em>Element Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.ElementGroupImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getElementGroup()
		 * @generated
		 */
		EClass ELEMENT_GROUP = eINSTANCE.getElementGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_GROUP__NAME = eINSTANCE.getElementGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_GROUP__ICON = eINSTANCE.getElementGroup_Icon();

		/**
		 * The meta object literal for the '<em><b>Brief Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_GROUP__BRIEF_DESCRIPTION = eINSTANCE.getElementGroup_BriefDescription();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_GROUP__DESCRIPTION = eINSTANCE.getElementGroup_Description();

		/**
		 * The meta object literal for the '<em><b>Referred Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_GROUP__REFERRED_ELEMENTS = eINSTANCE.getElementGroup_ReferredElements();

		/**
		 * The meta object literal for the '<em><b>Merge Resolution</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_GROUP__MERGE_RESOLUTION = eINSTANCE.getElementGroup_MergeResolution();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_GROUP__EXTENSION = eINSTANCE.getElementGroup_Extension();

		/**
		 * The meta object literal for the '<em><b>Owned Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_GROUP__OWNED_ELEMENTS = eINSTANCE.getElementGroup_OwnedElements();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.KernelImpl <em>Kernel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.KernelImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getKernel()
		 * @generated
		 */
		EClass KERNEL = eINSTANCE.getKernel();

		/**
		 * The meta object literal for the '<em><b>Consistency Rules</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KERNEL__CONSISTENCY_RULES = eINSTANCE.getKernel_ConsistencyRules();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.PracticeImpl <em>Practice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.PracticeImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getPractice()
		 * @generated
		 */
		EClass PRACTICE = eINSTANCE.getPractice();

		/**
		 * The meta object literal for the '<em><b>Consistency Rules</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRACTICE__CONSISTENCY_RULES = eINSTANCE.getPractice_ConsistencyRules();

		/**
		 * The meta object literal for the '<em><b>Objective</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRACTICE__OBJECTIVE = eINSTANCE.getPractice_Objective();

		/**
		 * The meta object literal for the '<em><b>Measures</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRACTICE__MEASURES = eINSTANCE.getPractice_Measures();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRACTICE__ENTRY = eINSTANCE.getPractice_Entry();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRACTICE__RESULT = eINSTANCE.getPractice_Result();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.LibraryImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.PatternImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__ASSOCIATION = eINSTANCE.getPattern_Association();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.PatternAssociationImpl <em>Pattern Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.PatternAssociationImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getPatternAssociation()
		 * @generated
		 */
		EClass PATTERN_ASSOCIATION = eINSTANCE.getPatternAssociation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_ASSOCIATION__NAME = eINSTANCE.getPatternAssociation_Name();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_ASSOCIATION__ELEMENTS = eINSTANCE.getPatternAssociation_Elements();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.ResourceImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__CONTENT = eINSTANCE.getResource_Content();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.EndeavorAssociationImpl <em>Endeavor Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.EndeavorAssociationImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getEndeavorAssociation()
		 * @generated
		 */
		EClass ENDEAVOR_ASSOCIATION = eINSTANCE.getEndeavorAssociation();

		/**
		 * The meta object literal for the '<em><b>Owned End</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDEAVOR_ASSOCIATION__OWNED_END = eINSTANCE.getEndeavorAssociation_OwnedEnd();

		/**
		 * The meta object literal for the '<em><b>Member End</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDEAVOR_ASSOCIATION__MEMBER_END = eINSTANCE.getEndeavorAssociation_MemberEnd();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.EndeavorPropertyImpl <em>Endeavor Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.EndeavorPropertyImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getEndeavorProperty()
		 * @generated
		 */
		EClass ENDEAVOR_PROPERTY = eINSTANCE.getEndeavorProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENDEAVOR_PROPERTY__NAME = eINSTANCE.getEndeavorProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENDEAVOR_PROPERTY__LOWER_BOUND = eINSTANCE.getEndeavorProperty_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENDEAVOR_PROPERTY__UPPER_BOUND = eINSTANCE.getEndeavorProperty_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDEAVOR_PROPERTY__TYPE = eINSTANCE.getEndeavorProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Owning Association</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDEAVOR_PROPERTY__OWNING_ASSOCIATION = eINSTANCE.getEndeavorProperty_OwningAssociation();

		/**
		 * The meta object literal for the '<em><b>Association</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDEAVOR_PROPERTY__ASSOCIATION = eINSTANCE.getEndeavorProperty_Association();

		/**
		 * The meta object literal for the '<em><b>Language Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENDEAVOR_PROPERTY__LANGUAGE_ELEMENT = eINSTANCE.getEndeavorProperty_LanguageElement();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.TypeImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE__NAME = eINSTANCE.getType_Name();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.MethodImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Base Kernel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__BASE_KERNEL = eINSTANCE.getMethod_BaseKernel();

		/**
		 * The meta object literal for the '<em><b>Purpose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__PURPOSE = eINSTANCE.getMethod_Purpose();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.MergeResolutionImpl <em>Merge Resolution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.MergeResolutionImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getMergeResolution()
		 * @generated
		 */
		EClass MERGE_RESOLUTION = eINSTANCE.getMergeResolution();

		/**
		 * The meta object literal for the '<em><b>Target Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MERGE_RESOLUTION__TARGET_NAME = eINSTANCE.getMergeResolution_TargetName();

		/**
		 * The meta object literal for the '<em><b>Target Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MERGE_RESOLUTION__TARGET_ATTRIBUTE = eINSTANCE.getMergeResolution_TargetAttribute();

		/**
		 * The meta object literal for the '<em><b>Resolution Function</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MERGE_RESOLUTION__RESOLUTION_FUNCTION = eINSTANCE.getMergeResolution_ResolutionFunction();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.PracticeAssetImpl <em>Practice Asset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.PracticeAssetImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getPracticeAsset()
		 * @generated
		 */
		EClass PRACTICE_ASSET = eINSTANCE.getPracticeAsset();

		/**
		 * The meta object literal for the '{@link Essence.Foundation.impl.CheckpointImpl <em>Checkpoint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Foundation.impl.CheckpointImpl
		 * @see Essence.Foundation.impl.FoundationPackageImpl#getCheckpoint()
		 * @generated
		 */
		EClass CHECKPOINT = eINSTANCE.getCheckpoint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECKPOINT__NAME = eINSTANCE.getCheckpoint_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECKPOINT__DESCRIPTION = eINSTANCE.getCheckpoint_Description();

	}

} //FoundationPackage
