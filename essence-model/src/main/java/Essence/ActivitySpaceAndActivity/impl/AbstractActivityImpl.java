/**
 */
package Essence.ActivitySpaceAndActivity.impl;

import Essence.ActivitySpaceAndActivity.AbstractActivity;
import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage;
import Essence.ActivitySpaceAndActivity.Criterion;

import Essence.Foundation.impl.BasicElementImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link AbstractActivityImpl#getCriterion <em>Criterion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractActivityImpl extends BasicElementImpl implements AbstractActivity {
	/**
	 * The cached value of the '{@link #getCriterion() <em>Criterion</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCriterion()
	 * @generated
	 * @ordered
	 */
	protected EList<Criterion> criterion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivitySpaceAndActivityPackage.Literals.ABSTRACT_ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Criterion> getCriterion() {
		if (criterion == null) {
			criterion = new EObjectContainmentEList<Criterion>(Criterion.class, this, ActivitySpaceAndActivityPackage.ABSTRACT_ACTIVITY__CRITERION);
		}
		return criterion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActivitySpaceAndActivityPackage.ABSTRACT_ACTIVITY__CRITERION:
				return ((InternalEList<?>)getCriterion()).basicRemove(otherEnd, msgs);
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
			case ActivitySpaceAndActivityPackage.ABSTRACT_ACTIVITY__CRITERION:
				return getCriterion();
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
			case ActivitySpaceAndActivityPackage.ABSTRACT_ACTIVITY__CRITERION:
				getCriterion().clear();
				getCriterion().addAll((Collection<? extends Criterion>)newValue);
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
			case ActivitySpaceAndActivityPackage.ABSTRACT_ACTIVITY__CRITERION:
				getCriterion().clear();
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
			case ActivitySpaceAndActivityPackage.ABSTRACT_ACTIVITY__CRITERION:
				return criterion != null && !criterion.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AbstractActivityImpl
