package Topic_2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App{


	/**
	 * Exercise 1 Topic 2
	 *
	 */
	public static void main(String[] args) {

	      String name= "";
	 
	    System.out.println( "Enter name:" ); 
	    try { 
	      BufferedReader Buff= 
	        new BufferedReader(new InputStreamReader(System.in));   
	      name= Buff.readLine(); 
	    }
	    catch (IOException e) {}
	    System.out.println( "hi," + name);
	}
}

