/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;
import com.mycompany.project1.parser.Manejador;
import com.mycompany.project1.tablasimbolos.Tabla;
import java.util.ArrayList;

/**
 *
 * @author jhony
 */
public class Mientras extends Operacion {
    private ArrayList<Operacion> Operaciones;
    private Condicion Condicion;
    private int ValorCondicion;
    public Mientras(ArrayList<Operacion> Operaciones, Condicion Condicion,Tabla tabla) {
        super(TipoOperacion.MIENTRAS,tabla);
        this.Operaciones = Operaciones;
        this.Condicion = Condicion;
    }
    
    public Mientras(Tabla tabla){
        super(TipoOperacion.MIENTRAS,tabla);
    }

    @Override
    public void Ejecutar(){
        Manejador m = new Manejador(getTabla());
        ValorCondicion = m.Condicion(Condicion.getValor1(), Condicion.getValor2(), Condicion.getOperacion());
        while(ValorCondicion == 1){
            for (Operacion Op : Operaciones) {
                Op.Ejecutar();
                if(!Op.getSalida().isEmpty())Salida(Op.getSalida());
            }
            ValorCondicion = m.Condicion(Condicion.getValor1(), Condicion.getValor2(), Condicion.getOperacion());
        }
    }
    
    
}
