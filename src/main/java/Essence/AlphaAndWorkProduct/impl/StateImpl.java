/**
 */
package Essence.AlphaAndWorkProduct.impl;

import Essence.AlphaAndWorkProduct.Alpha;
import Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage;
import Essence.AlphaAndWorkProduct.State;

import Essence.Foundation.Checkpoint;

import Essence.Foundation.impl.LanguageElementImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.StateImpl#getName <em>Name</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.StateImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.StateImpl#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.StateImpl#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link Essence.AlphaAndWorkProduct.impl.StateImpl#getCheckListItem <em>Check List Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateImpl extends LanguageElementImpl implements State {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSuccessor() <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessor()
	 * @generated
	 * @ordered
	 */
	protected State successor;

	/**
	 * The cached value of the '{@link #getCheckListItem() <em>Check List Item</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckListItem()
	 * @generated
	 * @ordered
	 */
	protected EList<Checkpoint> checkListItem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlphaAndWorkProductPackage.Literals.STATE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.STATE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha getAlpha() {
		if (eContainerFeatureID() != AlphaAndWorkProductPackage.STATE__ALPHA) return null;
		return (Alpha)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlpha(Alpha newAlpha, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAlpha, AlphaAndWorkProductPackage.STATE__ALPHA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlpha(Alpha newAlpha) {
		if (newAlpha != eInternalContainer() || (eContainerFeatureID() != AlphaAndWorkProductPackage.STATE__ALPHA && newAlpha != null)) {
			if (EcoreUtil.isAncestor(this, newAlpha))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAlpha != null)
				msgs = ((InternalEObject)newAlpha).eInverseAdd(this, AlphaAndWorkProductPackage.ALPHA__STATES, Alpha.class, msgs);
			msgs = basicSetAlpha(newAlpha, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.STATE__ALPHA, newAlpha, newAlpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getSuccessor() {
		if (successor != null && successor.eIsProxy()) {
			InternalEObject oldSuccessor = (InternalEObject)successor;
			successor = (State)eResolveProxy(oldSuccessor);
			if (successor != oldSuccessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlphaAndWorkProductPackage.STATE__SUCCESSOR, oldSuccessor, successor));
			}
		}
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetSuccessor() {
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuccessor(State newSuccessor) {
		State oldSuccessor = successor;
		successor = newSuccessor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.STATE__SUCCESSOR, oldSuccessor, successor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Checkpoint> getCheckListItem() {
		if (checkListItem == null) {
			checkListItem = new EObjectContainmentEList<Checkpoint>(Checkpoint.class, this, AlphaAndWorkProductPackage.STATE__CHECK_LIST_ITEM);
		}
		return checkListItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AlphaAndWorkProductPackage.STATE__ALPHA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAlpha((Alpha)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AlphaAndWorkProductPackage.STATE__ALPHA:
				return basicSetAlpha(null, msgs);
			case AlphaAndWorkProductPackage.STATE__CHECK_LIST_ITEM:
				return ((InternalEList<?>)getCheckListItem()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case AlphaAndWorkProductPackage.STATE__ALPHA:
				return eInternalContainer().eInverseRemove(this, AlphaAndWorkProductPackage.ALPHA__STATES, Alpha.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AlphaAndWorkProductPackage.STATE__NAME:
				return getName();
			case AlphaAndWorkProductPackage.STATE__DESCRIPTION:
				return getDescription();
			case AlphaAndWorkProductPackage.STATE__ALPHA:
				return getAlpha();
			case AlphaAndWorkProductPackage.STATE__SUCCESSOR:
				if (resolve) return getSuccessor();
				return basicGetSuccessor();
			case AlphaAndWorkProductPackage.STATE__CHECK_LIST_ITEM:
				return getCheckListItem();
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
			case AlphaAndWorkProductPackage.STATE__NAME:
				setName((String)newValue);
				return;
			case AlphaAndWorkProductPackage.STATE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case AlphaAndWorkProductPackage.STATE__ALPHA:
				setAlpha((Alpha)newValue);
				return;
			case AlphaAndWorkProductPackage.STATE__SUCCESSOR:
				setSuccessor((State)newValue);
				return;
			case AlphaAndWorkProductPackage.STATE__CHECK_LIST_ITEM:
				getCheckListItem().clear();
				getCheckListItem().addAll((Collection<? extends Checkpoint>)newValue);
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
			case AlphaAndWorkProductPackage.STATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.STATE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.STATE__ALPHA:
				setAlpha((Alpha)null);
				return;
			case AlphaAndWorkProductPackage.STATE__SUCCESSOR:
				setSuccessor((State)null);
				return;
			case AlphaAndWorkProductPackage.STATE__CHECK_LIST_ITEM:
				getCheckListItem().clear();
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
			case AlphaAndWorkProductPackage.STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AlphaAndWorkProductPackage.STATE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case AlphaAndWorkProductPackage.STATE__ALPHA:
				return getAlpha() != null;
			case AlphaAndWorkProductPackage.STATE__SUCCESSOR:
				return successor != null;
			case AlphaAndWorkProductPackage.STATE__CHECK_LIST_ITEM:
				return checkListItem != null && !checkListItem.isEmpty();
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
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //StateImpl
