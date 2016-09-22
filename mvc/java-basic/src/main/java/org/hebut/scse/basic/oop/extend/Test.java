package org.hebut.scse.basic.oop.extend;

/**
 * Created by jxy on 2016/8/29.
 */
public class Test {
    public static void main(String[] args) {
        Child c = new Child();

        Child c1 = new Child();
        System.out.println(c.getClass()==c1.getClass());//true

        Father f1 = new Child();
        System.out.println(c.getClass()==f1.getClass());//true

        Father f2 = new Father();
        System.out.println(c.getClass()==f2.getClass());//fasle
    }
}
