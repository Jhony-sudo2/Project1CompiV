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
public class Si extends Operacion{
    private int Condicion;
    private ArrayList<Operacion> Operaciones;
    private ArrayList<Operacion> Operaciones2;
    public Si(Tabla tabla,int Condicion,ArrayList<Operacion> Operaciones,ArrayList<Operacion> Operaciones2){
        super(TipoOperacion.SI,tabla);
        this.Condicion = Condicion;
        this.Operaciones = Operaciones;
        this.Operaciones2 = Operaciones2;
    }
    
    @Override
    public void Ejecutar(){
        System.out.println("EJECUTANDO OPERACION SI");
        if(Condicion == 1){
            for (Operacion Operacione : Operaciones) {
                Operacione.Ejecutar();
            }
        }else if(Operaciones2 != null){
            for (Operacion operacion : Operaciones2) {
                operacion.Ejecutar();
            }
        }
    }
}
