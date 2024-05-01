package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import dto.Student;

public class StudentDao1 {
	
	  static String className="com.mysql.cj.jdbc.Driver";
	  static String dbUrl="jdbc:mysql://localhost:3306/student_db?user=root&password=root";
	  
	  public void saveStudent(Student s) {
		  
		  try {
			Class.forName(className);
			
			Connection c=DriverManager.getConnection(dbUrl);
			
			PreparedStatement ps=c.prepareStatement("insert into student values(?,?,?,?,?)");
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setDouble(4, s.getMarks());
			ps.setString(5,s.getPassword());
			
			ps.execute();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
	  }
	  
	  
	  public List<Student> getAllStudent() {
		  
			try {
				Class.forName(className);
				
				Connection c=DriverManager.getConnection(dbUrl);
				
		       Statement s=c.createStatement();
		       
		       ResultSet rs=s.executeQuery("select * from student");
		       
		       ArrayList<Student> list=new ArrayList<Student>();
		       
		       while(rs.next()) {
		    	   
		    	   Student st=new Student();
		    	   st.setId(rs.getInt("id"));
		    	   st.setName(rs.getString("name"));
		    	   st.setEmail(rs.getString("email"));
		    	   st.setMarks(rs.getDouble("marks"));
		    	   st.setPassword(rs.getString("pass"));
		    	   
		    	   list.add(st);
		    	   
		       }
		       
		       return list;
		       
		       

				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		  
	  }
	  
	  
	  public Student FetchByEmail(String u_email) {
		  
			try {
				Class.forName(className);
				
				Connection c=DriverManager.getConnection(dbUrl);
				
			    Statement s=c.createStatement();
			    
			    ResultSet rs=s.executeQuery("select * from student");
			    
			    while(rs.next()) {
			    	
			    	if(rs.getString("email").equals(u_email)) {
			    		
			    		Student st=new Student();
			    		
			    		st.setId(rs.getInt("id"));
				    	st.setName(rs.getString("name"));
				    	st.setEmail(rs.getString("email"));
				    	st.setMarks(rs.getDouble("marks"));
				    	st.setPassword(rs.getString("pass"));
			    		
				    	return st;
			    	}
			    	
			    }		
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		  
		  
		  
	  }
	  
	  
	  public void deleteById(int u_id) {
		   
			try {
				Class.forName(className);
				Connection c=DriverManager.getConnection(dbUrl);
				
				PreparedStatement ps=c.prepareStatement("delete student where id=?");
				
				ps.setInt(1, u_id);
				
				ps.execute();

				
				

				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		  
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
