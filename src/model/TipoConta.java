package model;

public enum TipoConta {
    CORRENTE("Corrente"),
    POUPANCA("Poupança");

    private final String descricao;

    TipoConta(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}