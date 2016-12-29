/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amogh
 */
public class resultstatus extends HttpServlet {

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
            out.println("<title>Servlet resultstatus</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet resultstatus at " + request.getContextPath() + "</h1>");
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
              String setno=request.getParameter("seatno");
            try       
            {          
            Class.forName("com.mysql.jdbc.Driver");              
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/onlineresult","root",""); 
            PreparedStatement pstmt=con.prepareStatement("select * from marks,studentdetails where marks.seatno=studentdetails.seatno and marks.seatno=?");
            pstmt.setString(1,setno);
            ResultSet rs=pstmt.executeQuery(); 
            Integer sub1x,sub2x,sub3x,sub4x,sub5x,sub1i,sub2i,sub3i,sub4i,sub5i,pr1,pr2,pr3,subextot,subintot,practtot,total;
            String grd; 
            String seme; 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script>function showdetails()"
                        + "{"
                        + "document.getElementById('div1').style.display='none';"
                        + "document.getElementById('div2').style.display='block'; "
                        
                        + "}"
                        + "</script></head>");
            out.println("</head>");
            out.println("<body style=\"color:white;background-color:#689F38;font-family:Arial;font-size:25px;align:center;\">");                    
            out.println("<h1 align='center'>Marksheet</h1><br>");
            out.println("<div style=\"color:#689F38;background-color:white;font-family:Arial;text-align:center;border-radius:5px;\"id=\"div1\">");
            
            
            if(rs.next()) {
             //rs.getString("seatno");
             sub1x=rs.getInt("sub1ex");
             sub2x=rs.getInt("sub2ex");
             sub3x=rs.getInt("sub3ex");
             sub4x=rs.getInt("sub4ex");
             sub5x=rs.getInt("sub5ex");
             sub1i=rs.getInt("sub1in");
             sub2i=rs.getInt("sub2in");
             sub3i=rs.getInt("sub3in");
             sub4i=rs.getInt("sub4in");
             sub5i=rs.getInt("sub5in");
             pr1=rs.getInt("pract1");
             pr2=rs.getInt("pract2");
             pr3=rs.getInt("pract3");
             seme=rs.getString("sem");
             grd=rs.getString("grade");
             subextot=sub1x+sub2x+sub3x+sub4x+sub5x;
             subintot=sub1i+sub2i+sub3i+sub4i+sub5i;
             practtot=pr1+pr2+pr3;
             total=subextot+subintot+practtot;
             String sub1name=null,sub2name=null,sub3name=null,sub4name=null,sub5name=null,sub1pract=null,sub2pract=null,sub3pract=null,semi=null;
             switch(seme) {
                 case "1":  
                     semi="SEM I";
                     sub1name = "C Programming";
                     sub2name = "Computer Networks";
                     sub3name = "Computer Organisation and Architecture";
                     sub4name = "Introduction to WebTechnology";
                     sub5name = "Logic and Discrete Maths";
                     sub1pract = "C Programming Lab";
                     sub2pract = "Computer Networks Lab";
                     sub3pract = "Introduction to WebTechnology Lab";
                     break;
                     case "2":
                     semi="SEM II";
                     sub1name = "Database Management System";
                     sub2name = "Data Structures";
                     sub3name = "Introduction to Mobile Computing";
                     sub4name = "Operating Systems";
                     sub5name = "Probability and Statistics";
                     sub1pract = "Data Structures Lab";
                     sub2pract = "Operating Systems Lab";
                     sub3pract = "Database Management System Lab";
                     break;
                     case "3": 
                     semi="SEM III";
                     sub1name = "Core Java";
                     sub2name = "Distributed Computing";
                     sub3name = "OOAD and UML";
                     sub4name = "Operational Research";
                     sub5name = "BE +POM";
                     sub1pract = "Core Java Lab";
                     sub2pract = "OOAD and UML Lab";
                     sub3pract = "Operating System Lab";
                     break;
                     case "4":
                     semi="SEM IV";
                     sub1name = "ADBT";
                     sub2name = "Adv. Java";
                     sub3name = "Computer Graphics";
                     sub4name = "Financial Management";
                     sub5name = "AI/CC";
                     sub1pract = "Adv. Java Lab";
                     sub2pract = "Computer Graphics Lab";
                     sub3pract = "ADBT Lab";
                     break;
                     default: 
                
                     break;
                     
             }
            
              // if(sub1x<50 || sub2x<50||sub3x<50 || sub4x<50||sub5x<50 || sub1i<50||sub2i<50 || sub3i<50||sub4i<50 || sub5i<50||pr1<50||pr2<50||pr3<50)
             //{out.println("<div id=\"div1\">");
                out.println("<h2>Congatulations "+rs.getString("firstname")+" you have secured "+grd+" grade</h2><br>");
                out.println("<input type=\"submit\" name=\"viewmks\" value=\"View Marks\" onclick=\"showdetails()\"><br><br>");
                out.println("</div>");
                out.println("<div style=\"color:#689F38;background-color:white;font-family:TimesNewRoman;align:center; display:none;border-radius:5px;\"id=\"div2\">"+"<br>");
                out.println("<table border=1>");
                out.println("<tr style=\"color:#689F38;\"><th>Seat No</th><td>"+rs.getString("seatno")+"</td><td colspan='5'>Semister:"+semi+"</td></tr>");
                out.println("<tr style=\"color:#689F38;\"><th>Name</th><td>"+rs.getString("firstname")+" "+rs.getString("lastname")+"</td><td>Course:"+rs.getString("course")+"</td><td colspan='4'>Batch:"+rs.getString("batch")+"</td></tr>");
                out.println("<tr><th>SUBJECT-Name</th><th>External_Mini</th><th>External_max</th><th>External Marks Obtained</th><th>Internal_Mini</th><th>Internal_max</th><th>Internal Marks Obtained</th></tr>");              
                out.println("<tr style=\"color:#689F38;\"><td>"+sub1name+"</td><td>25</td><td>50</td><td>"+sub1x+"</td><td>25</td><td>50</td><td>"+sub1i+"</td></tr>");
                out.println("<tr style=\"color:#689F38;\"><td>"+sub2name+"</td><td>25</td><td>50</td><td>"+sub2x+"</td><td>25</td><td>50</td><td>"+sub2i+"</td></tr>");
                out.println("<tr style=\"color:#689F38;\"><td>"+sub3name+"</td><td>25</td><td>50</td><td>"+sub3x+"</td><td>25</td><td>50</td><td>"+sub3i+"</td></tr>");
                out.println("<tr style=\"color:#689F38;\"><td>"+sub4name+"</td><td>25</td><td>50</td><td>"+sub4x+"</td><td>25</td><td>50</td><td>"+sub4i+"</td></tr>");
                out.println("<tr style=\"color:#689F38;\"><td>"+sub5name+"</td><td>25</td><td>50</td><td>"+sub5x+"</td><td>25</td><td>50</td><td>"+sub5i+"</td></tr>");
                out.println("<tr style=\"color:#689F38;\"><td>"+sub1pract+"</td><td>25</td><td>50</td><td>"+pr1+"</td><td>--</td><td>--</td><td>--</td></tr>");
                out.println("<tr style=\"color:#689F38;\"><td>"+sub2pract+"</td><td>25</td><td>50</td><td>"+pr2+"</td><td>--</td><td>--</td><td>--</td></tr>");
                out.println("<tr style=\"color:#689F38;\"><td>"+sub3pract+"</td><td>25</td><td>50</td><td>"+pr3+"</td><td>--</td><td>--</td><td>--</td></tr>");
                out.println("<tr style=\"color:#689F38;\"><td colspan='3'>Total Marks: 750</td><td colspan='4'>Marks Obtained:"+total+"</td>");
                out.println("<tr style=\"color:#689F38;\"><td colspan='6'>Grade</td><td>"+grd+"</td></tr>");
             
             //}
               /* else
             {
                out.println("<tr style=\"color:black;\"><td>ADBT</td><td>25</td><td>50</td><td>"+sub1x+"</td><td>25</td><td>50</td><td>"+sub1i+"</td></tr>");
                out.println("<tr style=\"color:black;\"><td>Adv.Java</td><td>25</td><td>50</td><td>"+sub2x+"</td><td>25</td><td>50</td><td>"+sub2i+"</td></tr>");
                out.println("<tr style=\"color:black;\"><td>CG</td><td>25</td><td>50</td><td>"+sub3x+"</td><td>25</td><td>50</td><td>"+sub3i+"</td></tr>");
                out.println("<tr style=\"color:black;\"><td>FM</td><td>25</td><td>50</td><td>"+sub4x+"</td><td>25</td><td>50</td><td>"+sub4i+"</td></tr>");
                out.println("<tr style=\"color:black;\"><td>AI</td><td>25</td><td>50</td><td>"+sub5x+"</td><td>25</td><td>50</td><td>"+sub5i+"</td></tr>");
                out.println("<tr style=\"color:black;\"><td>ADBT Pract</td><td>25</td><td>50</td><td>"+pr1+"</td><td>--</td><td>--</td><td>--</td></tr>");
                out.println("<tr style=\"color:black;\"><td>Adv.Java Pract</td><td>25</td><td>50</td><td>"+pr2+"</td><td>--</td><td>--</td><td>--</td></tr>");
                out.println("<tr style=\"color:black;\"><td>CG Pract</td><td>25</td><td>50</td><td>"+pr3+"</td><td>--</td><td>--</td><td>--</td></tr>");
                out.println("<tr style=\"color:black;\"><td>Grade</td><td>"+grd+"</td></tr>");
             }*/
                 out.println("</table><br>");
                 out.println("</div>");
                 out.println("<a href=olresult.html style=\"color:white; text-decoration:none;\">Back</a>");
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
            out.println("Incorrect/Invalid Seat No.<br> ");
            out.println("<a href=\"olresult.html\" style=\"text-decoration:none;color:#689F38;text-align:center\">Back</a>");
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
