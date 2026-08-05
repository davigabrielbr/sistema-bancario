package model;

public abstract class Conta {
    protected double saldo;
    private static int proximoNumero = 1000;
    private final int numeroConta;
    private final TipoConta tipoConta;

    public Conta(TipoConta tipoConta) {
        this.numeroConta = proximoNumero++;
        this.tipoConta = tipoConta;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Digite um valor maior que zero.");
        }

        saldo += valor;
    }

    public abstract void sacar(double valor);

    public double getSaldo() {
        return saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }
}