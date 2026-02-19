package com.example.UC2_FeetAndInchesMeasurementEquality.UC2;

public class QuantityMeasurementApp {

    // ----------- FEET CLASS -----------
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet feet = (Feet) obj;
            return Double.compare(feet.value, value) == 0;
        }
    }

    // ----------- INCHES CLASS -----------
    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inches inches = (Inches) obj;
            return Double.compare(inches.value, value) == 0;
        }
    }

    // ----------- STATIC METHODS (UC2 requirement) -----------

    public static boolean compareFeet(double v1, double v2) {
        Feet f1 = new Feet(v1);
        Feet f2 = new Feet(v2);
        return f1.equals(f2);
    }

    public static boolean compareInches(double v1, double v2) {
        Inches i1 = new Inches(v1);
        Inches i2 = new Inches(v2);
        return i1.equals(i2);
    }

    // ----------- MAIN METHOD FOR DEMO -----------

    public static void main(String[] args) {
        System.out.println("1 ft vs 1 ft : " + compareFeet(1.0, 1.0));
        System.out.println("1 inch vs 1 inch : " + compareInches(1.0, 1.0));
    }
}