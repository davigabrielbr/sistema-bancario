package model;

public class ContaPoupanca extends Conta {
    public ContaPoupanca() {
        super(TipoConta.POUPANCA);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }

        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        saldo -= valor;
    }
}