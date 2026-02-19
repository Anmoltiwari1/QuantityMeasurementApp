package com.example.UC2_FeetAndInchesMeasurementEquality;

import org.junit.jupiter.api.Test;

import com.example.UC2_FeetAndInchesMeasurementEquality.UC2.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    // ---------- FEET TESTS ----------

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.compareFeet(1.0, 1.0));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.compareFeet(1.0, 2.0));
    }

    @Test
    void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet.equals(null));
    }

    @Test
    void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(feet.equals(feet));
    }

    @Test
    void testFeetEquality_DifferentType() {
        QuantityMeasurementApp.Feet feet = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(feet.equals("not a number"));
    }


    // ---------- INCH TESTS ----------

    @Test
    void testInchEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.compareInches(1.0, 1.0));
    }

    @Test
    void testInchEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.compareInches(1.0, 2.0));
    }

    @Test
    void testInchEquality_NullComparison() {
        QuantityMeasurementApp.Inches inch = new QuantityMeasurementApp.Inches(1.0);
        assertFalse(inch.equals(null));
    }

    @Test
    void testInchEquality_SameReference() {
        QuantityMeasurementApp.Inches inch = new QuantityMeasurementApp.Inches(1.0);
        assertTrue(inch.equals(inch));
    }

    @Test
    void testInchEquality_DifferentType() {
        QuantityMeasurementApp.Inches inch = new QuantityMeasurementApp.Inches(1.0);
        assertFalse(inch.equals(100));
    }
}
