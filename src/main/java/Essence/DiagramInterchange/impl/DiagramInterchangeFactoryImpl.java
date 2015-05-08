/**
 */
package Essence.DiagramInterchange.impl;

import Essence.DiagramInterchange.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramInterchangeFactoryImpl extends EFactoryImpl implements DiagramInterchangeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramInterchangeFactory init() {
		try {
			DiagramInterchangeFactory theDiagramInterchangeFactory = (DiagramInterchangeFactory)EPackage.Registry.INSTANCE.getEFactory(DiagramInterchangePackage.eNS_URI);
			if (theDiagramInterchangeFactory != null) {
				return theDiagramInterchangeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiagramInterchangeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramInterchangeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DiagramInterchangePackage.NODE: return createNode();
			case DiagramInterchangePackage.LABEL: return createLabel();
			case DiagramInterchangePackage.CARD: return createCard();
			case DiagramInterchangePackage.LINK: return createLink();
			case DiagramInterchangePackage.DETAIL_CARD: return createDetailCard();
			case DiagramInterchangePackage.DIAGRAM: return createDiagram();
			case DiagramInterchangePackage.DIAGRAM_ELEMENT: return createDiagramElement();
			case DiagramInterchangePackage.TEXT: return createText();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label createLabel() {
		LabelImpl label = new LabelImpl();
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Card createCard() {
		CardImpl card = new CardImpl();
		return card;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DetailCard createDetailCard() {
		DetailCardImpl detailCard = new DetailCardImpl();
		return detailCard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram createDiagram() {
		DiagramImpl diagram = new DiagramImpl();
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramElement createDiagramElement() {
		DiagramElementImpl diagramElement = new DiagramElementImpl();
		return diagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text createText() {
		TextImpl text = new TextImpl();
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramInterchangePackage getDiagramInterchangePackage() {
		return (DiagramInterchangePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiagramInterchangePackage getPackage() {
		return DiagramInterchangePackage.eINSTANCE;
	}

} //DiagramInterchangeFactoryImpl
