/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import com.mycompany.project1.parser.operaciones.Lexer2;
import com.mycompany.project1.parser.operaciones.Parser2;
import com.mycompany.project1.tablasimbolos.Funcion;
import com.mycompany.project1.tablasimbolos.Tabla;
import com.mycompany.project1.tablasimbolos.TablaFuncion;
import com.mycompany.project1.tablasimbolos.Variable;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author jhony
 */
public class OFuncion extends Operacion{
    private String Nombre;
    private int Retorno;
    private ArrayList<Operacion> Operaciones;
    private ArrayList<Variable> Parametros;
    private ArrayList<String>Parametros2;
    private int Tipo;
    private String ValorRetorno;
    private int TipoOperador = 0;
    private TablaFuncion Tabla;
    
    public OFuncion(TablaFuncion tabla,String Nombre,int Retorno,ArrayList<Operacion> Operaciones,String ValorRetorno,ArrayList<Variable> Parametros){
        super(TipoOperacion.FUNCION,tabla);
        this.Nombre = Nombre;
        this.Retorno = Retorno;
        this.Operaciones = Operaciones;
        this.ValorRetorno = ValorRetorno;
        this.Parametros = Parametros;
        this.TipoOperador = 1;
        this.Tabla = tabla;
    }
    
    public OFuncion(TablaFuncion tabla,String Nombre,ArrayList<String> Parametros2){
        super(TipoOperacion.FUNCION,tabla);
        this.TipoOperador = 2;
        this.Parametros2 = Parametros2;
        this.Nombre = Nombre;
        this.Tabla = tabla;
    }
    
    
    
    @Override
    
    public void Ejecutar(){
        if(TipoOperador == 1) GuardarFuncion();
        else EjecutarFuncion();
    }
    
    public void GuardarFuncion(){
        System.out.println("GUARDANDO FUNCION");
        if(Tabla.BuscarF(Nombre) == null){
            Tabla.Add(Nombre, Retorno, Operaciones, ValorRetorno, Parametros);
        }else Error("La funcion: "  + Nombre + " ya existe");
    }
    
    public void EjecutarFuncion(){
        if(Tabla.BuscarF(Nombre) != null){
            Funcion tmp = Tabla.BuscarF(Nombre);
            EjecutarFunciones(tmp.getOperaciones());
            ObtenerRetorno();
            
        }else Error("La funcion: " + Nombre + " no existe");
        
    }
    
    public String getRetorno(){
        return ValorRetorno;
    }
    
    public void ObtenerRetorno(){
        if(ValorRetorno != null){
            Reader reader = new StringReader(ValorRetorno);
            Lexer2 lexer = new Lexer2(reader);
            Parser2 parser = new Parser2(lexer,getTabla());
            System.out.println("ANALIZANDO: " + ValorRetorno);
            try{
                ValorRetorno = (String) parser.parse().value;
                System.out.println("VALORA: " + ValorRetorno);
            }catch(Exception e){
                    e.printStackTrace();
            }
        }
        
    }
    
}
