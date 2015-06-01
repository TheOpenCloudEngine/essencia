/**
 */
package Essence.ActivitySpaceAndActivity.impl;

import Essence.ActivitySpaceAndActivity.Action;
import Essence.ActivitySpaceAndActivity.ActionKind;
import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage;

import Essence.AlphaAndWorkProduct.Alpha;
import Essence.AlphaAndWorkProduct.WorkProduct;

import Essence.Foundation.impl.LanguageElementImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ActionImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link ActionImpl#getWorkProduct <em>Work Product</em>}</li>
 *   <li>{@link ActionImpl#getAlpha <em>Alpha</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionImpl extends LanguageElementImpl implements Action {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ActionKind KIND_EDEFAULT = ActionKind.CREATE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ActionKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWorkProduct() <em>Work Product</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkProduct()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkProduct> workProduct;

	/**
	 * The cached value of the '{@link #getAlpha() <em>Alpha</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha()
	 * @generated
	 * @ordered
	 */
	protected EList<Alpha> alpha;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivitySpaceAndActivityPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ActionKind newKind) {
		ActionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitySpaceAndActivityPackage.ACTION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkProduct> getWorkProduct() {
		if (workProduct == null) {
			workProduct = new EObjectResolvingEList<WorkProduct>(WorkProduct.class, this, ActivitySpaceAndActivityPackage.ACTION__WORK_PRODUCT);
		}
		return workProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Alpha> getAlpha() {
		if (alpha == null) {
			alpha = new EObjectResolvingEList<Alpha>(Alpha.class, this, ActivitySpaceAndActivityPackage.ACTION__ALPHA);
		}
		return alpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivitySpaceAndActivityPackage.ACTION__KIND:
				return getKind();
			case ActivitySpaceAndActivityPackage.ACTION__WORK_PRODUCT:
				return getWorkProduct();
			case ActivitySpaceAndActivityPackage.ACTION__ALPHA:
				return getAlpha();
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
			case ActivitySpaceAndActivityPackage.ACTION__KIND:
				setKind((ActionKind)newValue);
				return;
			case ActivitySpaceAndActivityPackage.ACTION__WORK_PRODUCT:
				getWorkProduct().clear();
				getWorkProduct().addAll((Collection<? extends WorkProduct>)newValue);
				return;
			case ActivitySpaceAndActivityPackage.ACTION__ALPHA:
				getAlpha().clear();
				getAlpha().addAll((Collection<? extends Alpha>)newValue);
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
			case ActivitySpaceAndActivityPackage.ACTION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ActivitySpaceAndActivityPackage.ACTION__WORK_PRODUCT:
				getWorkProduct().clear();
				return;
			case ActivitySpaceAndActivityPackage.ACTION__ALPHA:
				getAlpha().clear();
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
			case ActivitySpaceAndActivityPackage.ACTION__KIND:
				return kind != KIND_EDEFAULT;
			case ActivitySpaceAndActivityPackage.ACTION__WORK_PRODUCT:
				return workProduct != null && !workProduct.isEmpty();
			case ActivitySpaceAndActivityPackage.ACTION__ALPHA:
				return alpha != null && !alpha.isEmpty();
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

} //ActionImpl
