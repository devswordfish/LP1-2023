public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("\\b\\0\\n\\t", 0);
        pessoa.apresentar();

        Animal animal = new Animal("Boid", 10, "Auuhh!!!");
        animal.fazerBarulho();
        System.out.println("Idade: " + animal.envelhecer());
    }
}
