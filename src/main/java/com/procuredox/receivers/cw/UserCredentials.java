package com.procuredox.receivers.cw;

/**
 * Created by ihamouda on 2017-06-26.
 */
public class UserCredentials {
    private int cwid;
    private int uid;

    public UserCredentials(int cwid, int uid) {
        this.cwid = cwid;
        this.uid = uid;
    }

    public UserCredentials() {
    }

    public int getCwid() {
        return cwid;
    }

    public void setCwid(int cwid) {
        this.cwid = cwid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
