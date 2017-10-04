package com.procuredox.receivers;

import com.procuredox.receivers.resource.vendor.in.DocumentResource;
import com.procuredox.receivers.service.storage.StorageProvider;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ihamouda on 2017-06-21.
 */
@ApplicationPath("/")
public class ApiApplication extends ResourceConfig {
    private static final int MB_5 = 1024 * 1024 * 5;

    public ApiApplication(@Context ServletContext servletContext) {
        final String unc = (String) servletContext.getAttribute("unc");
        register(StorageProvider.bind(unc));
        register(ApiResources.class);
        register(DocumentResource.class);
        register(new LoggingFeature(Logger.getLogger("InOut"), Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, MB_5));
    }
}
