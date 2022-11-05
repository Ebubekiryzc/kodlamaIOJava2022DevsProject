package kodlama.io.devs.business.businessaspects.validation;

import kodlama.io.devs.exception.classes.programminglanguage.ProgrammingLanguageValidationException;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ProgrammingLanguageValidator {

    @Before("kodlama.io.devs.business.businessaspects.pointcutdeclarations.ProgrammingLanguagePointcutDeclarations.getProgrammingLanguageServiceMethodsWithPojoBodyOnArgs()")
    public void validateGivenObject(JoinPoint joinPoint) {
        ProgrammingLanguage programmingLanguage = (ProgrammingLanguage) joinPoint.getArgs()[0];
        if (programmingLanguage.getName() == null || programmingLanguage.getName().isEmpty()) {
            throw new ProgrammingLanguageValidationException("Programming language name must be given!");
        }
    }

}
