package com.kardi.test.querydsl.config;

import com.querydsl.sql.SQLTemplates;

import java.util.ResourceBundle;

public class DatabaseProperties {

    private static final String DEFAULT_RESOURCE_NAME = "db";
    private static final String JDBC_DRIVER = "jdbc.driver";
    private static final String JDBC_URL = "jdbc.url";
    private static final String JDBC_USER = "jdbc.user";
    private static final String JDBC_PASSWORD = "jdbc.password";
    private static final String QUERYDSL_DIALECT = "querydsl.dialect";

    public static DatabaseProperties get() throws ParseException {
        DatabaseProperties databaseProperties = new DatabaseProperties();
        databaseProperties.parseProperties(DEFAULT_RESOURCE_NAME);
        return databaseProperties;
    }

    public static DatabaseProperties get(String resourceName) throws ParseException {
        DatabaseProperties databaseProperties = new DatabaseProperties();
        databaseProperties.parseProperties(resourceName);
        return databaseProperties;
    }

    private Class jdbcDriver;
    private String connectionString;
    private String userName;
    private String password;
    private SQLTemplates dialect;

    private DatabaseProperties() {
    }

    public Class getJdbcDriver() {
        return jdbcDriver;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public SQLTemplates getDialect() {
        return dialect;
    }

    private void parseProperties(String resource) throws ParseException {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(resource);
            jdbcDriver = Class.forName(resourceBundle.getString(JDBC_DRIVER));
            connectionString = resourceBundle.getString(JDBC_URL);
            userName = resourceBundle.getString(JDBC_USER);
            password = resourceBundle.getString(JDBC_PASSWORD);
            dialect = (SQLTemplates) Class.forName(resourceBundle.getString(QUERYDSL_DIALECT)).newInstance();
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    public static class ParseException extends Exception {
        private ParseException(Exception cause) {
            super(cause);
        }
    }
}
