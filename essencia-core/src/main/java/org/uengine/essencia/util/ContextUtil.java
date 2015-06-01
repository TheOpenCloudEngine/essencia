package org.uengine.essencia.util;

import org.metaworks.ContextAware;
import org.metaworks.MetaworksContext;
import org.uengine.essencia.context.EssenciaContext;

import java.util.Objects;

public class ContextUtil {

    /**
     * @param to   is the ContextAware object to get MetaworksContext
     * @param from is the ContextAware object to serve MetaworksContext
     */
    public static void copyContext(ContextAware from, ContextAware to) {
        checkMetaworksContext(from);
        to.setMetaworksContext(from.getMetaworksContext());
    }


    /**
     * @param cls     is the class for wearing the MetaworksContext
     * @param context is the target MetaworksContext
     */
    public static void fillContext(ContextAware cls, MetaworksContext context) {
        cls.setMetaworksContext(context);
    }

    /**
     * @param cls
     * @param context
     * @return
     */
    public static void setWhen(ContextAware cls, String context) {
        checkMetaworksContext(cls);
        cls.getMetaworksContext().setWhen(context);
    }

    /**
     * @param cls
     * @param context
     * @return
     */
    public static void setHow(ContextAware cls, String context) {
        checkMetaworksContext(cls);
        cls.getMetaworksContext().setHow(context);
    }

    /**
     * @param cls
     * @param context
     * @return
     */
    public static void setWhere(ContextAware cls, String context) {
        checkMetaworksContext(cls);
        cls.getMetaworksContext().setWhere(context);
    }

    private static void checkMetaworksContext(ContextAware cls) {
        if (cls.getMetaworksContext()==null) {
            cls.setMetaworksContext(new EssenciaContext());
        }
    }

}
