package be.gfi.academy.dao;

import be.gfi.academy.ConnectionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DbHealthTest extends AbstractJdbcTest {

    @Test
    public void dbHealth() throws SQLException {
        Connection conn = ConnectionFactory.INSTANCE.getConnection();
        conn.close();
    }
}
