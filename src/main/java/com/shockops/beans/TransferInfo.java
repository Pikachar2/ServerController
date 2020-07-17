package com.shockops.beans;

public class TransferInfo {

	private String status = "";

	public TransferInfo(String status) {
		super();
		this.status = status;
	}

	@Override
	public String toString() {
		return "[status=" + status + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
