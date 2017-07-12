<%-- 
    Document   : listar_menu
    Created on : Apr 28, 2017, 11:55:22 PM
    Author     : victor
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Modelo.ChamadoDAO"%>
<%@page import="Modelo.Chamado"%>
<%@page import="Modelo.EquipamentosDAO"%>
<%@page import="Modelo.Equipamentos"%>
<%@page import="Modelo.MenuDAO"%>
<%@page import="Modelo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Date d = new Date();
    d.getTime();
    DateFormat spf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    String data = spf.format(d);
  Chamado ch = new Chamado();
    try{
       int id = Integer.parseInt(request.getParameter("id"));
       ChamadoDAO chDAO  = new ChamadoDAO();
       ch = chDAO.carregarPorId(id);
        
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

    <title>Cadastrar Solucao</title>

    
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
    
                    <h1 id="h1form"> Cadastrar Solução</h1>
                    <form id="form2" action="gerenciar_chamado.do" name="form_chamado" method="post">
                        <hr>
                        
                        <input type="hidden" name="op" value="concluir"/>   
                        <input type="hidden" name="id" value="<%=ch.getId()%>"/>
                        <input type="hidden" name="data_de_fechamento" value="<%=data%>"/>
                        ID:<%=ch.getId()%> <br>
                        <textarea type="text" name="solucoes"  placeholder="Solucao" value="<%=ch.getSolucoes() %>" required><%=ch.getSolucoes() %></textarea><br>
                        
                        <input type="submit" id="inputsubmit" value="Cadastrar">
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