package org.uengine.essencia.marketplace;

import org.metaworks.MetaworksContext;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.component.SelectBox;
import org.metaworks.dwr.MetaworksRemoteService;
import org.metaworks.website.MetaworksFile;
import org.metaworks.widget.ModalPanel;
import org.oce.garuda.multitenancy.TenantContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.marketplace.App;
import org.uengine.codi.mw3.marketplace.AppMapping;
import org.uengine.codi.mw3.marketplace.MyVendor;
import org.uengine.codi.mw3.marketplace.category.Category;
import org.uengine.codi.mw3.marketplace.category.ICategory;
import org.uengine.essencia.resource.ModelResource;
import org.uengine.essencia.resource.Resource;
import org.uengine.modeling.resource.ResourceManager;
import org.uengine.persistence.dao.UniqueKeyGenerator;
import org.uengine.processmanager.ProcessManagerBean;

import java.util.Calendar;

/**
 * Created by soo on 2015. 8. 18..
 */

@Component
@Scope("prototype")
@Face(
        ejsPath = "dwr/metaworks/genericfaces/FormFace.ejs",
        ejsPathForArray = "dwr/metaworks/genericfaces/ListFace.ejs",
        ejsPathMappingByContext = {
                "{how: 'inList', face: 'dwr/metaworks/org/uengine/codi/mw3/marketplace/IApp.ejs'}",
                "{how: 'detail', face: 'dwr/metaworks/org/uengine/codi/mw3/marketplace/IApp.ejs'}",
                "{how: 'myVendor', face: 'dwr/metaworks/org/uengine/codi/mw3/marketplace/IApp.ejs'}",
                "{where: 'mapList', face: 'dwr/metaworks/org/uengine/codi/mw3/marketplace/IAppMap.ejs'}"
        },
        options = {"fieldOrder"},
        values = {"categories,appName,simpleOverview,fullOverview,marketplaceResource"})
public class EssenciaApp extends App {

    public MarketplaceResource marketplaceResource;

    public MarketplaceResource getMarketplaceResource() {
        return marketplaceResource;
    }

    public void setMarketplaceResource(MarketplaceResource marketplaceResource) {
        this.marketplaceResource = marketplaceResource;
    }

    public String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public EssenciaApp() throws Exception {
        this.setMarketplaceResource(new MarketplaceResource());
    }

    @Override
    public void load() throws Exception {
        SelectBox categories = new SelectBox();

        ICategory category = Category.loadRootCategory();
        if (category.size() > 0) {
            while (category.next()) {

                String categoryId = Integer.toString(category.getCategoryId());
                String categoryName = category.getCategoryName();

                categories.add(categoryName, categoryId);
            }
        }

        this.setCategories(categories);

        if (this.getLogoFile() == null) {
            this.setLogoFile(new MetaworksFile());
        }
    }

    @Override
    public Object save() throws Exception {
        //이 내용을 원하는 경로에 맞춰서 다시 저장을 해야함.
        String filename = this.getMarketplaceResource().getModelResource().getPath();

        uploadToMarketplace(this.getMarketplaceResource().getModelResource());

        // 파일이 변경이 되어있지 않다면 변경을 안한다.
        if (this.getLogoFile().getFileTransfer() != null &&
                this.getLogoFile().getFileTransfer().getFilename() != null &&
                !"".equals(this.getLogoFile().getFileTransfer().getFilename()) &&
                this.getLogoFile().getFilename() != null &&
                this.getLogoFile().getFilename().length() > 0)
            this.getLogoFile().upload();

        if (MetaworksContext.WHEN_NEW.equals(this.getMetaworksContext().getWhen())) {

            this.setAppId(UniqueKeyGenerator.issueWorkItemKey(((ProcessManagerBean) processManager).getTransactionContext()).intValue());
            this.setCreateDate(Calendar.getInstance().getTime());
            this.setComcode(session.getCompany().getComCode());
            this.setComName(session.getCompany().getComName());
            this.setSubDomain(this.getSubDomain());
            this.setStatus(STATUS_APPROVED);
            this.setFilename(filename);

            createDatabaseMe();
            flushDatabaseMe();

        } else {

            syncToDatabaseMe();
            flushDatabaseMe();
        }

        MyVendor myVendor = new MyVendor();
        myVendor.load(session);

        return new ModalPanel(myVendor);
    }

    @Override
    @ServiceMethod(callByContent = true)
    public Object[] addApp() throws Exception {
        downloadFromMarketplace(this.getFilename());

        AppMapping am = new AppMapping();
        am.setAppId(this.getAppId());
        am.setAppName(this.getAppName());
        am.setComCode(session.getCompany().getComCode());

        am.createDatabaseMe();
        am.flushDatabaseMe();

        return new Object[]{this.detail()};

    }

    public void uploadToMarketplace(final Resource resource) throws Exception {

        final ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);


        final Object tenantObject = resourceManager.getStorage().getObject(resource);

        TenantContext.nonTenantSpecificOperation(new Runnable() {
            @Override
            public void run() {
                try {
                    resourceManager.getStorage().save(resource, tenantObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void downloadFromMarketplace(String path) {

        final ResourceManager resourceManager = MetaworksRemoteService.getComponent(ResourceManager.class);

        final ModelResource modelResource = new ModelResource();
        modelResource.setPath(path);

        final Object[] object = new Object[1];

        TenantContext.nonTenantSpecificOperation(new Runnable() {
            @Override
            public void run() {
                try {
                    object[0] = resourceManager.getStorage().getObject(modelResource);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            resourceManager.getStorage().save(modelResource, object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
