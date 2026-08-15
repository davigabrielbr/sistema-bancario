package service;

import model.Cliente;
import model.TipoOperacao;

import java.util.ArrayList;
import java.util.Scanner;

import static util.InputUtil.*;

public class ContaService {
    private final ClienteService clienteService = new ClienteService();

    public void depositar(ArrayList<Cliente> clientes, Scanner scanner) {
        Cliente cliente = clienteService.buscarCliente(clientes, scanner);

        double valorDeposito = lerValor(scanner, "Digite o valor do depósito: ");

        cliente.getConta().depositar(valorDeposito);

        System.out.println(TipoOperacao.DEPOSITO.getMensagem());
    }

    public void sacar(ArrayList<Cliente> clientes, Scanner scanner) {
        Cliente cliente = clienteService.buscarCliente(clientes, scanner);

        double valorSaque = lerValor(scanner, "Digite o valor do saque: ");

        cliente.getConta().sacar(valorSaque);

        System.out.println(TipoOperacao.SAQUE.getMensagem());
    }

    public void transferir(ArrayList<Cliente> clientes, Scanner scanner) {
        Cliente origem = clienteService.buscarCliente(clientes, scanner, "origem");
        Cliente destino = clienteService.buscarCliente(clientes, scanner, "destino");

        if (origem == destino) {
            System.out.println("Não é possível transferir para a mesma conta.");
            return;
        }

        double valor = lerValor(scanner, "Digite o valor: ");

        origem.getConta().sacar(valor);
        destino.getConta().depositar(valor);
        System.out.println(TipoOperacao.TRANSFERENCIA.getMensagem());
    }
}