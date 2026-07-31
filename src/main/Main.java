package main;

import model.Cliente;
import model.TipoConta;

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
                case 4 -> consultarCliente(cliente);
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
        System.out.println("4 - Consultar cliente");
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
        }

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

        System.out.println("Digite o tipo da conta:");
        System.out.println("1 - Corrente");
        System.out.println("2 - Poupança");
        System.out.print("Opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        TipoConta tipoConta;

        switch (opcao) {
            case 1 -> tipoConta = TipoConta.CORRENTE;
            case 2 -> tipoConta = TipoConta.POUPANCA;
            default -> {
                System.out.println("Tipo de conta inválido.");
                return cliente;
            }
        }

        cliente = new Cliente(nomeCliente, cpfCliente, tipoConta);

        System.out.println("Conta criada com sucesso.");
        return cliente;
    }

    public static void depositar(Cliente cliente, Scanner scanner) {
        if (!verificarCliente(cliente)) {
            contaNaoCriada();
            return;
        }

        System.out.print("Digite o valor do depósito: ");
        double valorDeposito = scanner.nextDouble();
        scanner.nextLine();

        if (!cliente.getConta().depositar(valorDeposito)) {
            System.out.println("Digite um valor maior que zero.");
            return;
        }

        System.out.println("Depósito realizado com sucesso.");
    }

    public static void sacar(Cliente cliente, Scanner scanner) {
        if (!verificarCliente(cliente)) {
            contaNaoCriada();
            return;
        }

        System.out.print("Digite o valor do saque: ");
        double valorSaque = scanner.nextDouble();
        scanner.nextLine();

        if (!cliente.getConta().sacar(valorSaque)) {
            System.out.println("Não foi possível realizar o saque.");
            return;
        }

        System.out.println("Saque realizado com sucesso.");
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

    public static void consultarCliente(Cliente cliente) {
        if (!verificarCliente(cliente)) {
            contaNaoCriada();
            return;
        }

        System.out.println(cliente);
    }
}