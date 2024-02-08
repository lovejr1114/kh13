package com.kh.spring10.dto;

import java.sql.Date;

public class ClientDto {
	private String clientId;
	private String clientPassword;
	private String clientNickname;
	private String clientGrade;
	private Date clientJoin;
	private int clientPoint;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientPassword() {
		return clientPassword;
	}
	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}
	public String getClientNickname() {
		return clientNickname;
	}
	public void setClientNickname(String clientNickname) {
		this.clientNickname = clientNickname;
	}
	public String getClientGrade() {
		return clientGrade;
	}
	public void setClientGrade(String clientGrade) {
		this.clientGrade = clientGrade;
	}
	public Date getClientJoin() {
		return clientJoin;
	}
	public void setClientJoin(Date clientJoin) {
		this.clientJoin = clientJoin;
	}
	public int getClientPoint() {
		return clientPoint;
	}
	public void setClientPoint(int clientPoint) {
		this.clientPoint = clientPoint;
	}
	public ClientDto() {
		super();
	}
	
	
}
