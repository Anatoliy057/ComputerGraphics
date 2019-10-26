package stud.task.ttf.types;

import java.util.StringJoiner;

public class UnsignedException extends Exception {
    private Number number;

    public UnsignedException(Number number) {
        this.number = number;
    }

    public UnsignedException(String message, Number number) {
        super(message);
        this.number = number;
    }

    public UnsignedException(String message, Throwable cause, Number number) {
        super(message, cause);
        this.number = number;
    }

    public UnsignedException(Throwable cause, Number number) {
        super(cause);
        this.number = number;
    }

    public UnsignedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Number number) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Negative number received: %s\nMessage %s", number, getMessage());
    }
}
