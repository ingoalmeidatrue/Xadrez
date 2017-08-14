import java.awt.Color;
import java.awt.event.MouseEvent;

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
		
		if(espaco!=null && pecaNaFrente == null){
			if(this.cor == Color.WHITE){
				if(espaco.getComponentCount() == 0){
					//rei branco movimenta para frente			
					if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX()){
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
					//rei branco movimenta para tras
					else if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX()){
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
					//rei branco movimenta na diagonal superior direita
					else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX()){
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
					//rei branco movimenta na diagonal superior esquerda
					else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
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
					//rei branco movimenta na diagonal inferior direita
					else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX()){
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
					//rei branco movimenta na diagonal inferior esquerda
					else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
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
					//rei branco movimenta para o lado direito
					else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX()){
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
					//rei branco movimenta para o lado esquerdo
					else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX()){
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
			
			else if(this.cor == Color.BLACK){
				if(espaco.getComponentCount() == 0){
					
					//rei preto movimenta para frente
					if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX()){
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
					
					//rei preto movimenta para tras
					else if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX()){
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
					
					//rei preto movimenta na diagonal superior direita
					else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX()){
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
					
					//rei preto movimenta na diagonal superior esquerda
					else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
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
					
					//rei preto movimenta na diagonal inferior direita
					else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX()){
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
					
					//rei preto movimenta na diagonal inferior esquerda
					else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX()){
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
					
					//rei preto movimenta para o lado direito
					else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX()){
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
					
					//rei preto movimenta para o lado esquerdo
					else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX()){
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
				}
				
				//tem uma peca no espaco clicado
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
		else if(pecaNaFrente!=null){
			Espaco espacoAux = (Espaco) tabuleiro.getComponentAt(pecaNaFrente.getX()+1, pecaNaFrente.getY()+1);
			
			if(this.cor == Color.BLACK && espacoAux.getNome() == "branco"){
				this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
			}
			else if(this.cor == Color.WHITE && espacoAux.getNome() == "preto"){
				this.atacarPeca(pecaNaFrente,espaco,tabuleiro);
			}
			else{
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
			}
		}
	}
	
	public void atacarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		if(espaco!=null && pecaNaFrente == null){
			if(this.cor == Color.BLACK){
				JLabel pecaComida = (JLabel) tabuleiro.getComponentAt(espaco.getX(),espaco.getY());
				
				tabuleiro.remove(pecaComida);
				
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
	
	public boolean getPodeSelecionar() {
		return this.podeSelecionar;
	}
	
}
