package org.uengine.essencia.modeling.editor;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.Face;
import org.uengine.essencia.util.ContextUtil;

public abstract class CompositeEditor extends Editor {

	private List<Editor> items;
	private int index;

	public CompositeEditor() {

	}

	@Face(ejsPath = "dwr/metaworks/genericfaces/TabFace.ejs", options = { "ableClose", "afterLoad" }, values = { "false", "true" })
	public List<Editor> getItems() {
		return this.items;
	}

	public void setItems(List<Editor> items) {
		this.items = items;
	}

	public void add(Editor editor) {
		if(this.items==null)
			setItems(new ArrayList<Editor>());

		this.items.add(editor);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void load() throws Exception {
		this.items = new ArrayList<Editor>();

		createEditors();

		for (Editor editor : this.items) {
			ContextUtil.fillContext(editor, getMetaworksContext());
			editor.setSaveable(false);
			editor.load();
		}
	}

	@Override
	public void  save() throws Exception {
		for (int i = 0; i < items.size(); i++)
			items.get(i).save();
	}

	@Override
	public boolean validate() throws Exception {
		boolean validate = false;

		for (Editor editor : items) {
			validate = editor.validate();
		}

		return validate;
	}

	public abstract void createEditors();
}
