package com.example.UC13.CentralizedArithmeticLogic.Service;

import com.example.UC13.CentralizedArithmeticLogic.DTO.QuantityDTO;

public interface IQuantityMeasurementService {

	QuantityDTO convert(QuantityDTO input,String targetUnit);
	
	boolean compare(QuantityDTO q1,QuantityDTO q2);
	
	QuantityDTO add(QuantityDTO q1,QuantityDTO q2,String targetUnit);
	
	QuantityDTO subtract(QuantityDTO q1,QuantityDTO q2,String targetUnit);
	
	double divide(QuantityDTO q1, QuantityDTO q2);
}
