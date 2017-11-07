package com.procuredox.receivers.services;

import com.procuredox.receivers.db.dao.BatchNumberDao;
import com.procuredox.receivers.db.dao.DocumentDao;
import com.procuredox.receivers.db.dao.PartnerDao;
import com.procuredox.receivers.db.model.BatchedProperties;
import com.procuredox.receivers.db.model.DocumentXPaths;

import java.util.Objects;

/**
 * @author procuredox on 9/18/16.
 */
public class DocumentServiceImpl implements DocumentService {

    private PartnerDao partnerDao;
    private DocumentDao documentDao;
    private BatchNumberDao batchNumberDao;

    DocumentServiceImpl(PartnerDao partnerDao, DocumentDao documentDao, BatchNumberDao batchNumberDao) {
        this.partnerDao = partnerDao;
        this.documentDao = documentDao;
        this.batchNumberDao = batchNumberDao;
    }

    @Override
    public BatchedProperties find(String secKey, String rootName) {
        final String partner = partnerDao.findPartnerBySecKey(secKey);
        if (Objects.isNull(partner)) {
            throw new NotAuthorized();
        }

        final DocumentXPaths paths = documentDao.loadPaths(secKey, rootName);
        if (Objects.isNull(paths)) {
            throw new KeyDocNotValid();
        }

        return new BatchedProperties(batchNumberDao.next(), paths);
    }

    public void setPartnerDao(PartnerDao partnerDao) {
        this.partnerDao = partnerDao;
    }

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    public void setBatchNumberDao(BatchNumberDao batchNumberDao) {
        this.batchNumberDao = batchNumberDao;
    }
}