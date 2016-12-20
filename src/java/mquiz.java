/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Amogh
 */
public class mquiz extends HttpServlet {

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
            out.println("<title>Servlet mquiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet mquiz at " + request.getContextPath() + "</h1>");
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
            try(PrintWriter out = response.getWriter())
          {
              String subj=request.getParameter("sub");
            try       
            {          
            Class.forName("com.mysql.jdbc.Driver");              
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/quiz","root",""); 
            PreparedStatement pstmt=con.prepareStatement("select * from questions where subject=?");
            pstmt.setString(1,subj);
            ResultSet rs=pstmt.executeQuery();  
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet mquiz</title>");            
            out.println("</head>");
            out.println("<body style=\"color:white;background-color:#689F38;font-family:Arial;\">");
            out.println("<h1 style=\"color:white;\">Select an appropriate option for following questions</h1>");
            Integer i=1;
           
            while(rs.next())
            {
                out.println("<h3 style=\"color:white;\">"+"Q"+i+":"+rs.getString("ques")+"</h3>");
                i++;
                PreparedStatement pstmt1=con.prepareStatement("select * from options where qno=?");
                pstmt1.setString(1,rs.getString("qno"));
                 ResultSet rs1=pstmt1.executeQuery();
                 
                    while(rs1.next())
                    {
                        
                        for(int k=1; k<=4; k++)
                        {
                        out.println("<input type=\"radio\" name=\"ans"+i+"\" value=\""+rs1.getString("opt"+k)+"\">");
                        out.println(rs1.getString("opt"+k)+"<br>");                       
                        }                        
                    } 
           }
            
            
            out.println("</body>");
            out.println("</html>");
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
