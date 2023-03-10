package org.example;

import org.example.Interfaz.Interfaz;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientesSOcketStream {

    static Socket clienteSocket;

    public static void main(String[] args) {
        conexion();
        new Interfaz();
        recibirMensaje();

    }

    public static void conexion() {

        try {
            System.out.println("Creando socket cliente");
            clienteSocket = new Socket();
            System.out.println("Estableciendo la conexión");
            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            clienteSocket.connect(addr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void enviarMensaje(int opcion, String mensaje) {

        try {

            OutputStream os = clienteSocket.getOutputStream();
            DataOutputStream sos = new DataOutputStream(os);
            switch (opcion) {
                case 1 -> {
                    System.out.println("Enviando mensaje 1");
                    sos.writeInt(1);
                    sos.writeInt(Integer.parseInt(mensaje));
                }
                case 2 -> {
                    System.out.println("Enviando mensaje 2");
                    sos.writeInt(2);
                    sos.writeInt(Integer.parseInt(mensaje));
                }
                case 3 -> {
                    System.out.println("Enviando mensaje 3");
                    sos.writeInt(3);
                    sos.writeInt(Integer.parseInt(mensaje));
                }
                case 4 -> {
                    System.out.println("Enviando mensaje 4");
                    sos.writeInt(4);
                    sos.writeInt(Integer.parseInt(mensaje));
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void recibirMensaje() {

        try {
            InputStream is = clienteSocket.getInputStream();
            DataInputStream eis = new DataInputStream(is);
            while(true){
                //JOptionPane.showMessageDialog(null, eis.readUTF());
                Interfaz.etiqueta.setText(eis.readUTF());
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}