package org.tenosoft.temp.measurements.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;
import org.tenosoft.temp.measurements.Model.Light;
import org.tenosoft.temp.measurements.Model.Room;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.Model.SollTemperatur;

import org.tenosoft.temp.measurements.data.RoomView;
import org.tenosoft.temp.measurements.driver.SmartHomeDriverManager;



@Component

public class DaoTemperature implements IRoomService,ITemperaturServices {
	
	SmartHomeDriverManager driverManager;
	
	public DaoTemperature (SmartHomeDriverManager driver) {
		this.driverManager = driver;
	} 
	
	@Override
	public boolean updateIstTemperature(int roomId, double istTemp)  {
		boolean updateResut = false;
		try {
			Connection con = driverManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(ITemperaturServices.UPDATE_ROOM);
			pstmt.setDouble(1, istTemp);
			pstmt.setInt(2, roomId);  
			
			
			int result = pstmt.executeUpdate();
			updateResut =  result > 0 ? true : false;
			System.out.println("Total records updated " + result);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return updateResut;
	}

	@Override
	public List<Room> getAvailableRooms() {
		List<Room> result = new ArrayList<Room>();
		
		try {	
			Connection con = driverManager.getConnection(); 
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(IRoomService.GET_ALL_ROOMS);
				while(rs.next()){
					 
					 Room room = new Room();
				 
					 room.setId(rs.getLong("id"));
					 room.setName(rs.getString("name"));
					 room.setFloorid(rs.getLong("floorId"));
					 
				    //Display values
				    System.out.print("ID: " + rs.getInt("id"));
				    System.out.print(", name: " + rs.getString("name"));
				    System.out.print(", floorId: " + rs.getInt("floorid"));
				    System.out.println(" ");
				    
				    result.add(room);
				// TODO Auto-generated method stub
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
         
         return result;
	}

	
	@Override
	public Room getRoomByName(String name) {
		// TODO Auto-generated method stub
		Room room = new Room();
		try {	
			Connection con = driverManager.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(IRoomService.SELECT_ROOM_BY_NAME);
			pstmt.setString(1, name);
	        ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
			
			room.setId(rs.getLong("id"));
			room.setName(rs.getString("name"));
			room.setFloorid(rs.getLong("floorid"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return room;
	}

	@Override
	public List<RoomTemperatur> getAvailableRoomTemperatur() {
		// TODO Auto-generated method stub
		List<RoomTemperatur> result = new ArrayList<RoomTemperatur>();
		try {	
			Connection con = driverManager.getConnection(); 
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(IRoomService.GET_ALL_ROOMS);
				while(rs.next()){
					 RoomTemperatur  roomtemp = new RoomTemperatur();
					 
					roomtemp.setId(rs.getLong("id"));
					roomtemp.setRoomId(rs.getLong("roomid"));
					roomtemp.setIstTemp(rs.getDouble("istemp"));
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
	        ResultSet rs = stmt.executeQuery(IRoomService.GET_ALL_ROOMS);
				while(rs.next()){
					 SollTemperatur  solltemp = new SollTemperatur();
					 
					 solltemp.setId(rs.getLong("id"));
					 solltemp.setRoomId(rs.getLong("roomId"));
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
	public void DeleteRoomById(long id) {
		// TODO Auto-generated method stub
		Room room = new Room();
		try {	
			Connection con = driverManager.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(IRoomService.DELETE_ROOM_BY_ID);
			pstmt.setLong(1, id);
	        ResultSet rs = pstmt.executeQuery();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Room getRoomById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public List<Room> getRoomsByFloorId(long id) {
List<Room> result = new ArrayList<Room>();
		
		try {	
			Connection con = driverManager.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(IRoomService.SELECT_ROOM_BY_FLOOR_ID);
			pstmt.setLong(1, id);
	        ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					Room room = new Room();
					 
					 room.setId(rs.getLong("id"));
					 room.setName(rs.getString("name"));
					 room.setFloorid(rs.getLong("floorId"));
					 
				    //Display values
				    System.out.print("ID: " + rs.getInt("id"));
				    System.out.print(", name: " + rs.getString("name"));
				    System.out.print(", floorId: " + rs.getInt("floorid"));
				    System.out.println(" ");
				    
				    result.add(room);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public RoomView getAllInfo(long roomId) {
		RoomView roomview = null;
		try {
			Connection con = driverManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(IRoomService.SELECT_ALL_INFO_ROOM);
			pstmt.setLong(1, roomId); 
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()) {
			 roomview = new RoomView(rs.getString("name"), roomId);
			roomview.setIstTemp(rs.getDouble("isttemp"));
			roomview.setSollTemp(rs.getDouble("solltemp"));
			roomview.setLightState(rs.getInt("state"));
			
				System.out.print("ID: " + rs.getLong("id"));
				  System.out.print(", name: " + rs.getString("name"));
				  System.out.print(", state: " + rs.getInt("state"));
				  
				  System.out.print(", roomtemp: " +rs.getDouble("isttemp"));
				 System.out.print(", solltemp : " +rs.getDouble( "solltemp"));
				 System.out.println(" ");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return roomview;
	}

	@Override
	public RoomView retrieveRoomTempLightByRoomId(long roomId) {
		Room room = getRoomById(roomId);
		Light light = getLightByRoomId(roomId);
		SollTemperatur sollTemperatur = getSollTempByRoomId(roomId);
		RoomTemperatur roomTemp = getRoomTempByRoomId(roomId);
		RoomView roomview = new RoomView(room.getName(), room.getId());
		
		roomview.setInstant(Instant.now());
		roomview.setIstTemp(roomTemp.getIstTemp());
		
		// TODO Auto-generated method stub
		return roomview;
	}

	@Override
	public Light getLightByRoomId(long roomId) {
		Light light = new Light();
		try {	
			Connection con = driverManager.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(IRoomService.SELECT_LIGHT_BY_ROOM_ID);
			pstmt.setLong(1, roomId);
	        ResultSet rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	light.setId(rs.getLong("id"));
	        	light.setRoomId(roomId);
	        	light.setState(rs.getInt("state"));
	        }
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return light;
	}

	@Override
	public RoomTemperatur getRoomTempByRoomId(long roomId) {
		RoomTemperatur roomtemp = new RoomTemperatur();
		try {	
			Connection con = driverManager.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(ITemperaturServices.GET_ROOM_TEMPERATUR_BY_ID);
			pstmt.setLong(1, roomId);
	        ResultSet rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	roomtemp.setId(rs.getLong("id"));
	        	roomtemp.setRoomId(rs.getLong("roomid"));
	        	roomtemp.setIstTemp(rs.getDouble("isttemp"));
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
			PreparedStatement pstmt = con.prepareStatement(ITemperaturServices.GET_SOLL_TEMPERATUR_BY_ID);
			pstmt.setLong(1, roomId);
	        ResultSet rs = pstmt.executeQuery();
	        while(rs.next()) {
	        	solltemp.setId(rs.getLong("id"));
	        	solltemp.setRoomId(rs.getLong("roomid"));
	        	solltemp.setSoll(rs.getDouble("soll"));
	        	solltemp.setMin(rs.getDouble("min"));
	        }
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return solltemp;
	}
	
}
