package com.almaviva.azienda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.azienda.test.controller.DipendenteContoller;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DipendenteContoller.class)
@ContextConfiguration
public class AziendaApplicationTests {

	
    @Test
    public void contextLoads() {
    }

}
  