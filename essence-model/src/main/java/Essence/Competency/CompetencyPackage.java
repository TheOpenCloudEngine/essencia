/**
 */
package Essence.Competency;

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
 * @see Essence.Competency.CompetencyFactory
 * @model kind="package"
 * @generated
 */
public interface CompetencyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Competency";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/Essence/20140301#Competency";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "essence.Competency";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CompetencyPackage eINSTANCE = Essence.Competency.impl.CompetencyPackageImpl.init();

	/**
	 * The meta object id for the '{@link Essence.Competency.impl.CompetencyImpl <em>Competency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Competency.impl.CompetencyImpl
	 * @see Essence.Competency.impl.CompetencyPackageImpl#getCompetency()
	 * @generated
	 */
	int COMPETENCY = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY__PROPERTIES = FoundationPackage.BASIC_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY__TAG = FoundationPackage.BASIC_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY__IS_SUPPRESSABLE = FoundationPackage.BASIC_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY__RESOURCE = FoundationPackage.BASIC_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY__OWNER = FoundationPackage.BASIC_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY__NAME = FoundationPackage.BASIC_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY__ICON = FoundationPackage.BASIC_ELEMENT__ICON;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY__BRIEF_DESCRIPTION = FoundationPackage.BASIC_ELEMENT__BRIEF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY__DESCRIPTION = FoundationPackage.BASIC_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Possible Level</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY__POSSIBLE_LEVEL = FoundationPackage.BASIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Competency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_FEATURE_COUNT = FoundationPackage.BASIC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Competency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_OPERATION_COUNT = FoundationPackage.BASIC_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.Competency.impl.CompetencyLevelImpl <em>Level</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.Competency.impl.CompetencyLevelImpl
	 * @see Essence.Competency.impl.CompetencyPackageImpl#getCompetencyLevel()
	 * @generated
	 */
	int COMPETENCY_LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL__NAME = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL__BRIEF_DESCRIPTION = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL__LEVEL = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Checklist Item</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL__CHECKLIST_ITEM = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Level</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPETENCY_LEVEL_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link Essence.Competency.Competency <em>Competency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Competency</em>'.
	 * @see Essence.Competency.Competency
	 * @generated
	 */
	EClass getCompetency();

	/**
	 * Returns the meta object for the containment reference list '{@link Essence.Competency.Competency#getPossibleLevel <em>Possible Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Possible Level</em>'.
	 * @see Essence.Competency.Competency#getPossibleLevel()
	 * @see #getCompetency()
	 * @generated
	 */
	EReference getCompetency_PossibleLevel();

	/**
	 * Returns the meta object for class '{@link Essence.Competency.CompetencyLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Level</em>'.
	 * @see Essence.Competency.CompetencyLevel
	 * @generated
	 */
	EClass getCompetencyLevel();

	/**
	 * Returns the meta object for the attribute '{@link Essence.Competency.CompetencyLevel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Essence.Competency.CompetencyLevel#getName()
	 * @see #getCompetencyLevel()
	 * @generated
	 */
	EAttribute getCompetencyLevel_Name();

	/**
	 * Returns the meta object for the attribute '{@link Essence.Competency.CompetencyLevel#getBriefDescription <em>Brief Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Brief Description</em>'.
	 * @see Essence.Competency.CompetencyLevel#getBriefDescription()
	 * @see #getCompetencyLevel()
	 * @generated
	 */
	EAttribute getCompetencyLevel_BriefDescription();

	/**
	 * Returns the meta object for the attribute '{@link Essence.Competency.CompetencyLevel#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see Essence.Competency.CompetencyLevel#getLevel()
	 * @see #getCompetencyLevel()
	 * @generated
	 */
	EAttribute getCompetencyLevel_Level();

	/**
	 * Returns the meta object for the containment reference list '{@link Essence.Competency.CompetencyLevel#getChecklistItem <em>Checklist Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Checklist Item</em>'.
	 * @see Essence.Competency.CompetencyLevel#getChecklistItem()
	 * @see #getCompetencyLevel()
	 * @generated
	 */
	EReference getCompetencyLevel_ChecklistItem();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CompetencyFactory getCompetencyFactory();

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
		 * The meta object literal for the '{@link Essence.Competency.impl.CompetencyImpl <em>Competency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Competency.impl.CompetencyImpl
		 * @see Essence.Competency.impl.CompetencyPackageImpl#getCompetency()
		 * @generated
		 */
		EClass COMPETENCY = eINSTANCE.getCompetency();

		/**
		 * The meta object literal for the '<em><b>Possible Level</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPETENCY__POSSIBLE_LEVEL = eINSTANCE.getCompetency_PossibleLevel();

		/**
		 * The meta object literal for the '{@link Essence.Competency.impl.CompetencyLevelImpl <em>Level</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.Competency.impl.CompetencyLevelImpl
		 * @see Essence.Competency.impl.CompetencyPackageImpl#getCompetencyLevel()
		 * @generated
		 */
		EClass COMPETENCY_LEVEL = eINSTANCE.getCompetencyLevel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPETENCY_LEVEL__NAME = eINSTANCE.getCompetencyLevel_Name();

		/**
		 * The meta object literal for the '<em><b>Brief Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPETENCY_LEVEL__BRIEF_DESCRIPTION = eINSTANCE.getCompetencyLevel_BriefDescription();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPETENCY_LEVEL__LEVEL = eINSTANCE.getCompetencyLevel_Level();

		/**
		 * The meta object literal for the '<em><b>Checklist Item</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPETENCY_LEVEL__CHECKLIST_ITEM = eINSTANCE.getCompetencyLevel_ChecklistItem();

	}

} //CompetencyPackage
