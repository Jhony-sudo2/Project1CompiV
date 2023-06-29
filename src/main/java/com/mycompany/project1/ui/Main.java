/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.project1.ui;

import com.mycompany.project1.operaciones.Operacion;
import com.mycompany.project1.parser.Lexer;
import com.mycompany.project1.parser.Manejador;
import com.mycompany.project1.parser.Parser;
import java.awt.Color;
import java.awt.Font;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author jhony
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    private javax.swing.JTextArea Lineas;
    private Parser parser;
    public Main() {
        initComponents();
        Lineas = new javax.swing.JTextArea("1");
        Lineas.setFont(new Font("Monospaced", Font.PLAIN, 14));
        Lineas.setBackground(Color.GRAY);
        Lineas.setEditable(false);
        //Lineas.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.DARK_GRAY));
        Entrada.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                actualizarNumerosDeLinea();
            }

            public void removeUpdate(DocumentEvent e) {
                actualizarNumerosDeLinea();
            }

            public void changedUpdate(DocumentEvent e) {
                actualizarNumerosDeLinea();
            }
        });

        Scroll.setRowHeaderView(Lineas);
        
    }
    private void actualizarNumerosDeLinea() {
        String texto = Entrada.getText();
        int lineas = texto.isEmpty() ? 1 : texto.split("\n", -1).length;
        StringBuilder numerosDeLinea = new StringBuilder();
        for (int i = 1; i <= lineas; i++) {
            numerosDeLinea.append(i).append("\n");
        }
        Lineas.setText(numerosDeLinea.toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Scroll = new javax.swing.JScrollPane();
        Entrada = new javax.swing.JTextArea();
        Compile = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Salida = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Entrada.setColumns(20);
        Entrada.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Entrada.setRows(5);
        Scroll.setViewportView(Entrada);

        Compile.setText("Ejecutar");
        Compile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompileActionPerformed(evt);
            }
        });

        Salida.setEditable(false);
        Salida.setColumns(20);
        Salida.setRows(5);
        jScrollPane2.setViewportView(Salida);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Scroll)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addComponent(Compile, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Compile)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CompileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompileActionPerformed
        if(!Entrada.getText().isEmpty()){
            Reader reader = new StringReader(Entrada.getText());
            Lexer lexer = new Lexer(reader); 
            parser = new Parser(lexer);
            ArrayList<Operacion> Lista;
            Manejador m = new Manejador();
            try{
                Lista = (ArrayList<Operacion>) parser.parse().value;
                m.EjecutarSalidas(Lista);
                parser.getM().Error(lexer.getErrores());
                Salida.setText("");
                Salida.setText(m.getMensaje() + parser.getSalida());

            }catch(Exception e){
                parser.getM().Error(lexer.getErrores());
                Salida.setText("");
                Salida.setText(m.getMensaje() + parser.getSalida());

            }
        }else JOptionPane.showMessageDialog(this, "Entrada vacia","Error",1);
    }//GEN-LAST:event_CompileActionPerformed
    
    public void Leer(){
        JOptionPane.showMessageDialog(this, "INGRESE LA VARIABLE");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Compile;
    private javax.swing.JTextArea Entrada;
    private javax.swing.JTextArea Salida;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
