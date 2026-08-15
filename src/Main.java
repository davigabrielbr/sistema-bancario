import model.Cliente;
import service.ClienteService;
import service.ContaService;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

            try {
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
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (numeroDigitado != 7);
        scanner.close();
    }

    public static int menu (Scanner scanner){
        System.out.println();
        System.out.println("============================");
        System.out.println("      SISTEMA BANCÁRIO");
        System.out.println("============================");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Consultar cliente");
        System.out.println("5 - Listar clientes");
        System.out.println("6 - Transferir");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");

        try {
            int numeroDigitado = scanner.nextInt();
            scanner.nextLine();
            return numeroDigitado;
        } catch (InputMismatchException e) {
            System.out.println("Digite apenas números.");
            scanner.nextLine();
            return 0;
        }
    }

    public static void sair () {
        System.out.println("Saindo...");
    }

    public static void opcaoInvalida () {
        System.out.println("Opção inválida.");
    }
}