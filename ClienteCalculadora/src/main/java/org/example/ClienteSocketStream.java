package org.example;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteSocketStream {
    static Socket clienteSocketStream;
        public static void main(String[] args) {
        conexion();
        new Interfaz();
        recibirDatos();
    }

    //Método para conectar con el servidor
    public static void conexion() {

        try {
            System.out.println("Creando socket cliente");
            clienteSocketStream = new Socket();
            System.out.println("Estableciendo la conexión");
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            clienteSocketStream.connect(addr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Enviamos los datos al servidor
    public static void enviarDatos (int casos, String mensaje) {

        try {
            OutputStream os = clienteSocketStream.getOutputStream();
            DataOutputStream os2 = new DataOutputStream(os);
            switch (casos) {
                case 1 -> {
                    System.out.println(" Mensaje Tiki-Taka ");
                    os2.writeInt(1);
                    os2.writeInt(Integer.parseInt(mensaje));
                }
                case 2 -> {
                    System.out.println(" Mensaje Reverte ");
                    os2.writeInt(2);
                    os2.writeInt(Integer.parseInt(mensaje));
                }
                case 3 -> {
                    System.out.println(" Mensaje jubilación ");
                    os2.writeInt(3);
                    os2.writeInt(Integer.parseInt(mensaje));
                }
                case 4 -> {
                    System.out.println(" Mensaje gasolina ");
                    os2.writeInt(4);
                    os2.writeInt(Integer.parseInt(mensaje));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Recibimos los resultados de la operaciones realizadas en el servidor
    public static void recibirDatos() {

        try {
            InputStream is = clienteSocketStream.getInputStream();
            DataInputStream is2 = new DataInputStream(is);
            while(true){
                Interfaz.respuesta.setText(is2.readUTF());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

