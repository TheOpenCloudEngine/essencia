package org.uengine.web.jiraclient;

import org.uengine.web.repository.PersistentRepositoryImpl;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JiraClientLifecycleRepositoryImpl extends PersistentRepositoryImpl<JiraClientLifecycle, Long> implements JiraClientLifecycleRepository {

    @Override
    public String getNamespace() {
        return NAMESPACE;
    }

    @Autowired
    public JiraClientLifecycleRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

}
