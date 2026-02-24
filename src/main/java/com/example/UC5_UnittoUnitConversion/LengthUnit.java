package com.example.UC5_UnittoUnitConversion;

public enum LengthUnit {

    FEET(1.0), // Base unit
    INCH(1.0 / 12.0), // 1 inch = 1/12 feet
    YARDS(3.0), // 1 yard = 3 feet
    CENTIMETERS(0.393701 / 12.0); // 1 cm = 0.393701 inch = (0.393701/12) feet

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    public double toFeet(double value) {
        return value * toFeetFactor;
    }
}
