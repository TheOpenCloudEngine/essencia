/**
 */
package Essence.AlphaAndWorkProduct.impl;

import Essence.AlphaAndWorkProduct.Alpha;
import Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage;
import Essence.AlphaAndWorkProduct.AlphaContainment;

import Essence.Foundation.impl.LanguageElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alpha Containment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link AlphaContainmentImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link AlphaContainmentImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link AlphaContainmentImpl#getSubordinateAlpha <em>Subordinate Alpha</em>}</li>
 *   <li>{@link AlphaContainmentImpl#getSuperAlpha <em>Super Alpha</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlphaContainmentImpl extends LanguageElementImpl implements AlphaContainment {
	/**
	 * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected int lowerBound = LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected int upperBound = UPPER_BOUND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubordinateAlpha() <em>Subordinate Alpha</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubordinateAlpha()
	 * @generated
	 * @ordered
	 */
	protected Alpha subordinateAlpha;

	/**
	 * The cached value of the '{@link #getSuperAlpha() <em>Super Alpha</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperAlpha()
	 * @generated
	 * @ordered
	 */
	protected Alpha superAlpha;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlphaContainmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlphaAndWorkProductPackage.Literals.ALPHA_CONTAINMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(int newLowerBound) {
		int oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpperBound() {
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(int newUpperBound) {
		int oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__UPPER_BOUND, oldUpperBound, upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha getSubordinateAlpha() {
		if (subordinateAlpha != null && subordinateAlpha.eIsProxy()) {
			InternalEObject oldSubordinateAlpha = (InternalEObject)subordinateAlpha;
			subordinateAlpha = (Alpha)eResolveProxy(oldSubordinateAlpha);
			if (subordinateAlpha != oldSubordinateAlpha) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUBORDINATE_ALPHA, oldSubordinateAlpha, subordinateAlpha));
			}
		}
		return subordinateAlpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha basicGetSubordinateAlpha() {
		return subordinateAlpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubordinateAlpha(Alpha newSubordinateAlpha) {
		Alpha oldSubordinateAlpha = subordinateAlpha;
		subordinateAlpha = newSubordinateAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUBORDINATE_ALPHA, oldSubordinateAlpha, subordinateAlpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha getSuperAlpha() {
		if (superAlpha != null && superAlpha.eIsProxy()) {
			InternalEObject oldSuperAlpha = (InternalEObject)superAlpha;
			superAlpha = (Alpha)eResolveProxy(oldSuperAlpha);
			if (superAlpha != oldSuperAlpha) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUPER_ALPHA, oldSuperAlpha, superAlpha));
			}
		}
		return superAlpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha basicGetSuperAlpha() {
		return superAlpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperAlpha(Alpha newSuperAlpha) {
		Alpha oldSuperAlpha = superAlpha;
		superAlpha = newSuperAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUPER_ALPHA, oldSuperAlpha, superAlpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__LOWER_BOUND:
				return getLowerBound();
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__UPPER_BOUND:
				return getUpperBound();
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUBORDINATE_ALPHA:
				if (resolve) return getSubordinateAlpha();
				return basicGetSubordinateAlpha();
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUPER_ALPHA:
				if (resolve) return getSuperAlpha();
				return basicGetSuperAlpha();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__LOWER_BOUND:
				setLowerBound((Integer)newValue);
				return;
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__UPPER_BOUND:
				setUpperBound((Integer)newValue);
				return;
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUBORDINATE_ALPHA:
				setSubordinateAlpha((Alpha)newValue);
				return;
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUPER_ALPHA:
				setSuperAlpha((Alpha)newValue);
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
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUBORDINATE_ALPHA:
				setSubordinateAlpha((Alpha)null);
				return;
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUPER_ALPHA:
				setSuperAlpha((Alpha)null);
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
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__LOWER_BOUND:
				return lowerBound != LOWER_BOUND_EDEFAULT;
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__UPPER_BOUND:
				return upperBound != UPPER_BOUND_EDEFAULT;
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUBORDINATE_ALPHA:
				return subordinateAlpha != null;
			case AlphaAndWorkProductPackage.ALPHA_CONTAINMENT__SUPER_ALPHA:
				return superAlpha != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lowerBound: ");
		result.append(lowerBound);
		result.append(", upperBound: ");
		result.append(upperBound);
		result.append(')');
		return result.toString();
	}

} //AlphaContainmentImpl
