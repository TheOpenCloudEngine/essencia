/**
 */
package Essence.Competency;

import Essence.Foundation.Checkpoint;
import Essence.Foundation.LanguageElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.Competency.CompetencyLevel#getName <em>Name</em>}</li>
 *   <li>{@link Essence.Competency.CompetencyLevel#getBriefDescription <em>Brief Description</em>}</li>
 *   <li>{@link Essence.Competency.CompetencyLevel#getLevel <em>Level</em>}</li>
 *   <li>{@link Essence.Competency.CompetencyLevel#getChecklistItem <em>Checklist Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Competency.CompetencyPackage#getCompetencyLevel()
 * @model
 * @generated
 */
public interface CompetencyLevel extends LanguageElement {
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
	 * @see Essence.Competency.CompetencyPackage#getCompetencyLevel_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link Essence.Competency.CompetencyLevel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Brief Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Brief Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Brief Description</em>' attribute.
	 * @see #setBriefDescription(String)
	 * @see Essence.Competency.CompetencyPackage#getCompetencyLevel_BriefDescription()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getBriefDescription();

	/**
	 * Sets the value of the '{@link Essence.Competency.CompetencyLevel#getBriefDescription <em>Brief Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Brief Description</em>' attribute.
	 * @see #getBriefDescription()
	 * @generated
	 */
	void setBriefDescription(String value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(int)
	 * @see Essence.Competency.CompetencyPackage#getCompetencyLevel_Level()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getLevel();

	/**
	 * Sets the value of the '{@link Essence.Competency.CompetencyLevel#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(int value);

	/**
	 * Returns the value of the '<em><b>Checklist Item</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.Foundation.Checkpoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checklist Item</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checklist Item</em>' containment reference list.
	 * @see Essence.Competency.CompetencyPackage#getCompetencyLevel_ChecklistItem()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Checkpoint> getChecklistItem();

} // CompetencyLevel
