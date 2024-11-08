package dto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.PaymentMethod;

public class PaymentMethodDTO {
    private Connection conn;
    
    public PaymentMethodDTO(Connection conn) {
        this.conn = conn;
    }

    // Método para obter todos os métodos de pagamento
    public List<PaymentMethod> getAllPaymentMethods() {
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        String sql = "SELECT paymentName FROM PaymentMethod";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String paymentName = rs.getString("paymentName");
                paymentMethods.add(new PaymentMethod(paymentName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentMethods;
    }
}
