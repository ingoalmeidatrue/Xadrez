import java.awt.Color;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tabuleiro extends JFrame {

	private ArrayList<Peca> pecas = new ArrayList<Peca>();

	private ArrayList<Peca> pecasComidas = new ArrayList<Peca>();

	private String espacos;
	
	private JButton botaoBranco, botaoPreto;
	
	//imagem do tabuleiro
	private Icon imagemTabuleiro;
	
	//imagens das pecas pretas
	private Icon imagemPeaoPreto;
	/*private Icon imagemPeao2Preto;
	private Icon imagemPeao3Preto;
	private Icon imagemPeao4Preto;
	private Icon imagemPeao5Preto;
	private Icon imagemPeao6Preto;
	private Icon imagemPeao7Preto;
	private Icon imagemPeao8Preto;*/
	
	private Icon imagemCavalo1Preto;
	private Icon imagemCavalo2Preto;
	
	private Icon imagemTorre1Preto;
	private Icon imagemTorre2Preto;
	
	private Icon imagemBispo1Preto;
	private Icon imagemBispo2Preto;
	
	private Icon imagemRainhaPreto;
	
	private Icon imagemReiPreto;
	
	//imagens das pecas brancas
	private Icon imagemPeaoBranco;
	/*private Icon imagemPeao2Branco;
	private Icon imagemPeao3Branco;
	private Icon imagemPeao4Branco;
	private Icon imagemPeao5Branco;
	private Icon imagemPeao6Branco;
	private Icon imagemPeao7Branco;
	private Icon imagemPeao8Branco;*/
		
	private Icon imagemCavalo1Branco;
	private Icon imagemCavalo2Branco;
		
	private Icon imagemTorre1Branco;
	private Icon imagemTorre2Branco;
		
	private Icon imagemBispo1Branco;
	private Icon imagemBispo2Branco;
		
	private Icon imagemRainhaBranco;
		
	private Icon imagemReiBranco;
	
	
	//Label pretos
	private JLabel imagemLabelPeaoPreto;
	/*private JLabel imagemLabelPeao2Preto;
	private JLabel imagemLabelPeao3Preto;
	private JLabel imagemLabelPeao4Preto;
	private JLabel imagemLabelPeao5Preto;
	private JLabel imagemLabelPeao6Preto;
	private JLabel imagemLabelPeao7Preto;
	private JLabel imagemLabelPeao8Preto;*/
	
	private JLabel imagemLabelCavalo1Preto;
	private JLabel imagemLabelCavalo2Preto;
	
	private JLabel imagemLabelBispo1Preto;
	private JLabel imagemLabelBispo2Preto;
	
	private JLabel imagemLabelTorre1Preto;
	private JLabel imagemLabelTorre2Preto;
	
	private JLabel imagemLabelRainhaPreto;
	
	private JLabel imagemLabelReiPreto;
	
	//Label brancos
	private JLabel imagemLabelPeaoBranco;
	/*private JLabel imagemLabelPeao2Branco;
	private JLabel imagemLabelPeao3Branco;
	private JLabel imagemLabelPeao4Branco;
	private JLabel imagemLabelPeao5Branco;
	private JLabel imagemLabelPeao6Branco;
	private JLabel imagemLabelPeao7Branco;
	private JLabel imagemLabelPeao8Branco;*/
		
	private JLabel imagemLabelCavalo1Branco;
	private JLabel imagemLabelCavalo2Branco;
		
	private JLabel imagemLabelBispo1Branco;
	private JLabel imagemLabelBispo2Branco;
		
	private JLabel imagemLabelTorre1Branco;
	private JLabel imagemLabelTorre2Branco;
		
	private JLabel imagemLabelRainhaBranco;
		
	private JLabel imagemLabelReiBranco;
	
	
	//tabuleiro
	private  JPanel tabuleiro;
		
		
	//janela do jogo
	private JFrame janelaJogo;
	
	//botao de reiniciar
	private JButton botaoReiniciar;
	
	//botao de instrucoes
	private JButton botaoInstrucoes;
	
	//botao de regras
	private JButton botaoRegras;
	
	//botao de sair
	private JButton botaoSair;
	
	//coordenadas iniciais
	int xTabuleiro = 50, yTabuleiro = 50, xPecaPreta = 50, yPecaPreta = 50,xPecaBranca = 50,yPecaBranca = 410;
	
		
	//construtor do tabuleiro (serve para reiniciar jogo)
	private Tabuleiro(){
		
		botaoReiniciar = new JButton("Reiniciar");
		botaoSair = new JButton("Sair");
		botaoInstrucoes = new JButton("Instrucoes");
		botaoRegras = new JButton("Regras");
		
		
		//criando nova instancia de imagem do tabuleiro
		imagemTabuleiro = new ImageIcon("image/board_chess.png");
		
		//criando novas instancias de imagens das pecas pretas
		imagemPeaoPreto = new ImageIcon("image/peaoPreto.png");
		/*imagemPeao2Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao3Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao4Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao5Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao6Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao7Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao8Preto = new ImageIcon("image/peaoPreto.png");*/
		
		imagemCavalo1Preto = new ImageIcon("image/cavaloPreto.png");
		imagemCavalo2Preto = new ImageIcon("image/cavaloPreto.png");
		
		imagemBispo1Preto = new ImageIcon("image/bispoPreto.png");
		imagemBispo2Preto = new ImageIcon("image/bispoPreto.png");
		
		imagemTorre1Preto = new ImageIcon("image/torrePreto.png");
		imagemTorre2Preto = new ImageIcon("image/torrePreto.png");
		
		imagemReiPreto = new ImageIcon("image/reiPreto.png");
		imagemRainhaPreto = new ImageIcon("image/rainhaPreto.png");
		
		//criando novas instancias de imagens das pecas pretas
		imagemPeaoBranco = new ImageIcon("image/peaoBranco.png");
		/*imagemPeao2Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao3Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao4Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao5Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao6Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao7Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao8Branco = new ImageIcon("image/peaoBranco.png");*/
				
		imagemCavalo1Branco = new ImageIcon("image/cavaloBranco.png");
		imagemCavalo2Branco = new ImageIcon("image/cavaloBranco.png");
				
		imagemBispo1Branco = new ImageIcon("image/bispoBranco.png");
		imagemBispo2Branco = new ImageIcon("image/bispoBranco.png");
				
		imagemTorre1Branco = new ImageIcon("image/torreBranco.png");
		imagemTorre2Branco = new ImageIcon("image/torreBranco.png");
				
		imagemReiBranco = new ImageIcon("image/reiBranco.png");
		imagemRainhaBranco = new ImageIcon("image/rainhaBranco.png");
		
				
		janelaJogo = new JFrame();
		
		//Define o tamanho da Janela
		janelaJogo.setSize(700, 700);
		
		tabuleiro = new JPanel();
		
		//O layout do tabuleiro é definido como nulo (por enquanto)
		tabuleiro.setLayout(null);
				
		//define tamanho e posicao dos botoes
		botaoReiniciar.setBounds(550, 530, 100, 30);
		botaoInstrucoes.setBounds(550, 563, 100, 30);
		botaoRegras.setBounds(550, 596, 100, 30);
		botaoSair.setBounds(550, 629, 100, 30);
				
		//adiciona ação nos botoes ao clicar com o mouse neles
		botaoRegras.addActionListener(new ApareceJanelaRegras());
		botaoInstrucoes.addActionListener(new ApareceJanelaInstrucoes());
		botaoSair.addActionListener(new FechaJogo());
				
		tabuleiro.add(botaoReiniciar);
		tabuleiro.add(botaoInstrucoes);
		tabuleiro.add(botaoRegras);
		tabuleiro.add(botaoSair);
				
				
		montarTabuleiro();
				
		tabuleiro.setBounds(10, 10, 500, 500);
				
		janelaJogo.setVisible(true);
				
		//esperar confirmacao do usuario para fechar realmente
		janelaJogo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janelaJogo.addWindowListener(new ApareceJanelaFechaJogo());
				
		//adiciona o tabuleiro no frame
		janelaJogo.getContentPane().add(tabuleiro);
	}
	
	public ArrayList<Peca> getPecas() {
		return pecas;
	}

	void addCelulaBranca(Espaco espaco){
		botaoBranco = new JButton ();
		
		botaoBranco.setIcon(new ImageIcon("image/white.png"));
		botaoBranco.setBounds(xTabuleiro, yTabuleiro, 60, 60);
		botaoBranco.setBorder(null);
		botaoBranco.setName(null);

		if(espaco.getNome() != null){
			 botaoBranco.add(espaco);			
		}
		
	     botaoBranco.setContentAreaFilled(false);
	     Movimentacao mov = new Movimentacao(botaoBranco,this,tabuleiro);
	     botaoBranco.addMouseListener(mov);
			 	
		tabuleiro.add(botaoBranco);
	}
	
	void addCelulaPreta(Espaco espaco){
		botaoPreto = new JButton ();
		

		
		botaoPreto.setIcon(new ImageIcon("image/brown.png"));
		botaoPreto.setBounds(xTabuleiro, yTabuleiro, 60, 60);
		botaoPreto.setBorder(null);
		botaoPreto.setName(null);
		
		if(espaco.getNome() != null){
			botaoPreto.add(espaco);			
		}
		
		botaoPreto.setContentAreaFilled(false);
		Movimentacao mov = new Movimentacao(botaoPreto,this,tabuleiro);
		botaoPreto.addMouseListener(mov);
		
		tabuleiro.add(botaoPreto);
	}

	
	
	public void montarTabuleiro() {
		for(int i = 0; i < 8; ++i){
			for(int j = 0; j < 8;++j){
				if(i == 6){		
					//Adiciona Peao Branco
					imagemLabelPeaoBranco = new JLabel(imagemPeaoBranco);
					imagemLabelPeaoBranco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
					
					Peao PeaoBranco = new Peao(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelPeaoBranco,this);
					pecas.add(PeaoBranco);
					imagemLabelPeaoBranco.addMouseListener(PeaoBranco);
					
					tabuleiro.add(imagemLabelPeaoBranco);
					xPecaBranca += 60;
					
				}
				if(i == 7){
					//Adiciona torre 1 branca
					if(j == 0){
						xPecaBranca = 50;
						yPecaBranca += 60;
						imagemLabelTorre1Branco = new JLabel(imagemTorre1Branco);
						
						imagemLabelTorre1Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						tabuleiro.add(imagemLabelTorre1Branco);
					}
					//adiciona bispo 1 branco
					else if(j == 2){
						imagemLabelBispo1Branco = new JLabel(imagemBispo1Branco);
						
						imagemLabelBispo1Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Bispo bispoBranco = new Bispo(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelBispo1Branco,this);
						pecas.add(bispoBranco);
						imagemLabelBispo1Branco.addMouseListener(bispoBranco);
						
						tabuleiro.add(imagemLabelBispo1Branco);
					}
					//adiciona rei branco
					else if(j == 4){
						imagemLabelReiBranco = new JLabel(imagemReiBranco);
						
						imagemLabelReiBranco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Rei reiBranco = new Rei(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelReiBranco,this);
						pecas.add(reiBranco);
						imagemLabelReiBranco.addMouseListener(reiBranco);
						
						tabuleiro.add(imagemLabelReiBranco);
					}
					//adiciona cavalo 2 branco
					else if(j == 6){
						imagemLabelCavalo2Branco = new JLabel(imagemCavalo2Branco);
						
						imagemLabelCavalo2Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						tabuleiro.add(imagemLabelCavalo2Branco);
					}
					//adiciona cavalo 1 branco
					else if(j == 1){
						imagemLabelCavalo1Branco = new JLabel(imagemCavalo1Branco);
						
						imagemLabelCavalo1Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						tabuleiro.add(imagemLabelCavalo1Branco);
					}
					//adiciona rainha branca
					else if(j == 3){
						imagemLabelRainhaBranco = new JLabel(imagemRainhaBranco);
						
						imagemLabelRainhaBranco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						tabuleiro.add(imagemLabelRainhaBranco);
					}
					//adiciona bispo 2 branco
					else if(j == 5){
						imagemLabelBispo2Branco = new JLabel(imagemBispo2Branco);
						
						imagemLabelBispo2Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						Bispo bispoBranco = new Bispo(xPecaBranca,yPecaBranca,Color.WHITE,imagemLabelBispo2Branco,this);
						pecas.add(bispoBranco);
						imagemLabelBispo2Branco.addMouseListener(bispoBranco);
						
						tabuleiro.add(imagemLabelBispo2Branco);
					}
					//adiciona torre 2 branco
					else if(j == 7){
						imagemLabelTorre2Branco = new JLabel(imagemTorre2Branco);
						
						imagemLabelTorre2Branco.setBounds(xPecaBranca, yPecaBranca, 50, 50);
						
						tabuleiro.add(imagemLabelTorre2Branco);
					}
					xPecaBranca += 60;
				}
				if(i % 2 == 0 ){
					if(j % 2 == 0){
						//adiciona a torre 1 preta
						if(i == 0 && j == 0){
							imagemLabelTorre1Preto = new JLabel(imagemTorre1Preto);
							
							imagemLabelTorre1Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							tabuleiro.add(imagemLabelTorre1Preto);
						}
						//adiciona bispo 1 preto
						else if(i == 0 && j == 2){
							imagemLabelBispo1Preto = new JLabel(imagemBispo1Preto);
							
							imagemLabelBispo1Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Bispo bispoPreto = new Bispo(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelBispo1Preto,this);
							pecas.add(bispoPreto);
							imagemLabelBispo1Preto.addMouseListener(bispoPreto);
							
							tabuleiro.add(imagemLabelBispo1Preto);
						}
						//adiciona rei preto
						else if(i == 0 && j == 4){
							imagemLabelReiPreto = new JLabel(imagemReiPreto);
							
							imagemLabelReiPreto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Rei reiPreto = new Rei(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelReiPreto,this);
							pecas.add(reiPreto);
							imagemLabelReiPreto.addMouseListener(reiPreto);
							
							tabuleiro.add(imagemLabelReiPreto);
						}
						//adiciona cavalo 2 preto
						else if(i == 0 && j == 6){
							imagemLabelCavalo2Preto = new JLabel(imagemCavalo2Preto);
							
							imagemLabelCavalo2Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							tabuleiro.add(imagemLabelCavalo2Preto);
						}
						
						
						if(i==0 || i==1 ){
							addCelulaBranca(new Espaco("preto"));
						}
						else if(i == 6 || i == 7){
							addCelulaBranca(new Espaco("branco"));
						}
						else{
							addCelulaBranca(new Espaco(null));							
						}
					}
					else{
						//adiciona cavalo 1 preto
						if(i == 0 && j == 1){
							imagemLabelCavalo1Preto = new JLabel(imagemCavalo1Preto);
							
							imagemLabelCavalo1Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							tabuleiro.add(imagemLabelCavalo1Preto);
						}
						//adiciona rainha preto
						else if(i == 0 && j == 3){
							imagemLabelRainhaPreto = new JLabel(imagemRainhaPreto);
							
							imagemLabelRainhaPreto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							tabuleiro.add(imagemLabelRainhaPreto);
						}
						//adiciona bispo 2 preto
						else if(i == 0 && j == 5){
							imagemLabelBispo2Preto = new JLabel(imagemBispo2Preto);
							
							imagemLabelBispo2Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							Bispo bispoPreto = new Bispo(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelBispo2Preto,this);
							pecas.add(bispoPreto);
							imagemLabelBispo2Preto.addMouseListener(bispoPreto);
							
							tabuleiro.add(imagemLabelBispo2Preto);
						}
						//adiciona torre 2 preto
						else if(i == 0 && j == 7){
							imagemLabelTorre2Preto = new JLabel(imagemTorre2Preto);
							
							imagemLabelTorre2Preto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
							
							tabuleiro.add(imagemLabelTorre2Preto);
						}
						if(i==0 || i==1){
							addCelulaPreta(new Espaco("preto"));
						}
						else if( i == 6 || i == 7){
							addCelulaPreta(new Espaco("branco"));
						}
						else{
							addCelulaPreta(new Espaco(null));							
						}
					}
					
				}
				else{
					//adiciona peao preto
					if(i == 1){
						imagemLabelPeaoPreto = new JLabel(imagemPeaoPreto);
						imagemLabelPeaoPreto.setBounds(xPecaPreta, yPecaPreta, 50, 50);
						Peao PeaoPreto = new Peao(xPecaPreta,yPecaPreta,Color.BLACK,imagemLabelPeaoPreto,this);
						pecas.add(PeaoPreto);
						imagemLabelPeaoPreto.addMouseListener(PeaoPreto);
						tabuleiro.add(imagemLabelPeaoPreto);
					}
					
				
					
					if(j % 2 == 0){
						if(i==0 || i==1){
							addCelulaPreta(new Espaco("preto"));
						}
						else if(i == 6 || i == 7){
							addCelulaPreta(new Espaco("branco"));
						}
						else{
							addCelulaPreta(new Espaco(null));							
						}
					}
					else{
						if(i==0 || i==1){
							addCelulaBranca(new Espaco("preto"));
						}
						else if(i == 6 || i == 7){
							addCelulaBranca(new Espaco("branco"));
						}
						else{
							addCelulaBranca(new Espaco(null));							
						}
					}
				}
		
				xTabuleiro+=60;
				xPecaPreta+=60;
				
			}
			yPecaPreta+=60;
			xPecaPreta = 50;
			yTabuleiro+=60;
			xTabuleiro = 50;
		}

	}
	
	public void travaSelecao(Peca peca){
		for(int i=0; i<pecas.size();i++){
			if(pecas.get(i)instanceof Peao && pecas.get(i) != peca){
				Peao p = (Peao)pecas.get(i);
				p.setPodeSelecionar(false);
			}
			else if(pecas.get(i)instanceof Rei && pecas.get(i) != peca){
				Rei rei = (Rei)pecas.get(i);
				rei.setPodeSelecionar(false);
				System.out.println(rei.getPodeSelecionar());
			}
			else if(pecas.get(i)instanceof Bispo && pecas.get(i) != peca){
				Bispo bispo = (Bispo)pecas.get(i);
				bispo.setPodeSelecionar(false);
			}
		}
	}
	public void destravaSelecao(){
		for(int i=0; i<pecas.size();i++){
				Peca p = pecas.get(i);
				p.setPodeSelecionar(true);
		}
	}
	
	public void exibirTabuleiro() {
		
	}

	public void atualizarTabuleiro() {

	}

	public void reiniciarTabuleiro() {

	}

	public boolean validarMovimento(Peca peca, Object c) {
		if(peca instanceof Peao){
			Peao p = (Peao)peca;
			if(c instanceof JButton){
				JButton espaco = (JButton)c;
				p.movimentarPeca(null,espaco, tabuleiro);
				
			}
			else if(c instanceof JLabel){
				JLabel pecaNaFrente = (JLabel)c;
				p.movimentarPeca(pecaNaFrente,null, tabuleiro);
			}
		}
		else if(peca instanceof Rei){
			Rei rei = (Rei) peca;
			
			if(c instanceof JButton){
				JButton espaco = (JButton)c;
				rei.movimentarPeca(null,espaco,tabuleiro);
			}
			else if(c instanceof JLabel){
				JLabel pecaNaFrente = (JLabel)c;
				rei.movimentarPeca(pecaNaFrente,null, tabuleiro);
			}
		}
		else if(peca instanceof Bispo){
			Bispo bispo = (Bispo) peca;
			
			if(c instanceof JButton){
				JButton espaco = (JButton)c;
				bispo.movimentarPeca(null,espaco,tabuleiro);
			}
			else if(c instanceof JLabel){
				JLabel pecaNaFrente = (JLabel)c;
				bispo.movimentarPeca(pecaNaFrente,null, tabuleiro);
			}
		}
		return false;
	}

	public boolean validarXeque() {
		return false;
	}

	public void declararEmpate() {

	}
	
	public void repaint(){
		super.repaint();
	}
	
	public static void main(String [] args){
		new Tabuleiro();
	}

}