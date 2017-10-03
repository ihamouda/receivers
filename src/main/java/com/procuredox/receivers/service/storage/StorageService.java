package com.procuredox.receivers.service.storage;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author procuredox on 10/5/16.
 */
public interface StorageService {

    @Deprecated
    void save(String filename, String session, byte[] data) throws IOException;

    void save(String filename, String session, InputStream inputStream) throws  IOException;
}