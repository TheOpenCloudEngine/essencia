/**
 */
package Essence.DiagramInterchange;

import Essence.Foundation.BasicElement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Detail Card</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link Essence.DiagramInterchange.DetailCard#getHeader <em>Header</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.DetailCard#getLeftHeaderSide <em>Left Header Side</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.DetailCard#getFooter <em>Footer</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.DetailCard#getBody <em>Body</em>}</li>
 *   <li>{@link Essence.DiagramInterchange.DetailCard#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getDetailCard()
 * @model
 * @generated
 */
public interface DetailCard extends EObject {
	/**
	 * Returns the value of the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Header</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Header</em>' containment reference.
	 * @see #setHeader(Node)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getDetailCard_Header()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Node getHeader();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.DetailCard#getHeader <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Header</em>' containment reference.
	 * @see #getHeader()
	 * @generated
	 */
	void setHeader(Node value);

	/**
	 * Returns the value of the '<em><b>Left Header Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Header Side</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Header Side</em>' containment reference.
	 * @see #setLeftHeaderSide(Node)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getDetailCard_LeftHeaderSide()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Node getLeftHeaderSide();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.DetailCard#getLeftHeaderSide <em>Left Header Side</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Header Side</em>' containment reference.
	 * @see #getLeftHeaderSide()
	 * @generated
	 */
	void setLeftHeaderSide(Node value);

	/**
	 * Returns the value of the '<em><b>Footer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Footer</em>' containment reference.
	 * @see #setFooter(Label)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getDetailCard_Footer()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Label getFooter();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.DetailCard#getFooter <em>Footer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Footer</em>' containment reference.
	 * @see #getFooter()
	 * @generated
	 */
	void setFooter(Label value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Text)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getDetailCard_Body()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	Text getBody();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.DetailCard#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Text value);

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference.
	 * @see #setModelElement(BasicElement)
	 * @see Essence.DiagramInterchange.DiagramInterchangePackage#getDetailCard_ModelElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BasicElement getModelElement();

	/**
	 * Sets the value of the '{@link Essence.DiagramInterchange.DetailCard#getModelElement <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(BasicElement value);

} // DetailCard
