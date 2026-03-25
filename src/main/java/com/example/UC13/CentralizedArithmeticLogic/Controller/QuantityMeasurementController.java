package com.example.UC13.CentralizedArithmeticLogic.Controller;

import java.io.Console;
import java.net.ResponseCache;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UC13.CentralizedArithmeticLogic.DTO.AddRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.CompareRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.ConvertRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.DivideRequest;
import com.example.UC13.CentralizedArithmeticLogic.DTO.QuantityDTO;
import com.example.UC13.CentralizedArithmeticLogic.DTO.SubtractRequest;
import com.example.UC13.CentralizedArithmeticLogic.Service.IQuantityMeasurementService;

@RestController
@RequestMapping("/api")
public class QuantityMeasurementController {

	 private final IQuantityMeasurementService service;

	    public QuantityMeasurementController(IQuantityMeasurementService service) {
	        this.service = service;
	    }

	    @PostMapping("/add")
	    public void performAdd(@RequestBody AddRequest request) {
	        try {
	            QuantityDTO result = service.add(request);
	            System.out.println("Add Result: " + result.getValue() + " " + result.getUnit());
	        } catch (Exception e) {
	            System.out.println("Add Error: " + e.getMessage());
	        }
	    }

	    @PostMapping("/subtract")
	    public void performSubtract(@RequestBody SubtractRequest request) {
	        try {
	            QuantityDTO result = service.subtract(request);
	            System.out.println("Subtract Result: " + result.getValue() + " " + result.getUnit());
	        } catch (Exception e) {
	            System.out.println("Subtract Error: " + e.getMessage());
	        }
	    }

	    @PostMapping("/divide")
	    public void performDivide(@RequestBody DivideRequest request) {
	        try {
	            double result = service.divide(request);
	            System.out.println("Divide Result: " + result);
	        } catch (Exception e) {
	            System.out.println("Divide Error: " + e.getMessage());
	        }
	    }

	    @PostMapping("/convert")
	    public void performConvert(@RequestBody ConvertRequest request) {
	        try {
	            QuantityDTO result = service.convert(request);
	            System.out.println("Convert Result: " + result.getValue() + " " + result.getUnit());
	        } catch (Exception e) {
	            System.out.println("Convert Error: " + e.getMessage());
	        }
	    }

	    @PostMapping("/compare")
	    public void performCompare(@RequestBody CompareRequest request) {
	        try {
	            boolean result = service.compare(request);
	            System.out.println("Compare Result: " + result);
	            
	            
	        } catch (Exception e) {
	            System.out.println("Compare Error: " + e.getMessage());
	        }
	        
	    }
}
