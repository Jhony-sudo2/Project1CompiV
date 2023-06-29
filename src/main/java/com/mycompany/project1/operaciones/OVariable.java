/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import static com.mycompany.project1.parser.Manejador.isDouble;
import static com.mycompany.project1.parser.Manejador.isInt;
import com.mycompany.project1.parser.operaciones.Lexer2;
import com.mycompany.project1.parser.operaciones.Parser2;
import com.mycompany.project1.tablasimbolos.Tabla;
import com.mycompany.project1.tablasimbolos.Variable;
import java.io.Reader;
import java.io.StringReader;

/**
 *
 * @author jhony
 */
public class OVariable extends Operacion{
    private String NombreVar;
    private int Tipo;
    private String Valor;
    private int TipoOp;
    private String ValorA;
    private OFuncion funcion;
    
    public OVariable(Tabla tabla,int Tipo,String NombreVar,String Valor,int TipoOp,int Linea){
        super(TipoOperacion.VARIABLE,tabla,Linea);
        this.Tipo = Tipo;
        this.Valor = Valor;
        this.NombreVar = NombreVar;
        this.TipoOp = TipoOp;
    }
    public OVariable(Tabla tabla,int Tipo,String NombreVar,OFuncion Valor,int TipoOp,int Linea){
        super(TipoOperacion.VARIABLE,tabla,Linea);
        this.Tipo = Tipo;
        this.funcion = Valor;
        this.NombreVar = NombreVar;
        this.TipoOp = TipoOp;
    }
    
    
    @Override
    public void Ejecutar(){
        if(funcion == null)Valor();
        else ValorFuncion();
        if(this.getErrores().isEmpty()){
            switch(TipoOp){
                case 1 -> CrearVariable();
                case 2 -> Actualizar();
            }
        }
    }
    
    public void CrearVariable(){
        if(Existe(NombreVar)){
            if(ValorA == null | ValorA.isEmpty()){
                getTabla().Add(NombreVar, Tipo);
                System.out.println("VARIABLE: " + NombreVar +" creada tipo: " + Tipo);
            }
            else if(Comparar(Tipo,ValorA)){
                getTabla().Add(NombreVar, Tipo, ValorA);
                System.out.println("VARIABLE: " + NombreVar + " creada con valor: " + ValorA);
            }else{
                Error("El tipo de dato no es compatible con la variable: " + NombreVar);
            }
        }else Error("La variable: " + NombreVar + " ya existe");
    }
    
    
    public void Actualizar(){
        if(ValorA == null)ValorA = Valor;
        if(!Existe(NombreVar)){
            Variable tmp = getTabla().Buscar(NombreVar);
            int TipoV = tmp.getTipo();
            if(Comparar(TipoV,ValorA)){
                getTabla().Actualizar(ValorA, NombreVar);
                System.out.println("VARIABLE: " + NombreVar + " actualizada a: " + ValorA);
            }else{
                Error("El tipo de dato no es compatible con la variable: " + NombreVar);
            }
        }else Error("La variable: " + NombreVar + " no existe");
    }
    
    
    public boolean Comparar(int Tipo,String Valor){
        System.out.println("CAMPARANDO TIPO: " + Tipo + " con: " + Valor);
        return switch (Tipo) {
            case 1 -> isInt(Valor);
            case 2 -> isDouble(Valor);
            case 3 ->  true;
            default -> false;
        };
    }
    
    public void Valor(){
        Reader reader = new StringReader(Valor);
        Lexer2 lexer = new Lexer2(reader);
        Parser2 parser = new Parser2(lexer,getTabla());
        if(Valor.isEmpty()) ValorA=Valor;
        else{
            try{
                
                ValorA = (String) parser.parse().value;
                if(parser.getVariable() != null){
                    Variable tmp = parser.getVariable();
                    if(tmp.getTipo() != Tipo)
                    Error("El tipo de dato no coincide con la variable: " + NombreVar);
                }
                
                if(!parser.getErrores().isEmpty()) {
                    Error(parser.getErrores());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public void ValorFuncion(){
        funcion.Ejecutar();
        ValorA = funcion.getRetorno();
    }
    
    
}
