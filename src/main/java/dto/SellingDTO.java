package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import dto.SellingDTO;
import model.Selling;

public class SellingDTO {

    private Connection connection;

    public SellingDTO(Connection connection) {
        this.connection = connection;
    }

    public boolean insertSale(Selling selling) throws SQLException {
        String query = "INSERT INTO Selling (cpf, paymentName, total, sellingDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, selling.getCpf());
            stmt.setString(2, selling.getPaymentName());
            stmt.setDouble(3, selling.getTotal());
            stmt.setDate(4,java.sql.Date.valueOf(selling.getSellingDate()));
            return stmt.executeUpdate() > 0;
        }
    }
}