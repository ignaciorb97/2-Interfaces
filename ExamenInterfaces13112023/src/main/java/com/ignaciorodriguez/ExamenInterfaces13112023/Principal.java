package com.ignaciorodriguez.ExamenInterfaces13112023;

import java.awt.BorderLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {

    public static void main(String[] args) {
    	
    	
    	JFrame ventanaLogin=new JFrame();
    	ventanaLogin.setTitle("Log In");
    	ventanaLogin.setBounds(10, 20, 400, 300);
    	ventanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	ventanaLogin.setVisible(true);
    	
    	TextArea usuario=new TextArea();
    	usuario.setBounds(120, 100, 30, 30);
    	TextArea contraseña=new TextArea();
    	contraseña.setBounds(120, 120, 30, 30);
    	
    	JPanel panelLoguin = new JPanel();
        panelLoguin.setLayout(null);
        
    	
    	panelLoguin.add(usuario);
    	panelLoguin.add(contraseña);
    	
    	JButton entrar =new JButton("Entrar");
    	entrar.setBounds(200, 280, 30, 30);
    	ventanaLogin.add(panelLoguin);
    	
    	SwingUtilities.invokeLater(()-> {
        JFrame ventanaPrincipal = new JFrame();
        ventanaPrincipal.setTitle("Examen Práctico");
        ventanaPrincipal.setBounds(10, 20, 400, 300);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel botonPanel = new JPanel();
        botonPanel.setLayout(new BorderLayout());

        JPanel panelNorte = new JPanel();
        JPanel panelSur = new JPanel();

        for (byte i = 0; i < 3; i++) {
            JButton botonButton = new JButton("Boton " + i);
            
            botonButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                	String textoBoton = ((JButton) e.getSource()).getText(); // Con esto extraemos el nombre del boton
//                	if(textoBoton.equals("Boton 0")) {
//                    	configurarBoton(botonPanel);
//                    	}
//                    
                	configurarBoton(botonPanel);
                }
            });
         ;
            panelSur.add(botonButton);
        }
        for (byte i = 0; i < 3; i++) {
            JButton botonButton = new JButton("Boton " + i);
            
            botonButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                	String textoBoton = ((JButton) e.getSource()).getText(); // Con esto extraemos el nombre del boton
//                	if(textoBoton.equals("Boton 0")) {
//                    	configurarBoton(botonPanel);
//                    	}
//                    
                	configurarBoton(botonPanel);
                }
            });
         ;
            panelNorte.add(botonButton);
        }
        botonPanel.add(panelSur, BorderLayout.SOUTH);
        botonPanel.add(panelNorte, BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu botones = new JMenu("Botones");

        for (byte i = 0; i < 6; i++) {
            JMenuItem item = new JMenuItem("Item " + i);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String textoItem = ((JMenuItem) e.getSource()).getText();
                    procesarBoton("Has abierto " + textoItem);
                }
            });
            botones.add(item);
        }

        menuBar.add(botones);
        ventanaPrincipal.setJMenuBar(menuBar);
        ventanaPrincipal.add(botonPanel);
        ventanaPrincipal.setVisible(true);
    });}

    public static void procesarBoton(String mensaje) {
        JFrame ventanaFrame = new JFrame();
        ventanaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaFrame.setLocationRelativeTo(null);
        ventanaFrame.setBounds(10, 20, 400, 300);
        JPanel panelInterno = new JPanel();
        JLabel textoAbierto = new JLabel(mensaje);
        JButton cerrar=new JButton("cerrar");
        cerrar.setBounds(0, 0, 10, 10);
        cerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ventanaFrame.dispose();
			}
		});
        panelInterno.add(textoAbierto);
        ventanaFrame.add(panelInterno);
        panelInterno.add(cerrar);
        ventanaFrame.setVisible(true);
    }
    public static void configurarBoton(JPanel botonPanel) {
    	botonPanel.setBackground(Color.getHSBColor(135, 206, 250));
    	botonPanel.setForeground(Color.black);
    }
   
    
}

