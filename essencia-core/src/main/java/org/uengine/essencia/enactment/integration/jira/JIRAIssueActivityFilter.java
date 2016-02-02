package org.uengine.essencia.enactment.integration.jira;

import org.uengine.kernel.*;

/**
 * Created by jjy on 2016. 2. 2..
 */
public class JIRAIssueActivityFilter implements ActivityFilter{
    @Override
    public void beforeExecute(Activity activity, ProcessInstance instance) throws Exception {

    }

    @Override
    public void afterExecute(Activity activity, ProcessInstance instance) throws Exception {

        if(activity instanceof HumanActivity){

            String tracingTag = activity.getTracingTag();
            String[] taskIds = ((HumanActivity) activity).getTaskIds(instance);
            String taskId = taskIds[0];

            //jira 호출
            String issueId = "xxxx"; //...

            ///  jira:uengine mapping table insertion



        }



    }

    @Override
    public void afterComplete(Activity activity, ProcessInstance instance) throws Exception {

    }

    @Override
    public void onPropertyChange(Activity activity, ProcessInstance instance, String propertyName, Object changedValue) throws Exception {

    }

    @Override
    public void onDeploy(ProcessDefinition definition) throws Exception {

    }
}
