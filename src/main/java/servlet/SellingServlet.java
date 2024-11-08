package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.ConnectionFactory;
import dto.PaymentMethodDTO;
import dto.ProfessionalDTO;
import dto.SellingDTO;
import dto.ServiceDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PaymentMethod;
import model.Professional;
import model.SellingModel;
import model.Service;

@WebServlet("/selling")
public class SellingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    ProfessionalDTO professionalDTO;
    ServiceDTO serviceDTO;
    PaymentMethodDTO paymentMethodDTO;
    
    @Override
    public void init() throws ServletException {
        try {
            
            Connection conn = ConnectionFactory.getConnection();
            professionalDTO = new ProfessionalDTO(conn); // Passa a conexão para o DTO
            serviceDTO = new ServiceDTO(conn);
            paymentMethodDTO = new PaymentMethodDTO(conn);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso.");

        } catch (SQLException e) {
            // Log detalhado caso haja erro de conexão com o banco de dados
            getServletContext().log("Erro ao conectar ao banco de dados", e);
            throw new ServletException("Erro de conexão com o banco de dados", e);
        } catch (Exception e) {
            // Log para capturar qualquer outro erro
            getServletContext().log("Erro inesperado ao inicializar o servlet", e);
            throw new ServletException("Erro inesperado", e);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
	        // Se a ação for "list", carregamos os dados
	        if ("list".equals(action)) {
	            // Carregar profissionais e serviços
	            List<Professional> professionals = professionalDTO.getAllProfessionals();
	            List<Service> services = serviceDTO.getAllServices();  // Aqui você carrega os serviços
	            List<PaymentMethod> paymentMethods = paymentMethodDTO.getAllPaymentMethods();
	            
	            // Passar os dados como atributos para o JSP
	            request.setAttribute("professionals", professionals);
	            request.setAttribute("services", services); 
	            request.setAttribute("paymentMethods", paymentMethods);// Passando a lista de serviços
	        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Encaminhar para o JSP
        request.getRequestDispatcher("sellingInsert.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera os parâmetros do formulário
    	LocalDate sellingDate = LocalDate.parse(request.getParameter("sellingDate"));
        String cpf = request.getParameter("cpf");
        String serviceName = request.getParameter("serviceName");
        String paymentName = request.getParameter("paymentName");
        double total = Double.parseDouble(request.getParameter("total").replace("R$ ", "").replace(",", ".").trim());
        
     // Imprime os valores para verificação
        System.out.println("Data de venda: " + sellingDate);
        System.out.println("CPF: " + cpf);
        System.out.println("Nome do Serviço: " + serviceName);
        System.out.println("Nome do Método de Pagamento: " + paymentName);
        System.out.println("Total: " + total);
        // Cria o DTO
        SellingDTO sellingDTO = new SellingDTO();
        sellingDTO.setSellingDate(sellingDate);
        sellingDTO.setCpf(cpf);
        sellingDTO.setServiceName(serviceName);
        sellingDTO.setPaymentName(paymentName);
        sellingDTO.setTotal(total);

        // Conectar ao banco de dados e inserir
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();// Ajuste com suas credenciais
            SellingModel sellingModel = new SellingModel(connection);
            if (sellingModel.insertSale(sellingDTO)) {
                response.sendRedirect("selling?action=list");
            } else {
                response.getWriter().println("Erro ao inserir venda.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao conectar com o banco de dados.");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}