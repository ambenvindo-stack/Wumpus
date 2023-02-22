/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

import java.util.LinkedList;

/**
 *
 * @author Benvindo Amaro
 */
public class BaseConhecimento {
    
    LinkedList<String> listaPercepcoes ;
    
    public BaseConhecimento(){
        
        listaPercepcoes = new LinkedList<String>();   
    }
    
    
    public void captarPercepcoes(String percepcoes){
        
        listaPercepcoes.addLast(percepcoes);
        
    }
    
    public boolean verificaPosicoes(){
        
    return true;
    }
    
    
    
}
