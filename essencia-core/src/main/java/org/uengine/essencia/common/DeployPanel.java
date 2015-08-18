package org.uengine.essencia.common;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.metaworks.MetaworksContext;
import org.metaworks.Remover;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.component.SelectBox;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.oce.garuda.multitenancy.TenantContext;
import org.uengine.codi.CodiProcessDefinitionFactory;
import org.uengine.codi.mw3.model.ProcessDefinition;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.resource.FolderResourceType;
import org.uengine.kernel.ProcessDefinitionFactory;
import org.uengine.modeling.resource.DefaultResource;
import org.uengine.modeling.resource.IResource;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.modeling.resource.Serializer;
import org.uengine.modeling.resource.resources.MethodResource;
import org.uengine.essencia.resource.RepositoryFolderResource;
import org.uengine.essencia.resource.Resource;
import org.uengine.kernel.GlobalContext;
import org.uengine.processmanager.*;
import org.uengine.util.UEngineUtil;

@Face(ejsPath = "dwr/metaworks/genericfaces/FormFace.ejs")
public class DeployPanel {

    @AutowiredFromClient
    public Session session;

    private SelectBox selectBox;
    private MetaworksContext metaworksContext;
    private MethodResource resource;

    @Hidden
    public MethodResource getResource() {
        return resource;
    }



    public void setResource(MethodResource resource) {
        this.resource = resource;
    }

    public DeployPanel() {
    }

    public DeployPanel(Resource resource) {
        setResource((MethodResource) resource);
        selectBox = new SelectBox();

        CommitHistory commitHistory = CommitHistory.load();
        List<CommitRecord> records = commitHistory.getRecordsByFilename(resource.getName());

        String name = "";
        Iterator<CommitRecord> iterator = records.iterator();
        SimpleDateFormat df = new SimpleDateFormat("yy.MM.dd. a hh:mm");
        while (iterator.hasNext()) {
            CommitRecord record = iterator.next();
            name = record.getResources();
            name = name.substring(0, name.indexOf(".")) + ".process";
            selectBox.add(String.valueOf(record.getRevision()) + " : " + record.getAuthor() + " "
                    + df.format(record.getDate()), name + "." + String.valueOf(record.getRevision()) + ".rev");
        }
    }

    @Face(displayName = "selectRevision")
    public SelectBox getSelectBox() {
        return selectBox;
    }

    public void setSelectBox(SelectBox selectBox) {
        this.selectBox = selectBox;
    }

    public MetaworksContext getMetaworksContext() {
        return metaworksContext;
    }

    public void setMetaworksContext(MetaworksContext metaworksContext) {
        this.metaworksContext = metaworksContext;
    }


    class DummyProcessTransactionContext extends ProcessTransactionContext{

        protected DummyProcessTransactionContext(ProcessManagerBean processManagerBean) {
            super(processManagerBean);
        }
    }
}
