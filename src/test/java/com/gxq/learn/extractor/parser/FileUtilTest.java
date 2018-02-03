package com.gxq.learn.extractor.parser;

import java.io.IOException;
import org.junit.Test;

import com.gxq.learn.extractor.util.FileUtil;

public class FileUtilTest {

	@Test
	public final void testRename() throws IOException {
		FileUtil.rename("D:\\temp\\test.txt");
	}

}
