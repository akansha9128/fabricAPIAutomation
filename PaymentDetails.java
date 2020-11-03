package com.ydv.CBL.checkout;

public class PaymentDetails {

	private String paymentType;

	private String cardNumber;

	private String expDate;

	private String cvv;

	private String cardHolderFullName;

	private Metadata metadata;

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getExpDate() {
		return this.expDate;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getCvv() {
		return this.cvv;
	}

	public void setCardHolderFullName(String cardHolderFullName) {
		this.cardHolderFullName = cardHolderFullName;
	}

	public String getCardHolderFullName() {
		return this.cardHolderFullName;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Metadata getMetadata() {
		return this.metadata;
	}

}
