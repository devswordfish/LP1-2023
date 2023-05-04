import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Motor motor = new Motor(12, 2, 30);

        ArrayList<Roda> rodas = new ArrayList<Roda>();
        rodas.add(new Roda(15, 20));
        rodas.add(new Roda(15, 20));
        rodas.add(new Roda(15, 20));
        rodas.add(new Roda(15, 20));

        Carro carro = new Carro("0-index", "null", "00110011", 1,"preto", motor, rodas);
    }
}
