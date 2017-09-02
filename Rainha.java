import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rainha extends Peca {
	
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
	
			
	public Rainha(int posicaox, int posicaoy, Color cor, JLabel img, Tabuleiro tabuleiro){
				this.posicaox = posicaox;
				this.posicaoy = posicaoy;
				this.posicaoxIni = posicaox - 40;
				this.posicaoyIni = posicaoy - 40;
				this.cor = cor;
				this.icon = img;
				this.tabuleiro = tabuleiro;
	}
	
	private boolean verificaEspacoSuperior(JButton espaco,JPanel tabuleiro){
    	int posicaoAuxX = posicaox,posicaoAuxY = posicaoy;

    	while(posicaoAuxY - 60 != espaco.getY() && posicaoAuxX == espaco.getX()){
    		if(tabuleiro.getComponentAt(posicaoAuxX, posicaoAuxY - 60)instanceof JLabel ){
    			return false;
    		}
    		else if(tabuleiro.getComponentAt(posicaoAuxX, posicaoAuxY - 60)instanceof JButton){
    			JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoAuxX, posicaoAuxY - 60);
    			if(espacoAux.getComponentCount() != 0){
    	
    				return false;
    			}
    		}
    		posicaoAuxY = posicaoAuxY - 60;
    	}
    	return true;
    }

	private boolean verificaEspacoInferior(JButton espaco,JPanel tabuleiro){
			int posicaoAuxX = posicaox,posicaoAuxY = posicaoy;
	
			while(posicaoAuxY + 60 != espaco.getY() && posicaoAuxX == espaco.getX()){
				if(tabuleiro.getComponentAt(posicaoAuxX, posicaoAuxY + 60)instanceof JLabel ){
					return false;
				}
				else if(tabuleiro.getComponentAt(posicaoAuxX, posicaoAuxY + 60)instanceof JButton){
					JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoAuxX, posicaoAuxY + 60);
					if(espacoAux.getComponentCount() != 0){
						return false;
					}
				}
				posicaoAuxY = posicaoAuxY + 60;
			}
			return true;
	}

	private boolean verificaEspacoLateralDireita(JButton espaco,JPanel tabuleiro){
		int posicaoAuxX = posicaox,posicaoAuxY = posicaoy;

		while(posicaoAuxY == espaco.getY() && posicaoAuxX + 60 != espaco.getX()){
			if(tabuleiro.getComponentAt(posicaoAuxX + 60, posicaoAuxY)instanceof JLabel ){
				return false;
			}
			else if(tabuleiro.getComponentAt(posicaoAuxX + 60, posicaoAuxY)instanceof JButton){
				JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoAuxX + 60, posicaoAuxY);
				if(espacoAux.getComponentCount() != 0){
					return false;
				}
			}
			posicaoAuxX = posicaoAuxX + 60;
		}
		return true;
	}

	private boolean verificaEspacoLateralEsquerda(JButton espaco,JPanel tabuleiro){
		int posicaoAuxX = posicaox,posicaoAuxY = posicaoy;
	
		while(posicaoAuxY == espaco.getY() && posicaoAuxX - 60 != espaco.getX()){
			if(tabuleiro.getComponentAt(posicaoAuxX - 60, posicaoAuxY)instanceof JLabel ){
				return false;
			}
			else if(tabuleiro.getComponentAt(posicaoAuxX - 60, posicaoAuxY)instanceof JButton){
				JButton espacoAux = (JButton)tabuleiro.getComponentAt(posicaoAuxX - 60, posicaoAuxY);
				if(espacoAux.getComponentCount() != 0){
					return false;
				}
			}	
			posicaoAuxX = posicaoAuxX - 60;
		}
		return true;
	}
		
	private boolean verificaEspacoSuperiorEsquerda(JButton espaco,JPanel tabuleiro){
			int posicaoAuxX = posicaox,posicaoAuxY = posicaoy;
			
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
			
			while(posicaoAuxX + 60 != espaco.getX() && posicaoAuxY - 60 != espaco.getY()){
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
		
		while(posicaoAuxX + 60 != espaco.getX() && posicaoAuxY + 60 != espaco.getY()){
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
		
		while(posicaoAuxX - 60!= espaco.getX() && posicaoAuxY + 60 != espaco.getY()){
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
				
					//Rainha branca movimenta para cima
					if(espaco.getY() < posicaoy && espaco.getX() == posicaox){
					
						//verifica se existe alguma peça no caminho
						if(verificaEspacoSuperior(espaco,tabuleiro)){
					
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
			
					//rainha branca movimenta para baixo
					else if(espaco.getY() > posicaoy && espaco.getX() == posicaox){
						
						//verifica se existe alguma peça no caminho
						if(verificaEspacoInferior(espaco,tabuleiro)){
			
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
		
					//rainha branca movimenta para esquerda
					else if(espaco.getY() == posicaoy && espaco.getX() < posicaox){
						//verifica se existe alguma peça no caminho
						if(verificaEspacoLateralEsquerda(espaco,tabuleiro)){
			
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
		
					//rainha branca movimenta para a direita
					else if(espaco.getY() == posicaoy && espaco.getX() > posicaox){
						//verifica se existe alguma peça no caminho
						if(verificaEspacoLateralDireita(espaco,tabuleiro)){
			
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				
				
					//rainha branco movimenta para a diagonal superior esquerda
					if(espaco.getX() < posicaox && espaco.getY() < posicaoy){
							//verifica se clicou na mesma diagonal que a rainha esta
							if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy)){
								
								//verifica se existe alguma peça no caminho da rainha
								if(verificaEspacoSuperiorEsquerda(espaco,tabuleiro)){
								
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
								//tem uma peca no caminho
								else{
									this.selecionada = false;
									this.tabuleiro.destravaSelecao();
								}
							}
							//nao clicou na mesma diagonal
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
					
					//rainha branco movimenta para a diagonal superior direita
					else if(espaco.getX() > posicaox && espaco.getY() < posicaoy){
						
						if((espaco.getX() - posicaox) == (posicaoy - espaco.getY())){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoSuperiorDireita(espaco,tabuleiro)){
							
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
							//tem uma peca no caminho
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
							
						}
						//nao clicou na mesma diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				
					//rainha branco movimenta para a diagonal inferior esquerda
					else if(espaco.getX() < posicaox && espaco.getY() > posicaoy){
						if((posicaox - espaco.getX()) == (espaco.getY() - posicaoy)){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoInferiorEsquerda(espaco,tabuleiro)){
							
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
							//tem uma peca no caminho
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						//nao clicou na mesma diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				
					//rainha branco movimenta para a diagonal inferior direita
					else if(espaco.getX() > posicaox && espaco.getY() > posicaoy){
							if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy) ){
								
								//verifica se existe alguma peça no caminho da rainha
								if(verificaEspacoInferiorDireita(espaco,tabuleiro)){
								
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
								//tem uma peca no caminho
								else{
									this.selecionada = false;
									this.tabuleiro.destravaSelecao();
								}
							}
							//nao clicou na mesma diagonal
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
							
					}
					//clicou numa posicao invalida
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
			
				else if(this.cor == Color.BLACK){
					
					//movimenta para cima
					if(espaco.getY() < posicaoy && espaco.getX() == posicaox){
					
						//verifica se existe alguma peça no caminho
						if(verificaEspacoSuperior(espaco,tabuleiro)){
					
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
			
					//movimenta para baixo
					else if(espaco.getY() > posicaoy && espaco.getX() == posicaox){
						//verifica se existe alguma peça no caminho
						if(verificaEspacoInferior(espaco,tabuleiro)){
			
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
		
					//movimenta para esquerda
					else if(espaco.getY() == posicaoy && espaco.getX() < posicaox){
						
						//verifica se existe alguma peça no caminho
						if(verificaEspacoLateralEsquerda(espaco,tabuleiro)){
			
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
		
					//movimenta para a direita
					else if(espaco.getY() == posicaoy && espaco.getX() > posicaox){
						
						//verifica se existe alguma peça no caminho
						if(verificaEspacoLateralDireita(espaco,tabuleiro)){
			
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				
					//rainha preto movimenta para a diagonal superior esquerda
					if(espaco.getX() < posicaox && espaco.getY() < posicaoy){
	
						if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy)){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoSuperiorEsquerda(espaco,tabuleiro)){
							
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
							//tem uma peca no caminho
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
			
						}
						//nao clicou na mesma diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					
					//rainha preto movimenta para a diagonal superior direita
					else if(espaco.getX() > posicaox && espaco.getY() < posicaoy){
						
						if((espaco.getX() - posicaox) == (posicaoy - espaco.getY())){
													
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoSuperiorDireita(espaco,tabuleiro)){
							
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
							//tem uma peca no caminho
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						//nao clicou na mesma diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					
					//rainha preto movimenta para a diagonal inferior esquerda
					else if(espaco.getX() < posicaox && espaco.getY() > posicaoy){
						
						if((posicaox - espaco.getX()) == (espaco.getY() - posicaoy)){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoInferiorEsquerda(espaco,tabuleiro)){
							
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
							//tem uma peca no caminho
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						//nao clicou na mesma diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					
					//rainha preto movimenta para a diagonal inferior direita
					if(espaco.getX() > posicaox && espaco.getY() > posicaoy){
	
						if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy)){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoInferiorDireita(espaco,tabuleiro)){
							
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
							//tem uma peca no caminho
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						//nao clicou na mesma diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
			}
		}
		else if(pecaNaFrente!=null){
			espaco = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
			
			if(this.cor == Color.WHITE){
				
				//Rainha branca movimenta para cima
				if(espaco.getY() < posicaoy && espaco.getX() == posicaox){
				
					//verifica se existe alguma peça no caminho
					if(verificaEspacoSuperior(espaco,tabuleiro)){
				
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
					//tem uma peca no caminho
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
		
				//rainha branca movimenta para baixo
				else if(espaco.getY() > posicaoy && espaco.getX() == posicaox){
					
					//verifica se existe alguma peça no caminho
					if(verificaEspacoInferior(espaco,tabuleiro)){
		
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
					//tem uma peca no caminho
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
	
				//rainha branca movimenta para esquerda
				else if(espaco.getY() == posicaoy && espaco.getX() < posicaox){
					//verifica se existe alguma peça no caminho
					if(verificaEspacoLateralEsquerda(espaco,tabuleiro)){
		
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
					//tem uma peca no caminho
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
	
				//rainha branca movimenta para a direita
				else if(espaco.getY() == posicaoy && espaco.getX() > posicaox){
					//verifica se existe alguma peça no caminho
					if(verificaEspacoLateralDireita(espaco,tabuleiro)){
		
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
					//tem uma peca no caminho
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
			
			
				//rainha branco movimenta para a diagonal superior esquerda
				if(espaco.getX() < posicaox && espaco.getY() < posicaoy){
						//verifica se clicou na mesma diagonal que a rainha esta
						if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy)){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoSuperiorEsquerda(espaco,tabuleiro)){
							
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
							//tem uma peca no caminho
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						//nao clicou na mesma diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				
				//rainha branco movimenta para a diagonal superior direita
				else if(espaco.getX() > posicaox && espaco.getY() < posicaoy){
					
					if((espaco.getX() - posicaox) == (posicaoy - espaco.getY())){
						
						//verifica se existe alguma peça no caminho da rainha
						if(verificaEspacoSuperiorDireita(espaco,tabuleiro)){
						
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
					}
					//nao clicou na mesma diagonal
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
			
				//rainha branco movimenta para a diagonal inferior esquerda
				else if(espaco.getX() < posicaox && espaco.getY() > posicaoy){
					if((posicaox - espaco.getX()) == (espaco.getY() - posicaoy)){
						
						//verifica se existe alguma peça no caminho da rainha
						if(verificaEspacoInferiorEsquerda(espaco,tabuleiro)){
						
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					//nao clicou na mesma diagonal
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
			
				//rainha branco movimenta para a diagonal inferior direita
				else if(espaco.getX() > posicaox && espaco.getY() > posicaoy){
						if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy) ){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoInferiorDireita(espaco,tabuleiro)){
							
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
							//tem uma peca no caminho
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						//nao clicou na mesma diagonal
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
						
				}
				//clicou numa posicao invalida
				else{
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
				}
			}
		
			else if(this.cor == Color.BLACK){
				
				//movimenta para cima
				if(espaco.getY() < posicaoy && espaco.getX() == posicaox){
				
					//verifica se existe alguma peça no caminho
					if(verificaEspacoSuperior(espaco,tabuleiro)){
				
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
					//tem uma peca no caminho
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
		
				//movimenta para baixo
				else if(espaco.getY() > posicaoy && espaco.getX() == posicaox){
					//verifica se existe alguma peça no caminho
					if(verificaEspacoInferior(espaco,tabuleiro)){
		
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
					//tem uma peca no caminho
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
	
				//movimenta para esquerda
				else if(espaco.getY() == posicaoy && espaco.getX() < posicaox){
					
					//verifica se existe alguma peça no caminho
					if(verificaEspacoLateralEsquerda(espaco,tabuleiro)){
		
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
					//tem uma peca no caminho
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
	
				//movimenta para a direita
				else if(espaco.getY() == posicaoy && espaco.getX() > posicaox){
					
					//verifica se existe alguma peça no caminho
					if(verificaEspacoLateralDireita(espaco,tabuleiro)){
		
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
					//tem uma peca no caminho
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
			
				//rainha preto movimenta para a diagonal superior esquerda
				if(espaco.getX() < posicaox && espaco.getY() < posicaoy){

					if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy)){
						
						//verifica se existe alguma peça no caminho da rainha
						if(verificaEspacoSuperiorEsquerda(espaco,tabuleiro)){
						
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
		
					}
					//nao clicou na mesma diagonal
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
				
				//rainha preto movimenta para a diagonal superior direita
				else if(espaco.getX() > posicaox && espaco.getY() < posicaoy){
					
					if((espaco.getX() - posicaox) == (posicaoy - espaco.getY())){
												
						//verifica se existe alguma peça no caminho da rainha
						if(verificaEspacoSuperiorDireita(espaco,tabuleiro)){
						
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					//nao clicou na mesma diagonal
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
				
				//rainha preto movimenta para a diagonal inferior esquerda
				else if(espaco.getX() < posicaox && espaco.getY() > posicaoy){
					
					if((posicaox - espaco.getX()) == (espaco.getY() - posicaoy)){
						
						//verifica se existe alguma peça no caminho da rainha
						if(verificaEspacoInferiorEsquerda(espaco,tabuleiro)){
						
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					//nao clicou na mesma diagonal
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
				
				//rainha preto movimenta para a diagonal inferior direita
				if(espaco.getX() > posicaox && espaco.getY() > posicaoy){

					if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy)){
						
						//verifica se existe alguma peça no caminho da rainha
						if(verificaEspacoInferiorDireita(espaco,tabuleiro)){
						
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
						//tem uma peca no caminho
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					//nao clicou na mesma diagonal
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
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
	
	public boolean isMorta() {
		return morta;
	}

	public void setMorta(boolean morta) {
		this.morta = morta;
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



