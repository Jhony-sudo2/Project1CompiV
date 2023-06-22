/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

/**
 *
 * @author jhony
 */
public class Condicion {
    private String Valor1;
    private String Valor2;
    private int Operacion = 0;
    
    public Condicion(String Valor1, String Valor2,int Operacion) {
        this.Valor1 = Valor1;
        this.Valor2 = Valor2;
        this.Operacion = Operacion;
    }
    

    public String getValor1() {
        return Valor1;
    }

    public String getValor2() {
        return Valor2;
    }

    public int getOperacion() {
        return Operacion;
    }
    
    
    
}
