import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Peao extends Peca {
	private int posicaox;
	private int posicaoy;
	private int posicaoxIni;
	private int posicaoyIni;
	private Tabuleiro tabuleiro;
	private Color cor;
	private boolean podeSelecionar = true;
	private boolean selecionada = false;
	private boolean morta = false;
	public boolean isMorta() {
		return morta;
	}
	public void setMorta(boolean morta) {
		this.morta = morta;
	}
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
	private JLabel icon;
	private boolean pecaMorta = false;
	
	public Peao(int posicaox, int posicaoy, Color cor, JLabel img, Tabuleiro tabuleiro){
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
		this.posicaoxIni = posicaox - 40;
		this.posicaoyIni = posicaoy - 40;
		this.cor = cor;
		this.icon = img;
		this.tabuleiro = tabuleiro;
	}
	public void usarJogadaEspecial(JPanel tabuleiro) {
		if(this.cor == Color.WHITE && posicaoy == 50){
			this.tabuleiro.getPecasForaDoJogo().add(this);
			Icon imgRainha = new ImageIcon("image/rainhaBranco.png");
			JLabel imgRainhaEspecial = new JLabel(imgRainha);
			Rainha rainhaEspecial = new Rainha(posicaox, posicaoy,this.cor,imgRainhaEspecial,this.tabuleiro);
			imgRainhaEspecial.addMouseListener(rainhaEspecial);
			this.tabuleiro.getPecas().add(rainhaEspecial);
			new PecaMorta().check(this);
			JButton espaco = (JButton) tabuleiro.getComponentAt(posicaox+50, posicaoy);
			tabuleiro.remove(espaco);
			imgRainhaEspecial.setBounds(posicaox, posicaoy, 50, 50);
			tabuleiro.add(imgRainhaEspecial);
			tabuleiro.add(espaco);
			posicaox = 50;
			posicaoy = 50;
			icon.setBounds(posicaox, posicaoy, 0, 0);
			this.tabuleiro.atualizarTabuleiro();
		}
		else if(this.cor == Color.BLACK && posicaoy == 470){
			this.tabuleiro.getPecasForaDoJogo().add(this);
			Icon imgRainha = new ImageIcon("image/rainhaPreto.png");
			JLabel imgRainhaEspecial = new JLabel(imgRainha);
			Rainha rainhaEspecial = new Rainha(posicaox, posicaoy,this.cor,imgRainhaEspecial,this.tabuleiro);
			imgRainhaEspecial.addMouseListener(rainhaEspecial);
			this.tabuleiro.getPecas().add(rainhaEspecial);
      new PecaMorta().check(this);
			JButton espaco = (JButton) tabuleiro.getComponentAt(posicaox+50, posicaoy);
			tabuleiro.remove(espaco);
			imgRainhaEspecial.setBounds(posicaox, posicaoy, 50, 50);
			tabuleiro.add(imgRainhaEspecial);
			tabuleiro.add(espaco);
			posicaox = 0;
			posicaoy = 0;
			icon.setBounds(posicaox, posicaoy, 0, 0);
			this.tabuleiro.atualizarTabuleiro();
		}
	}
	
	
	public void movimentarPeca(JLabel pecaNaFrente,JButton espaco, JPanel tabuleiro) {
		this.desativaHighlight();
			//Realiza o movimento caso tenha clicado num espaço
			if(espaco!=null && pecaNaFrente == null){
				if(this.cor == Color.WHITE){
					if((posicaox + 60 == espaco.getX() || posicaox-60 == espaco.getX()) && posicaoy-60 == espaco.getY()){
						atacarPeca(null,espaco,tabuleiro);
						usarJogadaEspecial(tabuleiro);
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
							this.tabuleiro.atualizarTabuleiro();
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
							this.tabuleiro.atualizarTabuleiro();
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
							this.tabuleiro.atualizarTabuleiro();
							usarJogadaEspecial(tabuleiro);
						}
						else{
							this.selecionada = false;
							this.tabuleiro.destravaSelecao();
						}
					}
				}
					else if(this.cor == Color.BLACK){
						//ataque do peao preto
						if((posicaox + 60 == espaco.getX() || posicaox-60 == espaco.getX()) && posicaoy+60 == espaco.getY() && espaco.getComponentCount()!= 0){
							atacarPeca(null,espaco,tabuleiro);
							usarJogadaEspecial(tabuleiro);
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
								this.tabuleiro.atualizarTabuleiro();
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
								this.tabuleiro.atualizarTabuleiro();
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
								this.tabuleiro.atualizarTabuleiro();
								usarJogadaEspecial(tabuleiro);
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
				usarJogadaEspecial(tabuleiro);
			}
			else if(pecaNaFrente!= null && (posicaox + 60 == pecaNaFrente.getX() || posicaox-60 == pecaNaFrente.getX()) && posicaoy+60 == pecaNaFrente.getY() && this.cor == Color.BLACK){
				atacarPeca(pecaNaFrente,null,tabuleiro);
				usarJogadaEspecial(tabuleiro);
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
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaComida.getMouseListeners()[0]);
				new PecaMorta().check(pecaComida.getMouseListeners()[0]);	Peca p = (Peca)pecaComida.getMouseListeners()[0];
				tabuleiro.remove(pecaComida);
				tabuleiro.add(espaco);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.atualizarTabuleiro();
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
				System.out.println(pecaComida.getMouseListeners()[0]);
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaComida.getMouseListeners()[0]);
				new PecaMorta().check(pecaComida.getMouseListeners()[0]);
				tabuleiro.remove(pecaComida);
				tabuleiro.add(espaco);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.atualizarTabuleiro();
			}
		}
		//Peao branco ataca caso a peca tenha sido clicada e seja branca
		else if(espaco==null && pecaNaFrente!=null && this.cor == Color.WHITE){
			JButton espaconovo = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
			Espaco cor = (Espaco) espaconovo.getComponent(0);
			if(cor.getNome() == "preto"){
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
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaComida.getMouseListeners()[0]);
				new PecaMorta().check(pecaComida.getMouseListeners()[0]);
				tabuleiro.remove(pecaComida);
				tabuleiro.add(espaconovo);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.atualizarTabuleiro();
			}
		}
		//Peao preto ataca caso a peca tenha sido clicada e seja preto
		else if(espaco==null && pecaNaFrente!=null && this.cor == Color.BLACK){
			JButton espaconovo = (JButton) tabuleiro.getComponentAt(pecaNaFrente.getX()+50, pecaNaFrente.getY()+50);
			Espaco cor = (Espaco) espaconovo.getComponent(0);
			JLabel pecaComida = (JLabel)tabuleiro.getComponentAt(pecaNaFrente.getX(), pecaNaFrente.getY());
			if(cor.getNome() == "branco"){
				posicaoy += 60;
				JButton espacoAntigo;
				if(posicaox - 60 == pecaNaFrente.getX()){
					posicaox = posicaox-60;
					icon.setBounds(posicaox, posicaoy, 50,50);
					espacoAntigo = (JButton) tabuleiro.getComponentAt(posicaox+60, posicaoy-60);
				}
				else{
					posicaox = posicaox+ 60;
					icon.setBounds(posicaox, posicaoy, 50, 50);
					espacoAntigo = (JButton) tabuleiro.getComponentAt(posicaox-60, posicaoy-60);
				}
				tabuleiro.remove(espaconovo);
				this.tabuleiro.getPecasForaDoJogo().add((Peca)pecaComida.getMouseListeners()[0]); 
				new PecaMorta().check(pecaComida.getMouseListeners()[0]);
				tabuleiro.remove(pecaComida);
				tabuleiro.add(espaconovo);
				espacoAntigo.remove(0);
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
				this.tabuleiro.atualizarTabuleiro();
			}
		}
		else{
			this.selecionada = false;
			this.tabuleiro.destravaSelecao();
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