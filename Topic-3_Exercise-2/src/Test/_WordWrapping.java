package Test;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Classes.WordWrapping;

public class _WordWrapping {

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending");
	}
	
	@Test
	public void wordWrapping1Test(){
		WordWrapping ww = new WordWrapping();
		String testString= "0123456789ABCDEF0123456789ABCD";
		int rowLength= 60;
		ArrayList<String> list = new ArrayList<String>();
		list = ww.wordWrap(testString,rowLength);
		ArrayList<String> expectedList =new ArrayList<String>();
		expectedList.add("\"0123456789ABCDEF0123456789ABCD\" ");
		
		Assert.assertEquals(expectedList, list);
	}
	
	@Test
	public void wordWrapping2Test(){
		WordWrapping ww = new WordWrapping();
		String testString= "Hello world!";
		int rowLength= 7;
		ArrayList<String> list = new ArrayList<String>();
		list = ww.wordWrap(testString,rowLength);
		ArrayList<String> expectedList =new ArrayList<String>();
		expectedList.add("\"Hello\" ");
		expectedList.add("\"world!\" ");
		Assert.assertEquals(expectedList, list);
	}

	@Test
	public void wordWrapping3test() {
		
		WordWrapping ww = new WordWrapping();		
		ArrayList<String> list = new ArrayList<String>();
		String testString = "a b c d e f";
		int rowLength=3;
		list = ww.wordWrap(testString,rowLength);
		ArrayList<String> expectedList =new ArrayList<String>();
		expectedList.add("\"a b\" ");
		expectedList.add("\"c d\" ");
		expectedList.add("\"e f\" ");
		Assert.assertEquals(expectedList, list);
	}
	@Test
	
	public void wordWrapping4test() {
		
		WordWrapping ww = new WordWrapping();		
		ArrayList<String> list = new ArrayList<String>();
		String testString = "Excelent";
		int rowLength=5;
		list = ww.wordWrap(testString,rowLength);
		ArrayList<String> expectedList =new ArrayList<String>();
		expectedList.add("\"Excel\" ");
		expectedList.add("\"ent\" ");
		Assert.assertEquals(expectedList, list);
	}
}
