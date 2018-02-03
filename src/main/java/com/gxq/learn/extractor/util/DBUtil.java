package com.gxq.learn.extractor.util;

public class DBUtil {
	public static void show(int index, String[] parms) {
		System.out.print("index="+index);
		for(String str : parms) {
			System.out.print(" "+str+", ");
		}
		System.out.println();
	}
}
