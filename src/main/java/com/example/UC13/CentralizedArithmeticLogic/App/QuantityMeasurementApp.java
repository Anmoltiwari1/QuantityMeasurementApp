//package com.example.UC13.CentralizedArithmeticLogic.App;
//
//import com.example.UC13.CentralizedArithmeticLogic.Controller.QuantityMeasurementController;
//import com.example.UC13.CentralizedArithmeticLogic.DTO.QuantityDTO;
//import com.example.UC13.CentralizedArithmeticLogic.Service.IQuantityMeasurementService;
//import com.example.UC13.CentralizedArithmeticLogic.Service.QuantityMeasurementServiceImpl;
//
//public class QuantityMeasurementApp {
//
//	 public static void main(String[] args) {
//
//		 IQuantityMeasurementService service = new QuantityMeasurementServiceImpl();
//	        QuantityMeasurementController controller = new QuantityMeasurementController(service);
//
//	        // ================= LENGTH =================
//	        QuantityDTO l1 = new QuantityDTO(1, "FEET", "LENGTH");
//	        QuantityDTO l2 = new QuantityDTO(12, "INCHES", "LENGTH");
//
//	        controller.performCompare(l1, l2);
//	        controller.performConvert(l1, "INCHES");
//	        controller.performAdd(l1, l2, "INCHES");
//	        controller.performSubtract(l1, l2, "INCHES");
//	        controller.performDivide(l1, l2);
//
//	        // ================= WEIGHT =================
//	        QuantityDTO w1 = new QuantityDTO(1, "KILOGRAM", "WEIGHT");
//	        QuantityDTO w2 = new QuantityDTO(1000, "GRAM", "WEIGHT");
//
//	        controller.performCompare(w1, w2);
//	        controller.performAdd(w1, w2, "GRAM");
//
//	        // ================= VOLUME =================
//	        QuantityDTO v1 = new QuantityDTO(1, "LITER", "VOLUME");
//	        QuantityDTO v2 = new QuantityDTO(1000, "MILLILITER", "VOLUME");
//
//	        controller.performCompare(v1, v2);
//	        controller.performConvert(v1, "GALLON");
//
//	        // ================= TEMPERATURE =================
//	        QuantityDTO t1 = new QuantityDTO(0, "CELSIUS", "TEMPERATURE");
//	        QuantityDTO t2 = new QuantityDTO(32, "FAHRENHEIT", "TEMPERATURE");
//
//	        controller.performCompare(t1, t2);
//	        controller.performConvert(t1, "FAHRENHEIT");
//	        
//	        controller.performAdd(t1, t2, "CELSIUS");
//	        controller.performDivide(t1, t2);
//
//	        // ================= CROSS CATEGORY =================
//	        controller.performCompare(l1, w1); // should fail
//	    }
//}