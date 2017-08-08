import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class FechaJogo implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null,"Deseja realmente sair do jogo?",null,JOptionPane.INFORMATION_MESSAGE);
		 System.exit(0);
	}
}