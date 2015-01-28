package Classes;


import java.sql.*;

import com.mysql.jdbc.Statement;

public class MySQL {
	private static MySQL mysql;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/highschool";
	static final String USER = "root";
	static final String PASS = "regedit";
	static Connection conn = null;
	
    public static MySQL getInstance() {       
        if (mysql == null) 
        	mysql = new MySQL();
        return mysql;
    }
    
	      
	  public void closeConnectionDB() throws SQLException{
		  if(this.conn != null) {
			  conn.close();
			  mysql = null;
		   System.out.println("Connection closed.");
		  }
	  }
	 
	  public Connection openConnection() throws Exception {
		  if (this.conn == null) {
	          Class.forName(JDBC_DRIVER); 
	          this.conn = DriverManager.getConnection(DB_URL, USER, PASS);   
	          System.out.println("Connection opened...");
	      }
	      return this.conn;   
	  }
	  
	  public void listCourse(String courseName) throws SQLException{
		  System.out.println("Creating statement...");
		  ResultSet rs = conn.createStatement().executeQuery("call listCourse(\""+courseName+"\");");
	      showListCourse(rs);
	      rs.close();
	  }
	  
	  public void showListCourse(ResultSet rs) throws SQLException{
		  int flag=0;
		  while(rs.next()){
		         String courseName = rs.getString("name");
		         String teacherLast = rs.getString("t.lastname");
		         String teacherFirst = rs.getString("t.firstname");
		         String studentLast = rs.getString("s.lastname");
		         String studentFirst = rs.getString("s.firstname");
	
		         if(flag==0){
		         System.out.println("\nCourse: " + courseName);
		         System.out.println("\nTeacher: " + teacherLast + " , " + teacherFirst);
		         System.out.println("\nStudents: \n");
		         flag=1;
		         }
		         System.out.print(studentLast + " , " + studentFirst +"\n");
		      }
	  }
	  
	  public void finalNotesList(String lastName) throws SQLException{
		  System.out.println("Creating statement...");
		  ResultSet rs = conn.createStatement().executeQuery("call listFinalNotes_StudentLastName(\""+lastName+"\");");
	      showFinalNotesList(rs);
	      rs.close();
		  
	  }
	  
	  public void finalNotesList(int registrationNumber) throws SQLException{
		  System.out.println("Creating statement...");
		  ResultSet rs = conn.createStatement().executeQuery("call listFinalNotes_RegNum("+registrationNumber+");");
	      showFinalNotesList(rs);
	      rs.close();
	  }
	  
	  public void showFinalNotesList(ResultSet rs) throws SQLException{
		  int flag=0;
		  while(rs.next()){
		         String courseName = rs.getString("name");
		         float finalNote = rs.getFloat("finalNote");
		         String studentLast = rs.getString("s.lastname");
		         String studentFirst = rs.getString("s.firstname");
	
		         if(flag==0){
		         System.out.println("Course , final note , Student Name\n");
		         flag=1;
		         }
		         System.out.print(courseName+" , "+ finalNote + " , " + studentLast +","+studentFirst +"\n");
		      }
	  }
	  
	  public void courseStats(String courseName) throws SQLException{
		  System.out.println("Creating statement...");
		  ResultSet rs = conn.createStatement().executeQuery("call courseStats(\""+courseName+"\");");

		  while(rs.next()){
			  float Pass = rs.getFloat("pass");
		      float fail = rs.getFloat("fail");
		      System.out.println("pass:" + Pass +"% , fail: "+ fail + "%.\n" );
		  }
	      rs.close();
	  }
	  
	  public void courseTimeLine(String teacherLast) throws SQLException{
		  System.out.println("Creating statement...");
		  ResultSet rs = conn.createStatement().executeQuery("call courseTimeLine(\""+teacherLast+"\");");
	      showcourseTimeLine(rs);
	      rs.close();
	  }
	  public void showcourseTimeLine(ResultSet rs) throws SQLException{
		  int flag=0;
		  while(rs.next()){
		         String teacherLast = rs.getString("t.lastname");
		         String teacherFirst = rs.getString("t.firstname");
		         Date day = rs.getDate("s.day");
		         Time startTime = rs.getTime("s.startTime");
		         Time endTime = rs.getTime("s.endTime");
		         String courseName = rs.getString("c.name");
	
		         if(flag==0){
		         System.out.println("\nTeacher: " + teacherLast + " , " + teacherFirst);
		         System.out.println("\nSchedule: \n");
		         flag=1;
		         }
		         System.out.print(day + " , " + startTime + " - "+endTime+" < "+courseName+" >\n");
		      }
	  }
	  
}
