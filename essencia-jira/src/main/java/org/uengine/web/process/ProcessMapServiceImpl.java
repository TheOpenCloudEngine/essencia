package org.uengine.web.process;

import org.metaworks.dao.TransactionAdvice;
import org.oce.garuda.multitenancy.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uengine.codi.mw3.model.Company;
import org.uengine.codi.mw3.model.IProcessMap;
import org.uengine.codi.mw3.model.ProcessMap;
import org.uengine.codi.mw3.model.Session;
import org.uengine.kernel.Role;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.web.util.JsonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class ProcessMapServiceImpl implements ProcessMapService {

    @Autowired
    TransactionAdvice transactionAdvice;

    @Autowired
    ProcessManagerRemote processManager;

    @Override
    public List<ProcessMap> listPublicAndOwnProcessMap(String comCode) throws Exception {
        List<ProcessMap> processMaps = new ArrayList<>();
        List<ProcessMap> publicProcessList = this.listPublicProcessMap();
        List<ProcessMap> ownProcessList = this.listProcessMapByComCode(comCode);

        processMaps.addAll(publicProcessList);
        processMaps.addAll(ownProcessList);
        return processMaps;
    }

    @Override
    public List<ProcessMap> listPublicProcessMap() throws Exception {
        try {
            transactionAdvice.initiateTransaction();

            String comCode = "1";
            ProcessMap processMap = new ProcessMap();
            IProcessMap iProcessMap = processMap.loadListByComCode(comCode);
            ArrayList<ProcessMap> processMaps = new ArrayList<>();
            while (iProcessMap.next()) {
                ProcessMap result = new ProcessMap();
                result.copyFrom(iProcessMap);
                processMaps.add(result);
            }

            transactionAdvice.commitTransaction();
            return processMaps;
        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }

    @Override
    public List<ProcessMap> listProcessMapByComCode(String comCode) throws Exception {
        try {
            transactionAdvice.initiateTransaction();

            ProcessMap processMap = new ProcessMap();
            IProcessMap iProcessMap = processMap.loadListByComCode(comCode);
            ArrayList<ProcessMap> processMaps = new ArrayList<>();
            while (iProcessMap.next()) {
                ProcessMap result = new ProcessMap();
                result.copyFrom(iProcessMap);
                processMaps.add(result);
            }

            transactionAdvice.commitTransaction();
            return processMaps;
        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }

    @Override
    public ProcessMap getProcessMapByMapId(String mapId) throws Exception {
        try {
            transactionAdvice.initiateTransaction();

            ProcessMap processMap = new ProcessMap();
            IProcessMap iProcessMap = processMap.findByMapId(mapId);

            ProcessMap result = new ProcessMap();
            result.copyFrom(iProcessMap);

            transactionAdvice.commitTransaction();
            return result;
        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }

    @Override
    public List<Role> getRoles(String defId, String comCode) throws Exception {
        try {
            transactionAdvice.initiateTransaction();
            new TenantContext(comCode);
            org.uengine.kernel.ProcessDefinition definition = processManager.getProcessDefinition(defId);
            Role[] roles = definition.getRoles();

            List<Role> roleList = new ArrayList<>();
            for (int i = 0; i < roles.length; i++) {
                roleList.add(roles[i]);
            }

            transactionAdvice.commitTransaction();
            return roleList;

        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }
}
