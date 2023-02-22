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
 * @author Deolinda
 */
public class Wumpus {
    
    int posicaoWx, posicaoWy, posicaoFx, posicaoFy;
    
    boolean visivel;
    
    public Wumpus(){
        
       this.visivel = false; 
       posicionarWumpus();  
       
    }
    
    public void posicionarWumpus(){
        
        int x, y;
        
        Random gerador1 = new Random();
        
        Random gerador2 = new Random();
        
        x = gerador1.nextInt(5);
        
        y = gerador2.nextInt(5);
        
        posicaoWx = x * Constantes.TAMANHOCELULAX;
        posicaoWy = y * Constantes.TAMANHOCELULAY;
        
        
    }
    
    
    public void desenharWumpus(Graphics2D g2d){
        
        g2d.drawImage(getImagemWumpus(), getPosicaoWx(), getPosicaoWy(), null);
        desenharFedor(g2d);
    }
    
    public void desenharFedor(Graphics2D g2d){
        
        // se posicao esquerda diferente de parede e diferente da posicao inicial do agente
//        if (posicaoWx - Constantes.TAMANHOCELULAX < 0 )
            g2d.drawImage(getImagemFedor(), posicaoWx - Constantes.TAMANHOCELULAX, posicaoWy, null);
        // se posicao cima diferente de parede e diferente da posicao inicial da parede
//        if (posicaoWy - Constantes.TAMANHOCELULAY < 0)
            g2d.drawImage(getImagemFedor(), posicaoWx, posicaoWy - Constantes.TAMANHOCELULAY, null);
        // se posicao direita diferente de parede e diferente da posicao inicial do agente
//        if (posicaoWx + Constantes.TAMANHOCELULAX > Constantes.TAMANHOCELULAX * Constantes.MAXLINHAS)
            g2d.drawImage(getImagemFedor(), posicaoWx + Constantes.TAMANHOCELULAX, posicaoWy, null);
        // se posicao baixo diferente de parede e deferente da posicao inicial do agente
//        if (posicaoWy + Constantes.TAMANHOCELULAY > Constantes.TAMANHOCELULAY * Constantes.MAXCOLUNAS)
            g2d.drawImage(getImagemFedor(), posicaoWx, posicaoWy + Constantes.TAMANHOCELULAY, null);
    }
    
    public void setVisivel(boolean visivel){
        this.visivel = visivel;
    }
    
    public boolean getVisivel(){
        return visivel;
    }
    
    public int getPosicaoWx(){
        return this.posicaoWx;
    }
    
    public int getPosicaoWy(){
        return this.posicaoWy;
    }
    
    public Image getImagemWumpus(){
        return Constantes.IMGWUMPUS.getImage();
    }
    
    public Image getImagemFedor(){
        return Constantes.IMGFEDOR.getImage();
    }
}
