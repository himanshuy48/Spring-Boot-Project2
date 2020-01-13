package com.digi.uniprr.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.model.PaymentDetails;
import com.digi.uniprr.model.User;
import com.digi.uniprr.model.UserInvoice;
import com.digi.uniprr.repository.UserInvoiceRepo;
import com.digi.uniprr.repository.UserRepo;
import com.digi.uniprr.service.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;

@Service
public class PaymentServiceImpl implements PaymentService {

	
	@Autowired
	UserInvoiceRepo userInvoiceRepo;
	
	@Autowired
	UserRepo userRepo;
	
	 @Autowired
	 PaymentServiceImpl() {
	        Stripe.apiKey = "sk_test_NvfTwI4uxYLFf7VEGf0Mtwn600RLfG6dZc";
	    }
	
	@Override
	public Customer createCustomer(String token, String email) throws StripeException {

        Map<String, Object> customerParams = new HashMap<String, Object>();
        customerParams.put("email", email);
        //customerParams.put("description", "test");
        return Customer.create(customerParams);
    
	}

	@Override
	public Charge chargeNewCard(double amount, String token) throws StripeException {

        Map<String, Object> chargeParams = new HashMap<String, Object>();
        List<Map<String, Object>> chargeDetails=null;		
        chargeParams.put("amount", (int)(amount));
        chargeParams.put("currency", "USD");
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        
        return charge;
    
	}

	@Override
	public void saveDataInDb(Charge chargeDetails, PaymentDetails data) {
		UserInvoice userInvoice = new UserInvoice();
		User user = userRepo.findByEmail(data.getEmail());
		userInvoice.setManuscriptId(data.getMauscriptId());
		userInvoice.setTransactionId(chargeDetails.getId());
		userInvoice.setUserId(user.getId());
		userInvoice.setTransactionStatus(chargeDetails.getStatus());
		userInvoice.setAmount(chargeDetails.getAmount());
		userInvoiceRepo.save(userInvoice);
	}

	@Override
	public UserInvoice getPaymentDetail(ManuscriptListVO manuscriptListVO) {
		UserInvoice userInvoice = userInvoiceRepo.getPaymentDetailByUser(manuscriptListVO.getManuScriptId(), manuscriptListVO.getUserId());
		return userInvoice;
	}

}
