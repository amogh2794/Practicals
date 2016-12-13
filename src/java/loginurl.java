/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amogh
 */
public class loginurl extends HttpServlet {
private static final long serialVersionUID=1L;
public loginurl(){
    
}
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
            out.println("<title>Servlet loginurl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginurl at " + request.getContextPath() + "</h1>");
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
       response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String userName=request.getParameter("un").trim();
        String password=request.getParameter("pd").trim();
        if(userName==null||userName.equals("")||password==null||password.equals("")){
            out.println("Please enter both username and"+"password");
            RequestDispatcher reqDispatcher=request.getRequestDispatcher("/loginseturl.html");
            reqDispatcher.include(request,response);
        }
        else if(userName.equals("amogh")&&password.equals("vaidya"))
        {
            out.println("Logged in successfully");
        out.println("click here to see the values of username & password");
        out.println("<a href='logingeturl?userName="+userName+"&password="+password+"'>Click here</a>");
        }
        else{
                out.println("wrong username or password");
                RequestDispatcher reqDispatcher=request.getRequestDispatcher("/loginseturl.html");
                reqDispatcher.include(request,response);
        //processRequest(request, response);
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
