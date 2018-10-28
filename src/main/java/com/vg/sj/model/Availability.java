package com.vg.sj.model;

/**
 *
 * @author VG
 *
 */
public class Availability {

	private String title;
	private int dayIndex;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDayIndex() {
		return dayIndex;
	}

	public void setDayIndex(int dayIndex) {
		this.dayIndex = dayIndex;
	}

	@Override
	public String toString() {
		return "Availability [title=" + title + ", dayIndex=" + dayIndex + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dayIndex;
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
		if (!(obj instanceof Availability)) {
			return false;
		}
		final Availability other = (Availability) obj;

		if (dayIndex != other.dayIndex) {
			return false;
		}
		return true;
	}

}
