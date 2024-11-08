package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import dto.SellingDTO;

public class SellingDTO {

    private Connection connection;

    public SellingModel(Connection connection) {
        this.connection = connection;
    }

    public boolean insertSale(SellingDTO sellingDTO) throws SQLException {
        String query = "INSERT INTO Selling (cpf, paymentName, total, sellingDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, sellingDTO.getCpf());
            stmt.setString(2, sellingDTO.getPaymentName());
            stmt.setDouble(3, sellingDTO.getTotal());
            stmt.setDate(4,java.sql.Date.valueOf(sellingDTO.getSellingDate()));
            return stmt.executeUpdate() > 0;
        }
    }
}