/**
 */
package Essence.Competency.impl;

import Essence.Competency.Competency;
import Essence.Competency.CompetencyLevel;
import Essence.Competency.CompetencyPackage;

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
 * An implementation of the model object '<em><b>Competency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Essence.Competency.impl.CompetencyImpl#getPossibleLevel <em>Possible Level</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompetencyImpl extends BasicElementImpl implements Competency {
	/**
	 * The cached value of the '{@link #getPossibleLevel() <em>Possible Level</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPossibleLevel()
	 * @generated
	 * @ordered
	 */
	protected EList<CompetencyLevel> possibleLevel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompetencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompetencyPackage.Literals.COMPETENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompetencyLevel> getPossibleLevel() {
		if (possibleLevel == null) {
			possibleLevel = new EObjectContainmentEList<CompetencyLevel>(CompetencyLevel.class, this, CompetencyPackage.COMPETENCY__POSSIBLE_LEVEL);
		}
		return possibleLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompetencyPackage.COMPETENCY__POSSIBLE_LEVEL:
				return ((InternalEList<?>)getPossibleLevel()).basicRemove(otherEnd, msgs);
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
			case CompetencyPackage.COMPETENCY__POSSIBLE_LEVEL:
				return getPossibleLevel();
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
			case CompetencyPackage.COMPETENCY__POSSIBLE_LEVEL:
				getPossibleLevel().clear();
				getPossibleLevel().addAll((Collection<? extends CompetencyLevel>)newValue);
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
			case CompetencyPackage.COMPETENCY__POSSIBLE_LEVEL:
				getPossibleLevel().clear();
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
			case CompetencyPackage.COMPETENCY__POSSIBLE_LEVEL:
				return possibleLevel != null && !possibleLevel.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompetencyImpl
