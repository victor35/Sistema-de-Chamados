<%-- 
    Document   : form_inserir_usuario
    Created on : Apr 28, 2017, 5:24:35 PM
    Author     : victor
--%>

<%@page import="Modelo.UnidadeDAO"%>
<%@page import="Modelo.ChamadoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Chamado"%>
<%@page import="Modelo.Unidade"%>
<%@page import="Modelo.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
ArrayList<Chamado>lista = new ArrayList<>();
Usuario u = new Usuario();
u = (Usuario) session.getAttribute("usuario");

int id = u.getUnidade().getId();
try{
   
    ChamadoDAO cDAO = new ChamadoDAO();
    lista = cDAO.listar(id);
    
    
}catch(Exception e){
    out.print("ERRO"+e);
}


%>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Listar Chamado</title>

    
    <link href="css/bootstrap.min.css" rel="stylesheet">

    
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

   
    <link href="css/dashboard.css" rel="stylesheet">

    
    <script src="js/ie-emulation-modes-warning.js"></script>"
    
   <script type="text/javascript">
                
    
                function excluir(id){
                var url = "gerenciar_chamado.do?op=excluir&id="+id;
                if (confirm("Voce tem certeza que deseja excluir o chamado "+id+" ?")){
                    window.open(url,'_self');
                }
            }
       
          
                function atender(id,nome){
                    var url="gerenciar_chamado.do?op=atender&id="+id+"&responsavel="+nome;
                    if(confirm(nome+" voce tem certeza que deseja atender o chamado "+id+" ?")){
                        window.open(url,'_self');
                    }
                }
                
                function concluir(id,solucoes,data_de_fechamento){
                    var url ="form_inserir_solucao.jsp?id="+id+"&solucoes="+solucoes+"&data_de_fechamento="+data_de_fechamento; 
                    window.open(url,'_self');
                }
                function cancelar(id,nome){
                    var url = "gerenciar_chamado.do?op=cancelar&id="+id;
                    if(confirm(nome+"tem certeza que deseja cancelar o chamado"+id+" ?")){
                        window.open(url,'_self');
                    }
                }
                
             
            </script>
  
  </head>

  <body>
       <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
        <%@include file="menu.jsp" %>
        </div>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index2.jsp">SGC IBGE</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
           <%@include file="lista.jsp" %>
        </div>
      </div>
    </nav>

   
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
         

          
          <h2 class="sub-header">Lista Chamado</h2>
          
          <ul id="novo">
              <li><a href="form_inserir_chamado.jsp">
                      <img src="imagens/add.png"> Novo</a></li>
          </ul>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>ID</th>
                            
                            <th>LOCAL</th>
                            <th>REQUISITANTE</th>
                            
                            <th>STATUS</th>
                            <th>DETALHAR</th>
                            <th>DATA DE ABERTURA</th>
                            <th>DATA DE FECHAMENTO</th>
                            <th>ACOES </th>
                </tr>
              </thead>
             <tbody>
                               <% for(Chamado ch: lista){ %>
                        <tr>
                           		
                            <td><%= ch.getId()%></td>
                           
                            <td><%= ch.getLocal()%></td>
                            <td><%= ch.getRequisitante()%></td>
                        
                            <td><%= ch.getStatus()%></td>
                            <td><button><a id="alink" href="informacoes_chamado.jsp?id=<%=ch.getId()%>">Detalhar</a></button></td>
                            <td><%= ch.getDataDeAbertura()%></td>
                            <td><%= ch.getDataDeFechamento()%></td>
                            <%if( uLogado.getPerfil().getNome().equals("Administrador") ){%>
                            
                            <td cellpadding='4'> <a href="form_alterar_chamado.jsp?id=<%=ch.getId()%>"><img src="imagens/pencil.png"/></a>
                            <a href="#" onclick="excluir(<%=ch.getId()%>)"><img src="imagens/delete.png"/></a>
                            <a href="#" onclick="atender(<%=ch.getId()%>,'<%=u.getNome()%>')"><img src="imagens/phone.png"/></a>
                            <a href="#" onclick="concluir(<%=ch.getId()%>,'<%=ch.getSolucoes()%>','<%=ch.getDataDeFechamento()%>')"><img src="imagens/checkmark2.png"/></a>
                            <a href="#" onclick="cancelar(<%=ch.getId()%>,'<%=u.getNome()%>')"><img src="imagens/close.png"></a>
                            </td>
                            
                            <%}else if(uLogado.getPerfil().getNome().equals("Supervisor")){ %>
                            <td><a href="form_alterar_chamado.jsp?id=<%=ch.getId()%>"><img src="imagens/pencil.png"/></a>
                            <a href="#" onclick="atender(<%=ch.getId()%>,'<%=u.getNome()%>')"><img src="imagens/phone.png"/></a>
                            <a href="#" onclick="concluir(<%=ch.getId()%>,'<%=ch.getSolucoes()%>','<%=ch.getDataDeFechamento()%>')"><img src="imagens/checkmark2.png"/></a>
                            <a href="#" onclick="cancelar(<%=ch.getId()%>,'<%=u.getNome()%>')"><img src="imagens/close.png"></a>
                            </td>
                            
                            <%}else if(uLogado.getPerfil().getNome().equals("Estagiario")){ %>
                            <td><a href="form_alterar_chamado.jsp?id=<%=ch.getId()%>"><img src="imagens/pencil.png"/></a>
                            <a href="#" onclick="concluir(<%=ch.getId()%>,'<%=ch.getSolucoes()%>','<%=ch.getDataDeFechamento()%>')"><img src="imagens/checkmark2.png"/></a>
                            <a href="#" onclick="cancelar(<%=ch.getId()%>,'<%=u.getNome()%>')"><img src="imagens/close.png"></a>
                            </td>
                            
                            <%}else if(uLogado.getPerfil().getNome().equals("Pesquisador")){ %>
                            <td><a href="form_alterar_chamado.jsp?id=<%=ch.getId()%>"><img src="imagens/pencil.png"/></a>
                            </td>
                            
                            <% } %>
                        </tr>
                    <%}%>
                            </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
