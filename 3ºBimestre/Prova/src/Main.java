import model.*;

public class Main {
    public static void main(String[] args) {
        ItemPedido itemPedido1 = new ItemPedido("Bermuda", "Jogador", "G", 30.0);

        itemPedido1.exibir(true);

        itemPedido1.exibir(false);

        Orcamento orcamento = new Orcamento();

        orcamento.addItem(itemPedido1);

        orcamento.exibir(true);

        orcamento.exibir(false);

        ItemPedido itemPedido2 = new ItemPedido("Calça", "Jogador", "G", 60.0);

        orcamento.addItem(itemPedido2);

        orcamento.exibir(true);

        try {
            orcamento.removerItem(1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        orcamento.exibir(true);

        try {
            orcamento.removerItem(99);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        orcamento.exibir(true);

        Pedido pedido = new Pedido("15/06/2023");

        pedido.addItem(itemPedido2);

        pedido.exibir(true);

        pedido.exibir(false);

        try {
            pedido.entregar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        pedido.exibir(false);

        try {
            pedido.entregar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        pedido.exibir(false);
    }
}
