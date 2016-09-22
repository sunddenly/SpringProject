package org.hebut.scse.design.create.singleton.lazy.statics;

/**
 * 初始化一个类，包括执行这个类的静态初始化（static代码段）和初始化在这个类中声明的静态字段。
 根据java语言规范，在首次发生下列任意一种情况时，一个类或接口类型T将被立即初始化：
 - T是一个类，而且一个T类型的实例被创建；
 - T是一个类，且T中声明的一个静态方法被调用；
 - T中声明的一个静态字段被赋值；
 - T中声明的一个静态字段被使用，而且这个字段不是一个常量字段；
 */
public class Singleton {
    private static class InstanceHolder {  
        public static final Singleton instance = new Singleton();  
    }  
      
  
    public static Singleton getInstance() {  
        return InstanceHolder.instance;  
    }  
  
    private Singleton() {  
    }  
} 