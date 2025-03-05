package com.platzi.service;

import com.platzi.dao.MensajesDAO;
import com.platzi.dao.model.Mensajes;

import java.util.Scanner;

public class MensajesService {

    public static void crearMensaje() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Tu nombre");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutorMensaje(nombre);

        MensajesDAO.crearMensajeDB(registro);
    }

    public static void listarMensajes() {
        MensajesDAO.leerMensajesDB();
    }

    public static void borrarMensaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el ID del mensaje a borrar");
        String mensaje = sc.nextLine();

        MensajesDAO.borrarMensajeDB(Integer.parseInt(mensaje));
    }

    public static void editarMensaje() {

    }
}
