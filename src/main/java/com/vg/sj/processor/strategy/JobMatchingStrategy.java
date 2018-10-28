package com.vg.sj.processor.strategy;

import com.vg.sj.model.Job;
import com.vg.sj.model.Worker;

/**
 *
 * @author VG
 *
 */
public interface JobMatchingStrategy {

	boolean match(final Worker worker, final Job job);

}
