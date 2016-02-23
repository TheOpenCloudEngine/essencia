package org.uengine.web.activity;

import org.uengine.kernel.*;

/**
 * Created by jjy on 2016. 2. 2..
 */
public class JIRAIssueActivityFilter implements ActivityFilter {
    @Override
    public void beforeExecute(Activity activity, ProcessInstance instance) throws Exception {

    }

    @Override
    public void afterExecute(Activity activity, ProcessInstance instance) throws Exception {

        if (activity instanceof HumanActivity) {

            //필요 정보를 모은다.
            String instanceId = instance.getInstanceId(); //인스턴스 아이디
            String tracingTag = activity.getTracingTag(); //트래이싱 태그
            String[] taskIds = ((HumanActivity) activity).getTaskIds(instance);
            String taskId = taskIds[0]; //타스크 아이디
            String activityName = activity.getName(); //이슈 이름
            String description = activity.getDescription(); //이슈 설명
            Role role = ((HumanActivity) activity).getRole();
            String roleName = role.getName(); // 롤 이름
            RoleMapping roleMapping = instance.getRoleMapping(roleName);
            String endpoint = roleMapping.getEndpoint(); //empCode


            //jira 이슈를 생성한다.


            //생성된 지라 이슈와 액티비티를 매핑하여 저장한다.


            //EssenceActivity essenceActivity = (EssenceActivity) processManager.getProcessInstance(getInstanceId()).getProcessDefinition().getActivity(tracingTag);
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
