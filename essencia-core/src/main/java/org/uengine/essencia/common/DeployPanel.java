package org.uengine.essencia.common;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.CodiProcessDefinitionFactory;
import org.uengine.codi.mw3.model.Session;
import org.uengine.essencia.repository.ObjectRepository;
import org.uengine.essencia.resource.MethodResource;
import org.uengine.essencia.resource.RepositoryFolderResource;
import org.uengine.essencia.resource.Resource;
import org.uengine.kernel.GlobalContext;
import org.uengine.kernel.ProcessDefinition;
import org.uengine.processmanager.*;

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
        List<CommitRecord> records = CommitUtils.getRecordsByFilename(resource.getName());
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


    @ServiceMethod(callByContent = true)
    public void deploy() {
        String exsistingFileName = RepositoryFolderResource.getMethodsRepository() + selectBox.getSelected();
        String tenantId = TenantContext.getThreadLocalInstance().getTenantId();
        tenantId = (tenantId == null ? "default" : tenantId);
        String path = GlobalContext.getPropertyString("codebase") + File.separator + "codi" + File.separator + tenantId + File.separator + getResource().getProcessResource().getName();


        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(exsistingFileName);
            out = new FileOutputStream(path);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (Exception e) {

        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            MetaworksRemoteService.wrapReturn(new Remover(new ModalWindow()));
        }

        String processId = getResource().getName();
        if(processId.endsWith(".method")){
            processId = processId.substring(0, processId.indexOf(".")) + ".process";
        }

        CodiProcessDefinitionFactory.getInstance(new DummyProcessTransactionContext(null)).removeFromCache(getResource().getName());

		/*System.out.println();

		HttpURLConnection conn = null;
	    DataOutputStream dos = null;
	    DataInputStream inStream = null;

	    String exsistingFileName = RepositoryFolderResource.getMethodsRepository() + selectBox.getSelected();

	    String lineEnd = "\r\n";
	    String twoHyphens = "--";
	    String boundary =  "*****";

	    int bytesRead, bytesAvailable, bufferSize;
	    byte[] buffer;
	    int maxBufferSize = 1*1024*1024;
	    String urlString = GlobalContext.getPropertyString("codi.deployServlet", "http://localhost:8080/uengine-web/DeployServlet");

	    try{
	      FileInputStream fileInputStream = new FileInputStream( new File(exsistingFileName) );
	      URL url = new URL(urlString);
	      conn = (HttpURLConnection) url.openConnection();
	      conn.setDoInput(true);
	      conn.setDoOutput(true);
	      conn.setRequestMethod("POST");
	      conn.setUseCaches(false);

	      conn.setRequestProperty("Connection", "Keep-Alive");
	      conn.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);

	      dos = new DataOutputStream( conn.getOutputStream() );

	      dos.writeBytes(twoHyphens + boundary + lineEnd);
	      dos.writeBytes("Content-Disposition: form-data; name=\"pic\";" + " filename=\"" + exsistingFileName +"\"" + lineEnd);
	      dos.writeBytes(lineEnd);

	      bytesAvailable = fileInputStream.available();
	      bufferSize = Math.min(bytesAvailable, maxBufferSize);
	      buffer = new byte[bufferSize];

	      bytesRead = fileInputStream.read(buffer, 0, bufferSize);

	      while (bytesRead > 0){
	        dos.write(buffer, 0, bufferSize);
	        bytesAvailable = fileInputStream.available();
	        bufferSize = Math.min(bytesAvailable, maxBufferSize);
	        bytesRead = fileInputStream.read(buffer, 0, bufferSize);
	      }

	      dos.writeBytes(lineEnd);
	      dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

	      fileInputStream.close();
	      dos.flush();
	      dos.close();


	    }catch (MalformedURLException ex){
	      System.out.println("Error:"+ex);
	    }catch (IOException ioe){
	      System.out.println("Error:"+ioe);
	    }

	    try{
	      inStream = new DataInputStream ( conn.getInputStream() );
	      String str;
	      while (( str = inStream.readLine()) != null){
	        System.out.println(str);
	      }
	      inStream.close();
	    }catch (IOException ioex){
	      System.out.println("Error: "+ioex);
	    }*/
    }

    class DummyProcessTransactionContext extends ProcessTransactionContext{

        protected DummyProcessTransactionContext(ProcessManagerBean processManagerBean) {
            super(processManagerBean);
        }
    }
}
