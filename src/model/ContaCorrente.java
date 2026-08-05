package model;

public class ContaCorrente extends Conta {
    private static final double LIMITE = 500;

    public ContaCorrente() {
        super(TipoConta.CORRENTE);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }

        if (valor > saldo + LIMITE) {
            throw new IllegalArgumentException("Limite insuficiente.");
        }

        saldo -= valor;
    }
}