package com.vg.sj.processor;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vg.sj.model.Job;
import com.vg.sj.model.Worker;
import com.vg.sj.processor.strategy.WorkerAvailableStrategy;
import com.vg.sj.service.WorkerService;

/**
 * 
 * @author VG
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IsWorkerAvailableStrategyTest {

	@Autowired
	private WorkerAvailableStrategy workerAvailableStrategy;

	@Autowired
	private WorkerService workerService;

	@Test
	public void test_isDateIndexMatching() {
		Worker worker = workerService.getWorkerDetails(12);
		List<Job> matchingJobs = workerService.getMatchingJobsForWorker(worker);
		for (Job job : matchingJobs) {
			if (job.getGuid().equals("562f66aa4742de2c682f07f7")) {
				boolean isIndex = workerAvailableStrategy.match(worker, job);
				Assert.assertEquals(true, isIndex);
			}

			if (job.getGuid().equals("562f66aacbff2d14fcaae283")) {
				boolean isIndex = workerAvailableStrategy.match(worker, job);
				Assert.assertEquals(false, isIndex);
			}

		}
	}
}
