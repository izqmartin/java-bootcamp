package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.RecentFilesList;

public class _RecentFilesList {

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting");
		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Ending");
	}

	@Test
	public void testInsert(){
		RecentFilesList rfl=new RecentFilesList();
		rfl.Open("File 1");
		rfl.Open("File 2");
		rfl.Open("File 3");
		rfl.Open("File 4");
		rfl.Open("File 5");
		rfl.Show();
		rfl.Open("File 1");
		System.out.println("opened file 1");
		rfl.Show();
		rfl.Open("File 4");	
		System.out.println("opened file 4");
		rfl.Show();
		rfl.Open("File 5");
		System.out.println("opened file 5");
		rfl.Show();
		rfl.Open("File 6");
		rfl.Show();
		rfl.Open("File 7");
		rfl.Show();
		rfl.Open("File 8");
		rfl.Show();
		rfl.Open("File 9");
		rfl.Show();
		rfl.Open("File 10");
		rfl.Show();
		rfl.Open("File 11");
		rfl.Show();
		rfl.Open("File 12");
		rfl.Show();
		rfl.Open("File 13");
		rfl.Show();
		rfl.Open("File 14");
		rfl.Show();
		rfl.Open("File 15");
		rfl.Show();
		rfl.Open("File 16");
		rfl.Show();
		rfl.Open("File 17");
		rfl.Show();
		rfl.Open("File 9");
		System.out.println("opened file 9");
		rfl.Show();
		rfl.Open("File 7");
		System.out.println("opened file 7");
		rfl.Show();
	}

}
