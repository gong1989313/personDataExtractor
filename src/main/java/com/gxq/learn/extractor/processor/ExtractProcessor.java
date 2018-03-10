package com.gxq.learn.extractor.processor;

import java.io.File;

import com.gxq.learn.extractor.constant.ParserConstant;
import com.gxq.learn.extractor.parser.CsvParser;

public class ExtractProcessor {
	
	public void process(String path) {
		File dir = new File(path);
		if(dir.isDirectory()) {
			File[] subFiles = dir.listFiles();
			int size = subFiles.length;
			if(size > 0) {
				for(File sub : subFiles) {
					//ThreadPoolUtil.submitTask(new Processor(sub.getAbsolutePath()));
					Thread t = new Thread(new Processor(sub.getAbsolutePath()));
					t.start();
				}
			}
		}
	}
}

class Processor implements Runnable {
	private CsvParser parser = null;
	private String filePath = null;
	
	public Processor( String filePath) {
		this.filePath = filePath;
	}
	@Override
	public void run() {
		parser = new CsvParser();
		System.out.println("Thread "+Thread.currentThread().getName()+" start load file:"+filePath);
		parser.parseCSVFile(ParserConstant.columnNum, filePath);
	}
}
