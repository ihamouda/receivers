package com.procuredox.receivers.db.model;

/**
 * @author procuredox on 9/18/16.
 */
public class BatchedProperties {

    private int batchNumber;
    private DocumentXPaths paths;

    public BatchedProperties(int batchNumber, DocumentXPaths paths) {
        this.batchNumber = batchNumber;
        this.paths = paths;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public DocumentXPaths getPaths() {
        return paths;
    }

    public void setPaths(DocumentXPaths paths) {
        this.paths = paths;
    }
}
