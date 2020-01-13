package com.digi.uniprr.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digi.uniprr.VO.ManuscriptListVO;
import com.digi.uniprr.model.PaymentDetails;
import com.digi.uniprr.model.UserInvoice;
import com.digi.uniprr.service.PaymentService;
import com.stripe.model.Charge;
import com.stripe.model.Customer;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/payment")
public class Payment {

	@Autowired
	private PaymentService paymentService;

	JSONObject obj = new JSONObject();

	@RequestMapping(path = "/makePayment", method = RequestMethod.POST)
	public ResponseEntity<?> payment(@RequestBody PaymentDetails data) throws Exception {
		Customer customer = paymentService.createCustomer(data.getToken(), data.getEmail());
		Charge chargeDetails = paymentService.chargeNewCard(data.getAmount(), data.getToken());
		System.out.println(chargeDetails.getPaymentMethod());
		try {
			paymentService.saveDataInDb(chargeDetails, data);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		obj.put("status", chargeDetails.getStatus());
		obj.put("Transaction_id", chargeDetails.getId());
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
	
	@PostMapping("getPaymentDetail")
	public ResponseEntity<?> getPaymentDetail(@RequestBody ManuscriptListVO manuscriptListVO){
		try {
			UserInvoice userInvoice = paymentService.getPaymentDetail(manuscriptListVO);
			if(userInvoice != null) {
				obj.put("data", userInvoice);
			}else {
				obj.put("data", "data not found");
			}
		}catch(Exception e) {
			System.out.println(e);
			obj.put("data", "Something went wrong");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}
