import java.util.ArrayList;

public class Carro {
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private String cor;
    private Motor motor;
    private ArrayList<Roda> rodas = new ArrayList<>();

    public Carro(String marca, String modelo, String placa, int ano, String cor, Motor motor, ArrayList<Roda> rodas) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.motor = motor;
        this.rodas = rodas;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public Motor getMotor() {
        return motor;
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public ArrayList<Roda> getRodas() {
        return rodas;
    }
    public void setRodas(ArrayList<Roda> rodas) {
        this.rodas = rodas;
    }
}
