<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.*" %>
<%@ page import="dto.ConnectionFactory" %> <!-- Substitua pelo pacote correto da ConnectionFactory -->

<html>
<head>
    <title>Teste de Conexão com Banco de Dados</title>
</head>
<body>
    <h1>Verificação de Conexão com Banco de Dados</h1>
    <%
        Connection conn = null;
        try {
            // Tenta obter a conexão
            conn = ConnectionFactory.getConnection();
            if (conn != null) {
                out.println("<p>Conexão com o banco de dados estabelecida com sucesso!</p>");
            } else {
                out.println("<p>Falha ao estabelecer a conexão com o banco de dados.</p>");
            }
        } catch (SQLException e) {
            // Mostra uma mensagem de erro em caso de falha
            out.println("<p>Erro ao conectar com o banco de dados: " + e.getMessage() + "</p>");
        } finally {
            if (conn != null) {
                try {
                    conn.close(); // Fecha a conexão após o teste
                } catch (SQLException e) {
                    out.println("<p>Erro ao fechar a conexão: " + e.getMessage() + "</p>");
                }
            }
        }
    %>
</body>
</html>
