package org.uengine.modeling.resource.resources;

import org.uengine.essencia.common.CommitRecord;
import org.uengine.essencia.resource.Resource;

/**
 * Created by hoo.lim on 7/31/2015.
 */
public class RevResource extends Resource{
    public static RevResource createInstance(CommitRecord record){
        RevResource revResource = new RevResource();

        return  revResource;
    }
}
