/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import com.mycompany.project1.parser.operaciones.Lexer2;
import com.mycompany.project1.parser.operaciones.Parser2;
import com.mycompany.project1.tablasimbolos.Tabla;
import com.mycompany.project1.tablasimbolos.Variable;
import java.io.Reader;
import java.io.StringReader;
import javax.swing.JOptionPane;

/**
 *
 * @author jhony
 */
public class Salida extends Operacion{
    private String Mensaje;
    private String MensajeOriginal;
    private int tipo = 0;
    private OFuncion funcion;
    
    public Salida(Tabla tabla,String Mensaje,int Tipo) {
        super(TipoOperacion.SALIDA, tabla);
        this.Mensaje = Mensaje;
        this.MensajeOriginal = Mensaje;
        this.tipo = Tipo;
        if(tipo == 1) this.setTipo(TipoOperacion.ESCRIBIR);
    }
    public Salida(Tabla tabla,OFuncion funcion){
        super(TipoOperacion.SALIDA,tabla);
        this.funcion = funcion;
        this.tipo = 1;
    }
    
    
    @Override
    public void Ejecutar(){
        if(tipo == 1){
            if(funcion == null)
            Escribir();
            else EscribirconFuncion();
        }
        else Leer();
    }
    
    public String  Escribir(){
        Reader reader = new StringReader(MensajeOriginal);
        Lexer2 lexer = new Lexer2(reader);
        Parser2 parser = new Parser2(lexer,getTabla());
        try{
            Mensaje = (String) parser.parse().value;
            if(!parser.getErrores().isEmpty()) {
                    Error(parser.getErrores());
            }
        }catch(Exception e){
                e.printStackTrace();
        }
        Variable tmp = getTabla().Buscar(Mensaje);
        if(tmp == null){
            Salida(Mensaje);
            return Mensaje;
        } else{
            Salida(tmp.getValor());
            return tmp.getValor();
        }
    }
    
    public void Leer(){
        if(!Existe(Mensaje)){
            java.util.Scanner n = new java.util.Scanner(System.in);
            String Valor = JOptionPane.showInputDialog("Variable:" + Mensaje);
            OVariable tmp = new OVariable(getTabla(),2,Mensaje,Valor,2);
            tmp.Actualizar();
        }else Error("La variable: " + Mensaje  + " no existe");
    }
    
    public void EscribirconFuncion(){
        funcion.setSalida("");
        funcion.Ejecutar();
        if(!funcion.getErrores().isEmpty()) Error(funcion.getErrores());
        if(!funcion.getSalida().isEmpty() & !funcion.getRetorno().isEmpty())
        System.out.println("SALIDA: " + funcion.getSalida());
        System.out.println("RETORNO: " + funcion.getRetorno());
        setSalida("");
        Salida(funcion.getSalida() + funcion.getRetorno());
    }
    
    
    
}
