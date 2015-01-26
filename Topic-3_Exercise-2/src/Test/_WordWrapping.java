package Test;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
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
	public void wordWrappingtest() {
		
		WordWrapping ww = new WordWrapping();
		
		ArrayList<String> list = new ArrayList<String>();
		
		String testString = "a b c d e f";
		
		int rowLength=3;
		
		list = ww.wordWrap(testString,rowLength);
				
		for (int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}
