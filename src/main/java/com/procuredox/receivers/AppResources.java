package com.procuredox.receivers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by ihamouda on 2017-06-21.
 */
public class AppResources {
    private static AppResources instance = new AppResources();
    private static OSValidator os = OSValidator.getInstance();
    //for Phoenix
    //private ResourceBundle rb = ResourceBundle.getBundle("com.procuredox.adapi.resources", Locale.US);

    //for demo
    private static ResourceBundle rb;

    private AppResources() {
    }

    public static AppResources getInstance() {
        //for demo
        try {
            File file = null;
            if(os.isWindows())
                file = new File("C:/Apps/Resources");
            else if(os.isUnix())
                file = new File("~/workdata");
            URL[] urls = {file.toURI().toURL()};
            ClassLoader loader = new URLClassLoader(urls);
            rb = ResourceBundle.getBundle("adApi", Locale.US,loader);
            return instance;
        }catch (MalformedURLException e){
            return null;
        }

    }

    public ResourceBundle getRb() {
        return rb;
    }
}
