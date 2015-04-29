package org.uengine.essencia.api;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.uengine.essencia.model.Activity;
import org.uengine.essencia.model.PracticeDefinition;
import org.uengine.essencia.model.State;
import org.uengine.essencia.repository.ObjectRepository;

@Controller
@RequestMapping("practice")
public class PracticeController {

	private PracticeDefinition getPracticeDefinition(String pdId) throws Exception{
		PracticeDefinition pd = (PracticeDefinition)ObjectRepository.getInstance().get("/methods/" + pdId);
		pd.afterDeserialize();
		return pd;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "{practiceId}/activity/{activityName}")
	public Activity getActivity(@PathVariable String practiceId, @PathVariable String activityName) throws Exception {
		PracticeDefinition pd = this.getPracticeDefinition(practiceId);
		Activity activity = pd.getElement(activityName, Activity.class);
		return activity;
	}
	
//	@ResponseBody
//	@RequestMapping(value = "{practiceId}/activity/{activityName}/state")
//	public List<State> getState(@PathVariable String practiceId, @PathVariable String activityName) throws Exception {
//		Activity activity = this.getActivity(practiceId,activityName);
//		List<State> stateList = activity.getStateList();	
//		return stateList;
//	}
}
