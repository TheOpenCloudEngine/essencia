package org.uengine.web.jiraclient;

import org.apache.ibatis.session.Configuration;
import org.uengine.web.repository.PersistentRepositoryImpl;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JiraClientRepositoryImpl extends PersistentRepositoryImpl<JiraClient, Long> implements JiraClientRepository {

    @Override
    public String getNamespace() {
        return NAMESPACE;
    }

    @Autowired
    public JiraClientRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public JiraClient selectById(Long id) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectById", id);
    }

    @Override
    public JiraClient selectByClientKey(String clientKey) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectByClientKey", clientKey);
    }

    @Override
    public int replaceClient(JiraClient jiraClient) {
        return this.getSqlSessionTemplate().update(this.getNamespace() + ".replaceClient", jiraClient);
    }

    @Override
    public int updateStatus(Long id, String status) {
        Map map = new HashMap();
        map.put("id", id);
        map.put("status", status);
        return this.getSqlSessionTemplate().update(this.getNamespace() + ".updateStatus", map);
    }
}
