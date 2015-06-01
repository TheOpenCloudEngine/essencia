/**
 */
package Essence.View;

import Essence.Foundation.LanguageElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ViewSelection#getName <em>Name</em>}</li>
 *   <li>{@link ViewSelection#getDescription <em>Description</em>}</li>
 *   <li>{@link ViewSelection#getFeatureSelection <em>Feature Selection</em>}</li>
 *   <li>{@link ViewSelection#getConstructSelection <em>Construct Selection</em>}</li>
 *   <li>{@link ViewSelection#getIncludedViewSelection <em>Included View Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.View.ViewPackage#getViewSelection()
 * @model
 * @generated
 */
public interface ViewSelection extends LanguageElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see Essence.View.ViewPackage#getViewSelection_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ViewSelection#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see Essence.View.ViewPackage#getViewSelection_Description()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link ViewSelection#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Feature Selection</b></em>' reference list.
	 * The list contents are of type {@link FeatureSelection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Selection</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Selection</em>' reference list.
	 * @see Essence.View.ViewPackage#getViewSelection_FeatureSelection()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<FeatureSelection> getFeatureSelection();

	/**
	 * Returns the value of the '<em><b>Construct Selection</b></em>' reference list.
	 * The list contents are of type {@link Essence.Foundation.LanguageElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Construct Selection</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Construct Selection</em>' reference list.
	 * @see Essence.View.ViewPackage#getViewSelection_ConstructSelection()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<LanguageElement> getConstructSelection();

	/**
	 * Returns the value of the '<em><b>Included View Selection</b></em>' reference list.
	 * The list contents are of type {@link ViewSelection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included View Selection</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included View Selection</em>' reference list.
	 * @see Essence.View.ViewPackage#getViewSelection_IncludedViewSelection()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ViewSelection> getIncludedViewSelection();

} // ViewSelection
