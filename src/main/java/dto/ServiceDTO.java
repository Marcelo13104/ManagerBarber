package dto;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Service;

public class ServiceDTO {
	private Connection conn;
	
	public ServiceDTO(Connection conn) {
        this.conn = conn;
    }
    // Método para obter todos os serviços
    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT isActive, serviceName, price FROM Service";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                boolean isActive = rs.getBoolean("isActive");
                String serviceName = rs.getString("serviceName");
                double price = rs.getDouble("price");

                services.add(new Service(isActive, serviceName, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }
}
