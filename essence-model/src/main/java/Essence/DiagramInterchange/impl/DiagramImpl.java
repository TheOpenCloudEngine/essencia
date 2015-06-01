/**
 */
package Essence.DiagramInterchange.impl;

import Essence.DiagramInterchange.Diagram;
import Essence.DiagramInterchange.DiagramElement;
import Essence.DiagramInterchange.DiagramInterchangePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link DiagramImpl#getDiagramElement <em>Diagram Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiagramImpl extends MinimalEObjectImpl.Container implements Diagram {
	/**
	 * The cached value of the '{@link #getDiagramElement() <em>Diagram Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramElement()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagramElement> diagramElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramInterchangePackage.Literals.DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiagramElement> getDiagramElement() {
		if (diagramElement == null) {
			diagramElement = new EObjectContainmentEList<DiagramElement>(DiagramElement.class, this, DiagramInterchangePackage.DIAGRAM__DIAGRAM_ELEMENT);
		}
		return diagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramInterchangePackage.DIAGRAM__DIAGRAM_ELEMENT:
				return ((InternalEList<?>)getDiagramElement()).basicRemove(otherEnd, msgs);
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
			case DiagramInterchangePackage.DIAGRAM__DIAGRAM_ELEMENT:
				return getDiagramElement();
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
			case DiagramInterchangePackage.DIAGRAM__DIAGRAM_ELEMENT:
				getDiagramElement().clear();
				getDiagramElement().addAll((Collection<? extends DiagramElement>)newValue);
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
			case DiagramInterchangePackage.DIAGRAM__DIAGRAM_ELEMENT:
				getDiagramElement().clear();
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
			case DiagramInterchangePackage.DIAGRAM__DIAGRAM_ELEMENT:
				return diagramElement != null && !diagramElement.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DiagramImpl
