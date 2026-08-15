package exception;

public class LimiteInsuficienteException extends IllegalArgumentException {
    public LimiteInsuficienteException(String message) {
        super(message);
    }
}
