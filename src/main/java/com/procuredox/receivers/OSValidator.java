package com.procuredox.receivers;

/**
 * Created by ihamouda on 2017-06-21.
 */
public class OSValidator {
    private String OS = System.getProperty("os.name").toLowerCase();

    public static  OSValidator instance = new OSValidator();

    public static OSValidator getInstance(){
        return instance;
    }

    private OSValidator(){}


    public boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }

    public  boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    public boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

    }

    public boolean isSolaris() {

        return (OS.indexOf("sunos") >= 0);

    }
}
