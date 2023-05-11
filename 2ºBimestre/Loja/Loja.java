import java.util.ArrayList;

public class Loja {
    private String nome;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public Loja(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void mostrarClientes() {
        System.out.println("-=-=-=- Clientes -=-=-=-");
        for (Cliente c : this.clientes) {
            System.out.format("Nome: %s   CPF: %s   Telefone: %s\n", c.getNome(), c.getCpf(), c.getTelefone());
        }
    }
}
