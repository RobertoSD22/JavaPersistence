package com.platzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Conexion {

    static Logger logger = Logger.getLogger(Conexion.class.getName());

    public Connection getConection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "sislab", "password");
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            logger.severe("Error al conectar a la base de datos: " + e);
        }
        return connection;
    }
}
