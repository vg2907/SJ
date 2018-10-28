package com.vg.sj.model;

/**
 *
 * @author VG
 *
 */
public class Name {
	private String first;
	private String last;

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public String toString() {
		return "Name [first=" + first + ", last=" + last + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
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
		if (!(obj instanceof Name)) {
			return false;
		}
		final Name other = (Name) obj;
		if (first == null) {
			if (other.first != null) {
				return false;
			}
		} else if (!first.equals(other.first)) {
			return false;
		}
		if (last == null) {
			if (other.last != null) {
				return false;
			}
		} else if (!last.equals(other.last)) {
			return false;
		}
		return true;
	}
}
