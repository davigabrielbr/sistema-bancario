package model;

public enum TipoOperacao {
    CONTA_CRIADA("Conta criada com sucesso."),
    DEPOSITO("Depósito realizado com suceso."),
    SAQUE("Saque realizado com sucesso."),
    TRANSFERENCIA("Transferência realizada com sucesso.");

    private final String mensagem;

    TipoOperacao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}