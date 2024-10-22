package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private final String url;
    private final String user;
    private final String password;
    private Connection connection;

    public DatabaseConfig(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        if (this.connection == null) {
            this.connection = DriverManager.getConnection(url, user, password);
            return this.connection;
        }
        return this.connection;
    }
}
