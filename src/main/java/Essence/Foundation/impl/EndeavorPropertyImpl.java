/**
 */
package Essence.Foundation.impl;

import Essence.Foundation.EndeavorAssociation;
import Essence.Foundation.EndeavorProperty;
import Essence.Foundation.FoundationPackage;
import Essence.Foundation.LanguageElement;
import Essence.Foundation.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Endeavor Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Essence.Foundation.impl.EndeavorPropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link Essence.Foundation.impl.EndeavorPropertyImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link Essence.Foundation.impl.EndeavorPropertyImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link Essence.Foundation.impl.EndeavorPropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link Essence.Foundation.impl.EndeavorPropertyImpl#getOwningAssociation <em>Owning Association</em>}</li>
 *   <li>{@link Essence.Foundation.impl.EndeavorPropertyImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link Essence.Foundation.impl.EndeavorPropertyImpl#getLanguageElement <em>Language Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EndeavorPropertyImpl extends MinimalEObjectImpl.Container implements EndeavorProperty {
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
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * The cached value of the '{@link #getAssociation() <em>Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociation()
	 * @generated
	 * @ordered
	 */
	protected EndeavorAssociation association;

	/**
	 * The cached value of the '{@link #getLanguageElement() <em>Language Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageElement()
	 * @generated
	 * @ordered
	 */
	protected LanguageElement languageElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndeavorPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoundationPackage.Literals.ENDEAVOR_PROPERTY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ENDEAVOR_PROPERTY__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ENDEAVOR_PROPERTY__LOWER_BOUND, oldLowerBound, lowerBound));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ENDEAVOR_PROPERTY__UPPER_BOUND, oldUpperBound, upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FoundationPackage.ENDEAVOR_PROPERTY__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ENDEAVOR_PROPERTY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndeavorAssociation getOwningAssociation() {
		if (eContainerFeatureID() != FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION) return null;
		return (EndeavorAssociation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningAssociation(EndeavorAssociation newOwningAssociation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningAssociation, FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningAssociation(EndeavorAssociation newOwningAssociation) {
		if (newOwningAssociation != eInternalContainer() || (eContainerFeatureID() != FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION && newOwningAssociation != null)) {
			if (EcoreUtil.isAncestor(this, newOwningAssociation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningAssociation != null)
				msgs = ((InternalEObject)newOwningAssociation).eInverseAdd(this, FoundationPackage.ENDEAVOR_ASSOCIATION__OWNED_END, EndeavorAssociation.class, msgs);
			msgs = basicSetOwningAssociation(newOwningAssociation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION, newOwningAssociation, newOwningAssociation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndeavorAssociation getAssociation() {
		if (association != null && association.eIsProxy()) {
			InternalEObject oldAssociation = (InternalEObject)association;
			association = (EndeavorAssociation)eResolveProxy(oldAssociation);
			if (association != oldAssociation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FoundationPackage.ENDEAVOR_PROPERTY__ASSOCIATION, oldAssociation, association));
			}
		}
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndeavorAssociation basicGetAssociation() {
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociation(EndeavorAssociation newAssociation, NotificationChain msgs) {
		EndeavorAssociation oldAssociation = association;
		association = newAssociation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FoundationPackage.ENDEAVOR_PROPERTY__ASSOCIATION, oldAssociation, newAssociation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociation(EndeavorAssociation newAssociation) {
		if (newAssociation != association) {
			NotificationChain msgs = null;
			if (association != null)
				msgs = ((InternalEObject)association).eInverseRemove(this, FoundationPackage.ENDEAVOR_ASSOCIATION__MEMBER_END, EndeavorAssociation.class, msgs);
			if (newAssociation != null)
				msgs = ((InternalEObject)newAssociation).eInverseAdd(this, FoundationPackage.ENDEAVOR_ASSOCIATION__MEMBER_END, EndeavorAssociation.class, msgs);
			msgs = basicSetAssociation(newAssociation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ENDEAVOR_PROPERTY__ASSOCIATION, newAssociation, newAssociation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageElement getLanguageElement() {
		if (languageElement != null && languageElement.eIsProxy()) {
			InternalEObject oldLanguageElement = (InternalEObject)languageElement;
			languageElement = (LanguageElement)eResolveProxy(oldLanguageElement);
			if (languageElement != oldLanguageElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FoundationPackage.ENDEAVOR_PROPERTY__LANGUAGE_ELEMENT, oldLanguageElement, languageElement));
			}
		}
		return languageElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageElement basicGetLanguageElement() {
		return languageElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguageElement(LanguageElement newLanguageElement) {
		LanguageElement oldLanguageElement = languageElement;
		languageElement = newLanguageElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ENDEAVOR_PROPERTY__LANGUAGE_ELEMENT, oldLanguageElement, languageElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningAssociation((EndeavorAssociation)otherEnd, msgs);
			case FoundationPackage.ENDEAVOR_PROPERTY__ASSOCIATION:
				if (association != null)
					msgs = ((InternalEObject)association).eInverseRemove(this, FoundationPackage.ENDEAVOR_ASSOCIATION__MEMBER_END, EndeavorAssociation.class, msgs);
				return basicSetAssociation((EndeavorAssociation)otherEnd, msgs);
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
			case FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION:
				return basicSetOwningAssociation(null, msgs);
			case FoundationPackage.ENDEAVOR_PROPERTY__ASSOCIATION:
				return basicSetAssociation(null, msgs);
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
			case FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION:
				return eInternalContainer().eInverseRemove(this, FoundationPackage.ENDEAVOR_ASSOCIATION__OWNED_END, EndeavorAssociation.class, msgs);
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
			case FoundationPackage.ENDEAVOR_PROPERTY__NAME:
				return getName();
			case FoundationPackage.ENDEAVOR_PROPERTY__LOWER_BOUND:
				return getLowerBound();
			case FoundationPackage.ENDEAVOR_PROPERTY__UPPER_BOUND:
				return getUpperBound();
			case FoundationPackage.ENDEAVOR_PROPERTY__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION:
				return getOwningAssociation();
			case FoundationPackage.ENDEAVOR_PROPERTY__ASSOCIATION:
				if (resolve) return getAssociation();
				return basicGetAssociation();
			case FoundationPackage.ENDEAVOR_PROPERTY__LANGUAGE_ELEMENT:
				if (resolve) return getLanguageElement();
				return basicGetLanguageElement();
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
			case FoundationPackage.ENDEAVOR_PROPERTY__NAME:
				setName((String)newValue);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__LOWER_BOUND:
				setLowerBound((Integer)newValue);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__UPPER_BOUND:
				setUpperBound((Integer)newValue);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__TYPE:
				setType((Type)newValue);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION:
				setOwningAssociation((EndeavorAssociation)newValue);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__ASSOCIATION:
				setAssociation((EndeavorAssociation)newValue);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__LANGUAGE_ELEMENT:
				setLanguageElement((LanguageElement)newValue);
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
			case FoundationPackage.ENDEAVOR_PROPERTY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__TYPE:
				setType((Type)null);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION:
				setOwningAssociation((EndeavorAssociation)null);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__ASSOCIATION:
				setAssociation((EndeavorAssociation)null);
				return;
			case FoundationPackage.ENDEAVOR_PROPERTY__LANGUAGE_ELEMENT:
				setLanguageElement((LanguageElement)null);
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
			case FoundationPackage.ENDEAVOR_PROPERTY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FoundationPackage.ENDEAVOR_PROPERTY__LOWER_BOUND:
				return lowerBound != LOWER_BOUND_EDEFAULT;
			case FoundationPackage.ENDEAVOR_PROPERTY__UPPER_BOUND:
				return upperBound != UPPER_BOUND_EDEFAULT;
			case FoundationPackage.ENDEAVOR_PROPERTY__TYPE:
				return type != null;
			case FoundationPackage.ENDEAVOR_PROPERTY__OWNING_ASSOCIATION:
				return getOwningAssociation() != null;
			case FoundationPackage.ENDEAVOR_PROPERTY__ASSOCIATION:
				return association != null;
			case FoundationPackage.ENDEAVOR_PROPERTY__LANGUAGE_ELEMENT:
				return languageElement != null;
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
		result.append(", lowerBound: ");
		result.append(lowerBound);
		result.append(", upperBound: ");
		result.append(upperBound);
		result.append(')');
		return result.toString();
	}

} //EndeavorPropertyImpl
