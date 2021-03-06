<%-- 
    Document   : listar_menu
    Created on : Apr 28, 2017, 11:55:22 PM
    Author     : victor
--%>

<%@page import="Modelo.Unidade"%>
<%@page import="Modelo.Perfil"%>
<%@page import="Modelo.PerfilDAO"%>
<%@page import="Modelo.UnidadeDAO"%>
<%@page import="Modelo.EquipamentosDAO"%>
<%@page import="Modelo.Equipamentos"%>
<%@page import="Modelo.MenuDAO"%>
<%@page import="Modelo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%  ArrayList<Perfil> lista = new ArrayList<>();
    ArrayList<Unidade> listar = new ArrayList<>();
  try{
    PerfilDAO pDAO = new PerfilDAO();
    lista = pDAO.listar();
    
    UnidadeDAO uDAO = new UnidadeDAO();
    listar=uDAO.listar();
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

    <title>Cadastrar Usuario</title>

    
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
                    <h1 id="h1form"> Cadastrar Usuario</h1>
                        <form id="form2" action="gerenciar_usuario.do" name="form_usuario" method="post">
                            <hr>
                            <input type="hidden" name="op" value="inserir"/>   
                            <input type="text" name="login" id="input2" placeholder="Usuario" required/><br>
                            <input type="text" name="nome" id="input2" placeholder="Nome" required/><br>
                            <input type="text" name="telefone" id="input2" placeholder="Telefone" required/><br>
                            <input type="text" name="email" id="input2" placeholder="Email" required/><br>
                            <input type="password" name="senha" id="input2" placeholder="Senha" required/><br><br>
                            <select name="id_perfil" class="select1" required> 
                                <option > Selecione Perfil</option>
                                <% for (Perfil p : lista) {%>
                                <option value="<%=p.getId()%>">  <%=p.getNome()%> </option>
                                <% } %>
                            </select> 
                            <select name="id_unidade" class="select2" required> 
                                <option > Selecione Unidade</option>
                                <% for (Unidade u : listar) {%>
                                <option value="<%= u.getId()%>"><%= u.getUnidade()%></option>
                                <%}%>
                            </select>    <br>
                            <input type="submit" id="inputsubmit"  >
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