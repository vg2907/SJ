package com.vg.sj.model;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author VG
 *
 */
public class Job {
	private boolean driverLicenseRequired;
	private Set<String> requiredCertificates;
	private Location location;
	private String billRate;
	private int workersRequired;
	private Date startDate;
	private String about;
	private String jobTitle;
	private String company;
	// private UUID guid;
	private String guid;
	private int jobId;

	public boolean isDriverLicenseRequired() {
		return driverLicenseRequired;
	}

	public void setDriverLicenseRequired(boolean driverLicenseRequired) {
		this.driverLicenseRequired = driverLicenseRequired;
	}

	public Set<String> getRequiredCertificates() {
		return requiredCertificates;
	}

	public void setRequiredCertificates(Set<String> requiredCertificates) {
		this.requiredCertificates = requiredCertificates;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getBillRate() {
		return billRate;
	}

	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}

	public int getWorkersRequired() {
		return workersRequired;
	}

	public void setWorkersRequired(int workersRequired) {
		this.workersRequired = workersRequired;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jobId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Job)) {
			return false;
		}
		final Job other = (Job) obj;
		if (jobId != other.jobId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Job [driverLicenseRequired=" + driverLicenseRequired + ", requiredCertificates=" + requiredCertificates
				+ ", workersRequired=" + workersRequired + ", startDate=" + startDate + ", jobTitle=" + jobTitle + ", company=" + company
				+ "]";
	}
}
