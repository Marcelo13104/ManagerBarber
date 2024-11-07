package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import dto.ConnectionFactory;
import java.sql.*;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        // Tentando estabelecer a conexão e fazer uma consulta
        try (Connection conn = ConnectionFactory.getConnection()) {
            System.out.println("Conexão bem-sucedida!");

            // Criar uma consulta SQL simples para verificar a conexão
            String query = "SELECT professionalId, professionalName FROM Professional LIMIT 5"; // Exemplo de consulta
            
            // Criar um Statement para executar a consulta
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

                // Verificar se há resultados e imprimir no log
                System.out.println("Resultados da consulta:");
                while (rs.next()) {
                    int professionalId = rs.getInt("professionalId");
                    String professionalName = rs.getString("professionalName");
                    System.out.println("ID: " + professionalId + ", Nome: " + professionalName);
                }

            } catch (SQLException e) {
                System.out.println("Erro ao executar a consulta.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados.");
            e.printStackTrace();
        }
    }
}
