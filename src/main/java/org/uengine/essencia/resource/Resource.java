package org.uengine.essencia.resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;

import javax.persistence.Id;

import org.apache.commons.lang.StringUtils;
import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.Refresh;
import org.metaworks.Remover;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToEvent;
import org.metaworks.ToOpener;
import org.metaworks.annotation.Available;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Name;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.Clipboard;
import org.metaworks.widget.ModalWindow;
import org.uengine.ConfirmPanel;
import org.uengine.cloud.saasfier.TenantUtil;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.designer.ResourceNavigator;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.kernel.GlobalContext;
import org.uengine.kernel.UEngineException;
import org.uengine.modeling.IContainer;
import org.uengine.modeling.IResource;
import org.uengine.modeling.IResourceVisitor;
import org.uengine.util.FileUtil;

public class Resource implements IResource, Comparable<IResource> {

	private String path;
	private IContainer parent;
	protected MetaworksContext metaworksContext;

	public Resource() {
		setTreeContext();
	}

	public Resource(String path) {
		this();
		setPath(path);
	}

	/**
	 * path is the most important field in the class. path is relative path from
	 * codebase for example,
	 * <p>
	 * folder : practices
	 * </p>
	 * <p>
	 * file : practices\\scurm.practice
	 * </p>
	 * name, displayName, type are based on the path thus if you want to modify
	 * resource setPath() is the best way
	 *
	 * @return relative path from codebase
	 */
	@Id
	@Hidden
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * name is provided from path by parsing * for example,
	 * <p>
	 * folder : practices
	 * </p>
	 * <p>
	 * file : scurm.practice
	 * </p>
	 *
	 * @return file name includ filename extension except folder
	 */
	public String getName() {
		if (path.indexOf(File.separator) == StringUtils.INDEX_NOT_FOUND) {
			return path;
		}
		return StringUtils.substringAfterLast(path, File.separator);
	}

	public void setName(String name) {
		StringBuilder newPath = new StringBuilder();
		if (this.path == null || this.path.contains(File.separator)) {
			newPath.append(StringUtils.substringBeforeLast(this.path, File.separator)).append(File.separator).append(name);
		} else {
			newPath.append(File.separator).append(name);
		}
		this.path = newPath.toString();
	}

	/**
	 * displayname is provided from path by parsing the file's name is provided
	 * except filename extension * for example,
	 * <p>
	 * folder : practices
	 * </p>
	 * <p>
	 * file : scurm
	 * </p>
	 *
	 * @return only file name will be returned
	 */
	@Name
	@Face(displayName = "name")
	public String getDisplayName() {
		int index = this.path.lastIndexOf(File.separatorChar) + 1;
		int pos = this.path.indexOf(".");
		if (pos == -1) {
			return this.path.substring(index);
		} else {
			return this.path.substring(index, pos);
		}
	}

	public void setDisplayName(String displayName) {
		if(this.path != null){
			StringBuffer sb = new StringBuffer();
			int index = this.path.lastIndexOf(File.separatorChar) + 1;
			int pos = this.path.indexOf(".");
			sb.append(this.path.substring(0, index) + displayName);
			if (pos != -1) {
				sb.append(this.path.substring(pos));
			}
			setPath(sb.toString());
		}
	}

	/**
	 * type is filename extension if the file is folder String "folder" will be
	 * returned * for example,
	 * <p>
	 * folder : folder
	 * </p>
	 * <p>
	 * file : practice
	 * </p>
	 *
	 * @return filename extension
	 */
	public String getType() {
		if (getName().indexOf(".") == StringUtils.INDEX_NOT_FOUND) {
			return TYPE_FOLDER;
		}
		return StringUtils.substringAfter(getName(), ".");
	}

	public void setType(String type) {
		StringBuilder newPath = new StringBuilder();
		if (!TYPE_FOLDER.equals(type)) {
			if(type.startsWith(".")){
				newPath.append(StringUtils.substringBefore(this.path, ".")).append(type);
			} else { 
				newPath.append(StringUtils.substringBefore(this.path, ".")).append(".").append(type);
			}
			this.path = newPath.toString();
		}
	}

	@Hidden
	public IContainer getParent() {
		if (this.parent == null && File.separator.equals(this.getPath())) {
			return null;
		}
		return parent;
	}

	@Override
	public void setParent(IContainer parent) {
		this.parent = parent;
	}

	@Override
	public MetaworksContext getMetaworksContext() {
		return metaworksContext;
	}

	@Override
	public void setMetaworksContext(MetaworksContext metaworksContext) {
		this.metaworksContext = metaworksContext;
	}

	public String read() {
		try {
			return FileUtil.readFile(this.getAbsolutePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "";
	}

	public void write(String content) {
		FileUtil.writeFile(this.getAbsolutePath(), content);
	}

	@Order(11)
	@Face(displayName = "delete")
	@ServiceMethod(callByContent = true, inContextMenu = true, target = ServiceMethodContext.TARGET_POPUP)
	public Object confirmDelete() throws Exception {
		ContextUtil.setHow(this, HOW_DELETE);
		ContextUtil.setWhen(this, MetaworksContext.WHEN_VIEW);
		ConfirmPanel panel = new ConfirmPanel(this);

		panel.delete();
		return new ModalWindow(panel, 500, 500, "Delete");
	}

	public Object delete() {
		if (deleteAll(this.getAbsolutePath())) {
			return new Remover(this);
		}
		return null;
	}

	public boolean deleteAll(String path) {
		File file = new File(path);
		File[] fileList = file.listFiles();
		if (fileList != null) {
			for (File delFile : fileList) {
				if (delFile.isDirectory()) {
					deleteAll(delFile.getAbsolutePath());
				} else {
					delFile.delete();
				}
			}
		}
		return file.delete();
	}
	
	@Available(condition="metaworksContext.how == 'tree' && metaworksContext.where == 'explorer'")
	@ServiceMethod(callByContent=true, eventBinding="mousedown", target=ServiceMethodContext.TARGET_STICK)
	public Object select(){
		return new Refresh(new Clipboard(ResourceNavigator.NAVIGATOR_ID, this));
	}

	@Override
	public boolean isContainer() {
		return false;
	}

	@Face(displayName = "save")
	@Available(when = MetaworksContext.WHEN_EDIT)
	@ServiceMethod(callByContent = true, target = ServiceMethodContext.TARGET_POPUP)
	public Object[] save() throws Exception {
		ContextUtil.setHow(this, HOW_TREE);
		ContextUtil.setWhen(this, MetaworksContext.WHEN_VIEW);

		return new Object[] { new ToEvent(ServiceMethodContext.TARGET_SELF, EventContext.EVENT_CLOSE), new ToOpener(this) };
	}

	public int compareTo(IResource o) {
		return Comparators.NAME.compare(this, o);
	}

	public static class Comparators {
		public static Comparator<IResource> NAME = new Comparator<IResource>() {
			@Override
			public int compare(IResource o1, IResource o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
	}

	public static void checkDuplicatedFile(String id) throws UEngineException {
		File file = new File(getCodebase() + id);
		if (file.exists()) {
			throw new UEngineException("There are duplicated names in the path :" + file.getAbsolutePath());
		}
	}
	
	@Hidden
	public static String getCodebase() {
        String os = System.getProperty("os.name");
        if(os.startsWith("Windows")){
            return FileUtil.addLastFileSeparatorSuffix(GlobalContext.getPropertyString("essencia.windows.codebase", "codebase"))  + TenantUtil.getTenantPath();
        }else{
            return FileUtil.addLastFileSeparatorSuffix(GlobalContext.getPropertyString("essencia.linux.codebase", "codebase"))  + TenantUtil.getTenantPath();
        }
	}

	protected String getAbsolutePath() {
		return getCodebase() + this.getPath();
	}

	@Override
	public void accept(IResourceVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void accept(IResourceVisitor visitor, boolean admin) {
		visitor.visit(this);
	}

	public void setTreeContext() {
		ContextUtil.setWhen(this, EssenciaContext.WHEN_VIEW);
		ContextUtil.setHow(this, HOW_TREE);
		ContextUtil.setWhere(this, WHERE_NAVIGATOR);
	}

	public static IResource newInstance(String id) {
		IResource resource = newInstance(makeFile(id));

		return resource;
	}

	public static IResource newPracticeFolderResource(String id) {
		return newPracticeFolderResource(makeFile(id));
	}

	public static IResource newPracticeFolderResource(File file) {
		return newInstance(FolderResourceType.PRACTICE_FOLDER.getClazz(), file);
	}

	public static IResource newMethodFolderResource(String id) {
		return newMethodFolderResource(makeFile(id));
	}

	public static IResource newMethodFolderResource(File file) {
		return newInstance(FolderResourceType.METHOD_FOLDER.getClazz(), file);
	}

	public static IResource newInstance(File file) {
		IResource resource = null;
		for (ResourceType r : ResourceType.values()) {
			if (!file.getAbsolutePath().contains(".")) {
				resource = newInstance(ResourceType.FOLDER_RESOURCE.getClazz(), file);
			} else if (file.getAbsolutePath().endsWith(r.getType())) {
				resource = newInstance(r.getClazz(), file);
				break;
			}
		}
		return resource;
	}
	
	public static IResource newInstance(Class<?> clazz, File file) {
		IResource resource = null;
		Constructor<?> constructor = null;
		try {
			constructor = clazz.getConstructor(String.class);
			resource = (IResource) constructor.newInstance(file.getAbsolutePath().replace(getCodebase(), ""));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return resource;
	}
	
	public static File makeFile(String resourceId) {
		return new File(getCodebase() + resourceId);
	}

	/**
	 * change the file or folder's name for example, if "method" is recieved as
	 * a newName parameter
	 * <p>
	 * folder : practices -> method
	 * </p>
	 * if "UX" is recieved as a newName parameter
	 * <p>
	 * file : scurm -> UX
	 * </p>
	 *
	 * @param newName
	 * @return only file name will be returned
	 */
	@Override
	public void rename(String newName) {
		String oldAbsolutePath = this.getAbsolutePath();
		
		setDisplayName(newName);
		
		File fromFile = new File(oldAbsolutePath);
		File toFile = new File(this.getAbsolutePath());

		fromFile.renameTo(toFile);
	}
}
