/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author win
 */
public class Mapa extends JPanel implements Runnable{
    
    int cont = 30;
    
    int maxColunas = 6,  maxLinhas = 6, tamanhoCelulaX, tamanhoCelulaY;
    
    
    public Mapa(){
        
        setSize(351 , 233);        
        tamanhoCelulaX = this.getWidth() / maxLinhas;
        tamanhoCelulaY = this.getHeight() / maxColunas;
        setBackground(Color.white);
    }
    
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(3));
        Rectangle2D rect;
        
        for(int i = 0; i < maxLinhas ; i++)
        {
            for (int j = 0; j < maxColunas; j++){
                
                rect = new Rectangle2D.Float(j * tamanhoCelulaX, i * tamanhoCelulaY, tamanhoCelulaX, tamanhoCelulaY);
                g2d.draw(rect);
            }
        }
        
        g2d.setStroke(new BasicStroke(1));
        
    }

    @Override
    public void run() {
        
        while (true) {
            try{
            
                Thread.sleep(43);
             
                } catch (InterruptedException ex) {
                Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }         
    }
    
}
