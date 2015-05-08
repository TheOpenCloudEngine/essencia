/**
 */
package Essence.Competency;

import Essence.Foundation.BasicElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Competency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.Competency.Competency#getPossibleLevel <em>Possible Level</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Competency.CompetencyPackage#getCompetency()
 * @model
 * @generated
 */
public interface Competency extends BasicElement {
	/**
	 * Returns the value of the '<em><b>Possible Level</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.Competency.CompetencyLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Possible Level</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Possible Level</em>' containment reference list.
	 * @see Essence.Competency.CompetencyPackage#getCompetency_PossibleLevel()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<CompetencyLevel> getPossibleLevel();

} // Competency
