package org.hebut.scse.design.create.singleton.lazy.syn;

public class Singleton {
	private static Singleton instance;
	private Singleton(){
	}
	public static synchronized Singleton getInstance(){
		if(instance==null)
			instance = new Singleton();
		return instance;
	}
}
