package com.vg.sj.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vg.sj.model.Worker;
/**
 * 
 * @author VG
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerRespositoryTest {

	@Autowired
	private WorkerRepository workerRepository;

	@Test
	public void test_invokeWorkerEndpoint_200() {
		Optional<Worker[]> workers = workerRepository.invokeWorkerEndpoint();
		Assert.assertEquals(true, workers.isPresent());

	}

}
