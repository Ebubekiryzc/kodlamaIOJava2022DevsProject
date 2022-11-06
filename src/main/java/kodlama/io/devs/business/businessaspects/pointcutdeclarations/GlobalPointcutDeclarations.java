package kodlama.io.devs.business.businessaspects.pointcutdeclarations;

import org.aspectj.lang.annotation.Pointcut;

public class GlobalPointcutDeclarations {
    @Pointcut("execution(* kodlama.io.devs.business.concretes.*.*(..))")
    public void getServiceMethods() {
    }

}
