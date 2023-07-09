package model;

import repository.ExibirInterface;

public class ItemPedido implements ExibirInterface {
    private static long idBase = 0;

    private long id;
    private String peca;
    private String modelo;
    private String tamanho;
    private double valor;

    public ItemPedido(String peca, String modelo, String tamanho, double valor) {
        this.peca = peca;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.valor = valor;
        this.id = idBase++;
    }

    public static long getIdBase() {
        return idBase;
    }

    public static void setIdBase(long idBase) {
        ItemPedido.idBase = idBase;
    }

    public long getId() {
        return id;
    }

    public String getPeca() {
        return peca;
    }

    public void setPeca(String peca) {
        this.peca = peca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public void exibir(boolean exibir) {
        if (exibir) {
            System.out.println("Item do pedido: " + getId());
            System.out.println("- Peca: " + this.getPeca());
            System.out.println("- Modelo: " + this.getModelo());
            System.out.println("- Tamanho: " + this.getTamanho());
            System.out.println("- Valor: R$" + this.getValor());
        } else {
            System.out.format("- %s, %s, %s, %.1f\n", getPeca(), getModelo(), getTamanho(), getValor());
        }
    }
}
