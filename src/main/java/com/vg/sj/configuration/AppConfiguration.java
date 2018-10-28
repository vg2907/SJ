package com.vg.sj.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @author VG
 *
 */
@Configuration
public class AppConfiguration {

	@Value("${jobUrl:http://test.swipejobs.com/api/jobs}")
	private String jobUrl;

	@Value("${workerUrl:http://test.swipejobs.com/api/workers}")
	private String workerUrl;

	@Value("${maxApproriateJobs:3}")
	private int maxApproriateJobs;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public String getJobUrl() {
		return jobUrl;
	}

	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}

	public String getWorkerUrl() {
		return workerUrl;
	}

	public void setWorkerUrl(String workerUrl) {
		this.workerUrl = workerUrl;
	}

	public int getMaxApproriateJobs() {
		return maxApproriateJobs;
	}

	public void setMaxApproriateJobs(int maxApproriateJobs) {
		this.maxApproriateJobs = maxApproriateJobs;
	}
}
