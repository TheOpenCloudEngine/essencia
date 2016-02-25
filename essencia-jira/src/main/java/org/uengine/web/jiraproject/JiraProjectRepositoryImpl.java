package org.uengine.web.jiraproject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uengine.web.jiraclient.JiraClientLifecycle;
import org.uengine.web.jiraclient.JiraClientLifecycleRepository;
import org.uengine.web.repository.PersistentRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JiraProjectRepositoryImpl extends PersistentRepositoryImpl<JiraProject, Long> implements JiraProjectRepository {

    @Override
    public String getNamespace() {
        return NAMESPACE;
    }

    @Autowired
    public JiraProjectRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public JiraProject selectById(Long id) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectById", id);
    }

    @Override
    public JiraProject selectByInstanceId(Long instanceId) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectByInstanceId", instanceId);
    }

    @Override
    public JiraProject selectByClientIdAndProjectId(Long jiraClientId, String projectId) {
        Map map = new HashMap();
        map.put("jiraClientId", jiraClientId);
        map.put("projectId", projectId);
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectByClientIdAndProjectId", map);
    }
}
