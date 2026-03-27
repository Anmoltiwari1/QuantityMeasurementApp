package com.example.UC17.JPAIntegration.Service;

import com.example.UC17.JPAIntegration.DTO.AddRequest;
import com.example.UC17.JPAIntegration.DTO.CompareRequest;
import com.example.UC17.JPAIntegration.DTO.ConvertRequest;
import com.example.UC17.JPAIntegration.DTO.DivideRequest;
import com.example.UC17.JPAIntegration.DTO.QuantityDTO;
import com.example.UC17.JPAIntegration.DTO.SubtractRequest;
import com.example.UC17.JPAIntegration.util.IMeasurable;

public interface IQuantityMeasurementService {

	QuantityDTO convert(ConvertRequest request);
	
	boolean compare(CompareRequest request);
	
	QuantityDTO add(AddRequest request);
	
	QuantityDTO subtract(SubtractRequest request);
	
	double divide(DivideRequest request);
	
}
