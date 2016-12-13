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

/**
 *
 * @author Amogh
 */
public class AppExceptionHandler extends HttpServlet {

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
        Throwable throwable=(Throwable)request.getAttribute("javax.servlet.error.exception");
        Integer statusCode=(Integer)request.getAttribute("javax.servlet.error.status_code");
        String servletName=(String)request.getAttribute("javax.Servlet.error.Servlet_name");
        if(servletName==null){
            servletName="Unknown";
        }
        String requestUri=(String)request.getAttribute("javax.servlet.error.request_uri");
        if(requestUri==null){
            requestUri="Unknown";
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Exception/ErrorDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            if(statusCode!=500){
                out.write("<h3>Error Details</h3>");
                out.write("<strong>StatusCode</strong>:"+statusCode+"<br>");
                out.write("<strong>Request URI</strong>:"+requestUri);
            }else{
                out.write("<h3>Exception Details</h3>");
                out.write("<ul><li>Servlet Name:"+servletName+"</li>");
                out.write("<li>Exception Name:"+throwable.getClass().getName()+"</li>");
                out.write("<li>Requested URI:"+requestUri+"</li>");
                out.write("<li>Exception Message:"+throwable.getMessage()+"</li>");
                out.write("</ul>");
            }
            out.write("<br><br>");
            out.write("<a href=\"Programlist.html\">Back</a>");
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
