package com.example.UC13.CentralizedArithmeticLogic.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.UC13.CentralizedArithmeticLogic.entity.QuantityMeasurementEntity;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository{
 
	private List<QuantityMeasurementEntity> data=new ArrayList<QuantityMeasurementEntity>();
	
	private QuantityMeasurementCacheRepository() {
		
	}
	
	@Override
	public void save(QuantityMeasurementEntity entity) {
		data.add(entity);
	}
	
	@Override
	public List<QuantityMeasurementEntity> getAllMeasurements(){
		return data;
	}
	
	@Override
	public void deleteAll() {
		data.clear();
	}
	
	@Override
	public int getTotalCount() {
		return data.size();
	}
	
}
