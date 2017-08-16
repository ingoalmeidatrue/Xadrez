import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Peao extends Peca {
	private int posicaox;
	private int posicaoy;
	private Tabuleiro tabuleiro;
	private Color cor;
	private boolean podeSelecionar = true;
	private boolean selecionada = false;
	private JLabel icon;
	
	public Peao(int posicaox, int posicaoy, Color cor, JLabel img, Tabuleiro tabuleiro){
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
		this.cor = cor;
		this.icon = img;
		this.tabuleiro = tabuleiro;
	}
	public void usarJogadaEspecial() {

	}
	
	public void movimentarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
			//Realiza o movimento caso tenha clicado num espaço
			if(espaco!=null && pecaNaFrente == null){
				if(this.cor == Color.WHITE){
					if((posicaox + 60 == espaco.getX() || posicaox-60 == espaco.getX()) && posicaoy-60 == espaco.getY()){
						atacarPeca(null,espaco,tabuleiro);
					}
					//trata primeiro movimento do peao
					else if(posicaoy == 410){
						if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX() && espaco.getComponentCount() == 0){
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
						else if(posicaoy - 120 == espaco.getY() && posicaox == espaco.getX() && espaco.getComponentCount() == 0){
							icon.setBounds(posicaox, posicaoy-120, 50,50);
							this.posicaoy = posicaoy-120;
							tabuleiro.remove(espaco);
							espaco.add(new Espaco("branco"));
							tabuleiro.add(espaco);
							JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+120);
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
					//2 movimento em diante
					else{
						if(posicaoy - 60 == espaco.getY() && posicaox == espaco.getX() && espaco.getComponentCount() == 0){
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
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				}
					else if(this.cor == Color.BLACK){
						//ataque do peao preto
						if((posicaox + 60 == espaco.getX() || posicaox-60 == espaco.getX()) && posicaoy+60 == espaco.getY()){
							atacarPeca(null,espaco,tabuleiro);
						}
						//trata primeiro movimento do peao
						else if(posicaoy == 110){
							if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX() && espaco.getComponentCount() == 0){
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
							else if(posicaoy + 120 == espaco.getY() && posicaox == espaco.getX() && espaco.getComponentCount() == 0){
								icon.setBounds(posicaox, posicaoy+120, 50,50);
								this.posicaoy = posicaoy+120;
								tabuleiro.remove(espaco);
								espaco.add(new Espaco("preto"));
								tabuleiro.add(espaco);
								JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-120);
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
						//2 movimento em diante
						else{
							if(posicaoy + 60 == espaco.getY() && posicaox == espaco.getX() && espaco.getComponentCount() == 0){
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
								this.selecionada = false;
								this.tabuleiro.destravaSelecao();
							}
						}
					}
				}
			else if(pecaNaFrente!= null && (posicaox + 60 == pecaNaFrente.getX() || posicaox-60 == pecaNaFrente.getX()) && posicaoy-60 == pecaNaFrente.getY() && this.cor == Color.WHITE){
				atacarPeca(pecaNaFrente,null,tabuleiro);
			}
				//Se tiver uma peça na frente, deseleciona
				else if(pecaNaFrente!=null){
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
				}
	}

	public void atacarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		//Peao branco Ataca peca caso espaco tenha sido clicado e contenha peca preta
		if(espaco!=null && pecaNaFrente == null){
			Espaco cor = (Espaco) espaco.getComponent(0);
			if(this.cor == Color.WHITE && cor.getNome() == "preto"){
				posicaoy -= 60;
				JButton espacoAntigo;
				if(posicaox - 60 == espaco.getX()){
					posicaox = posicaox-60;
					icon.setBounds(posicaox, posicaoy, 50,50);
					espacoAntigo = (JButton) tabuleiro.getComponentAt(posicaox+60, posicaoy+60);
				}
				else{
					posicaox = posicaox+ 60;
					icon.setBounds(posicaox, posicaoy, 50, 50);
					espacoAntigo = (JButton) tabuleiro.getComponentAt(posicaox-60, posicaoy+60);
				}
				tabuleiro.remove(espaco);
				JLabel pecaComida = (JLabel)tabuleiro.getComponentAt(espaco.getX(), espaco.getY());
				tabuleiro.remove(pecaComida);
				tabuleiro.add(espaco);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.repaint();
			}
			//Peao preto ataca a peca caso o espaco tenha sido clicado e contenha uma peca branca
			else if(espaco!=null && pecaNaFrente == null && this.cor == Color.BLACK && cor.getNome() == "branco"){
				posicaoy += 60;
				JButton espacoAntigo;
				JLabel pecaComida = (JLabel)tabuleiro.getComponentAt(espaco.getX(), espaco.getY());
				
				if(posicaox - 60 == espaco.getX()){
					posicaox = posicaox-60;
					icon.setBounds(posicaox, posicaoy, 50,50);
					espacoAntigo = (JButton) tabuleiro.getComponentAt(posicaox+60, posicaoy-60);
				}
				else{
					posicaox = posicaox + 60;
					icon.setBounds(posicaox, posicaoy, 50, 50);
					espacoAntigo = (JButton) tabuleiro.getComponentAt(posicaox-60, posicaoy-60);
				}
				tabuleiro.remove(espaco);
				tabuleiro.remove(pecaComida);
				tabuleiro.add(espaco);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.repaint();
			}
		}
		else if(espaco==null && pecaNaFrente!=null){
			JButton espaconovo = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
			Espaco cor = (Espaco) espaconovo.getComponent(0);
			if(this.cor == Color.WHITE && cor.getNome() == "preto"){
				posicaoy -= 60;
				JButton espacoAntigo;
				if(posicaox - 60 == pecaNaFrente.getX()){
					posicaox = posicaox-60;
					icon.setBounds(posicaox, posicaoy, 50,50);
					espacoAntigo = (JButton) tabuleiro.getComponentAt(posicaox+60, posicaoy+60);
				}
				else{
					posicaox = posicaox+ 60;
					icon.setBounds(posicaox, posicaoy, 50, 50);
					espacoAntigo = (JButton) tabuleiro.getComponentAt(posicaox-60, posicaoy+60);
				}
				tabuleiro.remove(espaconovo);
				JLabel pecaComida = (JLabel)tabuleiro.getComponentAt(pecaNaFrente.getX(), pecaNaFrente.getY());
				tabuleiro.remove(pecaComida);
				tabuleiro.add(espaconovo);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.repaint();
			}
		}
		else{
			this.selecionada = false;
			this.tabuleiro.destravaSelecao();
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
	
}