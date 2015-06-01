package org.uengine.essencia.common;

/**
 * Created by manage on 3/5/2015.
 */
import java.io.File;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.metaworks.ContextAware;
import org.metaworks.EventContext;
import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.ToAppend;
import org.metaworks.ToEvent;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.NonEditable;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.context.EssenciaContext;
import org.uengine.essencia.modeling.editor.Editor;
import org.uengine.essencia.modeling.editor.EditorTabs;
import org.uengine.essencia.modeling.editor.EssenciaEditor;
import org.uengine.essencia.modeling.editor.MethodComposerEditor;
import org.uengine.essencia.modeling.editor.PracticeDefinerEditor;
import org.uengine.essencia.resource.Resource;
import org.uengine.essencia.resource.ResourceType;
import org.uengine.essencia.util.ContextUtil;
import org.uengine.modeling.IResource;

@XmlRootElement(name = "record")
@Face(ejsPath = "dwr/metaworks/genericfaces/Record.ejs")
public class CommitRecord implements ContextAware {

    transient MetaworksContext metaworksContext;

    private String author;
    private String comment;
    private String resources;

    private Date date;

    private int revision;
    private int changes;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Face(options={"format"}, values={"yy.MM.dd. a/p hh:mm"})
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public int getChanges() {
        return changes;
    }

    public void setChanges(int changes) {
        this.changes = changes;
    }

    @NonEditable
    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    @XmlTransient
    @Override
    public MetaworksContext getMetaworksContext() {
        return metaworksContext;
    }

    @Override
    public void setMetaworksContext(MetaworksContext metaworksContext) {
        this.metaworksContext = metaworksContext;
    }

    @ServiceMethod(callByContent = true, eventBinding = EventContext.EVENT_CLICK, target = ServiceMethodContext.TARGET_APPEND)
    public Object[] load() {
        EssenciaEditor essenciaEditor = null;
        IResource r = null;
        if (resources.endsWith(".practice")) {
            r = Resource.newInstance("repository" + File.separator + "practices" + File.separator + getResources() + "." + getRevision() + ResourceType.REVISION_RESOURCE.getType());
            try {
                essenciaEditor = new PracticeDefinerEditor(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            r = Resource.newInstance("repository" + File.separator + "methods" + File.separator + getResources() + "." + getRevision() + ResourceType.REVISION_RESOURCE.getType());
            try {
                essenciaEditor = new MethodComposerEditor(r);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ContextUtil.setWhen(essenciaEditor, EssenciaContext.WHEN_VIEW_READONLY);
        for (Editor editor : essenciaEditor.getItems()) {
            ContextUtil.setWhen(editor, EssenciaContext.WHEN_VIEW_READONLY);
            editor.setSaveable(false);
            try {
                editor.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        essenciaEditor.setChanged(false);
        ((Resource)r).setDisplayName(r.getDisplayName() + "[Rev:" + getRevision() + "]");

        return new Object[] { new ToEvent(new ModalWindow(), EventContext.EVENT_CLOSE), new ToAppend(new EditorTabs(), essenciaEditor) };
    }
}