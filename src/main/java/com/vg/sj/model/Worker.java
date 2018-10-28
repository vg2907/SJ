package com.vg.sj.model;

import java.util.Set;

/**
 *
 * @author VG
 *
 */
public class Worker {

	private int rating;
	private Boolean isActive;
	private Set<String> certificates;
	private Set<String> skills;
	private JobSearchAddress jobSearchAddress;
	private String transportation;
	private boolean hasDriversLicense;
	private Set<Availability> availability;
	private String phone;
	private String email;
	private Name name;
	private int age;
	private String guid;
	private int userId;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Boolean IsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<String> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<String> certificates) {
		this.certificates = certificates;
	}

	public Set<String> getSkills() {
		return skills;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}

	public JobSearchAddress getJobSearchAddress() {
		return jobSearchAddress;
	}

	public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
		this.jobSearchAddress = jobSearchAddress;
	}

	public String getTransportation() {
		return transportation;
	}

	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

	public boolean hasDriversLicense() {
		return hasDriversLicense;
	}

	public void setHasDriversLicense(boolean hasDriversLicense) {
		this.hasDriversLicense = hasDriversLicense;
	}

	public Set<Availability> getAvailability() {
		return availability;
	}

	public void setAvailability(Set<Availability> availability) {
		this.availability = availability;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Worker [isActive=" + isActive + ", certificates=" + certificates + ", skills=" + skills + ", transportation="
				+ transportation + ", hasDriversLicense=" + hasDriversLicense + ", name=" + name + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Worker))
			return false;
		Worker other = (Worker) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

}
