
package com.mycompany.projetoe;

import com.mycompany.projetoe.databaseDatabaseConnection;
import com.mycompany.projetoe.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public boolean registerUser(User user) throws SQLException {
        String sql = "INSERT INTO Users (nome, endereco, numero_conta, senha, saldo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEndereco());
            stmt.setString(3, user.getNumeroConta());
            stmt.setString(4, user.getSenha());
            stmt.setDouble(5, user.getSaldo());
            return stmt.executeUpdate() > 0;
        }
    }

    public User authenticateUser(String numeroConta, String senha) throws SQLException {
        String sql = "SELECT * FROM Users WHERE numero_conta = ? AND senha = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, numeroConta);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setEndereco(rs.getString("endereco"));
                user.setNumeroConta(rs.getString("numero_conta"));
                user.setSenha(rs.getString("senha"));
                user.setSaldo(rs.getDouble("saldo"));
                return user;
            }
        }
        return null;
    }

    public double getUserBalance(int userId) throws SQLException {
        String sql = "SELECT saldo FROM Users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("saldo");
            }
        }
        return 0;
    }

    public boolean updateUserBalance(int userId, double amount) throws SQLException {
        String sql = "UPDATE Users SET saldo = saldo + ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, userId);
            return stmt.executeUpdate() > 0;
        }
    }
}