package org.uengine.web.jiraproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uengine.web.jiraclient.*;

@Service
public class JiraProjectServiceImpl implements JiraProjectService {

    @Autowired
    private JiraProjectRepository projectRepository;

    @Autowired
    private JiraClientService jiraClientService;

    @Override
    public void mappingWithInstanceId(Long instanceId, String clientKey, String projectId, String initiator) throws Exception {
        JiraClient jiraClient = jiraClientService.selectByClientKey(clientKey);
        Long id = jiraClient.getId();

        JiraProject jiraProject = new JiraProject();
        jiraProject.setInstanceId(instanceId);
        jiraProject.setJiraClientId(id);
        jiraProject.setProjectId(projectId);
        jiraProject.setInitiator(initiator);

        projectRepository.insert(jiraProject);
    }

    @Override
    public JiraProject selectByInstanceId(Long instanceId) {

        return projectRepository.selectByInstanceId(instanceId);
    }
}
