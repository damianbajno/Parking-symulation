package pl.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@
public class TransactionSteps {

    @Pointcut("execution(* print*(..)")
    public void print1(){
	System.out.println("Transaction Step");
    }
    
}
