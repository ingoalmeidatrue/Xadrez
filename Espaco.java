import java.awt.Container;

import javax.swing.JLabel;

public class Espaco {
	private JLabel imagemPeca;
	
	public Espaco(JLabel peca){
		this.imagemPeca = peca;
	}

	public JLabel getImagempeca() {
		return imagemPeca;
	}
}