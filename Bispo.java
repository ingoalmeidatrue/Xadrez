import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bispo extends Peca {
	//posicao da peca selecionada
	private int posicaox;
	private int posicaoy;
		
	private Tabuleiro tabuleiro;
		
	//cor da peca
	private Color cor;
		
	//booleana que diz se existe ou nao alguma peca selecionada
	private boolean podeSelecionar = true;
		
	//booleana que diz se a peca esta selecionada
	private boolean selecionada = false;
		
	//imagem da peca
	private JLabel icon;

		
	public Bispo(int posicaox, int posicaoy, Color cor, JLabel img, Tabuleiro tabuleiro){
			this.posicaox = posicaox;
			this.posicaoy = posicaoy;
			this.cor = cor;
			this.icon = img;
			this.tabuleiro = tabuleiro;
	}
	
	
	
	public void movimentarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		System.out.println(espaco.getX());
		System.out.println(espaco.getY());
		if(this.cor == Color.WHITE){
			
			//bispo branco movimenta para a diagonal inferior direita
			if(espaco.getX() > posicaox && espaco.getY() > posicaoy){
				if((espaco.getX() - posicaox)%60 == 0 && (espaco.getY() - posicaoy)%60 == 0){
					icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
					
					int posicaoAnteriorx = posicaox;
					int posicaoAnteriory = posicaoy;
					
					this.posicaoy = espaco.getY();
					this.posicaox = espaco.getX();
					
					tabuleiro.remove(espaco);
					espaco.add(new Espaco("branco"));
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
			}
		}
		else if(this.cor == Color.BLACK){
			//bispo preto movimenta para a diagonal inferior direita
			if(espaco.getX() > posicaox && espaco.getY() > posicaoy){
				if((espaco.getX() - posicaox)%60 == 0 && (espaco.getY() - posicaoy)%60 == 0){
					System.out.println("entrou11");
					icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
					
					int posicaoAnteriorx = posicaox;
					int posicaoAnteriory = posicaoy;
					
					this.posicaoy = espaco.getY();
					this.posicaox = espaco.getX();
					
					tabuleiro.remove(espaco);
					espaco.add(new Espaco("branco"));
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
			}
		}
	}

	public void atacarPeca() {

	}
	
public void mouseClicked(MouseEvent e){
		
		if(this.selecionada){			
			this.selecionada = false;
			this.tabuleiro.destravaSelecao();
		}
		else if(podeSelecionar){
			System.out.println("entrou");
			this.selecionada = true;
			tabuleiro.travaSelecao(this);
			
		}
		else if(!podeSelecionar){
			Movimentacao barraPeca = new Movimentacao(null, tabuleiro, null);
			barraPeca.setPecaBarra(this.icon);
			barraPeca.mouseClicked(e);
		}
		System.out.println(this.selecionada);
	}
	
	public boolean getSelecionada(){
		return this.selecionada;
	}
	
	public JLabel getIcon() {
		return icon;
	}
	
	public void setSelecionada(boolean selecionada) {
		this.selecionada = selecionada;
	}
	
	public boolean isPodeSelecionar() {
		return podeSelecionar;
	}
	
	public void setPodeSelecionar(boolean podeSelecionar) {
		this.podeSelecionar = podeSelecionar;
	}
}
