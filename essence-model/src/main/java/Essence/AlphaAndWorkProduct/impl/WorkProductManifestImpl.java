/**
 */
package Essence.AlphaAndWorkProduct.impl;

import Essence.AlphaAndWorkProduct.Alpha;
import Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage;
import Essence.AlphaAndWorkProduct.WorkProduct;
import Essence.AlphaAndWorkProduct.WorkProductManifest;

import Essence.Foundation.impl.LanguageElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Work Product Manifest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link WorkProductManifestImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link WorkProductManifestImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link WorkProductManifestImpl#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link WorkProductManifestImpl#getWorkProduct <em>Work Product</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkProductManifestImpl extends LanguageElementImpl implements WorkProductManifest {
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
	 * The cached value of the '{@link #getAlpha() <em>Alpha</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha()
	 * @generated
	 * @ordered
	 */
	protected Alpha alpha;

	/**
	 * The cached value of the '{@link #getWorkProduct() <em>Work Product</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkProduct()
	 * @generated
	 * @ordered
	 */
	protected WorkProduct workProduct;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkProductManifestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlphaAndWorkProductPackage.Literals.WORK_PRODUCT_MANIFEST;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__LOWER_BOUND, oldLowerBound, lowerBound));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__UPPER_BOUND, oldUpperBound, upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha getAlpha() {
		if (alpha != null && alpha.eIsProxy()) {
			InternalEObject oldAlpha = (InternalEObject)alpha;
			alpha = (Alpha)eResolveProxy(oldAlpha);
			if (alpha != oldAlpha) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__ALPHA, oldAlpha, alpha));
			}
		}
		return alpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alpha basicGetAlpha() {
		return alpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlpha(Alpha newAlpha) {
		Alpha oldAlpha = alpha;
		alpha = newAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__ALPHA, oldAlpha, alpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkProduct getWorkProduct() {
		if (workProduct != null && workProduct.eIsProxy()) {
			InternalEObject oldWorkProduct = (InternalEObject)workProduct;
			workProduct = (WorkProduct)eResolveProxy(oldWorkProduct);
			if (workProduct != oldWorkProduct) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__WORK_PRODUCT, oldWorkProduct, workProduct));
			}
		}
		return workProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkProduct basicGetWorkProduct() {
		return workProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkProduct(WorkProduct newWorkProduct) {
		WorkProduct oldWorkProduct = workProduct;
		workProduct = newWorkProduct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__WORK_PRODUCT, oldWorkProduct, workProduct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__LOWER_BOUND:
				return getLowerBound();
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__UPPER_BOUND:
				return getUpperBound();
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__ALPHA:
				if (resolve) return getAlpha();
				return basicGetAlpha();
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__WORK_PRODUCT:
				if (resolve) return getWorkProduct();
				return basicGetWorkProduct();
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
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__LOWER_BOUND:
				setLowerBound((Integer)newValue);
				return;
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__UPPER_BOUND:
				setUpperBound((Integer)newValue);
				return;
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__ALPHA:
				setAlpha((Alpha)newValue);
				return;
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__WORK_PRODUCT:
				setWorkProduct((WorkProduct)newValue);
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
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__ALPHA:
				setAlpha((Alpha)null);
				return;
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__WORK_PRODUCT:
				setWorkProduct((WorkProduct)null);
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
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__LOWER_BOUND:
				return lowerBound != LOWER_BOUND_EDEFAULT;
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__UPPER_BOUND:
				return upperBound != UPPER_BOUND_EDEFAULT;
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__ALPHA:
				return alpha != null;
			case AlphaAndWorkProductPackage.WORK_PRODUCT_MANIFEST__WORK_PRODUCT:
				return workProduct != null;
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
		result.append(" (lowerBound: ");
		result.append(lowerBound);
		result.append(", upperBound: ");
		result.append(upperBound);
		result.append(')');
		return result.toString();
	}

} //WorkProductManifestImpl
