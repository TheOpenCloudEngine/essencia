/**
 */
package Essence.Foundation.impl;

import Essence.Foundation.FoundationPackage;
import Essence.Foundation.MergeResolution;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Merge Resolution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Essence.Foundation.impl.MergeResolutionImpl#getTargetName <em>Target Name</em>}</li>
 *   <li>{@link Essence.Foundation.impl.MergeResolutionImpl#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link Essence.Foundation.impl.MergeResolutionImpl#getResolutionFunction <em>Resolution Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MergeResolutionImpl extends LanguageElementImpl implements MergeResolution {
	/**
	 * The default value of the '{@link #getTargetName() <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetName()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetName() <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetName()
	 * @generated
	 * @ordered
	 */
	protected String targetName = TARGET_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetAttribute() <em>Target Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetAttribute() <em>Target Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetAttribute()
	 * @generated
	 * @ordered
	 */
	protected String targetAttribute = TARGET_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResolutionFunction() <em>Resolution Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutionFunction()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOLUTION_FUNCTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResolutionFunction() <em>Resolution Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutionFunction()
	 * @generated
	 * @ordered
	 */
	protected String resolutionFunction = RESOLUTION_FUNCTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MergeResolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoundationPackage.Literals.MERGE_RESOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetName() {
		return targetName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetName(String newTargetName) {
		String oldTargetName = targetName;
		targetName = newTargetName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.MERGE_RESOLUTION__TARGET_NAME, oldTargetName, targetName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetAttribute() {
		return targetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetAttribute(String newTargetAttribute) {
		String oldTargetAttribute = targetAttribute;
		targetAttribute = newTargetAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.MERGE_RESOLUTION__TARGET_ATTRIBUTE, oldTargetAttribute, targetAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResolutionFunction() {
		return resolutionFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolutionFunction(String newResolutionFunction) {
		String oldResolutionFunction = resolutionFunction;
		resolutionFunction = newResolutionFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.MERGE_RESOLUTION__RESOLUTION_FUNCTION, oldResolutionFunction, resolutionFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoundationPackage.MERGE_RESOLUTION__TARGET_NAME:
				return getTargetName();
			case FoundationPackage.MERGE_RESOLUTION__TARGET_ATTRIBUTE:
				return getTargetAttribute();
			case FoundationPackage.MERGE_RESOLUTION__RESOLUTION_FUNCTION:
				return getResolutionFunction();
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
			case FoundationPackage.MERGE_RESOLUTION__TARGET_NAME:
				setTargetName((String)newValue);
				return;
			case FoundationPackage.MERGE_RESOLUTION__TARGET_ATTRIBUTE:
				setTargetAttribute((String)newValue);
				return;
			case FoundationPackage.MERGE_RESOLUTION__RESOLUTION_FUNCTION:
				setResolutionFunction((String)newValue);
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
			case FoundationPackage.MERGE_RESOLUTION__TARGET_NAME:
				setTargetName(TARGET_NAME_EDEFAULT);
				return;
			case FoundationPackage.MERGE_RESOLUTION__TARGET_ATTRIBUTE:
				setTargetAttribute(TARGET_ATTRIBUTE_EDEFAULT);
				return;
			case FoundationPackage.MERGE_RESOLUTION__RESOLUTION_FUNCTION:
				setResolutionFunction(RESOLUTION_FUNCTION_EDEFAULT);
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
			case FoundationPackage.MERGE_RESOLUTION__TARGET_NAME:
				return TARGET_NAME_EDEFAULT == null ? targetName != null : !TARGET_NAME_EDEFAULT.equals(targetName);
			case FoundationPackage.MERGE_RESOLUTION__TARGET_ATTRIBUTE:
				return TARGET_ATTRIBUTE_EDEFAULT == null ? targetAttribute != null : !TARGET_ATTRIBUTE_EDEFAULT.equals(targetAttribute);
			case FoundationPackage.MERGE_RESOLUTION__RESOLUTION_FUNCTION:
				return RESOLUTION_FUNCTION_EDEFAULT == null ? resolutionFunction != null : !RESOLUTION_FUNCTION_EDEFAULT.equals(resolutionFunction);
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
		result.append(" (targetName: ");
		result.append(targetName);
		result.append(", targetAttribute: ");
		result.append(targetAttribute);
		result.append(", resolutionFunction: ");
		result.append(resolutionFunction);
		result.append(')');
		return result.toString();
	}

} //MergeResolutionImpl
