/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Benvindo Amaro
 */
public class Constantes {
    
    // dimensoes da matriz
    public static final int MAXCOLUNAS = 6;  
    public static final int MAXLINHAS = 6; 
    public static final int TAMANHOCELULAX = 58;
    public static final int TAMANHOCELULAY = 39;
    
    // imagens das entidades
    public static final ImageIcon IMGAGENTE = new ImageIcon("src\\imagens\\Agente.PNG");
    public static final ImageIcon IMGOURO = new ImageIcon("src\\imagens\\Ouro.PNG");
    public static final ImageIcon IMGWUMPUS = new ImageIcon("src\\imagens\\Wumpus.PNG");
    public static final ImageIcon IMGPOCO = new ImageIcon("src\\imagens\\Poco.PNG");
    
    public static Rectangle getBounds(int posicaoX, int posicaoY){
        return new Rectangle(posicaoX, posicaoY, TAMANHOCELULAX, TAMANHOCELULAY);
    }
    
    
    // imagens das percepcoes
    public static final ImageIcon IMGFEDOR = new ImageIcon("src\\imagens\\Fedor.PNG");
    public static final ImageIcon IMGBRIZA = new ImageIcon("src\\imagens\\Briza.PNG");
    
}
