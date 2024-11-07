<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Adicionar Profissional</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addProfessional.css">   
</head>
<body>
    <div class="form-container">
        <h1>Adicionar Profissional</h1>
        <form action="professional" method="post">
            <input type="hidden" name="action" value="add">
            <label for="cpf">CPF:</label>
            <input type="text" id="cpf" name="cpf" required>
            
            <label for="name">Nome:</label>
            <input type="text" id="name" name="name" required>
            
            <label for="isActive">
                <input type="checkbox" id="isActive" name="isActive"> Ativo
            </label>
            
            <button type="submit">Salvar</button>
        </form>
        <a href="professional?action=list">Voltar à lista de profissionais</a>
    </div>
</body>
</html>