package com.almaviva.azienda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.azienda.controller.DipendenteContoller;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AziendaApplicationTests {

    @Test
    public void testGetDipendente() {
    	try {
    		Client client = Client.create();
    		WebResource webResource = client
    		   .resource("http://localhost:8080/dipendenti");
    		ClientResponse response = webResource.accept("application/json")
                       .get(ClientResponse.class);
    		if (response.getStatus() != 200) {
    		   throw new RuntimeException("Failed : HTTP error code : "
    			+ response.getStatus());
    		}
    		String output = response.getEntity(String.class);
    		System.out.println("Output from Server .... \n");
    		System.out.println(output);
    	  } catch (Exception e) {
    		e.printStackTrace();
    	  }
    }
    
    @Test
    public void testGetDip() {
    	DipendenteContoller d=new DipendenteContoller();
    	ResponseEntity<?> result = d.ricercaTuttiIDipendenti();
    	assertEquals(result, "[{\"id\": 1,\"nome\": \"Michele\",\"cognome\": \"Belfiore\",\"email\": \"michele@test.it\",\"azienda\": null}]");
    }

}
