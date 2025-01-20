package org.tenosoft.temp.measurements.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.Model.SollTemperatur;
import org.tenosoft.temp.measurements.dao.DaoTemperature;
import org.tenosoft.temp.measurements.interfaces.ITemperaturServices;

import java.util.List;

@Service
public class TemperaturServices implements ITemperaturServices  {


    ITemperaturServices iTemperaturServices;
public TemperaturServices(@Qualifier("TemperatureServiceBean") ITemperaturServices iTemperaturServices ){
    this.iTemperaturServices = iTemperaturServices;
}

    public void updateIstTemperature(int roomId, double istTemp) {
         iTemperaturServices.updateIstTemperature(roomId,istTemp);
    }


    public List<RoomTemperatur> getAvailableRoomTemperatur() {
        return iTemperaturServices.getAvailableRoomTemperatur();
    }


    public List<SollTemperatur> getAvailableRoomSollTemperatur() {
        return iTemperaturServices.getAvailableRoomSollTemperatur();
    }

    @Override
    public void updateSollTemperature(SollTemperatur sollTemperatur) {
        iTemperaturServices.updateSollTemperature(sollTemperatur);
    }


    public RoomTemperatur getRoomTempByRoomId(long roomId) {
        return iTemperaturServices.getRoomTempByRoomId(roomId);
    }


    public SollTemperatur getSollTempByRoomId(long roomId) {
        return iTemperaturServices.getSollTempByRoomId(roomId);
    }
}
