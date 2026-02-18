package com.example.QuantityMesaurment.UC1_FeetMeasurmentApp.App;

public class QuantityMeasurementApp {
	 public static class Feet {
	        private final double value;

	        public Feet(double value) {
	            this.value = value;
	        }

	        @Override
	        public boolean equals(Object obj) {

	            // 1. Same reference check
	            if (this == obj) return true;

	            // 2. Null or different type
	            if (obj == null || getClass() != obj.getClass()) return false;

	            // 3. Cast safely
	            Feet other = (Feet) obj;

	            // 4. Compare double properly
	            return Double.compare(this.value, other.value) == 0;
	        }
	    }

	
	    public static void main(String[] args) {

	        Feet f1 = new Feet(1.0);
	        Feet f2 = new Feet(1.0);

	        System.out.println("Are equal? " + f1.equals(f2));
	    }
}
