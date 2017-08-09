import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class ApareceJanelaFechaJogo implements WindowListener {

	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if (e.getID() == WindowEvent.WINDOW_CLOSING){
			int selectedOption = JOptionPane.showConfirmDialog(null,"Deseja sair do jogo?", null, JOptionPane.YES_NO_OPTION);
			if(selectedOption == JOptionPane.YES_OPTION){
				System.exit(0);  	                	
			}	
		}	
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}