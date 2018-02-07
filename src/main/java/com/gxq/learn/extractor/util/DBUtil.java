package com.gxq.learn.extractor.util;

public class DBUtil {
	public static void show(int index, String[] parms) {
		System.out.println("Thread: "+Thread.currentThread().getName()+",   index="+index);
	}
}
