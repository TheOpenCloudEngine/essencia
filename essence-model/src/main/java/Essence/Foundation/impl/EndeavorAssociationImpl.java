/**
 */
package Essence.Foundation.impl;

import Essence.Foundation.EndeavorAssociation;
import Essence.Foundation.EndeavorProperty;
import Essence.Foundation.FoundationPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Endeavor Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link EndeavorAssociationImpl#getOwnedEnd <em>Owned End</em>}</li>
 *   <li>{@link EndeavorAssociationImpl#getMemberEnd <em>Member End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EndeavorAssociationImpl extends MinimalEObjectImpl.Container implements EndeavorAssociation {
	/**
	 * The cached value of the '{@link #getOwnedEnd() <em>Owned End</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEnd()
	 * @generated
	 * @ordered
	 */
	protected EList<EndeavorProperty> ownedEnd;

	/**
	 * The cached value of the '{@link #getMemberEnd() <em>Member End</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberEnd()
	 * @generated
	 * @ordered
	 */
	protected EList<EndeavorProperty> memberEnd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndeavorAssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoundationPackage.Literals.ENDEAVOR_ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndeavorProperty> getOwnedEnd() {
		if (ownedEnd == null) {
			ownedEnd = new EObjectContainmentWithInverseEList<EndeavorProperty>(EndeavorProperty.class, this, FoundationPackage.ENDEAVOR_ASSOCIATION__OWNED_END, FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION);
		}
		return ownedEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndeavorProperty> getMemberEnd() {
		if (memberEnd == null) {
			memberEnd = new EObjectWithInverseResolvingEList<EndeavorProperty>(EndeavorProperty.class, this, FoundationPackage.ENDEAVOR_ASSOCIATION__MEMBER_END, FoundationPackage.ENDEAVOR_PROPERTY__ASSOCIATION);
		}
		return memberEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoundationPackage.ENDEAVOR_ASSOCIATION__OWNED_END:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedEnd()).basicAdd(otherEnd, msgs);
			case FoundationPackage.ENDEAVOR_ASSOCIATION__MEMBER_END:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMemberEnd()).basicAdd(otherEnd, msgs);
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
			case FoundationPackage.ENDEAVOR_ASSOCIATION__OWNED_END:
				return ((InternalEList<?>)getOwnedEnd()).basicRemove(otherEnd, msgs);
			case FoundationPackage.ENDEAVOR_ASSOCIATION__MEMBER_END:
				return ((InternalEList<?>)getMemberEnd()).basicRemove(otherEnd, msgs);
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
			case FoundationPackage.ENDEAVOR_ASSOCIATION__OWNED_END:
				return getOwnedEnd();
			case FoundationPackage.ENDEAVOR_ASSOCIATION__MEMBER_END:
				return getMemberEnd();
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
			case FoundationPackage.ENDEAVOR_ASSOCIATION__OWNED_END:
				getOwnedEnd().clear();
				getOwnedEnd().addAll((Collection<? extends EndeavorProperty>)newValue);
				return;
			case FoundationPackage.ENDEAVOR_ASSOCIATION__MEMBER_END:
				getMemberEnd().clear();
				getMemberEnd().addAll((Collection<? extends EndeavorProperty>)newValue);
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
			case FoundationPackage.ENDEAVOR_ASSOCIATION__OWNED_END:
				getOwnedEnd().clear();
				return;
			case FoundationPackage.ENDEAVOR_ASSOCIATION__MEMBER_END:
				getMemberEnd().clear();
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
			case FoundationPackage.ENDEAVOR_ASSOCIATION__OWNED_END:
				return ownedEnd != null && !ownedEnd.isEmpty();
			case FoundationPackage.ENDEAVOR_ASSOCIATION__MEMBER_END:
				return memberEnd != null && !memberEnd.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EndeavorAssociationImpl
