package org.tenosoft.temp.measurements;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.tenosoft.temp.measurements.Model.SollTemperatur;
import org.tenosoft.temp.measurements.repositories.SollTempRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(properties = "temp.mes.resource.source=jpa")

public class SollTemperaturTest {

    @Autowired
    SollTempRepository sollTempRepository;

    @BeforeEach
    public void TestData(){
     generateTestData();
    }
    private void generateTestData(){
       List<SollTemperatur> sollTemperaturList =  new ArrayList<>();

       SollTemperatur sollTemperatur = new SollTemperatur();
       sollTemperatur.setSoll(22);
        //TODO sollTemperatur.setRoomId(0);
       sollTemperatur.setMin(20);
       sollTemperaturList.add(sollTemperatur);

        sollTemperatur = new SollTemperatur();
        sollTemperatur.setSoll(23);
        //TODO   sollTemperatur.setRoomId(1);
        sollTemperatur.setMin(20);
        sollTemperaturList.add(sollTemperatur);

        sollTemperatur = new SollTemperatur();
        sollTemperatur.setSoll(22);
        //TODO  sollTemperatur.setRoomId(2);
        sollTemperatur.setMin(20);
        sollTemperaturList.add(sollTemperatur);

        sollTemperatur = new SollTemperatur();
        sollTemperatur.setSoll(24);
        //TODO sollTemperatur.setRoomId(3);
        sollTemperatur.setMin(20);
        sollTemperaturList.add(sollTemperatur);

        sollTemperatur = new SollTemperatur();
        sollTemperatur.setSoll(21);
        //TODO  sollTemperatur.setRoomId(4);
        sollTemperatur.setMin(19);
        sollTemperaturList.add(sollTemperatur);
        sollTempRepository.saveAll(sollTemperaturList);
    }

  //  @Test
    public void findByRoomId(){
        //given
        SollTemperatur sollTemperatur = sollTempRepository.findByRoomId(4l);
        //Assert
          Assertions.assertEquals(sollTemperatur.getSoll(),21);
    }
    @Test
    public void findBySoll(){
        //given
        List<SollTemperatur> sollTemperatur = sollTempRepository.findBySoll(21);

        //Assert
        Assertions.assertEquals(sollTemperatur.size(),1);
    }

    @Test
    public void findByMin(){
        //given
        List<SollTemperatur>sollTemperaturs = sollTempRepository.findByMin(20);
        //Assert
        Assertions.assertEquals(sollTemperaturs.size(),4);
    }
    @AfterEach
    public void cleanTables(){
        sollTempRepository.deleteAll();
    }
}
