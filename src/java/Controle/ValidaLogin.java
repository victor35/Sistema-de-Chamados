/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author victor
 */
@WebServlet(name = "ValidaLogin", urlPatterns = {"/valida_login.do"})
public class ValidaLogin extends HttpServlet {

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
            out.println("<title>Servlet ValidaLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ValidaLogin at " + request.getContextPath() + "</h1>");
            
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            HttpSession session = request.getSession();
            try{
                if(login.isEmpty() || login.equals("")){
                      out.print("<script type='text/javascript'>");
                      out.print("alert('O campo login deve ser preenchido!');");
                      out.print("history.back();");
                      out.print("</script>");
                } else if(senha.equals("") || senha.isEmpty()){
                      out.print("<script type='text/javascript'>");
                      out.print("alert('O campo senha deve ser preenchido!');");
                      out.print("history.back();");
                      out.print("</script>");
                } else {
                    Usuario u = new Usuario();
                    UsuarioDAO uDAO = new UsuarioDAO();
                    u = uDAO.logar(login, senha);
                    if(u.getId()>0){
                        session.setAttribute("usuario",u);
                        response.sendRedirect("index2.jsp");
                    } else {
                      out.print("<script type='text/javascript'>");
                      out.print("alert('Usuario ou senha invalidos');");
                      out.print("history.back();");
                      out.print("</script>");
                    }
                }
            }catch(Exception e){
                      out.print("<script type='text/javascript'>");
                      out.print("alert('Banco nao conectado');");
                      out.print("history.back();");
                      out.print("</script>");
            }
            
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
