package service;

import exception.ClienteNaoEncontradoException;
import exception.CpfJaCadastradoException;
import model.Cliente;
import model.TipoConta;
import model.TipoOperacao;

import java.util.ArrayList;
import java.util.Scanner;

import static util.InputUtil.*;

public class ClienteService {
    public void criarConta(ArrayList<Cliente> clientes, Scanner scanner) {
        String nomeCliente = lerNome(scanner);
        String cpfCliente = lerCpf(scanner);

        if (existeCpf(clientes, cpfCliente)) {
            throw new CpfJaCadastradoException("CPF já cadastrado.");
        }

        TipoConta tipoConta = escolherTipoConta(scanner);

        Cliente cliente = new Cliente(nomeCliente, cpfCliente, tipoConta);
        clientes.add(cliente);

        System.out.println(TipoOperacao.CONTA_CRIADA.getMensagem());
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
        String cpf = lerCpf(scanner);
        return buscarCliente(clientes, cpf);
    }

    public Cliente buscarCliente(ArrayList<Cliente> clientes, Scanner scanner, String mensagem) {
        String cpf = lerCpf(
                scanner,
                "Digite o CPF da conta de " + mensagem + ": "
        );

        return buscarCliente(clientes, cpf);
    }

    public Cliente buscarCliente(ArrayList<Cliente> clientes, String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        throw new ClienteNaoEncontradoException("Cliente não encontrado.");
    }

    public void listarClientes(ArrayList<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}