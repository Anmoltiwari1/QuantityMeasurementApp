package com.example.UC9.WeightMeasurementEquality.App;
import com.example.UC9.WeightMeasurementEquality.util.IMeasurable;


public class Quantity<U extends IMeasurable> {

	private final double value;
	private final U unit;
	
	public Quantity(double value,U unit) {
		
		if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");
        
		this.value=value;
		this.unit=unit;
	}
	
	public double toBase() {
		return unit.convertToBaseUnit(value);
	}
	
	
	//Equals
	public boolean equals(Object obj) {
		
		if(obj==null)
			return false;
		
		if(this == obj )
			return true;
		
		if(getClass()!=obj.getClass())
			return false;
		
		Quantity<?> other=(Quantity<?>)obj;
		
		if(this.unit.getClass()!=other.unit.getClass())
			return false;
		
		double thisBase=unit.convertToBaseUnit(value);
		double otherBase=other.unit.convertToBaseUnit(other.value);
		
		return Double.compare(thisBase, otherBase) == 0;
	}
	
	//Convert
	public Quantity<U> convertTo( U targetUnit) {
		
		if(targetUnit==null)
			throw new IllegalArgumentException("Value cannot be null");
		
		double baseValue=unit.convertToBaseUnit(value);
		double converted=targetUnit.convertFromBaseUnit(baseValue);
		
		return new Quantity<>(converted,targetUnit);
		
	}
	
	
	//add
	public Quantity<U> add(Quantity<U> other){
		return add(other,this.unit);
	}
	
	//add with target
	public Quantity<U> add(Quantity<U> other,U targetUnit){
		
		if(other==null || targetUnit==null)
			throw new IllegalArgumentException("Invalid Input");
		
		double sumBase=this.unit.convertFromBaseUnit(this.value)+other.unit.convertFromBaseUnit(other.value);
		
		return new Quantity<>(sumBase, targetUnit);
	}
	
	 @Override
	    public String toString() {
	        return value + " " + unit;
	    }

}
