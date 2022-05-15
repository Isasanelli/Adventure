/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gioco.thehuntress.type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */
public class AdvObject {
    
    //definiamo gli attributi della classe oggetto 
    private final int id; 
    private String nome;
    private String descrizione;
    private Set<String> alias;
    private boolean attiva = false;
    private boolean raccogliere = false;
    private boolean apri = false; 
    
    public AdvObject ( int id ){
        this.id = id; 
    }
    
    public AdvObject ( int id, String nome){
        this.id = id; 
        this.nome = nome;
    }
    
    public AdvObject ( int id, String nome, String descrizione){
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        
    }
    
    public AdvObject ( int id, String nome, String descrizione, Set<String> alias){
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.alias = alias;
    }
    
    
    
}
