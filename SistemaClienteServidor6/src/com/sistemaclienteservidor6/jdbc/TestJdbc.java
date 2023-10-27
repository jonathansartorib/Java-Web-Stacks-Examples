package com.sistemaclienteservidor6.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbUrl = "jdbc:mysql://localhost:3306/dbstudent?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "root";

        try {
            System.out.println("Conectando...");

            Connection myConn = DriverManager.getConnection(jdbUrl, user, pass);

            System.out.println("Conectou...");

            // Agora, vamos criar uma instrução SQL INSERT INTO
            String sql = "INSERT INTO student (first_name, last_name, email) VALUES (?, ?, ?)";

            // Preparamos a instrução SQL
            PreparedStatement statement = myConn.prepareStatement(sql);

            // Defina os valores que deseja inserir
            statement.setString(1, "Teste");
            statement.setString(2, "Codigo");
            statement.setString(3, "testandooo@example.com");

            // Execute a instrução SQL
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Inserção realizada com sucesso.");
            } else {
                System.out.println("Nenhuma linha inserida.");
            }

            // Feche a conexão e a declaração
            statement.close();
            myConn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



