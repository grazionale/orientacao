/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orientacaoweb2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
    
    private static Connection conexao = null;
    private static String url = "jdbc:postgresql://localhost:5432/orientacaoweb";
    private static String user = "postgres";
    private static String password = "root";
    
    private static PreparedStatement ps;
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, user, password);

            /*conexao.prepareStatement("CREATE TABLE IF NOT EXISTS usuarios (\n"
                    + "  id SERIAL PRIMARY KEY,\n"
                    + "  nome VARCHAR UNIQUE NOT NULL,\n"
                    + "  email VARCHAR UNIQUE NOT NULL,\n"
                    + "  senha VARCHAR NOT NULL\n"
                    + ");").executeUpdate();

            conexao.prepareStatement("CREATE TABLE IF NOT EXISTS seguidores (\n"
                    + "  seguido_id SERIAL REFERENCES usuarios (id) NOT NULL,\n"
                    + "  seguidor_id SERIAL REFERENCES usuarios (id) NOT NULL\n"
                    + ");").executeUpdate();

            conexao.prepareStatement("CREATE TABLE IF NOT EXISTS postagens (\n"
                    + "  id SERIAL PRIMARY KEY,\n"
                    + "  usuario_id SERIAL REFERENCES usuarios (id) NOT NULL,\n"
                    + "  mensagem varchar(144) NOT NULL,\n"
                    + "  data_criacao TIMESTAMP DEFAULT NOW()\n"
                    + ");").executeUpdate();*/
                        
            conexao.prepareStatement("CREATE TABLE IF NOT EXISTS usuario(\n" +
                            "	idUsuario serial primary key,\n" +
                            "    nomeUsuario text not null,\n" +
                            "    emailUsuario text not null,\n" +
                            "    senhaUsuario text not null\n" +
                            ");").executeUpdate();
            
            conexao.prepareStatement("CREATE TABLE IF NOT EXISTS professor(\n" +
                                        "	idProfessor serial primary key,\n" +
                                        "    nomeProfessor text not null\n" +
                                        ");").executeUpdate();
            
            conexao.prepareStatement("CREATE TABLE IF NOT EXISTS orientacao(\n" +
                                        "	idOrientacao serial primary key,\n" +
                                        "    descricaoOrientacao text not null,\n" +
                                        "    orientadoOrientacao text not null,\n" +
                                        "    idProfessorOrientacao int not null,\n" +
                                        "    CONSTRAINT fkProfessorOrientacao FOREIGN KEY (idProfessorOrientacao) REFERENCES professor (idProfessor)\n" +
                                        ")").executeUpdate();
                      
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection Conector() {
        return conexao;
    }
    
}
