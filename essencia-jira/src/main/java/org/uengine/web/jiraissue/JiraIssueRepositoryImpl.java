package org.uengine.web.jiraissue;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uengine.web.jiraproject.JiraProject;
import org.uengine.web.jiraproject.JiraProjectRepository;
import org.uengine.web.repository.PersistentRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JiraIssueRepositoryImpl extends PersistentRepositoryImpl<JiraIssue, Long> implements JiraIssueRepository {

    @Override
    public String getNamespace() {
        return NAMESPACE;
    }

    @Autowired
    public JiraIssueRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public JiraIssue selectById(Long id) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectById", id);
    }

    @Override
    public JiraIssue selectByInstanceAndTracing(Long instanceId, Long tracingTag) {
        Map map = new HashMap();
        map.put("instanceId" , instanceId);
        map.put("tracingTag" , tracingTag);
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectByInstanceAndTracing", map);
    }

    @Override
    public JiraIssue selectByJiraIssueInformation(Long jiraClientId, String projectId, String issueId) {
        Map map = new HashMap();
        map.put("jiraClientId" , jiraClientId);
        map.put("projectId" , projectId);
        map.put("issueId" , issueId);
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectByJiraIssueInformation", map);
    }
}
