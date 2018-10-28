package com.vg.sj.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vg.sj.model.Job;
/**
 * 
 * @author VG
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JobRespositoryTest {

	@Autowired
	private JobRepository jobRepository;

	@Test
	public void test_invokeJobsEndpoint_200() {
		Optional<Job[]> jobs = jobRepository.invokeJobsEndpoint();
		Assert.assertEquals(true, jobs.isPresent());

	}

}
