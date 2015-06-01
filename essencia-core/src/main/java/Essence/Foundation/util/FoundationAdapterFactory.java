/**
 */
package Essence.Foundation.util;

import Essence.Foundation.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see Essence.Foundation.FoundationPackage
 * @generated
 */
public class FoundationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FoundationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoundationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FoundationPackage.eINSTANCE;
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
	protected FoundationSwitch<Adapter> modelSwitch =
		new FoundationSwitch<Adapter>() {
			@Override
			public Adapter caseLanguageElement(LanguageElement object) {
				return createLanguageElementAdapter();
			}
			@Override
			public Adapter caseBasicElement(BasicElement object) {
				return createBasicElementAdapter();
			}
			@Override
			public Adapter caseExtensionElement(ExtensionElement object) {
				return createExtensionElementAdapter();
			}
			@Override
			public Adapter caseTag(Tag object) {
				return createTagAdapter();
			}
			@Override
			public Adapter caseElementGroup(ElementGroup object) {
				return createElementGroupAdapter();
			}
			@Override
			public Adapter caseKernel(Kernel object) {
				return createKernelAdapter();
			}
			@Override
			public Adapter casePractice(Practice object) {
				return createPracticeAdapter();
			}
			@Override
			public Adapter caseLibrary(Library object) {
				return createLibraryAdapter();
			}
			@Override
			public Adapter casePattern(Pattern object) {
				return createPatternAdapter();
			}
			@Override
			public Adapter casePatternAssociation(PatternAssociation object) {
				return createPatternAssociationAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public Adapter caseEndeavorAssociation(EndeavorAssociation object) {
				return createEndeavorAssociationAdapter();
			}
			@Override
			public Adapter caseEndeavorProperty(EndeavorProperty object) {
				return createEndeavorPropertyAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseMethod(Method object) {
				return createMethodAdapter();
			}
			@Override
			public Adapter caseMergeResolution(MergeResolution object) {
				return createMergeResolutionAdapter();
			}
			@Override
			public Adapter casePracticeAsset(PracticeAsset object) {
				return createPracticeAssetAdapter();
			}
			@Override
			public Adapter caseCheckpoint(Checkpoint object) {
				return createCheckpointAdapter();
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
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.ExtensionElement <em>Extension Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.ExtensionElement
	 * @generated
	 */
	public Adapter createExtensionElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.Tag
	 * @generated
	 */
	public Adapter createTagAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.ElementGroup <em>Element Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.ElementGroup
	 * @generated
	 */
	public Adapter createElementGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.Kernel <em>Kernel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.Kernel
	 * @generated
	 */
	public Adapter createKernelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.Practice <em>Practice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.Practice
	 * @generated
	 */
	public Adapter createPracticeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.Library
	 * @generated
	 */
	public Adapter createLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.Pattern
	 * @generated
	 */
	public Adapter createPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.PatternAssociation <em>Pattern Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.PatternAssociation
	 * @generated
	 */
	public Adapter createPatternAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.EndeavorAssociation <em>Endeavor Association</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.EndeavorAssociation
	 * @generated
	 */
	public Adapter createEndeavorAssociationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.EndeavorProperty <em>Endeavor Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.EndeavorProperty
	 * @generated
	 */
	public Adapter createEndeavorPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.Method
	 * @generated
	 */
	public Adapter createMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.MergeResolution <em>Merge Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.MergeResolution
	 * @generated
	 */
	public Adapter createMergeResolutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.PracticeAsset <em>Practice Asset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.PracticeAsset
	 * @generated
	 */
	public Adapter createPracticeAssetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Essence.Foundation.Checkpoint <em>Checkpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Essence.Foundation.Checkpoint
	 * @generated
	 */
	public Adapter createCheckpointAdapter() {
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

} //FoundationAdapterFactory
