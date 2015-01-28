package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Classes.Blog;

public class _Test {

	@Before
	public void setUp() throws Exception {
		System.out.println("start of test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("end of test");
	}

	@Test
	public void BlogTest() {
		
		//add a new entry
		Blog blog = new Blog();
		String title="hello";
		String text="hello world, this is my new post!";
		String tag="new";
		blog.PostEntry(title,text,tag);
		
		//add a new entry
		title="bye";
		text="hello world, this is my 2 post!";
		tag="new";
		blog.PostEntry(title,text,tag);
		
		//add a new entry
		title="hi";
		text="hello world, this is my 3 post!";
		tag="new";
		blog.PostEntry(title,text,tag);
	
		//search tag="new"
		tag="new";
		blog.TagSearch(tag);
	
		// delete entry 
		title="hello";
		text="hello world, this is my new post!";
		tag="new";
		blog.DeleteEntry(title,text,tag);
		
		// update entry
		title="bye";
		text="hello world, this is my updated post!";
		tag="23";
		blog.UpdateEntry(title,text,tag);
		
		// show all tags
		blog.AllTags();
		

	}

}
