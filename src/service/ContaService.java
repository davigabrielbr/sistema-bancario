package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

import static service.ClienteService.buscarCliente;

import static main.Main.*;

public class ContaService {
    public void depositar(ArrayList<Cliente> clientes, Scanner scanner) {
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

    public void sacar(ArrayList<Cliente> clientes, Scanner scanner) {
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

    public void transferir(ArrayList<Cliente> clientes, Scanner scanner) {
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