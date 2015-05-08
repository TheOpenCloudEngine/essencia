/**
 */
package Essence.ActivitySpaceAndActivity.impl;

import Essence.ActivitySpaceAndActivity.AbstractActivity;
import Essence.ActivitySpaceAndActivity.ActivityAssociation;
import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage;

import Essence.Foundation.impl.LanguageElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Essence.ActivitySpaceAndActivity.impl.ActivityAssociationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link Essence.ActivitySpaceAndActivity.impl.ActivityAssociationImpl#getEnd1 <em>End1</em>}</li>
 *   <li>{@link Essence.ActivitySpaceAndActivity.impl.ActivityAssociationImpl#getEnd2 <em>End2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityAssociationImpl extends LanguageElementImpl implements ActivityAssociation {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnd1() <em>End1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd1()
	 * @generated
	 * @ordered
	 */
	protected AbstractActivity end1;

	/**
	 * The cached value of the '{@link #getEnd2() <em>End2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd2()
	 * @generated
	 * @ordered
	 */
	protected AbstractActivity end2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivitySpaceAndActivityPackage.Literals.ACTIVITY_ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractActivity getEnd1() {
		if (end1 != null && end1.eIsProxy()) {
			InternalEObject oldEnd1 = (InternalEObject)end1;
			end1 = (AbstractActivity)eResolveProxy(oldEnd1);
			if (end1 != oldEnd1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END1, oldEnd1, end1));
			}
		}
		return end1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractActivity basicGetEnd1() {
		return end1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd1(AbstractActivity newEnd1) {
		AbstractActivity oldEnd1 = end1;
		end1 = newEnd1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END1, oldEnd1, end1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractActivity getEnd2() {
		if (end2 != null && end2.eIsProxy()) {
			InternalEObject oldEnd2 = (InternalEObject)end2;
			end2 = (AbstractActivity)eResolveProxy(oldEnd2);
			if (end2 != oldEnd2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END2, oldEnd2, end2));
			}
		}
		return end2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractActivity basicGetEnd2() {
		return end2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd2(AbstractActivity newEnd2) {
		AbstractActivity oldEnd2 = end2;
		end2 = newEnd2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END2, oldEnd2, end2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__KIND:
				return getKind();
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END1:
				if (resolve) return getEnd1();
				return basicGetEnd1();
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END2:
				if (resolve) return getEnd2();
				return basicGetEnd2();
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
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__KIND:
				setKind((String)newValue);
				return;
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END1:
				setEnd1((AbstractActivity)newValue);
				return;
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END2:
				setEnd2((AbstractActivity)newValue);
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
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END1:
				setEnd1((AbstractActivity)null);
				return;
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END2:
				setEnd2((AbstractActivity)null);
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
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END1:
				return end1 != null;
			case ActivitySpaceAndActivityPackage.ACTIVITY_ASSOCIATION__END2:
				return end2 != null;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //ActivityAssociationImpl
