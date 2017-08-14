import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ApareceJanelaRegras implements ActionListener{

	public void actionPerformed(ActionEvent actionEvent) {
		JOptionPane.showMessageDialog(null,"MOVIMENTAÇÃO DE PEÇAS\r\n" + 
				"Torre - A movimentação da torre se dá somente de forma horizontal (linhas do tabuleiro) ou vertical (colunas do tabuleiro).\r\n" + 
				"Bispo - Esta peça se movimenta somente nas diagonais do tabuleiro.\r\n" + 
				"Dama - Uma dama pode se movimentar tanto na horizontal como na vertical (assim como uma torre) ou nas diagonais (assim como um bispo).\r\n" + 
				"Rei - Se movimenta em qualquer direção mas com limitação quanto ao número de casas. O limite de casas que um rei pode se deslocar é de uma casa por lance. O rei NUNCA pode fazer um movimento que resulte em um xeque para ele.\r\n" + 
				"Peão - O peão somente pode fazer movimentos adjacentes à sua posição anterior, isto é, não pode retroceder. O peão, assim como o rei só pode deslocar-se 1 casa à frente por lance, no entanto, quando o peão ainda está na sua posição inicial, este pode dar um salto de 2 casas à frente.\r\n" + 
				"Cavalo - É a única peça que pode \"saltar\" sobre outras peças. A movimentação do cavalo é feita em forma de \"L\", ou seja, anda 2 casas em qualquer direção (vertical ou horizontal) e depois mais uma em sentido perpendicular.\r\n" + 
				"Nenhuma peça, quando deslocada, pode ocupar uma casa que já está sendo ocupada por outra peça da mesma cor.\r\n" + 
				"Quando a casa de destino de uma peça, quando em movimento, estiver sendo ocupada por uma peça de cor adversária, a peça em movimento efetuará a captura da aversária.\r\n" + 
				"A captura feita por peças do tipo peão só é possível quando a peça a ser capturada estiver deslocada uma linha à frente e 1 coluna a direita ou a esquerda. A captura se dá na diagonal.\r\n" + 
				"MOVIMENTOS ESPECIAIS\r\n" + 
				"Roque - É um movimento que envolve 2 peças da mesma cor. São elas o Rei e qualquer uma das torres. O roque é feito ao mover o rei 2 casas para qualquer lado na horizontal. Para se fazer um roque é obrigatório satisfazer as seguintes condições:\r\n" + 
				"O Rei não pode ter sido mexido até o momento do roque. Tem que estar na posição inicial.\r\n" + 
				"Assim como o Rei, a Torre tambem não pode ter sido mexida, portanto deve estar na sua posição inicial.\r\n" + 
				"As casas pelas quais o Rei irá passar, não podem estar sob ameaça das peças adversárias.\r\n" + 
				"Não pode haver nenhuma peça obstruindo o caminho onde passarão Rei e Torre.\r\n" + 
				"OBS: Para efetuar o Roque, clique sobre o Rei e clique sobre a posição desejada. O sistema moverá a Torre automaticamente.\r\n" + 
				"Captura en-passant - Esta captura é um tipo especial feita por peões. Regras para a captura en-passant:\r\n" + 
				"O peão a ser capturado deve ter feito o lance inicial de 2 casas.\r\n" + 
				"O peão que vai fazer a captura, pode fazê-la como se o peão a ser capturado estivesse exatamente 1 casa à frente da sua posição inicial e deslocado 1 coluna a esquerda ou a direita como na captura normal.\r\n" + 
				"PROMOÇÕES DE PEÕES\r\n" + 
				"Um peão, ao alcançar a última linha do tabuleiro (no caso das brancas a linha 8, e no caso das pretas a linha 1) é promovido, o jogador é obrigado a escolher entre uma das seguintes peças para substituí-lo:\r\n" + 
				"Dama\r\n" + 
				"Torre\r\n" + 
				"Bispo\r\n" + 
				"Cavalo\r\n" + 
				"VITÓRIA\r\n" + 
				"Só existem 2 formas de um jogador vencer. São elas:\r\n" + 
				"Se o jogador fazer um Xeque-Mate ao adversário.\r\n" + 
				"Se o adversário desistir da partida.\r\n" + 
				"Na sala ranqueada, ainda um jogador pode ganhar se o seu adversário atingir o tempo limite.\r\n" + 
				"EMPATES\r\n" + 
				"Uma partida é considerada empatada quando:\r\n" + 
				"Um jogador não puder mais efetuar jogadas consideradas legais.\r\n" + 
				"Um jogador propor o empate e o outro aceitar.\r\n" + 
				"Os jogadores não tiverem mais peças suficientes para dar xeque-mate ao adversário. É considerado material insuficiente:\r\n" + 
				"O Rei e um Bispo\r\n" + 
				"O Rei e um Cavalo\r\n" + 
				"O Rei e dois Cavalos contra um Rei sozinho\r\n" + 
				"Um jogador oferecer xeque-perpétuo.\r\n" + 
				"Forem feitas 50 jogadas sem captura e sem movimentação de peão.\r\n" + 
				"Determinada posição ocorrer pela 3ª vez durante uma partida.\r\n" + 
				"REI AFOGADO\r\n" + 
				"O \"rei afogado\" é uma posição que ocorre em duas circunstâncias ao mesmo tempo:\r\n" + 
				"O jogador da vez não tem jogadas legais para realizar\r\n" + 
				"O rei do jogador da vez não está em xeque e não pode movimentar nenhuma peça;\r\n" + 
				"Quando isto acontece, se diz que o rei está \"afogado\" e a partida termina em empate.","Regras do jogo",JOptionPane.PLAIN_MESSAGE);
	}
}