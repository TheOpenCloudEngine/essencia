/**
 */
package Essence.DiagramInterchange.impl;

import Essence.DiagramInterchange.DiagramInterchangePackage;
import Essence.DiagramInterchange.Label;
import Essence.DiagramInterchange.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link NodeImpl#getBottomRightLabel <em>Bottom Right Label</em>}</li>
 *   <li>{@link NodeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends DiagramElementImpl implements Node {
	/**
	 * The cached value of the '{@link #getBottomRightLabel() <em>Bottom Right Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottomRightLabel()
	 * @generated
	 * @ordered
	 */
	protected Label bottomRightLabel;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Label name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramInterchangePackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getBottomRightLabel() {
		return bottomRightLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBottomRightLabel(Label newBottomRightLabel, NotificationChain msgs) {
		Label oldBottomRightLabel = bottomRightLabel;
		bottomRightLabel = newBottomRightLabel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.NODE__BOTTOM_RIGHT_LABEL, oldBottomRightLabel, newBottomRightLabel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomRightLabel(Label newBottomRightLabel) {
		if (newBottomRightLabel != bottomRightLabel) {
			NotificationChain msgs = null;
			if (bottomRightLabel != null)
				msgs = ((InternalEObject)bottomRightLabel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.NODE__BOTTOM_RIGHT_LABEL, null, msgs);
			if (newBottomRightLabel != null)
				msgs = ((InternalEObject)newBottomRightLabel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.NODE__BOTTOM_RIGHT_LABEL, null, msgs);
			msgs = basicSetBottomRightLabel(newBottomRightLabel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.NODE__BOTTOM_RIGHT_LABEL, newBottomRightLabel, newBottomRightLabel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(Label newName, NotificationChain msgs) {
		Label oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.NODE__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(Label newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.NODE__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.NODE__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.NODE__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramInterchangePackage.NODE__BOTTOM_RIGHT_LABEL:
				return basicSetBottomRightLabel(null, msgs);
			case DiagramInterchangePackage.NODE__NAME:
				return basicSetName(null, msgs);
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
			case DiagramInterchangePackage.NODE__BOTTOM_RIGHT_LABEL:
				return getBottomRightLabel();
			case DiagramInterchangePackage.NODE__NAME:
				return getName();
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
			case DiagramInterchangePackage.NODE__BOTTOM_RIGHT_LABEL:
				setBottomRightLabel((Label)newValue);
				return;
			case DiagramInterchangePackage.NODE__NAME:
				setName((Label)newValue);
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
			case DiagramInterchangePackage.NODE__BOTTOM_RIGHT_LABEL:
				setBottomRightLabel((Label)null);
				return;
			case DiagramInterchangePackage.NODE__NAME:
				setName((Label)null);
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
			case DiagramInterchangePackage.NODE__BOTTOM_RIGHT_LABEL:
				return bottomRightLabel != null;
			case DiagramInterchangePackage.NODE__NAME:
				return name != null;
		}
		return super.eIsSet(featureID);
	}

} //NodeImpl
