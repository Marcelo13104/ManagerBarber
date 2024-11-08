<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="utils.FormatterUtils" %>
    
<html>
<head>
    <title>Listagem de Profissionais</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/listProfessionals.css">
</head>
<body>
    <h1>Lista de Profissionais</h1>
    <table>
        <thead>
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Ativo</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
           <c:forEach var="professional" items="${professionals}">
    <tr>
        <td>${professional.getCpfFormater()}</td>
        <td><input type="text" name="professionalName" value="${professional.professionalName}"></td>
        <td>
            <select name="isActive">
                <option value="true" ${professional.isActive() ? 'selected' : ''}>Ativo</option>
                <option value="false" ${professional.isActive() ? 'selected' : ''}>Inativo</option>
            </select>
        </td>
        <td>
            <a href="professional?action=edit&cpf=${professional.cpf}&professionalName=${professional.professionalName}">Editar</a> |
            <a href="professional?action=delete&cpf=${professional.cpf}">Excluir</a>
        </td>
    </tr>
</c:forEach>
        </tbody>
    </table>
    <br>
    <a href="selling?action=list">Voltar à pagina principal</a>
</body>
</html>
