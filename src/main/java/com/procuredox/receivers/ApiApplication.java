package com.procuredox.receivers;

import com.procuredox.receivers.resource.vendor.in.DocumentResource;
import com.procuredox.receivers.service.storage.StorageProvider;
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

    public static final int MB_5 = 1024 * 1024 * 5;

    public ApiApplication(){
        register(StorageProvider.bind(AppResources.getInstance().getRb().getString("unc")));
        register(ApiResources.class);
        register(DocumentResource.class);
        register(new LoggingFeature(Logger.getLogger("InOut"), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, MB_5));
    }
}
