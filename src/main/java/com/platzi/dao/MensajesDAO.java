package com.platzi.dao;

import com.platzi.Conexion;
import com.platzi.dao.model.Mensajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        Conexion claseConexion = new Conexion();
        try(Connection connection = claseConexion.getConection()) {

            PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                String query = "SELECT * FROM mensajes";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("Mensaje: " + rs.getString("mensaje"));
                    System.out.println("Autor: " + rs.getString("autor_mensaje"));
                    System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                    System.out.println();
                }
            } catch (Exception e) {
                logger.severe("Error al leer mensajes: " + e);
            } finally {
                Objects.requireNonNull(rs).close();
                Objects.requireNonNull(ps).close();
                connection.close();
            }

        } catch (Exception e) {
            logger.severe("Error al conectar a la base de datos: " + e);
        }
    }

    public static void borrarMensajeDB(int idMensaje) {

        Conexion claseConexion = new Conexion();
        try(Connection connection = claseConexion.getConection()) {

            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                logger.info("Mensaje eliminado correctamente");
            } catch (Exception e) {
                logger.severe("Error al borrar mensaje: " + e);
                connection.rollback();
            } finally {
                Objects.requireNonNull(ps).close();
                connection.close();
            }
        } catch (Exception e) {
            logger.severe("Error al conectar a la base de datos: " + e);

        }
    }

    public static void actualizarMensajeDB(Mensajes mensaje) {

        Conexion claseConexion = new Conexion();
        try(Connection connection = claseConexion.getConection()) {

            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET mensaje = ?, fecha_mensaje = CURRENT_TIMESTAMP WHERE id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getIdMensaje());
                ps.executeUpdate();
                logger.info("Mensaje actualizado correctamente");
            } catch (Exception e) {
                logger.severe("Error al actualizar mensaje: " + e);
                connection.rollback();
            } finally {
                Objects.requireNonNull(ps).close();
                connection.close();
            }
        } catch (Exception e) {
            logger.severe("Error al conectar a la base de datos: " + e);
        }
    }
}
