package servlet;

import java.io.IOException;
import java.util.List;

import dto.PaymentMethodDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PaymentMethod;

@WebServlet("/paymentMethod")
public class PaymentMethodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Carregar todos os métodos de pagamento
    	PaymentMethodDTO dao = new PaymentMethodDTO();
        List<PaymentMethod> paymentMethods = dao.getAllPaymentMethods();

        // Definir como atributo para o JSP
        request.setAttribute("paymentMethods", paymentMethods);

        // Encaminhar para o JSP
        request.getRequestDispatcher("sellingInsert.jsp").forward(request, response);
    }
}
