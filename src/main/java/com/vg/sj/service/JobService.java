package com.vg.sj.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vg.sj.model.Job;

/**
 *
 * @author VG
 *
 */
@Service
public class JobService {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobService.class);

	@Autowired
	private JobRepository jobRepository;

	public List<Job> getJobsForSkills(final Set<String> skills) {
		final Optional<Job[]> optionalJobs = jobRepository.invokeJobsEndpoint();
		if (optionalJobs.isPresent()) {
			return aggregateJobsBySkills(optionalJobs.get(), skills);
		}

		return Collections.emptyList();
	}

	private List<Job> aggregateJobsBySkills(final Job[] jobs, final Set<String> skills) {
		final List<Job> jobsBySkills = new ArrayList<>();

		for (final Job job : jobs) {
			if (skills.contains(job.getJobTitle())) {
				jobsBySkills.add(job);
			}
		}

		final String jobsBySkillsInfo = jobsBySkills
				.stream()
				.collect(
						StringBuilder::new,
						(sb, jobByJobTitles) -> sb.append(jobByJobTitles.getJobTitle()).append("::")
								.append(jobByJobTitles.toString()).append("\n"),
						(sb1, sb2) -> sb1.append(sb2.toString())).toString();

		LOGGER.info("Jobs grouped by JobTitle ::\n {}", jobsBySkillsInfo);
		return jobsBySkills;
	}
}
