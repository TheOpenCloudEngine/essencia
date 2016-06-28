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

import javax.activation.MimetypesFileTypeMap;
import java.io.*;

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
        String fileName = "essencia(XMI).xmi";

        if(processDefinition instanceof EssenceProcessDefinition){
            EssenceProcessDefinition essenceProcessDefinition = (EssenceProcessDefinition) processDefinition;
            File xmiFile = essenceProcessDefinition.getPracticeDefinition().toXmi();

            FileInputStream fis;
            ByteArrayInputStream bio = null;
            ByteArrayOutputStream bao = new ByteArrayOutputStream();

            try {
                byte[] buf = new byte[1024];
                fis = new FileInputStream(xmiFile);

                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bao.write(buf, 0, readNum);
                }
                bio = new ByteArrayInputStream(bao.toByteArray());

            } catch (FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return new Download(new FileTransfer(fileName, MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(fileName), bio));

        } else {
            return null;
        }

    }
}
