import java.awt.LayoutManager;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tabuleiro extends JFrame {

	private Peca pecas;

	private Peca pecasComidas;

	private String espacos;
	
	//imagem do tabuleiro
	private Icon imagemTabuleiro;
	
	//imagens das pecas pretas
	private Icon imagemPeao1Preto;
	private Icon imagemPeao2Preto;
	private Icon imagemPeao3Preto;
	private Icon imagemPeao4Preto;
	private Icon imagemPeao5Preto;
	private Icon imagemPeao6Preto;
	private Icon imagemPeao7Preto;
	private Icon imagemPeao8Preto;
	
	private Icon imagemCavalo1Preto;
	private Icon imagemCavalo2Preto;
	
	private Icon imagemTorre1Preto;
	private Icon imagemTorre2Preto;
	
	private Icon imagemBispo1Preto;
	private Icon imagemBispo2Preto;
	
	private Icon imagemRainhaPreto;
	
	private Icon imagemReiPreto;
	
	//imagens das pecas brancas
	private Icon imagemPeao1Branco;
	private Icon imagemPeao2Branco;
	private Icon imagemPeao3Branco;
	private Icon imagemPeao4Branco;
	private Icon imagemPeao5Branco;
	private Icon imagemPeao6Branco;
	private Icon imagemPeao7Branco;
	private Icon imagemPeao8Branco;
		
	private Icon imagemCavalo1Branco;
	private Icon imagemCavalo2Branco;
		
	private Icon imagemTorre1Branco;
	private Icon imagemTorre2Branco;
		
	private Icon imagemBispo1Branco;
	private Icon imagemBispo2Branco;
		
	private Icon imagemRainhaBranco;
		
	private Icon imagemReiBranco;
	
	
	//Label pretos
	private JLabel imagemLabelPeao1Preto;
	private JLabel imagemLabelPeao2Preto;
	private JLabel imagemLabelPeao3Preto;
	private JLabel imagemLabelPeao4Preto;
	private JLabel imagemLabelPeao5Preto;
	private JLabel imagemLabelPeao6Preto;
	private JLabel imagemLabelPeao7Preto;
	private JLabel imagemLabelPeao8Preto;
	
	private JLabel imagemLabelCavalo1Preto;
	private JLabel imagemLabelCavalo2Preto;
	
	private JLabel imagemLabelBispo1Preto;
	private JLabel imagemLabelBispo2Preto;
	
	private JLabel imagemLabelTorre1Preto;
	private JLabel imagemLabelTorre2Preto;
	
	private JLabel imagemLabelRainhaPreto;
	
	private JLabel imagemLabelReiPreto;
	
	//Label brancos
	private JLabel imagemLabelPeao1Branco;
	private JLabel imagemLabelPeao2Branco;
	private JLabel imagemLabelPeao3Branco;
	private JLabel imagemLabelPeao4Branco;
	private JLabel imagemLabelPeao5Branco;
	private JLabel imagemLabelPeao6Branco;
	private JLabel imagemLabelPeao7Branco;
	private JLabel imagemLabelPeao8Branco;
		
	private JLabel imagemLabelCavalo1Branco;
	private JLabel imagemLabelCavalo2Branco;
		
	private JLabel imagemLabelBispo1Branco;
	private JLabel imagemLabelBispo2Branco;
		
	private JLabel imagemLabelTorre1Branco;
	private JLabel imagemLabelTorre2Branco;
		
	private JLabel imagemLabelRainhaBranco;
		
	private JLabel imagemLabelReiBranco;
	
	
	
	private JLabel imagemLabelTabuleiro;
	
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
	
	void addPeaoTabuleiro(){
				//instanciando e colocando no tabuleiro o peao 1 preto
				imagemLabelPeao1Preto = new JLabel(imagemPeao1Preto);
				
				imagemLabelPeao1Preto.setBounds(70, 120, 50, 50);
				
				tabuleiro.add(imagemLabelPeao1Preto);
				
				//instanciando e colocando no tabuleiro o peao 2 preto
				imagemLabelPeao2Preto = new JLabel(imagemPeao2Preto);
						
				imagemLabelPeao2Preto.setBounds(130, 120, 50, 50);
					
				tabuleiro.add(imagemLabelPeao2Preto);
				
				//instanciando e colocando no tabuleiro o peao 3 preto
				imagemLabelPeao3Preto = new JLabel(imagemPeao3Preto);
				
				imagemLabelPeao3Preto.setBounds(190, 120, 50, 50);
				
				tabuleiro.add(imagemLabelPeao3Preto);
				
				//instanciando e colocando no tabuleiro o peao 4 preto
				imagemLabelPeao4Preto = new JLabel(imagemPeao4Preto);
				
				imagemLabelPeao4Preto.setBounds(250, 120, 50, 50);
				
				tabuleiro.add(imagemLabelPeao4Preto);
				
				//instanciando e colocando no tabuleiro o peao 5 preto
				imagemLabelPeao5Preto = new JLabel(imagemPeao5Preto);
				
				imagemLabelPeao5Preto.setBounds(310, 120, 50, 50);
				
				tabuleiro.add(imagemLabelPeao5Preto);
				
				//instanciando e colocando no tabuleiro o peao 6 preto
				imagemLabelPeao6Preto = new JLabel(imagemPeao6Preto);
				
				imagemLabelPeao6Preto.setBounds(370, 120, 50, 50);
				
				tabuleiro.add(imagemLabelPeao6Preto);
				
				//instanciando e colocando no tabuleiro o peao 7 preto
				imagemLabelPeao7Preto = new JLabel(imagemPeao7Preto);
				
				imagemLabelPeao7Preto.setBounds(425, 120, 50, 50);
				
				tabuleiro.add(imagemLabelPeao7Preto);
				
				//instanciando e colocando no tabuleiro o peao 8 preto
				imagemLabelPeao8Preto = new JLabel(imagemPeao8Preto);
						
				imagemLabelPeao8Preto.setBounds(490, 120, 50, 50);
						
				tabuleiro.add(imagemLabelPeao8Preto);
				
				//peoes brancos  
				
				//instanciando e colocando no tabuleiro o peao 1 branco
				imagemLabelPeao1Branco = new JLabel(imagemPeao1Branco);
				
				imagemLabelPeao1Branco.setBounds(70, 425, 50, 50);
				
				tabuleiro.add(imagemLabelPeao1Branco);
				
				//instanciando e colocando no tabuleiro o peao 2 branco
				imagemLabelPeao2Branco = new JLabel(imagemPeao2Branco);
						
				imagemLabelPeao2Branco.setBounds(130, 425, 50, 50);
					
				tabuleiro.add(imagemLabelPeao2Branco);
				
				//instanciando e colocando no tabuleiro o peao 3 branco
				imagemLabelPeao3Branco = new JLabel(imagemPeao3Branco);
				
				imagemLabelPeao3Branco.setBounds(190, 425, 50, 50);
				
				tabuleiro.add(imagemLabelPeao3Branco);
				
				//instanciando e colocando no tabuleiro o peao 4 Branco
				imagemLabelPeao4Branco = new JLabel(imagemPeao4Branco);
				
				imagemLabelPeao4Branco.setBounds(250, 425, 50, 50);
				
				tabuleiro.add(imagemLabelPeao4Branco);
				
				//instanciando e colocando no tabuleiro o peao 5 preto
				imagemLabelPeao5Branco = new JLabel(imagemPeao5Branco);
				
				imagemLabelPeao5Branco.setBounds(310, 425, 50, 50);
				
				tabuleiro.add(imagemLabelPeao5Branco);
				
				//instanciando e colocando no tabuleiro o peao 6 preto
				imagemLabelPeao6Branco = new JLabel(imagemPeao6Branco);
				
				imagemLabelPeao6Branco.setBounds(370, 425, 50, 50);
				
				tabuleiro.add(imagemLabelPeao6Branco);
				
				//instanciando e colocando no tabuleiro o peao 7 preto
				imagemLabelPeao7Branco = new JLabel(imagemPeao7Branco);
				
				imagemLabelPeao7Branco.setBounds(425, 425, 50, 50);
				
				tabuleiro.add(imagemLabelPeao7Branco);
				
				//instanciando e colocando no tabuleiro o peao 8 preto
				imagemLabelPeao8Branco = new JLabel(imagemPeao8Branco);
						
				imagemLabelPeao8Branco.setBounds(490, 425, 50, 50);
						
				tabuleiro.add(imagemLabelPeao8Branco);
	}
	
	void addBispoTabuleiro(){
		//instanciando e colocando no tabuleiro o bispo 1 preto
		imagemLabelBispo1Preto = new JLabel(imagemBispo1Preto);
		
		imagemLabelBispo1Preto.setBounds(185, 65, 50, 50);
		
		tabuleiro.add(imagemLabelBispo1Preto);
		
		//instanciando e colocando no tabuleiro o bispo 2 preto
		imagemLabelBispo2Preto = new JLabel(imagemBispo2Preto);
				
		imagemLabelBispo2Preto.setBounds(365, 65, 50, 50);
				
		tabuleiro.add(imagemLabelBispo2Preto);
		
		//instanciando e colocando no tabuleiro o bispo 1 branco
		imagemLabelBispo1Branco = new JLabel(imagemBispo1Branco);
				
		imagemLabelBispo1Branco.setBounds(185, 485, 50, 50);
				
		tabuleiro.add(imagemLabelBispo1Branco);
				
		//instanciando e colocando no tabuleiro o bispo 2 branco
		imagemLabelBispo2Branco = new JLabel(imagemBispo2Branco);
						
		imagemLabelBispo2Branco.setBounds(365, 485, 50, 50);
						
		tabuleiro.add(imagemLabelBispo2Branco);
	}
	
	void addTorreTabuleiro(){
		//instanciando e colocando no tabuleiro o torre 1 preto
		imagemLabelTorre1Preto = new JLabel(imagemTorre1Preto);
				
		imagemLabelTorre1Preto.setBounds(70, 65, 50, 50);
				
		tabuleiro.add(imagemLabelTorre1Preto);
				
		//instanciando e colocando no tabuleiro o torre 2 preto
		imagemLabelTorre2Preto = new JLabel(imagemTorre2Preto);
						
		imagemLabelTorre2Preto.setBounds(483, 65, 50, 50);
						
		tabuleiro.add(imagemLabelTorre2Preto);
		
		//instanciando e colocando no tabuleiro o torre 1 branco
		imagemLabelTorre1Branco = new JLabel(imagemTorre1Branco);
						
		imagemLabelTorre1Branco.setBounds(70, 485, 50, 50);
						
		tabuleiro.add(imagemLabelTorre1Branco);
						
		//instanciando e colocando no tabuleiro o torre 2 branco
		imagemLabelTorre2Branco = new JLabel(imagemTorre2Branco);
								
		imagemLabelTorre2Branco.setBounds(483, 485, 50, 50);
								
		tabuleiro.add(imagemLabelTorre2Branco);
	}
	
	void addCavaloTabuleiro(){
		//instanciando e colocando no tabuleiro o cavalo 1 preto
		imagemLabelCavalo1Preto = new JLabel(imagemCavalo1Preto);
						
		imagemLabelCavalo1Preto.setBounds(128, 65, 50, 50);
						
		tabuleiro.add(imagemLabelCavalo1Preto);
						
		//instanciando e colocando no tabuleiro o cavalo 2 preto
		imagemLabelCavalo2Preto = new JLabel(imagemCavalo2Preto);
								
		imagemLabelCavalo2Preto.setBounds(425, 65, 50, 50);
								
		tabuleiro.add(imagemLabelCavalo2Preto);
		
		//instanciando e colocando no tabuleiro o cavalo 1 branco
		imagemLabelCavalo1Branco = new JLabel(imagemCavalo1Branco);
								
		imagemLabelCavalo1Branco.setBounds(128, 485, 50, 50);
								
		tabuleiro.add(imagemLabelCavalo1Branco);
								
		//instanciando e colocando no tabuleiro o cavalo 2 branco
		imagemLabelCavalo2Branco = new JLabel(imagemCavalo2Branco);
										
		imagemLabelCavalo2Branco.setBounds(425, 485, 50, 50);
										
		tabuleiro.add(imagemLabelCavalo2Branco);
	}
	
	void addRainhaTabuleiro(){
		//instanciando e colocando no tabuleiro o rainha preto
		imagemLabelRainhaPreto = new JLabel(imagemRainhaPreto);
								
		imagemLabelRainhaPreto.setBounds(305, 65, 50, 50);
								
		tabuleiro.add(imagemLabelRainhaPreto);
		
		//instanciando e colocando no tabuleiro o rei preto
		imagemLabelRainhaBranco = new JLabel(imagemRainhaBranco);
														
		imagemLabelRainhaBranco.setBounds(305, 485, 50, 50);
														
		tabuleiro.add(imagemLabelRainhaBranco);
	}
	
	void addReiTabuleiro(){
		//instanciando e colocando no tabuleiro o rei preto
		imagemLabelReiPreto = new JLabel(imagemReiPreto);
										
		imagemLabelReiPreto.setBounds(245, 65, 50, 50);
										
		tabuleiro.add(imagemLabelReiPreto);
		
		//instanciando e colocando no tabuleiro o rei preto
		imagemLabelReiBranco = new JLabel(imagemReiBranco);
												
		imagemLabelReiBranco.setBounds(245, 485, 50, 50);
												
		tabuleiro.add(imagemLabelReiBranco);
	}
	
	//construtor do tabuleiro (serve para reiniciar jogo)
	private Tabuleiro(){
		
		botaoReiniciar = new JButton("Reiniciar");
		botaoSair = new JButton("Sair");
		botaoInstrucoes = new JButton("Instrucoes");
		botaoRegras = new JButton("Regras");
		
		
		//criando nova instancia de imagem do tabuleiro
		imagemTabuleiro = new ImageIcon("image/board_chess.png");
		
		//criando novas instancias de imagens das pecas pretas
		imagemPeao1Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao2Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao3Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao4Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao5Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao6Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao7Preto = new ImageIcon("image/peaoPreto.png");
		imagemPeao8Preto = new ImageIcon("image/peaoPreto.png");
		
		imagemCavalo1Preto = new ImageIcon("image/cavaloPreto.png");
		imagemCavalo2Preto = new ImageIcon("image/cavaloPreto.png");
		
		imagemBispo1Preto = new ImageIcon("image/bispoPreto.png");
		imagemBispo2Preto = new ImageIcon("image/bispoPreto.png");
		
		imagemTorre1Preto = new ImageIcon("image/torrePreto.png");
		imagemTorre2Preto = new ImageIcon("image/torrePreto.png");
		
		imagemReiPreto = new ImageIcon("image/reiPreto.png");
		imagemRainhaPreto = new ImageIcon("image/rainhaPreto.png");
		
		//criando novas instancias de imagens das pecas pretas
		imagemPeao1Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao2Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao3Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao4Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao5Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao6Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao7Branco = new ImageIcon("image/peaoBranco.png");
		imagemPeao8Branco = new ImageIcon("image/peaoBranco.png");
				
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
		
		addPeaoTabuleiro();
		addBispoTabuleiro();
		addTorreTabuleiro();
		addCavaloTabuleiro();
		addRainhaTabuleiro();
		addReiTabuleiro();
		
		botaoReiniciar.setBounds(550, 530, 100, 30);
		botaoInstrucoes.setBounds(550, 563, 100, 30);
		botaoRegras.setBounds(550, 596, 100, 30);
		botaoSair.setBounds(550, 629, 100, 30);
		
		tabuleiro.add(botaoReiniciar);
		tabuleiro.add(botaoInstrucoes);
		tabuleiro.add(botaoRegras);
		tabuleiro.add(botaoSair);
		
		imagemLabelTabuleiro = new JLabel(imagemTabuleiro);
		
		imagemLabelTabuleiro.setBounds(50, 50, 500, 500);
		
		tabuleiro.add(imagemLabelTabuleiro);
	
		
		tabuleiro.setBounds(10, 10, 500, 500);
		
		janelaJogo.setVisible(true);
		janelaJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaJogo.getContentPane().add(tabuleiro);
	}

	
	
	public void exibirTabuleiro() {

	}

	public void atualizarTabuleiro() {

	}

	public void reiniciarTabuleiro() {

	}

	public boolean validarMovimento() {
		return false;
	}

	public boolean validarXeque() {
		return false;
	}

	public void declararEmpate() {

	}
	
	public static void main(String [] args){
		new Tabuleiro();
	}

}