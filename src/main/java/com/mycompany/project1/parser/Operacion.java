/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.parser;

/**
 *
 * @author jhony
 */
public class Operacion {
    private int Tipo;
    private String Mensaje;
    private String Valor;
    
    public Operacion(int Tipo, String Mensaje) {
        this.Tipo = Tipo;
        this.Mensaje = Mensaje;
    }
    
    public Operacion(int Tipo,String Variable,String Valor){
        this.Tipo = Tipo;
        this.Mensaje = Variable;
        this.Valor = Valor;
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
    
    
    
}
