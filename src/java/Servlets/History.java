package Servlets;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
import Model.Student;
import DAO.StudentDAO;
//API TO List Out All Asset
public class History extends HttpServlet 
{  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {  
     response.setContentType("text/html");  
     PrintWriter out=response.getWriter();  
     String Name = request.getParameter("Name");
     StudentDAO sDAO=new StudentDAO();
     List<Student>sList=sDAO.StudHist(Name);
     request.setAttribute("Marks",sList);
     RequestDispatcher rd=request.getRequestDispatcher("history.jsp");
     rd.forward(request, response); 
    }  
}  