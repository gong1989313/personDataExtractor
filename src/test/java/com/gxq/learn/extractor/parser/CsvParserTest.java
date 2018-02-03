package com.gxq.learn.extractor.parser;

import org.junit.Test;

public class CsvParserTest {

	@Test
	public final void testParseCSVFile() {
		CsvParser csvParser = new CsvParser();
		csvParser.parseCSVFile(34, "D:\\temp\\1800w-2000w.csv");
	}
}
