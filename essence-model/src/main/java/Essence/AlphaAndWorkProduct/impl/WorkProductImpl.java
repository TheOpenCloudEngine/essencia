/**
 */
package Essence.AlphaAndWorkProduct.impl;

import Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage;
import Essence.AlphaAndWorkProduct.LevelOfDetail;
import Essence.AlphaAndWorkProduct.WorkProduct;

import Essence.Foundation.impl.BasicElementImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Work Product</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link WorkProductImpl#getLevelOfDetail <em>Level Of Detail</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkProductImpl extends BasicElementImpl implements WorkProduct {
	/**
	 * The cached value of the '{@link #getLevelOfDetail() <em>Level Of Detail</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevelOfDetail()
	 * @generated
	 * @ordered
	 */
	protected EList<LevelOfDetail> levelOfDetail;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkProductImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlphaAndWorkProductPackage.Literals.WORK_PRODUCT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LevelOfDetail> getLevelOfDetail() {
		if (levelOfDetail == null) {
			levelOfDetail = new EObjectContainmentWithInverseEList<LevelOfDetail>(LevelOfDetail.class, this, AlphaAndWorkProductPackage.WORK_PRODUCT__LEVEL_OF_DETAIL, AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT);
		}
		return levelOfDetail;
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
			case AlphaAndWorkProductPackage.WORK_PRODUCT__LEVEL_OF_DETAIL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLevelOfDetail()).basicAdd(otherEnd, msgs);
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
			case AlphaAndWorkProductPackage.WORK_PRODUCT__LEVEL_OF_DETAIL:
				return ((InternalEList<?>)getLevelOfDetail()).basicRemove(otherEnd, msgs);
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
			case AlphaAndWorkProductPackage.WORK_PRODUCT__LEVEL_OF_DETAIL:
				return getLevelOfDetail();
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
			case AlphaAndWorkProductPackage.WORK_PRODUCT__LEVEL_OF_DETAIL:
				getLevelOfDetail().clear();
				getLevelOfDetail().addAll((Collection<? extends LevelOfDetail>)newValue);
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
			case AlphaAndWorkProductPackage.WORK_PRODUCT__LEVEL_OF_DETAIL:
				getLevelOfDetail().clear();
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
			case AlphaAndWorkProductPackage.WORK_PRODUCT__LEVEL_OF_DETAIL:
				return levelOfDetail != null && !levelOfDetail.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WorkProductImpl
