package com.mycompany.proyecto_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String url;
    private String db;
    private String user;
    private String password;
    private String driver;
    private Connection connection;

    public Conexion() {
        this.url = "jdbc:mysql://localhost:3306/";
        this.db = "HospitalSGH";
        this.user = "root";
        this.password = "RPFNDan!998";
        this.driver = "com.mysql.cj.jdbc.Driver";
    }

    public Connection conectar() throws Exception {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url + db, user, password);
            return connection;

        } catch (ClassNotFoundException ex) {
            System.out.println("Exception Class: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Exception SQL: " + ex.getMessage());
        }
        throw new Exception ("Error de Clase o SQL");
    }

    public void desconectar() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion finalizada.");
            } catch (SQLException ex) {
                System.out.println("Exception SQL: " + ex.getMessage());
            }
        }
    }
}