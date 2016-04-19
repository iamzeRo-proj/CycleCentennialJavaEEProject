package com.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.dao.PaymentDAO;

@ManagedBean(name = "payment")
@SessionScoped
public class PaymentBean  {

	
	private int ccNumber;
	private int memberId;
	private String ccType;
	private String ccExpiryDate;
	private String holderName;
	private double amount;
	private int paymentId;
	
	private String date;
	private String bikeType;

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	public int getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(int ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiryDate() {
		return ccExpiryDate;
	}

	public void setCcExpiryDate(String ccExpiryDate) {
		this.ccExpiryDate = ccExpiryDate;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {

		this.amount = amount;
	}

	public int getPaymentId() {
		return paymentId;
	}

	
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	public String insertToDB() {
		double calAmount;
		String date = getDate();
		switch (ccType) {
		case "Touring":
			calAmount = 1 * Double.parseDouble(date);
			break;
		case "Sports":
			calAmount = 2 * Double.parseDouble(date);
			break;
		case "Road":
			calAmount = 3 * Double.parseDouble(date);
			break;
			
			default: calAmount = 0;

		}

		this.amount= calAmount;
		
		
		return "receipt";
	}
	
		
}
