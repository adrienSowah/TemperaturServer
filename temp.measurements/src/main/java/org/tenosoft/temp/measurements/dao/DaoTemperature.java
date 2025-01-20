package org.tenosoft.temp.measurements.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.Model.SollTemperatur;

import org.tenosoft.temp.measurements.interfaces.IRoomService;
import org.tenosoft.temp.measurements.driver.SmartHomeDriverManager;
import org.tenosoft.temp.measurements.interfaces.ITemperaturServices;
import org.tenosoft.temp.measurements.interfaces.JbbcSqlStatements;


@Component
public class DaoTemperature implements ITemperaturServices {
	
	SmartHomeDriverManager driverManager;
	
	public DaoTemperature (SmartHomeDriverManager driver) {
		this.driverManager = driver;
	} 
	
	@Override
	public void updateIstTemperature(int roomId, double istTemp)  {
		boolean updateResut = false;
		try {
			Connection con = driverManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(JbbcSqlStatements.UPDATE_ROOM);
			pstmt.setDouble(1, istTemp);
			pstmt.setInt(2, roomId);  
			
			
			int result = pstmt.executeUpdate();
			updateResut =  result > 0 ? true : false;
			System.out.println("Total records updated " + result);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
	}



	


	@Override
	public List<RoomTemperatur> getAvailableRoomTemperatur() {
		// TODO Auto-generated method stub
		List<RoomTemperatur> result = new ArrayList<RoomTemperatur>();
		try {	
			Connection con = driverManager.getConnection(); 
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(JbbcSqlStatements.GET_ALL_ROOM_TEMPERATURS);
				while(rs.next()){
					 RoomTemperatur  roomtemp = new RoomTemperatur();
					 
					roomtemp.setId(rs.getLong("id"));
					roomtemp.setId(rs.getLong("room_id"));
					roomtemp.setIstTemp(rs.getDouble("ist_temp"));
					roomtemp.setTime(rs.getDate("uhrzeit")); 
					 
					result.add(roomtemp);
				
				
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
         
         return result;
		
	}

	@Override
	public List<SollTemperatur> getAvailableRoomSollTemperatur() {
		List<SollTemperatur> result = new ArrayList<SollTemperatur>();
		try {	
			Connection con = driverManager.getConnection(); 
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(JbbcSqlStatements.GET_ALL_ROOMS);
				while(rs.next()){
					 SollTemperatur  solltemp = new SollTemperatur();
					 
					 solltemp.setId(rs.getLong("id"));
					 //TODO solltemp.setRoomId(rs.getLong("roomId"));
					 solltemp.setSoll(rs.getDouble("soll"));
					 solltemp.setMin(rs.getDouble("min")); 
					 
					result.add(solltemp);
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
         
         return result;
	}

	@Override
	public void updateSollTemperature(SollTemperatur sollTemperatur) {

	}


	@Override
	public RoomTemperatur getRoomTempByRoomId(long roomId) {
		RoomTemperatur roomtemp = new RoomTemperatur();
		try {	
			Connection con = driverManager.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(JbbcSqlStatements.GET_ROOM_TEMPERATUR_BY_ID);
			pstmt.setLong(1, roomId);
	        ResultSet rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	roomtemp.setId(rs.getLong("id"));
	        	//TODO roomtemp.setRoomId(rs.getLong("room_id"));
	        	roomtemp.setIstTemp(rs.getDouble("ist_temp"));
	        	roomtemp.setTime(rs.getDate("uhrzeit"));
	        }
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roomtemp;
	}

	@Override
	public SollTemperatur getSollTempByRoomId(long roomId) {
		SollTemperatur solltemp = new SollTemperatur();
		try {	
			Connection con = driverManager.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(JbbcSqlStatements.GET_SOLL_TEMPERATUR_BY_ID);
			pstmt.setLong(1, roomId);
	        ResultSet rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	solltemp.setId(rs.getLong("id"));
	        	//TODO solltemp.setRoomId(rs.getLong("room_id"));
	        	solltemp.setSoll(rs.getDouble("solltemp"));
	        	solltemp.setMin(rs.getDouble("mintemp"));
	        }
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return solltemp;
	}
	
}
