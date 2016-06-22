package org.uengine.essencia.portal;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.uengine.codi.mw3.model.NotificationBadge;

/**
 * Created by jjy on 2016. 6. 20..
 */
@Component
@Scope("prototype")
public class EssenciaNotificationBadge extends NotificationBadge{

    public EssenciaNotificationBadge(){
        super();

        setAppName("Essencia");

    }
}
