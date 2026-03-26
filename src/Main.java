import project.mateuzin.banco.Conta;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //throws InterruptedException para o java obrigar a tratar um erro, caso acontecer

        //scanner para entrada de caracteres
        Scanner input = new Scanner(System.in);

        System.out.println("Iae, Você quer criar uma conta? ");
        String escolha = input.nextLine();
        //nextLine lê a linha toda

        //equalIgnoreCase compara 2 strings
        if (escolha.equalsIgnoreCase("nao")) {
            System.out.println("Blz, tenha um bom dia!");
            return;
        }

        //Fazendo o método nome acontecer
        String nome;
        do {
            System.out.println("Qual seu nome:");
            nome = input.nextLine();
        } while (nome.length() < 3);

        // Fazendo o método senha acontecer
        String senha1, senha2;
        do {
            System.out.println("Digite sua senha:");
            senha1 = input.nextLine();

            System.out.println("Confirme sua senha:");
            senha2 = input.nextLine();

        } while (!Objects.equals(senha1, senha2) || senha1.length() < 3);

        // Fazendo o método Saldo acontecer
        double saldo;
        do {
            System.out.println("Informe o saldo inicial:");
            saldo = input.nextDouble();
        } while (saldo < 0);

        Conta conta = new Conta(nome, senha1, saldo);

        int opcao;

        do {
            System.out.println("""
                    \nBem-vindo %s
                    1 - Ver saldo
                    2 - Sacar
                    3 - Depositar
                    4 - Sair
                    """.formatted(conta.titular));

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo: " + conta.getSaldo());
                    break;

                case 2:
                    System.out.println("Valor para saque:");
                    double saque = input.nextDouble();

                    if (saque <= conta.getSaldo()) {
                        conta.sacarSaldo(saque);
                        System.out.println("Novo saldo: " + conta.getSaldo());
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;

                case 3:
                    System.out.println("Valor para depósito:");
                    double deposito = input.nextDouble();

                    if (deposito > 0) {
                        conta.setSaldo(deposito);
                        System.out.println("Novo saldo: " + conta.getSaldo());
                    } else {
                        System.out.println("Valor inválido!");
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

    }
}