package org.uengine.web.process;

import org.uengine.web.repository.PersistentRepository;

import java.util.List;

public interface ProcessMapRepository extends PersistentRepository<ProcessMap, Long> {

    public static final String NAMESPACE = ProcessMapRepository.class.getName();

    List<ProcessMap> selectAll();

    List<ProcessMap> selectByComCode(String comCode);

    ProcessMap selectByMapId(String mapId);
}
