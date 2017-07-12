
<%@page contentType="text/html" pageEncoding="UTF-8"%>


                <ul id="menu" >
                    <li> <img  src="imagens/id.png"/> <%=uLogado.getId() %>&nbsp;&nbsp; <img src="imagens/administrator.png"  /> <%=uLogado.getNome()%> </li>
                      
                    <li> <img src="imagens/home.png"/> <%= uLogado.getUnidade().getUnidade() %></li>
                    <li><a href="sair.jsp"> <img id="sair" src="imagens/power.png" alt="sair" /></a></li>
                   </ul> 
