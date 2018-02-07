package com.gxq.learn.extractor.boot;

import com.gxq.learn.extractor.processor.ExtractProcessor;

public class ExtractApp {

	public static void main(String[] args) {
		ExtractProcessor ep = new ExtractProcessor();
		ep.process("D:\\temp");
	}
}
