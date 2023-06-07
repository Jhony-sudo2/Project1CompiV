/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project1.parser;

/**
 *
 * @author jhony
 */
public class Token {
    private String Value;
    private int Line;
    private int Column;
    private int Type;
    
    public Token(String Value,int Line, int Column,int Type){
        this.Value = Value;
        this.Type = Type;
        this.Column = Column;
        this.Line = Line;
    }
    
    
    public Token(int Line,int Column,int Type){
        this.Type = Type;
        this.Column = Column;
        this.Line = Line;
    }
    
    public String getValue(){
        return Value;
    }
    
    public int getLine(){
        return Line;
    }
    
    public int getColumn(){
        return Column;
    }
    
    public int getType(){
        return Type;
    }
}
