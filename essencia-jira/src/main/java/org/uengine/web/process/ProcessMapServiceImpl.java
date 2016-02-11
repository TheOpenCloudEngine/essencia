package org.uengine.web.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class ProcessMapServiceImpl implements ProcessMapService {

    @Autowired
    @Qualifier("config")
    private Properties config;

    @Autowired
    private ProcessMapRepository processMapRepository;

    @Override
    public List<ProcessMap> getListProcessMap() throws Exception {

        return processMapRepository.selectAll();

    }

    @Override
    public ProcessMap getProcessMapByMapId(String mapId) throws Exception {
        return processMapRepository.selectByMapId(mapId);
    }
}
