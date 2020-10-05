package tabelabasquete;
import java.util.Scanner;

/**
 *
 * @author dayvi
 */
public class TabelaBasquete {

    public static void main(String[] args) {
        int aux;
        int entrada = 0;
        System.out.println("--- Teste prático PROWAY --- ");
        Scanner ler = new Scanner(System.in);
        Jogo jg = new Jogo();

        while (entrada != 4) {
            jg.tlInicial();
            entrada = ler.nextInt();
            switch (entrada) {
                case 1:
                    jg.verTabela();
                    break;
                case 2:
                    System.out.printf("\nDigite o placar do jogo " + jg.proxGame() + ":");
                    aux = ler.nextInt();
                    if (aux > 0 && aux <= 1000) {
                        jg.setResult(aux);
                    } else {
                        System.out.println("Verifique o valor digitado");
                    }
                    jg.verTabela();
                    break;
                case 3:
                    do {
                        int jogo = jg.editGame();
                        if (jogo <= 3) {
                            System.out.println("Adicione um jogo novo para altera-lo");
                            break;
                        }

                        System.out.printf("\nQual foi o resultado do jogo " + (jogo + 1) + "?   ");
                        aux = ler.nextInt();
                        if (aux > 0 && aux < 1000) {
                            jg.setEditar(jogo, aux);
                        } else {
                            System.out.println("Verifique o valor do Resultado digitado");
                        }
                    } while (aux < 0 || aux > 1000);
                    break;

                default:
                    if (entrada == 4) {
                        System.out.println("\nSaindo...");
                    } else {
                        System.out.println("Verifique o valor digitado!");
                    }
                    break;
            }
        }

    }
}
