package com.vg.sj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vg.sj.model.Job;
import com.vg.sj.model.Worker;
import com.vg.sj.service.WorkerService;

/**
 * 
 * @author VG
 *
 */
@RestController
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@GetMapping("/searches/{workerId}")
	public ResponseEntity<List<Job>> getWorkedById(@PathVariable final int workerId) {
		Worker worker = workerService.getWorkerDetails(workerId);
		List<Job> matchingJobs = workerService.getMatchingJobsForWorker(worker);
		if (matchingJobs.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok().cacheControl(CacheControl.noCache()).body(matchingJobs);
	}
}
