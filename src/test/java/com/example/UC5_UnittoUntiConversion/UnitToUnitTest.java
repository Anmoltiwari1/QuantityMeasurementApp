package com.example.UC5_UnittoUntiConversion;


import org.junit.jupiter.api.Test;

import com.example.UC5_UnittoUnitConversion.LengthUnit;
import com.example.UC5_UnittoUnitConversion.UnitToUnit;

import static org.junit.jupiter.api.Assertions.*;

public class UnitToUnitTest {

	private static final double EPSILON = 1e-6;

    @Test
    void testConversion_FeetToInches() {
        double result = UnitToUnit.convert(1.0, LengthUnit.FEET, LengthUnit.INCH);
        assertEquals(12.0, result, EPSILON);
    }

    @Test
    void testConversion_InchesToFeet() {
        double result = UnitToUnit.convert(24.0, LengthUnit.INCH, LengthUnit.FEET);
        assertEquals(2.0, result, EPSILON);
    }

    @Test
    void testConversion_YardsToInches() {
        double result = UnitToUnit.convert(1.0, LengthUnit.YARDS, LengthUnit.INCH);
        assertEquals(36.0, result, EPSILON);
    }

    @Test
    void testConversion_CentimetersToInches() {
        double result = UnitToUnit.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCH);
        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testConversion_RoundTrip_PreservesValue() {
        double original = 5.75;

        double toInches = UnitToUnit.convert(original, LengthUnit.FEET, LengthUnit.INCH);
        double backToFeet = UnitToUnit.convert(toInches, LengthUnit.INCH, LengthUnit.FEET);

        assertEquals(original, backToFeet, EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {
        double result = UnitToUnit.convert(0.0, LengthUnit.FEET, LengthUnit.INCH);
        assertEquals(0.0, result, EPSILON);
    }

    @Test
    void testConversion_NegativeValue() {
        double result = UnitToUnit.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH);
        assertEquals(-12.0, result, EPSILON);
    }

    @Test
    void testConversion_SameUnit() {
        double result = UnitToUnit.convert(5.0, LengthUnit.FEET, LengthUnit.FEET);
        assertEquals(5.0, result, EPSILON);
    }

    @Test
    void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> UnitToUnit.convert(1.0, null, LengthUnit.FEET));

        assertThrows(IllegalArgumentException.class,
                () -> UnitToUnit.convert(1.0, LengthUnit.FEET, null));
    }

    @Test
    void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> UnitToUnit.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH));

        assertThrows(IllegalArgumentException.class,
                () -> UnitToUnit.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCH));
    }

    @Test
    void testEquality_NormalizedComparison() {
        UnitToUnit q1 = new UnitToUnit(1, LengthUnit.YARDS);
        UnitToUnit q2 = new UnitToUnit(3, LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }
}
