package org.uengine.essencia.enactment;

import org.metaworks.AllChildFacesAreIgnored;
import org.metaworks.annotation.Face;
import org.uengine.essencia.model.LanguageElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjy on 2015. 12. 26..
 */
public class AlphaInstanceList extends ArrayList<AlphaInstanceInList> {

    LanguageElement languageElementType;
    @Face(faceClass = AllChildFacesAreIgnored.class)
        public LanguageElement getLanguageElementType() {
            return languageElementType;
        }

        public void setLanguageElementType(LanguageElement languageElementType) {
            this.languageElementType = languageElementType;
        }

}
