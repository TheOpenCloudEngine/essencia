package org.uengine.essencia.portal;

import org.metaworks.MetaworksContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.*;

/**
 * Created by jangjinyoung on 2016. 6. 12..
 */
@Component
@Scope("prototype")
public class ExplorerPerspectivePanel extends PerspectivePanel {
    public ExplorerPerspectivePanel() throws Exception {
    }


    @Override
    public void load(Session session) throws Exception {
        if (session != null) {
            //개인별
            if ("1".equals(Perspective.USE_PERSONAL)) {
                setPersonalPerspective(new ExplorerPersonalPerspective());
                getPersonalPerspective().session = session;
            }

            //친구
            if ("1".equals(Perspective.USE_CONTACT)) {
                setContactPerspective(new ContactPerspective());
            }
            if ("1".equals(Perspective.USE_COMMINGTODO)) {
                setUpcommingTodoPerspective(new UpcommingTodoPerspective());
            }
        }//session
    }


}
