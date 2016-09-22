package org.hebut.scse.basic.oop.multistatus;

/**
 * Created by jxy on 2016/8/26.
 */
public class Test {
    public static void main(String[] args) {
        //多态调用
        Parent p = new Child();
        p.pfun1();//没有重写
        p.pfun2();//重写
//        p.cfun();
        //子类调用
        Child c = new Child();
        c.pfun1();
        c.pfun2();
        c.cfun1();
    }
}
