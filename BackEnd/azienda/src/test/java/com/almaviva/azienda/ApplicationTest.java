package com.almaviva.azienda;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class ApplicationTest extends AziendaApplicationTests {
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void  testDip() throws Exception {
		mockMvc.perform(get("/dipendenti")).andExpect(status().isOk());
	}
	
	/*
	@Test
	public void testAdd() throws Exception{
		mockMvc.perform(post("/addDip")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.name").value("Michele"))
		.andExpect(jsonPath("$.cognome").value("Belfiore"))
		.andExpect(jsonPath("$.Azienda").value(null))
		.andExpect(jsonPath("$.email").value("michele@email.it"));

       }
       */
	}

