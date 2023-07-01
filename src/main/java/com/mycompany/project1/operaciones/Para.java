/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import com.mycompany.project1.parser.Manejador;
import com.mycompany.project1.parser.operaciones.Lexer2;
import com.mycompany.project1.parser.operaciones.Parser2;
import com.mycompany.project1.tablasimbolos.Tabla;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author jhony
 */
public class Para extends Operacion{
    private ArrayList<Operacion> Operaciones;
    private int I;
    private String i;
    public Para(Tabla tabla,ArrayList<Operacion> Operaciones,String i){
        super(TipoOperacion.PARA,tabla,0);
        this.Operaciones = Operaciones;
        this.i = i;
    }
    
    @Override
    public void Ejecutar(){
        setSalida("");
        getI(i);
        AsignarNuevaTabla(Operaciones, getTabla());
        for (int i = 0; i < I; i++) {
            EjecutarFunciones(Operaciones);
            if(!this.getErrores().isEmpty())break;
        }
    }
    
    public String getI(String Valor){
        System.out.println("I: " + Valor);
        String ValorA = "";
        Reader reader = new StringReader(Valor);
        Lexer2 lexer = new Lexer2(reader);
        Parser2 parser = new Parser2(lexer,getTabla());
        if(Valor.isEmpty()) return Valor;
        else{
            try{
                ValorA = (String) parser.parse().value;
                System.out.println("VALORA: "+ ValorA);
                if(Manejador.Comparar(1, ValorA)){
                    I = Integer.valueOf(ValorA);
                }else Error("La operacion en para no es un valor entero: ");
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
    
}
