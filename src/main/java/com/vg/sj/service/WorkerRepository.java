package com.vg.sj.service;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.vg.sj.configuration.AppConfiguration;
import com.vg.sj.model.Worker;

/**
 *
 * @author VG
 *
 */
@Service
public class WorkerRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(JobRepository.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AppConfiguration appConfig;

	public Optional<Worker[]> invokeWorkerEndpoint() {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		final HttpEntity<?> httpEntity = new HttpEntity<>(headers);

		Worker[] workers = null;
		try {
			workers = restTemplate.exchange(appConfig.getWorkerUrl(), HttpMethod.GET, httpEntity, Worker[].class).getBody();
		} catch (final ResourceAccessException e) {
			LOGGER.info("Error accessing {}", appConfig.getJobUrl(), e);
		}

		return Optional.ofNullable(workers);
	}

}
