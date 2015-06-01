/**
 */
package Essence.Foundation.impl;

import Essence.Foundation.ElementGroup;
import Essence.Foundation.EndeavorProperty;
import Essence.Foundation.FoundationPackage;
import Essence.Foundation.LanguageElement;
import Essence.Foundation.Resource;
import Essence.Foundation.Tag;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Essence.Foundation.impl.LanguageElementImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link Essence.Foundation.impl.LanguageElementImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link Essence.Foundation.impl.LanguageElementImpl#isIsSuppressable <em>Is Suppressable</em>}</li>
 *   <li>{@link Essence.Foundation.impl.LanguageElementImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link Essence.Foundation.impl.LanguageElementImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LanguageElementImpl extends MinimalEObjectImpl.Container implements LanguageElement {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<EndeavorProperty> properties;

	/**
	 * The cached value of the '{@link #getTag() <em>Tag</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected EList<Tag> tag;

	/**
	 * The default value of the '{@link #isIsSuppressable() <em>Is Suppressable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSuppressable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SUPPRESSABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSuppressable() <em>Is Suppressable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSuppressable()
	 * @generated
	 * @ordered
	 */
	protected boolean isSuppressable = IS_SUPPRESSABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LanguageElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoundationPackage.Literals.LANGUAGE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndeavorProperty> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<EndeavorProperty>(EndeavorProperty.class, this, FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Tag> getTag() {
		if (tag == null) {
			tag = new EObjectContainmentEList<Tag>(Tag.class, this, FoundationPackage.LANGUAGE_ELEMENT__TAG);
		}
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSuppressable() {
		return isSuppressable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSuppressable(boolean newIsSuppressable) {
		boolean oldIsSuppressable = isSuppressable;
		isSuppressable = newIsSuppressable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE, oldIsSuppressable, isSuppressable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResource() {
		if (resource == null) {
			resource = new EObjectContainmentEList<Resource>(Resource.class, this, FoundationPackage.LANGUAGE_ELEMENT__RESOURCE);
		}
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementGroup getOwner() {
		if (eContainerFeatureID() != FoundationPackage.LANGUAGE_ELEMENT__OWNER) return null;
		return (ElementGroup)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(ElementGroup newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, FoundationPackage.LANGUAGE_ELEMENT__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(ElementGroup newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != FoundationPackage.LANGUAGE_ELEMENT__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, FoundationPackage.ELEMENT_GROUP__OWNED_ELEMENTS, ElementGroup.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.LANGUAGE_ELEMENT__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FoundationPackage.LANGUAGE_ELEMENT__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((ElementGroup)otherEnd, msgs);
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
			case FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case FoundationPackage.LANGUAGE_ELEMENT__TAG:
				return ((InternalEList<?>)getTag()).basicRemove(otherEnd, msgs);
			case FoundationPackage.LANGUAGE_ELEMENT__RESOURCE:
				return ((InternalEList<?>)getResource()).basicRemove(otherEnd, msgs);
			case FoundationPackage.LANGUAGE_ELEMENT__OWNER:
				return basicSetOwner(null, msgs);
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
			case FoundationPackage.LANGUAGE_ELEMENT__OWNER:
				return eInternalContainer().eInverseRemove(this, FoundationPackage.ELEMENT_GROUP__OWNED_ELEMENTS, ElementGroup.class, msgs);
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
			case FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES:
				return getProperties();
			case FoundationPackage.LANGUAGE_ELEMENT__TAG:
				return getTag();
			case FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE:
				return isIsSuppressable();
			case FoundationPackage.LANGUAGE_ELEMENT__RESOURCE:
				return getResource();
			case FoundationPackage.LANGUAGE_ELEMENT__OWNER:
				return getOwner();
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
			case FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends EndeavorProperty>)newValue);
				return;
			case FoundationPackage.LANGUAGE_ELEMENT__TAG:
				getTag().clear();
				getTag().addAll((Collection<? extends Tag>)newValue);
				return;
			case FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE:
				setIsSuppressable((Boolean)newValue);
				return;
			case FoundationPackage.LANGUAGE_ELEMENT__RESOURCE:
				getResource().clear();
				getResource().addAll((Collection<? extends Resource>)newValue);
				return;
			case FoundationPackage.LANGUAGE_ELEMENT__OWNER:
				setOwner((ElementGroup)newValue);
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
			case FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES:
				getProperties().clear();
				return;
			case FoundationPackage.LANGUAGE_ELEMENT__TAG:
				getTag().clear();
				return;
			case FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE:
				setIsSuppressable(IS_SUPPRESSABLE_EDEFAULT);
				return;
			case FoundationPackage.LANGUAGE_ELEMENT__RESOURCE:
				getResource().clear();
				return;
			case FoundationPackage.LANGUAGE_ELEMENT__OWNER:
				setOwner((ElementGroup)null);
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
			case FoundationPackage.LANGUAGE_ELEMENT__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case FoundationPackage.LANGUAGE_ELEMENT__TAG:
				return tag != null && !tag.isEmpty();
			case FoundationPackage.LANGUAGE_ELEMENT__IS_SUPPRESSABLE:
				return isSuppressable != IS_SUPPRESSABLE_EDEFAULT;
			case FoundationPackage.LANGUAGE_ELEMENT__RESOURCE:
				return resource != null && !resource.isEmpty();
			case FoundationPackage.LANGUAGE_ELEMENT__OWNER:
				return getOwner() != null;
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
		result.append(" (isSuppressable: ");
		result.append(isSuppressable);
		result.append(')');
		return result.toString();
	}

} //LanguageElementImpl
