package org.example.Interfaz;

import org.example.ClientesSOcketStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz extends JFrame {
    private JButton btnPerezR, btnFurbo, btnJubilacion, btnGasofa;
    JTextField editor;
     public static JLabel  etiqueta, titulo;
    JFrame frameMenu = new JFrame();

    public Interfaz() {

        titulo = new JLabel();
        titulo.setBounds(25, 30, 435, 70);
        titulo.setVisible(true);
        titulo.setIcon(new ImageIcon("pedrerol.png"));


        etiqueta = new JLabel();
        etiqueta.setBounds(25, 15, 435, 200);
        etiqueta.setToolTipText("Aqui va el resultado");
        etiqueta.setVisible(true);
        etiqueta.setBackground(Color.PINK);
        etiqueta.setIcon(new ImageIcon("pedrerol.jpg"));
        etiqueta.setIconTextGap(10);
        //etiqueta.setText(ClientesSOcketStream.recibirMensaje());



        editor = new JTextField("Escribe un numero"); //Incilaizamos el editorPane
        editor.setBounds(25, 200, 435, 30);
        editor.setEditable(true); //Habilitamos la edicion
        editor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                editor.setText("");
            }
            public void mouseReleased(MouseEvent e){
                super.mouseClicked(e);
                editor.setText("Escribe un número");
            }
        });
        //editor.setText(""); // Insertamos texto
        editor.setToolTipText("Escribe un número");


        btnPerezR = new JButton("Perez Reverte");
        btnPerezR.setBounds(25, 250, 120, 50);
        btnPerezR.getName();
        btnPerezR.setToolTipText("Calcula cuantos libros te quedan para alcanzar al maestro Perez Reverte!!");
        btnPerezR.addActionListener(e -> ClientesSOcketStream.enviarMensaje(1, editor.getText()));

        btnFurbo = new JButton("Furbol");
        btnFurbo.setBounds(150, 250, 100, 50);
        btnFurbo.setToolTipText("La medida que pongas en campos de futbol");
        btnFurbo.addActionListener(e -> {
            //JOptionPane.showMessageDialog(null, "Conectando");
            ClientesSOcketStream.enviarMensaje(2, editor.getText());
        });

        btnJubilacion = new JButton("Jubilacion");
        btnJubilacion.setBounds(255, 250, 100, 50);
        btnJubilacion.setToolTipText("Calcula" +
                " los meses que te quedan para jubilarte");
        btnJubilacion.addActionListener(e -> ClientesSOcketStream.enviarMensaje(3, editor.getText()));

        btnGasofa = new JButton("Gasolina");
        btnGasofa.setBounds(360, 250, 100, 50);
        btnGasofa.setToolTipText("Calcula la diferencia con la gasolina mas barata");
        btnGasofa.addActionListener(e -> ClientesSOcketStream.enviarMensaje(4, editor.getText()));


        /*
         * Asignamos titulo a la ventana
         * */
        frameMenu.setTitle(" Calculadora Cuñada ");
        /*
         * creamos un panel y le añadimos los botones
         * */
        JPanel panelMenu = new JPanel();
        panelMenu.setOpaque(false);
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 485, 400);

        panelMenu.add(btnPerezR);
        panelMenu.add(btnFurbo);
        panelMenu.add(btnJubilacion);
        panelMenu.add(btnGasofa);
        panelMenu.add(editor);
        panelMenu.add(etiqueta);
        panelMenu.add(titulo);

        /*
         * Dentro de la venatana de inicio de menu colocamos los botones
         * a final de pagina.
         * */
        frameMenu.add(panelMenu);
        /*
         *  Asignamos tamaño de la ventana
         * */
        frameMenu.setSize(485, 400);
        /*
         *  Centra la ventana al medio de la pantalla
         * */
        frameMenu.setLocationRelativeTo(null);
        frameMenu.setVisible(true);
        frameMenu.setResizable(false);
        frameMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
