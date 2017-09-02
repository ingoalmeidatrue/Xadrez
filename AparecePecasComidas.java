import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneLayout;

public class AparecePecasComidas implements ActionListener{
	private JFrame ajuda;
	private Icon imagemTabuleiro;
	private JPanel painel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JLabel textomov = new JLabel();
	private JLabel image = new JLabel();
	public AparecePecasComidas(String titulo){
		  this.ajuda = new JFrame(titulo);
	    }
	public void actionPerformed(ActionEvent actionEvent) {
		this.montaJanela(); 
		painel.setSize(1000,1000);
		ajuda.setVisible(true);
	}
	private void montaJanela(){
		for(int  i = 0; i < Tabuleiro.getPecasForaDoJogo().size();i++){
			if(Tabuleiro.getPecasForaDoJogo().get(i) instanceof Peao){
				Peao p = (Peao)Tabuleiro.getPecasForaDoJogo().get(i);
				JLabel peao = p.getIcon();
				peao.setBounds(p.getPosicaoxIni(),p.getPosicaoyIni(),50,50);
				painel.add(peao);
			}
			else if(Tabuleiro.getPecasForaDoJogo().get(i) instanceof Rei){
				Rei r = (Rei)Tabuleiro.getPecasForaDoJogo().get(i);
				JLabel rei = r.getIcon();
				rei.setBounds(r.getPosicaoxIni(),r.getPosicaoyIni(),50,50);
				painel.add(rei);
			}
			else if(Tabuleiro.getPecasForaDoJogo().get(i) instanceof Bispo){
				Bispo b = (Bispo)Tabuleiro.getPecasForaDoJogo().get(i);
				JLabel bispo = b.getIcon();
				bispo.setBounds(b.getPosicaoxIni(),b.getPosicaoyIni(),50,50);
				painel.add(bispo);
			}
			else if(Tabuleiro.getPecasForaDoJogo().get(i) instanceof Rainha){
				Rainha r = (Rainha)Tabuleiro.getPecasForaDoJogo().get(i);
				JLabel rainha = r.getIcon();
				rainha.setBounds(r.getPosicaoxIni(),r.getPosicaoyIni(),50,50);
				painel.add(rainha);
			}
			else if(Tabuleiro.getPecasForaDoJogo().get(i) instanceof Torre){
				Torre t = (Torre)Tabuleiro.getPecasForaDoJogo().get(i);
				JLabel torre = t.getIcon();
				torre.setBounds(t.getPosicaoxIni(),t.getPosicaoyIni(),50,50);
				painel.add(torre);
			}
			else if(Tabuleiro.getPecasForaDoJogo().get(i) instanceof Cavalo){
				Cavalo c = (Cavalo)Tabuleiro.getPecasForaDoJogo().get(i);
				JLabel cavalo = c.getIcon();
				cavalo.setBounds(c.getPosicaoxIni(),c.getPosicaoyIni(),50,50);
				painel.add(cavalo);
			}
		}
		imagemTabuleiro = new ImageIcon("image/board_chess.png");
		image.setIcon(imagemTabuleiro);
		//image.setBounds(10,10,400,400);
		painel.add(image);
		GroupLayout layout = new GroupLayout(painel);
		this.painel.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().addComponent(image));
		layout.setHorizontalGroup(hGroup);
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(image));
		layout.setVerticalGroup(vGroup);
		scrollPane.setViewportView(painel);
		ScrollPaneLayout scrollPaneLayout = new ScrollPaneLayout(); 
		scrollPaneLayout.setHorizontalScrollBarPolicy(ScrollPaneLayout.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneLayout.setVerticalScrollBarPolicy(ScrollPaneLayout.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setLayout(scrollPaneLayout);
		ajuda.getContentPane().add(this.scrollPane,BorderLayout.CENTER);
		ajuda.setSize(700, 700);
	   //ajuda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ajuda.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){                                           
                    ajuda.setVisible(false);
                }
            }); //talvez colocar no tabuleiro para melhorar o desempenho     
	}
	}