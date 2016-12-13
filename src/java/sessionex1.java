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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amogh
 */
public class sessionex1 extends HttpServlet {
    Integer count;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
public void init(){
     count=null;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        HttpSession session=request.getSession(true);
        response.setContentType("text/html");
        
        String head;
        
        if(session.isNew()){
            head="This is the new Session";
            count=0;
        }
        else{
            head="This is the old Session";
            
        
        Integer oldcount=(Integer)session.getAttribute("count");
        if(oldcount!=null){
            count=new Integer(oldcount.intValue()+1);
        }
        }
    session.setAttribute("count",count);
    out.println("<!DOCTYPE html>");
    out.println("<html><bgcolor=\"#fdf5e6\">\n"+"<h2 align=\"center\">"+head+"</h2>\n"+"<table border=1 align=center>\n"+"<tr bgcolor=\"#ffad00\">\n"+"<th>Information type<th>SessionCount<th>Session id\n"+"<tr>\n"+"<td>Total Session Accesses\n"+"<td>"+"\n"+count+"<td>"+"\n"+session.getId()+"<table>\n"+"</body></html>");
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
