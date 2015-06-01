/**
 */
package Essence.Foundation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Endeavor Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EndeavorAssociation#getOwnedEnd <em>Owned End</em>}</li>
 *   <li>{@link EndeavorAssociation#getMemberEnd <em>Member End</em>}</li>
 * </ul>
 * </p>
 *
 * @see Essence.Foundation.FoundationPackage#getEndeavorAssociation()
 * @model
 * @generated
 */
public interface EndeavorAssociation extends EObject {
	/**
	 * Returns the value of the '<em><b>Owned End</b></em>' containment reference list.
	 * The list contents are of type {@link Essence.Foundation.EndeavorProperty}.
	 * It is bidirectional and its opposite is '{@link Essence.Foundation.EndeavorProperty#getOwningAssociation <em>Owning Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned End</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned End</em>' containment reference list.
	 * @see Essence.Foundation.FoundationPackage#getEndeavorAssociation_OwnedEnd()
	 * @see Essence.Foundation.EndeavorProperty#getOwningAssociation
	 * @model opposite="owningAssociation" containment="true" ordered="false"
	 * @generated
	 */
	EList<EndeavorProperty> getOwnedEnd();

	/**
	 * Returns the value of the '<em><b>Member End</b></em>' reference list.
	 * The list contents are of type {@link Essence.Foundation.EndeavorProperty}.
	 * It is bidirectional and its opposite is '{@link Essence.Foundation.EndeavorProperty#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member End</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member End</em>' reference list.
	 * @see Essence.Foundation.FoundationPackage#getEndeavorAssociation_MemberEnd()
	 * @see Essence.Foundation.EndeavorProperty#getAssociation
	 * @model opposite="association" lower="2" ordered="false"
	 * @generated
	 */
	EList<EndeavorProperty> getMemberEnd();

} // EndeavorAssociation
