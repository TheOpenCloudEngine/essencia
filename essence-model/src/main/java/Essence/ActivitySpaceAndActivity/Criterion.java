/**
 */
package Essence.ActivitySpaceAndActivity;

import Essence.AlphaAndWorkProduct.LevelOfDetail;
import Essence.AlphaAndWorkProduct.State;

import Essence.Foundation.LanguageElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Criterion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Criterion#getDescription <em>Description</em>}</li>
 *   <li>{@link Criterion#getState <em>State</em>}</li>
 *   <li>{@link Criterion#getLevelOfDetail <em>Level Of Detail</em>}</li>
 * </ul>
 * </p>
 *
 * @see ActivitySpaceAndActivityPackage#getCriterion()
 * @model abstract="true"
 * @generated
 */
public interface Criterion extends LanguageElement {
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
	 * @see ActivitySpaceAndActivityPackage#getCriterion_Description()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link Criterion#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' reference.
	 * @see #setState(State)
	 * @see ActivitySpaceAndActivityPackage#getCriterion_State()
	 * @model ordered="false"
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link Criterion#getState <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

	/**
	 * Returns the value of the '<em><b>Level Of Detail</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level Of Detail</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level Of Detail</em>' reference.
	 * @see #setLevelOfDetail(LevelOfDetail)
	 * @see ActivitySpaceAndActivityPackage#getCriterion_LevelOfDetail()
	 * @model ordered="false"
	 * @generated
	 */
	LevelOfDetail getLevelOfDetail();

	/**
	 * Sets the value of the '{@link Criterion#getLevelOfDetail <em>Level Of Detail</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level Of Detail</em>' reference.
	 * @see #getLevelOfDetail()
	 * @generated
	 */
	void setLevelOfDetail(LevelOfDetail value);

} // Criterion
