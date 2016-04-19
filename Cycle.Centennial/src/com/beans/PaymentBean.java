package com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.beans.SessionBean;
import com.dao.PaymentDAO;

@ManagedBean(name = "payment")
@SessionScoped
public class PaymentBean {

	private int ccNumber;
	private int userId;
	private String ccType;
	private String ccExpiryDate;
	private String holderName;
	private double amount;
	private int paymentId;
	private String userName;

	private String date;
	private String bikeType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int memberId) {
		this.userId = memberId;
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
		switch (bikeType) {
		case "Touring":
			calAmount = 1 * Double.parseDouble(date);
			break;
		case "Sports":
			calAmount = 2 * Double.parseDouble(date);
			break;
		case "Road":
			calAmount = 3 * Double.parseDouble(date);
			break;

		default:
			calAmount = 0;

		}

		this.amount = calAmount;
		this.paymentId=GeneratePaymentID();

		 HttpSession session = SessionBean.getSession();
//		 userId = (Integer) session.getAttribute("userid");
		int userid = 300760378;
		String userName = "wbl";
//		 userName=session.getAttribute("userName").toString();

		 PaymentDAO.InsertToPayinfo(ccNumber, userId, ccType, ccExpiryDate,
		 holderName, amount, paymentId);

		return "receipt";
	}

	
	public int GeneratePaymentID()
	{
		int randomID = 0;
		 ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i=1; i<11; i++) {
	            list.add(new Integer(i));
	        }
	        Collections.shuffle(list);
	        for (int i=0; i<1; i++) {
	        	
	        	randomID=list.get(i);
	        	
	        	
	        }
	        return randomID;
	}
}
