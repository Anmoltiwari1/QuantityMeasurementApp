package com.example.UC12.SubstractionAndDivision.App;

import com.example.UC12.SubstractionAndDivision.util.LengthUnit;
import com.example.UC12.SubstractionAndDivision.util.VolumeUnit;
import com.example.UC12.SubstractionAndDivision.util.WeightUnit;

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
	        
	        //Volume Test
	        Quantity<VolumeUnit> v1=new Quantity<VolumeUnit>(1,VolumeUnit.LITER);
	        Quantity<VolumeUnit> v2=new Quantity<VolumeUnit>(1000,VolumeUnit.MILLILITER);
	        
	        System.out.println("Volume Equality: " + v1.equals(v2));
	        
	        Quantity<VolumeUnit> vConverted = v1.convertTo(VolumeUnit.GALLON);
	        System.out.println("Volume Conversion: " + vConverted);

	        Quantity<VolumeUnit> vAdd = v1.add(v2);
	        System.out.println("Volume Addition: " + vAdd);
	        
	        //Substraction Test
	        Quantity<LengthUnit> s1 = new Quantity<>(1, LengthUnit.FEET);
	        Quantity<LengthUnit> s2 = new Quantity<>(12, LengthUnit.INCHES);
	        
	        System.out.println("Substraction: "+s1.substraction(s2));
	        
	        //Division Test
	        Quantity<LengthUnit> d1 = new Quantity<>(1, LengthUnit.FEET);
	        Quantity<LengthUnit> d2 = new Quantity<>(12, LengthUnit.INCHES);
	        
	        System.out.println("Division: "+d1.division(d2));
	}
}
