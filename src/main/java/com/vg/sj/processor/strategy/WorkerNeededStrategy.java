package com.vg.sj.processor.strategy;

import org.springframework.stereotype.Service;

import com.vg.sj.model.Job;
import com.vg.sj.model.Worker;

/**
 *
 * @author VG
 *
 */
@Service
public class WorkerNeededStrategy implements JobMatchingStrategy {

	@Override
	public boolean match(final Worker worker, final Job job) {
		return job.getWorkersRequired() > 0;
	}

}
