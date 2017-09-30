package com.procuredox.receivers.db.dao;


import com.procuredox.receivers.db.model.DocumentXPaths;

/**
 * @author procuredox on 9/18/16.
 */
public interface DocumentDao {

    DocumentXPaths loadPaths(String secKey, String rootElement);

}
