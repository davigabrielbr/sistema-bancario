package model;

public class Cliente {
    private String nome;
    private String cpf;
    private Conta conta;

    public Cliente(String nome, String cpf, TipoConta tipoConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = new Conta(tipoConta);
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
        return "==========================\n" +
                "Cliente\n" +
                "==========================\n" +
                "Nome: " + nome + "\n" +
                "CPF: " + cpf + "\n" +
                String.format("Saldo: R$ %.2f", conta.getSaldo()) + "\n" +
                "==========================";
    }
}