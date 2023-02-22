
package wumpus;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author win
 */
public class Ambiente extends JPanel implements Runnable, ActionListener{
    
    private int posicaoPx, posicaoPy;
    
    private Agente agente;
    
    private Wumpus wumpus;
    
    private boolean fimJogo = false;
    
    private Ouro ouro;
    
    private ArrayList arrayPocos;
    
    public Ambiente(Jogo jogo){
        
        setSize(Constantes.TAMANHOCELULAX * Constantes.MAXLINHAS , Constantes.TAMANHOCELULAY * Constantes.MAXCOLUNAS);        
        
        agente = new  Agente(jogo, 0, 5 * Constantes.TAMANHOCELULAY ,getWidth(), getHeight());
        
        wumpus = new Wumpus();
        
        ouro = new Ouro();
        
        carregarPocos();
        
        addKeyListener(new ActLis());  
        
        setFocusable(true);
    
        setBackground(Color.black);
        
        new Thread(this).start();
        
    }
    
    
    
    @Override
    public void paint(Graphics g) {
        
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        if (fimJogo){
        for (int i = 0; i < arrayPocos.size(); i++){
                Pocos pocos = (Pocos)arrayPocos.get(i);
                    pocos.desenharPoco(g2d);
        }
        
        wumpus.desenharWumpus(g2d);
        
        ouro.desenharOuro(g2d);    
        }
        g2d.setStroke(new BasicStroke(3));
       
        desenharCaverna(g2d);
        
        g2d.drawImage(agente.getImagemAgente(), agente.getPosicaoAx(), agente.getPosicaoAy(), null);
   
    }
    
   @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    public class ActLis extends KeyAdapter{
        

        public void keyReleased(KeyEvent e){
            
            agente.keyReleased(e);
        }
        
        public void keyPressed(KeyEvent e){
            agente.keyPressed(e);
        }
    }
    
    public void desenharCaverna(Graphics2D g2d){
        
        Rectangle2D rect = null;
        
        for(int i = 0; i < Constantes.MAXLINHAS ; i++)
        {
            for (int j = 0; j < Constantes.MAXCOLUNAS; j++){
                
                rect = new Rectangle2D.Float(j * Constantes.TAMANHOCELULAX, i * Constantes.TAMANHOCELULAY, Constantes.TAMANHOCELULAX, Constantes.TAMANHOCELULAY);
                g2d.draw(rect);
            }
        }
            
    }
    
    public void carregarPocos(){
        
        arrayPocos = new ArrayList();
        
        int x, y;
        
        Random gerador1 = new Random();
        
        Random gerador2 = new Random();
        
        for (int i = 0; i < Constantes.MAXCOLUNAS + 1; i++){
            
            x = gerador1.nextInt(6);
        
            y = gerador2.nextInt(6);

            posicaoPx = x * Constantes.TAMANHOCELULAX;
            posicaoPy = y * Constantes.TAMANHOCELULAY;
            
            arrayPocos.add(new Pocos(posicaoPx, posicaoPy));
            
        }
    }
    
    public void posicionarPocos(){
    
        int x, y;
        Random gerador = new Random();

        x = gerador.nextInt(5) + 1;
        y = gerador.nextInt(5) + 1;
            
        for (int i = 1; i <=  7; i++){
        
            x = gerador.nextInt(6) + 1;
            y = gerador.nextInt(6) + 1;
        }
    }

    @Override
    public void run() {
        
        while (true) {
            try{
                
                Thread.sleep(43);
                requestFocus();
                agente.movimentarAgente();
//                agente.verificarColisoes(wumpus, arrayPocos, ouro);
                repaint();
                    
                } catch (InterruptedException ex) {
                Logger.getLogger(Ambiente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
    }
    
}