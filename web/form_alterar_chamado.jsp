<%-- 
    Document   : form_inserir_chamado
    Created on : Apr 30, 2017, 7:00:40 PM
    Author     : victor
--%>

<%@page import="Modelo.UsuarioDAO"%>
<%@page import="Modelo.EquipamentosDAO"%>
<%@page import="Modelo.Equipamentos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.ChamadoDAO"%>
<%@page import="Modelo.Chamado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Chamado ch = new Chamado();
    ArrayList<Equipamentos> lista = new ArrayList<>();
    Usuario u= new Usuario();
    u =(Usuario) session.getAttribute("usuario");
    try{
      ChamadoDAO chDAO = new ChamadoDAO();
      int id = Integer.parseInt(request.getParameter("id"));
      ch = chDAO.carregarPorId(id);
      int id1 = u.getUnidade().getId();
      EquipamentosDAO eDAO = new EquipamentosDAO();
      lista = eDAO.listar(id1);
     
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

    <title>Alterar Chamado</title>

    
    <link href="css/bootstrap.min.css" rel="stylesheet">

    
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

   
    <link href="css/dashboard.css" rel="stylesheet">

    
    <script src="js/ie-emulation-modes-warning.js"></script>
    
   
  
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
     
            <div class="testbox2">
                        <h1 id='h1form'> Alterar Chamado</h1>
                    <form id="form2" action="gerenciar_chamado.do" name="form_chamado" method="post">
                        <hr>
                        <input type="hidden" name="op" value="alterar"/>
                        <input type="hidden" name="id" value="<%=ch.getId()%>"/>
                        <input type="hidden" name="id_usuario" value="<%=u.getId()%>"/>
                        ID:<%=ch.getId()%> <br>
                        <input type="text" name="descricao" id="input3" placeholder="Descricao" value="<%=ch.getDescricao()%>" required/><br><br>
                        <input type="text" name="local" id="input3" placeholder="Local" value="<%=ch.getLocal()%>" required><br><br>
                        <input type="text" name="requisitante" id="input3" placeholder="Requisitante" value="<%=ch.getRequisitante()%>" required><br><br>  
                        <input type="text" name="prioridade" id="input3" placeholder="Prioridade" value="<%=ch.getPrioridade()%>" required/><br><br>
                        <input type="text" name="data_de_abertura"  id="input3" placeholder="Data de Abertura" value="<%=ch.getDataDeAbertura()%>" required/><br><br> 
              
                          <select class="select1" name="id_equipamentos">
                            <option>Selecione equipamento</option>
                            <% for(Equipamentos e:lista) { %>
                            <option value="<%=e.getId()%>"> <%=e.getNome()%></option>
                            <% } %>
                        </select>
                        <br>
                        <input id="inputsubmit"type="submit"  value="Alterar">
                    </form>
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