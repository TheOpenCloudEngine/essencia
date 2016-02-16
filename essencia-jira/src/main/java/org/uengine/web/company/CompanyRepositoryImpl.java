package org.uengine.web.company;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.uengine.web.process.ProcessMap;
import org.uengine.web.process.ProcessMapRepository;
import org.uengine.web.repository.PersistentRepositoryImpl;

import java.util.List;

@Repository
public class CompanyRepositoryImpl extends PersistentRepositoryImpl<Company, Long> implements CompanyRepository {

    @Override
    public String getNamespace() {
        return NAMESPACE;
    }

    @Autowired
    public CompanyRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public int createKey() {
        this.getSqlSessionTemplate().insert(this.getNamespace() + ".initKey");
        this.getSqlSessionTemplate().update(this.getNamespace() + ".createKey");
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".getKey");
    }

    @Override
    public Company selectByAlias(String clientKey) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectByAlias", clientKey);
    }
}
