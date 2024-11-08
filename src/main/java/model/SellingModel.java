package model;

//SellingModel.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.SellingDTO;

public class SellingModel {

 private Connection connection;

 public SellingModel(Connection connection) {
     this.connection = connection;
 }

 public boolean insertSale(SellingDTO sellingDTO) throws SQLException {
     String query = "INSERT INTO Selling (cpf, serviceId, paymentName, total, sellingDate) VALUES (?, ?, ?, ?, CURDATE())";
     try (PreparedStatement stmt = connection.prepareStatement(query)) {
         stmt.setString(1, sellingDTO.getCpf());
         stmt.setInt(2, sellingDTO.getServiceId());
         stmt.setString(3, sellingDTO.getPaymentName());
         stmt.setDouble(4, sellingDTO.getTotal());
         return stmt.executeUpdate() > 0;
     }
 }
}

