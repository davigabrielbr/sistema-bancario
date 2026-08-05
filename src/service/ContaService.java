package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

import static main.Main.*;

public class ContaService {
    private final ClienteService clienteService = new ClienteService();

    public void depositar(ArrayList<Cliente> clientes, Scanner scanner) {
        Cliente cliente = clienteService.buscarCliente(clientes, scanner);

        double valorDeposito = lerValor(scanner, "Digite o valor do depósito: ");

        cliente.getConta().depositar(valorDeposito);

        System.out.println("Depósito realizado com sucesso.");
    }

    public void sacar(ArrayList<Cliente> clientes, Scanner scanner) {
        Cliente cliente = clienteService.buscarCliente(clientes, scanner);

        double valorSaque = lerValor(scanner, "Digite o valor do saque: ");

        cliente.getConta().sacar(valorSaque);

        System.out.println("Saque realizado com sucesso.");
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
        System.out.println("Transferência realizada com sucesso.");
    }
}