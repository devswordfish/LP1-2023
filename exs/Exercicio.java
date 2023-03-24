package exs;

import java.util.Scanner;

public class Exercicio {
    private String[] nomes = new String[3];
    private double[][] contas = new double[4][4];

    public static void main(String[] args) {
        Exercicio app = new Exercicio();
        
        app.start();
    }

    public void start() {
        Scanner scan = new Scanner(System.in);

        // pede para o usuário digitar três nomes
        for (int i = 0; i < nomes.length; i++) {
            System.out.format("Digite o %dº nome: ", i + 1);
            String nome = scan.nextLine();
            nomes[i] = nome;
        }

        mostrarNomes();

        // repete quatro vezes: pede ao usuário digitar um número e mostra o nome da pessoa baseado nesse número
        for (int i = 0; i < 4; i++) {
            boolean continuar = true;

            while (continuar) {
                try {
                    System.out.print("Digite um número para a opção: ");
                    int opcao = Integer.parseInt(scan.nextLine());
                    checarNumero(opcao);

                    continuar = false;
                } catch (Exception e) {
                    System.out.println("Digite um número!!!");
                }
            }
            
        }

        // pede para o usuário digitar três números
        for (int i = 0; i < 3; i++) {
            System.out.format("Digite o %dº número: ", i + 1);

            boolean continuar = true;

            while (continuar) {
                try {
                    double numero = Double.parseDouble(scan.nextLine());
                    contas[0][1 + i] = numero;
                    contas[1 + i][0] = numero;

                    continuar = false;
                } catch (Exception e) {
                    System.out.println("Digite um número!!!");
                }
            }
        }

        // configuração da matriz
        for (int i = 1; i < contas.length; i++) {
            for (int j = 1; j < contas[i].length; j++) {
                contas[i][j] = i == j 
                    ? contas[i][0] * contas[0][j]
                    : contas[i][0] - contas[0][j];
            }
        }

        mostrarContas();

        scan.close();
    }

    private void mostrarNomes() {
        System.out.println("Nomes digitados:");
        for (int i = 0; i < nomes.length; i++) {
            System.out.print(nomes[i]);

            if (i  < nomes.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private void mostrarContas() {
        for (double[] row : contas) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private void checarNumero(int number) {
        if (number < 1) System.out.println("Opção inválida");
        else if (number == 1) System.out.println(nomes[0]);
        else if (number <= 10) System.out.println(nomes[1]);
        else System.out.println(nomes[2]);
    }
}
