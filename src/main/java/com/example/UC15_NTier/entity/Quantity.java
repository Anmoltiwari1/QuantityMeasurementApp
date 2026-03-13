package com.example.UC15_NTier.entity;
import com.example.UC15_NTierArchitecture.unit.IMeasurable;
import com.example.UC15_NTierArchitecture.unit.TemeratureUnit;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }
    
    private enum ArithmeticOperation{
    	
    	ADD{
    		public double compute(double a,double b) {
    			return a+b;
    		}
    	},
    	SUBTRACT{
    		public double compute(double a,double b) {
    			return a-b;
    		}
    	},
    	
    	DIVIDE{
    		public double compute(double a,double b) {
    			if(b==0)
    				throw new ArithmeticException("Division By zero");
    			return a/b;
    		}
    	};
    	
    	public abstract double compute(double a,double b);
    }
    
    private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetUnitRequired) {

        if (other == null)
            throw new IllegalArgumentException("Quantity cannot be null");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross category operation not allowed");

        if (Double.isNaN(other.value) || Double.isInfinite(other.value))
            throw new IllegalArgumentException("Invalid value");

        if (targetUnitRequired && targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
        
       unit.validateOperationSupport("Arithmetic Operation");
    }
    
    private double performBaseArithmetic(Quantity<U> other, ArithmeticOperation operation) {

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return operation.compute(base1, base2);
    }
    
    public double roundTwoDecimal(double value) {
    	return Math.round(value*100.0)/100;
    }

    public Quantity<U> convertTo(U targetUnit) {
    	
    	if (unit.getClass().equals(TemeratureUnit.class)) {

            double converted = ((TemeratureUnit) unit).convertTo(value, (TemeratureUnit) targetUnit);
            return new Quantity<>(converted, targetUnit);
        }

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);
    	
    	double baseResult=performBaseArithmetic(other,ArithmeticOperation.ADD);
    	
    	double result=targetUnit.convertFromBaseUnit(baseResult);
    	
    	return new Quantity<>(roundTwoDecimal(result),targetUnit);
    }
    
    

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Quantity<?> other)) return false;

        if (!unit.getClass().equals(other.unit.getClass())) return false;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Double.compare(base1, base2) == 0;
    }
    
    public Quantity<U> subtract(Quantity<U> other,U targetUnit){
    	
    	validateArithmeticOperands(other, targetUnit, true);

        double baseResult = performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);

        double result = targetUnit.convertFromBaseUnit(baseResult);

        return new Quantity<>(roundTwoDecimal(result), targetUnit);
    	
    }
    
    public double division(Quantity<U> other) {
    	
    	validateArithmeticOperands(other, null, false);

        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }

    @Override
    public int hashCode() {

        double baseValue = unit.convertToBaseUnit(value);
        return Double.hashCode(baseValue);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }

}
