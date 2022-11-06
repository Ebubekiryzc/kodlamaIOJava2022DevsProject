package kodlama.io.devs.business.businessaspects.validation;

import kodlama.io.devs.business.requests.programminglanguage.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programminglanguage.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.exception.classes.programminglanguage.ProgrammingLanguageValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class ProgrammingLanguageValidator {

    @Before("kodlama.io.devs.business.businessaspects.pointcutdeclarations.ProgrammingLanguagePointcutDeclarations.getMethodsToValidate()")
    public void validateGivenObject(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(
                arg -> {
                    if (arg instanceof CreateProgrammingLanguageRequest) {
                        CreateProgrammingLanguageRequest param = ((CreateProgrammingLanguageRequest) arg);
                        if (param.getName().isBlank()) {
                            throw new ProgrammingLanguageValidationException("Programming language name can't be null or blank value.");
                        }
                    } else if (arg instanceof UpdateProgrammingLanguageRequest) {
                        UpdateProgrammingLanguageRequest param = ((UpdateProgrammingLanguageRequest) arg);
                        if (param.getName().isBlank()) {
                            throw new ProgrammingLanguageValidationException("Programming language name can't be null or blank value.");
                        }
                    }
                }
        );
    }

}
