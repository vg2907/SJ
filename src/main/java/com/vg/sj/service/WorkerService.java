package com.vg.sj.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vg.sj.model.Job;
import com.vg.sj.model.Worker;
import com.vg.sj.processor.engine.JobMatchingEngine;
import com.vg.sj.rest.WorkerNotFoundException;

/**
 * 
 * @author VG
 *
 */
@Service
public class WorkerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkerService.class);
	@Autowired
	private WorkerRepository workerRepository;

	@Autowired
	private JobMatchingEngine jobMatchingEngine;

	public List<Job> getMatchingJobsForWorker(Worker worker) {
		return jobMatchingEngine.findMatchingJobs(worker);
	}

	public Worker getWorkerDetails(int workerId) throws WorkerNotFoundException {
		final Optional<Worker[]> optionalWorker = workerRepository.invokeWorkerEndpoint();
		if (!optionalWorker.isPresent()) {
		}

		for (final Worker worker : optionalWorker.get()) {
			if (workerId == worker.getUserId()) {
				return worker;
			}
		}
		LOGGER.info("No Matching Worker Found For id {}", workerId);
		throw new WorkerNotFoundException(workerId);
	}

}
