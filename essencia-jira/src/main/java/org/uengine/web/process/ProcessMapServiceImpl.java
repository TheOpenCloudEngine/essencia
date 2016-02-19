package org.uengine.web.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uengine.codi.mw3.model.Company;
import org.uengine.codi.mw3.model.IProcessMap;
import org.uengine.codi.mw3.model.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class ProcessMapServiceImpl implements ProcessMapService {

    @Autowired
    private ProcessMapRepository processMapRepository;

    @Override
    @Transactional
    public List<ProcessMap> listProcessMap() throws Exception {
        return processMapRepository.selectAll();
    }

    //TODO 마켓플레이스에서 퍼블릭한 프로세스맵을 가져와야한다.일단은 임시방편으로 가져온다.
    @Override
    public List<ProcessMap> listPublicProcessMap() throws Exception {
        String comCode = "1";
        return processMapRepository.selectByComCode(comCode);
    }

    @Override
    public List<ProcessMap> listProcessMapByComCode(String comCode) throws Exception {
        return processMapRepository.selectByComCode(comCode);
    }

    @Override
    public ProcessMap getProcessMapByMapId(String mapId) throws Exception {
        return processMapRepository.selectByMapId(mapId);
    }
}
