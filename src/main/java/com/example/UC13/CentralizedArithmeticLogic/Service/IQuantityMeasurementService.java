package com.example.UC13.CentralizedArithmeticLogic.Service;

import com.example.UC13.CentralizedArithmeticLogic.DTO.AddRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.CompareRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.ConvertRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.DivideRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.QuantityDTO;
import com.example.UC13.CentralizedArithmeticLogic.DTO.SubtractRequest;
import com.example.UC13.CentralizedArithmeticLogic.util.IMeasurable;

public interface IQuantityMeasurementService {

	QuantityDTO convert(ConvertRequest request);
	
	boolean compare(CompareRequest request);
	
	QuantityDTO add(AddRequest request);
	
	QuantityDTO subtract(SubtractRequest request);
	
	double divide(DivideRequest request);
	
}
