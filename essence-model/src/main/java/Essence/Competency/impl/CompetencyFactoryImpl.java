/**
 */
package Essence.Competency.impl;

import Essence.Competency.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompetencyFactoryImpl extends EFactoryImpl implements CompetencyFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompetencyFactory init() {
		try {
			CompetencyFactory theCompetencyFactory = (CompetencyFactory)EPackage.Registry.INSTANCE.getEFactory(CompetencyPackage.eNS_URI);
			if (theCompetencyFactory != null) {
				return theCompetencyFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CompetencyFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompetencyFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CompetencyPackage.COMPETENCY: return createCompetency();
			case CompetencyPackage.COMPETENCY_LEVEL: return createCompetencyLevel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Competency createCompetency() {
		CompetencyImpl competency = new CompetencyImpl();
		return competency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompetencyLevel createCompetencyLevel() {
		CompetencyLevelImpl competencyLevel = new CompetencyLevelImpl();
		return competencyLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompetencyPackage getCompetencyPackage() {
		return (CompetencyPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CompetencyPackage getPackage() {
		return CompetencyPackage.eINSTANCE;
	}

} //CompetencyFactoryImpl
