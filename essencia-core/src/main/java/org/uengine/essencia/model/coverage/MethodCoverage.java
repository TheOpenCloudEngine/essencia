package org.uengine.essencia.model.coverage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uengine.essencia.model.Alpha;
import org.uengine.essencia.model.Criterion;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;

import com.thoughtworks.xstream.XStream;
import org.uengine.essencia.util.KernelUtil;
import org.uengine.modeling.ElementView;

public class MethodCoverage {

    private List<String> activity;
    private List<String> alpha;
    private Map<String, List<State>> alphaMapping;
    private Map<String, List<State>> activityMapping;

    public MethodCoverage() {

    }

    public MethodCoverage(EssenciaCanvas essenciaCanvas) {
        this.activity = new ArrayList<String>();
        this.alpha = new ArrayList<String>();
        this.alphaMapping = new HashMap<String, List<State>>();
        this.activityMapping = new HashMap<String, List<State>>();

        this.load(essenciaCanvas);
    }

    public List<String> getActivity() {
        return activity;
    }

    public void setActivity(List<String> activity) {
        this.activity = activity;
    }

    public List<String> getAlpha() {
        return alpha;
    }

    public void setAlpha(List<String> alpha) {
        this.alpha = alpha;
    }

    public Map<String, List<State>> getAlphaMapping() {
        return alphaMapping;
    }

    public void setAlphaMapping(Map<String, List<State>> alphaMapping) {
        this.alphaMapping = alphaMapping;
    }

    public Map<String, List<State>> getActivityMapping() {
        return activityMapping;
    }

    public void setActivityMapping(Map<String, List<State>> activityMapping) {
        this.activityMapping = activityMapping;
    }

    public List<Alpha> loadKernelAlphaList() {
        List<Alpha> alphaList = null;
        try {
            alphaList = KernelUtil.getInstance().getKernelAlphaList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return alphaList;
    }

    public void load(EssenciaCanvas essenciaCanvas) {

        List<Alpha> kernelAlphaList = loadKernelAlphaList();
        for (Alpha alpha : kernelAlphaList) {
            this.alpha.add(alpha.getName());

            List<State> tempStates = new ArrayList<State>();

            for (org.uengine.essencia.model.State state : alpha.getStates()) {
                State st = new State(state.getName());
                tempStates.add(st);
            }

            this.alphaMapping.put(alpha.getName(), tempStates);
        }

        List<ElementView> viewList = essenciaCanvas.getElementViewList();

        Map tmpMapping = new HashMap<String, String>();
        for (ElementView elementview : viewList) {
            if (elementview.getElement() instanceof org.uengine.essencia.model.Activity) {
                org.uengine.essencia.model.Activity activity = (org.uengine.essencia.model.Activity) elementview.getElement();
                this.getActivity().add(activity.getName());

                for (int i = 0; i < activity.getCompletionCriteria().size(); i++) {
                    Criterion criterion = activity.getCompletionCriteria().get(i);
                    if (criterion.getState() != null) {
                        String stateName = criterion.getState().getName();

                        tmpMapping.put(criterion.getState().getName(), String.valueOf(i));

                        if (this.getAlphaMapping().containsKey(criterion.getState().getParentAlpha().getName())) {
                            for (int j = 0; j < this.getAlphaMapping().get(criterion.getState().getParentAlpha().getName()).size(); j++) {
                                if (stateName.equals(this.getAlphaMapping().get(criterion.getState().getParentAlpha().getName()).get(j).getName())) {
                                    this.getAlphaMapping().get(criterion.getState().getParentAlpha().getName()).get(j).setInvolved(true);
                                    String tmpMappingIndex = (String) tmpMapping.get(criterion.getState().getName());
                                    if (tmpMappingIndex != null) {
                                        for (int k = j - 1; k > i; k--) {
                                            this.getAlphaMapping().get(criterion.getState().getParentAlpha().getName()).get(k).setInvolved(true);
                                        }
                                    }
                                }
                            }// state List
                        }

                    }

                }// outputAlpha List
            }// activity List
        }
    }

}
