package org.hebut.scse.thread.volatiles;

import org.hebut.scse.thread.syn.Producer;
import org.hebut.scse.thread.syn.Store;

/**
 * Created by jxy on 2016/8/23.
 */
public class Test {
    public static void main(String[] args) {
        Store store = new Store(10);

        Thread p1 = new Thread(new Producer(store));
        p1.setName("p1");
        p1.start();
        while(true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("address2:"+store);
        }
//        Thread p2 = new Thread(new Producer(store));
//        p2.setName("p2");
//        Thread c1 = new Thread(new Consumer(store));
//        c1.setName("c1");
//        Thread c2 = new Thread(new Consumer(store));
//        c2.setName("c2");
//        Thread c3 = new Thread(new Consumer(store));
//        c3.setName("c3");

//        p2.start();
//        c1.start();
//        c2.start();
//        c3.start();
    }
}
