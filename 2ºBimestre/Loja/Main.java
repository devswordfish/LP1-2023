public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja("Capitão Salgados");

        Cliente c1 = new Cliente("C1", "123.456.789-00", "12345-6789");

        Pedido p1 = new Pedido(c1, "Batata Fritas", 12.99, 0);

        loja.addCliente(c1);
        loja.addPedido(p1);

        loja.mostrarClientes();
    }
}
