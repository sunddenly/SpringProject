package org.hebut.scse.basic.oop.extend;

/**
 * Created by jxy on 2016/8/29.
 */
public class instance {
    public static void main(String[] args) {
        String s="";
        int[] array=new int[5];
        Child child = new Child();
        Father father = new Father();
        if(s instanceof String)
            System.out.println(true);//true
        if(s instanceof Object)
            System.out.println(true);//true
        if(array instanceof int[])
            System.out.println(true);//true
        if(array instanceof Object)
            System.out.println(true);//true
        if(child instanceof Child)
            System.out.println(true);//true
        if(child instanceof Father)
            System.out.println(true);//true
        if(father instanceof Father)//true
            System.out.println(true);//true
        if(!(father instanceof Child))//true
            System.out.println(false);//false
    }
}
