package org.hebut.scse.basic.oop.multistatus;

/**
 * Created by jxy on 2016/8/26.
 */
public class Child extends Parent{
    @Override
    public void pfun2() {
        System.out.println("c override pfun2()");
    }
    public void cfun1(){
        System.out.println("c fun1");
    }
}
