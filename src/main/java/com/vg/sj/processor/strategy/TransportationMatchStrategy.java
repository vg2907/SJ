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
public class TransportationMatchStrategy implements JobMatchingStrategy {

	@Override
	public boolean match(final Worker worker, final Job job) {
		return true; // TODO - is there any parameter in job details?
	}

}
