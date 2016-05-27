package org.uengine.essencia.modeling.modeler;

import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.widget.ModalWindow;
import org.uengine.essencia.designer.EssenciaPropertyPanel;
import org.uengine.essencia.model.view.LanguageElementView;
import org.uengine.modeling.ElementView;
import org.uengine.modeling.ElementViewActionDelegate;
import org.uengine.modeling.PropertySettingDialog;
import org.uengine.modeling.modeler.DefaultElementViewActionDelegate;

/**
 * Created by jangjinyoung on 2016. 5. 26..
 */
public class EssenciaDefaultElementViewActionDelegate extends DefaultElementViewActionDelegate{

    @Override
    public void onDoubleClick(ElementView elementView) {
        if(elementView instanceof LanguageElementView){
            MetaworksRemoteService.wrapReturn(new ModalWindow(new EssenciaPropertyPanel(elementView)));
        }else

            MetaworksRemoteService.wrapReturn(new PropertySettingDialog(elementView));
    }
}
