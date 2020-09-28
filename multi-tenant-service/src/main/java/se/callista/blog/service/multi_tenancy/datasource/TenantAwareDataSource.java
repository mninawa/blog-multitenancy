package se.callista.blog.service.multi_tenancy.datasource;

import org.springframework.jdbc.datasource.DelegatingDataSource;
import se.callista.blog.service.multi_tenancy.util.TenantContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TenantAwareDataSource extends DelegatingDataSource {

    public TenantAwareDataSource(DataSource targetDataSource) {
        super(targetDataSource);
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = getTargetDataSource().getConnection();
        setTenantId(connection);
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Connection connection = getTargetDataSource().getConnection(username, password);
        setTenantId(connection);
        return connection;
    }

    private void setTenantId(Connection connection) throws SQLException {
        try (Statement sql = connection.createStatement()) {
            String tenantId = TenantContext.getTenantId();
            sql.execute("SET app.tenant_id = '" + tenantId + "'");
        }
    }
}
