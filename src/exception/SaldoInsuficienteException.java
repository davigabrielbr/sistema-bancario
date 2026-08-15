package exception;

public class SaldoInsuficienteException extends IllegalArgumentException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}