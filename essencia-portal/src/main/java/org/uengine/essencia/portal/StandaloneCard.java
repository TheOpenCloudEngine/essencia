package org.uengine.essencia.portal;

import org.metaworks.annotation.ServiceMethod;
import org.uengine.codi.mw3.model.Session;
import org.uengine.codi.mw3.model.User;
import org.uengine.essencia.enactment.handler.EssenceActivityHandler;

/**
 * Created by jjy on 2016. 2. 2..
 */
public class StandaloneCard {

    String cardName;
    String instanceId;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }


    String token;
        public String getToken() {
            return token;
        }
        public void setToken(String token) {
            this.token = token;
        }



    EssenceActivityHandler essenceActivityHandler;
        public EssenceActivityHandler getEssenceActivityHandler() {
            return essenceActivityHandler;
        }
        public void setEssenceActivityHandler(EssenceActivityHandler essenceActivityHandler) {
            this.essenceActivityHandler = essenceActivityHandler;
        }


    @ServiceMethod
    public void load() throws Exception {
        setCardName("Test!!!!");

        parseToken(getToken());

        Session session = new Session();
        session.setUser(new User());
        String emailAddress = null; //obtain from token.
        session.getUser().setEmail(emailAddress);

        EssenceActivityHandler essenceActivityHandler1 = new EssenceActivityHandler();
        essenceActivityHandler1.setInstanceId(getInstanceId());
        essenceActivityHandler1.setTracingTag("1");
        essenceActivityHandler1.setTaskId(665l);

        essenceActivityHandler1.session = session;


        essenceActivityHandler1.load(); //NPE ... session 없다고...

    }

    private void parseToken(String token) {

    }
}
