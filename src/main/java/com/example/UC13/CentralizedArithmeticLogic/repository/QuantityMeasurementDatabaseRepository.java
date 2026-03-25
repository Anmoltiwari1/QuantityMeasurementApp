package com.example.UC13.CentralizedArithmeticLogic.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.UC13.CentralizedArithmeticLogic.entity.QuantityMeasurementEntity;

@Repository
public class QuantityMeasurementDatabaseRepository implements IQuantityMeasurementRepository{

	@Override
	public void save(QuantityMeasurementEntity entity) {
		
		String sql = "INSERT INTO measurements (value1, unit1, value2, unit2, operation, numeric_result, boolean_result) VALUES (?,?,?,?,?,?,?)";
		
		try (Connection con=DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
				PreparedStatement ps=con.prepareStatement(sql)){
			

	        ps.setDouble(1, entity.getValue1());
	        ps.setString(2, entity.getUnit1());
	        ps.setDouble(3, entity.getValue2());
	        ps.setString(4, entity.getUnit2());
	        ps.setString(5, entity.getOperation());
	        ps.setDouble(6, entity.getNumericResult());
	        ps.setBoolean(7, entity.isBooleanResult());
	        
	        
	        ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB Error", e);
		}
	}
	
	@Override
	public List<QuantityMeasurementEntity> getAllMeasurements(){
		
		List<QuantityMeasurementEntity> list=new ArrayList<>();
		
		String sql="Select * FROM measurements";
		
		try (Connection con=DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery()){
			
			while(rs.next()) {
				QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
				
				entity.setValue1(rs.getDouble("value1"));
				entity.setUnit1(rs.getString("unit1"));
				entity.setValue2(rs.getDouble("value2"));
				entity.setUnit2(rs.getString("unit2"));
				entity.setOperation(rs.getString("operation"));
				entity.setNumericResult(rs.getDouble("numeric_result"));
				entity.setBooleanResult(rs.getBoolean("boolean_result"));
		        
		        list.add(entity);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB Error",e);
		}
		
		return list;
		
	}
	
	@Override
	public void deleteAll() {
		
		String sql="DELETE FROM measurements";
		
		try (Connection con=DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
				PreparedStatement ps=con.prepareStatement(sql))
				{
			
			ps.executeUpdate();
				
			}
			 catch (Exception e) {
				 e.printStackTrace();
			throw new RuntimeException("DB Error",e);
		}
	}
	
	@Override
	public int getTotalCount() {
		
		String sql="SELECT COUNT(*) from measurements";
		
		
		try (Connection con=DriverManager.getConnection("jdbc:h2:mem:testdb","sa","");
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery()){
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB Error",e);
		}
	return 0;
}
}
