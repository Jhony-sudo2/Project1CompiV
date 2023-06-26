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
public class Si extends Operacion{
    private int Tipo = 0;
    private int ValorCondicion = 0;
    private Condicion condicion;
    private ArrayList<Operacion> Operaciones;
    private ArrayList<Operacion> Operaciones2;
    private Si SI;
    public Si(Tabla tabla,Condicion condicion,ArrayList<Operacion> Operaciones,ArrayList<Operacion> Operaciones2){
        super(TipoOperacion.SI,tabla);
        this.condicion = condicion;
        this.Operaciones = Operaciones;
        this.Operaciones2 = Operaciones2;
        Tipo = 1;
    }
    
    public Si(Tabla tabla,Si Condicion,ArrayList<Operacion> Operaciones,ArrayList<Operacion> Operaciones2){
        super(TipoOperacion.SI,tabla);
        this.SI = Condicion;
        this.Operaciones = Operaciones;
        this.Operaciones2 = Operaciones2;
        Tipo = 2;
    }
    
    
    @Override
    public void Ejecutar(){
        Manejador m = new Manejador(getTabla());
        System.out.println("EJECUTANDO OPERACION SI");
        if(Tipo == 1)
            ValorCondicion = m.Condicion(condicion.getValor1(), condicion.getValor2(), condicion.getOperacion());
        else{
            Operaciones = SI.Operaciones;
            Condicion tmp = SI.getCondicion();
            ValorCondicion =m.Condicion(tmp.getValor1(), tmp.getValor2(), tmp.getOperacion());
        }
        System.out.println("VALOR CONDICION: " + ValorCondicion);
        if(ValorCondicion == 1){
            EjecutarFunciones(Operaciones);
        }else if(Operaciones2 != null & ValorCondicion ==2){
            EjecutarFunciones(Operaciones2);
        }
        
        
    }
    
    public Condicion getCondicion(){
        return condicion;
    }
}
