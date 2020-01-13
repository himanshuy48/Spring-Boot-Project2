package com.digi.uniprr.service;

import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.model.PaymentDetails;
import com.digi.uniprr.model.UserInvoice;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;

public interface PaymentService {
	
	public Customer createCustomer(String token, String email) throws StripeException;

	public Charge chargeNewCard(double amount, String token) throws StripeException;
	
	public void saveDataInDb(Charge chargeDetails, PaymentDetails data);
	
	public UserInvoice getPaymentDetail(ManuscriptListVO manuscriptListVO); 
	
	
}
