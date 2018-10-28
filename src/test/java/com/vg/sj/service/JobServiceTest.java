package com.vg.sj.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class JobServiceTest {

	@Autowired
	private JobService jobService;

	@Test
	public void test_getJobsMatchingSkills() {
		Set<String> skills = Stream.of("Creator of opportunities", "Arts and Crafts Designer", "c").collect(Collectors.toSet());
		List<Job> jobs = jobService.getJobsForSkills(skills);
		Assert.assertEquals(false, jobs.isEmpty());
		Assert.assertEquals(7, jobs.size());
	}

}
