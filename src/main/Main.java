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

        String nomeCliente = lerNome(scanner);
        String cpfCliente = lerCpf(scanner);
        TipoConta tipoConta = escolherTipoConta(scanner);

        cliente = new Cliente(nomeCliente, cpfCliente, tipoConta);

        System.out.println("Conta criada com sucesso.");
        return cliente;
    }

    public static void depositar(Cliente cliente, Scanner scanner) {
        if (!verificarCliente(cliente)) {
            contaNaoCriada();
            return;
        }

        double valorDeposito = lerValor(scanner, "Digite o valor do depósito: ");

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

        double valorSaque = lerValor(scanner, "Digite o valor do saque: ");

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

    public static TipoConta escolherTipoConta(Scanner scanner) {
        int opcao;

        do {
            System.out.println("Digite o tipo da conta:");
            System.out.println("1 - Corrente");
            System.out.println("2 - Poupança");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    return TipoConta.CORRENTE;
                case 2:
                    return TipoConta.POUPANCA;
                default:
                    System.out.println("Tipo de conta inválido.\n");
            }
        } while (true);
    }

    public static String lerNome(Scanner scanner) {
        String nomeCliente;

        do {
            System.out.print("Digite o seu nome: ");
            nomeCliente = scanner.nextLine().trim();

            if (nomeCliente.isEmpty()) {
                System.out.println("Nome não informado.");
            }
        } while (nomeCliente.isEmpty());

        return nomeCliente;
    }

    public static String lerCpf(Scanner scanner) {
        String cpfCliente;

        do {
            System.out.print("Digite o seu cpf: ");
            cpfCliente = scanner.nextLine().trim();

            if (cpfCliente.isEmpty()) {
                System.out.println("CPF não informado.");
            }
        } while (cpfCliente.isEmpty());

        return cpfCliente;
    }

    public static double lerValor(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}