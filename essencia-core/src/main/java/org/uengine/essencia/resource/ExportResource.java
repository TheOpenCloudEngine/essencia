package org.uengine.essencia.resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.directwebremoting.io.FileTransfer;
import org.metaworks.MetaworksContext;
import org.metaworks.widget.Download;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.adapter.EssenceXmiAPI;
import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.modeling.IModel;
import org.uengine.modeling.resource.IContainer;
import org.uengine.modeling.resource.IResource;
import org.uengine.modeling.resource.IResourceVisitor;

public class ExportResource implements IModelResource {

	private IModelResource modelResource;
	
	public ExportResource(IModelResource modelResource) {
		this.modelResource = modelResource;
	}
	
	public Download exportXmi() throws Exception {
		Download download = null;
		
		try {
			PracticeDefinition pd = (PracticeDefinition) loadModel();
			EssenceXmiAPI exportable = new EssenceXmiAPI(pd);
			exportable.toXmi();
			Path source = Paths.get(exportable.getExportPath());
//			String[] pathArr = exportable.getExportPath().split(File.separator);
			String[] pathArr = exportable.getExportPath().split("[\\\\|/]");
			String fileName = pathArr[pathArr.length-1];
			download = new Download(new FileTransfer(fileName, "text/xml", new FileInputStream(exportable.getExportPath())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return download;
	}

	@Override
	public void saveResource(IModel model) throws Exception {
		modelResource.saveResource(model);
	}

	@Override
	public IModel loadModel() throws Exception {
		return modelResource.loadModel();
	}

	@Override
	public Editor createEditor() throws Exception {
		return modelResource.createEditor();
	}

	@Override
	public String getPath() {
		return null;
	}

	@Override
	public String getDisplayName() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public void rename(String newName) {

	}

	@Override
	public IContainer getParent() {
		return null;
	}

	@Override
	public void setParent(IContainer iContainer) {

	}

	@Override
	public void accept(IResourceVisitor visitor) {

	}

	@Override
	public void accept(IResourceVisitor visitor, boolean admin) {

	}

	@Override
	public boolean isContainer() {
		return false;
	}

	@Override
	public void setPath(String path) {

	}

	@Override
	public void save(Object editingObject) throws Exception {

	}

	public MetaworksContext getMetaworksContext() {
		return null;
	}

	public void setMetaworksContext(MetaworksContext context) {

	}

	@Override
	public void delete() {

	}

	@Override
	public Download download(String fileName, String mimeType) throws Exception {
		return null;
	}

	@Override
	public void copy(String desPath) throws Exception {

	}

	@Override
	public void upload(InputStream is) {

	}

	@Override
	public void move(IContainer container) throws IOException {

	}

	@Override
	public void newOpen() throws Exception {

	}

	@Override
	public void reopen() throws Exception {

	}

	@Override
	public int compareTo(IResource o) {
		return 0;
	}
}