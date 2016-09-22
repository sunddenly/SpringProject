package org.hebut.scse.thread.death;
public class DeadThread2 implements Runnable {
	@Override
	public void run() {
		fun();
	}

	//首先,占用o2资源,然后休眠1秒,让给其他线程执行
	//然后,请求o1资源
	public void fun() {
		synchronized (Resource.o2) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			synchronized (Resource.o1) {
				System.out.println("DeadThread1里的fun()被执行");
			}
		}
	}

}
