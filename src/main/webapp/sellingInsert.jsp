<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Inserir Venda</title>
    <link rel="stylesheet" type="text/css" href="resources/css/sellingInsert.css">
    <script>
        function formatCurrency(input) {
            let value = input.value;
            value = value.replace(/\D/g, ''); // Remove tudo o que não for número
            value = value.replace(/(\d)(\d{8})$/, '$1.$2'); // Adiciona ponto para milhar
            value = value.replace(/(\d)(\d{5})$/, '$1.$2'); // Adiciona ponto para milhar
            value = value.replace(/(\d)(\d{2})$/, '$1,$2'); // Adiciona vírgula
            input.value = 'R$ ' + value;
        }
    </script>
</head>
<body>
    <div class="main-container">
        <!-- Sidebar -->
        <div class="sidebar">
            <h2>Menu</h2>
            <ul>
                <li><a href="addProfessional.jsp">Adicionar Profissional</a></li>
                <li><a href="professional?action=list">Profissionais</a></li>
                <li><a href="service?action=list">Serviços</a></li>
                <li><a href="paymentMethod?action=list">Métodos de Pagamento</a></li>
                <li><a href="biggestSellerMark?action=list">Maior Vendedor</a></li>
            </ul>
        </div>

        <!-- Main Content -->
        <div class="content-container">
            <div class="form-container">
                <h1>Inserir Venda</h1>

                <!-- Formulário de Inserção de Venda -->
                <form action="selling?action=add" method="POST">
                    <div>
                        <label for="cpf">Selecione o Profissional:</label>
                        <select name="cpf" id="cpf">
                            <c:forEach var="professional" items="${professionals}">
                                <option value="${professional.cpf}">${professional.professionalName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label for="serviceId">Selecione o Serviço:</label>
                        <select name="serviceId" id="serviceId">
                            <c:forEach var="service" items="${services}">
                                <option value="${service.serviceName}">${service.serviceName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label for="paymentName">Selecione o Método de Pagamento:</label>
                        <select name="paymentName" id="paymentName">
                            <c:forEach var="paymentMethod" items="${paymentMethods}">
                                <option value="${paymentMethod.paymentName}">${paymentMethod.paymentName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div>
                        <label for="total">Total da Venda:</label>
                        <input type="text" name="total" id="total" oninput="formatCurrency(this)" required>
                    </div>

                    <div>
                        <button type="submit">Inserir Venda</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>


