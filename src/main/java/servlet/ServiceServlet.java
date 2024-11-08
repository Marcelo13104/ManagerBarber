package servlet;

import java.io.IOException;
import java.util.List;

import dto.ServiceDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Service;

@WebServlet("/service")
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Carregar todos os serviços
        ServiceDTO dao = new ServiceDTO();
        List<Service> services = dao.getAllServices();

        // Definir como atributo para o JSP
        request.setAttribute("services", services);

        // Encaminhar para o JSP
        request.getRequestDispatcher("sellingInsert.jsp").forward(request, response);
    }
}
