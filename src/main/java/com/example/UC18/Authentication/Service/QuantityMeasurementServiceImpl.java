package com.example.UC18.Authentication.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UC18.Authentication.DTO.AddRequest;
import com.example.UC18.Authentication.DTO.CompareRequest;
import com.example.UC18.Authentication.DTO.ConvertRequest;
import com.example.UC18.Authentication.DTO.DivideRequest;
import com.example.UC18.Authentication.DTO.QuantityDTO;
import com.example.UC18.Authentication.DTO.SubtractRequest;
import com.example.UC18.Authentication.entity.QuantityMeasurementEntity;
import com.example.UC18.Authentication.repository.QuanityMeasurmentRepository;
import com.example.UC18.Authentication.util.IMeasurable;
import com.example.UC18.Authentication.util.LengthUnit;
import com.example.UC18.Authentication.util.TemperatureUnit;
import com.example.UC18.Authentication.util.VolumeUnit;
import com.example.UC18.Authentication.util.WeightUnit;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService{
	
	@Autowired
	private QuanityMeasurmentRepository repository;
	
	

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
	    
	    private QuantityMeasurementEntity creatEntity(QuantityDTO q1,QuantityDTO q2,String operation,double numericResult,boolean booleanResult) {
	    	
	    	QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
	    	entity.setValue1(q1.getValue());
	        entity.setUnit1(q1.getUnit());
	        entity.setValue2(0);
	        entity.setUnit2("-");
	        entity.setOperation("CONVERT");
	        entity.setNumericResult(numericResult);
	        entity.setBooleanResult(booleanResult);
	        
	        return entity;
	    	
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

	        repository.save(creatEntity(input,null,"CONVERT",resultValue,false));

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
	    	    

	    	    repository.save(creatEntity(q1, q2,"COMPARE", 0, result));

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
	    	  
	    	    repository.save(creatEntity(q1, q2,"ADD", resultValue, false));

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
	    	    
	    	    repository.save(creatEntity(q1, q2, "SUBTRACT", resultValue, false));

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
	    	   

	    	    repository.save(creatEntity(q1, q2,"DIVIDE", result, false));

	    	    return result;
	    }

}

