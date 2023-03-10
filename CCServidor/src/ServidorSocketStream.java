import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Arrays;

public class ServidorSocketStream {

    public static void main(String[] args) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket = serverSocket.accept();

            System.out.println("Conexión recibida");

            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();
            DataInputStream eis = new DataInputStream(is);
            DataOutputStream sos = new DataOutputStream(os);
            boolean conectado = true;
            while (conectado) {
                int mensaje = eis.readInt();
                int resultado;
                System.out.println("Esperando al 1er numero...");
                int operando = eis.readInt();
                System.out.println("El numero recibido es: " + operando);
                switch (mensaje) {
                    case 1 -> {
                        resultado = operando / 34;
                        System.out.println("El resultado es : " + resultado + " libros de Pérez-Reverte");
                        sos.writeUTF("El resultado es : " + resultado + " libros de Pérez-Reverte");
                    }
                    case 2 -> {
                        resultado = operando / 120;
                        System.out.println("El resultado es : " + Math.abs(resultado) + " campos de fútbol");
                        sos.writeUTF("El resultado es : " + Math.abs(resultado) + " campos de fútbol");
                    }
                    case 3 -> {
                        resultado = 420 - operando * 12;
                        if(resultado<=0){
                            System.out.println(resultado + " Jubiladísimo");
                            sos.writeUTF(resultado + " Jubiladísimo");
                        }else{
                            System.out.println("Te quedan " + resultado + " meses para llegar a la jubilación completa");
                            sos.writeUTF("Te quedan " + resultado + " meses para llegar a la jubilación completa");
                        }
                    }
                    case 4 -> {
                        resultado = (int) (operando - 1.397);
                        System.out.println("La diferencia es de : " + Math.abs(resultado) + " €");
                        sos.writeUTF("La diferencia es de : " + Math.abs(resultado) + " €");
                    }
                    case 5 -> {
                        conectado = false;
                    }
                }
            }

            System.out.println("Cerrando el nuevo socket");
            newSocket.close();
            System.out.println("Cerrando el socket servidor");
            serverSocket.close();
            System.out.println("Terminado");


        } catch (IOException ignored) {
        }
    }
}
