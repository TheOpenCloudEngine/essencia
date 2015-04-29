package org.uengine.essencia.modeling.palette;

import java.util.ArrayList;

import org.uengine.modeling.CompositePalette;
import org.uengine.modeling.Palette;

public class EssenciaPalette extends CompositePalette {

    public EssenciaPalette() {
	setName("Essencia Palette");
	initPallet();
    }

    @Override
    protected void initPallet() {
	setChildPallet(new ArrayList<Palette>());

	Palette LanguagePallet = new EssenciaLanguagePalette();
	Palette kernelPallet = new EssenciaKernelPalette();

	getChildPallet().add(LanguagePallet);
	getChildPallet().add(kernelPallet);

    }
}
