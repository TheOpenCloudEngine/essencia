/**
 */
package Essence.DiagramInterchange.impl;

import Essence.DiagramInterchange.DiagramInterchangePackage;
import Essence.DiagramInterchange.Label;
import Essence.DiagramInterchange.Link;
import Essence.DiagramInterchange.Node;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link LinkImpl#getName <em>Name</em>}</li>
 *   <li>{@link LinkImpl#getEnd2_bounds <em>End2 bounds</em>}</li>
 *   <li>{@link LinkImpl#getEnd1_bounds <em>End1 bounds</em>}</li>
 *   <li>{@link LinkImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link LinkImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkImpl extends DiagramElementImpl implements Link {
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
	 * The cached value of the '{@link #getEnd2_bounds() <em>End2 bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd2_bounds()
	 * @generated
	 * @ordered
	 */
	protected Label end2_bounds;

	/**
	 * The cached value of the '{@link #getEnd1_bounds() <em>End1 bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd1_bounds()
	 * @generated
	 * @ordered
	 */
	protected Label end1_bounds;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Node source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramInterchangePackage.Literals.LINK;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.LINK__NAME, oldName, newName);
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
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.LINK__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.LINK__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.LINK__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getEnd2_bounds() {
		return end2_bounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnd2_bounds(Label newEnd2_bounds, NotificationChain msgs) {
		Label oldEnd2_bounds = end2_bounds;
		end2_bounds = newEnd2_bounds;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.LINK__END2_BOUNDS, oldEnd2_bounds, newEnd2_bounds);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd2_bounds(Label newEnd2_bounds) {
		if (newEnd2_bounds != end2_bounds) {
			NotificationChain msgs = null;
			if (end2_bounds != null)
				msgs = ((InternalEObject)end2_bounds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.LINK__END2_BOUNDS, null, msgs);
			if (newEnd2_bounds != null)
				msgs = ((InternalEObject)newEnd2_bounds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.LINK__END2_BOUNDS, null, msgs);
			msgs = basicSetEnd2_bounds(newEnd2_bounds, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.LINK__END2_BOUNDS, newEnd2_bounds, newEnd2_bounds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getEnd1_bounds() {
		return end1_bounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnd1_bounds(Label newEnd1_bounds, NotificationChain msgs) {
		Label oldEnd1_bounds = end1_bounds;
		end1_bounds = newEnd1_bounds;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.LINK__END1_BOUNDS, oldEnd1_bounds, newEnd1_bounds);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd1_bounds(Label newEnd1_bounds) {
		if (newEnd1_bounds != end1_bounds) {
			NotificationChain msgs = null;
			if (end1_bounds != null)
				msgs = ((InternalEObject)end1_bounds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.LINK__END1_BOUNDS, null, msgs);
			if (newEnd1_bounds != null)
				msgs = ((InternalEObject)newEnd1_bounds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.LINK__END1_BOUNDS, null, msgs);
			msgs = basicSetEnd1_bounds(newEnd1_bounds, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.LINK__END1_BOUNDS, newEnd1_bounds, newEnd1_bounds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Node newTarget, NotificationChain msgs) {
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.LINK__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Node newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.LINK__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.LINK__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.LINK__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Node newSource, NotificationChain msgs) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.LINK__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Node newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.LINK__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.LINK__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.LINK__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramInterchangePackage.LINK__NAME:
				return basicSetName(null, msgs);
			case DiagramInterchangePackage.LINK__END2_BOUNDS:
				return basicSetEnd2_bounds(null, msgs);
			case DiagramInterchangePackage.LINK__END1_BOUNDS:
				return basicSetEnd1_bounds(null, msgs);
			case DiagramInterchangePackage.LINK__TARGET:
				return basicSetTarget(null, msgs);
			case DiagramInterchangePackage.LINK__SOURCE:
				return basicSetSource(null, msgs);
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
			case DiagramInterchangePackage.LINK__NAME:
				return getName();
			case DiagramInterchangePackage.LINK__END2_BOUNDS:
				return getEnd2_bounds();
			case DiagramInterchangePackage.LINK__END1_BOUNDS:
				return getEnd1_bounds();
			case DiagramInterchangePackage.LINK__TARGET:
				return getTarget();
			case DiagramInterchangePackage.LINK__SOURCE:
				return getSource();
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
			case DiagramInterchangePackage.LINK__NAME:
				setName((Label)newValue);
				return;
			case DiagramInterchangePackage.LINK__END2_BOUNDS:
				setEnd2_bounds((Label)newValue);
				return;
			case DiagramInterchangePackage.LINK__END1_BOUNDS:
				setEnd1_bounds((Label)newValue);
				return;
			case DiagramInterchangePackage.LINK__TARGET:
				setTarget((Node)newValue);
				return;
			case DiagramInterchangePackage.LINK__SOURCE:
				setSource((Node)newValue);
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
			case DiagramInterchangePackage.LINK__NAME:
				setName((Label)null);
				return;
			case DiagramInterchangePackage.LINK__END2_BOUNDS:
				setEnd2_bounds((Label)null);
				return;
			case DiagramInterchangePackage.LINK__END1_BOUNDS:
				setEnd1_bounds((Label)null);
				return;
			case DiagramInterchangePackage.LINK__TARGET:
				setTarget((Node)null);
				return;
			case DiagramInterchangePackage.LINK__SOURCE:
				setSource((Node)null);
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
			case DiagramInterchangePackage.LINK__NAME:
				return name != null;
			case DiagramInterchangePackage.LINK__END2_BOUNDS:
				return end2_bounds != null;
			case DiagramInterchangePackage.LINK__END1_BOUNDS:
				return end1_bounds != null;
			case DiagramInterchangePackage.LINK__TARGET:
				return target != null;
			case DiagramInterchangePackage.LINK__SOURCE:
				return source != null;
		}
		return super.eIsSet(featureID);
	}

} //LinkImpl
