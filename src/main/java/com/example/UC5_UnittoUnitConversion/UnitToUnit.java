package com.example.UC5_UnittoUnitConversion;



public class UnitToUnit {

    private final double value;
    private final LengthUnit unit;

    public UnitToUnit(double value, LengthUnit unit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    // Convert this instance to target unit and return numeric value
    public double convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double valueInFeet = unit.toFeet(value);
        return valueInFeet / targetUnit.toFeet(1);
    }

    // Static helper for direct conversion without creating an instance
    public static double convert(double value, LengthUnit from, LengthUnit to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be finite");
        }
        double valueInFeet = from.toFeet(value);
        return valueInFeet / to.toFeet(1);
    }

    // Optional: Equality based on normalized value
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UnitToUnit other)) return false;
        double thisInFeet = this.unit.toFeet(this.value);
        double otherInFeet = other.unit.toFeet(other.value);
        return Math.abs(thisInFeet - otherInFeet) < 1e-6; // epsilon for floating-point
    }

    @Override
    public String toString() {
        return String.format("%.6f %s", value, unit.name());
    }

    // Demo
    public static void main(String[] args) {
        UnitToUnit lengthInYards = new UnitToUnit(3, LengthUnit.YARDS);
        UnitToUnit lengthInFeet = new UnitToUnit(9, LengthUnit.FEET);

        System.out.println("3 Yards in Feet: " + lengthInYards.convertTo(LengthUnit.FEET)); // 9.0
        System.out.println("9 Feet in Yards: " + lengthInFeet.convertTo(LengthUnit.YARDS)); // 3.0

        System.out.println("3 Yards in Inches: " + lengthInYards.convertTo(LengthUnit.INCH)); // 108.0
        System.out.println("36 Inches in Yards: " + new UnitToUnit(36, LengthUnit.INCH).convertTo(LengthUnit.YARDS)); // 1.0

        // Using static helper
        System.out.println("1 cm in Inches: " + UnitToUnit.convert(1, LengthUnit.CENTIMETERS, LengthUnit.INCH)); // ~0.393701

        // Equality check
        UnitToUnit q1 = new UnitToUnit(1, LengthUnit.YARDS);
        UnitToUnit q2 = new UnitToUnit(3, LengthUnit.FEET);
        System.out.println(q1 + " equals " + q2 + " ? " + q1.equals(q2)); // true
    }
}