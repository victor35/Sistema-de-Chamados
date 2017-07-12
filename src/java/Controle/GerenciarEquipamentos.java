/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Equipamentos;
import Modelo.EquipamentosDAO;
import Modelo.Unidade;
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
@WebServlet(name = "GerenciarEquipamentos", urlPatterns = {"/gerenciar_equipamentos.do"})
public class GerenciarEquipamentos extends HttpServlet {

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
            out.println("<title>Servlet GerenciarEquipamentos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GerenciarEquipamentos at " + request.getContextPath() + "</h1>");
            
            String op = request.getParameter("op");
            int id;
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String tipo = request.getParameter("tipo");
            String id_unidade = request.getParameter("id_unidade");
            try{
                Equipamentos e = new Equipamentos();
                if(op.equals("alterar") || op.equals("excluir")){
                     id = Integer.parseInt(request.getParameter("id"));
                     e.setId(id);
                }
                e.setDescricao(descricao);
                e.setNome(nome);
                e.setTipo(tipo);
                EquipamentosDAO eDAO = new EquipamentosDAO();
                Unidade u = new Unidade();
                switch(op){
                    case "inserir":{
                        if(nome.equals("")|| nome.isEmpty()){
                            out.print("<script type=text/javascript>");
                            out.print("alert('Preencha o campo nome');");
                            out.print("history.back();");
                            out.print("</script>");
                        }
                        else if(descricao.equals("")|| descricao.isEmpty()){
                            out.print("<script type=text/javascript>");
                            out.print("alert('Preencha o campo descricao');");
                            out.print("history.back();");
                            out.print("</script>");
                        }  else if(tipo.equals("")|| tipo.isEmpty()){
                            out.print("<script type=text/javascript>");
                            out.print("alert('Preencha o campo descricao');");
                            out.print("history.back();");
                            out.print("</script>");
                        } else{
                            u.setId(Integer.parseInt(id_unidade));
                            e.setUnidade(u);
                            eDAO.inserir(e);
                        }
                    }
                        break;
                          case "alterar":{
                        if(nome.equals("")|| nome.isEmpty()){
                            out.print("<script type=text/javascript>");
                            out.print("alert('Preencha o campo nome');");
                            out.print("history.back();");
                            out.print("</script>");
                        }
                        else if(descricao.equals("")|| descricao.isEmpty()){
                            out.print("<script type=text/javascript>");
                            out.print("alert('Preencha o campo descricao');");
                            out.print("history.back();");
                            out.print("</script>");
                        }  else if(tipo.equals("")|| tipo.isEmpty()){
                            out.print("<script type=text/javascript>");
                            out.print("alert('Preencha o campo descricao');");
                            out.print("history.back();");
                            out.print("</script>");
                        } else{
                            u.setId(Integer.parseInt(id_unidade));
                            e.setUnidade(u);
                            eDAO.alterar(e);
                        }
                          }
                           break;
                           
                           case "excluir":{
                           eDAO.excluir(e);
                          }
                        

                }
                
        
            response.sendRedirect("listar_equipamentos.jsp");
            }catch(Exception e){
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
