package org.tenosoft.temp.measurements.dao;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.tenosoft.temp.measurements.Model.Light;
import org.tenosoft.temp.measurements.Model.Room;
import org.tenosoft.temp.measurements.controller.RoomData;
import org.tenosoft.temp.measurements.driver.SmartHomeDriverManager;
import org.tenosoft.temp.measurements.interfaces.IRoomService;
import org.tenosoft.temp.measurements.interfaces.JbbcSqlStatements;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
@ConditionalOnProperty(
        value="temp.mes.resource.source",
        havingValue = "jdbc",
        matchIfMissing = true)

public class DaoRoom implements IRoomService {

    SmartHomeDriverManager driverManager;
    JdbcTemplate jdbcTemplate;
    public DaoRoom( SmartHomeDriverManager driver) {
        this.driverManager = driver;

    }




    //@Override
    public List<Room> getAvailableRooms() {
        List<Room> result = new ArrayList<Room>();
        jdbcTemplate.queryForList(JbbcSqlStatements.GET_ALL_ROOMS,result);
        try {
            Connection con = driverManager.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(JbbcSqlStatements.GET_ALL_ROOMS);
            while(rs.next()){

                Room room = new Room();

                room.setId(rs.getLong("id"));
                room.setName(rs.getString("name"));
                room.setFloorId(rs.getLong("floorId"));

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
        jdbcTemplate.queryForList(JbbcSqlStatements.SELECT_ROOM_BY_NAME,room);
        try {
            Connection con = driverManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(JbbcSqlStatements.SELECT_ROOM_BY_NAME);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                room.setId(rs.getLong("id"));
                room.setName(rs.getString("name"));
                room.setDescription(rs.getString("description"));
                room.setFloorId(rs.getLong("floorid"));
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return room;
    }



    @Override
    public List<Light> getLightByRoomId(long roomId) {
        List<Light> light = new ArrayList<>();
        jdbcTemplate.queryForList(JbbcSqlStatements.SELECT_LIGHT_BY_ROOM_ID,light);



        return light;
    }

    @Override
    public Light addLight(Light light) {
        jdbcTemplate.queryForList(JbbcSqlStatements.INSERT_LIGHT);
        return light;
    }

    @Override
    public List<Room> getRoomsByFloorId(long id) {
        List<Room> result = new ArrayList<Room>();
        jdbcTemplate.queryForList(JbbcSqlStatements.SELECT_ROOM_BY_FLOOR_ID,result);

        return result;
    }

    @Override
    public RoomData getAllInfo(long roomId) {
        RoomData roomData = new RoomData();
        jdbcTemplate.queryForList(JbbcSqlStatements.SELECT_ALL_INFO_ROOM,roomData);

        return roomData;
    }


    @Override
    public void deleteRoomById(long id) {
        // TODO Auto-generated method stub
        Room room = new Room();
        jdbcTemplate.queryForList(JbbcSqlStatements.DELETE_ROOM_BY_ID,room);



    }

    @Override
    public void deleteByName(String name) {

    }

    public Room getRoomById(long roomId) {
        Room room = new Room();
        jdbcTemplate.queryForList(JbbcSqlStatements.SELECT_ROOM_BY_ID,room);

        return room;
    }

    @Override
    public void insertRoom(Room room) {
        jdbcTemplate.queryForList(JbbcSqlStatements.INSERT_ROOM);
    }

    @Override
    public Room updateRoom(Room room) {
        return null;
    }


}
