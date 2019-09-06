package com.azienda.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@SpringBootApplication
public class AziendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AziendaApplication.class, args);
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
    

}
