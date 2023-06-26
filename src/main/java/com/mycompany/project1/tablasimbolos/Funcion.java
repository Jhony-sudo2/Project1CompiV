/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.tablasimbolos;

import com.mycompany.project1.operaciones.Operacion;
import java.util.ArrayList;

/**
 *
 * @author jhony
 */
public class Funcion {
    private final String Nombre;
    private final String ValorRetorno;
    private final ArrayList<Variable> Parametros;
    private final int Retorno;
    private final ArrayList<Operacion> Operaciones;
    private Tabla TablaLocal = new Tabla();

    public Funcion(String Nombre,String ValorRetorno, ArrayList<Variable> Parametros, int Retorno, ArrayList<Operacion> Operaciones) {
        this.Nombre = Nombre;
        this.ValorRetorno  = ValorRetorno;
        this.Parametros = Parametros;
        this.Retorno = Retorno;
        this.Operaciones = Operaciones;
    }

    public String getNombre() {
        return Nombre;
    }
    
    public Tabla getTablaLocal(){
        return TablaLocal;
    }

    public String getValorRetorno() {
        return ValorRetorno;
    }

    public ArrayList<Variable> getParametros() {
        return Parametros;
    }

    public int getRetorno() {
        return Retorno;
    }

    public ArrayList<Operacion> getOperaciones() {
        return Operaciones;
    }
    public void IniciarTabla(){
        TablaLocal = new Tabla();
        for (Variable Parametro : Parametros) {
            TablaLocal.Add(Parametro);
        }
    }
    
    
    
    
    
}
