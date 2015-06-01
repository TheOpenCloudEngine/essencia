package org.metaworks.website;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.directwebremoting.io.FileTransfer;
import org.metaworks.ContextAware;
import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.Refresh;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Id;
import org.metaworks.annotation.NonEditable;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.Download;

public abstract class AbstractMetaworksFile implements ContextAware, Serializable {
	
	public AbstractMetaworksFile() {
		setMetaworksContext(new MetaworksContext());
	}
	
	transient MetaworksContext metaworksContext;
		public MetaworksContext getMetaworksContext() {
			return metaworksContext;
		}
		public void setMetaworksContext(MetaworksContext metaworksContext) {
			this.metaworksContext = metaworksContext;
		}

	transient FileTransfer fileTransfer;
		@Face(ejsPath="dwr/metaworks/org/directwebremoting/io/FileTransfer.ejs")
		public FileTransfer getFileTransfer() {
			return fileTransfer;
		}	
		public void setFileTransfer(FileTransfer fileTransfer) {
			this.fileTransfer = fileTransfer;
		}
		
	BufferedImage image;			
		public BufferedImage getImage() {
			return image;
		}	
		public void setImage(BufferedImage image) {
			this.image = image;
		}
	
	String filename;
		@NonEditable
		@Hidden	
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		
	Long filesize;
		public Long getFilesize() {
			return filesize;
		}
		public void setFilesize(Long filesize) {
			this.filesize = filesize;
		}

	String uploadedPath;
		@Id
		@NonEditable
		public String getUploadedPath() {
			return uploadedPath;
		}
		public void setUploadedPath(String uploadedPath) {
			this.uploadedPath = uploadedPath;
		}		
		
	String deletedPath;
		@NonEditable
		@Hidden
		public String getDeletedPath() {
			return deletedPath;
		}
		public void setDeletedPath(String deletedPath) {
			this.deletedPath = deletedPath;
		}
		
	String mimeType;
		@NonEditable
		@Hidden
		public String getMimeType() {
			return mimeType;
		}
		public void setMimeType(String mimeType) {
			this.mimeType = mimeType;
		}
		
	String directory;
		@Hidden	
		public String getDirectory() {
			return directory;
		}
		public void setDirectory(String directory) {
			this.directory = directory;
		}
		
	boolean auto;	
		public boolean isAuto() {
			return auto;
		}
		public void setAuto(boolean auto) {
			this.auto = auto;
		}
		
	boolean useClassLoader;
		public boolean isUseClassLoader() {
			return useClassLoader;
		}
		public void setUseClassLoader(boolean useClassLoader) {
			this.useClassLoader = useClassLoader;
		}
		
	@ServiceMethod(callByContent=true, except="fileTransfer", target="append")
	public Download download() throws FileNotFoundException, IOException, Exception{
		return new Download(new FileTransfer(new String(this.getFilename().getBytes("UTF-8"),"ISO8859_1"), getMimeType(), new FileInputStream(overrideUploadPathPrefix() + "/" + this.getUploadedPath())));
	}

	@ServiceMethod(callByContent=true, except="fileTransfer", target=ServiceMethodContext.TARGET_NONE) //it doesn't cause refresh so that the recursive call of constructor of MetaworksFile javascript object never happened
	public BufferedImage downloadImage() throws FileNotFoundException, IOException, Exception{
		
		if(useClassLoader)
			image = javax.imageio.ImageIO.read(Thread.currentThread().getContextClassLoader().getResourceAsStream(this.getUploadedPath()));
		else{
			File downloadImage = new File(overrideUploadPathPrefix() + "/" + uploadedPath);
			
			if(downloadImage.exists())
				image = javax.imageio.ImageIO.read(downloadImage);
			else
				System.out.println("not exist file : " + downloadImage.getAbsolutePath());
		}
		
		return image;
	}

	/**
	 * You should call this method in the container as well. Normally you may call this method just before the database insertion to 
	 * save the file and set the properties as well when you have set the @ORMapping annotation to map the file location and mimetype
	 * so that your DAO saves it. 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	@ServiceMethod(callByContent=true, target=ServiceMethodContext.TARGET_APPEND)
	public Object[] upload() throws FileNotFoundException, IOException, Exception{
		
		if(fileTransfer==null || fileTransfer.getFilename()==null || fileTransfer.getFilename().length() <= 0) 
			throw new Exception("No file attached");
		
		String prefix = overrideUploadPathPrefix();
		if(!prefix.endsWith("/"))
			prefix += "/";
		
		String uploadFileName = renameUploadFileWithMimeType(fileTransfer.getFilename(), fileTransfer.getMimeType());	
		//String uploadFileName = renameUploadFile(fileTransfer.getFilename());		
		String uploadPath = prefix + uploadFileName;
		
		new File(uploadPath).getParentFile().mkdirs();
		
		InputStream is = null;
		FileOutputStream os = null;
		
		try {						
			is = this.getFileTransfer().getInputStream();
			os = new FileOutputStream(uploadPath);
			
			AbstractMetaworksFile.copyStream(is, os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(os != null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		};
		
		setUploadedPath(uploadFileName); //only when the file has been successfully uploaded, this value is set, that means your can download later
		setMimeType(fileTransfer.getMimeType());
		setFilesize(fileTransfer.getSize());
		
		fileTransfer = null; //ensure to clear the data
		
		return new Object[]{new Refresh(this, true, true), new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CHANGE)};
	}
	
	@ServiceMethod(callByContent=true, except="fileTransfer", target=ServiceMethodContext.TARGET_SELF)
	public void remove() throws FileNotFoundException, IOException, Exception{
		if(getDeletedPath().length() == 0) 
			throw new Exception("No file attached");
		
		String prefix = overrideUploadPathPrefix();
		if(!prefix.endsWith("/"))
			prefix += "/";
		
		File f = new File(prefix + getDeletedPath());
		// 확장자 없으면 폴더. 다만 폴더안에는 아무것도 없어야 한다.
		if (f.exists()) {
			boolean de = f.delete();
			if (de) {	
				setUploadedPath(null);
				
				if(!isAuto())
					setDeletedPath(null);
				System.out.println("Successed Delete!!");
			} else {
				System.out.println("Failed Delete!!");
			}
		} else {
			setUploadedPath(null);

			if(!isAuto())
				setDeletedPath(null);
			
			System.out.println("File Not Found!!");
		}
	}

	// set parted Stored file path by MimeType
	abstract public String overrideUploadPathPrefix();
	
	public String renameUploadFile(String filename) {
		String fileBody;
		String fileExt;
		
		fileBody = Long.toString(System.currentTimeMillis());
		
		if(filename.lastIndexOf(".") != -1){
			fileExt = filename.substring(filename.lastIndexOf("."));
			
			fileBody += fileExt;
		}
		
		return fileBody;
	}
	
	public String renameUploadFileWithMimeType(String filename, String mimeType ) {
		String fileBody;
		String fileExt = null;
		
		fileBody = Long.toString(System.currentTimeMillis());
		
		//한글파일일 경우 확장자 구분하는 .까지 깨지는 경우가 발생한다.
		if(mimeType.indexOf("pdf") > -1){
			fileExt = ".pdf";
		} else if(mimeType.indexOf("plain") > -1){
			fileExt = ".rtf";
		} else if(mimeType.indexOf("rtf") > -1){
			fileExt = ".rtf";
		} else if(mimeType.indexOf("ms") > -1){
			if(mimeType.indexOf("excel") > -1){
				fileExt = ".xls";
			} else if(mimeType.indexOf("powerpoint") > -1){
				fileExt = ".ppt";
			} else if(mimeType.indexOf("word") > -1){
				fileExt = ".doc";
			}else{
				if(filename.lastIndexOf(".") != -1){
					fileExt = filename.substring(filename.lastIndexOf("."));
				}
			}
		} else if(mimeType.indexOf("officedocument") > -1){
			if(mimeType.indexOf("sheet") > -1){
				fileExt = ".xlsx";
			} else if(mimeType.indexOf("presentation") > -1){
				fileExt = ".pptx";
			} else if(mimeType.indexOf("word") > -1){
				fileExt = ".docx";
			}else{
				if(filename.lastIndexOf(".") != -1){
					fileExt = filename.substring(filename.lastIndexOf("."));
				}
			}
		} else if(mimeType.indexOf("haansoft") > -1){
			if(mimeType.indexOf("sheet") > -1){
				fileExt = ".xlsx";
			} else if(mimeType.indexOf("pptx") > -1){
				fileExt = ".pptx";
			} else if(mimeType.indexOf("word") > -1){
				fileExt = ".docx";
			} else if(mimeType.indexOf("hwp") > -1){
				fileExt = ".hwp";
			}else{
				if(filename.lastIndexOf(".") != -1){
					fileExt = filename.substring(filename.lastIndexOf("."));
				}
			}
		} else {
			if(filename.lastIndexOf(".") != -1){
				fileExt = filename.substring(filename.lastIndexOf("."));
			}
		}
		
		fileBody += fileExt;
		
		return fileBody;
	}
	
	private String getDirectoryName() {
		String path;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		path = df.format(new Date()); 
		
		return path;
	}
	
	public boolean ableUpload(){
		if(this.getFileTransfer() == null || this.getFileTransfer().getFilename() == null || this.getFileTransfer().getFilename().length() == 0)
			return false;
		
		return true;
	}
	
	static public void copyStream(InputStream sourceInputStream, OutputStream targetOutputStream) throws Exception{
		
		try{
			int length = 1024;
			byte[] bytes = new byte[length]; 
			int c; 
			int total_bytes=0;
				
			while ((c = sourceInputStream.read(bytes)) != -1) { 
					total_bytes +=c; 
					targetOutputStream.write(bytes,0,c); 
			} 
			
		}catch(Exception e){
			throw e;
		}
		
	}

}