package dto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Professional;

public class ProfessionalDTO {

    private Connection conn;

    public ProfessionalDTO(Connection conn) {
        this.conn = conn;
    }

    public void saveProfessional(Professional professional) throws SQLException {
        String sql = "INSERT INTO Professional(cpf, professionalName, isActive) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, professional.getCpf());
            stmt.setString(2, professional.getProfessionalName());
            stmt.setBoolean(3, professional.isActive());
            stmt.executeUpdate();
        }
    }

    public List<Professional> getAllProfessionals() throws SQLException {
        List<Professional> professionals = new ArrayList<>();
        String sql = "SELECT * FROM Professional";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Professional professional = new Professional();
                professional.setProfessionalId(rs.getInt("professionalId"));
                professional.setCpf(rs.getString("cpf"));
                professional.setProfessionalName(rs.getString("professionalName"));
                professional.setActive(rs.getBoolean("isActive"));
                professionals.add(professional);
            }
        }
        return professionals;
    }

    public void updateProfessional(Professional professional) throws SQLException {
        String sql = "UPDATE Professional SET professionalName = ?, isActive = ? WHERE cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, professional.getProfessionalName());
            stmt.setBoolean(2, professional.isActive());
            stmt.setString(3, professional.getCpf());
            stmt.executeUpdate();
        }
    }

    public void deleteProfessional(String cpf) throws SQLException {
        String sql = "DELETE FROM Professional WHERE cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
        }
    }

    public Professional getProfessionalByCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM Professional WHERE cpf = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Professional professional = new Professional();
                    professional.setProfessionalId(rs.getInt("professionalId"));
                    professional.setCpf(rs.getString("cpf"));
                    professional.setProfessionalName(rs.getString("professionalName"));
                    professional.setActive(rs.getBoolean("isActive"));
                    return professional;
                }
            }
        }
        return null;
    }
}
