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
				if(posicaoy - 59 == espaco.getY() && this.cor == Color.WHITE && espaco.getComponentCount() == 0){
					icon.setBounds(posicaox, posicaoy-59, 50,50);
					this.posicaoy = posicaoy-59;
					tabuleiro.remove(espaco);
					espaco.add(new JLabel());
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy+59);
					espacoAntigo.remove(0);
					this.selecionada = false;
					this.tabuleiro.destravaSelecao();
					this.tabuleiro.repaint();
				}
				else if(posicaoy + 59 == espaco.getY() && this.cor == Color.BLACK && espaco.getComponentCount() == 0){
					icon.setBounds(posicaox, posicaoy+59, 50,50);
					this.posicaoy = posicaoy+59;
					tabuleiro.remove(espaco);
					espaco.add(new JLabel());
					tabuleiro.add(espaco);
					JButton espacoAntigo = (JButton)tabuleiro.getComponentAt(posicaox, posicaoy-59);
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
			//Se tiver uma peça na frente, deseleciona
			else if(pecaNaFrente!=null){
				this.selecionada = false;
				this.tabuleiro.destravaSelecao();
			}
		}

	public void atacarPeca() {

	}

	public void mouseClicked(MouseEvent e){
		System.out.println("entrou2");
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