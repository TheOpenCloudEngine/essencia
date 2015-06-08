package org.uengine.essencia.enactment;

import org.uengine.kernel.ValidationContext;

public class NotCompletableException extends IllegalStateException {
    public NotCompletableException(String s) {
        super(s);
    }

    public NotCompletableException(ValidationContext validationContext){
        super(validationContext.toString());
    }
}
