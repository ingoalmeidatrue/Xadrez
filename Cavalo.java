import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cavalo extends Peca {
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
	
			
	public Cavalo(int posicaox, int posicaoy, Color cor, JLabel img, Tabuleiro tabuleiro){
				this.posicaox = posicaox;
				this.posicaoy = posicaoy;
				this.cor = cor;
				this.icon = img;
				this.tabuleiro = tabuleiro;
	}
	

	public void movimentarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		if(espaco!=null && pecaNaFrente == null){
			if(this.cor == Color.WHITE){
				
				//cavalo movimenta em l deitado para a esquerda comecando de cima
				if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() + 60 && espaco.getComponentCount() == 0){
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
				
				//cavalo movimenta em l deitado para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() + 60 && espaco.getComponentCount() == 0){
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
				
				//cavalo movimenta em l deitado para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() - 60 && espaco.getComponentCount() == 0){
					
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
				
				//cavalo movimenta em l deitado para a direita começando de baixo
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() - 60 && espaco.getComponentCount() == 0){
					
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
				
				//cavalo movimenta em l em pe para a esquerda comecando de cima
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() + 120 && espaco.getComponentCount() == 0){
					
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
				
				//cavalo movimenta em l em pe para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() + 120 && espaco.getComponentCount() == 0){
					
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
				
				//cavalo movimenta em l em pe para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() - 120 && espaco.getComponentCount() == 0){
					
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
				
				//cavalo movimenta em l em pe para a direita comecando de baixo
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() - 120 && espaco.getComponentCount() == 0){
					
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
			else if(this.cor == Color.BLACK){
				
				//cavalo movimenta em l deitado para a esquerda comecando de cima
				if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() + 60 && espaco.getComponentCount() == 0){
					icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
					
					int posicaoAnteriorx = posicaox;
					int posicaoAnteriory = posicaoy;
		
					this.posicaoy = espaco.getY();
					this.posicaox = espaco.getX();
		
					tabuleiro.remove(espaco);
					espaco.add(new Espaco("preto"));
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
				
				//cavalo movimenta em l deitado para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() + 60 && espaco.getComponentCount() == 0){
					icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
					
					int posicaoAnteriorx = posicaox;
					int posicaoAnteriory = posicaoy;
		
					this.posicaoy = espaco.getY();
					this.posicaox = espaco.getX();
		
					tabuleiro.remove(espaco);
					espaco.add(new Espaco("preto"));
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
				
				//cavalo movimenta em l deitado para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() - 60 && espaco.getComponentCount() == 0){
					
					icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
					
					int posicaoAnteriorx = posicaox;
					int posicaoAnteriory = posicaoy;
		
					this.posicaoy = espaco.getY();
					this.posicaox = espaco.getX();
		
					tabuleiro.remove(espaco);
					espaco.add(new Espaco("preto"));
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
				
				//cavalo movimenta em l deitado para a direita começando de baixo
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() - 60 && espaco.getComponentCount() == 0){
					
					icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
					
					int posicaoAnteriorx = posicaox;
					int posicaoAnteriory = posicaoy;
		
					this.posicaoy = espaco.getY();
					this.posicaox = espaco.getX();
		
					tabuleiro.remove(espaco);
					espaco.add(new Espaco("preto"));
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
				
				//cavalo movimenta em l em pe para a esquerda comecando de cima
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() + 120 && espaco.getComponentCount() == 0){
					
					icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
					
					int posicaoAnteriorx = posicaox;
					int posicaoAnteriory = posicaoy;
		
					this.posicaoy = espaco.getY();
					this.posicaox = espaco.getX();
		
					tabuleiro.remove(espaco);
					espaco.add(new Espaco("preto"));
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
				
				//cavalo movimenta em l em pe para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() + 120 && espaco.getComponentCount() == 0){
					
					icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
					
					int posicaoAnteriorx = posicaox;
					int posicaoAnteriory = posicaoy;
		
					this.posicaoy = espaco.getY();
					this.posicaox = espaco.getX();
		
					tabuleiro.remove(espaco);
					espaco.add(new Espaco("preto"));
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
				
				//cavalo movimenta em l em pe para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() - 120 && espaco.getComponentCount() == 0){
					
					icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
					
					int posicaoAnteriorx = posicaox;
					int posicaoAnteriory = posicaoy;
		
					this.posicaoy = espaco.getY();
					this.posicaox = espaco.getX();
		
					tabuleiro.remove(espaco);
					espaco.add(new Espaco("preto"));
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
				
				//cavalo movimenta em l em pe para a direita comecando de baixo
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() - 120 && espaco.getComponentCount() == 0){
					
					icon.setBounds(espaco.getX(), espaco.getY(), 50,50);
					
					int posicaoAnteriorx = posicaox;
					int posicaoAnteriory = posicaoy;
		
					this.posicaoy = espaco.getY();
					this.posicaox = espaco.getX();
		
					tabuleiro.remove(espaco);
					espaco.add(new Espaco("preto"));
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
					
			}
		}
		else if(pecaNaFrente!=null){
			this.selecionada = false;
			this.tabuleiro.destravaSelecao();
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
			this.selecionada = true;
			tabuleiro.travaSelecao(this);
			
		}
		else if(!podeSelecionar){
			Movimentacao barraPeca = new Movimentacao(null, tabuleiro, null);
			barraPeca.setPecaBarra(this.icon);
			barraPeca.mouseClicked(e);
		}

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
	
	public boolean getPodeSelecionar() {
		return this.podeSelecionar;
	}
	
}
