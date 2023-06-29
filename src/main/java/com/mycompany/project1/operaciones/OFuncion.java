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
    
    public OFuncion(TablaFuncion tabla,Tabla tablap,String Nombre,ArrayList<String> Parametros2){
        super(TipoOperacion.FUNCION,tablap);
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
        if(Tabla.BuscarF(Nombre) == null){
            if((Retorno != 0 & ValorRetorno != null) | (Retorno == 0 & ValorRetorno ==null)){
                System.out.println("GUARDANDO FUNCION: " + Nombre);
                Tabla.Add(Nombre, Retorno, Operaciones, ValorRetorno, Parametros);
                if(Parametros != null){
                    Funcion tmp =  Tabla.BuscarF(Nombre);
                    tmp.IniciarTabla();
                }
            }else if(Retorno != 0 & ValorRetorno == null )Error("La funcion: " + Nombre + " tiene que retornar un valor");
            else Error("La funcion: " + Nombre + " es de tipo void, no devuelve ningun valor");
        }else Error("La funcion: "  + Nombre + " ya existe");
    }
    
    public void EjecutarFuncion(){
        if(Tabla.BuscarF(Nombre) != null){
            Funcion tmp = Tabla.BuscarF(Nombre);
            if(VerificarParametros(tmp)){
                if(tmp.getOperaciones() != null){
                    for (Operacion operacione : tmp.getOperaciones()) {
                        operacione.setTabla(tmp.getTablaLocal());
                    }
                    for (int i = 0; i < Parametros2.size(); i++) {
                        Variable tmp2 = tmp.getTablaLocal().getVariables().get(i);
                        tmp2.setValor(Valor(Parametros2.get(i)));
                    }
                    EjecutarFunciones(tmp.getOperaciones());
                }else{
                    for (int i = 0; i < Parametros2.size(); i++) {
                            Variable tmp2 = tmp.getTablaLocal().getVariables().get(i);
                            tmp2.setValor(Valor(Parametros2.get(i)));
                    }
                }
                ObtenerRetorno(tmp.getValorRetorno(),tmp.getTablaLocal());
                tmp.IniciarTabla();
            }else Error("Error de parametros con la funcion: " + Nombre);
            
        }else Error("La funcion: " + Nombre + " no existe");
        
    }
    public String Valor(String Valor){
        String ValorA = "";
        Reader reader = new StringReader(Valor);
        Lexer2 lexer = new Lexer2(reader);
        Parser2 parser = new Parser2(lexer,getTabla());
        if(Valor.isEmpty()) return Valor;
        else{
            try{
                ValorA = (String) parser.parse().value;
                if(!parser.getErrores().isEmpty()) {
                    Error(parser.getErrores());
                    return "";
                }else return ValorA;
            }catch(Exception e){
                e.printStackTrace();
                return "";
            }
        }
    }
    
    
    public String getRetorno(){
        return ValorRetorno;
    }
    
    public void ObtenerRetorno(String V,Tabla t){
        if(V != null){
            Reader reader = new StringReader(V);
            Lexer2 lexer = new Lexer2(reader);
            Parser2 parser = new Parser2(lexer,t);
            try{
                ValorRetorno = (String) parser.parse().value;
                if(!parser.getErrores().isEmpty()) {
                    Error(parser.getErrores());
                }
            }catch(Exception e){
                Error(parser.getErrores());
            }
        }else System.out.println("RETORNO NULO");
        
    }
    
    public boolean VerificarParametros(Funcion tmp){
        if(tmp.getParametros() != null & Parametros2 != null ){
            if(tmp.getParametros().size() != Parametros2.size()) return false;
            for (int i = 0; i < Parametros2.size(); i++) {
                int tipo1 = tmp.getParametros().get(i).getTipo();
                int tipo2 = getTipoDato(Parametros2.get(i));
                if(tipo1 != tipo2) return false;
            }
        }else if(tmp.getParametros() == null & Parametros == null) return true;
        else return false;
        return true;
    }

    public ArrayList<Operacion> getOperaciones() {
        return Operaciones;
    }
    
    
    
}
