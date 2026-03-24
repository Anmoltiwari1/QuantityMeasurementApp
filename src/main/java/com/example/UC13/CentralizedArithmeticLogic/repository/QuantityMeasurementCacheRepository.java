package com.example.UC13.CentralizedArithmeticLogic.repository;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository {
 
	 private static final QuantityMeasurementCacheRepository INSTANCE = new QuantityMeasurementCacheRepository();

	    private List<String> data = new ArrayList<>();

	    private QuantityMeasurementCacheRepository() {}

	    public static QuantityMeasurementCacheRepository getInstance() {
	        return INSTANCE;
	    }

	    public void save(String record) {
	        data.add(record);
	    }

	    public List<String> getAll() {
	        return data;
	    }
}
