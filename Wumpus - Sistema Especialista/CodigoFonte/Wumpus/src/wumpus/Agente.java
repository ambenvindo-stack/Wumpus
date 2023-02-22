/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wumpus;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Deolinda
 */
public class Agente {

    private Image imgAgente;
    private int posicaoAx, posicaoAy, variacaoX, variacaoY, altura, largura, direcao, larguraAmbiente, alturaAmbiente;
    private final int HORINZONTAL = 1, VERTICAL = 2;
    
    private String percepcoesAgente = "";
    
    private Jogo telaJogo;


    int pontuacao;
    
    public Agente(Jogo jogo, int posicaoAx, int posicaoAy, int larguraAmbiente, int alturaAmbiente){
        
        this.telaJogo = jogo;
        this.posicaoAx = posicaoAx;
        this.posicaoAy = posicaoAy;
        this.larguraAmbiente = larguraAmbiente;
        this.alturaAmbiente = alturaAmbiente;
        this.pontuacao = 1000;
    }
    
    public Image getImagemAgente(){
        
        return Constantes.IMGAGENTE.getImage();
    }
    
    public int getPosicaoAx(){
        return this.posicaoAx;
    }
    
    public int getPosicaoAy(){
        return this.posicaoAy;
    }
    
    public void movimentarAgente(){
        
        if (direcao == HORINZONTAL)
            movimentarEmX();
        if(direcao == VERTICAL)
            movimentarEmY();
    }
    
    public void movimentarEmX(){
        
        posicaoAx  =  posicaoAx +  variacaoX;
    }
    
    public void movimentarEmY(){
        
        posicaoAy = posicaoAy + variacaoY;
        
    }
    
    
    public void keyPressed(KeyEvent e){
         
        int tecla = e.getKeyCode();
         
        if (tecla == KeyEvent.VK_LEFT){
           if (limiteMatriz()){
               direcao = HORINZONTAL;
               variacaoX = Constantes.TAMANHOCELULAX * (-1);
               saidaPercepcao("Agente move para as [ESQUERDA]posicoes: x: y: \nPERCEPCAO: OK!\n\n", 1);
            }
        }
        
        if (tecla == KeyEvent.VK_RIGHT){
            if (limiteMatriz()){
                direcao = HORINZONTAL;
                variacaoX = Constantes.TAMANHOCELULAX;
                saidaPercepcao("Agente move para[DIREITA] as posicoes: x: y: \nPERCEPCAO: OK!\n\n", 1);
            }
                
        }
        
        if (tecla == KeyEvent.VK_UP){
            if(limiteMatriz()){
                direcao = VERTICAL;
                variacaoY = Constantes.TAMANHOCELULAY * (-1);
                saidaPercepcao("Agente move para[CIMA] as posicoes: x: y: \nPERCEPCAO: OK!\n\n", 1);
            }
        }
 
        if (tecla == KeyEvent.VK_DOWN){
            if (limiteMatriz()){
                direcao = VERTICAL;
                variacaoY = Constantes.TAMANHOCELULAY;
                saidaPercepcao("Agente move para [BAIXO] as posicoes: x: y: \nPERCEPCAO: OK!\n\n", 1);
            }   
        }
     }
     
    public void keyReleased(KeyEvent e){
         
         int tecla = e.getKeyCode();
         
         if (tecla == KeyEvent.VK_RIGHT) 
             variacaoX = 0;
         
         if (tecla == KeyEvent.VK_LEFT)
                variacaoX = 0;
             
         if (tecla == KeyEvent.VK_DOWN)
                variacaoY = 0;

         if (tecla == KeyEvent.VK_UP)
                variacaoY = 0;
         
     }  
     
    
    public boolean limiteMatriz(){
        
//        String direcoes = "Agente_ Posicao X: "+getPosicaoAx()+" Posicao Y: "+getPosicaoAy()+"\n\nEsquerda: "+(getPosicaoAx() - Constantes.TAMANHOCELULAX);
//        
//        direcoes += "\n\nCima: "+(getPosicaoAy() - Constantes.TAMANHOCELULAY)+"\n\n Direita: "+(getPosicaoAx() + Constantes.TAMANHOCELULAX);
//        
//        direcoes += "\n\nBaixo: "+(getPosicaoAy() + Constantes.TAMANHOCELULAY);
//        
//        JOptionPane.showMessageDialog(null, direcoes);
        
//        if (getPosicaoAx() - Constantes.TAMANHOCELULAX < 0 ){
////            JOptionPane.showMessageDialog(null, "Posicao X: "+getPosicaoAx()+" Proxima Posicao: "+(Constantes.TAMANHOCELULAX));
////            saidaChoque();
//            return false;
//        }
//        if (getPosicaoAy() - Constantes.TAMANHOCELULAY < 0){
////            JOptionPane.showMessageDialog(null, "Posicao Y: "+getPosicaoAy()+" Proxima Posicao: "+(Constantes.TAMANHOCELULAY));
////           saidaChoque();
//            return false;
//        }
//        if (getPosicaoAx() + Constantes.TAMANHOCELULAX > Constantes.TAMANHOCELULAX * Constantes.MAXLINHAS){
//            saidaChoque();
//            return false;
//        }
//        if (getPosicaoAy() + Constantes.TAMANHOCELULAY > Constantes.TAMANHOCELULAY * Constantes.MAXCOLUNAS){
//            saidaChoque();
//            return false;
//        }    
        
        return true;
    }
    
    public void saidaPercepcao(String percepcao, int pontos){
        
        percepcoesAgente += percepcao;
        telaJogo.getJtextArea().requestFocus();
        telaJogo.getJtextArea().setText(percepcoesAgente);
        pontuacao -= pontos;
        telaJogo.getJtPontuacao().requestFocus();
        telaJogo.getJtPontuacao().setText(""+pontuacao);
    }
    
    public void saidaChoque(){
        percepcoesAgente += "Agente bate contra parede\n\n";
        telaJogo.getJtextArea().requestFocus();
        telaJogo.getJtextArea().setText(percepcoesAgente);
    }
     
    
    public void verificarColisoes(Wumpus wumpus, ArrayList arrayPocos, Ouro ouro){
        
        Rectangle rectAgente = Constantes.getBounds(posicaoAx, posicaoAy);

        Rectangle rectWumpus = Constantes.getBounds(wumpus.getPosicaoWx(), wumpus.getPosicaoWy());
        
        Rectangle rectOuro = Constantes.getBounds(ouro.getPosicaoOx(), ouro.getPosicaoOy());
        
        Rectangle rectPontoInicial = Constantes.getBounds(0, 5 * Constantes.TAMANHOCELULAY);
        
//        Rectangle rectFedor =  fedor.getBounds();
//        
//        Rectangle rectBriza = briza.getBounds();
//        
//        if (rectAgente.intersects(rectBriza))
//                percepcao += "Aviso: Poco pode encontrar-se nas posicoes ?";
//        
//        if (rectAgente.intersects(rectFedor))
//                percepcao += "Aviso: Wumpus pode encontrar-se nas posicoes ?";
        
        if (rectAgente.intersects(rectWumpus))
                percepcoesAgente += "\n\nO Agente foi agarrado pelo Wumpus. \n\n";
                pontuacao -= 10000;
                JOptionPane.showMessageDialog(null, "O jogador perdeu!");
        
//        if (rectFlecha.intersects(rectWumpus))
//                pontuacao += 1000;
//                JOptionPane.showMessageDialog(null, "O Wumpus foi Atingido Pela Flecha!");
        
        if (rectAgente.intersects(rectOuro))
                pontuacao += 10000;
                JOptionPane.showMessageDialog(null,"O Agente encontrou o Ouro");
        
        
//        if (rectAgente.intersects(rectPontoInicial))
//                JOptionPane.showMessageDialog(null,"Parabens! Você Ganhou!");
        
        for (int j = 0; j < arrayPocos.size(); j++) {
                Pocos pocos = (Pocos) arrayPocos.get(j);
                Rectangle rectPocos = Constantes.getBounds(pocos.getPosicaoX(), pocos.getPosicaoY());
        
                if (rectAgente.intersects(rectPocos))
                    percepcoesAgente += "\n\nAviso: Wumpus pode encontrar-se nas posicoes ?\n\n";
        }
        
    }
}