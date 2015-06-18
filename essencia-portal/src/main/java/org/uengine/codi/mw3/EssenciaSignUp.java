package org.uengine.codi.mw3;

import org.uengine.kernel.GlobalContext;

/**
 * Created by hoo.lim on 6/18/2015.
 */
public class EssenciaSignUp extends SignUp{

    public EssenciaSignUp(){
        EssenciaLogin login = new EssenciaLogin();
        login.getMetaworksContext().setWhere("index");
        login.getMetaworksContext().setHow("signup");

        setForOCE("true".equals(GlobalContext.getPropertyString("forOCE", "false")));

        this.setLogin(login);
    }

    @Override
    public Object goLogin() {
        return new EssenciaLogin();
    }
}
