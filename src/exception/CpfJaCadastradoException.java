package exception;

public class CpfJaCadastradoException extends IllegalArgumentException {
    public CpfJaCadastradoException(String message) {
        super(message);
    }
}