package com.procuredox.receivers.service.storage;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author procuredox on 10/5/16.
 */
public class StorageServiceImpl implements StorageService {
    private static final Logger log = LoggerFactory.getLogger(StorageServiceImpl.class);

    private final String basePath;
    private final String sessionPath;

    public StorageServiceImpl(String basePath, String sessionPath) {
        this.basePath = basePath;
        this.sessionPath = sessionPath;
    }

    @Override
    public void save(String filename, String session, byte[] data) throws IOException {
        final String path = createDirectory(sessionPath(session));
        final File document = new File(path, filename);
        FileUtils.writeByteArrayToFile(document, data);
    }

    @Override
    public void save(String filename, String session, InputStream inputStream) throws IOException {
        final String path = createDirectory(sessionPath(session));
        final File document = new File(path, filename);
        try (final FileOutputStream outputStream = FileUtils.openOutputStream(document)) {
            IOUtils.copy(inputStream, outputStream);
        }
    }

    private String createDirectory(String path) {
        final File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return path;
    }

    private String sessionPath(String session) {
        return basePath + "/" + sessionPath + "/" + session;
    }
}
