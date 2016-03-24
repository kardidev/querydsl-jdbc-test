package com.kardi.test.querydsl;

import com.kardi.test.querydsl.config.DatabaseProperties;
import com.querydsl.sql.SQLTemplates;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseTest {

    private static DatabaseProperties databaseProperties;

    private Connection connection;


    @BeforeClass
    public static void prepare() throws DatabaseProperties.ParseException {
        databaseProperties = DatabaseProperties.get();
    }

    @Before
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection(
                databaseProperties.getConnectionString(),
                databaseProperties.getUserName(),
                databaseProperties.getPassword());
    }

    @After
    public void tearDown() throws SQLException {
        connection.close();
    }

    protected Connection getConnection() {
        return connection;
    }

    protected SQLTemplates getSQLTemplates() {
        return databaseProperties.getDialect();
    }
}
