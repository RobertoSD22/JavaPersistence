package com.platzi.dao;

import com.platzi.Conexion;
import com.platzi.dao.model.Mensajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.logging.Logger;

public class MensajesDAO {

   static Logger logger = Logger.getLogger(MensajesDAO.class.getName());

    public static void crearMensajeDB(Mensajes mensaje) {

        Conexion claseConexion = new Conexion();
        try(Connection connection = claseConexion.getConection()) {

            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?, ?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                logger.info("Mensaje creado correctamente");
            } catch (Exception e) {
                logger.severe("Error al crear mensaje: " + e);
                connection.rollback();
            } finally {
                Objects.requireNonNull(ps).close();
                connection.close();
            }
        } catch (Exception e) {
            logger.severe("Error al conectar a la base de datos: " + e);
        }
    }

    public static void leerMensajesDB() {

    }

    public static void borrarMensajeDB(int idMensaje) {

    }

    public static void actualizarMensajeDB(Mensajes mensaje) {

    }
}
