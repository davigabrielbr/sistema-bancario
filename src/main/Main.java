package main;

import model.Cliente;
import model.TipoConta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();

        int numeroDigitado;

        do {
            numeroDigitado = menu(scanner);

            switch (numeroDigitado) {
                case 1 -> criarConta(clientes, scanner);
                case 2 -> depositar(clientes, scanner);
                case 3 -> sacar(clientes, scanner);
                case 4 -> consultarCliente(clientes, scanner);
                case 5 -> listarClientes(clientes);
                case 6 -> transferir(clientes, scanner);
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

    public static void criarConta(ArrayList<Cliente> clientes, Scanner scanner) {
        String nomeCliente = lerNome(scanner);
        String cpfCliente = lerCpf(scanner);

        if (cpfJaExiste(clientes, cpfCliente)) {
            System.out.println("Já existe um cliente com esse CPF.");
            return;
        }

        TipoConta tipoConta = escolherTipoConta(scanner);

        Cliente cliente = new Cliente(nomeCliente, cpfCliente, tipoConta);
        clientes.add(cliente);

        System.out.println("Conta criada com sucesso.");
    }

    public static void depositar(ArrayList<Cliente> clientes, Scanner scanner) {
        Cliente cliente = buscarCliente(clientes, scanner);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        double valorDeposito = lerValor(scanner, "Digite o valor do depósito: ");

        if (!cliente.getConta().depositar(valorDeposito)) {
            System.out.println("Digite um valor maior que zero.");
            return;
        }

        System.out.println("Depósito realizado com sucesso.");
    }

    public static void sacar(ArrayList<Cliente> clientes, Scanner scanner) {
        Cliente cliente = buscarCliente(clientes, scanner);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
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

    public static void consultarCliente(ArrayList<Cliente> clientes, Scanner scanner) {
        Cliente cliente = buscarCliente(clientes, scanner);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
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

    public static Cliente buscarCliente(ArrayList<Cliente> clientes, Scanner scanner) {
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine().trim();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        return null;
    }

    public static Cliente buscarCliente(ArrayList<Cliente> clientes, Scanner scanner, String mensagem) {
        System.out.print("Digite o CPF da " + mensagem + ": ");
        String cpf = scanner.nextLine().trim();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        return null;
    }

    public static boolean cpfJaExiste(ArrayList<Cliente> clientes, String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }

        return false;
    }

    public static void listarClientes(ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public static void transferir(ArrayList<Cliente> clientes, Scanner scanner) {
        Cliente origem = buscarCliente(clientes, scanner, "origem");

        if (origem == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Cliente destino = buscarCliente(clientes, scanner, "destino");

        if (destino == null) {
            System.out.println("Cliente não encontrado");
            return;
        }


        if (origem == destino) {
            System.out.println("Não é possível transferir para a mesma conta.");
            return;
        }

        double valor = lerValor(scanner, "Digite o valor: ");

        if (!origem.getConta().sacar(valor)) {
            System.out.println("Não foi possível realizar a transferência");
            return;
        }

        destino.getConta().depositar(valor);
        System.out.println("Transferência realizada com sucesso.");
    }
}