package com.procuredox.receivers.resource.vendor.in;

import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author procuredox on 9/18/16.
 */
public class Utils {

    public static <T> Response restOk(T response) {
        return Response.ok()
                .entity(response)
                .build();
    }

    public static <T> Response restFail(int code, T response) {
        return Response.status(code)
                .entity(response)
                .build();
    }

    public static String currentTime() {
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return df.format(new Date());
    }

    /** given from commons-lang3 */

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T str, T defaultStr) {
        return isEmpty(str)?defaultStr:str;
    }
}
