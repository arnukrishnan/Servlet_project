package Studentcrud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class Student_Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Connection con = Dbconnection.getConnection();
			String query = "select * from student";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				resp.getWriter().println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("dept"));
			}

			con.close();
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String dept = req.getParameter("dept");

		try {
			Connection con = Dbconnection.getConnection();
			String query = "insert into student values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, dept);

			int val = ps.executeUpdate();

			con.close();
			ps.close();

			resp.getWriter().println("inserted successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String dept = req.getParameter("dept");
			                                              
			Connection con = Dbconnection.getConnection();  
			String query = "update student set name=?,dept=? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2, dept);
			ps.setInt(3, id);
			 int val=ps.executeUpdate();
				
		 
		  resp.getWriter().println(val+"updated successfully");
		  con.close();
		  ps.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
            
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String dept = req.getParameter("dept");
			
			Connection con = Dbconnection.getConnection();
			String query = "delete from student where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);        
			ps.executeUpdate();                      
			
			resp.getWriter().println("updated successfully");
			ps.close();              
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
