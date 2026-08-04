package main;

import model.Cliente;
import model.TipoConta;
import service.ClienteService;
import service.ContaService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ClienteService clienteService = new ClienteService();
        ContaService contaService = new ContaService();

        int numeroDigitado;

        do {
            numeroDigitado = menu(scanner);

            switch (numeroDigitado) {
                case 1 -> clienteService.criarConta(clientes, scanner);
                case 2 -> contaService.depositar(clientes, scanner);
                case 3 -> contaService.sacar(clientes, scanner);
                case 4 -> clienteService.consultarCliente(clientes, scanner);
                case 5 -> clienteService.listarClientes(clientes);
                case 6 -> contaService.transferir(clientes, scanner);
                case 7 -> sair();
                default -> opcaoInvalida();
            }
        } while (numeroDigitado != 7);
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
        System.out.println("5 - Listar clientes");
        System.out.println("6 - Transferir");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");
        int numeroDigitado = scanner.nextInt();

        scanner.nextLine();
        return numeroDigitado;
    }

    public static void sair() {
        System.out.println("Saindo...");
    }

    public static void opcaoInvalida() {
        System.out.println("Opção inválida.");
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