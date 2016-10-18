package org.uengine.web.process;

import org.metaworks.dao.TransactionAdvice;
import org.metaworks.dao.TransactionContext;
import org.oce.garuda.multitenancy.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uengine.codi.mw3.model.*;
import org.uengine.kernel.*;
import org.uengine.kernel.Role;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.modeling.resource.VersionManager;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.web.company.CompanyService;
import org.uengine.web.employee.EmployeeService;
import org.uengine.web.jiraapi.JiraApiService;
import org.uengine.web.jiraapi.JiraServiceFactory;
import org.uengine.web.jiraclient.JiraClientService;
import org.uengine.web.jiraproject.JiraProjectService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProcessMapServiceImpl implements ProcessMapService {

    @Autowired
    TransactionAdvice transactionAdvice;

    @Autowired
    ProcessManagerRemote processManager;

    @Autowired
    JiraClientService jiraClientService;

    @Autowired
    CompanyService companyService;

    @Autowired
    ResourceManager resourceManager;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    JiraApiService jiraApiService;

    @Autowired
    JiraProjectService jiraProjectService;

    @Override
    public List<ProcessMap> listPublicAndOwnProcessMap(String comCode) throws Exception {
        List<ProcessMap> processMaps = new ArrayList<>();
        //List<ProcessMap> publicProcessList = this.listPublicProcessMap();
        List<ProcessMap> ownProcessList = this.listProcessMapByComCode(comCode);

        //processMaps.addAll(publicProcessList);
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

            VersionManager versionManager = org.metaworks.dwr.MetaworksRemoteService.getComponent(VersionManager.class);

            defId = versionManager.getProductionResourcePath("codi", defId);

            if (defId == null)
                throw new NoSuchProcessDefinitionException();

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

    @Override
    public void createProcess(HttpServletRequest request, String projectName, String projectKey,
                              String projectType, String mapId, List<Map> roleMappings) throws Exception {

        String clientKey = jiraClientService.getClientKeyFromRequest(request);
        String requestUserKey = jiraClientService.getRequestUserKey(request);
        Company company = companyService.selectByAlias(clientKey);
        ProcessMap processMap = this.getProcessMapByMapId(mapId);

        //프로세스 생성 요청자 유저 생성.
        Employee requestEmployee = employeeService.createJiraEmployeeIfNotExist(request, requestUserKey);

        //롤 매핑 대상자 유저 생성
        for (Map roleMapping : roleMappings) {
            String roleName = roleMapping.get("roleName").toString();
            String userKey = roleMapping.get("userKey").toString();
            Employee mappingEmployee = employeeService.createJiraEmployeeIfNotExist(request, userKey);
            roleMapping.put("empCode", mappingEmployee.getEmpCode());
        }

        //롤 데피니션.
        List<Role> roleDefinitions = this.getRoles(processMap.getDefId(), processMap.getComCode());

        //테넌트 설정과 프로세스 인스턴스 생성
        new TenantContext(company.getComCode());
        String instId = this.initializeProcess(processMap.getDefId());

        //지라 프로젝트 생성
        String projectId = jiraApiService.createProject(request, projectName, projectKey, projectType, requestUserKey);
        //지라 프로젝트와 프로세스 인스턴스 매핑
        jiraProjectService.mappingWithInstanceId(Long.parseLong(instId), clientKey, projectId, requestUserKey);

        try {
            transactionAdvice.initiateTransaction();

            //롤 매핑 Initiator 설정
            if (roleMappings != null && roleMappings.size() > 0) {
                processManager.putRoleMapping(instId, "Initiator", requestEmployee.getEmpCode());
            }

            //롤 매핑 rootRole 설정
            for (Role role : roleDefinitions) {
                if ("rootRole".equals(role.getName())) {
                    processManager.putRoleMapping(instId, "rootRole", requestEmployee.getEmpCode());
                }
            }

            //롤 매핑 대상자 유저 설정
            for (Map roleMapping : roleMappings) {
                String roleName = roleMapping.get("roleName").toString();
                String userKey = roleMapping.get("userKey").toString();
                String empCode = (String) roleMapping.get("empCode");
                processManager.putRoleMapping(instId, roleName, empCode);
            }
            //프로세스 시작
            ProcessInstance processInstance = processManager.getProcessInstance(instId);
            processInstance.setProperty("0", "jira", true);
            processManager.executeProcess(instId);
            processManager.applyChanges();

            transactionAdvice.commitTransaction();
        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new RuntimeException(ex);
        }
    }

    private String initializeProcess(String defId) throws Exception {
        try {
            transactionAdvice.initiateTransaction();
            VersionManager versionManager = org.metaworks.dwr.MetaworksRemoteService.getComponent(VersionManager.class);

            String instId = processManager.initializeProcess(versionManager.getProductionResourcePath("codi", defId));
            transactionAdvice.commitTransaction();
            return instId;

        } catch (Exception ex) {
            transactionAdvice.rollbackTransaction();
            throw new Exception(ex);
        }
    }
}
