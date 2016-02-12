package org.uengine.jira.mw3;

import org.metaworks.annotation.ServiceMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.uengine.codi.mw3.model.*;
import org.uengine.codi.mw3.model.ProcessMap;
import org.uengine.kernel.Role;
import org.uengine.modeling.resource.VersionManager;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.web.process.*;
import org.uengine.web.util.ApplicationContextRegistry;
import org.uengine.web.util.JsonUtils;

import java.util.List;

/**
 * Created by uengine on 2016. 2. 11..
 */
public class ProcessMwService {

    @Autowired
    public ProcessManagerRemote processManager;

    @Autowired
    public InstanceViewContent instanceView;

    private String defId;

    private org.uengine.kernel.Role[] roles;

    private String rolesJson;

    private String name;

    private String key;

    private String roleMapping;

    public String getDefId() {
        return defId;
    }

    public void setDefId(String defId) {
        this.defId = defId;
    }

    public org.uengine.kernel.Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    public String getRolesJson() {
        return rolesJson;
    }

    public void setRolesJson(String rolesJson) {
        this.rolesJson = rolesJson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRoleMapping() {
        return roleMapping;
    }

    public void setRoleMapping(String roleMapping) {
        this.roleMapping = roleMapping;
    }

    @ServiceMethod(callByContent = true)
    public void loadRoles() throws Exception {
        org.uengine.kernel.ProcessDefinition definition = processManager.getProcessDefinition(this.getDefId());
        this.setRolesJson(JsonUtils.marshal(definition.getRoles()));
    }

    @ServiceMethod(callByContent = true)
    public void saveProject() throws Exception {
        ApplicationContext context = ApplicationContextRegistry.getApplicationContext();
        ProcessMapService processMapService = context.getBean(ProcessMapService.class);
        List<org.uengine.web.process.ProcessMap> listProcessMap = processMapService.getListProcessMap();


    }

    @ServiceMethod(callByContent = true)
    public void load() throws Exception {
        ProcessMap map = new ProcessMap();
        Session session = new Session();
        User user = new User();
        user.setUserId("1");
        session.setUser(user);

        Employee employee = new Employee();
        employee.setGlobalCom("1");
        employee.setEmpCode("1");
        session.setEmployee(employee);

        Company company = new Company();
        company.setComCode("1");
        session.setCompany(company);


        map.session = session;
        map.setDefId("Scrum Practice/KOSTA Essence.method");
        map.setComCode("1");
        map.setMapId("1.Scrum Practice.KOSTA Essenc");
        map.setName("Scrum Practice.KOSTA Essenc");
        map.processManager = processManager;
        map.instanceView = instanceView;

        org.uengine.kernel.ProcessDefinition definition = processManager.getProcessDefinition("Scrum Practice/KOSTA Essence.method");
        org.uengine.kernel.Role[] roles = definition.getRoles();
        for (int i = 0; i < roles.length; i++) {
            org.uengine.kernel.Role role = roles[i];
        }

        String instId = map.processManager.initializeProcess(VersionManager.getProductionResourcePath("codi", map.getDefId()));
        String title = null;

        Instance instanceRef = new Instance();
        instanceRef.setInstId(new Long(instId));

        map.setRoleMappingPanel(new RoleMappingPanel(this.processManager, map.getDefId(), map.session));
        map.getRoleMappingPanel().putRoleMappings(this.processManager, instId);
        map.processManager.executeProcess(instId);
        map.processManager.applyChanges();

        //map.startWithRoleMapping();
        //map.initiate();
    }
}
