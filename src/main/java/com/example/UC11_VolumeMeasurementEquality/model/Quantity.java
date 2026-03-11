package com.example.UC11_VolumeMeasurementEquality.model;

import com.example.UC11_VolumeMeasurementEquality.unit.IMeasurable;

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

    public Quantity<U> convertTo(U targetUnit) {

        double baseValue = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new Quantity<>(converted, targetUnit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        double sumBase = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, targetUnit);
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
    	
    	if(other==null || targetUnit==null)
    		throw new IllegalArgumentException("Value cannot be null");
    	
    	double base1=unit.convertToBaseUnit(value);
    	double base2=other.unit.convertToBaseUnit(other.value);
    	
    	double res=base1-base2;
    	
    	double result=targetUnit.convertFromBaseUnit(res);
    	
    	result=Math.round(result*100.0)/100.0;
    	
    	return new Quantity<>(result,targetUnit);
    	
    }
    
    public double division(Quantity<U> other) {
    	
    	if(other==null)
    		throw new IllegalArgumentException("Value cannot be null");
    	
    	double base1=unit.convertToBaseUnit(value);
    	double base2=other.unit.convertToBaseUnit(other.value);
    	
    	if(base2==0)
    		throw new ArithmeticException("Division by zero");
    	
    	return base1/base2;
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