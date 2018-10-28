package com.vg.sj.processor.strategy;

import java.util.Calendar;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vg.sj.model.Availability;
import com.vg.sj.model.Job;
import com.vg.sj.model.Worker;

/**
 *
 * @author VG
 *
 */
@Service
public class WorkerAvailableStrategy implements JobMatchingStrategy {
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkerAvailableStrategy.class);

	@Override
	public boolean match(final Worker worker, final Job job) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(job.getStartDate());

		final Optional<Availability> isAvailable = worker.getAvailability().stream().filter(avail -> avail != null)
				.filter(avail -> avail.getDayIndex() == getDateIndex(cal.get(Calendar.DAY_OF_WEEK))).findAny();
		LOGGER.debug(
				"JobId : {}, Job Starting on :{} , Available Indexes : {}",
				job.getGuid(),
				getDateIndex(cal.get(Calendar.DAY_OF_WEEK)),
				worker.getAvailability().stream().filter(avail -> avail != null)
						.map(avail -> String.valueOf(avail.getDayIndex())).collect(Collectors.joining(", ")));

		return isAvailable.isPresent();
	}

	private int getDateIndex(int dayOfWeek) {
		switch (dayOfWeek) {
		case Calendar.SUNDAY:
			return 7;
		case Calendar.MONDAY:
			return 1;
		case Calendar.TUESDAY:
			return 2;
		case Calendar.WEDNESDAY:
			return 3;
		case Calendar.THURSDAY:
			return 4;
		case Calendar.FRIDAY:
			return 5;
		case Calendar.SATURDAY:
			return 6;
		default:
			return 0;
		}
	}

}
