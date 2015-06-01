/**
 */
package Essence.View;

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
 * @see ViewFactory
 * @model kind="package"
 * @generated
 */
public interface ViewPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "View";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/Essence/20140301#View";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "essence.View";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ViewPackage eINSTANCE = Essence.View.impl.ViewPackageImpl.init();

	/**
	 * The meta object id for the '{@link Essence.View.impl.ViewSelectionImpl <em>Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.View.impl.ViewSelectionImpl
	 * @see Essence.View.impl.ViewPackageImpl#getViewSelection()
	 * @generated
	 */
	int VIEW_SELECTION = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION__NAME = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION__DESCRIPTION = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature Selection</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION__FEATURE_SELECTION = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Construct Selection</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION__CONSTRUCT_SELECTION = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Included View Selection</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION__INCLUDED_VIEW_SELECTION = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIEW_SELECTION_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.View.impl.FeatureSelectionImpl <em>Feature Selection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.View.impl.FeatureSelectionImpl
	 * @see Essence.View.impl.ViewPackageImpl#getFeatureSelection()
	 * @generated
	 */
	int FEATURE_SELECTION = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SELECTION__PROPERTIES = FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SELECTION__TAG = FoundationPackage.LANGUAGE_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Is Suppressable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SELECTION__IS_SUPPRESSABLE = FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SELECTION__RESOURCE = FoundationPackage.LANGUAGE_ELEMENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SELECTION__OWNER = FoundationPackage.LANGUAGE_ELEMENT__OWNER;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SELECTION__FEATURE_NAME = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Construct</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SELECTION__CONSTRUCT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SELECTION_FEATURE_COUNT = FoundationPackage.LANGUAGE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Feature Selection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SELECTION_OPERATION_COUNT = FoundationPackage.LANGUAGE_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link ViewSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection</em>'.
	 * @see ViewSelection
	 * @generated
	 */
	EClass getViewSelection();

	/**
	 * Returns the meta object for the attribute '{@link ViewSelection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ViewSelection#getName()
	 * @see #getViewSelection()
	 * @generated
	 */
	EAttribute getViewSelection_Name();

	/**
	 * Returns the meta object for the attribute '{@link ViewSelection#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see ViewSelection#getDescription()
	 * @see #getViewSelection()
	 * @generated
	 */
	EAttribute getViewSelection_Description();

	/**
	 * Returns the meta object for the reference list '{@link ViewSelection#getFeatureSelection <em>Feature Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Feature Selection</em>'.
	 * @see ViewSelection#getFeatureSelection()
	 * @see #getViewSelection()
	 * @generated
	 */
	EReference getViewSelection_FeatureSelection();

	/**
	 * Returns the meta object for the reference list '{@link ViewSelection#getConstructSelection <em>Construct Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Construct Selection</em>'.
	 * @see ViewSelection#getConstructSelection()
	 * @see #getViewSelection()
	 * @generated
	 */
	EReference getViewSelection_ConstructSelection();

	/**
	 * Returns the meta object for the reference list '{@link ViewSelection#getIncludedViewSelection <em>Included View Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Included View Selection</em>'.
	 * @see ViewSelection#getIncludedViewSelection()
	 * @see #getViewSelection()
	 * @generated
	 */
	EReference getViewSelection_IncludedViewSelection();

	/**
	 * Returns the meta object for class '{@link FeatureSelection <em>Feature Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Selection</em>'.
	 * @see FeatureSelection
	 * @generated
	 */
	EClass getFeatureSelection();

	/**
	 * Returns the meta object for the attribute '{@link FeatureSelection#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see FeatureSelection#getFeatureName()
	 * @see #getFeatureSelection()
	 * @generated
	 */
	EAttribute getFeatureSelection_FeatureName();

	/**
	 * Returns the meta object for the reference '{@link FeatureSelection#getConstruct <em>Construct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Construct</em>'.
	 * @see FeatureSelection#getConstruct()
	 * @see #getFeatureSelection()
	 * @generated
	 */
	EReference getFeatureSelection_Construct();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ViewFactory getViewFactory();

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
		 * The meta object literal for the '{@link Essence.View.impl.ViewSelectionImpl <em>Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.View.impl.ViewSelectionImpl
		 * @see Essence.View.impl.ViewPackageImpl#getViewSelection()
		 * @generated
		 */
		EClass VIEW_SELECTION = eINSTANCE.getViewSelection();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_SELECTION__NAME = eINSTANCE.getViewSelection_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIEW_SELECTION__DESCRIPTION = eINSTANCE.getViewSelection_Description();

		/**
		 * The meta object literal for the '<em><b>Feature Selection</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_SELECTION__FEATURE_SELECTION = eINSTANCE.getViewSelection_FeatureSelection();

		/**
		 * The meta object literal for the '<em><b>Construct Selection</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_SELECTION__CONSTRUCT_SELECTION = eINSTANCE.getViewSelection_ConstructSelection();

		/**
		 * The meta object literal for the '<em><b>Included View Selection</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIEW_SELECTION__INCLUDED_VIEW_SELECTION = eINSTANCE.getViewSelection_IncludedViewSelection();

		/**
		 * The meta object literal for the '{@link Essence.View.impl.FeatureSelectionImpl <em>Feature Selection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.View.impl.FeatureSelectionImpl
		 * @see Essence.View.impl.ViewPackageImpl#getFeatureSelection()
		 * @generated
		 */
		EClass FEATURE_SELECTION = eINSTANCE.getFeatureSelection();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_SELECTION__FEATURE_NAME = eINSTANCE.getFeatureSelection_FeatureName();

		/**
		 * The meta object literal for the '<em><b>Construct</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_SELECTION__CONSTRUCT = eINSTANCE.getFeatureSelection_Construct();

	}

} //ViewPackage
