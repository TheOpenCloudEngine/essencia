package org.uengine.essencia.modeling.editor;

import java.util.ArrayList;
import java.util.List;

import org.metaworks.annotation.Face;
import org.metaworks.widget.Clipboard;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;

public class EditorTabs {

	private List<Editor> items;
	private Clipboard clipboard;

	public EditorTabs() {
		this.items = new ArrayList<Editor>();
		clipboard = new Clipboard(EssenciaCanvas.CANVAS_DROP);
	}

	@Face(ejsPath = "dwr/metaworks/genericfaces/TabFace.ejs", options = "ableClose", values = "true")
	public List<Editor> getItems() {
		return items;
	}

	public void setItems(List<Editor> items) {
		this.items = items;
	}

	public Clipboard getClipboard() {
		return clipboard;
	}

	public void setClipboard(Clipboard clipboard) {
		this.clipboard = clipboard;
	}

}
