package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.MySQL;

public class _Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		 try {
	            MySQL instance = MySQL.getInstance();
	            instance.openConnection();
	            instance.listCourse("Cloud Computing");
	            instance.finalNotesList("Bravo");
	            instance.finalNotesList(5);
	            instance.courseStats("Cloud Computing");
	            instance.courseTimeLine("izquierdo");
	            
	        }catch(Exception e) {System.out.println("Exception");}
		
	}

}
