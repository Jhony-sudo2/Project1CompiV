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
public class Mientras extends Operacion {
    private ArrayList<Operacion> Operaciones;
    private int Condicion;
    private String Var1,Var2,Operador;
    public Mientras(ArrayList<Operacion> Operaciones, int Condicion,Tabla tabla) {
        super(TipoOperacion.MIENTRAS,tabla);
        this.Operaciones = Operaciones;
        this.Condicion = Condicion;
    }

    @Override
    public void Ejecutar(){
        while(Condicion == 1){
            for (Operacion Op : Operaciones) {
                Op.Ejecutar();
            }
        }
    }
    
    public void setCondicion(int Condicion){
        this.Condicion = Condicion;
    }
    
    public void NuevaCondicion(){
        Condicion = 1;
    }
    
    
    
    
}
