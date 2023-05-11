public class Motor {
    private int potencia;
    private double classificacao;
    private int valvulas;

    public Motor(int potencia, double classificacao, int valvulas) {
        this.potencia = potencia;
        this.classificacao = classificacao;
        this.valvulas = valvulas;
    }

    public int getPotencia() {
        return this.potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public double getClassificacao() {
        return this.classificacao;
    }
    public void setClassificacao(double classificacao) {
        this.classificacao = classificacao;
    }

    public int getValvulas() {
        return this.valvulas;
    }
    public void setValvulas(int valvulas) {
        this.valvulas = valvulas;
    }
}
