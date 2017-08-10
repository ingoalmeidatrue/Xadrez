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
	private boolean podeSelecionar = true;
	
	//booleana que diz se a peca esta selecionada
	private boolean selecionada = false;
	
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
		System.out.println("posicao X que quero ir: "+espaco.getX());
		System.out.println("posicao Y que quero ir: "+espaco.getY());
		System.out.println("Posicao Y que estou: "+posicaoy);
		System.out.println("Posicao X que estou: "+posicaox);
		if(espaco!=null && pecaNaFrente == null){
			//System.out.println(espaco.getComponentCount());
			//rei branco movimenta para frente			
			if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX() &&  this.cor == Color.WHITE && espaco.getComponentCount() == 0){
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
				//System.out.println(selecionada);
			}
			
			//rei branco movimenta para tras
			else if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX() && this.cor == Color.WHITE && espaco.getComponentCount() == 0){
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
			else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX() && this.cor == Color.WHITE && espaco.getComponentCount() == 0){
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
			else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX() && this.cor == Color.WHITE && espaco.getComponentCount() == 0){
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
			else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX() && this.cor == Color.WHITE && espaco.getComponentCount() == 0){
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
			else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX() && this.cor == Color.WHITE && espaco.getComponentCount() == 0){
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
			else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX() && this.cor == Color.WHITE && espaco.getComponentCount() == 0){
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
			else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX() && this.cor == Color.WHITE && espaco.getComponentCount() == 0){
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
			
			
			//rei preto movimenta para frente
			else if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
				System.out.println("entrou");
				icon.setBounds(posicaox, posicaoy+60, 50,50);
				this.posicaoy = posicaoy+60;
				tabuleiro.remove(espaco);
				espaco.add(new JLabel());
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-60);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.repaint();
			}
			
			//rei preto movimenta para tras
			else if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
				icon.setBounds(posicaox, posicaoy-60, 50,50);
				this.posicaoy = posicaoy-60;
				tabuleiro.remove(espaco);
				espaco.add(new JLabel());
				tabuleiro.add(espaco);
				JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+60);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.repaint();
			}
			
			//rei preto movimenta na diagonal superior direita
			else if(posicaoy - 60 == espaco.getY() && posicaox +60 == espaco.getX() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
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
			
			//rei preto movimenta na diagonal superior esquerda
			else if(posicaoy - 60 == espaco.getY() && posicaox - 60 == espaco.getX() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
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
			
			//rei preto movimenta na diagonal inferior direita
			else if(posicaoy + 60 == espaco.getY() && posicaox + 60 == espaco.getX() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
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
			
			//rei preto movimenta na diagonal inferior esquerda
			else if(posicaoy + 60 == espaco.getY() && posicaox - 60 == espaco.getX() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
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
			
			//rei preto movimenta para o lado direito
			else if(posicaoy  == espaco.getY() && posicaox + 60 == espaco.getX() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
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
			
			//rei preto movimenta para o lado esquerdo
			else if(posicaoy  == espaco.getY() && posicaox - 60 == espaco.getX() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
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
			
			else{
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
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
	

	public void atacarPeca() {

	}
}
