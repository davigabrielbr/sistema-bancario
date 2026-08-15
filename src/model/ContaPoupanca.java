package model;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;

public class ContaPoupanca extends Conta {
    public ContaPoupanca() {
        super(TipoConta.POUPANCA);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor do saque deve ser maior que zero.");
        }

        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente.");
        }

        saldo -= valor;
    }
}