package org.uengine.essencia.enactment.face;

import org.metaworks.Face;
import org.metaworks.annotation.Hidden;
import org.uengine.contexts.TextContext;
import org.uengine.essencia.enactment.AlphaInstance;
import org.uengine.essencia.enactment.LanguageElementInstance;
import org.uengine.essencia.model.*;
import org.uengine.essencia.model.card.Card;
import org.uengine.essencia.modeling.canvas.CardCanvas;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class LanguageElementInstanceFace implements Card, Face<LanguageElementInstance> {

    protected List<String> list;
    protected List<String> levels;
    protected int x = 0;
    protected int y = 0;
    protected int trcTag = 0;
    protected TextContext name;
    protected String parentName;
    protected Symbol symbol = null;
    protected String img;
    LanguageElementInstance languageElementInstance;
    protected String stateNumber;

    public List<String> getLevels() {
        return levels;
    }

    public void setLevels(List<String> levels) {
        this.levels = levels;
    }

    public String getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(String stateNumber) {
        this.stateNumber = stateNumber;
    }

    public LanguageElementInstance getLanguageElementInstance() {
        return languageElementInstance;
    }

    public void setLanguageElementInstance(LanguageElementInstance languageElementInstance) {
        this.languageElementInstance = languageElementInstance;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }


    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    protected ElementView view = null;

    public ElementView getView() {
        return view;
    }

    public void setView(ElementView view) {
        this.view = view;
    }


    @Override
    public String getName() {
        return name.getText();
    }

    @Override
    public void setName(String name) {
        this.name.setText(name);
    }


    @Override
    public String getImg() {
        return img;
    }

    @Override
    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String getParentName() {
        return parentName;
    }

    @Override
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    protected TextContext description;

    public String getDescription() {
        return description.getText();
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    protected CardCanvas canvas;

    public CardCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(CardCanvas canvas) {
        this.canvas = canvas;
    }

    String id;

    List<PropertyValue> propertyValueList;
        public List<PropertyValue> getPropertyValueList() {
            return propertyValueList;
        }
        public void setPropertyValueList(List<PropertyValue> propertyValueList) {
            this.propertyValueList = propertyValueList;
        }

    BasicElement languageElement;
        @Hidden
        public BasicElement getLanguageElement() {
            return languageElement;
        }

        public void setLanguageElement(BasicElement languageElement) {
            this.languageElement = languageElement;
        }

    @Override
    public void setValueToFace(LanguageElementInstance languageElementInstance) {
        setPropertyValueList(languageElementInstance.getPropertyValues());
        setLanguageElement(languageElementInstance.getLanguageElement());
    }

    @Override
    public LanguageElementInstance createValueFromFace() {


        return null;
    }
    public LanguageElementInstanceFace(ElementView view) {
        this.name = new TextContext();
        this.description = new TextContext();
        setList(new ArrayList<String>());
        setLevels(new ArrayList<String>());

        setImg(IMG_LOCATION + view.getShapeId() + IMG_EXTENSION);
        String p = "";
        String n ="";
        p = view.getLabel().substring(0, view.getLabel().indexOf("("));
        n = view.getLabel().substring(view.getLabel().indexOf("(") + 1, view.getLabel().length()-1 );
        setParentName(view.getLabel().substring(0, view.getLabel().indexOf("(")));
        setName(view.getLabel().substring(view.getLabel().indexOf("(") + 1, view.getLabel().length()-1 ) );

        if( ((WorkProduct)view.getElement()).getLevelOfDetails()  != null){
            for(int i=0; i < ((WorkProduct)view.getElement()).getLevelOfDetails().size(); i++){
                LevelOfDetail levelOfDetail = ((WorkProduct)view.getElement()).getLevelOfDetails().get(i);
                getLevels().add(levelOfDetail.getName());
                if(levelOfDetail.getName().equals(n)){
                    for (CheckPoint checkPoint : levelOfDetail.getCheckPoints()){
                        getList().add(checkPoint.getName());
                    }
                }
            }
        }

    }
}
