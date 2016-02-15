package org.uengine.web.process;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uengine.web.jiraclient.JiraClient;
import org.uengine.web.jiraclient.JiraClientRepository;
import org.uengine.web.repository.PersistentRepositoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProcessMapRepositoryImpl extends PersistentRepositoryImpl<ProcessMap, Long> implements ProcessMapRepository {

    @Override
    public String getNamespace() {
        return NAMESPACE;
    }

    @Autowired
    public ProcessMapRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public List<ProcessMap> selectAll() {
        return this.getSqlSessionTemplate().selectList(this.getNamespace() + ".selectAll");
    }

    @Override
    public List<ProcessMap> selectByComCode(String comCode) {
        return this.getSqlSessionTemplate().selectList(this.getNamespace() + ".selectByComCode", comCode);
    }

    @Override
    public ProcessMap selectByMapId(String mapId) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectByMapId", mapId);
    }
}
