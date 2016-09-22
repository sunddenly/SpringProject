package org.hebut.scse.thread.syn;

/**
 * Created by jxy on 2016/8/23.
 */
public class Client {
    public static void main(String[] args) {
        Store store = new Store(10);
        Thread p1 = new Thread(new Producer(store));
        Thread p2 = new Thread(new Producer(store));
        Thread c1 = new Thread(new Consumer(store));
        Thread c2 = new Thread(new Consumer(store));
        Thread c3 = new Thread(new Consumer(store));
        p1.start();
        p2.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
