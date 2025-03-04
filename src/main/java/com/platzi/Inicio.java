package com.platzi;

import java.sql.Connection;

public class Inicio {

    public static void main(String[] args) {
        Connection connection = null;
        Conexion claseConexion = new Conexion();
        connection = claseConexion.getConection();
        System.out.println(connection);
    }
}
