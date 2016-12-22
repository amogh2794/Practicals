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
public class paydetails extends HttpServlet {

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
            out.println("<title>Servlet paydetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet paydetails at " + request.getContextPath() + "</h1>");
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
              String emid=request.getParameter("txteid");
            try       
            {          
            Class.forName("com.mysql.jdbc.Driver");              
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root",""); 
            PreparedStatement pstmt=con.prepareStatement("select * from empdetails where empdetails.eid=?");
            pstmt.setString(1,emid);
            float gross,da,hra,net,tax=0,incm;
            int bsal=0;
            String nm=null;
            String des=null;
            String pno=null;
            String dpt=null;
            String dob=null;
            ResultSet rs=pstmt.executeQuery();
            
            
            if (rs.next()) {
             nm=rs.getString("ename");
             bsal=rs.getInt("basicsalary");
             des=rs.getString("designation");
             pno=rs.getString("panno");
             dpt=rs.getString("dept");
             dob=rs.getString("dob");
            
            
                da=bsal*50/100;
                hra=bsal*20/100;
                gross=da+hra+bsal;
                incm=gross*12;
                if(incm>=100000 && incm<=200000)
                   {
                       tax=gross*10/100;
                   }
                else if(incm>=200000 && incm<=300000)
                   {
                       tax=gross*20/100;
                   }
                else if(incm>=300000)
                   {
                       tax=gross*30/100;
                   }
                net=gross-tax;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body style=\"color:white;background-color:#689F38;font-family:Arial;font-size:25px;align:center;\">");                    
            out.println("<h1 align='center'>Salary Details of "+nm+"</h1><br>");
            out.println("<div style=\"color:#689F38;background-color:white;font-family:Arial;border-radius:5px;\">");
            out.println("<table align='center' cellsppacing='30'>");
            out.println("<tr><td>Employee ID: "+emid+"</td><td>PAN NO: "+pno+"</td></tr>");
            out.println("<tr><td>Employee Name: "+nm+"</td><td>Department: "+dpt+"</td></tr>");
            out.println("<tr><td>Designation: "+des+"</td><td>Date of Birth: "+dob+"</td></tr>"); 
            out.println("<hr style=\"color=#689F38\">");
            out.println("<tr><td>Basic Salary: "+bsal+"</td></tr>");
            out.println("<tr><td>DA: "+da+"</td></tr>"); 
            out.println("<tr><td>HRA: "+hra+"</td><td>Tax Pay: "+tax+"</td></tr>");
            out.println("<tr><td>NetPay: "+net+"</td><td>GrossPay: "+gross+"</td></tr>");
            out.println("</table><br>");
            out.println("<a href=\"payroll.html\" style=\"text-decoration:none;color:#689F38;text-align:center\">Back</a>");
            out.println("</div><br>");
            
            out.println("</body>");
            out.println("</html>");
            }
             else
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body style=\"color:white;background-color:#689F38;font-family:Arial;font-size:25px;text-align:center;\">");                    
            out.println("<div style=\"color:#689F38;background-color:white;font-family:Arial;border-radius:5px;text-align:center;\">");
            out.println("Incorrect/Invalid Employee ID<br> ");
            out.println("</div>");
            out.println("<a href=\"payroll.html\" style=\"text-decoration:none;color:white;text-align:center\">Back</a>");
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
