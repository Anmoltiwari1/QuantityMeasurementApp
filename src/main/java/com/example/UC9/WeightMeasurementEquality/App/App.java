package com.example.UC9.WeightMeasurementEquality.App;

import com.example.UC9.WeightMeasurementEquality.util.LengthUnit;
import com.example.UC9.WeightMeasurementEquality.util.WeightUnit;

public class App {

	public static void main(String[] args) {
		
		 Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
	        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

	        System.out.println("Length Equality: " + l1.equals(l2));

	        Quantity<LengthUnit> lConverted = l1.convertTo(LengthUnit.INCHES);
	        System.out.println("Length Conversion: " + lConverted);

	        Quantity<LengthUnit> lAdd = l1.add(l2);
	        System.out.println("Length Addition: " + lAdd);


	        // WEIGHT TEST
	        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KILOGRAM);
	        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.GRAM);

	        System.out.println("Weight Equality: " + w1.equals(w2));

	        Quantity<WeightUnit> wConverted = w1.convertTo(WeightUnit.GRAM);
	        System.out.println("Weight Conversion: " + wConverted);

	        Quantity<WeightUnit> wAdd = w1.add(w2);
	        System.out.println("Weight Addition: " + wAdd);


	        // CROSS CATEGORY (SHOULD BE FALSE)
	        System.out.println("Cross Equality: " + l1.equals(w1));
	}
}
