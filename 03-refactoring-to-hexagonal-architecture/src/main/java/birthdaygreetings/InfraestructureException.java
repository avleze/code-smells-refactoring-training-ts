package birthdaygreetings;

import java.io.IOException;
import java.text.ParseException;

public class InfraestructureException extends RuntimeException {

    public InfraestructureException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public static InfraestructureException becauseFileCannotBeFound(final Exception exception) {
        return new InfraestructureException("Infraestructure exception because file cannot be found", exception);
    }

    public static InfraestructureException becauseFileCannotBeParsed(final  Exception exception) {
        return new InfraestructureException("Infraestructure exception because file cannot be parsed", exception);
    }
}
