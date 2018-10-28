package com.vg.sj.rest;

/**
 * 
 * @author VG
 *
 */
public class WorkerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 9002398529119645273L;
	private final int id;

	public WorkerNotFoundException(final int id) {
		super("Worker could not be found with id: " + id);
		this.id = id;
	}

	public WorkerNotFoundException(final int id, final String message) {
		super(message);
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
