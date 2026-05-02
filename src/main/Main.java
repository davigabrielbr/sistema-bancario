package main;

import model.Conta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroDigitado = 0;
        Conta conta = new Conta();

        do {
            System.out.println("=== Sistema Bancário ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            numeroDigitado = scanner.nextInt();

            switch (numeroDigitado) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();

                    if (conta.depositar(valorDeposito)) {
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Valor inválido para o depósito.");
                    }

                    break;
                case 2:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();

                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Valor inválido para o saque.");
                    }

                    break;
                case 3:
                    System.out.println("Saldo atual: R$ " + conta.getSaldo());

                    break;
                case 4:
                    System.out.println("Saindo...");

                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (numeroDigitado != 4);
    }
}