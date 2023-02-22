    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Deolinda
 */
public class Pocos {
    
    private int posicaoPx, posicaoPy;
    
    private boolean visivel;
    
    public Pocos(int posicaoX, int posicaoY){
        
       this.visivel = visivel; 
        
       this.posicaoPx = posicaoX;
       
       this.posicaoPy = posicaoY;
    }
   
    public void desenharPoco(Graphics2D g2d){
        
        g2d.drawImage(getImagemPoco(), getPosicaoX(), getPosicaoY(), null);
        desenharBriza(g2d);
    }
    
    public void desenharBriza(Graphics2D g2d){
        
        // se posicao esquerda diferente de parede e diferente da posicao inicial do agente
            g2d.drawImage(getImagemBriza(), posicaoPx - Constantes.TAMANHOCELULAX, posicaoPy, null);
        // se posicao cima diferente de parede e diferente da posicao inicial da parede
            g2d.drawImage(getImagemBriza(), posicaoPx, posicaoPy - Constantes.TAMANHOCELULAY, null);
        // se posicao direita diferente de parede e diferente da posicao inicial do agente
            g2d.drawImage(getImagemBriza(), posicaoPx + Constantes.TAMANHOCELULAX, posicaoPy, null);
        // se posicao baixo diferente de parede e deferente da posicao inicial do agente
            g2d.drawImage(getImagemBriza(), posicaoPx, posicaoPy + Constantes.TAMANHOCELULAY, null);
    }
    
    public void setVisivel(boolean visivel){
        this.visivel = visivel;
    }
    
    public boolean getVisivel(){
        return this.visivel;
    }
    
    public int getPosicaoX(){
        return this.posicaoPx;
    }
    
    public int getPosicaoY(){
        return this.posicaoPy;
    }
    
    public Image getImagemPoco(){
        return Constantes.IMGPOCO.getImage();
    }
    
    public Image getImagemBriza(){
        return Constantes.IMGBRIZA.getImage();
    }
}