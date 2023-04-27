public class Animal {
    private String nome;
    private int idade;
    private String barulho;

    public Animal(String nome, int idade, String barulho) {
        this.nome = nome;
        this.idade = idade;
        this.barulho = barulho;
    }

    public void fazerBarulho() {
        System.out.println(this.nome + ": " + barulho);
    }

    public int envelhecer() {
        this.idade++;
        return this.idade;
    }
}
