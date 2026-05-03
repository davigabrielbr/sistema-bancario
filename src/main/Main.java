package main;

import model.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroDigitado;
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
                case 1 -> cliente = criarConta(cliente, scanner);
                case 2 -> depositar(cliente, scanner);
                case 3 -> sacar(cliente, scanner);
                case 4 -> consultarSaldo(cliente);
                case 5 -> sair();
                default -> opcaoInvalida();
            }
        } while (numeroDigitado != 5);
    }

    public static Cliente criarConta(Cliente cliente, Scanner scanner) {
        if (cliente == null) {
            System.out.print("Digite o seu nome: ");
            String nomeCliente = scanner.nextLine().trim();

            if (nomeCliente.isEmpty()) {
                System.out.println("Nome não informado.");

                return cliente;
            }

            System.out.print("Digite o seu cpf: ");
            String cpfCliente = scanner.nextLine().trim();

            if (cpfCliente.isEmpty()) {
                System.out.println("Cpf não informado.");

                return cliente;
            }

            cliente = new Cliente(nomeCliente, cpfCliente);

            System.out.println("Conta criada com sucesso.");

            return cliente;
        } else {
            System.out.println("A conta já foi criada.");

            return cliente;
        }
    }

    public static void depositar(Cliente cliente, Scanner scanner) {
        if (cliente != null) {
            System.out.print("Digite o valor do depósito: ");
            double valorDeposito = scanner.nextDouble();

            if (cliente.getConta().depositar(valorDeposito)) {
                System.out.println("Depósito realizado com sucesso.");
            } else {
                System.out.println("Valor inválido para o depósito.");
            }
        } else {
            System.out.println("Conta não criada.");
        }
    }

    public static void sacar(Cliente cliente, Scanner scanner) {
        if (cliente != null) {
            System.out.print("Digite o valor do saque: ");
            double valorSaque = scanner.nextDouble();

            if (cliente.getConta().sacar(valorSaque)) {
                System.out.println("Saque realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Conta não criada.");
        }
    }

    public static void consultarSaldo(Cliente cliente) {
        if (cliente != null) {
            System.out.printf("Saldo atual: R$ %.2f%n", cliente.getConta().getSaldo());
        } else {
            System.out.println("Conta não criada.");
        }
    }

    public static void sair() {
        System.out.println("Saindo...");
    }

    public static void opcaoInvalida() {
        System.out.println("Opção inválida.");
    }
}