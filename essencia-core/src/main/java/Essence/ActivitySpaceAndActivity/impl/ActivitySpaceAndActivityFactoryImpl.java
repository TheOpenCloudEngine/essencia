/**
 */
package Essence.ActivitySpaceAndActivity.impl;

import Essence.ActivitySpaceAndActivity.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class ActivitySpaceAndActivityFactoryImpl extends EFactoryImpl implements ActivitySpaceAndActivityFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivitySpaceAndActivityFactory init() {
		try {
			ActivitySpaceAndActivityFactory theActivitySpaceAndActivityFactory = (ActivitySpaceAndActivityFactory)EPackage.Registry.INSTANCE.getEFactory(ActivitySpaceAndActivityPackage.eNS_URI);
			if (theActivitySpaceAndActivityFactory != null) {
				return theActivitySpaceAndActivityFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActivitySpaceAndActivityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivitySpaceAndActivityFactoryImpl() {
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
			case ActivitySpaceAndActivityPackage.ACTIVITY_SPACE: return createActivitySpace();
			case ActivitySpaceAndActivityPackage.ACTIVITY: return createActivity();
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION: return createActivityAssociation();
			case ActivitySpaceAndActivityPackage.ACTION: return createAction();
			case ActivitySpaceAndActivityPackage.APPROACH: return createApproach();
			case ActivitySpaceAndActivityPackage.COMPLETION_CRITERION: return createCompletionCriterion();
			case ActivitySpaceAndActivityPackage.ENTRY_CRITERION: return createEntryCriterion();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ActivitySpaceAndActivityPackage.ACTION_KIND:
				return createActionKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ActivitySpaceAndActivityPackage.ACTION_KIND:
				return convertActionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivitySpace createActivitySpace() {
		ActivitySpaceImpl activitySpace = new ActivitySpaceImpl();
		return activitySpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity createActivity() {
		ActivityImpl activity = new ActivityImpl();
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityAssociation createActivityAssociation() {
		ActivityAssociationImpl activityAssociation = new ActivityAssociationImpl();
		return activityAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Approach createApproach() {
		ApproachImpl approach = new ApproachImpl();
		return approach;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionCriterion createCompletionCriterion() {
		CompletionCriterionImpl completionCriterion = new CompletionCriterionImpl();
		return completionCriterion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryCriterion createEntryCriterion() {
		EntryCriterionImpl entryCriterion = new EntryCriterionImpl();
		return entryCriterion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionKind createActionKindFromString(EDataType eDataType, String initialValue) {
		ActionKind result = ActionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivitySpaceAndActivityPackage getActivitySpaceAndActivityPackage() {
		return (ActivitySpaceAndActivityPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActivitySpaceAndActivityPackage getPackage() {
		return ActivitySpaceAndActivityPackage.eINSTANCE;
	}

} //ActivitySpaceAndActivityFactoryImpl
