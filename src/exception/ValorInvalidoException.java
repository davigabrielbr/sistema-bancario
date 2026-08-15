package exception;

public class ValorInvalidoException extends IllegalArgumentException {
    public ValorInvalidoException(String message) {
        super(message);
    }
}