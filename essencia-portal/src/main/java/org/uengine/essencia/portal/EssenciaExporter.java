package org.uengine.essencia.portal;


import org.directwebremoting.io.FileTransfer;
import org.metaworks.annotation.AutowiredFromClient;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.Download;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.enactment.EssenceProcessDefinition;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.processadmin.ProcessAdminEditorPanel;
import org.uengine.processadmin.ProcessExporter;

/**
 * Created by jjy on 2016. 6. 20..
 */
public class EssenciaExporter extends ProcessExporter{
    public EssenciaExporter() throws Exception {
        super();
    }

    @ServiceMethod()
    public Download downloadAsOMGEssenceXmi(@AutowiredFromClient ProcessAdminEditorPanel processAdminEditorPanel){
        ProcessDefinition processDefinition = (ProcessDefinition) processAdminEditorPanel.getEditor().createEditedObject();

        if(processDefinition instanceof EssenceProcessDefinition){

            EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) processDefinition;

            essenceProcessDefinition.getPracticeDefinition().toXmi();

            return null;
            //return new Download(new FileTransfer(fileName, MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(fileName), bio));
        }

        throw new RuntimeException("This resource cannot be exported as OMG Essence XMI spec.");

    }
}
