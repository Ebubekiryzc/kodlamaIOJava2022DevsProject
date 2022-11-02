package kodlama.io.devs.business.businessaspects.pointcutdeclarations;

import org.aspectj.lang.annotation.Pointcut;

public class ProgrammingLanguagePointcutDeclarations {
    @Pointcut("execution(* kodlama.io.devs.business.concretes.*.*(kodlama.io.devs.entities.concretes.ProgrammingLanguage, ..))")
    public void getServiceMethodsWithPojoBodyOnArgs() {
    }

    @Pointcut("target(kodlama.io.devs.business.abstracts.ProgrammingLanguageService)")
    public void getProgrammingLanguageServiceImplementations() {
    }

    @Pointcut("getServiceMethodsWithPojoBodyOnArgs() && getProgrammingLanguageServiceImplementations()")
    public void getProgrammingLanguageServiceMethodsWithPojoBodyOnArgs() {
    }
}
