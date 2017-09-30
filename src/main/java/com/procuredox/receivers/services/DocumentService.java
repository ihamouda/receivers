package com.procuredox.receivers.services;

import com.procuredox.receivers.db.model.BatchedProperties;

/**
 * @author procuredox on 9/18/16.
 */
public interface DocumentService {

    BatchedProperties find(String secKey, String rootName);

}