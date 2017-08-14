import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;

public class Espaco extends Component {
	private String nome;
	
	public Espaco(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}