package org.hebut.scse.design.create.singleton.lazy.dcl;

public class Singleton {
  private static volatile Singleton instance;  
  private Singleton() {
    // init factory using the database connection passed in
  }  
  public static Singleton getInstance(){  
    if (instance == null) {  
      synchronized (Singleton.class) {  
        if (instance == null)  
          instance = new Singleton();
      }  
    }  
    return instance;    
  }  
} 