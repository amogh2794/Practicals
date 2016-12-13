/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Amogh
 */
public class loginjdb extends HttpServlet {

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
            out.println("<title>Servlet loginjdb</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginjdb at " + request.getContextPath() + "</h1>");
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
        String usrn=request.getParameter("un");
        String pass=request.getParameter("pd");
        try(PrintWriter out = response.getWriter())
        {
            try       
            {          
            Class.forName("com.mysql.jdbc.Driver");              
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/registration","root","");  
            PreparedStatement pstmt=con.prepareStatement("select username,password from userdetails where username=? and password=?");
            pstmt.setString(1,usrn);
            pstmt.setString(2,pass);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
                response.sendRedirect("Programlist.html");
            }
            else
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<body style=\"color:white;background-color:#689F38;font-family:Arial;font-size:25px;align:center;\">");
            out.println("<h1>Login failed username or password incorrect.</h1>");
            out.println("<a href=\registration.html style=\"color:white; text-decoration:none;\">Register</a>");
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
