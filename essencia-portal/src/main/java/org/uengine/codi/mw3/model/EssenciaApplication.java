package org.uengine.codi.mw3.model;

import org.metaworks.annotation.Face;
import org.uengine.codi.mw3.widget.IFrame;
import org.uengine.essencia.Essencia;
import org.uengine.essencia.Loader;

/**
 * Created by hoo.lim on 6/3/2015.
 */
@Face(ejsPath="dwr/metaworks/genericfaces/CleanObjectFace.ejs")
public class EssenciaApplication extends Application {
    Essencia essencia;

    public Essencia getEssencia() {
        return essencia;
    }

    public void setEssencia(Essencia essencia) {
        this.essencia = essencia;
    }
}