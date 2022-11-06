package kodlama.io.devs.business.businessaspects.pointcutdeclarations;

import org.aspectj.lang.annotation.Pointcut;

public class ProgrammingTechnologyPointcutDeclarations {

    @Pointcut("target(kodlama.io.devs.business.abstracts.ProgrammingTechnologyService)")
    public void getProgrammingTechnologyServiceImplementations() {
    }

    @Pointcut("kodlama.io.devs.business.businessaspects.pointcutdeclarations.GlobalPointcutDeclarations.getServiceMethods() && getProgrammingTechnologyServiceImplementations()")
    public void getProgrammingTechnologyServiceMethods() {
    }

    @Pointcut("@annotation(kodlama.io.devs.business.customannotations.ValidateRequest)")
    public void getAnnotatedMethodsWithValidateRequestAnnotation() {
    }

    @Pointcut("getProgrammingTechnologyServiceMethods() && getAnnotatedMethodsWithValidateRequestAnnotation()")
    public void getMethodsToValidate() {
    }
}
