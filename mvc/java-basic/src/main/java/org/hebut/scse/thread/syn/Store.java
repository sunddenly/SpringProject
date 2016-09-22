package org.hebut.scse.thread.syn;

/**
 * Created by jxy on 2016/8/23.
 */
public class Store {
    private final int MAX_SIZE;
    private int count = 0;
    public Store(int size) {
        this.MAX_SIZE = size;
    }

    public synchronized void add(){
        while(count>=MAX_SIZE){
            System.out.println("仓库已经满了！");
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName()+" put "+count);
        this.notifyAll();
    }

    public synchronized  void remove(){
        while (count<1){
            System.out.println("仓库空了！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" get "+count);
        count--;
        this.notify();
    }
}
