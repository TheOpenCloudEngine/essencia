/**
 */
package Essence.Foundation.impl;

import Essence.Foundation.FoundationPackage;
import Essence.Foundation.Practice;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Practice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link PracticeImpl#getConsistencyRules <em>Consistency Rules</em>}</li>
 *   <li>{@link PracticeImpl#getObjective <em>Objective</em>}</li>
 *   <li>{@link PracticeImpl#getMeasures <em>Measures</em>}</li>
 *   <li>{@link PracticeImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link PracticeImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PracticeImpl extends ElementGroupImpl implements Practice {
	/**
	 * The default value of the '{@link #getConsistencyRules() <em>Consistency Rules</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsistencyRules()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSISTENCY_RULES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConsistencyRules() <em>Consistency Rules</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsistencyRules()
	 * @generated
	 * @ordered
	 */
	protected String consistencyRules = CONSISTENCY_RULES_EDEFAULT;

	/**
	 * The default value of the '{@link #getObjective() <em>Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjective()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJECTIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObjective() <em>Objective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjective()
	 * @generated
	 * @ordered
	 */
	protected String objective = OBJECTIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMeasures() <em>Measures</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasures()
	 * @generated
	 * @ordered
	 */
	protected EList<String> measures;

	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected EList<String> entry;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected EList<String> result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PracticeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FoundationPackage.Literals.PRACTICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConsistencyRules() {
		return consistencyRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsistencyRules(String newConsistencyRules) {
		String oldConsistencyRules = consistencyRules;
		consistencyRules = newConsistencyRules;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.PRACTICE__CONSISTENCY_RULES, oldConsistencyRules, consistencyRules));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjective() {
		return objective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjective(String newObjective) {
		String oldObjective = objective;
		objective = newObjective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FoundationPackage.PRACTICE__OBJECTIVE, oldObjective, objective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMeasures() {
		if (measures == null) {
			measures = new EDataTypeUniqueEList<String>(String.class, this, FoundationPackage.PRACTICE__MEASURES);
		}
		return measures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEntry() {
		if (entry == null) {
			entry = new EDataTypeUniqueEList<String>(String.class, this, FoundationPackage.PRACTICE__ENTRY);
		}
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getResult() {
		if (result == null) {
			result = new EDataTypeUniqueEList<String>(String.class, this, FoundationPackage.PRACTICE__RESULT);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FoundationPackage.PRACTICE__CONSISTENCY_RULES:
				return getConsistencyRules();
			case FoundationPackage.PRACTICE__OBJECTIVE:
				return getObjective();
			case FoundationPackage.PRACTICE__MEASURES:
				return getMeasures();
			case FoundationPackage.PRACTICE__ENTRY:
				return getEntry();
			case FoundationPackage.PRACTICE__RESULT:
				return getResult();
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
			case FoundationPackage.PRACTICE__CONSISTENCY_RULES:
				setConsistencyRules((String)newValue);
				return;
			case FoundationPackage.PRACTICE__OBJECTIVE:
				setObjective((String)newValue);
				return;
			case FoundationPackage.PRACTICE__MEASURES:
				getMeasures().clear();
				getMeasures().addAll((Collection<? extends String>)newValue);
				return;
			case FoundationPackage.PRACTICE__ENTRY:
				getEntry().clear();
				getEntry().addAll((Collection<? extends String>)newValue);
				return;
			case FoundationPackage.PRACTICE__RESULT:
				getResult().clear();
				getResult().addAll((Collection<? extends String>)newValue);
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
			case FoundationPackage.PRACTICE__CONSISTENCY_RULES:
				setConsistencyRules(CONSISTENCY_RULES_EDEFAULT);
				return;
			case FoundationPackage.PRACTICE__OBJECTIVE:
				setObjective(OBJECTIVE_EDEFAULT);
				return;
			case FoundationPackage.PRACTICE__MEASURES:
				getMeasures().clear();
				return;
			case FoundationPackage.PRACTICE__ENTRY:
				getEntry().clear();
				return;
			case FoundationPackage.PRACTICE__RESULT:
				getResult().clear();
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
			case FoundationPackage.PRACTICE__CONSISTENCY_RULES:
				return CONSISTENCY_RULES_EDEFAULT == null ? consistencyRules != null : !CONSISTENCY_RULES_EDEFAULT.equals(consistencyRules);
			case FoundationPackage.PRACTICE__OBJECTIVE:
				return OBJECTIVE_EDEFAULT == null ? objective != null : !OBJECTIVE_EDEFAULT.equals(objective);
			case FoundationPackage.PRACTICE__MEASURES:
				return measures != null && !measures.isEmpty();
			case FoundationPackage.PRACTICE__ENTRY:
				return entry != null && !entry.isEmpty();
			case FoundationPackage.PRACTICE__RESULT:
				return result != null && !result.isEmpty();
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
		result.append(" (consistencyRules: ");
		result.append(consistencyRules);
		result.append(", objective: ");
		result.append(objective);
		result.append(", measures: ");
		result.append(measures);
		result.append(", entry: ");
		result.append(entry);
		result.append(", result: ");
		result.append(result);
		result.append(')');
		return result.toString();
	}

} //PracticeImpl
