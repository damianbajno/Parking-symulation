package pl.aspect;

import pl.panel.ThreadTracePanel;


public aspect TransactionStepsA {
    ThreadTracePanel threadTracePanel=ThreadTracePanel.getInstance();

    pointcut pointcut1() : 
	call(* pl.threadmanager.ParkingSpaceTransaction*.* (..)) ||
	call(* pl.dao.ParkingSpaceDAO*.* (..)) ||
	call(* pl.panels.ParkingSpaceButton*.* (..)) ||
	call(* pl.threadmanager.ParkingSpaceTransaction.*.* (..)) ||
	call(* pl.panel.ParkingSpaceButton.*.* ()) ||
	call(* pl.panel.ParkingSpacesTextBoard*.* (..)) ||
	call(* pl.panel.ParkingSpaceButtonList.* (..));

    before() : pointcut1() {
	threadTracePanel.append(thisJoinPoint.toShortString());
	threadTracePanel.refreshThreadStatus();
	System.out.println(thisJoinPoint.toShortString());
    }
    
//    after() returning() : pointcut1() {
//	System.out.println("A "+Thread.currentThread().getName()+" "+thisJoinPoint.toShortString());
//    }
}
