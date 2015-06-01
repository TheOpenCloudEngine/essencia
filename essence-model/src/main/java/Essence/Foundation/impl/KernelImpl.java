/**
 */
package Essence.Foundation.impl;

import Essence.Foundation.FoundationPackage;
import Essence.Foundation.Kernel;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Kernel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link KernelImpl#getConsistencyRules <em>Consistency Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KernelImpl extends ElementGroupImpl implements Kernel {
	/**
	 * The default value of the '{@link #getConsistencyRules() <em>Consistency Rules</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsistencyRules()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSISTENCY_RULES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConsistencyRules() <em>Consistency Rules</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsistencyRules()
	 * @generated
	 * @ordered
	 */
	protected String consistencyRules = CONSISTENCY_RULES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KernelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoundationPackage.Literals.KERNEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConsistencyRules() {
		return consistencyRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsistencyRules(String newConsistencyRules) {
		String oldConsistencyRules = consistencyRules;
		consistencyRules = newConsistencyRules;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.KERNEL__CONSISTENCY_RULES, oldConsistencyRules, consistencyRules));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoundationPackage.KERNEL__CONSISTENCY_RULES:
				return getConsistencyRules();
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
			case FoundationPackage.KERNEL__CONSISTENCY_RULES:
				setConsistencyRules((String)newValue);
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
			case FoundationPackage.KERNEL__CONSISTENCY_RULES:
				setConsistencyRules(CONSISTENCY_RULES_EDEFAULT);
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
			case FoundationPackage.KERNEL__CONSISTENCY_RULES:
				return CONSISTENCY_RULES_EDEFAULT == null ? consistencyRules != null : !CONSISTENCY_RULES_EDEFAULT.equals(consistencyRules);
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
		result.append(" (consistencyRules: ");
		result.append(consistencyRules);
		result.append(')');
		return result.toString();
	}

} //KernelImpl
