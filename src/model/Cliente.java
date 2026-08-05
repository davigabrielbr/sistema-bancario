package model;

public class Cliente {
    private final String nome;
    private final String cpf;
    private final Conta conta;

    public Cliente(String nome, String cpf, TipoConta tipoConta) {
        this.nome = nome;
        this.cpf = cpf;

        if (tipoConta == TipoConta.CORRENTE) {
            this.conta = new ContaCorrente();
        } else {
            this.conta = new ContaPoupanca();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return String.format("""
            ==========================
                 DADOS DO CLIENTE
            ==========================
            Nome            : %s
            CPF             : %s
            Número da conta : %d
            Tipo da conta   : %s
            Saldo           : R$ %.2f
            ==========================
            """,
                nome,
                cpf,
                conta.getNumeroConta(),
                conta.getTipoConta(),
                conta.getSaldo());
    }
}