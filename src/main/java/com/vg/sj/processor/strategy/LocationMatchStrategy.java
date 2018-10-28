package com.vg.sj.processor.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vg.sj.model.Job;
import com.vg.sj.model.Worker;

/**
 *
 * @author VG
 *
 */
@Service
public class LocationMatchStrategy implements JobMatchingStrategy {
	private static final Logger LOGGER = LoggerFactory.getLogger(LocationMatchStrategy.class);

	@Override
	public boolean match(final Worker worker, final Job job) {
		final double distanceInKms = calculateDistanceBetweenLocations(worker, job);
		LOGGER.info("JobId: {}; Difference in Location : {} , Max :{}", job.getGuid(), distanceInKms, worker
				.getJobSearchAddress().getMaxJobDistance());
		return isDistanceWithInMaxAllowed(worker, distanceInKms);
	}

	private boolean isDistanceWithInMaxAllowed(final Worker worker, final double distanceInKms) {
		switch (worker.getJobSearchAddress().getUnit()) {
		case "km":
			return distanceInKms > worker.getJobSearchAddress().getMaxJobDistance() ? false : true;

		case "m":
			return (distanceInKms * 1000) > worker.getJobSearchAddress().getMaxJobDistance() ? false : true;

		default:
			return false;
		}

	}

	private double calculateDistanceBetweenLocations(Worker worker, Job job) {
		final Double lat1 = Double.valueOf(worker.getJobSearchAddress().getLatitude());
		final Double lon1 = Double.valueOf(worker.getJobSearchAddress().getLongitude());
		final Double lat2 = Double.valueOf(job.getLocation().getLatitude());
		final Double lon2 = Double.valueOf(job.getLocation().getLongitude());

		final int radiusOfEarth = 6371;
		final double latDistance = Math.toRadians(lat2 - lat1);
		final double lonDistance = Math.toRadians(lon2 - lon1);
		final double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		final double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return radiusOfEarth * c;
	}

}
