/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.tablasimbolos;

/**
 *
 * @author jhony
 */
public class Variable {
    private String Nombre;
    private int Tipo;
    private String Valor;

    public Variable(String Nombre, int Tipo, String Valor) {
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Valor = Valor;
    }
    
    public Variable(String Nombre,int Tipo){
        this.Nombre = Nombre;
        this.Tipo = Tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }
    
    
}
