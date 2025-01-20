package org.tenosoft.temp.measurements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tenosoft.temp.measurements.Model.Light;
import org.tenosoft.temp.measurements.Model.Room;
import org.tenosoft.temp.measurements.repositories.LightRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(properties = "temp.mes.resource.source=jpa")

public class LightTest {
    @Autowired
    LightRepository lightRepository;

    @BeforeEach
    public void TestData(){
        GenerateTestData();
    }
    private void GenerateTestData(){
        List<Light> lights = new ArrayList<>();
        Light light = new Light();
        light.setState(0);

        Room room = new Room();
        room.setName("livingroom");
        room.setFloorId(0);
        room.getLights().add(light);

        lights.add(light);


        lightRepository.saveAll(lights);

    }

    @Test
    public void findByStateTest(){
        //given
        List<Light>lights = lightRepository.findByState(0);
        //Assert
        Assertions.assertEquals(lights.size(),1);
    }


    @Test
    public void findByRoomIdTest(){
        //given
        List<Light>lights = lightRepository.findByRoomId(0 );
        //Assert
        Assertions.assertEquals(lights.size(),2);
    }


    @AfterEach
    public void cleanTestTables(){
        lightRepository.deleteAll();
    }
}
