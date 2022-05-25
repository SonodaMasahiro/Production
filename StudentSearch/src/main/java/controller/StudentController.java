package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StudentBean;
import service.StudentService;

public class StudentController extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        
        try {
            String getId = request.getParameter("id");
            String getPassWord = request.getParameter("password");
            
            StudentService studentService = new StudentService();
           
            StudentBean bean  = studentService.search(getId, getPassWord);
            
            request.setAttribute("StudentBean", bean);
            
            
        
    }catch (Exception e) {
        e.printStackTrace();
    }finally {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

}
}