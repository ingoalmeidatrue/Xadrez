import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneLayout;

public class ApareceJanelaInstrucoes implements ActionListener{
	private JFrame ajuda;
	private JScrollPane scrollPane;
	private JTextPane textomov;
	private JPanel painel;
	  public ApareceJanelaInstrucoes(String titulo){
		  this.ajuda = new JFrame(titulo);
	    }
	public void actionPerformed(ActionEvent actionEvent) {
		this.montaJanela(); 
		ajuda.setVisible(true);
	}
	
	private void montaJanela(){
		this.painel = new JPanel();
		this.scrollPane = new JScrollPane();
		this.textomov = new JTextPane();
		this.textomov.setEditable(false);
		this.textomov.setText("Para jogar esse xadrez temos algumas instruções: ");
		GroupLayout layout = new GroupLayout(painel);
		this.painel.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);
		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().addComponent(textomov));
		layout.setHorizontalGroup(hGroup);
		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(textomov));
		layout.setVerticalGroup(vGroup);
		scrollPane.setViewportView(painel);
		ScrollPaneLayout scrollPaneLayout = new ScrollPaneLayout(); 
		scrollPaneLayout.setHorizontalScrollBarPolicy(ScrollPaneLayout.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneLayout.setVerticalScrollBarPolicy(ScrollPaneLayout.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setLayout(scrollPaneLayout);
		ajuda.getContentPane().add(this.scrollPane,BorderLayout.CENTER);
		ajuda.setSize(500, 500);
	   // ajuda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   /* ajuda.addWindowListener(
         new WindowAdapter() {
                public void windowClosing(WindowEvent e){                                        
                    System.exit(0);                                
                }
            }); */ //talvez colocar no tabuleiro para melhorar o desempenho     
	}
}