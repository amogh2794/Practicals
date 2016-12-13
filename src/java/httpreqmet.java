/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amogh
 */
public class httpreqmet extends HttpServlet {

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
            out.println("<title>Servlet httpreqmet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet httpreqmet at " + request.getContextPath() + "</h1>");
            out.println("<table border=1 align=center>"+"<th>Header Name</th><th>Header Value</th>");
            Enumeration headerNames = request.getHeaderNames();
                    while(headerNames.hasMoreElements()) 
                    {
                          String headerName = (String)headerNames.nextElement();
                          out.println("<TR><TD>" + headerName+"</TD>");
                          out.println(" <TD>" + request.getHeader(headerName)+"</TD></TR>");
                    }
                    out.println("</TABLE>");

             out.println("<table border=1 align=center>"+"<th>Variable Name</th><th>Variable Value</th>");                 
             out.println("<tr><td>CONTENT_LENGTH</td><td>"+request.getContentLength()+"</td></tr>");                              
             out.println("<tr><td>DOCUMENT_ROOT</td><td>"+getServletContext().getRealPath("/")+"</td></tr>");            
             out.println("<tr><td>REMOTE ADDRESS</td><td>"+request.getRemoteAddr()+"</td></tr>");
             out.println("<tr><td>REMOTE HOST</td><td>"+request.getRemoteHost()+"</td></tr>");             
             out.println("<tr><td>REQUEST METHOD</td><td>"+request.getMethod()+"</td></tr>");
             out.println("<tr><td>SCRIPT NAME</td><td>"+request.getServletPath()+"</td></tr>");
             out.println("<tr><td>SERVER NAME</td><td>"+request.getServerName()+"</td></tr>");
             out.println("<tr><td>SERVER PORT</td><td>"+String.valueOf(request.getServerPort())+"</td></tr>");
             out.println("<tr><td>SERVER PROTOCOL</td><td>"+ request.getProtocol()+"</td></tr>");
             out.println("<tr><td>SERVER SOFTWARE</td><td>"+getServletContext().getServerInfo()+"</td></tr>");
             
             out.println("</table><body><html>");
            
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
