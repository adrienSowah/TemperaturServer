package org.tenosoft.temp.measurements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.tenosoft.temp.measurements.Model.Light;
import org.tenosoft.temp.measurements.Model.Room;
import org.tenosoft.temp.measurements.repositories.LightRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        light.setColor("blue");

        Room room = new Room();
        room.setName("livingroom");
        room.setFloorId(0L);

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
        List<Light> lights = lightRepository.findAll();
        //Assert
        Assertions.assertEquals(lights.size(),1);
    }


    @Test
    public void findRLightByLightStateByExample() {
        Light lightExample = new Light();
        lightExample.setState(0);

        Example<Light> roomExample = Example.of(lightExample);

        Optional<Light>  actual = lightRepository.findOne(roomExample);

        Assertions.assertTrue(actual.isPresent());
    }


    @Test
    public void findRLightByLightColorByExample() {
        Light lightExample = new Light();
        lightExample.setColor("Blue");

        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        Example<Light> roomExample = Example.of(lightExample,caseInsensitiveExampleMatcher);

        Optional<Light>  actual = lightRepository.findOne(roomExample);

        Assertions.assertTrue(actual.isPresent());
    }



    @AfterEach
    public void cleanTestTables(){
        lightRepository.deleteAll();
    }
}
