/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orientacaoweb2.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author joao
 */
public class Conexao {
    
    public static Connection Conector() {
        java.sql.Connection conexao = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/orientacaoweb?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            System.err.println("\n " + e.getCause());
            System.err.println("\n " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
}
