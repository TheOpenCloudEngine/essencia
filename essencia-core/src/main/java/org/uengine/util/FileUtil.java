package org.uengine.util;

import java.io.*;

import org.metaworks.common.MetaworksUtil;

public class FileUtil {

	public final static String ENCODING = "UTF-8";
	
	public static String readFile(InputStream is){
		String content = "";
		
		ByteArrayOutputStream bao = null;
		try {
			bao = new ByteArrayOutputStream();
			
			MetaworksUtil.copyStream(is, bao);
			
			content = bao.toString(ENCODING);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(is != null){
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
				
			if(bao != null){
				try {
					bao.close();
					bao = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return content;
	}
	
	public static String readFile(String path) throws FileNotFoundException {
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		
		return FileUtil.readFile(is);
	}
	
	public static boolean writeFile(String path, String content){
		boolean successed = false;
		OutputStream fos = null;
		Writer osw = null;
		try {
			File file = new File(path);
			if(!file.exists()){
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos, "UTF-8");
			
			String newContent = content!=null?content:"";
			osw.write(newContent);
	        
	       
			successed = true;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			 try {
				if(osw!=null)
					osw.close();
				if(fos!=null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return successed;
	}
	
	public static boolean createFolder(String path) throws Exception{
		File file = new File(path);
		
		if(file.exists())
			throw new Exception("duplicated folder name");
		
		return file.mkdir();
	}
	
	public static boolean createFolders(String path) {
		File file = new File(path);
		
		if(file.exists()){
			System.out.println("Folder is exist!");	
		}
		
		return file.mkdirs();
	}
	
	public static boolean createFile(String path) throws Exception{
		File file = new File(path);
		
		if(file.exists())
			throw new Exception("duplicated file name.");
		
		return file.createNewFile();
	}
	
	public static String addLastFileSeparatorSuffix(String path){
		if("".equals(path))
			return path;
		
		if(!path.endsWith(File.separator))
			path = path.concat(File.separator);
		
		return path;
	}
	
	public static String extractName(String fileName){
		
		if(fileName.startsWith(File.separator))
			fileName = fileName.substring(1);
		
		int pos = fileName.lastIndexOf(File.separator);
		if(pos > 0)
			fileName = fileName.substring(pos+1);
		
		pos = fileName.lastIndexOf(".");
		if(pos == -1)
			return fileName;
		
		return fileName.substring(0, pos);
	}
	
	public static String extractExtensions(String fileName){
		int pos = fileName.lastIndexOf(".");
		
		if(pos == -1)
			return "";
		
		return fileName.substring(fileName.lastIndexOf("."));
	}
	
	public static String extractParnetId(String fileName){
		int pos = fileName.lastIndexOf(File.separator);
		
		if(pos == -1)
			return "";

		return fileName.substring(0, pos);
	}

    /**
     * change the dest's opengraph id from OG to file path
     * @param source
     * @param dest
     * @throws IOException
     */
    public static void copyFile(File source, File dest) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(source));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dest));
        String result = "";
        try {
            while ((result = br.readLine()) != null) {
                String a = dest.getName().replaceAll("\\.", "_");
                result = result.replaceAll("OG_",  a);
                bw.write(result + "\r\n");
                bw.flush();
            }
        } finally {
            br.close();
            bw.close();
        }
    }
}
