import java.awt.Color;
import java.awt.Component;
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
	
	private boolean verificaEspacoSuperiorEsquerda(JButton espaco,JPanel tabuleiro){
		int posicaoAuxX = posicaox,posicaoAuxY = posicaoy;
		
		//a posicao que o usuario clicou nao precisa ser verificada, pois verificaremos por ultimo na funcao movimentar peca
		while(posicaoAuxX - 60 != espaco.getX() && posicaoAuxY - 60 != espaco.getY()){
			if(tabuleiro.getComponentAt(posicaoAuxX - 60, posicaoAuxY - 60)instanceof JLabel ){
				return false;
			}
			else if(tabuleiro.getComponentAt(posicaoAuxX - 60, posicaoAuxY - 60)instanceof JButton){
				JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoAuxX - 60, posicaoAuxY - 60);
		
				if(espacoAux.getComponentCount() != 0){
					return false;
				}
			}
			posicaoAuxX = posicaoAuxX - 60;
			posicaoAuxY = posicaoAuxY - 60;
		}
		return true;
}
	
	private boolean verificaEspacoSuperiorDireita(JButton espaco,JPanel tabuleiro){
		int posicaoAuxX = posicaox,posicaoAuxY = posicaoy;
		
		while(posicaoAuxX + 60 != espaco.getX() && posicaoAuxY - 60!= espaco.getY()){
			if(tabuleiro.getComponentAt(posicaoAuxX + 60, posicaoAuxY - 60)instanceof JLabel ){
				return false;
			}
			else if(tabuleiro.getComponentAt(posicaoAuxX + 60, posicaoAuxY - 60)instanceof JButton){
				JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoAuxX + 60, posicaoAuxY - 60);
				
				if(espacoAux.getComponentCount() != 0){
					return false;
				}
			}
			posicaoAuxX = posicaoAuxX + 60;
			posicaoAuxY = posicaoAuxY - 60;
		}
		return true;
}

	private boolean verificaEspacoInferiorDireita(JButton espaco,JPanel tabuleiro){
		int posicaoAuxX = posicaox,posicaoAuxY = posicaoy;
	
		while(posicaoAuxX + 60!= espaco.getX() && posicaoAuxY + 60!= espaco.getY()){
			if(tabuleiro.getComponentAt(posicaoAuxX + 60, posicaoAuxY + 60)instanceof JLabel ){
				return false;
			}
			else if(tabuleiro.getComponentAt(posicaoAuxX + 60, posicaoAuxY + 60)instanceof JButton){
				JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoAuxX + 60, posicaoAuxY + 60);

				if(espacoAux.getComponentCount() != 0){
					return false;
				}
			}
			posicaoAuxX = posicaoAuxX + 60;
			posicaoAuxY = posicaoAuxY + 60;
		}
		return true;
	}

	private boolean verificaEspacoInferiorEsquerda(JButton espaco,JPanel tabuleiro){
		int posicaoAuxX = posicaox,posicaoAuxY = posicaoy;
		
		while(posicaoAuxX - 60 != espaco.getX() && posicaoAuxY + 60 != espaco.getY()){
			if(tabuleiro.getComponentAt(posicaoAuxX - 60, posicaoAuxY + 60)instanceof JLabel ){
				return false;
			}
			else if(tabuleiro.getComponentAt(posicaoAuxX - 60, posicaoAuxY + 60)instanceof JButton){
				JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoAuxX - 60, posicaoAuxY + 60);
	
				if(espacoAux.getComponentCount() != 0){
					return false;
				}
			}
			posicaoAuxX = posicaoAuxX - 60;
			posicaoAuxY = posicaoAuxY + 60;
		}
		return true;
	}
	
	
	
	
	
	
	public void movimentarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		
		if(espaco!=null && pecaNaFrente == null){
			if(this.cor == Color.WHITE){
					//bispo branco movimenta para a diagonal superior esquerda
					if(espaco.getX() < posicaox && espaco.getY() < posicaoy){
							//verifica se clicou na mesma diagonal que o bispo esta
							if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy)){
								
								//verifica se existe alguma peça no caminho do bispo
								if(verificaEspacoSuperiorEsquerda(espaco,tabuleiro)){
									//eh um movimento
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
									//ou ataca peca, ou clicou num espaco que tem peca de mesma cor
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
								//tem uma peca no caminho do bispo
								else{
									this.selecionada = false;
									this.tabuleiro.destravaSelecao();
								}
							}
							//o bispo nao clicou em sua diagonal
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						
					//bispo branco movimenta para a diagonal superior direita
					else if(espaco.getX() > posicaox && espaco.getY() < posicaoy){
						
						if((espaco.getX() - posicaox) == (posicaoy - espaco.getY())){
							
							//verifica se existe alguma peça no caminho do bispo
							if(verificaEspacoSuperiorDireita(espaco,tabuleiro)){
								//eh um movimento
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
								//ou ataca peca, ou clicou num espaco que tem peca de mesma cor
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
							//tem uma peca no caminho do bispo
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
							
						}
						//o bispo nao clicou em sua diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					
					//bispo branco movimenta para a diagonal inferior esquerda
					else if(espaco.getX() < posicaox && espaco.getY() > posicaoy){

						if((posicaox - espaco.getX()) == (espaco.getY() - posicaoy)){

							//verifica se existe alguma peça no caminho do bispo
							if(verificaEspacoInferiorEsquerda(espaco,tabuleiro)){
								//eh um movimento
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
								//ou ataca peca, ou clicou num espaco que tem peca de mesma cor
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
							//tem uma peca no caminho do bispo
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						//o bispo nao clicou em sua diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					
					//bispo branco movimenta para a diagonal inferior direita
					else if(espaco.getX() > posicaox && espaco.getY() > posicaoy){
						
							if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy) ){
								
								//verifica se existe alguma peça no caminho do bispo
								if(verificaEspacoInferiorDireita(espaco,tabuleiro)){
									//eh um movimento
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
									//ou ataca peca, ou clicou num espaco que tem peca de mesma cor
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
								//tem uma peca no caminho do bispo
								else{
									this.selecionada = false;
									this.tabuleiro.destravaSelecao();
								}
							}
							//o bispo nao clicou em sua diagonal
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
			}
			else if(this.cor == Color.BLACK){
				
				//bispo preto movimenta para a diagonal superior esquerda
				if(espaco.getX() < posicaox && espaco.getY() < posicaoy){
						//verifica se clicou na mesma diagonal que o bispo esta
						if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy)){
							
							//verifica se existe alguma peça no caminho do bispo
							if(verificaEspacoSuperiorEsquerda(espaco,tabuleiro)){
								//eh um movimento
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
								//ou ataca peca, ou clicou num espaco que tem peca de mesma cor
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
							//tem uma peca no caminho do bispo
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						//o bispo nao clicou em sua diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					
				//bispo preto movimenta para a diagonal superior direita
				else if(espaco.getX() > posicaox && espaco.getY() < posicaoy){
					
					if((espaco.getX() - posicaox) == (posicaoy - espaco.getY())){
						
						//verifica se existe alguma peça no caminho do bispo
						if(verificaEspacoSuperiorDireita(espaco,tabuleiro)){
							//eh um movimento
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
							//ou ataca peca, ou clicou num espaco que tem peca de mesma cor
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
						//tem uma peca no caminho do bispo
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
					}
					//o bispo nao clicou em sua diagonal
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
				
				//bispo preto movimenta para a diagonal inferior esquerda
				else if(espaco.getX() < posicaox && espaco.getY() > posicaoy){

					if((posicaox - espaco.getX()) == (espaco.getY() - posicaoy)){

						//verifica se existe alguma peça no caminho do bispo
						if(verificaEspacoInferiorEsquerda(espaco,tabuleiro)){
							//eh um movimento
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
							//ou ataca peca, ou clicou num espaco que tem peca de mesma cor
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
						//tem uma peca no caminho do bispo
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					//o bispo nao clicou em sua diagonal
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
				
				//bispo preto movimenta para a diagonal inferior direita
				else if(espaco.getX() > posicaox && espaco.getY() > posicaoy){
					
						if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy) ){
							
							//verifica se existe alguma peça no caminho do bispo
							if(verificaEspacoInferiorDireita(espaco,tabuleiro)){
								//eh um movimento
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
								//ou ataca peca, ou clicou num espaco que tem peca de mesma cor
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
							//tem uma peca no caminho do bispo
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						//o bispo nao clicou em sua diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
			}
		}
		else if(pecaNaFrente!=null){
			this.selecionada = false;
			this.tabuleiro.destravaSelecao();
		}
	}
	

	public void atacarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		//clica no canto do espaco
		if(espaco!=null && pecaNaFrente == null){
			if(this.cor == Color.BLACK){
				JLabel pecaComida = (JLabel) tabuleiro.getComponentAt(espaco.getX(),espaco.getY());
				
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
}
