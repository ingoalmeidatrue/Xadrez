import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rei extends Peca {
	
	//posicao da peca selecionada
	private int posicaox;
	private int posicaoy;
	
	private Tabuleiro tabuleiro;
	
	//cor da peca
	private Color cor;
	
	//booleana que diz se existe ou nao alguma peca selecionada
	private  boolean podeSelecionar = true;
	
	//booleana que diz se a peca esta selecionada
	private  boolean selecionada = false;
	
	//imagem da peca
	private JLabel icon;

	
	public Rei(int posicaox, int posicaoy, Color cor, JLabel img, Tabuleiro tabuleiro){
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
		this.cor = cor;
		this.icon = img;
		this.tabuleiro = tabuleiro;
	}

	public boolean verificarXeque() {
		return false;
	}

	public void usarJogadaEspecial() {

	}

	public void movimentarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		this.desativaHighlight();
		if(espaco!=null && pecaNaFrente == null){
			if(this.cor == Color.WHITE){
					//rei branco movimenta para frente			
					if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox, posicaoy-60, 50,50);
							this.posicaoy = posicaoy-60;
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							System.out.println(tabuleiro.getComponentAt(posicaox, posicaoy+60));
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+60);
							espacoAntigo.remove(0);
							
							
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
							this.tabuleiro.repaint();		
						}
						//tem uma peca no espaco clicado
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
					//rei branco movimenta para tras
					else if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox, posicaoy+60, 50,50);
							this.posicaoy = posicaoy+60;
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-60);
							espacoAntigo.remove(0);
							
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
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
					//rei branco movimenta na diagonal superior direita
					else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox + 60, posicaoy - 60, 50,50);
							
							this.posicaoy = posicaoy - 60;
							this.posicaox = posicaox + 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy + 60);
							espacoAntigo.remove(0);
							
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
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
					//rei branco movimenta na diagonal superior esquerda
					else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox - 60, posicaoy - 60, 50,50);
							
							this.posicaoy = posicaoy - 60;
							this.posicaox = posicaox - 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy + 60);
							espacoAntigo.remove(0);
							
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
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
					//rei branco movimenta na diagonal inferior direita
					else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox + 60, posicaoy + 60, 50,50);
							
							this.posicaoy = posicaoy + 60;
							this.posicaox = posicaox + 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy - 60);
							espacoAntigo.remove(0);
							
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
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
					//rei branco movimenta na diagonal inferior esquerda
					else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox - 60, posicaoy + 60, 50,50);
							
							this.posicaoy = posicaoy + 60;
							this.posicaox = posicaox - 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy - 60);
							espacoAntigo.remove(0);
							
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
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
					//rei branco movimenta para o lado direito
					else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox + 60, posicaoy, 50,50);
							
							this.posicaox = posicaox + 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy);
							espacoAntigo.remove(0);
							
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
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
					//rei branco movimenta para o lado esquerdo
					else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox - 60, posicaoy, 50,50);
							
							this.posicaox = posicaox - 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy);
							espacoAntigo.remove(0);
							
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
							this.tabuleiro.repaint();
						}
						//tem uma peca no espaco clicado
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
					else{
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
					}
			}
			
			else if(this.cor == Color.BLACK){
					//rei preto movimenta para frente
					if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox, posicaoy+60, 50,50);
							this.posicaoy = posicaoy+60;
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-60);
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
					
					//rei preto movimenta para tras
					else if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox, posicaoy-60, 50,50);
							this.posicaoy = posicaoy-60;
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+60);
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
					
					//rei preto movimenta na diagonal superior direita
					else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox + 60, posicaoy - 60, 50,50);
							
							this.posicaoy = posicaoy - 60;
							this.posicaox = posicaox + 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy + 60);
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
					
					//rei preto movimenta na diagonal superior esquerda
					else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox - 60, posicaoy - 60, 50,50);
							
							this.posicaoy = posicaoy - 60;
							this.posicaox = posicaox - 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy + 60);
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
					
					//rei preto movimenta na diagonal inferior direita
					else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox + 60, posicaoy + 60, 50,50);
							
							this.posicaoy = posicaoy + 60;
							this.posicaox = posicaox + 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy - 60);
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
					
					//rei preto movimenta na diagonal inferior esquerda
					else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox - 60, posicaoy + 60, 50,50);
							
							this.posicaoy = posicaoy + 60;
							this.posicaox = posicaox - 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy - 60);
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
					
					//rei preto movimenta para o lado direito
					else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox + 60, posicaoy, 50,50);
							
							this.posicaox = posicaox + 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy);
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
					
					//rei preto movimenta para o lado esquerdo
					else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX()){
						if(espaco.getComponentCount() == 0){
							
							icon.setBounds(posicaox - 60, posicaoy, 50,50);
							
							this.posicaox = posicaox - 60;
							
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("preto"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy);
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
				else{
					
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
				}
		}
		else if(pecaNaFrente!=null){
			espaco = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
			
			if(this.cor == Color.WHITE){
				//rei branco movimenta para frente			
				if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox, posicaoy-60, 50,50);
						this.posicaoy = posicaoy-60;
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
						this.tabuleiro.repaint();		
					}
					//tem uma peca no espaco clicado
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
				//rei branco movimenta para tras
				else if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox, posicaoy+60, 50,50);
						this.posicaoy = posicaoy+60;
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
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
				//rei branco movimenta na diagonal superior direita
				else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox + 60, posicaoy - 60, 50,50);
						
						this.posicaoy = posicaoy - 60;
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy + 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
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
				//rei branco movimenta na diagonal superior esquerda
				else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox - 60, posicaoy - 60, 50,50);
						
						this.posicaoy = posicaoy - 60;
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy + 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
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
				//rei branco movimenta na diagonal inferior direita
				else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox + 60, posicaoy + 60, 50,50);
						
						this.posicaoy = posicaoy + 60;
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy - 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
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
				//rei branco movimenta na diagonal inferior esquerda
				else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox - 60, posicaoy + 60, 50,50);
						
						this.posicaoy = posicaoy + 60;
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy - 60);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
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
				//rei branco movimenta para o lado direito
				else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox + 60, posicaoy, 50,50);
						
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
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
				//rei branco movimenta para o lado esquerdo
				else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox - 60, posicaoy, 50,50);
						
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("branco"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy);
						espacoAntigo.remove(0);
						this.selecionada = false;
						this.tabuleiro.destravaSelecao();
						this.tabuleiro.repaint();
					}
					//tem uma peca no espaco clicado
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
				else{
					
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
				}
		}
		
		else if(this.cor == Color.BLACK){
				//rei preto movimenta para frente
				if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox, posicaoy+60, 50,50);
						this.posicaoy = posicaoy+60;
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-60);
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
				
				//rei preto movimenta para tras
				else if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox, posicaoy-60, 50,50);
						this.posicaoy = posicaoy-60;
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+60);
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
				
				//rei preto movimenta na diagonal superior direita
				else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox + 60, posicaoy - 60, 50,50);
						
						this.posicaoy = posicaoy - 60;
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy + 60);
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
				
				//rei preto movimenta na diagonal superior esquerda
				else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox - 60, posicaoy - 60, 50,50);
						
						this.posicaoy = posicaoy - 60;
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy + 60);
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
				
				//rei preto movimenta na diagonal inferior direita
				else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox + 60, posicaoy + 60, 50,50);
						
						this.posicaoy = posicaoy + 60;
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy - 60);
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
				
				//rei preto movimenta na diagonal inferior esquerda
				else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox - 60, posicaoy + 60, 50,50);
						
						this.posicaoy = posicaoy + 60;
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy - 60);
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
				
				//rei preto movimenta para o lado direito
				else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox + 60, posicaoy, 50,50);
						
						this.posicaox = posicaox + 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox - 60, posicaoy);
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
				
				//rei preto movimenta para o lado esquerdo
				else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX()){
					if(espaco.getComponentCount() == 0){
						
						icon.setBounds(posicaox - 60, posicaoy, 50,50);
						
						this.posicaox = posicaox - 60;
						
						tabuleiro.remove(espaco);
						espaco.add(new Espaco("preto"));
						tabuleiro.add(espaco);
						JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox + 60, posicaoy);
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
				else{				
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
				}
			}			
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
		
		//dis-seleciona a peca
		if(this.selecionada){	
			
			this.desativaHighlight();
			this.selecionada = false;
			this.tabuleiro.destravaSelecao();
		}
		
		//clica na peca pela primeira vez para movimentar ou atacar
		else if(podeSelecionar){
			
			this.ativaHighlight();
			this.selecionada = true;
			tabuleiro.travaSelecao(this);
			
		}
		//a peca sofreu a acao de ser clicada
		else if(!podeSelecionar){		
			Movimentacao barraPeca = new Movimentacao(null, tabuleiro, null);
			barraPeca.setPecaBarra(this.icon);
			barraPeca.mouseClicked(e);
		}
	}
	
	public void ativaHighlight(){
		//ativa o highlight
		//verifica se o espaco clicado eh branco
		if(this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50).getName().equals("branco")){	
			
			JButton espacoHighlight = (JButton) this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50);
			
			espacoHighlight.setIcon(new ImageIcon("image/whiteHighlight.png"));
		}
		
		//verifica se o espaco clicado eh preto
		else if(this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50).getName().equals("preto")){
			
			JButton espacoHighlight = (JButton) this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50);
			
			espacoHighlight.setIcon(new ImageIcon("image/brownHighlight.png"));
		}
	}
	
	public void desativaHighlight(){
		//desativa o highlight
		//verifica se o espaco clicado eh branco
		if(this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50).getName().equals("branco")){	
			
			JButton espacoHighlight = (JButton) this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50);
			
			espacoHighlight.setIcon(new ImageIcon("image/white.png"));
		}
		
		//verifica se o espaco clicado eh preto
		else if(this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50).getName().equals("preto")){
			
			JButton espacoHighlight = (JButton) this.tabuleiro.getPainel().getComponentAt(posicaox+50, posicaoy+50);
			
			espacoHighlight.setIcon(new ImageIcon("image/brown.png"));
		}
	}
	
	public boolean getSelecionada(){
		return this.selecionada;
	}
	
	public JLabel getIcon() {
		return icon;
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
