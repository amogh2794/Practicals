/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amogh
 */
public class ErrorServlet extends HttpServlet {
final String EXC="javax.servlet.error.exception";
final String MSG="javax.servlet.error.message";
final String ST="javax.servlet.error.status_code";
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
            doGet(request,response);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ErrorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>hello</h1>");
            out.println("<h1>Servlet ErrorServlet at " + request.getContextPath() + "</h1>");
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
        ServletContext sc=getServletContext();
        PrintWriter pw=response.getWriter();
        Exception exc=(Exception)request.getAttribute(EXC);
        Integer st_cd=(Integer)request.getAttribute(ST);
        String msg=(String)request.getAttribute(MSG);
        pw.println("<html>");
        pw.println("<body>");
        pw.println("<hr>");
        pw.println("<h1>Sorry an error has occured that has prevented the sever from servicing your request</h1>");
        pw.println("<font size=5>");
        pw.println("<table align=center>");
        pw.println("<tr bgcolor=lightgrey>");
        pw.println("<td>Status Code:</td><td>"+st_cd+"</td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>Type of Exception:</td><td>"+exc.getClass()+"</td>");
        pw.println("</tr>");
        pw.println("<tr bgcolor=lightgrey");
        pw.println("<td>Message Descriotion</td><td>"+msg+"</td><hr/>");
        String str=exc.toString()+st_cd.toString()+msg;
        sc.log("Exception occured",exc);
        
        pw.print("</tr>");
        pw.println("</table>");
        pw.print("<br><br><h3>Plz try again....</h3><br><a href=\"Programlist.html\">BACK</a>");
        pw.println("</body>");
        pw.println("</html>");
        
        
        
// processRequest(request, response);
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
