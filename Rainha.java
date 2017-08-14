import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rainha extends Peca {
	
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
	
			
	public Rainha(int posicaox, int posicaoy, Color cor, JLabel img, Tabuleiro tabuleiro){
				this.posicaox = posicaox;
				this.posicaoy = posicaoy;
				this.cor = cor;
				this.icon = img;
				this.tabuleiro = tabuleiro;
	}
	
	private boolean verificaEspacoSuperior(JButton espaco,JPanel tabuleiro){
    	int posicaoAuxX = posicaox,posicaoAuxY = posicaoy;

    	while(posicaoAuxY != espaco.getY() && posicaoAuxX == espaco.getX()){
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
	
			while(posicaoAuxY != espaco.getY() && posicaoAuxX == espaco.getX()){
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

		while(posicaoAuxY == espaco.getY() && posicaoAuxX != espaco.getX()){
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
	
		while(posicaoAuxY == espaco.getY() && posicaoAuxX != espaco.getX()){
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
			
			while(posicaoAuxX != espaco.getX() && posicaoAuxY != espaco.getY()){
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
			
			while(posicaoAuxX != espaco.getX() && posicaoAuxY != espaco.getY()){
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
		
		while(posicaoAuxX != espaco.getX() && posicaoAuxY != espaco.getY()){
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
		
		while(posicaoAuxX != espaco.getX() && posicaoAuxY != espaco.getY()){
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
				
					//Torre branca movimenta para cima
					if(espaco.getY() < posicaoy && espaco.getX() == posicaox && espaco.getComponentCount() == 0){
					
						//verifica se existe alguma peça no caminho da torre
						if(verificaEspacoSuperior(espaco,tabuleiro)){
					
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
						else if(verificaEspacoSuperior(espaco,tabuleiro) == false){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
			
					//torre branca movimenta para baixo
					else if(espaco.getY() > posicaoy && espaco.getX() == posicaox && espaco.getComponentCount() == 0){
						//verifica se existe alguma peça no caminho da torre
						if(verificaEspacoInferior(espaco,tabuleiro)){
			
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
						else if(verificaEspacoInferior(espaco,tabuleiro) == false){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
		
					//torre branca movimenta para esquerda
					else if(espaco.getY() == posicaoy && espaco.getX() < posicaox && espaco.getComponentCount() == 0){
						//verifica se existe alguma peça no caminho da torre
						if(verificaEspacoLateralEsquerda(espaco,tabuleiro)){
			
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
						else if(verificaEspacoLateralEsquerda(espaco,tabuleiro) == false){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
		
					//torre branca movimenta para a direita
					else if(espaco.getY() == posicaoy && espaco.getX() > posicaox && espaco.getComponentCount() == 0){
						//verifica se existe alguma peça no caminho da torre
						if(verificaEspacoLateralDireita(espaco,tabuleiro)){
			
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
						else if(verificaEspacoLateralEsquerda(espaco,tabuleiro) == false){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				
				
					//rainha branco movimenta para a diagonal superior esquerda
					if(espaco.getX() < posicaox && espaco.getY() < posicaoy && espaco.getComponentCount() == 0){
							//verifica se clicou na mesma diagonal que a rainha esta
							if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy)){
								
								//verifica se existe alguma peça no caminho da rainha
								if(verificaEspacoSuperiorEsquerda(espaco,tabuleiro)){
								
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
									this.selecionada = false;
									this.tabuleiro.destravaSelecao();
								}
							}
							else{
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
					
					//rainha branco movimenta para a diagonal superior direita
					else if(espaco.getX() > posicaox && espaco.getY() < posicaoy && espaco.getComponentCount() == 0){
						
						if((espaco.getX() - posicaox) == (posicaoy - espaco.getY())){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoSuperiorDireita(espaco,tabuleiro)){
							
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
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
							
						}
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				
					//rainha branco movimenta para a diagonal inferior esquerda
					else if(espaco.getX() < posicaox && espaco.getY() > posicaoy && espaco.getComponentCount() == 0){
						if((posicaox - espaco.getX()) == (espaco.getY() - posicaoy)){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoInferiorEsquerda(espaco,tabuleiro)){
							
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
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				
					//rainha branco movimenta para a diagonal inferior direita
					else if(espaco.getX() > posicaox && espaco.getY() > posicaoy && espaco.getComponentCount() == 0){
							if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy) ){
								
								//verifica se existe alguma peça no caminho da rainha
								if(verificaEspacoInferiorDireita(espaco,tabuleiro)){
								
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
									this.selecionada = false;
									this.tabuleiro.destravaSelecao();
								}
							}
					}
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
				}
			
				else if(this.cor == Color.BLACK){
					
					//Torre branca movimenta para cima
					if(espaco.getY() < posicaoy && espaco.getX() == posicaox && espaco.getComponentCount() == 0){
					
						//verifica se existe alguma peça no caminho da torre
						if(verificaEspacoSuperior(espaco,tabuleiro)){
					
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
						else if(verificaEspacoSuperior(espaco,tabuleiro) == false){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
			
					//torre branca movimenta para baixo
					else if(espaco.getY() > posicaoy && espaco.getX() == posicaox && espaco.getComponentCount() == 0){
						//verifica se existe alguma peça no caminho da torre
						if(verificaEspacoInferior(espaco,tabuleiro)){
			
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
						else if(verificaEspacoInferior(espaco,tabuleiro) == false){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
		
					//torre branca movimenta para esquerda
					else if(espaco.getY() == posicaoy && espaco.getX() < posicaox && espaco.getComponentCount() == 0){
						//verifica se existe alguma peça no caminho da torre
						if(verificaEspacoLateralEsquerda(espaco,tabuleiro)){
			
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
						else if(verificaEspacoLateralEsquerda(espaco,tabuleiro) == false){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
		
					//torre branca movimenta para a direita
					else if(espaco.getY() == posicaoy && espaco.getX() > posicaox && espaco.getComponentCount() == 0){
						//verifica se existe alguma peça no caminho da torre
						if(verificaEspacoLateralDireita(espaco,tabuleiro)){
			
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
						else if(verificaEspacoLateralEsquerda(espaco,tabuleiro) == false){
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				
					//rainha preto movimenta para a diagonal superior esquerda
					if(espaco.getX() < posicaox && espaco.getY() < posicaoy && espaco.getComponentCount() == 0){
	
						if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy)){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoSuperiorEsquerda(espaco,tabuleiro)){
							
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
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
			
						}
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					
					//rainha preto movimenta para a diagonal superior direita
					else if(espaco.getX() > posicaox && espaco.getY() < posicaoy && espaco.getComponentCount() == 0){
						
						if((espaco.getX() - posicaox) == (posicaoy - espaco.getY())){
													
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoSuperiorDireita(espaco,tabuleiro)){
							
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
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					
					//rainha preto movimenta para a diagonal inferior esquerda
					else if(espaco.getX() < posicaox && espaco.getY() > posicaoy && espaco.getComponentCount() == 0){
						
						if((posicaox - espaco.getX()) == (espaco.getY() - posicaoy)){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoInferiorEsquerda(espaco,tabuleiro)){
							
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
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
					
					//rainha preto movimenta para a diagonal inferior direita
					if(espaco.getX() > posicaox && espaco.getY() > posicaoy){
	
						if((espaco.getX() - posicaox) == (espaco.getY() - posicaoy) && espaco.getComponentCount() == 0){
							
							//verifica se existe alguma peça no caminho da rainha
							if(verificaEspacoInferiorDireita(espaco,tabuleiro)){
							
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
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
						
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
			}
			else{
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
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

}



