package com.example.UC3_GenericQuantityClassForDRYPrinciple;

package com.example.UC4_ExtendedUnitSupport;

enum LengthUnit {

	FEET(1.0), // Base unit
	INCH(1.0 / 12.0), // 1 inch = 1/12 feet
	YARDS(3.0), // 1 yard = 3 feet
	CENTIMETERS(0.393701 / 12.0); // 1 cm = 0.393701 inch = (0.393701/12) feet

	private final double toFeetFactor;

	LengthUnit(double toFeetFactor) {
		this.toFeetFactor = toFeetFactor;
	}

	public double toFeet(double value) {
		return value * toFeetFactor;
	}
}

public class GenericQuantity {

	private final double value;
	private final LengthUnit unit;

	public GenericQuantity(double value, LengthUnit unit) {
		if (unit == null) {
			throw new IllegalArgumentException("Unit cannot be null");
		}
		this.value = value;
		this.unit = unit;
	}

	private double toFeet() {
		return unit.toFeet(value);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		GenericQuantity other = (GenericQuantity) obj;

		return Double.compare(this.toFeet(), other.toFeet()) == 0;
	}

	public static void main(String[] args) {

		GenericQuantity q1 = new GenericQuantity(1, LengthUnit.YARDS);
		GenericQuantity q2 = new GenericQuantity(3, LengthUnit.FEET);
		GenericQuantity q3 = new GenericQuantity(36, LengthUnit.INCH);
		GenericQuantity q4 = new GenericQuantity(1, LengthUnit.CENTIMETERS);
		GenericQuantity q5 = new GenericQuantity(0.393701, LengthUnit.INCH);

		System.out.println(q1.equals(q2)); // true
		System.out.println(q1.equals(q3)); // true
		System.out.println(q4.equals(q5)); // true
	}
}