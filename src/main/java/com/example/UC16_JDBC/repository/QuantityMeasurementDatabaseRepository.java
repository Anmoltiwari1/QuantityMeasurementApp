package com.example.UC16_JDBC.repository;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.List;
import com.example.UC16_JDBC.entity.QuantityMeasurementEntity;
import com.example.UC16_JDBC.exception.DatabaseException;


public class QuantityMeasurementDatabaseRepository implements IQuantityMeasurementRepository{
	private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public QuantityMeasurementDatabaseRepository() {
        createTable();
    }

    private void createTable() {
    	String sql = "CREATE TABLE IF NOT EXISTS quantity_measurement (" +
    	        "id INT AUTO_INCREMENT PRIMARY KEY," +
    	        "measurement_value DOUBLE," +
    	        "unit VARCHAR(50)," +
    	        "operation VARCHAR(50)," +
    	        "created_at TIMESTAMP" +
    	        ")";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            throw new DatabaseException("Error creating table", e);
        }
    }

    public void save(QuantityMeasurementEntity entity) {
    	String sql = "INSERT INTO quantity_measurement(measurement_value, unit, operation, created_at) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, entity.getValue());
            ps.setString(2, entity.getUnit());
            ps.setString(3, entity.getOperation());
            ps.setTimestamp(4, Timestamp.valueOf(entity.getCreatedAt()));

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Error saving entity", e);
        }
    }

    public List<QuantityMeasurementEntity> getAll() {
        List<QuantityMeasurementEntity> list = new ArrayList<>();
        String sql = "SELECT * FROM quantity_measurement";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
                entity.setId(rs.getInt("id"));
                entity.setValue(rs.getDouble("measurement_value"));
                entity.setUnit(rs.getString("unit"));
                entity.setOperation(rs.getString("operation"));
                entity.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

                list.add(entity);
            }

        } catch (SQLException e) {
            throw new DatabaseException("Error fetching data", e);
        }

        return list;
    }

    public int getTotalCount() {
        String sql = "SELECT COUNT(*) FROM quantity_measurement";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DatabaseException("Error counting data", e);
        }

        return 0;
    }

    public void deleteAll() {
        String sql = "DELETE FROM quantity_measurement";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Error deleting data", e);
        }
    }
}
