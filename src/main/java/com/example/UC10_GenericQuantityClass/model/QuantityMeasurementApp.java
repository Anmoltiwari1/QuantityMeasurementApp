package com.example.UC10_GenericQuantityClass.model;

import com.example.UC10_GenericQuantityClass.unit.LengthUnit;
import com.example.UC10_GenericQuantityClass.unit.WeightUnit;

public class QuantityMeasurementApp {
	public static void main(String[] args) {

        // Length Equality
        Quantity<LengthUnit> q1 = new Quantity<>(1.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(12.0, LengthUnit.INCHES);

        System.out.println("1 foot == 12 inches : " + q1.equals(q2));

        // Length Conversion
        System.out.println("1 foot in inches : " + q1.convertTo(LengthUnit.INCHES));

        // Length Addition
        System.out.println("1 foot + 12 inches : " +
                q1.add(q2, LengthUnit.FEET));


        // Weight Equality
        Quantity<WeightUnit> w1 = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("1 kg == 1000 g : " + w1.equals(w2));

        // Weight Conversion
        System.out.println("1 kg in grams : " + w1.convertTo(WeightUnit.GRAM));

        // Weight Addition
        System.out.println("1 kg + 1000 g : " +
                w1.add(w2, WeightUnit.KILOGRAM));
    }
}
