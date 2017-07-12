/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Chamado;
import Modelo.ChamadoDAO;
import Modelo.Equipamentos;
import Modelo.Unidade;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
@WebServlet(name = "GerenciarChamado", urlPatterns = {"/gerenciar_chamado.do"})
public class GerenciarChamado extends HttpServlet {

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
            out.println("<title>Servlet GerenciarChamado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GerenciarChamado at " + request.getContextPath() + "</h1>");
           
            String status = request.getParameter("status");
            String op = request.getParameter("op");
            int id;
            String descricao = request.getParameter("descricao");
            String requisitante = request.getParameter("requisitante");
            String local = request.getParameter("local");
            String prioridade = request.getParameter("prioridade");
            String data_de_abertura = request.getParameter("data_de_abertura");
            String id_equipamentos = request.getParameter("id_equipamentos");
            String id_usuario = request.getParameter("id_usuario");
            String responsavel = request.getParameter("responsavel");
            String data_de_fechamento = request.getParameter("data_de_fechamento");
            String solucoes = request.getParameter("solucoes");
            String id_unidade = request.getParameter("id_unidade");
            
            try{
                Chamado c = new Chamado();
                if(op.equals("excluir") || "alterar".equals(op) || "atender".equals(op) || "concluir".equals(op) || "cancelar".equals(op)){
                     id = Integer.parseInt(request.getParameter("id"));
                     c.setId(id);
                }
                
               
                c.setDataDeAbertura(data_de_abertura);
                c.setRequisitante(requisitante);
                c.setLocal(local);
                c.setPrioridade(prioridade);
                c.setDescricao(descricao);
                c.setStatus(status);
                c.setDataDeFechamento(data_de_fechamento);
                c.setSolucoes(solucoes);
                c.setResponsavel(responsavel);
                
                ChamadoDAO cDAO = new ChamadoDAO();
                switch(op){
                case "inserir":{
                         if(descricao.equals("") || descricao.isEmpty()){        
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o campo descricao');");
                          out.print("history.back();");
                          out.print("</script>");
                         } else if(local.equals("") || local.isEmpty()){ 
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o campo local');");
                          out.print("history.back();");
                          out.print("</script>");
                         }else if(requisitante.equals("") || requisitante.isEmpty()){ 
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o campo requisitante');");
                          out.print("history.back();");
                          out.print("</script>");
                         }else if(prioridade.equals("") || prioridade.isEmpty()){ 
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o campo prioridade');");
                          out.print("history.back();");
                          out.print("</script>");
                         }else if(data_de_abertura.equals("") || data_de_abertura.isEmpty()){ 
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o data de abertura');");
                          out.print("history.back();");
                          out.print("</script>");
                          
                          }else if(id_usuario.equals("") || id_usuario.isEmpty()){ 
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o id usuario');");
                          out.print("history.back();");
                          out.print("</script>");
                          
                          }else if(id_equipamentos.equals("") || id_equipamentos.isEmpty()){ 
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o cid equipamentos');");
                          out.print("history.back();");
                          out.print("</script>");
                          
                          
                         } else{
                             Equipamentos e = new Equipamentos();
                             e.setId(Integer.parseInt(id_equipamentos));
                             c.setEquipamentos(e);
                             
                             Usuario u = new Usuario();
                             u.setId(Integer.parseInt(id_usuario));
                             c.setUsuario(u);
                             
                             Unidade un = new Unidade();
                             un.setId(Integer.parseInt(id_unidade));
                             c.setUnidade(un);
                             cDAO.inserir(c);
                         }
                  }break;
                  
                   case "alterar":{
                         if(descricao.equals("") || descricao.isEmpty()){        
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o campo descricao');");
                          out.print("history.back();");
                          out.print("</script>");
                         } else if(local.equals("") || local.isEmpty()){ 
                          out.print("<script typr=text/javascrit>");
                          out.print("alert('Preencha o campo local');");
                          out.print("history.back();");
                          out.print("</script>");
                         }else if(requisitante.equals("") || requisitante.isEmpty()){ 
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o campo requisitante');");
                          out.print("history.back();");
                          out.print("</script>");
                         }else if(prioridade.equals("") || prioridade.isEmpty()){ 
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o campo prioridade');");
                          out.print("history.back();");
                          out.print("</script>");
                         }else if(data_de_abertura.equals("") || data_de_abertura.isEmpty()){ 
                          out.print("<script type=text/javascrit>");
                          out.print("alert('Preencha o data de abertura');");
                          out.print("history.back();");
                          out.print("</script>");
                       
                         } else{
                             
                             Equipamentos e  = new Equipamentos();
                             e.setId(Integer.parseInt(id_equipamentos));
                             c.setEquipamentos(e);
                             Usuario u = new Usuario();
                             u.setId(Integer.parseInt(id_usuario));
                             c.setUsuario(u);
                             
                             cDAO.alterar(c);
                             
                         }
                }break;
                
                   case "excluir":{
                    cDAO.excluir(c);
                  } break;
                   
                   case "atender":{
                       
                      cDAO.atenderChamado(c);
                  } break;
                   case"concluir":{
                       cDAO.concluirChamado(c);
                   } break;
                   case"cancelar":{
                       cDAO.cancelarChamado(c);
                   } break;
                   
                   
                }
                response.sendRedirect("listar_chamado.jsp");
            }catch(Exception e){
                out.print("ERRO"+e);
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
