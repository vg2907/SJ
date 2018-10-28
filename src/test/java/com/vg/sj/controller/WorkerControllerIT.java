package com.vg.sj.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.vg.sj.SjApplication;
import com.vg.sj.rest.WorkerController;

/**
 * 
 * @author VG
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = SjApplication.class)
@AutoConfigureMockMvc
public class WorkerControllerIT {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private WorkerController workerController;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void whenValidInput_getJobs_200() throws Exception {
		this.mvc.perform(get("/searches/{workerId}", 12).accept(MediaType.ALL)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].guid", is("562f66aa4742de2c682f07f7")))
				.andExpect(jsonPath("$[1].guid", is("562f66aa66f3026d02651040")))
				.andExpect(jsonPath("$[2].guid", is("562f66aa99105d7eaf0c9694")));
	}

	@Test
	public void whenValidInput_noMatchingJob_204() throws Exception {
		this.mvc.perform(get("/searches/{workerId}", 1).accept(MediaType.ALL)).andExpect(status().isNoContent());
	}

	@Test
	public void whenInValidInput_thenErrorMessage() throws Exception {
		this.mvc.perform(get("/searches/{workerId}", 10000).accept(MediaType.ALL)).andExpect(status().isNotFound())
				.andExpect(jsonPath("$[0].message", is("Worker could not be found with id: 10000")));
	}

}
