/**
 */
package Essence.ActivitySpaceAndActivity.util;

import Essence.ActivitySpaceAndActivity.*;

import Essence.Foundation.BasicElement;
import Essence.Foundation.LanguageElement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage
 * @generated
 */
public class ActivitySpaceAndActivitySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ActivitySpaceAndActivityPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivitySpaceAndActivitySwitch() {
		if (modelPackage == null) {
			modelPackage = ActivitySpaceAndActivityPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ActivitySpaceAndActivityPackage.ACTIVITY_SPACE: {
				ActivitySpace activitySpace = (ActivitySpace)theEObject;
				T result = caseActivitySpace(activitySpace);
				if (result == null) result = caseAbstractActivity(activitySpace);
				if (result == null) result = caseBasicElement(activitySpace);
				if (result == null) result = caseLanguageElement(activitySpace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivitySpaceAndActivityPackage.ACTIVITY: {
				Activity activity = (Activity)theEObject;
				T result = caseActivity(activity);
				if (result == null) result = caseAbstractActivity(activity);
				if (result == null) result = caseBasicElement(activity);
				if (result == null) result = caseLanguageElement(activity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION: {
				ActivityAssociation activityAssociation = (ActivityAssociation)theEObject;
				T result = caseActivityAssociation(activityAssociation);
				if (result == null) result = caseLanguageElement(activityAssociation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivitySpaceAndActivityPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseLanguageElement(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivitySpaceAndActivityPackage.CRITERION: {
				Criterion criterion = (Criterion)theEObject;
				T result = caseCriterion(criterion);
				if (result == null) result = caseLanguageElement(criterion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivitySpaceAndActivityPackage.ABSTRACT_ACTIVITY: {
				AbstractActivity abstractActivity = (AbstractActivity)theEObject;
				T result = caseAbstractActivity(abstractActivity);
				if (result == null) result = caseBasicElement(abstractActivity);
				if (result == null) result = caseLanguageElement(abstractActivity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivitySpaceAndActivityPackage.APPROACH: {
				Approach approach = (Approach)theEObject;
				T result = caseApproach(approach);
				if (result == null) result = caseLanguageElement(approach);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivitySpaceAndActivityPackage.COMPLETION_CRITERION: {
				CompletionCriterion completionCriterion = (CompletionCriterion)theEObject;
				T result = caseCompletionCriterion(completionCriterion);
				if (result == null) result = caseCriterion(completionCriterion);
				if (result == null) result = caseLanguageElement(completionCriterion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActivitySpaceAndActivityPackage.ENTRY_CRITERION: {
				EntryCriterion entryCriterion = (EntryCriterion)theEObject;
				T result = caseEntryCriterion(entryCriterion);
				if (result == null) result = caseCriterion(entryCriterion);
				if (result == null) result = caseLanguageElement(entryCriterion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Space</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivitySpace(ActivitySpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivity(Activity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Association</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Association</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityAssociation(ActivityAssociation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Criterion</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCriterion(Criterion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Activity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Activity</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractActivity(AbstractActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Approach</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Approach</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApproach(Approach object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Completion Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Completion Criterion</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompletionCriterion(CompletionCriterion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Criterion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Criterion</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryCriterion(EntryCriterion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Language Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Language Element</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLanguageElement(LanguageElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Element</em>'.
	 * @see #doSwitch(EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicElement(BasicElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ActivitySpaceAndActivitySwitch
