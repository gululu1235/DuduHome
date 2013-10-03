package com.duduhome.simpleweb;

import com.yammer.metrics.core.HealthCheck;

public class SimpleWebHealthCheck extends HealthCheck{
    protected SimpleWebHealthCheck(String name) {
        super(name);
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
