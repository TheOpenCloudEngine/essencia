/**
 */
package Essence.Foundation.impl;

import Essence.Foundation.ExtensionElement;
import Essence.Foundation.FoundationPackage;
import Essence.Foundation.LanguageElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link Essence.Foundation.impl.ExtensionElementImpl#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link Essence.Foundation.impl.ExtensionElementImpl#getExtensionFunction <em>Extension Function</em>}</li>
 *   <li>{@link Essence.Foundation.impl.ExtensionElementImpl#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionElementImpl extends LanguageElementImpl implements ExtensionElement {
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
	 * The default value of the '{@link #getExtensionFunction() <em>Extension Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionFunction()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTENSION_FUNCTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtensionFunction() <em>Extension Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionFunction()
	 * @generated
	 * @ordered
	 */
	protected String extensionFunction = EXTENSION_FUNCTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetElement() <em>Target Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetElement()
	 * @generated
	 * @ordered
	 */
	protected LanguageElement targetElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtensionElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoundationPackage.Literals.EXTENSION_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.EXTENSION_ELEMENT__TARGET_ATTRIBUTE, oldTargetAttribute, targetAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtensionFunction() {
		return extensionFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtensionFunction(String newExtensionFunction) {
		String oldExtensionFunction = extensionFunction;
		extensionFunction = newExtensionFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.EXTENSION_ELEMENT__EXTENSION_FUNCTION, oldExtensionFunction, extensionFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageElement getTargetElement() {
		if (targetElement != null && targetElement.eIsProxy()) {
			InternalEObject oldTargetElement = (InternalEObject)targetElement;
			targetElement = (LanguageElement)eResolveProxy(oldTargetElement);
			if (targetElement != oldTargetElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FoundationPackage.EXTENSION_ELEMENT__TARGET_ELEMENT, oldTargetElement, targetElement));
			}
		}
		return targetElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageElement basicGetTargetElement() {
		return targetElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetElement(LanguageElement newTargetElement) {
		LanguageElement oldTargetElement = targetElement;
		targetElement = newTargetElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.EXTENSION_ELEMENT__TARGET_ELEMENT, oldTargetElement, targetElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoundationPackage.EXTENSION_ELEMENT__TARGET_ATTRIBUTE:
				return getTargetAttribute();
			case FoundationPackage.EXTENSION_ELEMENT__EXTENSION_FUNCTION:
				return getExtensionFunction();
			case FoundationPackage.EXTENSION_ELEMENT__TARGET_ELEMENT:
				if (resolve) return getTargetElement();
				return basicGetTargetElement();
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
			case FoundationPackage.EXTENSION_ELEMENT__TARGET_ATTRIBUTE:
				setTargetAttribute((String)newValue);
				return;
			case FoundationPackage.EXTENSION_ELEMENT__EXTENSION_FUNCTION:
				setExtensionFunction((String)newValue);
				return;
			case FoundationPackage.EXTENSION_ELEMENT__TARGET_ELEMENT:
				setTargetElement((LanguageElement)newValue);
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
			case FoundationPackage.EXTENSION_ELEMENT__TARGET_ATTRIBUTE:
				setTargetAttribute(TARGET_ATTRIBUTE_EDEFAULT);
				return;
			case FoundationPackage.EXTENSION_ELEMENT__EXTENSION_FUNCTION:
				setExtensionFunction(EXTENSION_FUNCTION_EDEFAULT);
				return;
			case FoundationPackage.EXTENSION_ELEMENT__TARGET_ELEMENT:
				setTargetElement((LanguageElement)null);
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
			case FoundationPackage.EXTENSION_ELEMENT__TARGET_ATTRIBUTE:
				return TARGET_ATTRIBUTE_EDEFAULT == null ? targetAttribute != null : !TARGET_ATTRIBUTE_EDEFAULT.equals(targetAttribute);
			case FoundationPackage.EXTENSION_ELEMENT__EXTENSION_FUNCTION:
				return EXTENSION_FUNCTION_EDEFAULT == null ? extensionFunction != null : !EXTENSION_FUNCTION_EDEFAULT.equals(extensionFunction);
			case FoundationPackage.EXTENSION_ELEMENT__TARGET_ELEMENT:
				return targetElement != null;
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
		result.append(" (targetAttribute: ");
		result.append(targetAttribute);
		result.append(", extensionFunction: ");
		result.append(extensionFunction);
		result.append(')');
		return result.toString();
	}

} //ExtensionElementImpl
