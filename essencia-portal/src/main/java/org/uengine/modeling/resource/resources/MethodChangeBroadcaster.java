package org.uengine.modeling.resource.resources;

import java.util.ArrayList;

/**
 * Created by jjy on 2016. 2. 16..
 */
public class MethodChangeBroadcaster {

 //   @Scheduled(fixedRate = 5000) //not used
    public void broadcast(){
        for(ArrayList<String> sessions : MethodResource.sessions.values()){
            if(sessions.size() > 1){ //means there are two or more connections

            }
        }
    }
}
