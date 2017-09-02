import java.awt.event.MouseListener;

public class PecaMorta{
	void check(MouseListener x){
		if(x instanceof Peao){
			Peao p = (Peao)x;
			p.setMorta(true);
		}
		else if(x instanceof Rei){
			Rei rei = (Rei)x;
			rei.setMorta(true);
		}
		else if(x instanceof Bispo){
			Bispo bispo = (Bispo)x;
			bispo.setMorta(true);
		}
		else if(x instanceof Rainha){
			Rainha rainha = (Rainha)x;
			rainha.setMorta(true);
		}
		else if(x instanceof Torre){
			Torre torre = (Torre)x;
			torre.setMorta(true);
		}
		else if(x instanceof Cavalo){
			Cavalo cavalo = (Cavalo)x;
			cavalo.setMorta(true);
		}
	}
}
