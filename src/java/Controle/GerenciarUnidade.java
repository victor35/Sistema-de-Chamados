/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Unidade;
import Modelo.UnidadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
@WebServlet(name = "GerenciarUnidade", urlPatterns = {"/gerenciar_unidade.do"})
public class GerenciarUnidade extends HttpServlet {

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
            out.println("<title>Servlet GerenciarUnidade</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GerenciarUnidade at " + request.getContextPath() + "</h1>");
            
            String op= request.getParameter("op");
            String unidade = request.getParameter("unidade");
            
            int id ;
            String telefone = request.getParameter("telefone");
            String cep = request.getParameter("cep");
            String endereco = request.getParameter("endereco");
            
            try{
                Unidade u = new Unidade();
                
                u.setUnidade(unidade);
                u.setCep(cep);
                u.setEndereco(endereco);
                u.setTelefone(telefone);
                if(op.equals("alterar")|| op.equals("excluir")){
                    id = Integer.parseInt(request.getParameter("id"));
                    u.setId(id);
                }
                UnidadeDAO uDAO = new UnidadeDAO();
                switch(op){
                     case "inserir":{
                        if(unidade.isEmpty() || unidade.equals("")){
                            out.print("<script type='text/javascript'>;");
                            out.print("alert('Preencha o campo unidade');");
                            out.print("history.back();");
                            out.print("</script>");
                            
                            } else if (endereco.equals("") || endereco.isEmpty()){
                         out.print("<script type='text/javascript'>;");
                            out.print("alert('Preencha o campo endereco');");
                            out.print("history.back();");
                            out.print("</script>");
                            
                             } else if (telefone.equals("") || telefone.isEmpty()){
                         out.print("<script type='text/javascript'>;");
                            out.print("alert('Preencha o campo endereco');");
                            out.print("history.back();");
                            out.print("</script>");
                            
                             } else if (cep.equals("") || cep.isEmpty()){
                         out.print("<script type='text/javascript'>;");
                            out.print("alert('Preencha o campo endereco');");
                            out.print("history.back();");
                            out.print("</script>");
                    } else{
                        uDAO.inserir(u);
                    }
                    } break;
                    
                    case "alterar":{
                        if(unidade.isEmpty() || unidade.equals("")){
                            out.print("<script type='text/javascript'>;");
                            out.print("alert('Preencha o campo unidade');");
                            out.print("history.back();");
                            out.print("</script>");
                            } else if (endereco.equals("") || endereco.isEmpty()){
                         out.print("<script type='text/javascript'>;");
                            out.print("alert('Preencha o campo descricao');");
                            out.print("history.back();");
                            out.print("</script>");
                            
                             } else if (telefone.equals("") || telefone.isEmpty()){
                         out.print("<script type='text/javascript'>;");
                            out.print("alert('Preencha o campo endereco');");
                            out.print("history.back();");
                            out.print("</script>");
                            
                             } else if (cep.equals("") || cep.isEmpty()){
                         out.print("<script type='text/javascript'>;");
                            out.print("alert('Preencha o campo endereco');");
                            out.print("history.back();");
                            out.print("</script>");
                    } else{
                        uDAO.alterar(u);
                    }
                    }break;
                    
                    case "excluir":{
                        uDAO.excluir(u);
                    }break;
                }
                response.sendRedirect("listar_unidades.jsp");
                
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
