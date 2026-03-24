package com.example.UC13.CentralizedArithmeticLogic.Service;

import com.example.UC13.CentralizedArithmeticLogic.DTO.QuantityDTO;
import com.example.UC13.CentralizedArithmeticLogic.util.IMeasurable;
import com.example.UC13.CentralizedArithmeticLogic.util.LengthUnit;
import com.example.UC13.CentralizedArithmeticLogic.util.TemperatureUnit;
import com.example.UC13.CentralizedArithmeticLogic.util.VolumeUnit;
import com.example.UC13.CentralizedArithmeticLogic.util.WeightUnit;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService{

	 private IMeasurable getUnit(QuantityDTO dto) {
	        switch (dto.getMeasurementType()) {
	            case "LENGTH": 
	            	return LengthUnit.valueOf(dto.getUnit());
	            case "WEIGHT": 
	            	return WeightUnit.valueOf(dto.getUnit());
	            case "VOLUME": 
	            	return VolumeUnit.valueOf(dto.getUnit());
	            case "TEMPERATURE": 
	            	return TemperatureUnit.valueOf(dto.getUnit());
	            default: throw new IllegalArgumentException("Invalid type");
	        }
	    }

	    private IMeasurable getTargetUnit(String type, String unit) {
	        switch (type) {
	            case "LENGTH": 
	            	return LengthUnit.valueOf(unit);
	            case "WEIGHT": 
	            	return WeightUnit.valueOf(unit);
	            case "VOLUME": 
	            	return VolumeUnit.valueOf(unit);
	            case "TEMPERATURE": 
	            	return TemperatureUnit.valueOf(unit);
	            default: throw new IllegalArgumentException("Invalid type");
	        }
	    }
	    
	    @Override
	    public QuantityDTO convert(QuantityDTO input, String targetUnit) {
	        IMeasurable unit = getUnit(input);
	        IMeasurable target = getTargetUnit(input.getMeasurementType(), targetUnit);

	        double base = unit.convertToBaseUnit(input.getValue());
	        double result = target.convertFromBaseUnit(base);

	        return new QuantityDTO(result, targetUnit, input.getMeasurementType());
	    }

	    @Override
	    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
	        IMeasurable u1 = getUnit(q1);
	        IMeasurable u2 = getUnit(q2);

	        if (u1.getClass() != u2.getClass()) throw new IllegalArgumentException("Different categories");

	        double b1 = u1.convertToBaseUnit(q1.getValue());
	        double b2 = u2.convertToBaseUnit(q2.getValue());

	        return Math.abs(b1 - b2) < 0.0001;
	    }
	    
	    @Override
	    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2, String targetUnit) {
	        IMeasurable u1 = getUnit(q1);
	        IMeasurable u2 = getUnit(q2);
	        IMeasurable target = getTargetUnit(q1.getMeasurementType(), targetUnit);

	        if (u1.getClass() != u2.getClass()) throw new IllegalArgumentException("Different categories");

	        u1.validateOperationSupport("ADD");

	        double result = u1.convertToBaseUnit(q1.getValue()) + u2.convertToBaseUnit(q2.getValue());

	        return new QuantityDTO(target.convertFromBaseUnit(result), targetUnit, q1.getMeasurementType());
	    }
	    
	    @Override
	    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2, String targetUnit) {
	        IMeasurable u1 = getUnit(q1);
	        IMeasurable u2 = getUnit(q2);
	        IMeasurable target = getTargetUnit(q1.getMeasurementType(), targetUnit);

	        if (u1.getClass() != u2.getClass()) throw new IllegalArgumentException("Different categories");

	        u1.validateOperationSupport("SUBTRACT");

	        double result = u1.convertToBaseUnit(q1.getValue()) - u2.convertToBaseUnit(q2.getValue());

	        return new QuantityDTO(target.convertFromBaseUnit(result), targetUnit, q1.getMeasurementType());
	    }
	    
	    @Override
	    public double divide(QuantityDTO q1, QuantityDTO q2) {
	        IMeasurable u1 = getUnit(q1);
	        IMeasurable u2 = getUnit(q2);

	        if (u1.getClass() != u2.getClass()) throw new IllegalArgumentException("Different categories");

	        u1.validateOperationSupport("DIVIDE");

	        double b1 = u1.convertToBaseUnit(q1.getValue());
	        double b2 = u2.convertToBaseUnit(q2.getValue());

	        if (b2 == 0) throw new ArithmeticException("Divide by zero");

	        return b1 / b2;
	    }

}

