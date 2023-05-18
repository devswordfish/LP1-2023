public class GastoLazer extends Gasto {
    private boolean importante;

    public GastoLazer(String nome, int valor, boolean importante) {
        super(nome, valor);
        this.setImportante(importante);
    }

    public boolean isImportante() {
        return importante;
    }

    public void setImportante(boolean importante) {
        this.importante = importante;
    }

    @Override
    public void mudarValor(double valor) {
        this.valor = valor * 1.05;
    }
}
