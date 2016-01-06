package pl.aspect;

import pl.panel.ThreadTracePanel;

public aspect TransactionStepsPrinter {
    ThreadTracePanel threadTracePanel = ThreadTracePanel.getInstance();

    pointcut flow() :
	    (call(* pl.threadmanager.ParkingSpaceTransaction.*(..)) ||
	    call(* pl.button.ParkingSpaceButton.*(..)) ||
	    call(* pl.button.ParkingSpaceButtonList.*(..)) ||
	    call(* pl.dao.ParkingSpaceDAO.*(..)) ||
	    call(* pl.panel.ParkingSpacesTextBoard.*(..)) ||
	    call(* pl.button.ParkingSpaceButton.*(..)))
	    && !within(TransactionStepsPrinter) && !cflow(call(public void *.append(..))) && !cflow(call(public void *.refreshThreadStatus(..)));

    before() : flow() {
	threadTracePanel.append(thisJoinPoint.toShortString());
	threadTracePanel.refreshThreadStatus();
    }
    
    after() returning: flow() {
	threadTracePanel.append(thisJoinPoint.toShortString());
	threadTracePanel.refreshThreadStatus();
    }

}
