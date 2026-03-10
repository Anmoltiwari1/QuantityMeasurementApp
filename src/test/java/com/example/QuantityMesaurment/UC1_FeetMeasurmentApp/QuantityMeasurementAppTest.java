package com.example.QuantityMesaurment.UC1_FeetMeasurmentApp;
import org.junit.jupiter.api.Test;

import com.example.QuantityMesaurment.UC1_FeetMeasurmentApp.App.QuantityMeasurementApp;

import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // GIVEN same value WHEN compared THEN should be equal
    @Test
    void testEquality_SameValue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(f1.equals(f2), "1.0 ft should equal 1.0 ft");
    }

    // GIVEN different values WHEN compared THEN should not be equal
    @Test
    void testEquality_DifferentValue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);

        assertFalse(f1.equals(f2), "1.0 ft should not equal 2.0 ft");
    }

    // GIVEN value WHEN compared with null THEN should return false
    @Test
    void testEquality_NullComparison() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertFalse(f1.equals(null), "Value should not equal null");
    }

    // GIVEN value WHEN compared with different type THEN should return false
    @Test
    void testEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        String notFeet = "Not a Feet object";

        assertFalse(f1.equals(notFeet), "Feet should not equal non Feet object");
    }

    // GIVEN same reference WHEN compared THEN should return true (reflexive)
    @Test
    void testEquality_SameReference() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);

        assertTrue(f1.equals(f1), "Object should equal itself");
    }
}
