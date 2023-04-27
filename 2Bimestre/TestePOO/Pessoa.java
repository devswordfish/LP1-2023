public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentar() {
        System.out.format("Olá! Meu nome é %s e tenho %d anos!\n", this.nome, this.idade);
    }
}
