package org.uengine.essencia.enactment;

import org.metaworks.annotation.Face;
import org.uengine.codi.mw3.model.CommentWorkItem;

/**
 * Created by uengine on 2017. 5. 7..
 */
@Face(ejsPath="") // don't use super class' ejs path. Use my own ejs path .
public class StateDiffCommentWorkItem extends CommentWorkItem{

    @Override
    public Object[] add() throws Exception {
        setType(this.getClass().getName());

        return super.add();
    }
}
