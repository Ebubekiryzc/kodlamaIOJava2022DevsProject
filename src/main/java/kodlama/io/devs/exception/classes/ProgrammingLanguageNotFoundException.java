package kodlama.io.devs.exception.classes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProgrammingLanguageNotFoundException extends RuntimeException{
    public ProgrammingLanguageNotFoundException() {
        super();
    }

    public ProgrammingLanguageNotFoundException(String message) {
        super(message);
    }
}
