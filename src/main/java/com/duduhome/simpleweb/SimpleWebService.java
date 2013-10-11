package com.duduhome.simpleweb;

import com.duduhome.simpleweb.data.NoteDao;
import com.duduhome.simpleweb.data.NoteDaoMySQLImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class SimpleWebService extends Service<SimpleWebServiceConfiguration> {

    @Override
    public void initialize(Bootstrap<SimpleWebServiceConfiguration> bootstrap) {
        bootstrap.setName("simple-web");
        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }

    @Override
    public void run(SimpleWebServiceConfiguration simpleWebServiceConfiguration, Environment environment) throws Exception {
        final Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(NoteDao.class).toInstance(new NoteDaoMySQLImpl("root", "1234", "localhost:3306", "simpleweb", "notes"));
            }
        });
        environment.addResource(injector.getInstance(SimpleWebApiResources.class));
        environment.manage(injector.getInstance(NoteDao.class));
        environment.addHealthCheck(new SimpleWebHealthCheck("simple-web"));
    }

    public static void main(String[] args) throws Exception {
        new SimpleWebService().run(args);
    }
}
