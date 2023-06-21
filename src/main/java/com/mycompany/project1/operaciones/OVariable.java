/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.operaciones;

import static com.mycompany.project1.parser.Manejador.isDouble;
import static com.mycompany.project1.parser.Manejador.isInt;
import com.mycompany.project1.tablasimbolos.Tabla;
import com.mycompany.project1.tablasimbolos.Variable;

/**
 *
 * @author jhony
 */
public class OVariable extends Operacion{
    private String NombreVar;
    private int Tipo;
    private String Valor;
    
    public OVariable(Tabla tabla,int Tipo,String Valor){
        super(TipoOperacion.VARIABLE,tabla);
        this.Tipo = Tipo;
        this.Valor = Valor;
    }
    
    @Override
    public void Ejecutar(){
        switch(Tipo){
            case 1 -> CrearVariable();
            case 2 -> Actualizar();
        }
    }
    
    public void CrearVariable(){
        if(Existe(NombreVar)){
            if(Valor == null){
                this.getTabla().Add(NombreVar, Tipo);
                System.out.println("VARIABLE: " + NombreVar +" creada tipo: " + Tipo);
            }
            else if(Comparar(Tipo,Valor)){
                this.getTabla().Add(NombreVar, Tipo, Valor);
                System.out.println("VARIABLE: " + NombreVar + " creada con valor: " + Valor);
            }else{
                Error("El tipo de dato no es compatible con la variable: " + NombreVar);
            }
        }else Error("La variable: " + NombreVar + " ya existe");
    }
    
    
    public void Actualizar(){
        if(!Existe(NombreVar)){
            Variable tmp = getTabla().Buscar(NombreVar);
            int TipoV = tmp.getTipo();
            if(Comparar(TipoV,Valor)){
                getTabla().Actualizar(Valor, NombreVar);
                System.out.println("VARIABLE: " + NombreVar + " actualizada a: " + Valor);
            }else{
                Error("El tipo de dato no es compatible con la variable: " + NombreVar);
            }
        }else Error("La variable: " + NombreVar + " no existe");
    }
    
    
    public boolean Comparar(int Tipo,String Valor){
        return switch (Tipo) {
            case 1 -> isInt(Valor);
            case 2 -> isDouble(Valor);
            case 3 ->  true;
            default -> false;
        };
    }
    
    
}
