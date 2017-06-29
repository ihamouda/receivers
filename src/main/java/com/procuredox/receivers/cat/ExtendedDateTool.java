package com.procuredox.receivers.cat;

import org.apache.velocity.tools.generic.DateTool;

import java.util.Date;

/**
 * @author maxim.krestovsky@gmail.com on 6/28/17.
 */
public class ExtendedDateTool extends DateTool {

    public Date epochToDate(String millisec) {
        return new Date(Long.parseLong(millisec));
    }

}