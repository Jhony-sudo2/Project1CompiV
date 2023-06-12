/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

/**
 *
 * @author jhony
 */
public class Bucle {
    private int Tipo; //1 PARA 2 MIENTRAS
    private Operacion op;
    private int X;

    public Bucle(int Tipo, Operacion op, int X) {
        this.Tipo = Tipo;
        this.op = op;
        this.X = X;
    }

    public int getTipo() {
        return Tipo;
    }

    public Operacion getOp() {
        return op;
    }

    public int getX() {
        return X;
    }
    
    
    
    
}
