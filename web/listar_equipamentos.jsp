<%-- 
    Document   : listar_menu
    Created on : Apr 28, 2017, 11:55:22 PM
    Author     : victor
--%>



<%@page import="Modelo.EquipamentosDAO"%>
<%@page import="Modelo.Equipamentos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%  ArrayList<Equipamentos> lista = new ArrayList<>();  
Usuario u = new Usuario();
u = (Usuario) session.getAttribute("usuario");
int id = u.getUnidade().getId();

    try{
       EquipamentosDAO eDAO = new EquipamentosDAO();
        lista = eDAO.listar(id);
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

    <title>Listar Equipamentos</title>

    
    <link href="css/bootstrap.min.css" rel="stylesheet">

    
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

   
    <link href="css/dashboard.css" rel="stylesheet">

    
    <script src="js/ie-emulation-modes-warning.js"></script>
    
   <script type="text/javascript">
                function excluir(id,nome){
            var url="gerenciar_equipamentos.do?op=excluir&id="+id;
            if (confirm("Voce tem certeza que deseja excluir o equipamentos: "+nome+"?")){
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
          

          
          <h2 class="sub-header">Lista Equipamentos</h2>
          <ul id="novo">
              <li><a href="form_inserir_equipamentos.jsp">
                      <img src="imagens/add.png"> Novo</a></li>
          </ul>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>ID</th>
                            <th>NOME</th>
                            <th>DESCRICAO</th>
                            <th>TIPO</th>
                            <th>ACOES</th>
                </tr>
              </thead>
             <tbody>
                               <% for(Equipamentos e:lista){%>
                        <tr>
                            <td><%= e.getId()%></td>
                            <td><%= e.getNome() %></td>
                            <td><%=e.getDescricao() %></td>
                            <td><%= e.getTipo() %></td>
                            <% if(u.getPerfil().getNome().equals("Administrador") || (u.getPerfil().getNome().equals("Supervisor"))) { %>
                            <td> &nbsp; 
                                <a href="form_alterar_equipamentos.jsp?id=<%=e.getId() %>"><img src="imagens/pencil.png"></a>&nbsp;
                                <a href="#" onclick="excluir(<%= e.getId() %>,'<%= e.getNome() %>') "><img src="imagens/delete.png"></a></td>
                             <% }else if(u.getPerfil().getNome().equals("Estagiario")){  %> 
                              <td> <a href="form_alterar_equipamentos.jsp?id=<%=e.getId() %>,'<%=e.getUnidade().getId() %>'"><img src="imagens/pencil.png"></a>&nbsp;   </td>    
                         <%  }%>
                </tr>
                        <%  }%>
                            </tbody>
            </table>
          </div>
        </div>'
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

