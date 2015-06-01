/**
 */
package Essence.DiagramInterchange;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Essence.DiagramInterchange.DiagramInterchangeFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramInterchangePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DiagramInterchange";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.omg.org/spec/Essence/20140301#DiagramInterchange";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "essence.DiagramInterchange";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramInterchangePackage eINSTANCE = Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl.init();

	/**
	 * The meta object id for the '{@link Essence.DiagramInterchange.impl.DiagramElementImpl <em>Diagram Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.DiagramInterchange.impl.DiagramElementImpl
	 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getDiagramElement()
	 * @generated
	 */
	int DIAGRAM_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Diagram Element2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT__DIAGRAM_ELEMENT2 = 0;

	/**
	 * The number of structural features of the '<em>Diagram Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Diagram Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Essence.DiagramInterchange.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.DiagramInterchange.impl.NodeImpl
	 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getNode()
	 * @generated
	 */
	int NODE = 0;

	/**
	 * The feature id for the '<em><b>Diagram Element2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DIAGRAM_ELEMENT2 = DIAGRAM_ELEMENT__DIAGRAM_ELEMENT2;

	/**
	 * The feature id for the '<em><b>Bottom Right Label</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__BOTTOM_RIGHT_LABEL = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = DIAGRAM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.DiagramInterchange.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.DiagramInterchange.impl.LabelImpl
	 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 1;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Essence.DiagramInterchange.impl.CardImpl <em>Card</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.DiagramInterchange.impl.CardImpl
	 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getCard()
	 * @generated
	 */
	int CARD = 2;

	/**
	 * The feature id for the '<em><b>Left Header Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__LEFT_HEADER_SIDE = 0;

	/**
	 * The feature id for the '<em><b>Left Body Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__LEFT_BODY_SIDE = 1;

	/**
	 * The feature id for the '<em><b>Right Body Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__RIGHT_BODY_SIDE = 2;

	/**
	 * The feature id for the '<em><b>Right Header Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__RIGHT_HEADER_SIDE = 3;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD__MODEL_ELEMENT = 4;

	/**
	 * The number of structural features of the '<em>Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Essence.DiagramInterchange.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.DiagramInterchange.impl.LinkImpl
	 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getLink()
	 * @generated
	 */
	int LINK = 3;

	/**
	 * The feature id for the '<em><b>Diagram Element2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__DIAGRAM_ELEMENT2 = DIAGRAM_ELEMENT__DIAGRAM_ELEMENT2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__NAME = DIAGRAM_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End2 bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__END2_BOUNDS = DIAGRAM_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End1 bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__END1_BOUNDS = DIAGRAM_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TARGET = DIAGRAM_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__SOURCE = DIAGRAM_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = DIAGRAM_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = DIAGRAM_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link Essence.DiagramInterchange.impl.DetailCardImpl <em>Detail Card</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.DiagramInterchange.impl.DetailCardImpl
	 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getDetailCard()
	 * @generated
	 */
	int DETAIL_CARD = 4;

	/**
	 * The feature id for the '<em><b>Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CARD__HEADER = 0;

	/**
	 * The feature id for the '<em><b>Left Header Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CARD__LEFT_HEADER_SIDE = 1;

	/**
	 * The feature id for the '<em><b>Footer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CARD__FOOTER = 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CARD__BODY = 3;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CARD__MODEL_ELEMENT = 4;

	/**
	 * The number of structural features of the '<em>Detail Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CARD_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Detail Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAIL_CARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Essence.DiagramInterchange.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.DiagramInterchange.impl.DiagramImpl
	 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getDiagram()
	 * @generated
	 */
	int DIAGRAM = 5;

	/**
	 * The feature id for the '<em><b>Diagram Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM__DIAGRAM_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Essence.DiagramInterchange.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Essence.DiagramInterchange.impl.TextImpl
	 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getText()
	 * @generated
	 */
	int TEXT = 7;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the containment reference '{@link Node#getBottomRightLabel <em>Bottom Right Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bottom Right Label</em>'.
	 * @see Node#getBottomRightLabel()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_BottomRightLabel();

	/**
	 * Returns the meta object for the containment reference '{@link Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Name();

	/**
	 * Returns the meta object for class '{@link Essence.DiagramInterchange.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see Essence.DiagramInterchange.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for class '{@link Essence.DiagramInterchange.Card <em>Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Card</em>'.
	 * @see Essence.DiagramInterchange.Card
	 * @generated
	 */
	EClass getCard();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.Card#getLeftHeaderSide <em>Left Header Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Header Side</em>'.
	 * @see Essence.DiagramInterchange.Card#getLeftHeaderSide()
	 * @see #getCard()
	 * @generated
	 */
	EReference getCard_LeftHeaderSide();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.Card#getLeftBodySide <em>Left Body Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Body Side</em>'.
	 * @see Essence.DiagramInterchange.Card#getLeftBodySide()
	 * @see #getCard()
	 * @generated
	 */
	EReference getCard_LeftBodySide();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.Card#getRightBodySide <em>Right Body Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Body Side</em>'.
	 * @see Essence.DiagramInterchange.Card#getRightBodySide()
	 * @see #getCard()
	 * @generated
	 */
	EReference getCard_RightBodySide();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.Card#getRightHeaderSide <em>Right Header Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Header Side</em>'.
	 * @see Essence.DiagramInterchange.Card#getRightHeaderSide()
	 * @see #getCard()
	 * @generated
	 */
	EReference getCard_RightHeaderSide();

	/**
	 * Returns the meta object for the reference '{@link Essence.DiagramInterchange.Card#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element</em>'.
	 * @see Essence.DiagramInterchange.Card#getModelElement()
	 * @see #getCard()
	 * @generated
	 */
	EReference getCard_ModelElement();

	/**
	 * Returns the meta object for class '{@link Essence.DiagramInterchange.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see Essence.DiagramInterchange.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.Link#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Name</em>'.
	 * @see Essence.DiagramInterchange.Link#getName()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Name();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.Link#getEnd2_bounds <em>End2 bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End2 bounds</em>'.
	 * @see Essence.DiagramInterchange.Link#getEnd2_bounds()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_End2_bounds();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.Link#getEnd1_bounds <em>End1 bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End1 bounds</em>'.
	 * @see Essence.DiagramInterchange.Link#getEnd1_bounds()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_End1_bounds();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.Link#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see Essence.DiagramInterchange.Link#getTarget()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Target();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.Link#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see Essence.DiagramInterchange.Link#getSource()
	 * @see #getLink()
	 * @generated
	 */
	EReference getLink_Source();

	/**
	 * Returns the meta object for class '{@link Essence.DiagramInterchange.DetailCard <em>Detail Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Detail Card</em>'.
	 * @see Essence.DiagramInterchange.DetailCard
	 * @generated
	 */
	EClass getDetailCard();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.DetailCard#getHeader <em>Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Header</em>'.
	 * @see Essence.DiagramInterchange.DetailCard#getHeader()
	 * @see #getDetailCard()
	 * @generated
	 */
	EReference getDetailCard_Header();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.DetailCard#getLeftHeaderSide <em>Left Header Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Header Side</em>'.
	 * @see Essence.DiagramInterchange.DetailCard#getLeftHeaderSide()
	 * @see #getDetailCard()
	 * @generated
	 */
	EReference getDetailCard_LeftHeaderSide();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.DetailCard#getFooter <em>Footer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Footer</em>'.
	 * @see Essence.DiagramInterchange.DetailCard#getFooter()
	 * @see #getDetailCard()
	 * @generated
	 */
	EReference getDetailCard_Footer();

	/**
	 * Returns the meta object for the containment reference '{@link Essence.DiagramInterchange.DetailCard#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see Essence.DiagramInterchange.DetailCard#getBody()
	 * @see #getDetailCard()
	 * @generated
	 */
	EReference getDetailCard_Body();

	/**
	 * Returns the meta object for the reference '{@link Essence.DiagramInterchange.DetailCard#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model Element</em>'.
	 * @see Essence.DiagramInterchange.DetailCard#getModelElement()
	 * @see #getDetailCard()
	 * @generated
	 */
	EReference getDetailCard_ModelElement();

	/**
	 * Returns the meta object for class '{@link Essence.DiagramInterchange.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see Essence.DiagramInterchange.Diagram
	 * @generated
	 */
	EClass getDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link Essence.DiagramInterchange.Diagram#getDiagramElement <em>Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagram Element</em>'.
	 * @see Essence.DiagramInterchange.Diagram#getDiagramElement()
	 * @see #getDiagram()
	 * @generated
	 */
	EReference getDiagram_DiagramElement();

	/**
	 * Returns the meta object for class '{@link DiagramElement <em>Diagram Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Element</em>'.
	 * @see DiagramElement
	 * @generated
	 */
	EClass getDiagramElement();

	/**
	 * Returns the meta object for the reference '{@link DiagramElement#getDiagramElement2 <em>Diagram Element2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Diagram Element2</em>'.
	 * @see DiagramElement#getDiagramElement2()
	 * @see #getDiagramElement()
	 * @generated
	 */
	EReference getDiagramElement_DiagramElement2();

	/**
	 * Returns the meta object for class '{@link Essence.DiagramInterchange.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see Essence.DiagramInterchange.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramInterchangeFactory getDiagramInterchangeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Essence.DiagramInterchange.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.DiagramInterchange.impl.NodeImpl
		 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Bottom Right Label</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__BOTTOM_RIGHT_LABEL = eINSTANCE.getNode_BottomRightLabel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '{@link Essence.DiagramInterchange.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.DiagramInterchange.impl.LabelImpl
		 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '{@link Essence.DiagramInterchange.impl.CardImpl <em>Card</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.DiagramInterchange.impl.CardImpl
		 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getCard()
		 * @generated
		 */
		EClass CARD = eINSTANCE.getCard();

		/**
		 * The meta object literal for the '<em><b>Left Header Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARD__LEFT_HEADER_SIDE = eINSTANCE.getCard_LeftHeaderSide();

		/**
		 * The meta object literal for the '<em><b>Left Body Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARD__LEFT_BODY_SIDE = eINSTANCE.getCard_LeftBodySide();

		/**
		 * The meta object literal for the '<em><b>Right Body Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARD__RIGHT_BODY_SIDE = eINSTANCE.getCard_RightBodySide();

		/**
		 * The meta object literal for the '<em><b>Right Header Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARD__RIGHT_HEADER_SIDE = eINSTANCE.getCard_RightHeaderSide();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARD__MODEL_ELEMENT = eINSTANCE.getCard_ModelElement();

		/**
		 * The meta object literal for the '{@link Essence.DiagramInterchange.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.DiagramInterchange.impl.LinkImpl
		 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__NAME = eINSTANCE.getLink_Name();

		/**
		 * The meta object literal for the '<em><b>End2 bounds</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__END2_BOUNDS = eINSTANCE.getLink_End2_bounds();

		/**
		 * The meta object literal for the '<em><b>End1 bounds</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__END1_BOUNDS = eINSTANCE.getLink_End1_bounds();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__TARGET = eINSTANCE.getLink_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK__SOURCE = eINSTANCE.getLink_Source();

		/**
		 * The meta object literal for the '{@link Essence.DiagramInterchange.impl.DetailCardImpl <em>Detail Card</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.DiagramInterchange.impl.DetailCardImpl
		 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getDetailCard()
		 * @generated
		 */
		EClass DETAIL_CARD = eINSTANCE.getDetailCard();

		/**
		 * The meta object literal for the '<em><b>Header</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAIL_CARD__HEADER = eINSTANCE.getDetailCard_Header();

		/**
		 * The meta object literal for the '<em><b>Left Header Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAIL_CARD__LEFT_HEADER_SIDE = eINSTANCE.getDetailCard_LeftHeaderSide();

		/**
		 * The meta object literal for the '<em><b>Footer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAIL_CARD__FOOTER = eINSTANCE.getDetailCard_Footer();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAIL_CARD__BODY = eINSTANCE.getDetailCard_Body();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DETAIL_CARD__MODEL_ELEMENT = eINSTANCE.getDetailCard_ModelElement();

		/**
		 * The meta object literal for the '{@link Essence.DiagramInterchange.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.DiagramInterchange.impl.DiagramImpl
		 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getDiagram()
		 * @generated
		 */
		EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Diagram Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM__DIAGRAM_ELEMENT = eINSTANCE.getDiagram_DiagramElement();

		/**
		 * The meta object literal for the '{@link Essence.DiagramInterchange.impl.DiagramElementImpl <em>Diagram Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.DiagramInterchange.impl.DiagramElementImpl
		 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getDiagramElement()
		 * @generated
		 */
		EClass DIAGRAM_ELEMENT = eINSTANCE.getDiagramElement();

		/**
		 * The meta object literal for the '<em><b>Diagram Element2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGRAM_ELEMENT__DIAGRAM_ELEMENT2 = eINSTANCE.getDiagramElement_DiagramElement2();

		/**
		 * The meta object literal for the '{@link Essence.DiagramInterchange.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Essence.DiagramInterchange.impl.TextImpl
		 * @see Essence.DiagramInterchange.impl.DiagramInterchangePackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

	}

} //DiagramInterchangePackage
