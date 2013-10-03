package com.duduhome.simpleweb;

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
        environment.addResource(new SimpleWebApiResources(simpleWebServiceConfiguration.getHeadline()));
        environment.addHealthCheck(new SimpleWebHealthCheck("simple-web"));
    }

    public static void main(String[] args) throws Exception {
        new SimpleWebService().run(args);
    }
}
