package service;

import model.Cliente;
import model.TipoConta;

import java.util.ArrayList;
import java.util.Scanner;

import static main.Main.*;

public class ClienteService {
    public void criarConta(ArrayList<Cliente> clientes, Scanner scanner) {
        String nomeCliente = lerNome(scanner);
        String cpfCliente = lerCpf(scanner);

        if (existeCpf(clientes, cpfCliente)) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        TipoConta tipoConta = escolherTipoConta(scanner);

        Cliente cliente = new Cliente(nomeCliente, cpfCliente, tipoConta);
        clientes.add(cliente);

        System.out.println("Conta criada com sucesso.");
    }

    public static boolean existeCpf(ArrayList<Cliente> clientes, String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }

        return false;
    }

    public void consultarCliente(ArrayList<Cliente> clientes, Scanner scanner) {
        Cliente cliente = buscarCliente(clientes, scanner);

        System.out.println(cliente);
    }

    public Cliente buscarCliente(ArrayList<Cliente> clientes, Scanner scanner) {
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine().trim();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        throw new IllegalArgumentException("Cliente não encontrado.");
    }

    public Cliente buscarCliente(ArrayList<Cliente> clientes, Scanner scanner, String mensagem) {
        System.out.print("Digite o CPF da conta de " + mensagem + ": ");
        String cpf = scanner.nextLine().trim();

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        throw new IllegalArgumentException("Cliente não encontrado.");
    }

    public void listarClientes(ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}