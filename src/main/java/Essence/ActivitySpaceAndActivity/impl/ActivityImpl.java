/**
 */
package Essence.ActivitySpaceAndActivity.impl;

import Essence.ActivitySpaceAndActivity.Action;
import Essence.ActivitySpaceAndActivity.Activity;
import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage;
import Essence.ActivitySpaceAndActivity.Approach;

import Essence.Competency.CompetencyLevel;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Essence.ActivitySpaceAndActivity.impl.ActivityImpl#getRequiredCompetencyLevel <em>Required Competency Level</em>}</li>
 *   <li>{@link Essence.ActivitySpaceAndActivity.impl.ActivityImpl#getAction <em>Action</em>}</li>
 *   <li>{@link Essence.ActivitySpaceAndActivity.impl.ActivityImpl#getApproach <em>Approach</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends AbstractActivityImpl implements Activity {
	/**
	 * The cached value of the '{@link #getRequiredCompetencyLevel() <em>Required Competency Level</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredCompetencyLevel()
	 * @generated
	 * @ordered
	 */
	protected EList<CompetencyLevel> requiredCompetencyLevel;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> action;

	/**
	 * The cached value of the '{@link #getApproach() <em>Approach</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApproach()
	 * @generated
	 * @ordered
	 */
	protected EList<Approach> approach;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivitySpaceAndActivityPackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompetencyLevel> getRequiredCompetencyLevel() {
		if (requiredCompetencyLevel == null) {
			requiredCompetencyLevel = new EObjectResolvingEList<CompetencyLevel>(CompetencyLevel.class, this, ActivitySpaceAndActivityPackage.ACTIVITY__REQUIRED_COMPETENCY_LEVEL);
		}
		return requiredCompetencyLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getAction() {
		if (action == null) {
			action = new EObjectContainmentEList<Action>(Action.class, this, ActivitySpaceAndActivityPackage.ACTIVITY__ACTION);
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Approach> getApproach() {
		if (approach == null) {
			approach = new EObjectContainmentEList<Approach>(Approach.class, this, ActivitySpaceAndActivityPackage.ACTIVITY__APPROACH);
		}
		return approach;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivitySpaceAndActivityPackage.ACTIVITY__ACTION:
				return ((InternalEList<?>)getAction()).basicRemove(otherEnd, msgs);
			case ActivitySpaceAndActivityPackage.ACTIVITY__APPROACH:
				return ((InternalEList<?>)getApproach()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivitySpaceAndActivityPackage.ACTIVITY__REQUIRED_COMPETENCY_LEVEL:
				return getRequiredCompetencyLevel();
			case ActivitySpaceAndActivityPackage.ACTIVITY__ACTION:
				return getAction();
			case ActivitySpaceAndActivityPackage.ACTIVITY__APPROACH:
				return getApproach();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActivitySpaceAndActivityPackage.ACTIVITY__REQUIRED_COMPETENCY_LEVEL:
				getRequiredCompetencyLevel().clear();
				getRequiredCompetencyLevel().addAll((Collection<? extends CompetencyLevel>)newValue);
				return;
			case ActivitySpaceAndActivityPackage.ACTIVITY__ACTION:
				getAction().clear();
				getAction().addAll((Collection<? extends Action>)newValue);
				return;
			case ActivitySpaceAndActivityPackage.ACTIVITY__APPROACH:
				getApproach().clear();
				getApproach().addAll((Collection<? extends Approach>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ActivitySpaceAndActivityPackage.ACTIVITY__REQUIRED_COMPETENCY_LEVEL:
				getRequiredCompetencyLevel().clear();
				return;
			case ActivitySpaceAndActivityPackage.ACTIVITY__ACTION:
				getAction().clear();
				return;
			case ActivitySpaceAndActivityPackage.ACTIVITY__APPROACH:
				getApproach().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ActivitySpaceAndActivityPackage.ACTIVITY__REQUIRED_COMPETENCY_LEVEL:
				return requiredCompetencyLevel != null && !requiredCompetencyLevel.isEmpty();
			case ActivitySpaceAndActivityPackage.ACTIVITY__ACTION:
				return action != null && !action.isEmpty();
			case ActivitySpaceAndActivityPackage.ACTIVITY__APPROACH:
				return approach != null && !approach.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ActivityImpl
