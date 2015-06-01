/**
 */
package Essence.DiagramInterchange.impl;

import Essence.DiagramInterchange.DetailCard;
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
 * An implementation of the model object '<em><b>Detail Card</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DetailCardImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link DetailCardImpl#getLeftHeaderSide <em>Left Header Side</em>}</li>
 *   <li>{@link DetailCardImpl#getFooter <em>Footer</em>}</li>
 *   <li>{@link DetailCardImpl#getBody <em>Body</em>}</li>
 *   <li>{@link DetailCardImpl#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DetailCardImpl extends MinimalEObjectImpl.Container implements DetailCard {
	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Node header;

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
	 * The cached value of the '{@link #getFooter() <em>Footer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFooter()
	 * @generated
	 * @ordered
	 */
	protected Label footer;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected Text body;

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
	protected DetailCardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramInterchangePackage.Literals.DETAIL_CARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeader(Node newHeader, NotificationChain msgs) {
		Node oldHeader = header;
		header = newHeader;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DETAIL_CARD__HEADER, oldHeader, newHeader);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeader(Node newHeader) {
		if (newHeader != header) {
			NotificationChain msgs = null;
			if (header != null)
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.DETAIL_CARD__HEADER, null, msgs);
			if (newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.DETAIL_CARD__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DETAIL_CARD__HEADER, newHeader, newHeader));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DETAIL_CARD__LEFT_HEADER_SIDE, oldLeftHeaderSide, newLeftHeaderSide);
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
				msgs = ((InternalEObject)leftHeaderSide).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.DETAIL_CARD__LEFT_HEADER_SIDE, null, msgs);
			if (newLeftHeaderSide != null)
				msgs = ((InternalEObject)newLeftHeaderSide).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.DETAIL_CARD__LEFT_HEADER_SIDE, null, msgs);
			msgs = basicSetLeftHeaderSide(newLeftHeaderSide, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DETAIL_CARD__LEFT_HEADER_SIDE, newLeftHeaderSide, newLeftHeaderSide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getFooter() {
		return footer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFooter(Label newFooter, NotificationChain msgs) {
		Label oldFooter = footer;
		footer = newFooter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DETAIL_CARD__FOOTER, oldFooter, newFooter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFooter(Label newFooter) {
		if (newFooter != footer) {
			NotificationChain msgs = null;
			if (footer != null)
				msgs = ((InternalEObject)footer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.DETAIL_CARD__FOOTER, null, msgs);
			if (newFooter != null)
				msgs = ((InternalEObject)newFooter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.DETAIL_CARD__FOOTER, null, msgs);
			msgs = basicSetFooter(newFooter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DETAIL_CARD__FOOTER, newFooter, newFooter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(Text newBody, NotificationChain msgs) {
		Text oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DETAIL_CARD__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(Text newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.DETAIL_CARD__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramInterchangePackage.DETAIL_CARD__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DETAIL_CARD__BODY, newBody, newBody));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramInterchangePackage.DETAIL_CARD__MODEL_ELEMENT, oldModelElement, modelElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DETAIL_CARD__MODEL_ELEMENT, oldModelElement, modelElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramInterchangePackage.DETAIL_CARD__HEADER:
				return basicSetHeader(null, msgs);
			case DiagramInterchangePackage.DETAIL_CARD__LEFT_HEADER_SIDE:
				return basicSetLeftHeaderSide(null, msgs);
			case DiagramInterchangePackage.DETAIL_CARD__FOOTER:
				return basicSetFooter(null, msgs);
			case DiagramInterchangePackage.DETAIL_CARD__BODY:
				return basicSetBody(null, msgs);
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
			case DiagramInterchangePackage.DETAIL_CARD__HEADER:
				return getHeader();
			case DiagramInterchangePackage.DETAIL_CARD__LEFT_HEADER_SIDE:
				return getLeftHeaderSide();
			case DiagramInterchangePackage.DETAIL_CARD__FOOTER:
				return getFooter();
			case DiagramInterchangePackage.DETAIL_CARD__BODY:
				return getBody();
			case DiagramInterchangePackage.DETAIL_CARD__MODEL_ELEMENT:
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
			case DiagramInterchangePackage.DETAIL_CARD__HEADER:
				setHeader((Node)newValue);
				return;
			case DiagramInterchangePackage.DETAIL_CARD__LEFT_HEADER_SIDE:
				setLeftHeaderSide((Node)newValue);
				return;
			case DiagramInterchangePackage.DETAIL_CARD__FOOTER:
				setFooter((Label)newValue);
				return;
			case DiagramInterchangePackage.DETAIL_CARD__BODY:
				setBody((Text)newValue);
				return;
			case DiagramInterchangePackage.DETAIL_CARD__MODEL_ELEMENT:
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
			case DiagramInterchangePackage.DETAIL_CARD__HEADER:
				setHeader((Node)null);
				return;
			case DiagramInterchangePackage.DETAIL_CARD__LEFT_HEADER_SIDE:
				setLeftHeaderSide((Node)null);
				return;
			case DiagramInterchangePackage.DETAIL_CARD__FOOTER:
				setFooter((Label)null);
				return;
			case DiagramInterchangePackage.DETAIL_CARD__BODY:
				setBody((Text)null);
				return;
			case DiagramInterchangePackage.DETAIL_CARD__MODEL_ELEMENT:
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
			case DiagramInterchangePackage.DETAIL_CARD__HEADER:
				return header != null;
			case DiagramInterchangePackage.DETAIL_CARD__LEFT_HEADER_SIDE:
				return leftHeaderSide != null;
			case DiagramInterchangePackage.DETAIL_CARD__FOOTER:
				return footer != null;
			case DiagramInterchangePackage.DETAIL_CARD__BODY:
				return body != null;
			case DiagramInterchangePackage.DETAIL_CARD__MODEL_ELEMENT:
				return modelElement != null;
		}
		return super.eIsSet(featureID);
	}

} //DetailCardImpl
