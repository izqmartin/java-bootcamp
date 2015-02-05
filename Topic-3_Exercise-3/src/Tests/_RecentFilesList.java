package Tests;

import static org.junit.Assert.*;

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
		assertEquals("RecentFilesList [list=[]]      cantidad de objetos:0",rfl.Show());
		
		rfl.Open("File 1");
		assertEquals("RecentFilesList [list=[File 1]]      cantidad de objetos:1",rfl.Show() );
		
		rfl.Open("File 2");
		rfl.Open("File 3");
		rfl.Open("File 4");
		rfl.Open("File 5");
		
		assertEquals("RecentFilesList [list=[File 1, File 2, File 3, File 4, File 5]]      cantidad de objetos:5", rfl.Show() );
		
		rfl.Open("File 1");
		System.out.println("opened file 1");
		
		assertEquals("RecentFilesList [list=[File 2, File 3, File 4, File 5, File 1]]      cantidad de objetos:5",rfl.Show());
		
		rfl.Open("File 4");	
		System.out.println("opened file 4");
		
		assertEquals("RecentFilesList [list=[File 2, File 3, File 5, File 1, File 4]]      cantidad de objetos:5",rfl.Show());
		
		rfl.Open("File 6");
		rfl.Open("File 7");
		rfl.Open("File 8");
		rfl.Open("File 9");
		rfl.Open("File 10");
		rfl.Open("File 11");
		rfl.Open("File 12");
		rfl.Open("File 13");
		rfl.Open("File 14");
		rfl.Open("File 15");
		assertEquals("RecentFilesList [list=[File 2, File 3, File 5, File 1, File 4, File 6, File 7, File 8, File 9, File 10, File 11, File 12, File 13, File 14, File 15]]      cantidad de objetos:15",rfl.Show());
		rfl.Open("File 16");
		assertEquals("RecentFilesList [list=[File 3, File 5, File 1, File 4, File 6, File 7, File 8, File 9, File 10, File 11, File 12, File 13, File 14, File 15, File 16]]      cantidad de objetos:15",rfl.Show());
		
		
				
	}

}
