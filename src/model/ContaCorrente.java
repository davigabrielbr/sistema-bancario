package model;

import exception.LimiteInsuficienteException;
import exception.ValorInvalidoException;

public class ContaCorrente extends Conta {
    private static final double LIMITE = 500;

    public ContaCorrente() {
        super(TipoConta.CORRENTE);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor do saque deve ser maior que zero.");
        }

        if (valor > saldo + LIMITE) {
            throw new LimiteInsuficienteException("Saldo e limite insuficientes para realizar o saque.");
        }

        saldo -= valor;
    }
}