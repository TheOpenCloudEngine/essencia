/**
 */
package Essence.DiagramInterchange;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.DiagramInterchange.Link#getName <em>Name</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.Link#getEnd2_bounds <em>End2 bounds</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.Link#getEnd1_bounds <em>End1 bounds</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.Link#getTarget <em>Target</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.Link#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getLink()
 * @model
 * @generated
 */
public interface Link extends DiagramElement {
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
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getLink_Name()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Label getName();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.Link#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(Label value);

	/**
	 * Returns the value of the '<em><b>End2 bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End2 bounds</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End2 bounds</em>' containment reference.
	 * @see #setEnd2_bounds(Label)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getLink_End2_bounds()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Label getEnd2_bounds();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.Link#getEnd2_bounds <em>End2 bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End2 bounds</em>' containment reference.
	 * @see #getEnd2_bounds()
	 * @generated
	 */
	void setEnd2_bounds(Label value);

	/**
	 * Returns the value of the '<em><b>End1 bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End1 bounds</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End1 bounds</em>' containment reference.
	 * @see #setEnd1_bounds(Label)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getLink_End1_bounds()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Label getEnd1_bounds();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.Link#getEnd1_bounds <em>End1 bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End1 bounds</em>' containment reference.
	 * @see #getEnd1_bounds()
	 * @generated
	 */
	void setEnd1_bounds(Label value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Node)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getLink_Target()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.Link#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(Node)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getLink_Source()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.Link#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

} // Link
