package pl.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class TestThreadDeadLocks {

	private static ThreadDeadLock threadDeadLock = new ThreadDeadLock();
	private static final String THREAD_NAME_NR_1 = "Damian Thread nr. 1";
	private static final String THREAD_NAME_NR_2 = "Damian Thread nr. 2";

	public static void main(String[] args) {
		createMXBean();
		Thread thread = new Thread(threadDeadLock);
		thread.setName(THREAD_NAME_NR_1);
		thread.start();
		Thread thread1 = new Thread(threadDeadLock);
		thread1.setName(THREAD_NAME_NR_2);
		thread1.start();
		createMXBean();
		sleep();
		createMXBean();
	}

	/**
	 * 
	 */
	private static void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createMXBean() {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		long[] allThreadIds = threadMXBean.getAllThreadIds();
		ThreadInfo[] threadsInfo = threadMXBean.getThreadInfo(allThreadIds);

		System.out.println("---- ThreadInfo START PRINTING ----");

		for (ThreadInfo threadInfo : threadsInfo) {

			if (threadInfo.getThreadName().contains(THREAD_NAME_NR_1)
					|| threadInfo.getThreadName().contains(THREAD_NAME_NR_1)) {

				System.out.println("Thread Id " + threadInfo.getThreadId()
						+ " || name " + threadInfo.getThreadName());

				System.out.println("Blocked time = "
						+ threadInfo.getBlockedTime());
			}
		}
		System.out.println("---- ThreadInfo STOP PRINTING ----");
	}

}
