/**
 */
package Essence.Foundation.impl;

import Essence.Foundation.FoundationPackage;
import Essence.Foundation.Kernel;
import Essence.Foundation.Method;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link MethodImpl#getBaseKernel <em>Base Kernel</em>}</li>
 *   <li>{@link MethodImpl#getPurpose <em>Purpose</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodImpl extends ElementGroupImpl implements Method {
	/**
	 * The cached value of the '{@link #getBaseKernel() <em>Base Kernel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseKernel()
	 * @generated
	 * @ordered
	 */
	protected Kernel baseKernel;

	/**
	 * The default value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected static final String PURPOSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected String purpose = PURPOSE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoundationPackage.Literals.METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Kernel getBaseKernel() {
		if (baseKernel != null && baseKernel.eIsProxy()) {
			InternalEObject oldBaseKernel = (InternalEObject)baseKernel;
			baseKernel = (Kernel)eResolveProxy(oldBaseKernel);
			if (baseKernel != oldBaseKernel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FoundationPackage.METHOD__BASE_KERNEL, oldBaseKernel, baseKernel));
			}
		}
		return baseKernel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Kernel basicGetBaseKernel() {
		return baseKernel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseKernel(Kernel newBaseKernel) {
		Kernel oldBaseKernel = baseKernel;
		baseKernel = newBaseKernel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.METHOD__BASE_KERNEL, oldBaseKernel, baseKernel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurpose(String newPurpose) {
		String oldPurpose = purpose;
		purpose = newPurpose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.METHOD__PURPOSE, oldPurpose, purpose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoundationPackage.METHOD__BASE_KERNEL:
				if (resolve) return getBaseKernel();
				return basicGetBaseKernel();
			case FoundationPackage.METHOD__PURPOSE:
				return getPurpose();
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
			case FoundationPackage.METHOD__BASE_KERNEL:
				setBaseKernel((Kernel)newValue);
				return;
			case FoundationPackage.METHOD__PURPOSE:
				setPurpose((String)newValue);
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
			case FoundationPackage.METHOD__BASE_KERNEL:
				setBaseKernel((Kernel)null);
				return;
			case FoundationPackage.METHOD__PURPOSE:
				setPurpose(PURPOSE_EDEFAULT);
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
			case FoundationPackage.METHOD__BASE_KERNEL:
				return baseKernel != null;
			case FoundationPackage.METHOD__PURPOSE:
				return PURPOSE_EDEFAULT == null ? purpose != null : !PURPOSE_EDEFAULT.equals(purpose);
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
		result.append(" (purpose: ");
		result.append(purpose);
		result.append(')');
		return result.toString();
	}

} //MethodImpl
