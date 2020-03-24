package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import Model.Student;
import java.io.PrintWriter;
//API To Add Task
public class AddStudent extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Name = request.getParameter("Name");
                Integer Score=Integer.parseInt(request.getParameter("Score"));
		if((Name.isEmpty())|| (Score==0))
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
                        Student s=new Student();
                        s.setName(Name);
                        s.setScore(Score);
                        StudentDAO ss=new StudentDAO();
                        ss.createStudent(s);
                        out.println("<font color=red>Entry Created Sucessfully</font> with ID:"+s.getName());
                        out.println("<br><font color=red>Entry Created Sucessfully</font> with ID:"+s.getScore());
                        
		}
	}
    
    
}
