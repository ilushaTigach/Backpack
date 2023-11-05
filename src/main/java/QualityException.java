public class QualityException extends Exception{
    public QualityException() {
    }

    public QualityException(String message) {
        super(message);
    }

    public QualityException(String message, Throwable cause) {
        super(message, cause);
    }

    public QualityException(Throwable cause) {
        super(cause);
    }

    public QualityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
