
<%@page import="Modelo.UsuarioDAO"%>
<%@page import="Modelo.Menu"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    Usuario uLogado = new Usuario();
    
    try{
        uLogado =(Usuario) session.getAttribute("usuario");
    
    %>
      
        
          <ul class="nav nav-sidebar">
                
                
                
             <% for(Menu mLogado: uLogado.getPerfil().getMenusPerfil()){
                %>
              <li > 
                 
                <a href="<%=mLogado.getLink()%>"><%=mLogado.getTitulo()%>
                 <span class="sr-only">(current)</span></a>
                  
                 
                </li>
                 <%}%> 
                  

                </ul>
                 

        <%    }catch(Exception e){
             response.sendRedirect("login.jsp");
}
            %>