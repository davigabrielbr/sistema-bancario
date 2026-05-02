package main;

import model.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroDigitado = 0;
        Cliente cliente = null;

        do {
            System.out.println("=== Sistema Bancário ===");
            System.out.println("1 - Cria conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Consultar saldo");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            numeroDigitado = scanner.nextInt();

            scanner.nextLine();

            switch (numeroDigitado) {
                case 1:
                    System.out.print("Digite o seu nome: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.print("Digite o seu cpf: ");
                    String cpfCliente = scanner.nextLine();

                    cliente = new Cliente(nomeCliente, cpfCliente);

                    System.out.println("Conta criada com sucesso.");

                    break;
                case 2:
                    if (cliente != null) {
                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();

                        if (cliente.getConta().depositar(valorDeposito)) {
                            System.out.println("Depósito realizado com sucesso.");
                        } else {
                            System.out.println("Valor inválido para o depósito.");
                        }

                        break;
                    } else {
                        System.out.println("Conta não criada.");

                        break;
                    }
                case 3:
                    if (cliente != null) {
                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = scanner.nextDouble();

                        if (cliente.getConta().sacar(valorSaque)) {
                            System.out.println("Saque realizado com sucesso.");

                            break;
                        } else {
                            System.out.println("Saldo insuficiente.");

                            break;
                        }
                    } else {
                        System.out.println("Conta não criada.");

                        break;
                    }
                case 4:
                    if (cliente != null) {
                        System.out.printf("Saldo atual: R$ %.2f%n", cliente.getConta().getSaldo());

                        break;
                    } else {
                        System.out.println("Conta não criada.");
                    }
                case 5:
                    System.out.println("Saindo...");

                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (numeroDigitado != 5);
    }
}