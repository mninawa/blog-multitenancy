package se.callista.blog.tenant_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = { LiquibaseAutoConfiguration.class })
public class TenantManagementApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TenantManagementApplication.class, args);
    }

}

