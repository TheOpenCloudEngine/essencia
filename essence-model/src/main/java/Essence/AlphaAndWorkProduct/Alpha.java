/**
 */
package Essence.AlphaAndWorkProduct;

import Essence.Foundation.BasicElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alpha</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Alpha#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see AlphaAndWorkProductPackage#getAlpha()
 * @model
 * @generated
 */
public interface Alpha extends BasicElement {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link State}.
	 * It is bidirectional and its opposite is '{@link State#getAlpha <em>Alpha</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see AlphaAndWorkProductPackage#getAlpha_States()
	 * @see State#getAlpha
	 * @model opposite="alpha" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<State> getStates();

} // Alpha
