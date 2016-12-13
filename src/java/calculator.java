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
public class calculator extends HttpServlet {

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
        int firstnum,secnum,sum=0,sub=0,mul=0;
        float div=0;
        String opr;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            firstnum=Integer.parseInt(request.getParameter("fstno"));
            secnum=Integer.parseInt(request.getParameter("sndno"));
            opr=request.getParameter("operator");
            if(opr.equals("+"))
            {
                sum=firstnum+secnum;
                out.println("<p>Sum of:"+firstnum+" and "+secnum+" is "+sum+"</p>");
            }
            else if(opr.equals("-"))
            {
                if(firstnum<secnum)
                {
                    out.println("<p>Please give proper input</p>");
                }
                else
                {
                sub=firstnum-secnum;
                out.println("<p>Subtraction of:"+firstnum+" and "+secnum+" is "+sub+"</p>");
                }
            }
            else if(opr.equals("*"))
                
            {
                mul=firstnum*secnum;
                 out.println("<p>Product of:"+firstnum+" and "+secnum+" is "+mul+"</p>");
            }
            else if(opr.equals("/"))
            {
                div=firstnum/secnum;
                 out.println("<p>Division of:"+firstnum+"and"+secnum+"is"+div+"</p>");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calculator</title>");            
            out.println("</head>");
            out.println("<body style=\"color:white;background-color:navy;font-family:Arial;font-size:25px\">");
            out.println("<a href=\"SimpCalc.html\"><input type=\"submit\" value=\"Back\"></a>");
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
