/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.parser;

/**
 *
 * @author jhony
 */
public class Operacion2 {
    private int Tipo;
    private String Mensaje;
    private String Valor;
    private Operacion2 Op;
    
    public Operacion2(int Tipo, String Mensaje) {
        this.Tipo = Tipo;
        this.Mensaje = Mensaje;
    }
    
    public Operacion2(int Tipo,String Variable,String Valor){
        this.Tipo = Tipo;
        this.Mensaje = Variable;
        this.Valor = Valor;
    }
    
    public Operacion2(Operacion2 p,String Caso){
        this.Op = p;
        this.Valor = Caso;
    }

    public int getTipo() {
        return Tipo;
    }
    
    public String getValor(){
        return Valor;
    }

    public String getMensaje() {
        return Mensaje;
    }
    
    public Operacion2 getOperacion(){
        return Op;
    }
    
    
}
