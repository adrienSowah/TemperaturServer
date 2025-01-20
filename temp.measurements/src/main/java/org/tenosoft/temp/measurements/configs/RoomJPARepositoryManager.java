package org.tenosoft.temp.measurements.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tenosoft.temp.measurements.dao.DaoRoom;
import org.tenosoft.temp.measurements.dao.DaoTemperature;
import org.tenosoft.temp.measurements.interfaces.IRoomService;
import org.tenosoft.temp.measurements.interfaces.ITemperaturServices;
import org.tenosoft.temp.measurements.repositories.RoomServiceJPAImpl;
import org.tenosoft.temp.measurements.repositories.TemperatureServiceJPAImpl;

@Configuration
@ConditionalOnProperty(
        value="temp.mes.resource.source",
        havingValue = "jpa",
        matchIfMissing = false)
public class RoomJPARepositoryManager {


    IRoomService iRoomService;
    ITemperaturServices iTemperaturServices;

    public RoomJPARepositoryManager( RoomServiceJPAImpl roomServiceJPA,  TemperatureServiceJPAImpl temperatureServiceJPA){

        iRoomService = roomServiceJPA;
        iTemperaturServices = temperatureServiceJPA;
    }

    @Bean(name = "RoomServiceBean")
    IRoomService getiRoomService() {
        return  iRoomService;
    }

    @Bean(name="TemperatureServiceBean")
    ITemperaturServices getiTemperaturServices() {
        return iTemperaturServices;
    }

}
