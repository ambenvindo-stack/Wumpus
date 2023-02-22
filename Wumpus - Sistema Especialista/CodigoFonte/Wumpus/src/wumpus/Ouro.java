/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

/**
 *
 * @author win
 */
public class Ouro {
    
    int posicaoOx, posicaoOy;
    
    Image imgOuro;
    
    boolean visivel;
    
    public Ouro(){
       
        this.visivel = false;
       posicionarOuro(); 
    }

    public void posicionarOuro(){
        
        int x, y;
        
        Random gerador1 = new Random();
        
        Random gerador2 = new Random();
        
        x = gerador1.nextInt(5);
        
        y = gerador2.nextInt(5);
        
        posicaoOx = x * Constantes.TAMANHOCELULAX;
        posicaoOy = y * Constantes.TAMANHOCELULAY;
        
        System.out.println("Posicao Ouro: x: "+(x+1)+" y: "+(y+1));
        
    }
    
    
    public void desenharOuro(Graphics2D g2d){
        
        g2d.drawImage(getImagem(), getPosicaoOx(), getPosicaoOy(), null);
    }
    
    public void setVisivel(boolean visivel){
        this.visivel = visivel;
    }
    
    public boolean getVisivel(){
        return visivel;
    }
    
    public int getPosicaoOx(){
        
        return this.posicaoOx;
    }
    
    public int getPosicaoOy(){
        
        return this.posicaoOy;
    }
    
    public Image getImagem(){
        
        return Constantes.IMGOURO.getImage();
    }
}
