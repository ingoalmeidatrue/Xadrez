import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class FechaJogo implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		int selectedOption = JOptionPane.showConfirmDialog(null,"Deseja sair do jogo?", null, JOptionPane.YES_NO_OPTION);
		if(selectedOption == JOptionPane.YES_OPTION){
			System.exit(0);  	                	
		}	
	}
}