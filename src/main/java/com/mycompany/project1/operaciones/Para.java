/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import com.mycompany.project1.tablasimbolos.Tabla;
import java.util.ArrayList;

/**
 *
 * @author jhony
 */
public class Para extends Operacion{
    private ArrayList<Operacion> Operaciones;
    private int I;
    public Para(Tabla tabla,ArrayList<Operacion> Operaciones,int i){
        super(TipoOperacion.PARA,tabla);
        this.Operaciones = Operaciones;
        this.I = i;
    }
    
    @Override
    public void Ejecutar(){
        for (int i = 0; i < I; i++) {
            EjecutarFunciones(Operaciones);
        }
    }
    
}
