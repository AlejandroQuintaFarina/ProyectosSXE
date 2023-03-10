import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
public class ServidorSocketStream {
    public static void main(String[] args){
        try{
            System.out.println(" Creando socket servidor ");

            ServerSocket serverSocket=new ServerSocket();

            System.out.println(" Realizando el bind ");

            InetSocketAddress addr=new InetSocketAddress("localhost",5555);
            serverSocket.bind(addr);

            System.out.println(" Aceptando conexiones ");

            Socket newSocket= serverSocket.accept();

            System.out.println(" Conexión recibida ");

            InputStream is =newSocket.getInputStream();
            OutputStream os =newSocket.getOutputStream();
            DataInputStream is2 = new DataInputStream(is);
            DataOutputStream os2 = new DataOutputStream(os);

            boolean online = true;
            while (online) {

                int mensaje = is2.readInt();
                int resultado;

                System.out.println(" Esperando datos ");
                int operando = is2.readInt();

                System.out.println(" El dato recibido es " + operando );
                switch (mensaje) {

                    case 1 -> {
                        resultado = operando / 120;
                        System.out.println(" Son " + Math.abs( resultado ) + " campos de fútbol ");
                        os2.writeUTF(" Son " + Math.abs( resultado ) + " campos de fútbol ");
                    }

                    case 2 -> {
                        resultado = operando / 34;
                        System.out.println(" Son " + resultado + " libros de Reverte ");
                        os2.writeUTF(" Son " + resultado + " libros de Reverte ");
                    }

                    case 3 -> {
                        resultado = 420 - operando * 12;
                        if(resultado<=0){
                            System.out.println( " Váyase a ver las obras ");
                            os2.writeUTF( " Váyase a ver las obras ");
                        }else{
                            System.out.println("Te quedan " + resultado + " meses para jubilarte ");
                            os2.writeUTF("Te quedan " + resultado + " meses para jubilarte ");
                        }
                    }
                    case 4 -> {
                        resultado = (int) (operando - 1.397);
                        System.out.println(" La diferencia es " + Math.abs( resultado ) + " € ");
                        os2.writeUTF(" La diferencia es " + Math.abs( resultado ) + " € ");
                    }

                }
            }

            System.out.println(" Cerrando el nuevo socket ");
            newSocket.close();

            System.out.println(" Cerrando el socket servidor ");
            serverSocket.close();
            System.out.println(" Terminado ");

        }catch (IOException e) {
        }
    }
}

