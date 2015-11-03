package pl.tools;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class ThreadTest implements Runnable {
	ThreadMXBean threadMXBean;

	public ThreadTest() {
		threadMXBean = ManagementFactory.getThreadMXBean();
	}

	public void run() {
		while (true) {
			printThreadInfo();
			sleep();
		}
			

	}

	private void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void printThreadInfo() {
		long[] allThreadIds = threadMXBean.getAllThreadIds();
		ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(allThreadIds);
		System.out.println("--- Start ThreadsINFO -----");
		for (ThreadInfo threadInfo2 : threadInfo) {

			System.out.println("Thread Id = " + threadInfo2.getThreadId() + "         name =     " + threadInfo2.getThreadName());
			System.out.println(
					"Thread state = " + threadInfo2.getThreadState() + " lock Name = " + threadInfo2.getLockName());
			System.out.println("   -----------    ");
		}
		System.out.println("--- END ThreadsINFO -----");
	}

}
