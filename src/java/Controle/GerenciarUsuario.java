/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Perfil;
import Modelo.Unidade;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
@WebServlet(name = "GerenciarUsuario", urlPatterns = {"/gerenciar_usuario.do"})
public class GerenciarUsuario extends HttpServlet {

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
            out.println("<title>Servlet GerenciarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GerenciarUsuario at " + request.getContextPath() + "</h1>");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GerenciarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            String op = request.getParameter("op");
            String id = request.getParameter("id");
            String id_perfil = request.getParameter("id_perfil");
            String nome = request.getParameter("nome");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String id_unidade = request.getParameter("id_unidade");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            try {
                Usuario u = new Usuario();

                u.setNome(nome);
                u.setLogin(login);
                u.setSenha(senha);
                u.setEmail(email);
                u.setTelefone(telefone);
                UsuarioDAO uDAO = new UsuarioDAO();
                Perfil p = new Perfil();
                Unidade un = new Unidade();
                switch (op) {
                    case "inserir": {
                        if (nome.isEmpty() || nome.equals("")) {
                            out.print("<script type='text/javascript'>");
                            out.print("alert('O campo Nome deve ser preenchido!');");
                            out.print("history.back();");
                            out.print("</script>");
                        } else if (login.isEmpty() || login.equals("")) {
                            out.print("<script type='text/javascript'>>");
                            out.print("alert('O campo Login deve ser preenchido!');");
                            out.print("history.back();");
                            out.print("</script>");
                        } else if (senha.isEmpty() || senha.equals("")) {
                            out.print("<script type='text/javascript'>>");
                            out.print("alert('O campo Senha deve ser preenchido!');");
                            out.print("history.back();");
                            out.print("</script>");
                        } else if (id_perfil.isEmpty() || id_perfil.equals("")) {
                            out.print("<script type='text/javascript'>>");
                            out.print("alert('O campo Perfil deve ser selecionado!');");
                            out.print("history.back();");
                            out.print("</script>");

                        } else if (id_unidade.isEmpty() || id_unidade.equals("")) {
                            out.print("<script type='text/javascript'>>");
                            out.print("alert('O campo Unidade deve ser selecionado!');");
                            out.print("history.back();");
                            out.print("</script>");
                        } else {
                            
                            p.setId(Integer.parseInt(id_perfil));
                            u.setPerfil(p);
                           
                            un.setId(Integer.parseInt(id_unidade));
                            u.setUnidade(un);
           
                            uDAO.inserir(u);
                        }
                    }
                    break;
                    case "alterar": {
                        if (nome.isEmpty() || nome.equals("")) {
                            out.print("<script type='text/javascript'>");
                            out.print("alert('O campo Nome deve ser preenchido!');");
                            out.print("history.back();");
                            out.print("</script>");
                        } else if (login.isEmpty() || login.equals("")) {
                            out.print("<script type='text/javascript'>>");
                            out.print("alert('O campo Login deve ser preenchido!');");
                            out.print("history.back();");
                            out.print("</script>");
                        } else if (senha.isEmpty() || senha.equals("")) {
                            out.print("<script type='text/javascript'>>");
                            out.print("alert('O campo Senha deve ser preenchido!');");
                            out.print("history.back();");
                            out.print("</script>");
                        } else if (id_perfil.isEmpty() || id_perfil.equals("")) {
                            out.print("<script type='text/javascript'>>");
                            out.print("alert('O campo Perfil deve ser selecionado!');");
                            out.print("history.back();");
                            out.print("</script>");

                        } else if (id_unidade.isEmpty() || id_unidade.equals("")) {
                            out.print("<script type='text/javascript'>>");
                            out.print("alert('O campo Unidade deve ser selecionado!');");
                            out.print("history.back();");
                            out.print("</script>");

                        } else {
                            
                            p.setId(Integer.parseInt(id_perfil));
                            u.setPerfil(p);
                            
                            un.setId(Integer.parseInt(id_unidade));
                            u.setUnidade(un);
                            
                            u.setId(Integer.parseInt(id));
                            uDAO.alterar(u);
                        }
                    }
                    break;
                    case "excluir": {
                     
                     
                        
                        u.setId(Integer.parseInt(id));
                        uDAO.excluir(u);

                    }
                    break;
                }
                response.sendRedirect("listar_usuario.jsp");

                } catch (Exception e ) {
                    out.print("<script type='text/javascript'>");
                    out.print("alert('Erro:  " + e+ "');");
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
