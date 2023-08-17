import entity.Endereco;
import entity.Pessoa;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
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
}
