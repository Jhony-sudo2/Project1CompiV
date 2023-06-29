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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jhony
 */
public class Switch extends Operacion{
    private ArrayList<Casos>Lista;
    private String Tipo;
    private Operacion Defecto;
    public Switch(Tabla tabla,String Tipo,Operacion defecto,ArrayList<Casos>Lista,int Linea) {
        super(TipoOperacion.SWITCH,tabla,Linea);
        this.Tipo = Tipo;
        this.Defecto = defecto;
        this.Lista = Lista;
    }
    
    @Override
    public void Ejecutar(){
        Valor();
        int TipoPrincipal = getTipoDato(Tipo);
        if(TipoPrincipal != 4){
            Set<String> conjunto = new HashSet<>();
            boolean error = false;
            for (int i = 0; i < Lista.size(); i++) {
                Casos operacion = Lista.get(i);
                int tipotmp = getTipoDato(operacion.getValor());
                if(tipotmp == TipoPrincipal){
                    if(conjunto.add(operacion.getValor())){
                        System.out.println("COMPARANDO " + Tipo + " con " + operacion.getValor());
                        if(Tipo.equals(operacion.getValor())){
                            for (Operacion operacione : operacion.getOperaciones()) {
                                operacione.setTabla(getTabla());
                            }
                            EjecutarFunciones(operacion.getOperaciones());
                            error = true;
                            break;
                        }
                    }else {
                        Error("Datos duplicados en switch");
                        error = true; 
                        break;
                    }
                }else{
                    Error("Los datos del caso no coinciden en el switch: ");
                    error= true;
                    break;
                } 
            }
            if(!error) if(Defecto != null) {
                Defecto.Ejecutar();
                if(!Defecto.getErrores().isEmpty()) Error(Defecto.getErrores());
                if(!Defecto.getSalida().isEmpty()) Salida(Defecto.getSalida());
            }
        }
    }
    public void Valor(){
        Reader reader = new StringReader(Tipo);
        Lexer2 lexer = new Lexer2(reader);
        Parser2 parser = new Parser2(lexer,getTabla());
        System.out.println("ANALIZANDO DESDE VARIABLE: " + Tipo);
        
            try{
                Tipo = (String) parser.parse().value;
                System.out.println("VALORA: " + Tipo);
                if(!parser.getErrores().isEmpty()) {
                    Error(parser.getErrores());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
    }
    
    
    
    
    
}
