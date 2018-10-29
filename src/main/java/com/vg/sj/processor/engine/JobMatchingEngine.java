package com.vg.sj.processor.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vg.sj.configuration.AppConfiguration;
import com.vg.sj.model.Job;
import com.vg.sj.model.Worker;
import com.vg.sj.processor.strategy.CertificatesPresentStrategy;
import com.vg.sj.processor.strategy.DriversLincenseNeededStrategy;
import com.vg.sj.processor.strategy.JobMatchingStrategy;
import com.vg.sj.processor.strategy.LocationMatchStrategy;
import com.vg.sj.processor.strategy.TransportationMatchStrategy;
import com.vg.sj.processor.strategy.WorkerAvailableStrategy;
import com.vg.sj.processor.strategy.WorkerNeededStrategy;
import com.vg.sj.service.JobService;

/**
 *
 * @author VG
 *
 */
@Component
public class JobMatchingEngine {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobMatchingEngine.class);

	@Autowired
	private AppConfiguration appConfiguration;

	@Autowired
	private WorkerAvailableStrategy workerAvailableStrategy;

	@Autowired
	private CertificatesPresentStrategy certificatesPresentStrategy;

	@Autowired
	private TransportationMatchStrategy transportationMatchStrategy;

	@Autowired
	private LocationMatchStrategy locationMatchStrategy;

	@Autowired
	private WorkerNeededStrategy workerNeededStrategy;
	
	@Autowired
	private DriversLincenseNeededStrategy driversLincenseNeededStrategy;


	@Autowired
	private JobService jobService;

	private final List<JobMatchingStrategy> jobMatchingStrategy = new ArrayList<>();

	@PostConstruct
	public void registerMatchingStrategies() {
		jobMatchingStrategy.add(workerAvailableStrategy);
		jobMatchingStrategy.add(certificatesPresentStrategy);
		jobMatchingStrategy.add(transportationMatchStrategy);
		jobMatchingStrategy.add(locationMatchStrategy);
		jobMatchingStrategy.add(workerNeededStrategy);
		jobMatchingStrategy.add(driversLincenseNeededStrategy);
	}

	public List<Job> findMatchingJobs(final Worker worker) {
		final List<Job> jobsMatchingSkillsOfWorker = jobService.getJobsForSkills(worker.getSkills());
		final List<Job> matchingJobs = new ArrayList<>();

		for (final Job job : jobsMatchingSkillsOfWorker) {
			boolean isAllStrategiesMatching = true;

			for (final JobMatchingStrategy strategy : jobMatchingStrategy) {
				if (!strategy.match(worker, job)) {
					isAllStrategiesMatching = false;
					LOGGER.info("JobId : {}; {} failed validation", job.getGuid(), strategy.getClass().getSimpleName());
					break;
				}
			}
			if (isAllStrategiesMatching) {
				matchingJobs.add(job);
				if (matchingJobs.size() == appConfiguration.getMaxApproriateJobs()) {
					break;
				}
			}
		}

		LOGGER.info("For Worker {} , Matching jobs are : {}", worker.getUserId(),
				matchingJobs.stream().map(Job::getGuid).collect(Collectors.joining(", ")));

		return matchingJobs;
	}

}
