package com.example.UC15_NTier.app;

import com.example.UC15_NTier.entity.Quantity;
import com.example.UC15_NTierArchitecture.unit.LengthUnit;
import com.example.UC15_NTierArchitecture.unit.VolumeUnit;
import com.example.UC15_NTierArchitecture.unit.WeightUnit;

public class QuantityMeasurementApp {
	 public static void main(String[] args) {

	        // ---------------- LENGTH ----------------

	        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
	        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCHES);

	        System.out.println("10 feet == 120 inches : " +
	                l1.equals(new Quantity<>(120.0, LengthUnit.INCHES)));

	        System.out.println("10 feet in inches : " +
	                l1.convertTo(LengthUnit.INCHES));

	        System.out.println("10 feet + 6 inches : " +
	                l1.add(l2, LengthUnit.FEET));

	        // Subtraction
	        System.out.println("10 feet - 6 inches (in feet) : " +
	                l1.subtract(l2, LengthUnit.FEET));

	        System.out.println("10 feet - 6 inches (in inches) : " +
	                l1.subtract(l2, LengthUnit.INCHES));

	        // Negative subtraction
	        Quantity<LengthUnit> l3 = new Quantity<>(5.0, LengthUnit.FEET);
	        System.out.println("5 feet - 10 feet : " +
	                l3.subtract(l1, LengthUnit.FEET));

	        // Zero subtraction
	        Quantity<LengthUnit> l4 = new Quantity<>(120.0, LengthUnit.INCHES);
	        System.out.println("10 feet - 120 inches : " +
	                l1.subtract(l4, LengthUnit.FEET));

	        // Division
	        System.out.println("10 feet / 2 feet : " +
	                l1.division(new Quantity<>(2.0, LengthUnit.FEET)));

	        System.out.println("24 inches / 2 feet : " +
	                new Quantity<>(24.0, LengthUnit.INCHES)
	                        .division(new Quantity<>(2.0, LengthUnit.FEET)));



	        // ---------------- WEIGHT ----------------

	        Quantity<WeightUnit> w1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
	        Quantity<WeightUnit> w2 = new Quantity<>(5000.0, WeightUnit.GRAM);

	        System.out.println("\n10 kg == 10000 g : " +
	                w1.equals(new Quantity<>(10000.0, WeightUnit.GRAM)));

	        System.out.println("10 kg in grams : " +
	                w1.convertTo(WeightUnit.GRAM));

	        System.out.println("10 kg + 5000 g : " +
	                w1.add(w2, WeightUnit.KILOGRAM));

	        System.out.println("10 kg - 5000 g : " +
	                w1.subtract(w2, WeightUnit.KILOGRAM));

	        System.out.println("10 kg - 5000 g (grams) : " +
	                w1.subtract(w2, WeightUnit.GRAM));

	        System.out.println("10 kg / 5 kg : " +
	                w1.division(new Quantity<>(5.0, WeightUnit.KILOGRAM)));



	        // ---------------- VOLUME ----------------

	        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
	        Quantity<VolumeUnit> v2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

	        System.out.println("\n5 litre in ml : " +
	                v1.convertTo(VolumeUnit.MILLILITRE));

	        System.out.println("5 litre + 500 ml : " +
	                v1.add(v2, VolumeUnit.LITRE));

	        System.out.println("5 litre - 500 ml : " +
	                v1.subtract(v2, VolumeUnit.LITRE));

	        System.out.println("5 litre - 500 ml (ml) : " +
	                v1.subtract(v2, VolumeUnit.MILLILITRE));

	        System.out.println("5 litre / 10 litre : " +
	                v1.division(new Quantity<>(10.0, VolumeUnit.LITRE)));
	    }
}
