package com.example.UC13.CentralizedArithmeticLogic.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UC13.CentralizedArithmeticLogic.DTO.AddRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.CompareRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.ConvertRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.DivideRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.QuantityDTO;
import com.example.UC13.CentralizedArithmeticLogic.DTO.SubtractRequest;
import com.example.UC13.CentralizedArithmeticLogic.repository.IQuantityMeasurementRepository;
import com.example.UC13.CentralizedArithmeticLogic.util.IMeasurable;
import com.example.UC13.CentralizedArithmeticLogic.util.LengthUnit;
import com.example.UC13.CentralizedArithmeticLogic.util.TemperatureUnit;
import com.example.UC13.CentralizedArithmeticLogic.util.VolumeUnit;
import com.example.UC13.CentralizedArithmeticLogic.util.WeightUnit;
import com.example.UC13.CentralizedArithmeticLogic.entity.QuantityMeasurementEntity;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService{
	
	@Autowired
	private IQuantityMeasurementRepository repository;
	
	

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
	    public QuantityDTO convert(ConvertRequest request) {
	    	
	    	QuantityDTO input = request.getQuantity();
	        String targetUnit = request.getTargetUnit();

	        IMeasurable unit = getUnit(input);
	        IMeasurable target = getTargetUnit(input.getMeasurementType(), targetUnit);

	        double base = unit.convertToBaseUnit(input.getValue());
	        double resultValue = target.convertFromBaseUnit(base);

	        QuantityDTO result = new QuantityDTO(resultValue, targetUnit, input.getMeasurementType());

	        // Save to DB
	        QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
	        entity.setValue1(input.getValue());
	        entity.setUnit1(input.getUnit());
	        entity.setValue2(0);
	        entity.setUnit2("-");
	        entity.setOperation("CONVERT");
	        entity.setNumericResult(resultValue);
	        entity.setBooleanResult(false);

	        repository.save(entity);

	        return result;
	        
	    }

	    @Override
	    public boolean compare(CompareRequest request) {
	    	 QuantityDTO q1 = request.getQ1();
	    	    QuantityDTO q2 = request.getQ2();

	    	    IMeasurable u1 = getUnit(q1);
	    	    IMeasurable u2 = getUnit(q2);

	    	    if (u1.getClass() != u2.getClass()) {
	    	        throw new IllegalArgumentException("Different categories");
	    	    }

	    	    double b1 = u1.convertToBaseUnit(q1.getValue());
	    	    double b2 = u2.convertToBaseUnit(q2.getValue());

	    	    boolean result = Math.abs(b1 - b2) < 0.0001;

	    	    // Save to DB
	    	    QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
	    	    entity.setValue1(q1.getValue());
	    	    entity.setUnit1(q1.getUnit());
	    	    entity.setValue2(q2.getValue());
	    	    entity.setUnit2(q2.getUnit());
	    	    entity.setOperation("COMPARE");
	    	    entity.setNumericResult(0);
	    	    entity.setBooleanResult(result);

	    	    repository.save(entity);

	    	    return result;
	    }
	    
	    @Override
	    public QuantityDTO add(AddRequest request) {
	    	 QuantityDTO q1 = request.getQ1();
	    	    QuantityDTO q2 = request.getQ2();
	    	    String targetUnit = request.getUnit();

	    	    IMeasurable u1 = getUnit(q1);
	    	    IMeasurable u2 = getUnit(q2);
	    	    IMeasurable target = getTargetUnit(q1.getMeasurementType(), targetUnit);

	    	    if (u1.getClass() != u2.getClass()) {
	    	        throw new IllegalArgumentException("Different categories");
	    	    }

	    	    u1.validateOperationSupport("ADD");

	    	    double resultValue =
	    	            u1.convertToBaseUnit(q1.getValue()) +
	    	            u2.convertToBaseUnit(q2.getValue());

	    	    QuantityDTO resultDto =
	    	            new QuantityDTO(
	    	                    target.convertFromBaseUnit(resultValue),
	    	                    targetUnit,
	    	                    q1.getMeasurementType()
	    	            );

	    	    // Save to DB
	    	    QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
	    	    entity.setValue1(q1.getValue());
	    	    entity.setUnit1(q1.getUnit());
	    	    entity.setValue2(q2.getValue());
	    	    entity.setUnit2(q2.getUnit());
	    	    entity.setOperation("ADD");
	    	    entity.setNumericResult(resultValue);
	    	    entity.setBooleanResult(false); 

	    	    repository.save(entity);

	    	    return resultDto;
	    }
	    
	    @Override
	    public QuantityDTO subtract(SubtractRequest request) {
	    	 QuantityDTO q1 = request.getQ1();
	    	    QuantityDTO q2 = request.getQ2();
	    	    String targetUnit = request.getUnit();

	    	    IMeasurable u1 = getUnit(q1);
	    	    IMeasurable u2 = getUnit(q2);
	    	    IMeasurable target = getTargetUnit(q1.getMeasurementType(), targetUnit);

	    	    if (u1.getClass() != u2.getClass()) {
	    	        throw new IllegalArgumentException("Different categories");
	    	    }

	    	    u1.validateOperationSupport("SUBTRACT");

	    	    double resultValue = u1.convertToBaseUnit(q1.getValue()) 
	    	                       - u2.convertToBaseUnit(q2.getValue());

	    	    QuantityDTO result = new QuantityDTO(
	    	            target.convertFromBaseUnit(resultValue),
	    	            targetUnit,
	    	            q1.getMeasurementType()
	    	    );

	    	    // Save to DB
	    	    QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
	    	    entity.setValue1(q1.getValue());
	    	    entity.setUnit1(q1.getUnit());
	    	    entity.setValue2(q2.getValue());
	    	    entity.setUnit2(q2.getUnit());
	    	    entity.setOperation("SUBTRACT");
	    	    entity.setNumericResult(resultValue);
	    	    entity.setBooleanResult(false);

	    	    repository.save(entity);

	    	    return result;
	    }
	    
	    @Override
	    public double divide(DivideRequest request) {
	    	  QuantityDTO q1 = request.getQ1();
	    	    QuantityDTO q2 = request.getQ2();

	    	    IMeasurable u1 = getUnit(q1);
	    	    IMeasurable u2 = getUnit(q2);

	    	    if (u1.getClass() != u2.getClass()) {
	    	        throw new IllegalArgumentException("Different categories");
	    	    }

	    	    u1.validateOperationSupport("DIVIDE");

	    	    double b1 = u1.convertToBaseUnit(q1.getValue());
	    	    double b2 = u2.convertToBaseUnit(q2.getValue());

	    	    if (b2 == 0) {
	    	        throw new ArithmeticException("Divide by zero");
	    	    }

	    	    double result = b1 / b2;

	    	    // Save to DB
	    	    QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
	    	    entity.setValue1(q1.getValue());
	    	    entity.setUnit1(q1.getUnit());
	    	    entity.setValue2(q2.getValue());
	    	    entity.setUnit2(q2.getUnit());
	    	    entity.setOperation("DIVIDE");
	    	    entity.setNumericResult(result);
	    	    entity.setBooleanResult(false);

	    	    repository.save(entity);

	    	    return result;
	    }

}

