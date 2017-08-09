import java.awt.Color;
import java.awt.Container;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Movimentacao extends MouseAdapter {
	private JButton espaco;
	private JLabel pecaBarra = null;
	private JPanel tabuleiroJogo;
	private Tabuleiro tabuleiro;
	private Peca pecaEscolhida = null;
	
	public Movimentacao(JButton espaco,Tabuleiro tabuleiro,JPanel tabuleiroJogo){
		this.espaco = espaco;
		this.tabuleiro = tabuleiro;
		this.tabuleiroJogo = tabuleiroJogo;
	}
	
	public void mouseClicked(MouseEvent e){
		for(int i=0; i<tabuleiro.getPecas().size();i++){
			if(tabuleiro.getPecas().get(i)instanceof Peao){
				Peao peao = (Peao)tabuleiro.getPecas().get(i);
				
				if(peao.getSelecionada()){
					this.pecaEscolhida = peao;					
				}
			}
			else if(tabuleiro.getPecas().get(i)instanceof Rei){
				Rei rei = (Rei)tabuleiro.getPecas().get(i);
				
				if(rei.getSelecionada()){
					this.pecaEscolhida = rei;					
				}
			}
		}
		if(espaco!=null){
				
			tabuleiro.validarMovimento(this.pecaEscolhida, espaco);
			
			//remove informacao da peca escolhida
			this.pecaEscolhida = null;
		}
		else if(pecaBarra!=null){
			tabuleiro.validarMovimento(pecaEscolhida, pecaBarra);
			
			//remove a informacao da peca que esta na frente
			this.pecaBarra = null;
		}
	}

	public JLabel getPecaBarra() {
		return pecaBarra;
	}

	public void setPecaBarra(JLabel pecaBarra) {
		this.pecaBarra = pecaBarra;
	}
	
}