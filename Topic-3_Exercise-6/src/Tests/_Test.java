package Tests;


import org.junit.After;
import org.junit.Assert;
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
	public void BlogEntryTest() {
		
		//add a new entry
		Blog blog = new Blog();
		blog.PostEntry("hello","hello world, this is my new post!","new");
		Assert.assertEquals("List of Recent Posts: [Entry [title=hello, text=hello world, this is my new post!, tag=new]]", blog.getRecentEntrys().toString());
	}
		
	
	@Test
	public void searchTagTest() {
		
		//add a new entry
		Blog blog = new Blog();
		blog.PostEntry("hello","hello world, this is my new post!","new");	
		//add a new entry
		blog.PostEntry("bye","hello world, this is my 2 post!","new");
		//add a new entry
		blog.PostEntry("hi","hello world, this is my 3 post!","new");

		String string="TAG Search \"new\" : [Entry [title=hello, text=hello world, this is my new post!, tag=new], Entry [title=bye, text=hello world, this is my 2 post!, tag=new], Entry [title=hi, text=hello world, this is my 3 post!, tag=new]]";
		Assert.assertEquals(string, blog.TagSearch("new"));
	}
	
	@Test
	public void deleteEntryTest() {
		//add a new entry
				Blog blog = new Blog();
				blog.PostEntry("hello","hello world, this is my new post!","new");	
				//add a new entry
				blog.PostEntry("bye","hello world, this is my 2 post!","new");
				//add a new entry
				blog.PostEntry("hi","hello world, this is my 3 post!","new");
		// delete entry 
				blog.DeleteEntry("hello","hello world, this is my new post!","new");	
			Assert.assertEquals("List of Recent Posts: [Entry [title=bye, text=hello world, this is my 2 post!, tag=new], Entry [title=hi, text=hello world, this is my 3 post!, tag=new]]", blog.getRecentEntrys().toString());
			

	}
	@Test
	public void updateAndAllTagsTest() {
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
		Blog blog1 = new Blog();
		blog1=blog;
		// update entry
		title="bye";
		text="hello world, this is my updated post!";
		tag="23";
		blog.UpdateEntry(title,text,tag);

		// show all tags
		//System.out.println(blog.AllTags());
		Assert.assertEquals("TAG List : [new, 23, new]", blog.AllTags());
	}
}
