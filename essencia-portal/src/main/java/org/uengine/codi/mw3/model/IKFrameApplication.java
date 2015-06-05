package org.uengine.codi.mw3.model;

import org.metaworks.annotation.Face;
import org.uengine.codi.mw3.widget.IFrame;

/**
 * Created by hoo.lim on 6/3/2015.
 */
@Face(ejsPath="dwr/metaworks/genericfaces/CleanObjectFace.ejs")
public class IKFrameApplication extends Application {
    IFrame content;
    public IFrame getContent() {
        return content;
    }
    public void setContent(IFrame content) {
        this.content = content;
    }

}