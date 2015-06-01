/**
 */
package Essence.AlphaAndWorkProduct.impl;

import Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage;
import Essence.AlphaAndWorkProduct.LevelOfDetail;
import Essence.AlphaAndWorkProduct.WorkProduct;

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
 * An implementation of the model object '<em><b>Level Of Detail</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link LevelOfDetailImpl#getName <em>Name</em>}</li>
 *   <li>{@link LevelOfDetailImpl#isIsSufficientLevel <em>Is Sufficient Level</em>}</li>
 *   <li>{@link LevelOfDetailImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link LevelOfDetailImpl#getCheckListItem <em>Check List Item</em>}</li>
 *   <li>{@link LevelOfDetailImpl#getSuccessor <em>Successor</em>}</li>
 *   <li>{@link LevelOfDetailImpl#getWorkProduct <em>Work Product</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LevelOfDetailImpl extends LanguageElementImpl implements LevelOfDetail {
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
	 * The default value of the '{@link #isIsSufficientLevel() <em>Is Sufficient Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSufficientLevel()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_SUFFICIENT_LEVEL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsSufficientLevel() <em>Is Sufficient Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsSufficientLevel()
	 * @generated
	 * @ordered
	 */
	protected boolean isSufficientLevel = IS_SUFFICIENT_LEVEL_EDEFAULT;

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
	 * The cached value of the '{@link #getCheckListItem() <em>Check List Item</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckListItem()
	 * @generated
	 * @ordered
	 */
	protected EList<Checkpoint> checkListItem;

	/**
	 * The cached value of the '{@link #getSuccessor() <em>Successor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessor()
	 * @generated
	 * @ordered
	 */
	protected LevelOfDetail successor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LevelOfDetailImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AlphaAndWorkProductPackage.Literals.LEVEL_OF_DETAIL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsSufficientLevel() {
		return isSufficientLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsSufficientLevel(boolean newIsSufficientLevel) {
		boolean oldIsSufficientLevel = isSufficientLevel;
		isSufficientLevel = newIsSufficientLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__IS_SUFFICIENT_LEVEL, oldIsSufficientLevel, isSufficientLevel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Checkpoint> getCheckListItem() {
		if (checkListItem == null) {
			checkListItem = new EObjectContainmentEList<Checkpoint>(Checkpoint.class, this, AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__CHECK_LIST_ITEM);
		}
		return checkListItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LevelOfDetail getSuccessor() {
		if (successor != null && successor.eIsProxy()) {
			InternalEObject oldSuccessor = (InternalEObject)successor;
			successor = (LevelOfDetail)eResolveProxy(oldSuccessor);
			if (successor != oldSuccessor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__SUCCESSOR, oldSuccessor, successor));
			}
		}
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LevelOfDetail basicGetSuccessor() {
		return successor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuccessor(LevelOfDetail newSuccessor) {
		LevelOfDetail oldSuccessor = successor;
		successor = newSuccessor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__SUCCESSOR, oldSuccessor, successor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkProduct getWorkProduct() {
		if (eContainerFeatureID() != AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT) return null;
		return (WorkProduct)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorkProduct(WorkProduct newWorkProduct, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newWorkProduct, AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkProduct(WorkProduct newWorkProduct) {
		if (newWorkProduct != eInternalContainer() || (eContainerFeatureID() != AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT && newWorkProduct != null)) {
			if (EcoreUtil.isAncestor(this, newWorkProduct))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newWorkProduct != null)
				msgs = ((InternalEObject)newWorkProduct).eInverseAdd(this, AlphaAndWorkProductPackage.WORK_PRODUCT__LEVEL_OF_DETAIL, WorkProduct.class, msgs);
			msgs = basicSetWorkProduct(newWorkProduct, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT, newWorkProduct, newWorkProduct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetWorkProduct((WorkProduct)otherEnd, msgs);
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
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__CHECK_LIST_ITEM:
				return ((InternalEList<?>)getCheckListItem()).basicRemove(otherEnd, msgs);
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT:
				return basicSetWorkProduct(null, msgs);
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
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT:
				return eInternalContainer().eInverseRemove(this, AlphaAndWorkProductPackage.WORK_PRODUCT__LEVEL_OF_DETAIL, WorkProduct.class, msgs);
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
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__NAME:
				return getName();
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__IS_SUFFICIENT_LEVEL:
				return isIsSufficientLevel();
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__DESCRIPTION:
				return getDescription();
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__CHECK_LIST_ITEM:
				return getCheckListItem();
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__SUCCESSOR:
				if (resolve) return getSuccessor();
				return basicGetSuccessor();
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT:
				return getWorkProduct();
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
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__NAME:
				setName((String)newValue);
				return;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__IS_SUFFICIENT_LEVEL:
				setIsSufficientLevel((Boolean)newValue);
				return;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__CHECK_LIST_ITEM:
				getCheckListItem().clear();
				getCheckListItem().addAll((Collection<? extends Checkpoint>)newValue);
				return;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__SUCCESSOR:
				setSuccessor((LevelOfDetail)newValue);
				return;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT:
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
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__IS_SUFFICIENT_LEVEL:
				setIsSufficientLevel(IS_SUFFICIENT_LEVEL_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__CHECK_LIST_ITEM:
				getCheckListItem().clear();
				return;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__SUCCESSOR:
				setSuccessor((LevelOfDetail)null);
				return;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT:
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
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__IS_SUFFICIENT_LEVEL:
				return isSufficientLevel != IS_SUFFICIENT_LEVEL_EDEFAULT;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__CHECK_LIST_ITEM:
				return checkListItem != null && !checkListItem.isEmpty();
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__SUCCESSOR:
				return successor != null;
			case AlphaAndWorkProductPackage.LEVEL_OF_DETAIL__WORK_PRODUCT:
				return getWorkProduct() != null;
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
		result.append(", isSufficientLevel: ");
		result.append(isSufficientLevel);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //LevelOfDetailImpl
