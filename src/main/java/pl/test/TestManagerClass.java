package pl.test;

public class TestManagerClass {
	private static TestManagerClass testManagerClass=new TestManagerClass();
	
	public TestManagerClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static TestManagerClass getInstance(){
		return testManagerClass;
	}
	
	public static synchronized void cyckleAll (int i,int threadNumber){
		cyckleWorkA(i, threadNumber);
		cyckleWorkB(i, threadNumber);
		cyckleWorkC(i, threadNumber);
	}
	
	public static synchronized void cyckleWorkA(int i, int threadNumber) {
		System.out.println("A        Wątek nr. " + threadNumber + " i = " + i);
	}

	public static synchronized void cyckleWorkB(int i, int threadNumber) {
		System.out.println("B        Wątek nr. " + threadNumber + " i = " + i);
	}
	
	public static synchronized void cyckleWorkC(int i, int threadNumber) {
		System.out.println("C        Wątek nr. " + threadNumber + " i = " + i);
	}
}
