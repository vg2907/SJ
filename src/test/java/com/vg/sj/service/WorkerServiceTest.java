package com.vg.sj.service;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vg.sj.model.Job;
import com.vg.sj.model.Worker;
import com.vg.sj.rest.WorkerNotFoundException;
/**
 * 
 * @author VG
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkerServiceTest {

	@Autowired
	private WorkerService workerService;

	@Autowired
	private WorkerRepository workerRepository;

	@Test
	public void test_getJobsMatchingSkills() {
		Worker worker = workerService.getWorkerDetails(48);
		List<Job> matchingJobs = workerService.getMatchingJobsForWorker(worker);
		Assert.assertEquals("562f66aa7383f3a5241674c8", matchingJobs.stream().map(Job::getGuid).collect(Collectors.joining(", ")));

	}

	@Test
	public void test_getJobsMatchingSkills_max3() {
		Worker worker = workerService.getWorkerDetails(12);
		List<Job> matchingJobs = workerService.getMatchingJobsForWorker(worker);
		Assert.assertEquals(3, matchingJobs.size());
		Assert.assertEquals("562f66aa4742de2c682f07f7, 562f66aa66f3026d02651040, 562f66aa99105d7eaf0c9694",
				matchingJobs.stream().map(Job::getGuid).collect(Collectors.joining(", ")));

	}

	@Test(expected = WorkerNotFoundException.class)
	public void test_getJobsMatchingSkill_Exception() {
		workerService.getWorkerDetails(10000);
	}

	@Test
	@Ignore
	public void test_all_getJobsMatchingSkills() {
		Worker[] workers = workerRepository.invokeWorkerEndpoint().get();
		for (Worker worker : workers) {
			Worker user = workerService.getWorkerDetails(worker.getUserId());
			workerService.getMatchingJobsForWorker(user);
		}

	}

}
