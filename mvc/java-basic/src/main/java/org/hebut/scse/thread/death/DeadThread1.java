package org.hebut.scse.thread.death;
public class DeadThread1 implements Runnable {
	@Override
	public void run() {
		fun();
	}
	//首先,占用o1资源,然后休眠1秒,让给其他线程执行
	//然后,请求o2资源
	public void fun() {
		synchronized (Resource.o1) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			synchronized (Resource.o2) {
				System.out.println("DeadThread2里的fun()被执行");
			}
		}
	}

}
