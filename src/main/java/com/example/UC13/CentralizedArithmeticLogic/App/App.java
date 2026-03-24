package com.example.UC13.CentralizedArithmeticLogic.App;

import com.example.UC13.CentralizedArithmeticLogic.util.LengthUnit;
import com.example.UC13.CentralizedArithmeticLogic.util.VolumeUnit;
import com.example.UC13.CentralizedArithmeticLogic.util.WeightUnit;

public class App {

    public static void main(String[] args) {

        // ================= LENGTH =================
        Quantity<LengthUnit> l1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(12, LengthUnit.INCHES);

        System.out.println("Length Equality: " + l1.equals(l2));

        Quantity<LengthUnit> lConverted = l1.convertTo(LengthUnit.INCHES);
        System.out.println("Length Conversion: " + lConverted);

        Quantity<LengthUnit> lAdd = l1.add(l2);
        System.out.println("Length Addition: " + lAdd);

        Quantity<LengthUnit> lSub = l1.substraction(l2);
        System.out.println("Length Subtraction: " + lSub);

        System.out.println("Length Division: " + l1.division(l2));

        Quantity<LengthUnit> lMul = l1.multiply(l2);
        System.out.println("Length Multiplication: " + lMul);


        // ================= WEIGHT =================
        Quantity<WeightUnit> w1 = new Quantity<>(1, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(1000, WeightUnit.GRAM);

        System.out.println("Weight Equality: " + w1.equals(w2));

        Quantity<WeightUnit> wConverted = w1.convertTo(WeightUnit.GRAM);
        System.out.println("Weight Conversion: " + wConverted);

        Quantity<WeightUnit> wAdd = w1.add(w2);
        System.out.println("Weight Addition: " + wAdd);

        Quantity<WeightUnit> wSub = w1.substraction(w2);
        System.out.println("Weight Subtraction: " + wSub);

        System.out.println("Weight Division: " + w1.division(w2));

        Quantity<WeightUnit> wMul = w1.multiply(w2);
        System.out.println("Weight Multiplication: " + wMul);


        // ================= VOLUME =================
        Quantity<VolumeUnit> v1 = new Quantity<>(1, VolumeUnit.LITER);
        Quantity<VolumeUnit> v2 = new Quantity<>(1000, VolumeUnit.MILLILITER);

        System.out.println("Volume Equality: " + v1.equals(v2));

        Quantity<VolumeUnit> vConverted = v1.convertTo(VolumeUnit.GALLON);
        System.out.println("Volume Conversion: " + vConverted);

        Quantity<VolumeUnit> vAdd = v1.add(v2);
        System.out.println("Volume Addition: " + vAdd);

        Quantity<VolumeUnit> vSub = v1.substraction(v2);
        System.out.println("Volume Subtraction: " + vSub);

        System.out.println("Volume Division: " + v1.division(v2));

        Quantity<VolumeUnit> vMul = v1.multiply(v2);
        System.out.println("Volume Multiplication: " + vMul);


        // ================= CROSS CATEGORY =================
        System.out.println("Cross Equality (Length vs Weight): " + l1.equals(w1));
    }
}