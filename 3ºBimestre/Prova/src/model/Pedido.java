package model;

public class Pedido extends Orcamento {
    private String dataEntrega;
    private boolean entregue;

    public Pedido(String dataEntrega) {
        this.dataEntrega = dataEntrega;
        this.entregue = false;
    }

    public void entregar() throws Exception {
        if (entregue == false) this.entregue = true;
        else throw new Exception("O pedido já foi entregue!");
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Override
    public void exibir(boolean exibir) {
        if (exibir) {
            System.out.println("Pedido: " + getId());

            System.out.println("Itens:");
            for (ItemPedido i : getItens()) {
                i.exibir(false);
            }

            System.out.println("Data de Entrega: " + dataEntrega);
            System.out.println("Situação: " + (this.entregue ? "Entregue" : "Não entregue"));
            System.out.println("Valor total: R$" + getValorTotal());
        } else {
            System.out.format("- %d, %s, %s, %.1f\n", this.getId(), dataEntrega, (this.entregue ? "Entregue" : "Não entregue"), getValorTotal());
        }
    }
}
