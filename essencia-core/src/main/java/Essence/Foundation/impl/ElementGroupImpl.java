/**
 */
package Essence.Foundation.impl;

import Essence.Foundation.ElementGroup;
import Essence.Foundation.ExtensionElement;
import Essence.Foundation.FoundationPackage;
import Essence.Foundation.LanguageElement;
import Essence.Foundation.MergeResolution;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Essence.Foundation.impl.ElementGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link Essence.Foundation.impl.ElementGroupImpl#getIcon <em>Icon</em>}</li>
 *   <li>{@link Essence.Foundation.impl.ElementGroupImpl#getBriefDescription <em>Brief Description</em>}</li>
 *   <li>{@link Essence.Foundation.impl.ElementGroupImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link Essence.Foundation.impl.ElementGroupImpl#getReferredElements <em>Referred Elements</em>}</li>
 *   <li>{@link Essence.Foundation.impl.ElementGroupImpl#getMergeResolution <em>Merge Resolution</em>}</li>
 *   <li>{@link Essence.Foundation.impl.ElementGroupImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link Essence.Foundation.impl.ElementGroupImpl#getOwnedElements <em>Owned Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementGroupImpl extends LanguageElementImpl implements ElementGroup {
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
	 * The cached value of the '{@link #getIcon() <em>Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIcon()
	 * @generated
	 * @ordered
	 */
	protected Object icon;

	/**
	 * The default value of the '{@link #getBriefDescription() <em>Brief Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBriefDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String BRIEF_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBriefDescription() <em>Brief Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBriefDescription()
	 * @generated
	 * @ordered
	 */
	protected String briefDescription = BRIEF_DESCRIPTION_EDEFAULT;

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
	 * The cached value of the '{@link #getReferredElements() <em>Referred Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredElements()
	 * @generated
	 * @ordered
	 */
	protected EList<LanguageElement> referredElements;

	/**
	 * The cached value of the '{@link #getMergeResolution() <em>Merge Resolution</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMergeResolution()
	 * @generated
	 * @ordered
	 */
	protected EList<MergeResolution> mergeResolution;

	/**
	 * The cached value of the '{@link #getExtension() <em>Extension</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtension()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionElement> extension;

	/**
	 * The cached value of the '{@link #getOwnedElements() <em>Owned Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<LanguageElement> ownedElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoundationPackage.Literals.ELEMENT_GROUP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ELEMENT_GROUP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getIcon() {
		return icon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcon(Object newIcon) {
		Object oldIcon = icon;
		icon = newIcon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ELEMENT_GROUP__ICON, oldIcon, icon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBriefDescription() {
		return briefDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBriefDescription(String newBriefDescription) {
		String oldBriefDescription = briefDescription;
		briefDescription = newBriefDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ELEMENT_GROUP__BRIEF_DESCRIPTION, oldBriefDescription, briefDescription));
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.ELEMENT_GROUP__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LanguageElement> getReferredElements() {
		if (referredElements == null) {
			referredElements = new EObjectResolvingEList<LanguageElement>(LanguageElement.class, this, FoundationPackage.ELEMENT_GROUP__REFERRED_ELEMENTS);
		}
		return referredElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MergeResolution> getMergeResolution() {
		if (mergeResolution == null) {
			mergeResolution = new EObjectContainmentEList<MergeResolution>(MergeResolution.class, this, FoundationPackage.ELEMENT_GROUP__MERGE_RESOLUTION);
		}
		return mergeResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionElement> getExtension() {
		if (extension == null) {
			extension = new EObjectContainmentEList<ExtensionElement>(ExtensionElement.class, this, FoundationPackage.ELEMENT_GROUP__EXTENSION);
		}
		return extension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LanguageElement> getOwnedElements() {
		if (ownedElements == null) {
			ownedElements = new EObjectContainmentWithInverseEList<LanguageElement>(LanguageElement.class, this, FoundationPackage.ELEMENT_GROUP__OWNED_ELEMENTS, FoundationPackage.LANGUAGE_ELEMENT__OWNER);
		}
		return ownedElements;
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
			case FoundationPackage.ELEMENT_GROUP__OWNED_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedElements()).basicAdd(otherEnd, msgs);
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
			case FoundationPackage.ELEMENT_GROUP__MERGE_RESOLUTION:
				return ((InternalEList<?>)getMergeResolution()).basicRemove(otherEnd, msgs);
			case FoundationPackage.ELEMENT_GROUP__EXTENSION:
				return ((InternalEList<?>)getExtension()).basicRemove(otherEnd, msgs);
			case FoundationPackage.ELEMENT_GROUP__OWNED_ELEMENTS:
				return ((InternalEList<?>)getOwnedElements()).basicRemove(otherEnd, msgs);
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
			case FoundationPackage.ELEMENT_GROUP__NAME:
				return getName();
			case FoundationPackage.ELEMENT_GROUP__ICON:
				return getIcon();
			case FoundationPackage.ELEMENT_GROUP__BRIEF_DESCRIPTION:
				return getBriefDescription();
			case FoundationPackage.ELEMENT_GROUP__DESCRIPTION:
				return getDescription();
			case FoundationPackage.ELEMENT_GROUP__REFERRED_ELEMENTS:
				return getReferredElements();
			case FoundationPackage.ELEMENT_GROUP__MERGE_RESOLUTION:
				return getMergeResolution();
			case FoundationPackage.ELEMENT_GROUP__EXTENSION:
				return getExtension();
			case FoundationPackage.ELEMENT_GROUP__OWNED_ELEMENTS:
				return getOwnedElements();
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
			case FoundationPackage.ELEMENT_GROUP__NAME:
				setName((String)newValue);
				return;
			case FoundationPackage.ELEMENT_GROUP__ICON:
				setIcon(newValue);
				return;
			case FoundationPackage.ELEMENT_GROUP__BRIEF_DESCRIPTION:
				setBriefDescription((String)newValue);
				return;
			case FoundationPackage.ELEMENT_GROUP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case FoundationPackage.ELEMENT_GROUP__REFERRED_ELEMENTS:
				getReferredElements().clear();
				getReferredElements().addAll((Collection<? extends LanguageElement>)newValue);
				return;
			case FoundationPackage.ELEMENT_GROUP__MERGE_RESOLUTION:
				getMergeResolution().clear();
				getMergeResolution().addAll((Collection<? extends MergeResolution>)newValue);
				return;
			case FoundationPackage.ELEMENT_GROUP__EXTENSION:
				getExtension().clear();
				getExtension().addAll((Collection<? extends ExtensionElement>)newValue);
				return;
			case FoundationPackage.ELEMENT_GROUP__OWNED_ELEMENTS:
				getOwnedElements().clear();
				getOwnedElements().addAll((Collection<? extends LanguageElement>)newValue);
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
			case FoundationPackage.ELEMENT_GROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FoundationPackage.ELEMENT_GROUP__ICON:
				setIcon((Object)null);
				return;
			case FoundationPackage.ELEMENT_GROUP__BRIEF_DESCRIPTION:
				setBriefDescription(BRIEF_DESCRIPTION_EDEFAULT);
				return;
			case FoundationPackage.ELEMENT_GROUP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case FoundationPackage.ELEMENT_GROUP__REFERRED_ELEMENTS:
				getReferredElements().clear();
				return;
			case FoundationPackage.ELEMENT_GROUP__MERGE_RESOLUTION:
				getMergeResolution().clear();
				return;
			case FoundationPackage.ELEMENT_GROUP__EXTENSION:
				getExtension().clear();
				return;
			case FoundationPackage.ELEMENT_GROUP__OWNED_ELEMENTS:
				getOwnedElements().clear();
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
			case FoundationPackage.ELEMENT_GROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FoundationPackage.ELEMENT_GROUP__ICON:
				return icon != null;
			case FoundationPackage.ELEMENT_GROUP__BRIEF_DESCRIPTION:
				return BRIEF_DESCRIPTION_EDEFAULT == null ? briefDescription != null : !BRIEF_DESCRIPTION_EDEFAULT.equals(briefDescription);
			case FoundationPackage.ELEMENT_GROUP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case FoundationPackage.ELEMENT_GROUP__REFERRED_ELEMENTS:
				return referredElements != null && !referredElements.isEmpty();
			case FoundationPackage.ELEMENT_GROUP__MERGE_RESOLUTION:
				return mergeResolution != null && !mergeResolution.isEmpty();
			case FoundationPackage.ELEMENT_GROUP__EXTENSION:
				return extension != null && !extension.isEmpty();
			case FoundationPackage.ELEMENT_GROUP__OWNED_ELEMENTS:
				return ownedElements != null && !ownedElements.isEmpty();
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
		result.append(", icon: ");
		result.append(icon);
		result.append(", briefDescription: ");
		result.append(briefDescription);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ElementGroupImpl
