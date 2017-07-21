package com.procuredox.receivers;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ihamouda on 2017-06-21.
 */
@ApplicationPath("/")
public class ApiApplication extends ResourceConfig {
    public ApiApplication(){
        register(ApiResources.class);
        register(new LoggingFeature(Logger.getLogger("InOut"), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, Integer.MAX_VALUE-1));
    }
}
