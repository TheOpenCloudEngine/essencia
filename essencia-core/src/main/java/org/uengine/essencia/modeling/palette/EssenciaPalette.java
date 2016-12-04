package org.uengine.essencia.modeling.palette;

import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.model.BasicElement;
import org.uengine.essencia.model.Concernable;
import org.uengine.essencia.model.LanguageElement;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.view.KernelLanguageViewable;
import org.uengine.essencia.model.view.LanguageElementView;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.essencia.util.KernelUtil;
import org.uengine.modeling.CompositePalette;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Palette;
import org.uengine.modeling.PaletteWindow;

public class EssenciaPalette extends CompositePalette {

    public EssenciaPalette() {this(null);}

    public EssenciaPalette(String kernel) {

        super();
        setName("Essencia Palette");

        Palette LanguagePallet = new EssenciaLanguagePalette();
        addPalette(LanguagePallet);


        /**
         * adding kernel elements
         */

        PaletteWindow customerPalette = new PaletteWindow();
        customerPalette.setName("Kernel - Customer");

        PaletteWindow solutionPalette = new PaletteWindow();
        solutionPalette.setName("Kernel - Solution");

        PaletteWindow endeavorPalette = new PaletteWindow();
        endeavorPalette.setName("Kernel - Endeavor");


        PracticeDefinition practice = null;

//        try {
            //TODO:  multiple kernel
            practice = KernelUtil.getInstance().getPracticeDefinition(kernel);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        EssenciaKernelSymbol symbol = null;
        KernelLanguageViewable view = null;

        List<IElement> elementList = practice.getElementList();

        for (IElement element : elementList) {
            view = (KernelLanguageViewable) element.getElementView();

            symbol = view.createKernelSymbol();
            symbol = fill(symbol, element);

            if(element instanceof Concernable){
                String concern = ((Concernable) element).getConcern();

                switch(concern){
                    case "Customer" :
                        customerPalette.addSymbol(symbol);
                        break;
                    case "Solution" :
                        solutionPalette.addSymbol(symbol);
                        break;
                    case "Endeavor" :
                        endeavorPalette.addSymbol(symbol);
                        break;

                }
            }


        }

        addPalette(customerPalette);
        addPalette(solutionPalette);
        addPalette(endeavorPalette);

    }


    private EssenciaKernelSymbol fill(EssenciaKernelSymbol symbol, IElement element) {
        symbol.setName(element.getName());
        symbol.setLanguageElementView((LanguageElementView) ((BasicElement) element).asView());
        return symbol;
    }
}
