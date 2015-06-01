/**
 */
package Essence.ActivitySpaceAndActivity.impl;

import Essence.ActivitySpaceAndActivity.ActivitySpaceAndActivityPackage;
import Essence.ActivitySpaceAndActivity.Criterion;

import Essence.AlphaAndWorkProduct.LevelOfDetail;
import Essence.AlphaAndWorkProduct.State;

import Essence.Foundation.impl.LanguageElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Criterion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CriterionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link CriterionImpl#getState <em>State</em>}</li>
 *   <li>{@link CriterionImpl#getLevelOfDetail <em>Level Of Detail</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CriterionImpl extends LanguageElementImpl implements Criterion {
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
	 * The cached value of the '{@link #getState() <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected State state;

	/**
	 * The cached value of the '{@link #getLevelOfDetail() <em>Level Of Detail</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevelOfDetail()
	 * @generated
	 * @ordered
	 */
	protected LevelOfDetail levelOfDetail;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CriterionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivitySpaceAndActivityPackage.Literals.CRITERION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitySpaceAndActivityPackage.CRITERION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getState() {
		if (state != null && state.eIsProxy()) {
			InternalEObject oldState = (InternalEObject)state;
			state = (State)eResolveProxy(oldState);
			if (state != oldState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivitySpaceAndActivityPackage.CRITERION__STATE, oldState, state));
			}
		}
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(State newState) {
		State oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitySpaceAndActivityPackage.CRITERION__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LevelOfDetail getLevelOfDetail() {
		if (levelOfDetail != null && levelOfDetail.eIsProxy()) {
			InternalEObject oldLevelOfDetail = (InternalEObject)levelOfDetail;
			levelOfDetail = (LevelOfDetail)eResolveProxy(oldLevelOfDetail);
			if (levelOfDetail != oldLevelOfDetail) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivitySpaceAndActivityPackage.CRITERION__LEVEL_OF_DETAIL, oldLevelOfDetail, levelOfDetail));
			}
		}
		return levelOfDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LevelOfDetail basicGetLevelOfDetail() {
		return levelOfDetail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevelOfDetail(LevelOfDetail newLevelOfDetail) {
		LevelOfDetail oldLevelOfDetail = levelOfDetail;
		levelOfDetail = newLevelOfDetail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitySpaceAndActivityPackage.CRITERION__LEVEL_OF_DETAIL, oldLevelOfDetail, levelOfDetail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivitySpaceAndActivityPackage.CRITERION__DESCRIPTION:
				return getDescription();
			case ActivitySpaceAndActivityPackage.CRITERION__STATE:
				if (resolve) return getState();
				return basicGetState();
			case ActivitySpaceAndActivityPackage.CRITERION__LEVEL_OF_DETAIL:
				if (resolve) return getLevelOfDetail();
				return basicGetLevelOfDetail();
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
			case ActivitySpaceAndActivityPackage.CRITERION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ActivitySpaceAndActivityPackage.CRITERION__STATE:
				setState((State)newValue);
				return;
			case ActivitySpaceAndActivityPackage.CRITERION__LEVEL_OF_DETAIL:
				setLevelOfDetail((LevelOfDetail)newValue);
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
			case ActivitySpaceAndActivityPackage.CRITERION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ActivitySpaceAndActivityPackage.CRITERION__STATE:
				setState((State)null);
				return;
			case ActivitySpaceAndActivityPackage.CRITERION__LEVEL_OF_DETAIL:
				setLevelOfDetail((LevelOfDetail)null);
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
			case ActivitySpaceAndActivityPackage.CRITERION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ActivitySpaceAndActivityPackage.CRITERION__STATE:
				return state != null;
			case ActivitySpaceAndActivityPackage.CRITERION__LEVEL_OF_DETAIL:
				return levelOfDetail != null;
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
		result.append(" (description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //CriterionImpl
