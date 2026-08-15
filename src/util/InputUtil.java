package util;

import model.TipoConta;

import java.util.Scanner;

public class InputUtil {
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
            } else if (!nomeCliente.matches("[a-zA-ZÀ-ÿ ]+")) {
                System.out.println("O nome deve conter apenas letras.");
            } else if (nomeCliente.length() < 3) {
                System.out.println("O nome deve conter pelo menos 3 letras.");
            }
        } while (!nomeCliente.matches("[a-zA-ZÀ-ÿ ]+")
                || nomeCliente.length() < 3);
        return nomeCliente;
    }

    public static String lerCpf(Scanner scanner) {
        String cpfCliente;

        do {
            System.out.print("Digite o seu cpf: ");
            cpfCliente = scanner.nextLine().trim();

            if (cpfCliente.isEmpty()) {
                System.out.println("CPF não informado.");
            } else if (!cpfCliente.matches("\\d{11}")) {
                System.out.println("O CPF deve conter exatamente 11 números.");
            }
        } while (cpfCliente.length() != 11
                || !cpfCliente.matches("\\d{11}"));
        return cpfCliente;
    }

    public static double lerValor(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}