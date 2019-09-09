package com.almaviva.azienda;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.azienda.AziendaApplication;
import com.google.common.net.MediaType;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AziendaApplication.class)
@ContextConfiguration
public class AziendaApplicationTests {



    @Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
	@Test
	public void  testDip() throws Exception {
		mockMvc.perform(get("/dipendenti")).andExpect(status().isNoContent());
	}
	
	@Test
	public void testEmployee() throws Exception {
		mockMvc.perform(post("/addDip")).andExpect(status().isOk());

	}

	
}
  