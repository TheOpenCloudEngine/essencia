package org.uengine.web.jiraproject;

import org.uengine.web.repository.PersistentRepository;

public interface JiraProjectRepository extends PersistentRepository<JiraProject, Long> {

    public static final String NAMESPACE = JiraProjectRepository.class.getName();

    JiraProject selectById(Long id);

    JiraProject selectByInstanceId(Long instanceId);

    JiraProject selectByClientAndProjectId(Long jiraClientId, String jiraProjectId);

}
