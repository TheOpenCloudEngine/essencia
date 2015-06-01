/**
 */
package Essence.DiagramInterchange;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Node#getBottomRightLabel <em>Bottom Right Label</em>}</li>
 *   <li>{@link Node#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getNode()
 * @model
 * @generated
 */
public interface Node extends DiagramElement {
	/**
	 * Returns the value of the '<em><b>Bottom Right Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bottom Right Label</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bottom Right Label</em>' containment reference.
	 * @see #setBottomRightLabel(Label)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getNode_BottomRightLabel()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Label getBottomRightLabel();

	/**
	 * Sets the value of the '{@link Node#getBottomRightLabel <em>Bottom Right Label</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bottom Right Label</em>' containment reference.
	 * @see #getBottomRightLabel()
	 * @generated
	 */
	void setBottomRightLabel(Label value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(Label)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getNode_Name()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Label getName();

	/**
	 * Sets the value of the '{@link Node#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(Label value);

} // Node
