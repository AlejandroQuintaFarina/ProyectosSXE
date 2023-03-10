package org.example;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interfaz extends JFrame {
    private JButton btnJogoBonito, btnReverte, btnJubilacion, btnGasolina;
    JTextField editor;
    public static JLabel respuesta;
    JFrame frameMenu = new JFrame();

    public Interfaz() {

        //esto es donde sale la respuesta de la calculadora
        respuesta = new JLabel();
        respuesta.setBounds(25, 5, 250, 50);
        respuesta.setVisible(true);
        respuesta.setIconTextGap(35);

        editor = new JTextField(" Introduce una cifra ");
        editor.setBounds(25, 60, 450, 40);
        editor.setEditable(true);
        editor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
            public void mouseReleased(MouseEvent e){
                super.mouseClicked(e);
                editor.setText(" Introduce una cifra ");
            }
        });

        //Creamos los botones

        btnJogoBonito = new JButton(" Tiki-Taka ");
        btnJogoBonito.setBounds(25, 125, 100, 50);
        btnJogoBonito.addActionListener(e -> ClienteSocketStream.enviarDatos(1, editor.getText()));

        btnReverte = new JButton(" Reverte ");
        btnReverte.setBounds(140, 125, 100, 50);
        btnReverte.getName();
        btnReverte.addActionListener(e -> ClienteSocketStream.enviarDatos(2, editor.getText()));

        btnJubilacion = new JButton(" Jubilacion ");
        btnJubilacion.setBounds(255, 125, 100, 50);
        btnJubilacion.addActionListener(e -> ClienteSocketStream.enviarDatos(3, editor.getText()));

        btnGasolina = new JButton(" Gasolina ");
        btnGasolina.setBounds(373, 125, 100, 50);
        btnGasolina.addActionListener(e -> ClienteSocketStream.enviarDatos(4, editor.getText()));


        //Título para la ventana
        frameMenu.setTitle(" Calculadora del cuñado ");

        //Creamos el panel y le ponemos los botones
        JPanel panelMenu = new JPanel();
        panelMenu.setOpaque(false);
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 500, 225);

        panelMenu.add(editor);
        panelMenu.add(respuesta);
        panelMenu.add(btnReverte);
        panelMenu.add(btnJogoBonito);
        panelMenu.add(btnJubilacion);
        panelMenu.add(btnGasolina);

        frameMenu.add(panelMenu);

        //Tamaño de la ventana
        frameMenu.setSize(500, 225);

        //Centrar la ventana
        frameMenu.setLocationRelativeTo(null);
        frameMenu.setVisible(true);
        frameMenu.setResizable(false);
        frameMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
