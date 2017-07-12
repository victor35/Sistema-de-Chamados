package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public abstract class DataBaseDAO {
    
   
    Connection cnn;
    public void conectar() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/chamado";
        String user = "root";
        String pass = "";
        cnn = DriverManager.getConnection(url, user, pass);
    }
    
    public void desconectar() throws Exception{
        if(!cnn.isClosed()){
            cnn.close();
        }
    }


}

