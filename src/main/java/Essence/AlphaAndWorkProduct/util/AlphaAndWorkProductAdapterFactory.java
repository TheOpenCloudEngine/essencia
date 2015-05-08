/**
 */
package Essence.AlphaAndWorkProduct.util;

import Essence.AlphaAndWorkProduct.*;

import Essence.Foundation.BasicElement;
import Essence.Foundation.LanguageElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see Essence.AlphaAndWorkProduct.AlphaAndWorkProductPackage
 * @generated
 */
public class AlphaAndWorkProductAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AlphaAndWorkProductPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlphaAndWorkProductAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AlphaAndWorkProductPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlphaAndWorkProductSwitch<Adapter> modelSwitch =
		new AlphaAndWorkProductSwitch<Adapter>() {
			@Override
			public Adapter caseAlpha(Alpha object) {
				return createAlphaAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter caseAlphaAssociation(AlphaAssociation object) {
				return createAlphaAssociationAdapter();
			}
			@Override
			public Adapter caseWorkProduct(WorkProduct object) {
				return createWorkProductAdapter();
			}
			@Override
			public Adapter caseWorkProductManifest(WorkProductManifest object) {
				return createWorkProductManifestAdapter();
			}
			@Override
			public Adapter caseAlphaContainment(AlphaContainment object) {
				return createAlphaContainmentAdapter();
			}
			@Override
			public Adapter caseLevelOfDetail(LevelOfDetail object) {
				return createLevelOfDetailAdapter();
			}
			@Override
			public Adapter caseLanguageElement(LanguageElement object) {
				return createLanguageElementAdapter();
			}
			@Override
			public Adapter caseBasicElement(BasicElement object) {
				return createBasicElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link Essence.AlphaAndWorkProduct.Alpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.AlphaAndWorkProduct.Alpha
	 * @generated
	 */
	public Adapter createAlphaAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.AlphaAndWorkProduct.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.AlphaAndWorkProduct.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.AlphaAndWorkProduct.AlphaAssociation <em>Alpha Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.AlphaAndWorkProduct.AlphaAssociation
	 * @generated
	 */
	public Adapter createAlphaAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.AlphaAndWorkProduct.WorkProduct <em>Work Product</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.AlphaAndWorkProduct.WorkProduct
	 * @generated
	 */
	public Adapter createWorkProductAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.AlphaAndWorkProduct.WorkProductManifest <em>Work Product Manifest</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.AlphaAndWorkProduct.WorkProductManifest
	 * @generated
	 */
	public Adapter createWorkProductManifestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.AlphaAndWorkProduct.AlphaContainment <em>Alpha Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.AlphaAndWorkProduct.AlphaContainment
	 * @generated
	 */
	public Adapter createAlphaContainmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.AlphaAndWorkProduct.LevelOfDetail <em>Level Of Detail</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.AlphaAndWorkProduct.LevelOfDetail
	 * @generated
	 */
	public Adapter createLevelOfDetailAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.LanguageElement <em>Language Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.LanguageElement
	 * @generated
	 */
	public Adapter createLanguageElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.BasicElement <em>Basic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.BasicElement
	 * @generated
	 */
	public Adapter createBasicElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AlphaAndWorkProductAdapterFactory
