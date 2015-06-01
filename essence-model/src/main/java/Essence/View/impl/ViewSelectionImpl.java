/**
 */
package Essence.View.impl;

import Essence.Foundation.LanguageElement;

import Essence.Foundation.impl.LanguageElementImpl;

import Essence.View.FeatureSelection;
import Essence.View.ViewPackage;
import Essence.View.ViewSelection;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ViewSelectionImpl#getName <em>Name</em>}</li>
 *   <li>{@link ViewSelectionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link ViewSelectionImpl#getFeatureSelection <em>Feature Selection</em>}</li>
 *   <li>{@link ViewSelectionImpl#getConstructSelection <em>Construct Selection</em>}</li>
 *   <li>{@link ViewSelectionImpl#getIncludedViewSelection <em>Included View Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewSelectionImpl extends LanguageElementImpl implements ViewSelection {
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
	 * The cached value of the '{@link #getFeatureSelection() <em>Feature Selection</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureSelection()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureSelection> featureSelection;

	/**
	 * The cached value of the '{@link #getConstructSelection() <em>Construct Selection</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstructSelection()
	 * @generated
	 * @ordered
	 */
	protected EList<LanguageElement> constructSelection;

	/**
	 * The cached value of the '{@link #getIncludedViewSelection() <em>Included View Selection</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncludedViewSelection()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewSelection> includedViewSelection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ViewSelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ViewPackage.Literals.VIEW_SELECTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.VIEW_SELECTION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.VIEW_SELECTION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureSelection> getFeatureSelection() {
		if (featureSelection == null) {
			featureSelection = new EObjectResolvingEList<FeatureSelection>(FeatureSelection.class, this, ViewPackage.VIEW_SELECTION__FEATURE_SELECTION);
		}
		return featureSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LanguageElement> getConstructSelection() {
		if (constructSelection == null) {
			constructSelection = new EObjectResolvingEList<LanguageElement>(LanguageElement.class, this, ViewPackage.VIEW_SELECTION__CONSTRUCT_SELECTION);
		}
		return constructSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ViewSelection> getIncludedViewSelection() {
		if (includedViewSelection == null) {
			includedViewSelection = new EObjectResolvingEList<ViewSelection>(ViewSelection.class, this, ViewPackage.VIEW_SELECTION__INCLUDED_VIEW_SELECTION);
		}
		return includedViewSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ViewPackage.VIEW_SELECTION__NAME:
				return getName();
			case ViewPackage.VIEW_SELECTION__DESCRIPTION:
				return getDescription();
			case ViewPackage.VIEW_SELECTION__FEATURE_SELECTION:
				return getFeatureSelection();
			case ViewPackage.VIEW_SELECTION__CONSTRUCT_SELECTION:
				return getConstructSelection();
			case ViewPackage.VIEW_SELECTION__INCLUDED_VIEW_SELECTION:
				return getIncludedViewSelection();
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
			case ViewPackage.VIEW_SELECTION__NAME:
				setName((String)newValue);
				return;
			case ViewPackage.VIEW_SELECTION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ViewPackage.VIEW_SELECTION__FEATURE_SELECTION:
				getFeatureSelection().clear();
				getFeatureSelection().addAll((Collection<? extends FeatureSelection>)newValue);
				return;
			case ViewPackage.VIEW_SELECTION__CONSTRUCT_SELECTION:
				getConstructSelection().clear();
				getConstructSelection().addAll((Collection<? extends LanguageElement>)newValue);
				return;
			case ViewPackage.VIEW_SELECTION__INCLUDED_VIEW_SELECTION:
				getIncludedViewSelection().clear();
				getIncludedViewSelection().addAll((Collection<? extends ViewSelection>)newValue);
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
			case ViewPackage.VIEW_SELECTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ViewPackage.VIEW_SELECTION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ViewPackage.VIEW_SELECTION__FEATURE_SELECTION:
				getFeatureSelection().clear();
				return;
			case ViewPackage.VIEW_SELECTION__CONSTRUCT_SELECTION:
				getConstructSelection().clear();
				return;
			case ViewPackage.VIEW_SELECTION__INCLUDED_VIEW_SELECTION:
				getIncludedViewSelection().clear();
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
			case ViewPackage.VIEW_SELECTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ViewPackage.VIEW_SELECTION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ViewPackage.VIEW_SELECTION__FEATURE_SELECTION:
				return featureSelection != null && !featureSelection.isEmpty();
			case ViewPackage.VIEW_SELECTION__CONSTRUCT_SELECTION:
				return constructSelection != null && !constructSelection.isEmpty();
			case ViewPackage.VIEW_SELECTION__INCLUDED_VIEW_SELECTION:
				return includedViewSelection != null && !includedViewSelection.isEmpty();
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

} //ViewSelectionImpl
