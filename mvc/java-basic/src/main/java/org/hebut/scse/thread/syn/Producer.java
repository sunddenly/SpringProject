package org.hebut.scse.thread.syn;

/**
 * Created by jxy on 2016/8/23.
 */
public class Producer implements Runnable{
    private Store s;
    public Producer(Store s) {
        this.s = s;
    }
    public void run() {
        while (true){
            s.add();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
