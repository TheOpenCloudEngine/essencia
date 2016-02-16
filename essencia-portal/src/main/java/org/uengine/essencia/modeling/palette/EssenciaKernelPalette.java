package org.uengine.essencia.modeling.palette;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.uengine.essencia.model.*;
import org.uengine.essencia.model.view.KernelLanguageViewable;
import org.uengine.essencia.model.view.LanguageElementView;
import org.uengine.essencia.modeling.EssenciaKernelSymbol;
import org.uengine.essencia.util.KernelUtil;
import org.uengine.modeling.IElement;
import org.uengine.modeling.Palette;

import com.thoughtworks.xstream.XStream;

public class EssenciaKernelPalette extends Palette {

    public EssenciaKernelPalette() {
        setName("Kernel Palette");
        PracticeDefinition practice = null;

        try {
            practice = KernelUtil.getInstance().getPracticeDefinition();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<EssenciaKernelSymbol> symbolList = new ArrayList<EssenciaKernelSymbol>();
        EssenciaKernelSymbol symbol = null;
        KernelLanguageViewable view = null;

        List<IElement> elementList = practice.getElementList();

        for (IElement element : elementList) {
            view = (KernelLanguageViewable) element.getElementView();

            symbol = view.createKernelSymbol();
            symbol = fill(symbol, element);
            symbolList.add(symbol);
        }
        getSymbolList().addAll(symbolList);

    }

    private EssenciaKernelSymbol fill(EssenciaKernelSymbol symbol, IElement element) {
        symbol.setName(element.getName());
        symbol.setLanguageElementView((LanguageElementView) ((BasicElement) element).asView());
        return symbol;
    }

}