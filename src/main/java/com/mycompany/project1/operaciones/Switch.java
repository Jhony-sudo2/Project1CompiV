/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import static com.mycompany.project1.parser.Manejador.isDouble;
import static com.mycompany.project1.parser.Manejador.isInt;
import com.mycompany.project1.tablasimbolos.Tabla;
import com.mycompany.project1.tablasimbolos.Variable;
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
    public Switch(Tabla tabla,String Tipo,Operacion defecto,ArrayList<Casos>Lista) {
        super(TipoOperacion.SWITCH,tabla);
        this.Tipo = Tipo;
        this.Defecto = defecto;
        this.Lista = Lista;
    }
    
    @Override
    public void Ejecutar(){
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
                            operacion.getOperacion().Ejecutar();
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
            if(!error) if(Defecto != null) Defecto.Ejecutar();
        }
    }
    
    public int getTipoDato(String V){
        int tipo=-1;
        if(isInt(V)) return 1;
        else if(isDouble(V)) return 2;
        else{
            if(Existe(V)) return 3;
            else {
                Variable tmp = getTabla().Buscar(V);
                if(tmp!= null) return tmp.getTipo();
            } 
            
        }
        return 4;
    }
    
    
    
}
