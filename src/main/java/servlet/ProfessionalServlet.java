package servlet;

import dto.ConnectionFactory;
import dto.ProfessionalDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Professional;
import utils.PopupUtils;

import java.io.*;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/professional")
public class ProfessionalServlet extends HttpServlet {

    private ProfessionalDTO professionalDTO;

    @Override
    public void init() throws ServletException {
        try {
            
            Connection conn = ConnectionFactory.getConnection();
            professionalDTO = new ProfessionalDTO(conn); // Passa a conexão para o DTO
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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("list".equals(action)) {
                List<Professional> professionals = professionalDTO.getAllProfessionals();
                
                /* Imprimir cada profissional na lista no log (console)
                for (Professional professional : professionals) {
                    System.out.println(professional);  // Chama o método toString() do objeto
                }*/
                
                request.setAttribute("professionals", professionals);
               
                RequestDispatcher dispatcher = request.getRequestDispatcher("listProfessionals.jsp");
                dispatcher.forward(request, response);
            
            } else if ("edit".equals(action)) {
                String cpf = request.getParameter("cpf");
                String name = request.getParameter("professionalName");
                boolean isActive = "on".equals(request.getParameter("isActive"));
                
                Professional professional = new Professional();
                professional.setCpf(cpf);
                professional.setProfessionalName(name);
                professional.setActive(isActive);
                System.out.println(professional.toString());
                
                professionalDTO.updateProfessional(professional);  // Chama o método de exclusão no DAO
                PopupUtils.setPopupMessage(request, "Aviso", "Esta é uma mensagem de aviso.", "info");
                
                // Redireciona para a lista de profissionais após a exclusão
                response.sendRedirect("professional?action=list");
            }else if ("delete".equals(action)) {
                String cpf = request.getParameter("cpf");
                
                
                professionalDTO.deleteProfessional(cpf);  // Chama o método de exclusão no DAO
                PopupUtils.setPopupMessage(request, "Aviso", "Esta é uma mensagem de aviso.", "info");
                
                // Redireciona para a lista de profissionais após a exclusão
                response.sendRedirect("professional?action=list");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String cpf = request.getParameter("cpf");
            String name = request.getParameter("name");
            boolean isActive = "on".equals(request.getParameter("isActive"));

            Professional professional = new Professional();
            professional.setCpf(cpf);
            professional.setProfessionalName(name);
            professional.setActive(isActive);
            try {
                professionalDTO.saveProfessional(professional);
                response.sendRedirect("professional?action=list");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

