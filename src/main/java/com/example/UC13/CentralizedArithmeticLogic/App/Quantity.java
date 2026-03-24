package com.example.UC13.CentralizedArithmeticLogic.App;
import com.example.UC13.CentralizedArithmeticLogic.util.IMeasurable;


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
		
		return  Math.abs(thisBase - otherBase) < 0.0001;
	}
	
	//Convert
	public Quantity<U> convertTo( U targetUnit) {
		
		if(targetUnit==null)
			throw new IllegalArgumentException("Value cannot be null");
		
		
		double baseValue=unit.convertToBaseUnit(value);
		double converted=targetUnit.convertFromBaseUnit(baseValue);
		
		return new Quantity<>(converted,targetUnit);
		
	}
	
	private enum ArithmeticOperation{
		
		ADD{
			double apply(double a,double b) {
				return a+b;
			}
		},
		
		SUBTRACT{
			double apply(double a,double b) {
				return a-b;
			}
		},
		DIVIDE{
			double apply(double a,double b) {
				if(b==0)
					throw new ArithmeticException("Divide by zero");
				return a/b;
			}
		},
		MULTIPLY{
			double apply(double a,double b) {
				return a*b;
			}
		};
		
		abstract double apply(double a,double b);
	}
	
	private void validate(Quantity<U> other) {
		if(other==null)
			throw new IllegalArgumentException("Invalid Input");
		
		if(this.unit.getClass()!=other.unit.getClass())
			throw new IllegalArgumentException("Different categories");
		
		if(!Double.isFinite(this.value) || !Double.isFinite(other.value)) {
			throw new IllegalArgumentException("Invalid values");
		}
	}
	
	private double performBaseArithmetic(Quantity<U> other,ArithmeticOperation op) {
		
		validate(other);
		
		double a=this.toBase();
		double b=other.toBase();
		
		return op.apply(a,b);
	}
	
	
	//add
	public Quantity<U> add(Quantity<U> other){
		return add(other,this.unit);
	}
	
	//add with target
	public Quantity<U> add(Quantity<U> other,U targetUnit){
		
		this.unit.validateOperationSupport("ADD");
		
		if(other==null || targetUnit==null)
			throw new IllegalArgumentException("Invalid Input");
		
		
		double baseResult=performBaseArithmetic(other,ArithmeticOperation.ADD);
		double result=targetUnit.convertFromBaseUnit(baseResult);
		
		return new Quantity<>(result, targetUnit);
	}
	
	//Subtract 
	public Quantity<U> substraction(Quantity<U> other,U targetUnit){
		
		this.unit.validateOperationSupport("SUBTRACT");
		
		if(targetUnit==null)
			throw new IllegalArgumentException("Invalid Input");
		
		
	    double baseResult=performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);
	    double result=targetUnit.convertFromBaseUnit(baseResult);
			 
		return new Quantity<>(result, targetUnit);
	}
	
	public Quantity<U> substraction(Quantity<U> other){
		return substraction(other,this.unit);
	}
	
	//Division
	public double division(Quantity<U> other){
		
		this.unit.validateOperationSupport("DIVIDE");
		
		return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
		
	}
	
	public Quantity<U> multiply(Quantity<U> other,U targetUnit) {
		
		this.unit.validateOperationSupport("MULTIPLY"); 
		
		if(targetUnit==null)
			throw new IllegalArgumentException("Invalid Input");
		
		double baseResult=performBaseArithmetic(other, ArithmeticOperation.MULTIPLY);
		double result=targetUnit.convertFromBaseUnit(baseResult);
		
		return new Quantity<>(result, targetUnit);
	}
	
	public Quantity<U> multiply(Quantity<U> other) {
		
		return multiply(other,this.unit);
		
	}
	
	 @Override
	    public String toString() {
	        return value + " " + unit;
	    }

}
