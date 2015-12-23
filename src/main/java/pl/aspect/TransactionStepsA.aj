package pl.aspect;


public aspect TransactionStepsA {

    pointcut pointcut1() : 
	call(* pl.threadmanager.ParkingSpaceTransaction*.* (..)) || 
	call(* pl.dao.ParkingSpaceDAO*.* (..)) ||
	call(* pl.panels.ParkingSpaceButton*.* (..)) ||
	call(* pl.panel.ParkingSpacesTextBoard*.* (..));

    before() : pointcut1() {
	System.out.println(Thread.currentThread().getName()+" "+thisJoinPoint.toShortString());
    }
    
//    after() returning() : pointcut1() {
//	System.out.println("A "+Thread.currentThread().getName()+" "+thisJoinPoint.toShortString());
//    }
}
