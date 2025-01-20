package org.tenosoft.temp.measurements.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.tenosoft.temp.measurements.Model.RoomTemperatur;
import org.tenosoft.temp.measurements.Model.SollTemperatur;
import org.tenosoft.temp.measurements.interfaces.ITemperaturServices;

import java.util.List;

@Configuration
@ConditionalOnProperty(
        value="temp.mes.resource.source",
        havingValue = "jpa",
        matchIfMissing = false)
public class TemperatureServiceJPAImpl implements ITemperaturServices {
    @Autowired
    RoomTempRepository roomTempRepository;
    @Autowired
     SollTempRepository sollTempRepository;
    @Override
    public void updateIstTemperature(int roomId, double istTemp) {

    }

    @Override
    public List<RoomTemperatur> getAvailableRoomTemperatur() {
        return roomTempRepository.findAll();
    }

    @Override
    public List<SollTemperatur> getAvailableRoomSollTemperatur() {
        return sollTempRepository.findAll();
    }

    @Override
    public void updateSollTemperature(SollTemperatur sollTemperatur) {
        sollTempRepository.save(sollTemperatur);
    }

    @Override
    public RoomTemperatur getRoomTempByRoomId(long roomId) {
        return roomTempRepository.findById(roomId).get();
    }

    @Override
    public SollTemperatur getSollTempByRoomId(long roomId) {
        return sollTempRepository.findByRoomId(roomId);
    }
}
