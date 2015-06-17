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
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.modeling.canvas.EssenciaCanvas;

import com.thoughtworks.xstream.XStream;

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
		PracticeDefinition practice = null;
		try {
			InputStream is = getClass().getResourceAsStream("/org/uengine/essencia/model/kernel/kernel.practice");
			XStream x = new XStream();
			InputStreamReader isr = new InputStreamReader(is);
			practice = (PracticeDefinition)x.fromXML(isr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return practice.getElements(Alpha.class);
	}
	
	public void load(EssenciaCanvas essenciaCanvas){
		/*
		List<Alpha> kernelAlphaList = loadKernelAlphaList();
		for (Alpha alpha : kernelAlphaList) {
			this.alpha.add(alpha.getName());

			List<State> tempStates = new ArrayList<State>();

			for (org.uengine.essencia.model.State state : alpha.getStates()
					.getStates()) {
				State st = new State(state.getName());
				tempStates.add(st);
			}

			this.alphaMapping.put(alpha.getName(), tempStates);
		}

		List<ElementView> viewList = essenciaCanvas.getElementViewList();

		Map tmpMapping = new HashMap<String, String>();
		for (ElementView elementview : viewList) {
			if (elementview.getElement() instanceof Activity) {
				Activity activity = (Activity) elementview.getElement();
				this.getActivity().add(activity.getName());

				Criteria criteria = activity.getCompletionCriteria();
				for (Criterion criterion : criteria.getCriteria()) {
						String stateName = criterion.getState().getName();
						
						tmpMapping.put(criterion.getName(), String.valueOf(i)); 

						for (int j=0; j<this.getAlphaMapping().get(criterion.getName()).size(); j++) {
							if (stateName.equals(this.getAlphaMapping().get(criterion.getName()).get(j).getName())) {
								this.getAlphaMapping().get(criterion.getName()).get(j).setInvolved(true);
								String tmpMappingIndex = (String) tmpMapping.get(criterion.getName());
								if (tmpMappingIndex != null) {
									for (int k=j-1; k>i; k--) {
										this.getAlphaMapping().get(criterion.getName()).get(k).setInvolved(true);
									}
								}
							}
						
						
					}// state List
				}// outputAlpha List
			}// activity List
		}*/
	}

}
