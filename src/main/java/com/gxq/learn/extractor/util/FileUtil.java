package com.gxq.learn.extractor.util;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtil {
	//public static final CopyOption[] REPLACE_EXISTING = {"COMPLETED"}; 
	public static void rename(String sourceName) throws IOException {
		//String 
		Path source = Paths.get(sourceName);
		
		Path newdir = Paths.get(sourceName);
		Files.move(source, newdir.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
	}
}
