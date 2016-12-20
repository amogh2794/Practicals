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
public class addemp extends HttpServlet {

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
            out.println("<title>Servlet addemp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addemp at " + request.getContextPath() + "</h1>");
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
       String id=request.getParameter("txteid");
        String nm=request.getParameter("txtnm");
        String des=request.getParameter("txtdes");
        String bs=request.getParameter("txtbsal");
        String dpt=request.getParameter("txtdept");
        String birthdate=request.getParameter("txtdob");
        String pan=request.getParameter("txtpan");
        try(PrintWriter out = response.getWriter())
    {
        try       
        {          
Class.forName("com.mysql.jdbc.Driver");              
Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");              
PreparedStatement pstmt=con.prepareStatement("insert into empdetails values(?,?,?,?,?,?,?)");
        pstmt.setString(1,id);
        pstmt.setString(2,nm);
        pstmt.setString(3,bs);
        pstmt.setString(4,des);
        pstmt.setString(5,pan);
        pstmt.setString(6,dpt);
        pstmt.setString(7,birthdate);
        int i=pstmt.executeUpdate();
if(i>0)
{
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<body style=\"color:white;background-color:#689F38;font-family:Arial;font-size:25px;align:center;\">");
    out.println("<h2>Successfully</h2>");
    out.println("<div style=\"background-color:white;color:#689F38;\">");
    out.println("<h2>Click the below link to view detailed salary</h2>");
    out.println("<a href=payroll.html style=\"color:#689F38; text-decoration:none;\">View Details</a>");
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
            out.println("<a href=\newemp.html style=\"color:white; text-decoration:none;\">Back</a>");
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
