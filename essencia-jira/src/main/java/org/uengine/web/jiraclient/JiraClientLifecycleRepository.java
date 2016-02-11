package org.uengine.web.jiraclient;

import org.uengine.web.repository.PersistentRepository;

public interface JiraClientLifecycleRepository extends PersistentRepository<JiraClientLifecycle, Long> {

    public static final String NAMESPACE = JiraClientLifecycleRepository.class.getName();

}
