package org.uengine.essencia.portal;

import org.metaworks.ServiceMethodContext;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.dao.TransactionContext;
import org.metaworks.widget.Label;
import org.metaworks.widget.Window;
import org.metaworks.widget.layout.Layout;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.admin.TopPanel;
import org.uengine.codi.mw3.model.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jangjinyoung on 2016. 6. 11..
 */
//@Component
@Scope("prototype")
public class Explorer extends SNS {

    public Explorer(){

    }

    Layout layout;
    public Layout getLayout() {
        return layout;
    }
    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    Session session;




    public void load(Session session) throws Exception {

        String preferUX = session.getEmployee().getPreferUX();
        String preferMob = session.getEmployee().getPreferMob();

        boolean pad = SNS.isPad();
        boolean phone = SNS.isPhone();
        boolean isMobile = pad || phone;


        if(isMobile && (preferMob==null || "auto".equals(preferMob)) ){
            preferMob = (pad ? "pad" : "phone");

        }

        TopPanel topPanel = new TopPanel(session);
        {

            Layout westLayout = new Layout();

            PerspectiveWindow perspectiveWindow = new PerspectiveWindow(session);

            ContentWindow contentWindow = createNewInstancePanel(session);;

            westLayout.setCenter(perspectiveWindow);
            westLayout.setUseHideBar(true);
            westLayout.setOptions("togglerLength_open:0, spacing_open:0, spacing_closed:0, south__spacing_open:5, south__size:'50%'");
            westLayout.setName("west");


            Layout eastLayout = new Layout();
            eastLayout.setWest(new ListWindow());//null list panel
            eastLayout.setCenter(contentWindow);
            eastLayout.setOptions("togglerLength_open:0, spacing_open:0, spacing_closed:0, south__spacing_open:5, west__spacing_open:5, west__size:0"); //make instance list panel invisible (size 0)
            eastLayout.setName("east");
            eastLayout.setUseHideBar(false);

            Layout outerLayout = new Layout();
            outerLayout.setOptions("togglerLength_open:0, spacing_open:0, spacing_closed:0, west__spacing_open:1, north__size:52, west__size: 100");

            outerLayout.setWest(westLayout);
            outerLayout.setCenter(eastLayout);
            outerLayout.setName("center");
            outerLayout.setUseHideBar(false);

            setLayout(outerLayout);


        }

    }


}

