/**
 */
package Essence.DiagramInterchange.impl;

import Essence.DiagramInterchange.DiagramElement;
import Essence.DiagramInterchange.DiagramInterchangePackage;

import Essence.Foundation.LanguageElement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DiagramElementImpl#getDiagramElement2 <em>Diagram Element2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramElementImpl extends MinimalEObjectImpl.Container implements DiagramElement {
	/**
	 * The cached value of the '{@link #getDiagramElement2() <em>Diagram Element2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramElement2()
	 * @generated
	 * @ordered
	 */
	protected LanguageElement diagramElement2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramInterchangePackage.Literals.DIAGRAM_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageElement getDiagramElement2() {
		if (diagramElement2 != null && diagramElement2.eIsProxy()) {
			InternalEObject oldDiagramElement2 = (InternalEObject)diagramElement2;
			diagramElement2 = (LanguageElement)eResolveProxy(oldDiagramElement2);
			if (diagramElement2 != oldDiagramElement2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramInterchangePackage.DIAGRAM_ELEMENT__DIAGRAM_ELEMENT2, oldDiagramElement2, diagramElement2));
			}
		}
		return diagramElement2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageElement basicGetDiagramElement2() {
		return diagramElement2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramElement2(LanguageElement newDiagramElement2) {
		LanguageElement oldDiagramElement2 = diagramElement2;
		diagramElement2 = newDiagramElement2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramInterchangePackage.DIAGRAM_ELEMENT__DIAGRAM_ELEMENT2, oldDiagramElement2, diagramElement2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramInterchangePackage.DIAGRAM_ELEMENT__DIAGRAM_ELEMENT2:
				if (resolve) return getDiagramElement2();
				return basicGetDiagramElement2();
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
			case DiagramInterchangePackage.DIAGRAM_ELEMENT__DIAGRAM_ELEMENT2:
				setDiagramElement2((LanguageElement)newValue);
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
			case DiagramInterchangePackage.DIAGRAM_ELEMENT__DIAGRAM_ELEMENT2:
				setDiagramElement2((LanguageElement)null);
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
			case DiagramInterchangePackage.DIAGRAM_ELEMENT__DIAGRAM_ELEMENT2:
				return diagramElement2 != null;
		}
		return super.eIsSet(featureID);
	}

} //DiagramElementImpl
