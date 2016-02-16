package org.uengine.web.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.mw3.model.InstanceViewContent;
import org.uengine.processmanager.ProcessManagerRemote;

import java.util.ArrayList;

/**
 * Created by uengine on 2016. 2. 4..
 */
public class ProcessMap {

    private String mapId;

    private String defId;

    private String name;

    private String iconPath;

    private String color;

    private String comCode;

    private int no;

    private String cmPhrase;

    private String cmTrgr;

    private boolean isScheduled;

    private boolean isPublic;

    private boolean isNew;

    public String getMapId() {
        return mapId;
    }

    public void setMapId(String mapId) {
        this.mapId = mapId;
    }

    public String getDefId() {
        return defId;
    }

    public void setDefId(String defId) {
        this.defId = defId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getCmPhrase() {
        return cmPhrase;
    }

    public void setCmPhrase(String cmPhrase) {
        this.cmPhrase = cmPhrase;
    }

    public String getCmTrgr() {
        return cmTrgr;
    }

    public void setCmTrgr(String cmTrgr) {
        this.cmTrgr = cmTrgr;
    }

    public boolean getIsScheduled() {
        return isScheduled;
    }

    public void setIsScheduled(boolean isScheduled) {
        this.isScheduled = isScheduled;
    }

    public boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    @Override
    public String toString() {
        return "ProcessMap{" +
                "mapId='" + mapId + '\'' +
                ", defId='" + defId + '\'' +
                ", name='" + name + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", color='" + color + '\'' +
                ", comCode='" + comCode + '\'' +
                ", no=" + no +
                ", cmPhrase='" + cmPhrase + '\'' +
                ", cmTrgr='" + cmTrgr + '\'' +
                ", isScheduled=" + isScheduled +
                ", isPublic=" + isPublic +
                ", isNew=" + isNew +
                '}';
    }
}
