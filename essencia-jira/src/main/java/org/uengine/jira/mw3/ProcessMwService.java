package org.uengine.jira.mw3;

import org.metaworks.annotation.ServiceMethod;
import org.oce.garuda.multitenancy.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.uengine.codi.mw3.model.*;
import org.uengine.codi.mw3.model.ProcessMap;
import org.uengine.kernel.*;
import org.uengine.kernel.Role;
import org.uengine.modeling.resource.VersionManager;
import org.uengine.processmanager.ProcessManagerRemote;
import org.uengine.web.util.JsonUtils;

import java.util.ArrayList;


/**
 * Created by uengine on 2016. 2. 11..
 */
public class ProcessMwService extends JiraMwService {

    @Autowired
    public ProcessManagerRemote processManager;

    @Autowired
    public InstanceViewContent instanceView;

    private String claimJson;

    private String defId;

    private String comCode;

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

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
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

    public String getClaimJson() {
        return claimJson;
    }

    public void setClaimJson(String claimJson) {
        this.claimJson = claimJson;
    }

    @ServiceMethod(callByContent = true)
    public void loadRoles() throws Exception {



        new TenantContext(this.getComCode());
        org.uengine.kernel.ProcessDefinition definition = processManager.getProcessDefinition(this.getDefId());
        this.setRolesJson(JsonUtils.marshal(definition.getRoles()));
    }

    @ServiceMethod(callByContent = true)
    public void saveProject() throws Exception {
        //new TenantContext(this.jiraSession.getComCode());
        new TenantContext("1");

        ProcessMap map = new ProcessMap();
        String instId = processManager.initializeProcess(VersionManager.getProductionResourcePath("codi", map.getDefId()));

        org.uengine.kernel.ProcessDefinition definition = processManager.getProcessDefinition(this.getDefId());

        ArrayList<IRoleMappingDefinition> roleMappingDefinitions = new ArrayList<IRoleMappingDefinition>();
        if(definition.getRoles()!=null)
            for(org.uengine.kernel.Role role : definition.getRoles()){
                if( "Initiator".equalsIgnoreCase(role.getName()) ){
                    continue;
                }
                RoleMappingDefinition roleMappingDefinition = new RoleMappingDefinition();
                roleMappingDefinition.setRoleDefId(this.jiraSession.getComCode() + "." + defId + "." + role.getName());
                try{
                    roleMappingDefinition.copyFrom(roleMappingDefinition.findRoleMappingDefinition());
                    roleMappingDefinition.setRoleMappedUser(new RoleMappedUser());

                    IUser user = new User();
                    user.setName(roleMappingDefinition.getMappedUserName());
                    user.setUserId(roleMappingDefinition.getMappedUserId());
                    roleMappingDefinition.getRoleMappedUser().getUsers().add(user);

                    roleMappingDefinitions.add(roleMappingDefinition);
                }catch(Exception e){
                    RoleMappingDefinition roleMappingDef = new RoleMappingDefinition();
                    roleMappingDef.setRoleDefId(roleMappingDefinition.getRoleDefId());
                    roleMappingDef.setDefId(defId);
                    roleMappingDef.setRoleName(role.getName());

                    IUser user = new User();
                    user.setUserId("2");
                    roleMappingDefinition.getRoleMappedUser().getUsers().add(user);

                    roleMappingDef.setComCode(this.jiraSession.getComCode());
                    roleMappingDef.setRoleDefType(RoleMappingDefinition.ROLE_DEF_TYPE_USER);
                    roleMappingDefinitions.add(roleMappingDef);
                }
            }

        for(IRoleMappingDefinition roleMappingDefinition: roleMappingDefinitions){
            if( RoleMappingDefinition.ROLE_DEF_TYPE_USER.equals(roleMappingDefinition.getRoleDefType() )){
                if(roleMappingDefinition.getMappedUserId()!=null){
                    processManager.putRoleMapping(instId, roleMappingDefinition.getRoleName(), roleMappingDefinition.getMappedUserId());
                }
            }else if( RoleMappingDefinition.ROLE_DEF_TYPE_ROLE.equals(roleMappingDefinition.getRoleDefType() )){
                if(roleMappingDefinition.getMappedRoleCode()!=null ){
                    RoleUser roleUser = new RoleUser();
                    roleUser.setRoleCode(roleMappingDefinition.getMappedRoleCode());
                    IRoleUser refRoleUser = roleUser.findUserByRoleCode();
                    while(refRoleUser.next()){
                        processManager.putRoleMapping(instId, roleMappingDefinition.getRoleName(), refRoleUser.getEmpCode() );
                    }
                }
            }
        }

//        Instance instanceRef = new Instance();
//        instanceRef.setInstId(new Long(instId));

        //map.setRoleMappingPanel(new RoleMappingPanel(this.processManager, map.getDefId(), map.session));
        //map.getRoleMappingPanel().putRoleMappings(this.processManager, instId);
        map.processManager.executeProcess(instId);
        map.processManager.applyChanges();
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
