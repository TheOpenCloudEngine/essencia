package org.uengine.essencia.component;

import org.metaworks.component.SelectBox;

public class EssenciaConcernSelectBox extends SelectBox {
    
    final String CONCERN_CUSTOMER = "Customer";
    final String CONCERN_SOLUTION = "Solution";
    final String CONCERN_ENDEAVOUR = "Endeavour";

    public EssenciaConcernSelectBox() {
	add(0, CONCERN_CUSTOMER, CONCERN_CUSTOMER);
	add(1, CONCERN_SOLUTION, CONCERN_SOLUTION);
	add(2, CONCERN_ENDEAVOUR, CONCERN_ENDEAVOUR);
    }

}
