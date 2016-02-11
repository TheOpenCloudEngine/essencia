package org.uengine.web.jiraclient;

import org.uengine.web.repository.PersistentRepository;

public interface JiraClientRepository extends PersistentRepository<JiraClient, Long> {

    public static final String NAMESPACE = JiraClientRepository.class.getName();

    JiraClient selectById(Long id);

    JiraClient selectByClientKey(String clientKey);

    int replaceClient(JiraClient jiraClient);

    int updateStatus(Long id, String status);
}
