/**
 */
package Essence.ActivitySpaceAndActivity.util;

import Essence.ActivitySpaceAndActivity.*;

import Essence.Foundation.BasicElement;
import Essence.Foundation.LanguageElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage
 * @generated
 */
public class ActivitySpaceAndActivityAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActivitySpaceAndActivityPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivitySpaceAndActivityAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ActivitySpaceAndActivityPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivitySpaceAndActivitySwitch<Adapter> modelSwitch =
		new ActivitySpaceAndActivitySwitch<Adapter>() {
			@Override
			public Adapter caseActivitySpace(ActivitySpace object) {
				return createActivitySpaceAdapter();
			}
			@Override
			public Adapter caseActivity(Activity object) {
				return createActivityAdapter();
			}
			@Override
			public Adapter caseActivityAssociation(ActivityAssociation object) {
				return createActivityAssociationAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseCriterion(Criterion object) {
				return createCriterionAdapter();
			}
			@Override
			public Adapter caseAbstractActivity(AbstractActivity object) {
				return createAbstractActivityAdapter();
			}
			@Override
			public Adapter caseApproach(Approach object) {
				return createApproachAdapter();
			}
			@Override
			public Adapter caseCompletionCriterion(CompletionCriterion object) {
				return createCompletionCriterionAdapter();
			}
			@Override
			public Adapter caseEntryCriterion(EntryCriterion object) {
				return createEntryCriterionAdapter();
			}
			@Override
			public Adapter caseLanguageElement(LanguageElement object) {
				return createLanguageElementAdapter();
			}
			@Override
			public Adapter caseBasicElement(BasicElement object) {
				return createBasicElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link Essence.ActivitySpaceAndActivity.ActivitySpace <em>Activity Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.ActivitySpaceAndActivity.ActivitySpace
	 * @generated
	 */
	public Adapter createActivitySpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.ActivitySpaceAndActivity.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.ActivitySpaceAndActivity.Activity
	 * @generated
	 */
	public Adapter createActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.ActivitySpaceAndActivity.ActivityAssociation <em>Activity Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.ActivitySpaceAndActivity.ActivityAssociation
	 * @generated
	 */
	public Adapter createActivityAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.ActivitySpaceAndActivity.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.ActivitySpaceAndActivity.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.ActivitySpaceAndActivity.Criterion <em>Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.ActivitySpaceAndActivity.Criterion
	 * @generated
	 */
	public Adapter createCriterionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.ActivitySpaceAndActivity.AbstractActivity <em>Abstract Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.ActivitySpaceAndActivity.AbstractActivity
	 * @generated
	 */
	public Adapter createAbstractActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.ActivitySpaceAndActivity.Approach <em>Approach</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.ActivitySpaceAndActivity.Approach
	 * @generated
	 */
	public Adapter createApproachAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.ActivitySpaceAndActivity.CompletionCriterion <em>Completion Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.ActivitySpaceAndActivity.CompletionCriterion
	 * @generated
	 */
	public Adapter createCompletionCriterionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.ActivitySpaceAndActivity.EntryCriterion <em>Entry Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.ActivitySpaceAndActivity.EntryCriterion
	 * @generated
	 */
	public Adapter createEntryCriterionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.LanguageElement <em>Language Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.LanguageElement
	 * @generated
	 */
	public Adapter createLanguageElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.BasicElement <em>Basic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.BasicElement
	 * @generated
	 */
	public Adapter createBasicElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ActivitySpaceAndActivityAdapterFactory
