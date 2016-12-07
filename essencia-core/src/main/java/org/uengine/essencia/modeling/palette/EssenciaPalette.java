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

        Palette languagePallet = new EssenciaLanguagePalette();
        PaletteWindow languagePaletteWindow = new PaletteWindow();
        languagePaletteWindow.setName(languagePallet.getName());
        languagePaletteWindow.addPalette(languagePallet);
        addPalette(languagePaletteWindow);


        /**
         * adding kernel elements
         */

        Palette customerPalette = new Palette();
        customerPalette.setName("Kernel - Customer");

        Palette solutionPalette = new Palette();
        solutionPalette.setName("Kernel - Solution");

        Palette endeavorPalette = new Palette();
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

        PaletteWindow customerPaletteWindow = new PaletteWindow();  customerPaletteWindow.addPalette(customerPalette); customerPaletteWindow.setName(customerPalette.getName());
        PaletteWindow solutionPaletteWindow = new PaletteWindow();  solutionPaletteWindow.addPalette(solutionPalette); solutionPaletteWindow.setName(solutionPalette.getName());
        PaletteWindow endeavorPaletteWindow = new PaletteWindow();  endeavorPaletteWindow.addPalette(endeavorPalette); endeavorPaletteWindow.setName(endeavorPalette.getName());

        addPalette(customerPaletteWindow);
        addPalette(solutionPaletteWindow);
        addPalette(endeavorPaletteWindow);

    }


    private EssenciaKernelSymbol fill(EssenciaKernelSymbol symbol, IElement element) {
        symbol.setName(element.getName());
        symbol.setLanguageElementView((LanguageElementView) ((BasicElement) element).asView());
        return symbol;
    }
}
