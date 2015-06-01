/**
 */
package Essence.AlphaAndWorkProduct.impl;

import Essence.AlphaAndWorkProduct.Alpha;
import Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage;
import Essence.AlphaAndWorkProduct.AlphaAssociation;

import Essence.Foundation.impl.LanguageElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alpha Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl#getName <em>Name</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl#getEnd1lowerBound <em>End1lower Bound</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl#getEnd1upperBound <em>End1upper Bound</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl#getEnd2lowerBound <em>End2lower Bound</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl#getEnd2upperBound <em>End2upper Bound</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl#getEnd1 <em>End1</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.AlphaAssociationImpl#getEnd2 <em>End2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AlphaAssociationImpl extends LanguageElementImpl implements AlphaAssociation {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd1lowerBound() <em>End1lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd1lowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final int END1LOWER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnd1lowerBound() <em>End1lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd1lowerBound()
	 * @generated
	 * @ordered
	 */
	protected int end1lowerBound = END1LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd1upperBound() <em>End1upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd1upperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int END1UPPER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnd1upperBound() <em>End1upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd1upperBound()
	 * @generated
	 * @ordered
	 */
	protected int end1upperBound = END1UPPER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd2lowerBound() <em>End2lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd2lowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final int END2LOWER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnd2lowerBound() <em>End2lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd2lowerBound()
	 * @generated
	 * @ordered
	 */
	protected int end2lowerBound = END2LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd2upperBound() <em>End2upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd2upperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int END2UPPER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnd2upperBound() <em>End2upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd2upperBound()
	 * @generated
	 * @ordered
	 */
	protected int end2upperBound = END2UPPER_BOUND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnd1() <em>End1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd1()
	 * @generated
	 * @ordered
	 */
	protected Alpha end1;

	/**
	 * The cached value of the '{@link #getEnd2() <em>End2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd2()
	 * @generated
	 * @ordered
	 */
	protected Alpha end2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlphaAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlphaAndWorkProductPackage.Literals.ALPHA_ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnd1lowerBound() {
		return end1lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd1lowerBound(int newEnd1lowerBound) {
		int oldEnd1lowerBound = end1lowerBound;
		end1lowerBound = newEnd1lowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1LOWER_BOUND, oldEnd1lowerBound, end1lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnd1upperBound() {
		return end1upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd1upperBound(int newEnd1upperBound) {
		int oldEnd1upperBound = end1upperBound;
		end1upperBound = newEnd1upperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1UPPER_BOUND, oldEnd1upperBound, end1upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnd2lowerBound() {
		return end2lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd2lowerBound(int newEnd2lowerBound) {
		int oldEnd2lowerBound = end2lowerBound;
		end2lowerBound = newEnd2lowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2LOWER_BOUND, oldEnd2lowerBound, end2lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnd2upperBound() {
		return end2upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd2upperBound(int newEnd2upperBound) {
		int oldEnd2upperBound = end2upperBound;
		end2upperBound = newEnd2upperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2UPPER_BOUND, oldEnd2upperBound, end2upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha getEnd1() {
		if (end1 != null && end1.eIsProxy()) {
			InternalEObject oldEnd1 = (InternalEObject)end1;
			end1 = (Alpha)eResolveProxy(oldEnd1);
			if (end1 != oldEnd1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1, oldEnd1, end1));
			}
		}
		return end1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha basicGetEnd1() {
		return end1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd1(Alpha newEnd1) {
		Alpha oldEnd1 = end1;
		end1 = newEnd1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1, oldEnd1, end1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha getEnd2() {
		if (end2 != null && end2.eIsProxy()) {
			InternalEObject oldEnd2 = (InternalEObject)end2;
			end2 = (Alpha)eResolveProxy(oldEnd2);
			if (end2 != oldEnd2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2, oldEnd2, end2));
			}
		}
		return end2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha basicGetEnd2() {
		return end2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd2(Alpha newEnd2) {
		Alpha oldEnd2 = end2;
		end2 = newEnd2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2, oldEnd2, end2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__NAME:
				return getName();
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1LOWER_BOUND:
				return getEnd1lowerBound();
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1UPPER_BOUND:
				return getEnd1upperBound();
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2LOWER_BOUND:
				return getEnd2lowerBound();
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2UPPER_BOUND:
				return getEnd2upperBound();
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1:
				if (resolve) return getEnd1();
				return basicGetEnd1();
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2:
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
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__NAME:
				setName((String)newValue);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1LOWER_BOUND:
				setEnd1lowerBound((Integer)newValue);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1UPPER_BOUND:
				setEnd1upperBound((Integer)newValue);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2LOWER_BOUND:
				setEnd2lowerBound((Integer)newValue);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2UPPER_BOUND:
				setEnd2upperBound((Integer)newValue);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1:
				setEnd1((Alpha)newValue);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2:
				setEnd2((Alpha)newValue);
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
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1LOWER_BOUND:
				setEnd1lowerBound(END1LOWER_BOUND_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1UPPER_BOUND:
				setEnd1upperBound(END1UPPER_BOUND_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2LOWER_BOUND:
				setEnd2lowerBound(END2LOWER_BOUND_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2UPPER_BOUND:
				setEnd2upperBound(END2UPPER_BOUND_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1:
				setEnd1((Alpha)null);
				return;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2:
				setEnd2((Alpha)null);
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
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1LOWER_BOUND:
				return end1lowerBound != END1LOWER_BOUND_EDEFAULT;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1UPPER_BOUND:
				return end1upperBound != END1UPPER_BOUND_EDEFAULT;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2LOWER_BOUND:
				return end2lowerBound != END2LOWER_BOUND_EDEFAULT;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2UPPER_BOUND:
				return end2upperBound != END2UPPER_BOUND_EDEFAULT;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END1:
				return end1 != null;
			case AlphaAndWorkProductPackage.ALPHA_ASSOCIATION__END2:
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
		result.append(" (name: ");
		result.append(name);
		result.append(", end1lowerBound: ");
		result.append(end1lowerBound);
		result.append(", end1upperBound: ");
		result.append(end1upperBound);
		result.append(", end2lowerBound: ");
		result.append(end2lowerBound);
		result.append(", end2upperBound: ");
		result.append(end2upperBound);
		result.append(')');
		return result.toString();
	}

} //AlphaAssociationImpl
