package pl.test;


public class ThreadDeadLock implements Runnable{

	public ThreadDeadLock() {
		// TODO Auto-generated constructor stub
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(Thread.currentThread().getName()+" -- Liczba i = "+i+" -- "); 
			synchronizedContex();
		}
		System.out.println();
	}
	
	public static void synchronizedContex(){
		System.out.println("Synchronized Context");
	}

}
