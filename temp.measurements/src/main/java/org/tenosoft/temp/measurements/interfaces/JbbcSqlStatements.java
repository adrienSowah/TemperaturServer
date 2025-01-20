package org.tenosoft.temp.measurements.interfaces;

public interface JbbcSqlStatements {
    String GET_ALL_ROOMS = "SELECT * FROM ROOM ";

    String SELECT_ROOM_BY_NAME = "Select * from Room Where name = ?";

    String SELECT_ROOM_BY_ID = "Select * from Room Where id = ?";
    String SELECT_ROOM_BY_FLOOR_ID = "Select * from Room Where floorid = ?";
    String DELETE_ROOM_BY_ID = "Delete * from Room Where id = ?";
    String SELECT_ALL_INFO_ROOM = 	"Select distinct r.id , r.name, l.state,rt.ist_temp ,sol.solltemp from room as r, light as l, room_temp as rt,soll_temperatur as sol where r.id=? and r.id=sol.id";

    String SELECT_LIGHT_BY_ROOM_ID = "Select * from light where id = ?";

    String INSERT_ROOM = "Insert into Room(id,name,floorId,description) Value(?,?,?,?)";

    String INSERT_LIGHT = "Insert into Light(id,lightName,state) value(?,?,?)";

    /****************************************** Room Temperature SQL Statemenents ****************************/
    String GET_ROOM_TEMPERATUR_BY_ID = "Select * from room_temp where id = ? " ;
    String GET_SOLL_TEMPERATUR_BY_ID = "Select * from soll_temperatur where id = ? " ;
    String UPDATE_ROOM = "UPDATE ROOMTEMP SET ISTTEMP= ? WHERE ROOMID=? ";
    String GET_ALL_ROOM_TEMPERATURS = "Select * from room_temp";
    String GET_ALL_SOLL_TEMPERATURS = "Select * from soll_temperatur";
}
