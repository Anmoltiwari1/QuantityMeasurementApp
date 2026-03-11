package com.example.UC11_VolumeMeasurementEquality.unit;

public enum TemeratureUnit implements IMeasurable{

	CELSIUS {
        public double convertToBaseUnit(double value) {
            return value;
        }

        public double convertFromBaseUnit(double baseValue) {
            return baseValue;
        }
    },

    FAHRENHEIT {
        public double convertToBaseUnit(double value) {
            return (value - 32) * 5 / 9;
        }

        public double convertFromBaseUnit(double baseValue) {
            return (baseValue * 9 / 5) + 32;
        }
    },

    KELVIN {
        public double convertToBaseUnit(double value) {
            return value - 273.15;
        }

        public double convertFromBaseUnit(double baseValue) {
            return baseValue + 273.15;
        }
    };

    @Override
    public double getConversionFactor() {
        return 1.0; 
    }

    @Override
    public String getUnitName() {
        return name();
    }

    @Override
    public boolean supportsArithmetic() {
        return false;
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support " + operation
        );
    }

    public double convertTo(double value, TemeratureUnit target) {
        double base = convertToBaseUnit(value);
        return target.convertFromBaseUnit(base);
    }
}
