package org.uengine.web.company;

import org.uengine.web.repository.PersistentRepository;

public interface CompanyRepository extends PersistentRepository<Company, Long> {

    public static final String NAMESPACE = CompanyRepository.class.getName();

    int createKey();

    Company selectByAlias(String clientKey);
}
