/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.tablasimbolos;

/**
 *
 * @author jhony
 */
public class Funcion {
    private final String Nombre;
    private final String Retorno;
    private final int[] Parametros;

    public Funcion(String Nombre, String Retorno, int[] Parametros) {
        this.Nombre = Nombre;
        this.Retorno = Retorno;
        this.Parametros = Parametros;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getRetorno() {
        return Retorno;
    }

    public int[] getParametros() {
        return Parametros;
    }
    
    
    
}
