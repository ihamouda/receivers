package com.procuredox.receivers.service.storage;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

/**
 * @author maxim.krestovsky@gmail.com on 9/3/17.
 */
public class StorageProvider {

    public static class Binder extends AbstractBinder {

        private final StorageProvider storageProvider;

        Binder(String unc) {
            storageProvider = new StorageProvider(unc);
        }

        @Override
        protected void configure() {
            bindFactory(storageProvider.storageFactory).to(StorageService.class).in(Singleton.class);
        }
    }

    public static class StorageFactory implements Factory<StorageService> {

        private final StorageService service;

        public StorageFactory(StorageService service) {
            this.service = service;
        }

        @Override
        public StorageService provide() {
            return service;
        }

        @Override
        public void dispose(StorageService storageService) {
        }
    }

    public static Binder bind(String unc) {
        return new Binder(unc);
    }

    private final StorageFactory storageFactory;

    public StorageProvider(String unc) {
        this.storageFactory = new StorageFactory(new StorageServiceImpl(unc, "Sessions"));
    }
}