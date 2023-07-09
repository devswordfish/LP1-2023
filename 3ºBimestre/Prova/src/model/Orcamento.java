package model;

import repository.ExibirInterface;

import java.util.List;
import java.util.ArrayList;

public class Orcamento implements ExibirInterface {
    private static long idBase = 0;

    private long id;
    private List<ItemPedido> itens;
    private double valorTotal;

    public Orcamento() {
        this.id = idBase++;
        this.itens = new ArrayList<>();
    }

    public void addItem(ItemPedido item) {
        itens.add(item);
        this.valorTotal += item.getValor();
    }

    public void removerItem(long id) throws RuntimeException {
        for (ItemPedido i : itens) {
            if (i.getId() == id) {
                itens.remove(i);
                this.valorTotal -= i.getValor();
                return;
            }
        }

        throw new RuntimeException("O item não foi encontrado!");
    }

    public static long getIdBase() {
        return idBase;
    }

    public long getId() {
        return id;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public void exibir(boolean exibir) {
        if (exibir) {
            System.out.println("Orçamento: " + getId());
            System.out.println("Itens:");

            for (ItemPedido i : itens) {
                i.exibir(false);
            }

            System.out.println("Valor total: R$" + getValorTotal());
        } else {
            System.out.println("- " + getId() + ", " + "R$" + getValorTotal());
        }
    }
}
