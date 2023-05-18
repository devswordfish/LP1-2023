public class GastoVariavel extends Gasto {
    private int meses;

    protected GastoVariavel(String nome, double valor, int meses) {
        super(nome, valor);
        this.setMeses(meses);
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
}
