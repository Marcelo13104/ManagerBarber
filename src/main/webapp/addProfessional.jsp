<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Adicionar Profissional</title>
</head>
<body>
    <h1>Adicionar Profissional</h1>
    <form action="professional" method="post">
        <input type="hidden" name="action" value="add">
        <label for="cpf">CPF:</label><br>
        <input type="text" id="cpf" name="cpf" required><br><br>
        <label for="name">Nome:</label><br>
        <input type="text" id="name" name="name" required><br><br>
        <label for="isActive">Ativo:</label>
        <input type="checkbox" id="isActive" name="isActive"><br><br>
        <button type="submit">Salvar</button>
    </form>
    <br>
    <a href="professional?action=list">Voltar à lista de profissionais</a>
</body>
</html>
