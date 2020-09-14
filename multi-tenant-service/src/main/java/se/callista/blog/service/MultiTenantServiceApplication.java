package se.callista.blog.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import se.callista.blog.service.multi_tenancy.util.DynamicInstrumentationLoaderUtils;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, LiquibaseAutoConfiguration.class })
@EnableTransactionManagement
@EnableAsync
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class MultiTenantServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        DynamicInstrumentationLoaderUtils.ensureLoaded();
        SpringApplication.run(MultiTenantServiceApplication.class, args);
    }

}

