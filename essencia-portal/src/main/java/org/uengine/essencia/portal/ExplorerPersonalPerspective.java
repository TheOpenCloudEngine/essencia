package org.uengine.essencia.portal;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dwr.MetaworksRemoteService;
import org.uengine.codi.mw3.model.*;

/**
 * Created by jangjinyoung on 2016. 6. 12..
 */
public class ExplorerPersonalPerspective extends PersonalPerspective {

    @Override
    public Object[] loadAllICanSee() throws Exception {
        Object[] sessionAndListPanel = super.loadAllICanSee();

        ListPanel listPanel = (ListPanel) sessionAndListPanel[0];
        ListWindow listWindow = new ListWindow();
        listWindow.setPanel(listPanel);
        listPanel.getInstanceListPanel().getInstanceList().setMetaworksContext(new MetaworksContext());
        listPanel.getInstanceListPanel().getInstanceList().getMetaworksContext().setWhere("pinterest");


        return new Object[]{listWindow};
    }

    @ServiceMethod
    public void newProject() throws Exception {
        ListWindow listWindow = new ListWindow();
        listWindow.setPanel(SNS.createNewInstancePanel(session));

        MetaworksRemoteService.wrapReturn(listWindow);

    }


    @ServiceMethod
    public void projectExplorer() throws Exception {

        ListWindow listWindow = SNS.createInstanceListWindow(session);
        InstanceList instanceList = ((ListPanel)listWindow.getPanel()).getInstanceListPanel().getInstanceList();

        if(instanceList.getMetaworksContext()==null)
            instanceList.setMetaworksContext(new MetaworksContext());

        instanceList.getMetaworksContext().setWhere("pinterest");

        MetaworksRemoteService.wrapReturn(listWindow);
    }

    @ServiceMethod
    public void processExplorer() throws Exception {

        ListWindow listWindow = new ListWindow();
        listWindow.setPanel(new ProcessExplorer(session));

        MetaworksRemoteService.wrapReturn(listWindow);

    }


    @Override
    public Object[] calendar() throws Exception {
        Object[] sessionAndListPanel = super.calendar();

        ListPanel listPanel = (ListPanel) sessionAndListPanel[0];
        ListWindow listWindow = new ListWindow();
        listWindow.setPanel(listPanel);

        return new Object[]{listWindow};
    }

}
