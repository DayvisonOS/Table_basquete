package tabelabasquete;

/**
 *
 * @author dayvi
 */
import java.util.ArrayList;
import java.util.Collections;

public class Jogo {

    protected int anyGame;
    protected int valorMin;
    protected int valorMax;
    protected int recordMaximo;
    protected int recordMinimo;
    protected ArrayList<Integer> jogo = new ArrayList<>();
    protected ArrayList<Integer> result = new ArrayList<>();
    protected ArrayList<Integer> rcMin = new ArrayList<>();
    protected ArrayList<Integer> rcMax = new ArrayList<>();
    protected ArrayList<Integer> min = new ArrayList<>();
    protected ArrayList<Integer> max = new ArrayList<>();
    protected ArrayList<Integer> cont = new ArrayList<>();

    public Jogo() {
        this.jogosInicio();
        this.resultInicial();
        this.rcMinimo();
        this.recordeMaxInicio();
        this.valoresMinInicio();
        this.valoresMaxInicio();
    }

    private void jogosInicio() {
        for (int i = 0; i < 4; i++) {
            this.jogo.add(i + 1);
            this.cont.add(i);
        }
    }

    public void tlInicial() {
        System.out.println("Escolha uma operação\n");
        System.out.println("(1)Visualizar Jogos");
        System.out.println("(2)Adicionar um novo Jogo");
        System.out.println("(3)Alterar ultimo jogo");
        System.out.println("(4)Exit");
        System.out.print("\nDigite a operação: ");
    }

    public int proxGame() {
        return cont.size() + 1;
    }

    private void resultInicial() {
        this.result.add(12);
        this.result.add(24);
        this.result.add(10);
        this.result.add(24);

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                valorMin = this.result.get(0);
            }
            if (this.result.get(i) < Collections.min(this.result)) {
                valorMin = result.get(i);
                recordMinimo++;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                valorMax = this.result.get(0);
            }
            if (this.result.get(i) > Collections.max(this.result)) {
                valorMax = result.get(i);
                recordMaximo++;
            }
        }
    }

    private void rcMinimo() {
        this.min.add(0);
        this.min.add(0);
        this.min.add(1);
        this.min.add(1);
    }

    private void recordeMaxInicio() {
        this.max.add(0);
        this.max.add(1);
        this.max.add(1);
        this.max.add(1);
    }

    private void valoresMinInicio() {
        this.rcMin.add(12);
        this.rcMin.add(12);
        this.rcMin.add(10);
        this.rcMin.add(10);
    }

    private void valoresMaxInicio() {
        this.rcMax.add(12);
        this.rcMax.add(24);
        this.rcMax.add(24);
        this.rcMax.add(24);
    }

    public void setResult(int value) {
        this.result.add(value);
        if (Collections.min(this.result) < Collections.min(this.rcMin)) {
            this.min.add(Collections.max(this.min) + 1);
        } else {
            this.min.add(Collections.max(this.min));
        }
        if (Collections.max(this.result) > Collections.max(this.rcMax)) {
            this.max.add(Collections.max(this.max) + 1);
        } else {
            this.max.add(Collections.max(this.max));
        }
        rcMin.add(Collections.min(this.result));
        rcMax.add(Collections.max(this.result));
        this.jogo.add(jogo.size() + 1);
        this.cont.add(cont.size());
    }

    public int quebraMin() {
        return Collections.max(this.min);
    }

    public int quebraMax() {
        return Collections.max(this.max);
    }

    public int quebraTotal() {
        return quebraMax() + quebraMin();
    }

    public void setEditar(int game, int scoreboard) {

        this.result.set(game, scoreboard);

        if (this.min.get(game) != this.min.get(game - 1)) {
            this.min.set(game, Collections.max(this.min) - 1);
        } else if (this.rcMax.get(game) == this.rcMax.get(game - 1)) {
            this.max.set(game, Collections.max(this.max) + 1);
        }

        if (this.max.get(game) != this.max.get(game - 1) && this.rcMax.get(game) < this.rcMax.get(game - 1)) {
            this.max.set(game, this.min.get(game - 1));
        }
        if (this.result.get(game) == Collections.min(this.result) && this.min.get(game) == this.min.get(game - 1)) {
            this.min.set(game, Collections.max(this.min) + 1);
        }
        rcMin.set(game, Collections.min(this.result));
        rcMax.set(game, Collections.max(this.result));
    }

    public int mnGames() {
        return Collections.min(this.jogo) + 1;
    }

    public int mxGames() {
        return Collections.max(this.jogo);
    }

    public int editGame() {
        return this.result.size() - 1;
    }

    public void verTabela() {
        System.out.printf("%n%6s%18s%20s%20s%20s%20s%n", "Jogo", "Placar", "Temp(Min)", "Temp(Max)", "Rc Min", "Rc Max");
        for (int i = 0; i < jogo.size(); i++) {
            System.out.printf("%n%6d", jogo.get(i));
            System.out.printf("%20d", result.get(i));
            System.out.printf("%23d", rcMin.get(i));
            System.out.printf("%31d", rcMax.get(i));
            System.out.printf("%32d", min.get(i));
            System.out.printf("%31d", max.get(i));
        }
        System.out.println("\n*--------------------------*");

        if (this.quebraMax() > 1) {
            System.out.println("Rec Maximo" + quebraMax());
        }
        if (this.quebraMin() > 1) {
            System.out.print("Rec Minimo" + quebraMin());
        }
        if (this.quebraTotal() > 1) {
            System.out.print("Quebras no recorde total: " + quebraTotal());
        }
    }
}
