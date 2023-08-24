import entity.Endereco;
import entity.Pedido;
import entity.Pessoa;
import entity.Produto;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        teste2();
    }

    public static void teste1() {
        Endereco e1 = new Endereco("A", "a");
        Endereco e2 = new Endereco("B", "b");
        Endereco e3 = new Endereco("C", "c");
        Endereco e4 = new Endereco("D", "d");

        Pessoa p1 = new Pessoa("A", "Z", "aaa@emil", e1);
        Pessoa p2 = new Pessoa("B", "Y", "bbb@email", e2);
        Pessoa p3 = new Pessoa("C", "X", "ccc@email", e3);
        Pessoa p4 = new Pessoa("D", "W", "ddd@email", e4);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(p1);
        session.persist(p2);
        session.persist(p3);
        session.persist(p4);

        transaction.commit();

        List<Pessoa> pessoas = session.createQuery("from Pessoa", Pessoa.class).list();
        pessoas.forEach(p -> System.out.println(p.toString()));
    }

    public static void teste2() {
        Endereco e1 = new Endereco("A", "a");
        Endereco e2 = new Endereco("B", "b");
        Endereco e3 = new Endereco("C", "c");
        Endereco e4 = new Endereco("D", "d");

        Pessoa p1 = new Pessoa("A", "Z", "aaa@emil", e1);
        Pessoa p2 = new Pessoa("B", "Y", "bbb@email", e2);
        Pessoa p3 = new Pessoa("C", "X", "ccc@email", e3);
        Pessoa p4 = new Pessoa("D", "W", "ddd@email", e4);

        Produto pr1 = new Produto("ZZZ", 99.99);
        Produto pr2 = new Produto("XXX", 59.99);
        Produto pr3 = new Produto("WWW", 1.99);

        Pedido pe1 = new Pedido(p1, Arrays.asList(pr1, pr2));
        Pedido pe2 = new Pedido(p2, Arrays.asList(pr1, pr2, pr3));
        Pedido pe3 = new Pedido(p3, Arrays.asList(pr1));
        Pedido pe4 = new Pedido(p4, Arrays.asList(pr2, pr3));

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(pe1);
        session.persist(pe2);
        session.persist(pe3);
        session.persist(pe4);

        transaction.commit();

        List<Pedido> pedidos = session.createQuery("from Pedido", Pedido.class).list();
        pedidos.forEach(p -> System.out.println(p.getTotal()));


        System.out.println();


        pe1.addProduto(new Produto("M", 10));

        transaction.begin();

        session.persist(pe1);

        transaction.commit();

        pedidos = session.createQuery("from Pedido", Pedido.class).list();
        pedidos.forEach(p -> System.out.println(p.getTotal()));
    }
}
