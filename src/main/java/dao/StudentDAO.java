package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Student;

public class StudentDAO {
	
	static String class_name="com.mysql.cj.jdbc.Driver";
	static String db_url="jdbc:mysql://localhost:3306/jdbc?user=root&password=root";
	
	public void saveStudent(Student s) {
		
		try {
			
			Class.forName(class_name);
			
			Connection c = DriverManager.getConnection(db_url);
			
			PreparedStatement ps = c.prepareStatement("insert into studentproject values(?,?,?,?,?)");
			
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.setDouble(5, s.getMarks());
			
			ps.executeUpdate();
			
			c.close();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public List<Student> getAllStudent() {
		
		try {
			
			Class.forName(class_name);
			
			Connection c = DriverManager.getConnection(db_url);
			
			Statement s=c.createStatement();
			
			ResultSet rs=s.executeQuery("select * from studentproject");
			
			ArrayList<Student> list = new ArrayList<Student>(); 
			
			while (rs.next()) {
				
				Student st = new Student();
				
				st.setId(rs.getInt("sid"));
				st.setName(rs.getString("sname"));
				st.setEmail(rs.getString("semail"));
				st.setPassword(rs.getString("spassword"));
				st.setMarks(rs.getDouble("smark"));
				
				list.add(st);
			}
			
			return list;
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return null;
	}
	
	public void updateStudent(Student s) {
		
		try {
			
			Class.forName(class_name);
			
			Connection c=DriverManager.getConnection(db_url);
			
			PreparedStatement ps=c.prepareStatement("update studentproject set sname=?,semail=?,spassword=?,smark=? where sid=?");
			
			ps.setInt(5, s.getId());
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setDouble(4, s.getMarks());
			
			ps.executeUpdate();
			
			c.close();
			
			System.out.println("Data update");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Student fetchById(int s) {
		
		try {
			
			Class.forName(class_name);
			
			Connection c=DriverManager.getConnection(db_url);
			
			PreparedStatement ps=c.prepareStatement("select * from studentproject where sid=?");
			
			ps.setInt(1, s);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
//				System.out.println(rs.getInt("sid"));
//				System.out.println(rs.getString("sname"));
//				System.out.println(rs.getString("semail"));
//				System.out.println(rs.getString("spassword"));
//				System.out.println(rs.getDouble("smark"));
				
				int id=rs.getInt("sid");
				String name=rs.getString("sname");
				String email=rs.getString("semail");
				String password=rs.getString("spassword");
				double marks=rs.getDouble("smark");
				
				Student st=new Student(id,name,email,password,marks);
				
				System.out.println(st);
				
				return st;
				
			}
			c.close();
			
			System.out.println("Data Fetched successfully");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Student deleteById(int id) {
		
		try {
			
			Class.forName(class_name);
			
			Connection c=DriverManager.getConnection(db_url);
			
			PreparedStatement ps=c.prepareStatement("DELETE FROM studentproject WHERE sid=?");
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			c.close();
			
			System.out.println("Data Deleted successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

public Student fetchByEmail(String email) {
		
		try {
			
			Class.forName(class_name);
			
			Connection c=DriverManager.getConnection(db_url);
			
			PreparedStatement ps=c.prepareStatement("select * FROM studentproject WHERE semail=?");
			
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				
				Student st=new Student();
				
				st.setId(rs.getInt("sid"));
				st.setName(rs.getString("sname"));
				st.setEmail(rs.getString("semail"));
				st.setPassword(rs.getString("spassword"));
				st.setMarks(rs.getDouble("smark"));
				
				return st;
				
			}
			
			
			c.close();
			
			System.out.println("Data Deleted successfully");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
