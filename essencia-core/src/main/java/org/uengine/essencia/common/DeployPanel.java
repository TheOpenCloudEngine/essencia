package org.uengine.essencia.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.component.SelectBox;
import org.uengine.essencia.resource.RepositoryFolderResource;
import org.uengine.kernel.GlobalContext;

@Face(ejsPath="dwr/metaworks/genericfaces/FormFace.ejs")
public class DeployPanel {

	SelectBox selectBox;
	MetaworksContext metaworksContext;
	
	public DeployPanel() {
	}
	
	public DeployPanel(String filename) {
		selectBox = new SelectBox();
		List<CommitRecord> records = CommitUtils.getRecordsByFilename(filename);
		String name = "";
		Iterator<CommitRecord> iterator = records.iterator();
		SimpleDateFormat df = new SimpleDateFormat("yy.MM.dd. a hh:mm");
		while(iterator.hasNext()){
            CommitRecord record = iterator.next();
			name = record.getResources();
			name = name.substring(0, name.indexOf(".")) + ".process";
			selectBox.add(String.valueOf(record.getRevision()) + " : " + record.getAuthor() + " "
					+ df.format(record.getDate()), name + "." + String.valueOf(record.getRevision()) + ".rev");
		}
	}
	
	@Face(displayName="selectRevision")
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
	
	@ServiceMethod(callByContent=true)
	public void deploy(){
		System.out.println();
		
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
	    }
	}
}
