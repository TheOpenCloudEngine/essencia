/**
 */
package Essence.DiagramInterchange;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Diagram#getDiagramElement <em>Diagram Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see DiagramInterchangePackage#getDiagram()
 * @model
 * @generated
 */
public interface Diagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Diagram Element</b></em>' containment reference list.
	 * The list contents are of type {@link DiagramElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Element</em>' containment reference list.
	 * @see DiagramInterchangePackage#getDiagram_DiagramElement()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DiagramElement> getDiagramElement();

} // Diagram
