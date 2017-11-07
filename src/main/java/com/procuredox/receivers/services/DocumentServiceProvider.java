package com.procuredox.receivers.services;

import com.procuredox.receivers.db.dao.BatchNumberDao;
import com.procuredox.receivers.db.dao.DocumentDao;
import com.procuredox.receivers.db.dao.PartnerDao;
import com.procuredox.receivers.service.storage.StorageService;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

/**
 * @author maxim.krestovsky@gmail.com on 10/6/17.
 */
public class DocumentServiceProvider {

    public static class Binder extends AbstractBinder {

        private final DocumentServiceProvider documentServiceProvider;

        Binder(PartnerDao partnerDao, DocumentDao documentDao, BatchNumberDao batchNumberDao) {
            documentServiceProvider = new DocumentServiceProvider(partnerDao, documentDao, batchNumberDao);
        }

        @Override
        protected void configure() {
            bindFactory(documentServiceProvider.documentServiceFactory).to(StorageService.class).in(Singleton.class);
        }
    }

    public static class DocumentServiceFactory implements Factory<DocumentService> {

        private final DocumentService service;

        public DocumentServiceFactory(DocumentService service) {
            this.service = service;
        }

        @Override
        public DocumentService provide() {
            return service;
        }

        @Override
        public void dispose(DocumentService documentService) {
        }
    }

    public static DocumentServiceProvider.Binder bind(PartnerDao partnerDao, DocumentDao documentDao, BatchNumberDao batchNumberDao) {
        return new DocumentServiceProvider.Binder(partnerDao, documentDao, batchNumberDao);
    }

    private final DocumentServiceProvider.DocumentServiceFactory documentServiceFactory;

    public DocumentServiceProvider(PartnerDao partnerDao, DocumentDao documentDao, BatchNumberDao batchNumberDao) {
        this.documentServiceFactory = new DocumentServiceProvider.DocumentServiceFactory(new DocumentServiceImpl(partnerDao, documentDao, batchNumberDao));
    }
}