package main;

import model.Cliente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroDigitado;
        Cliente cliente = null;

        do {
            numeroDigitado = menu(scanner);

            switch (numeroDigitado) {
                case 1 -> cliente = criarConta(cliente, scanner);
                case 2 -> depositar(cliente, scanner);
                case 3 -> sacar(cliente, scanner);
                case 4 -> consultarSaldo(cliente);
                case 5 -> sair();
                default -> opcaoInvalida();
            }
        } while (numeroDigitado != 5);

        scanner.close();
    }

    public static int menu(Scanner scanner) {
        System.out.println();

        System.out.println("============================\n" +
                            "      SISTEMA BANCÁRIO\n" +
                            "============================");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Consultar saldo");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
        int numeroDigitado = scanner.nextInt();

        scanner.nextLine();

        return numeroDigitado;
    }

    public static Cliente criarConta(Cliente cliente, Scanner scanner) {
        if (verificarCliente(cliente)) {
            System.out.println("A conta já foi criada.");

            return cliente;
        } else {
            System.out.print("Digite o seu nome: ");
            String nomeCliente = scanner.nextLine().trim();

            if (nomeCliente.isEmpty()) {
                System.out.println("Nome não informado.");

                return cliente;
            }

            System.out.print("Digite o seu cpf: ");
            String cpfCliente = scanner.nextLine().trim();

            if (cpfCliente.isEmpty()) {
                System.out.println("CPF não informado.");

                return cliente;
            }

            cliente = new Cliente(nomeCliente, cpfCliente);

            System.out.println("Conta criada com sucesso.");

            return cliente;
        }
    }

    public static void depositar(Cliente cliente, Scanner scanner) {
        if (verificarCliente(cliente)) {
            System.out.print("Digite o valor do depósito: ");
            double valorDeposito = scanner.nextDouble();

            scanner.nextLine();

            if (verificarValor(valorDeposito)) {
                cliente.getConta().depositar(valorDeposito);

                System.out.println("Depósito realizado com sucesso.");
            } else {
                System.out.println("Digite um valor maior que zero.");
            }
        } else {
            contaNaoCriada();
        }
    }

    public static void sacar(Cliente cliente, Scanner scanner) {
        if (verificarCliente(cliente)) {
            System.out.print("Digite o valor do saque: ");
            double valorSaque = scanner.nextDouble();

            scanner.nextLine();

            if (!verificarValor(valorSaque)) {
                System.out.println("Digite um valor maior que zero.");
            } else if (!verificarSaldo(cliente, valorSaque)) {
                System.out.println("Saldo insuficiente.");
            } else {
                cliente.getConta().sacar(valorSaque);

                System.out.println("Saque realizado com sucesso.");
            }
        } else {
            contaNaoCriada();
        }
    }

    public static void consultarSaldo(Cliente cliente) {
        if (verificarCliente(cliente)) {
            System.out.println("Cliente: " + cliente.getNome());
            System.out.printf("Saldo atual: R$ %.2f%n", cliente.getConta().getSaldo());
        } else {
            contaNaoCriada();
        }
    }

    public static void sair() {
        System.out.println("Saindo...");
    }

    public static void opcaoInvalida() {
        System.out.println("Opção inválida.");
    }

    public static void contaNaoCriada() {
        System.out.println("Conta não criada.");
    }

    public static boolean verificarCliente(Cliente cliente) {
        return cliente != null;
    }

    public static boolean verificarValor(double valor) {
        return valor > 0;
    }

    public static boolean verificarSaldo(Cliente cliente, double valor) {
        return valor <= cliente.getConta().getSaldo();
    }
}