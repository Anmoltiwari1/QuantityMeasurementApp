package com.example.UC16_JDBC.entity;

import java.time.LocalDateTime;

public class QuantityMeasurementEntity {
	 private int id;
	    private double value;
	    private String unit;
	    private String operation;
	    private LocalDateTime createdAt;

	    public QuantityMeasurementEntity() {}

	    public QuantityMeasurementEntity(double value, String unit, String operation) {
	        this.value = value;
	        this.unit = unit;
	        this.operation = operation;
	        this.createdAt = LocalDateTime.now();
	    }

	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public double getValue() { return value; }
	    public void setValue(double value) { this.value = value; }

	    public String getUnit() { return unit; }
	    public void setUnit(String unit) { this.unit = unit; }

	    public String getOperation() { return operation; }
	    public void setOperation(String operation) { this.operation = operation; }

	    public LocalDateTime getCreatedAt() { return createdAt; }
	    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
	    
	    @Override
	    public String toString() {
	        return "QuantityMeasurementEntity{" +
	                "id=" + id +
	                ", value=" + value +
	                ", unit='" + unit + '\'' +
	                ", operation='" + operation + '\'' +
	                ", createdAt=" + createdAt +
	                '}';
	    }
}
