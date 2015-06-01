/**
 */
package Essence.Competency.impl;

import Essence.Competency.CompetencyLevel;
import Essence.Competency.CompetencyPackage;

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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link CompetencyLevelImpl#getName <em>Name</em>}</li>
 *   <li>{@link CompetencyLevelImpl#getBriefDescription <em>Brief Description</em>}</li>
 *   <li>{@link CompetencyLevelImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link CompetencyLevelImpl#getChecklistItem <em>Checklist Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompetencyLevelImpl extends LanguageElementImpl implements CompetencyLevel {
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
	 * The default value of the '{@link #getBriefDescription() <em>Brief Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBriefDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String BRIEF_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBriefDescription() <em>Brief Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBriefDescription()
	 * @generated
	 * @ordered
	 */
	protected String briefDescription = BRIEF_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected int level = LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChecklistItem() <em>Checklist Item</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChecklistItem()
	 * @generated
	 * @ordered
	 */
	protected EList<Checkpoint> checklistItem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompetencyLevelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompetencyPackage.Literals.COMPETENCY_LEVEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CompetencyPackage.COMPETENCY_LEVEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBriefDescription() {
		return briefDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBriefDescription(String newBriefDescription) {
		String oldBriefDescription = briefDescription;
		briefDescription = newBriefDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompetencyPackage.COMPETENCY_LEVEL__BRIEF_DESCRIPTION, oldBriefDescription, briefDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(int newLevel) {
		int oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompetencyPackage.COMPETENCY_LEVEL__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Checkpoint> getChecklistItem() {
		if (checklistItem == null) {
			checklistItem = new EObjectContainmentEList<Checkpoint>(Checkpoint.class, this, CompetencyPackage.COMPETENCY_LEVEL__CHECKLIST_ITEM);
		}
		return checklistItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompetencyPackage.COMPETENCY_LEVEL__CHECKLIST_ITEM:
				return ((InternalEList<?>)getChecklistItem()).basicRemove(otherEnd, msgs);
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
			case CompetencyPackage.COMPETENCY_LEVEL__NAME:
				return getName();
			case CompetencyPackage.COMPETENCY_LEVEL__BRIEF_DESCRIPTION:
				return getBriefDescription();
			case CompetencyPackage.COMPETENCY_LEVEL__LEVEL:
				return getLevel();
			case CompetencyPackage.COMPETENCY_LEVEL__CHECKLIST_ITEM:
				return getChecklistItem();
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
			case CompetencyPackage.COMPETENCY_LEVEL__NAME:
				setName((String)newValue);
				return;
			case CompetencyPackage.COMPETENCY_LEVEL__BRIEF_DESCRIPTION:
				setBriefDescription((String)newValue);
				return;
			case CompetencyPackage.COMPETENCY_LEVEL__LEVEL:
				setLevel((Integer)newValue);
				return;
			case CompetencyPackage.COMPETENCY_LEVEL__CHECKLIST_ITEM:
				getChecklistItem().clear();
				getChecklistItem().addAll((Collection<? extends Checkpoint>)newValue);
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
			case CompetencyPackage.COMPETENCY_LEVEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CompetencyPackage.COMPETENCY_LEVEL__BRIEF_DESCRIPTION:
				setBriefDescription(BRIEF_DESCRIPTION_EDEFAULT);
				return;
			case CompetencyPackage.COMPETENCY_LEVEL__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case CompetencyPackage.COMPETENCY_LEVEL__CHECKLIST_ITEM:
				getChecklistItem().clear();
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
			case CompetencyPackage.COMPETENCY_LEVEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CompetencyPackage.COMPETENCY_LEVEL__BRIEF_DESCRIPTION:
				return BRIEF_DESCRIPTION_EDEFAULT == null ? briefDescription != null : !BRIEF_DESCRIPTION_EDEFAULT.equals(briefDescription);
			case CompetencyPackage.COMPETENCY_LEVEL__LEVEL:
				return level != LEVEL_EDEFAULT;
			case CompetencyPackage.COMPETENCY_LEVEL__CHECKLIST_ITEM:
				return checklistItem != null && !checklistItem.isEmpty();
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
		result.append(", briefDescription: ");
		result.append(briefDescription);
		result.append(", level: ");
		result.append(level);
		result.append(')');
		return result.toString();
	}

} //CompetencyLevelImpl
