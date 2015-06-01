/**
 */
package Essence.DiagramInterchange.impl;

import Essence.DiagramInterchange.Card;
import Essence.DiagramInterchange.Diagram;
import Essence.DiagramInterchange.DiagramInterchangePackage;
import Essence.DiagramInterchange.Label;
import Essence.DiagramInterchange.Node;
import Essence.DiagramInterchange.Text;

import Essence.Foundation.BasicElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Card</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CardImpl#getLeftHeaderSide <em>Left Header Side</em>}</li>
 *   <li>{@link CardImpl#getLeftBodySide <em>Left Body Side</em>}</li>
 *   <li>{@link CardImpl#getRightBodySide <em>Right Body Side</em>}</li>
 *   <li>{@link CardImpl#getRightHeaderSide <em>Right Header Side</em>}</li>
 *   <li>{@link CardImpl#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CardImpl extends MinimalEObjectImpl.Container implements Card {
	/**
	 * The cached value of the '{@link #getLeftHeaderSide() <em>Left Header Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftHeaderSide()
	 * @generated
	 * @ordered
	 */
	protected Node leftHeaderSide;

	/**
	 * The cached value of the '{@link #getLeftBodySide() <em>Left Body Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftBodySide()
	 * @generated
	 * @ordered
	 */
	protected Diagram leftBodySide;

	/**
	 * The cached value of the '{@link #getRightBodySide() <em>Right Body Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightBodySide()
	 * @generated
	 * @ordered
	 */
	protected Text rightBodySide;

	/**
	 * The cached value of the '{@link #getRightHeaderSide() <em>Right Header Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightHeaderSide()
	 * @generated
	 * @ordered
	 */
	protected Label rightHeaderSide;

	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected BasicElement modelElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramInterchangePackage.Literals.CARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getLeftHeaderSide() {
		return leftHeaderSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftHeaderSide(Node newLeftHeaderSide, NotificationChain msgs) {
		Node oldLeftHeaderSide = leftHeaderSide;
		leftHeaderSide = newLeftHeaderSide;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.CARD__LEFT_HEADER_SIDE, oldLeftHeaderSide, newLeftHeaderSide);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftHeaderSide(Node newLeftHeaderSide) {
		if (newLeftHeaderSide != leftHeaderSide) {
			NotificationChain msgs = null;
			if (leftHeaderSide != null)
				msgs = ((InternalEObject)leftHeaderSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.CARD__LEFT_HEADER_SIDE, null, msgs);
			if (newLeftHeaderSide != null)
				msgs = ((InternalEObject)newLeftHeaderSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.CARD__LEFT_HEADER_SIDE, null, msgs);
			msgs = basicSetLeftHeaderSide(newLeftHeaderSide, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.CARD__LEFT_HEADER_SIDE, newLeftHeaderSide, newLeftHeaderSide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getLeftBodySide() {
		return leftBodySide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftBodySide(Diagram newLeftBodySide, NotificationChain msgs) {
		Diagram oldLeftBodySide = leftBodySide;
		leftBodySide = newLeftBodySide;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.CARD__LEFT_BODY_SIDE, oldLeftBodySide, newLeftBodySide);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftBodySide(Diagram newLeftBodySide) {
		if (newLeftBodySide != leftBodySide) {
			NotificationChain msgs = null;
			if (leftBodySide != null)
				msgs = ((InternalEObject)leftBodySide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.CARD__LEFT_BODY_SIDE, null, msgs);
			if (newLeftBodySide != null)
				msgs = ((InternalEObject)newLeftBodySide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.CARD__LEFT_BODY_SIDE, null, msgs);
			msgs = basicSetLeftBodySide(newLeftBodySide, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.CARD__LEFT_BODY_SIDE, newLeftBodySide, newLeftBodySide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text getRightBodySide() {
		return rightBodySide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightBodySide(Text newRightBodySide, NotificationChain msgs) {
		Text oldRightBodySide = rightBodySide;
		rightBodySide = newRightBodySide;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.CARD__RIGHT_BODY_SIDE, oldRightBodySide, newRightBodySide);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightBodySide(Text newRightBodySide) {
		if (newRightBodySide != rightBodySide) {
			NotificationChain msgs = null;
			if (rightBodySide != null)
				msgs = ((InternalEObject)rightBodySide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.CARD__RIGHT_BODY_SIDE, null, msgs);
			if (newRightBodySide != null)
				msgs = ((InternalEObject)newRightBodySide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.CARD__RIGHT_BODY_SIDE, null, msgs);
			msgs = basicSetRightBodySide(newRightBodySide, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.CARD__RIGHT_BODY_SIDE, newRightBodySide, newRightBodySide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getRightHeaderSide() {
		return rightHeaderSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightHeaderSide(Label newRightHeaderSide, NotificationChain msgs) {
		Label oldRightHeaderSide = rightHeaderSide;
		rightHeaderSide = newRightHeaderSide;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.CARD__RIGHT_HEADER_SIDE, oldRightHeaderSide, newRightHeaderSide);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightHeaderSide(Label newRightHeaderSide) {
		if (newRightHeaderSide != rightHeaderSide) {
			NotificationChain msgs = null;
			if (rightHeaderSide != null)
				msgs = ((InternalEObject)rightHeaderSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.CARD__RIGHT_HEADER_SIDE, null, msgs);
			if (newRightHeaderSide != null)
				msgs = ((InternalEObject)newRightHeaderSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.CARD__RIGHT_HEADER_SIDE, null, msgs);
			msgs = basicSetRightHeaderSide(newRightHeaderSide, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.CARD__RIGHT_HEADER_SIDE, newRightHeaderSide, newRightHeaderSide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicElement getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject)modelElement;
			modelElement = (BasicElement)eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramInterchangePackage.CARD__MODEL_ELEMENT, oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicElement basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElement(BasicElement newModelElement) {
		BasicElement oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.CARD__MODEL_ELEMENT, oldModelElement, modelElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramInterchangePackage.CARD__LEFT_HEADER_SIDE:
				return basicSetLeftHeaderSide(null, msgs);
			case DiagramInterchangePackage.CARD__LEFT_BODY_SIDE:
				return basicSetLeftBodySide(null, msgs);
			case DiagramInterchangePackage.CARD__RIGHT_BODY_SIDE:
				return basicSetRightBodySide(null, msgs);
			case DiagramInterchangePackage.CARD__RIGHT_HEADER_SIDE:
				return basicSetRightHeaderSide(null, msgs);
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
			case DiagramInterchangePackage.CARD__LEFT_HEADER_SIDE:
				return getLeftHeaderSide();
			case DiagramInterchangePackage.CARD__LEFT_BODY_SIDE:
				return getLeftBodySide();
			case DiagramInterchangePackage.CARD__RIGHT_BODY_SIDE:
				return getRightBodySide();
			case DiagramInterchangePackage.CARD__RIGHT_HEADER_SIDE:
				return getRightHeaderSide();
			case DiagramInterchangePackage.CARD__MODEL_ELEMENT:
				if (resolve) return getModelElement();
				return basicGetModelElement();
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
			case DiagramInterchangePackage.CARD__LEFT_HEADER_SIDE:
				setLeftHeaderSide((Node)newValue);
				return;
			case DiagramInterchangePackage.CARD__LEFT_BODY_SIDE:
				setLeftBodySide((Diagram)newValue);
				return;
			case DiagramInterchangePackage.CARD__RIGHT_BODY_SIDE:
				setRightBodySide((Text)newValue);
				return;
			case DiagramInterchangePackage.CARD__RIGHT_HEADER_SIDE:
				setRightHeaderSide((Label)newValue);
				return;
			case DiagramInterchangePackage.CARD__MODEL_ELEMENT:
				setModelElement((BasicElement)newValue);
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
			case DiagramInterchangePackage.CARD__LEFT_HEADER_SIDE:
				setLeftHeaderSide((Node)null);
				return;
			case DiagramInterchangePackage.CARD__LEFT_BODY_SIDE:
				setLeftBodySide((Diagram)null);
				return;
			case DiagramInterchangePackage.CARD__RIGHT_BODY_SIDE:
				setRightBodySide((Text)null);
				return;
			case DiagramInterchangePackage.CARD__RIGHT_HEADER_SIDE:
				setRightHeaderSide((Label)null);
				return;
			case DiagramInterchangePackage.CARD__MODEL_ELEMENT:
				setModelElement((BasicElement)null);
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
			case DiagramInterchangePackage.CARD__LEFT_HEADER_SIDE:
				return leftHeaderSide != null;
			case DiagramInterchangePackage.CARD__LEFT_BODY_SIDE:
				return leftBodySide != null;
			case DiagramInterchangePackage.CARD__RIGHT_BODY_SIDE:
				return rightBodySide != null;
			case DiagramInterchangePackage.CARD__RIGHT_HEADER_SIDE:
				return rightHeaderSide != null;
			case DiagramInterchangePackage.CARD__MODEL_ELEMENT:
				return modelElement != null;
		}
		return super.eIsSet(featureID);
	}

} //CardImpl
