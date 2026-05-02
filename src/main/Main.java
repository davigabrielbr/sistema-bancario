package main;

import model.Conta;

public class Main {
    public static void main(String[] args) {
        Conta conta = new Conta();

        if (conta.depositar(100)) {
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para o depósito.");
        }

        if (conta.sacar(50)) {
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saque não realizado.");
        }

        System.out.println("Saldo em conta R$ " + conta.verSaldo());
    }
}