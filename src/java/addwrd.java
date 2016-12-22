/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Amogh
 */
public class addwrd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addwrd</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addwrd at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String wd=request.getParameter("txtnword");
        String mn=request.getParameter("txtmn");
        try(PrintWriter out = response.getWriter())
    {
        try       
        {          
Class.forName("com.mysql.jdbc.Driver");              
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dictionary","root","");              
PreparedStatement pstmt=con.prepareStatement("insert into dict values(?,?)");
        pstmt.setString(1,wd);
        pstmt.setString(2,mn);
        int i=pstmt.executeUpdate();
if(i>0)
{
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<body style=\"color:white;background-color:#689F38;font-family:Arial;font-size:25px;align:center;\">");
    out.println("<h2>Successfully</h2>");
    out.println("<div style=\"background-color:white;color:#689F38;\">");
    out.println("<h2>Click the below link to search word</h2>");
    out.println("<a href=oldict.html style=\"color:#689F38; text-decoration:none;\">Find Word</a>");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
}
else
{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body style=\"color:white;background-color:#689F38;font-family:Arial;font-size:25px;align:center;\">");
            out.println("<h1>Unsuccessful please try again later.</h1>");
            out.println("<div style=\"background-color:white;color:#689F38;\">");
            out.println("<a href=\newword.html style=\"color:white; text-decoration:none;\">Back</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>"); 
}
        }
        catch(SQLException e)        
        {
            out.println(e);
        }    
        catch(ClassNotFoundException e)
        {
            out.println(e);
        } 
    }
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
