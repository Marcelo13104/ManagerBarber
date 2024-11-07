<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
                    <td>${professional.cpf}</td>
                    <td>${professional.professionalName}</td>
                    <td>${professional.isActive()}</td>
                    <td>
                        <a href="professional?action=edit&cpf=${professional.cpf}">Editar</a> |
                        <a href="professional?action=delete&cpf=${professional.cpf}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="addProfessional.jsp">Adicionar Profissional</a>
</body>
</html>
