import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cavalo extends Peca {
	//posicao da peca selecionada
	private int posicaox;
	private int posicaoy;
	private int posicaoxIni;
	private int posicaoyIni;
	private boolean morta = false;
	public int getPosicaoxIni() {
		return posicaoxIni;
	}


	public void setPosicaoxIni(int posicaoxIni) {
		this.posicaoxIni = posicaoxIni;
	}


	public int getPosicaoyIni() {
		return posicaoyIni;
	}


	public void setPosicaoyIni(int posicaoyIni) {
		this.posicaoyIni = posicaoyIni;
	}


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
				this.posicaoxIni = posicaox - 40;
				this.posicaoyIni = posicaoy - 40;
				this.cor = cor;
				this.icon = img;
				this.tabuleiro = tabuleiro;
	}
	

	public void movimentarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		if(espaco!=null && pecaNaFrente == null){
		
			if(this.cor == Color.WHITE){
		
				
				//cavalo movimenta em l deitado para a esquerda comecando de cima
				if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() + 60){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l deitado para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() + 60){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l deitado para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() - 60){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l deitado para a direita começando de baixo
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() - 60){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l em pe para a esquerda comecando de cima
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() + 120){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l em pe para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() + 120){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l em pe para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() - 120){

					if(espaco.getComponentCount() == 0){

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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l em pe para a direita comecando de baixo
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() - 120){
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
					
			}
			else if(this.cor == Color.BLACK){
				
				//cavalo movimenta em l deitado para a esquerda comecando de cima
				if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() + 60){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l deitado para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() + 60){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l deitado para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() - 60){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l deitado para a direita começando de baixo
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() - 60){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l em pe para a esquerda comecando de cima
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() + 120){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l em pe para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() + 120){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l em pe para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() - 120){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
				
				//cavalo movimenta em l em pe para a direita comecando de baixo
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() - 120){
					
					if(espaco.getComponentCount() == 0){
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
					else{
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					}
				}
					
			}
		}
		else if(pecaNaFrente!=null){
			espaco = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
			
			if(this.cor == Color.WHITE){
				//cavalo movimenta em l deitado para a esquerda comecando de cima
				if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() + 60){
					
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l deitado para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() + 60){
					
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l deitado para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() - 60){
					
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
				}
				
				//cavalo movimenta em l deitado para a direita começando de baixo
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() - 60){

						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l em pe para a esquerda comecando de cima
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() + 120){

						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l em pe para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() + 120){
					
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l em pe para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() - 120){

						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l em pe para a direita comecando de baixo
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() - 120){
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "branco"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
				}
				
			}
			else if(this.cor == Color.BLACK){
				
				//cavalo movimenta em l deitado para a esquerda comecando de cima
				if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() + 60){
					
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l deitado para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() + 60){
					
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l deitado para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 120 && posicaoy == espaco.getY() - 60){
					
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
				}
				
				//cavalo movimenta em l deitado para a direita começando de baixo
				else if(posicaox == espaco.getX()  + 120 && posicaoy == espaco.getY() - 60){

						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l em pe para a esquerda comecando de cima
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() + 120){

						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l em pe para a direita comecando de cima
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() + 120){
					
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l em pe para a esquerda comecando de baixo
				else if(posicaox == espaco.getX()  - 60 && posicaoy == espaco.getY() - 120){

						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
					
				}
				
				//cavalo movimenta em l em pe para a direita comecando de baixo
				else if(posicaox == espaco.getX()  + 60 && posicaoy == espaco.getY() - 120){
						Espaco espacoAux = (Espaco) espaco.getComponent(0);
						
						//clicou num espaco que tem uma peca de mesma cor
						if(espacoAux.getNome() == "preto"){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
						//clicou numa peca de outra cor para atacar
						else{
							this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
						}
				}
			}
		}
				
	}

	public void atacarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		//clica no canto do espaco
		if(espaco!=null && pecaNaFrente == null){
			if(this.cor == Color.BLACK){
				JLabel pecaComida = (JLabel) tabuleiro.getComponentAt(espaco.getX(),espaco.getY());
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaComida.getMouseListeners()[0]);
				new PecaMorta().check(pecaComida.getMouseListeners()[0]);
				tabuleiro.remove(pecaComida);
				espaco.remove(0);
				
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
			else if(this.cor == Color.WHITE){
				JLabel pecaComida = (JLabel) tabuleiro.getComponentAt(espaco.getX(),espaco.getY());
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaComida.getMouseListeners()[0]);
				new PecaMorta().check(pecaComida.getMouseListeners()[0]);
				tabuleiro.remove(pecaComida);
				espaco.remove(0);
				
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
		//clica no JLabel
		else if(pecaNaFrente != null){
			if(this.cor == Color.BLACK){
				
				espaco = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaNaFrente.getMouseListeners()[0]);
				new PecaMorta().check(pecaNaFrente.getMouseListeners()[0]);
				int posicaoAtualX = pecaNaFrente.getX();
				int posicaoAtualY = pecaNaFrente.getY();
				
				tabuleiro.remove(pecaNaFrente);
				espaco.remove(0);
				
				icon.setBounds(posicaoAtualX, posicaoAtualY, 50,50);
		
				
				int posicaoAnteriorx = posicaox;
				int posicaoAnteriory = posicaoy;
				
				this.posicaoy = posicaoAtualY;
				this.posicaox = posicaoAtualX;
				
				tabuleiro.remove(espaco);
				espaco.add(new Espaco("preto"));
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaoAnteriorx, posicaoAnteriory);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.repaint();
				
			}
			else if(this.cor == Color.WHITE){
				espaco = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaNaFrente.getMouseListeners()[0]);
				new PecaMorta().check(pecaNaFrente.getMouseListeners()[0]);
				int posicaoAtualX = pecaNaFrente.getX();
				int posicaoAtualY = pecaNaFrente.getY();
				
				tabuleiro.remove(pecaNaFrente);
				espaco.remove(0);
				
				icon.setBounds(posicaoAtualX, posicaoAtualY, 50,50);
		
				
				int posicaoAnteriorx = posicaox;
				int posicaoAnteriory = posicaoy;
				
				this.posicaoy = posicaoAtualY;
				this.posicaox = posicaoAtualX;
				
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
	
	public void mouseClicked(MouseEvent e){
		if(this.morta){
		}
		else if(this.selecionada){	
			this.desativaHighlight();
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


	public int getPosicaox() {
		return posicaox;
	}


	public void setPosicaox(int posicaox) {
		this.posicaox = posicaox;
	}


	public int getPosicaoy() {
		return posicaoy;
	}


	public void setPosicaoy(int posicaoy) {
		this.posicaoy = posicaoy;
	}
	
	
}
