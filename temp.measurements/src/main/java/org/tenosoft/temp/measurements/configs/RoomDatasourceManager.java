package org.tenosoft.temp.measurements.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tenosoft.temp.measurements.dao.DaoRoom;
import org.tenosoft.temp.measurements.dao.DaoTemperature;
import org.tenosoft.temp.measurements.interfaces.IRoomService;
import org.tenosoft.temp.measurements.interfaces.ITemperaturServices;

@Configuration
@ConditionalOnProperty(
        value="temp.mes.resource.source",
        havingValue = "jdbc",
        matchIfMissing = true)
public class RoomDatasourceManager {

    IRoomService iRoomService;
    ITemperaturServices iTemperaturServices;

    public RoomDatasourceManager(DaoRoom daoRoom, DaoTemperature daoTemperature) {
       iRoomService = daoRoom;
        iTemperaturServices = daoTemperature;

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
